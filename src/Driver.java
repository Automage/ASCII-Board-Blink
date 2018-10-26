import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String in = "";

        Game g = new Game();
        Display display = new Display();

        g.initializeMap();
        Thread displayThread = new Thread(display);

        displayThread.start();
        while (!Game.getShouldTerminate()) {
            in = s.next();
            if (in.equals("q")) {
                Game.setShouldTerminate(true);
            } else {
                try {
                    g.placeMove(Integer.parseInt(in.charAt(0) + ""), Integer.parseInt(in.charAt(1) + ""));
                } catch (StringIndexOutOfBoundsException str) {

                }
            }
        }

    }
}
