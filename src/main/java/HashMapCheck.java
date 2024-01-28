import java.util.HashMap;

public class HashMapCheck {

    public static void main(String[] args) {

        System.out.println("main");

        HashMap<String , CusObject[]> map = new HashMap<String, CusObject[]>();
        CusObject cus1 = new CusObject();
        CusObject cus2 = new CusObject();
        map.put("anbu" , new CusObject[]{cus1,cus2});
        if(null != map && map.size() >0 ) {


            for (CusObject cusEach : map.get("")) {
                System.out.println("hai");
            }

        }
    }
}


class CusObject {


}


