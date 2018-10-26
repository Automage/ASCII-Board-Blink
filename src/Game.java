import java.util.Random;

public class Game {

    private static char map[][] = new char[10][10];
    public static boolean shouldTerminate = false;

    public static boolean getShouldTerminate() {
        return shouldTerminate;
    }

    public static void setShouldTerminate(boolean shoulTerminate) {
        shouldTerminate = shoulTerminate;
    }

    public void initializeMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = 'X';
            }
        }
        updateDisplay();
    }

    private static void updateDisplay() {
        Display.update(map);
    }

    public void placeMove(int x, int y) {
        map[x][y] = 'O';
        updateDisplay();
    }

    public static void rand() {
        Random rand = new Random();
        map[rand.nextInt(10)][rand.nextInt(10)] = '#';
        updateDisplay();
    }



}
