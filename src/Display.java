
public class Display implements Runnable {

    private static char map[][] = new char[10][10];
    private static char blinkMap[][] = new char[10][10];
    //private static List<Character[]> blinkBuffer = new ArrayList<>(); //3 values [0]=x, [1]=y, [2]=char
    private static boolean shouldBlink = false; //True -> turn invisible, false -> turn visible

    public static void print(char[][] inMap) {
        for (int i = 0; i < inMap.length; i++) {
            for (int j = 0; j < inMap[i].length; j++) {
                System.out.print(" " + inMap[i][j]);
            }
            System.out.println();
        }
    }

    public static synchronized void update(char[][] inMap) {

        for (int i = 0; i < inMap.length; i++) {
            for (int j = 0; j < inMap[i].length; j++) {
                map[i][j] = inMap[i][j];
                blinkMap[i][j] = inMap[i][j];
            }
        }

        initializeBlinkMap();
        //shouldBlink = false;
    }

    private static void initializeBlinkMap() {

        for (int i = 0; i < blinkMap.length; i++) {
            for (int j = 0; j < blinkMap[i].length; j++) {
                if (blinkMap[i][j] != 'X' && blinkMap[i][j] != ' ') {

                    blinkMap[i][j] = ' ';

                }
            }
        }

    }


    public void run() {
        String ESC = "\033[";
        while (!Game.getShouldTerminate()) {
            System.out.print(ESC + "2J");

            Game.rand();

            if (shouldBlink) { //Turn invisible
                shouldBlink = false; //for next blink event
                print(blinkMap);
            } else { //Turn visible
                shouldBlink = true; //for next blink event
                print(map);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\n");
        }

    }

}
