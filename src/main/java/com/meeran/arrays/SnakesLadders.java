package com.meeran.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class SnakesLadders {
	private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Ladder> laddAndSlop = new ArrayList<>();
    private boolean isPlay;

    public SnakesLadders() {
        laddAndSlop.add(new Ladder(2,38));
        laddAndSlop.add(new Ladder(7,14));
        laddAndSlop.add(new Ladder(8,31));
        laddAndSlop.add(new Ladder(7,14));
        laddAndSlop.add(new Ladder(8,31));
        laddAndSlop.add(new Ladder(15,26));
        laddAndSlop.add(new Ladder(21,42));
        laddAndSlop.add(new Ladder(28,84));
        laddAndSlop.add(new Ladder(36,44));
        laddAndSlop.add(new Ladder(51,67));
        laddAndSlop.add(new Ladder(71,91));
        laddAndSlop.add(new Ladder(78,98));
        laddAndSlop.add(new Ladder(87,94));
        laddAndSlop.add(new Slope(16,6));
        laddAndSlop.add(new Slope(46,25));
        laddAndSlop.add(new Slope(49,11));
        laddAndSlop.add(new Slope(62,19));
        laddAndSlop.add(new Slope(64,60));
        laddAndSlop.add(new Slope(74,53));
        laddAndSlop.add(new Slope(89,68));
        laddAndSlop.add(new Slope(92,88));
        laddAndSlop.add(new Slope(95,75));
        laddAndSlop.add(new Slope(99,80));
        players.add(new Player(1, true));
        players.add(new Player(2));
        isPlay = false;
    }

    class Ladder {
        private int startX, endX;
        public Ladder(int startX, int endX) {
            this.startX = startX;
            this.endX = endX;
        }
    }

    class Slope extends Ladder {
        public Slope(int startX, int endX) {
            super(startX, endX);
        }
    }

    class Player {
        private int id, x;
        private boolean isWinner, isCurrentTurn;
        public Player(int id) {
            this.id = id;
        }
        public Player(int id, boolean isCurrentTurn) {
            this.id = id;
            this.isCurrentTurn = isCurrentTurn;
        }
    }

    private String currentState(Player p) {
        if (p.x == 100 && !isPlay) {
            p.isWinner = true;
            isPlay = true;
            return String.format("Player %d Wins!", p.id);
        } else {
            if (isPlay) {
                return ("Game over!");
            }
            return String.format("Player %d is on square %d", p.id, p.x);
        }
    }

    private void checkPosition(Player p) {
        laddAndSlop.forEach(m -> {
            if (m.startX == p.x) {
                p.x = m.endX;
            }
        });
    }

    public String play(int die1, int die2) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).isCurrentTurn) {
                players.get(i).x += die1 + die2;

                if (players.get(i).x > 100) {
                    players.get(i).x = 100 - (players.get(i).x - 100);
                }

                checkPosition(players.get(i));

                if (die1 != die2) {
                    players.get(i).isCurrentTurn = false;

                    if (i != players.size() - 1) {
                        players.get(i + 1).isCurrentTurn = true;
                    } else {
                        players.get(0).isCurrentTurn = true;
                    }
                }
                return currentState(players.get(i));
            }
        }
        return null;
    }
    
    @Test
    public void randomTests() {
        for (int runs = 1; runs < 6; runs++) {
            SnakesLadders  game     = new SnakesLadders();
            SnakesLadders2 solution = new SnakesLadders2();
            for (int moves = 1; moves < 51; moves++) {
                int x = (int)(Math.random() * 6) + 1,
                    y = (int)(Math.random() * 6) + 1;
                String expected = solution.play(x, y),
                       actual   = game.play(x, y);
                System.out.format("Game #%d move #%d {%d, %d}: %s\n",
                                  runs, moves, x, y, actual);
                assertEquals(expected, actual);
                if ( actual.equals("Game over!") )
                    break;
            }
        }
    }
    private class SnakesLadders2 {
        public SnakesLadders2() {}
        public String play(int die1, int die2) {
            if ( won )
                return "Game over!";
            int roll = die1 + die2;
            if ( roll + playerSquare[player] <= 100 ) {
                playerSquare[player] += roll;
                if ( playerSquare[player] == 100 ) {
                    won = true;
                    return String.format("Player %d Wins!", player + 1);
                }
            }
            else
                playerSquare[player] = 100 - ((playerSquare[player] + roll) - 100);
            for (int i = 0; i < trap.length; i++)
                if ( playerSquare[player] == trap[i][0] )
                    playerSquare[player] = trap[i][1];
            String message = String.format("Player %d is on square %d", player + 1, playerSquare[player]);
            if ( die1 != die2 )
                player = 0 == player ? 1 : 0;
            return message;
        }
        private int[]         playerSquare = new int[]{0, 0};
        private int           player       = 0;
        private boolean       won          = false;
        private final int[][] trap         = new int[][]{
                                                new int[]{ 2,38}, new int[]{ 7,14}, new int[]{ 8,31},
                                                new int[]{15,26}, new int[]{21,42}, new int[]{28,84},
                                                new int[]{36,44}, new int[]{51,67}, new int[]{71,91},
                                                new int[]{78,98}, new int[]{87,94}, new int[]{16,6 },
                                                new int[]{46,25}, new int[]{49,11}, new int[]{62,19},
                                                new int[]{64,60}, new int[]{74,53}, new int[]{89,68},
                                                new int[]{92,88}, new int[]{95,75}, new int[]{99,80}};
    }
}
