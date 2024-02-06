package anbu;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class AnbuLoadBalancer {
    public static void main(String[] args) {

        int NUM_OF_REQUESTS = 15;
        AnbuLoadBalancer client = new AnbuLoadBalancer();

        ArrayList <String> ipPool = new ArrayList <>();
        ipPool.add("192.168.0.1");
        ipPool.add("192.168.0.2");
        ipPool.add("192.168.0.3");
        ipPool.add("192.168.0.4");
        ipPool.add("192.168.0.5");

        Map <String, Integer> ipPoolWeighted = new HashMap<>();
        ipPoolWeighted.put("192.168.0.1",  6);
        ipPoolWeighted.put("192.168.0.2",  6);
        ipPoolWeighted.put("192.168.0.3",  3);

        client.printNextTurn("Random");
        LoadBalancer random = new RandomLoadBalancer(ipPool);
        client.simulateConcurrentClientRequest(random, NUM_OF_REQUESTS);

        client.printNextTurn("Round-Robin");
        LoadBalancer roundRobbin = new RoundRobinLoadBalancer(ipPool);
        client.simulateConcurrentClientRequest(roundRobbin, NUM_OF_REQUESTS);

        client.printNextTurn("Weighted-Round-Robin");
        LoadBalancer weightedRoundRobin = new WeightedRoundRobinLoadBalancer(ipPoolWeighted);
        client.simulateConcurrentClientRequest(weightedRoundRobin, NUM_OF_REQUESTS);

        System.out.println("Main exits");

    }

    private void simulateConcurrentClientRequest(LoadBalancer loadBalancer, int numOfCalls) {

        IntStream.range(0, numOfCalls)
                .parallel()
                .forEach(i ->
                        System.out.println(
                                "IP: " + loadBalancer.getIp()
                                        + " --- Request from Client: " + i
                                        + " --- [Thread: " + Thread.currentThread().getName() + "]")
                );
    }

    private void printNextTurn(String name) {
        System.out.println("---");
        System.out.println("Clients starts to send requests to " + name + " Load Balancer");
        System.out.println("---");
    }
}

 abstract class LoadBalancer {
    final List<String> ipList;

    public LoadBalancer(List <String> ipList) {
        this.ipList = Collections.unmodifiableList(ipList);
    }
    abstract String getIp();
}


 class RandomLoadBalancer extends LoadBalancer {

    public RandomLoadBalancer(List <String> ipList) {
        super(ipList);
    }

    @Override
    public String getIp() {
        Random random = new Random();
        return ipList.get(random.nextInt(ipList.size()));
    }
}

class RoundRobinLoadBalancer extends LoadBalancer {

    private int counter = 0;
    private final ReentrantLock lock;

    public RoundRobinLoadBalancer(List <String> list) {
        super(list);
        lock = new ReentrantLock();
    }

    @Override
    public String getIp() {
        lock.lock();
        try {
            String ip = ipList.get(counter);
            counter += 1;
            if (counter == ipList.size()) {
                counter = 0;
            }
            return ip;
        } finally {
            lock.unlock();
        }
    }
}

 class WeightedRoundRobinLoadBalancer extends RoundRobinLoadBalancer {
    public WeightedRoundRobinLoadBalancer(Map<String, Integer> ipMap) {
        super(
                ipMap.keySet()
                        .stream()
                        .map(ip -> {
                            List<String> tempList =  new LinkedList<>();
                            for (int i=0; i<ipMap.get(ip); i++) {
                                tempList.add(ip);
                            }
                            return tempList;
                        })
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList())
        );
    }
}