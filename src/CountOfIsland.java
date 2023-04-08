import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountOfIsland {
    private static final List<Integer[]> mapList = new ArrayList<>();
    private static final String START_MESSAGE = "Введите карту и нажмите клавишу Enter два раза.";
    private static final String COUNT_OF_ISLAND_IS = "Количество островов в карте равно: ";

    public void startMethod() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(START_MESSAGE);
        System.out.println();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            mapList.add(parseLine(line));
        }
        System.out.println(COUNT_OF_ISLAND_IS + findCountIsland(listToArray(mapList)));
    }

    private static Integer[] parseLine(String line) {
        char[] chars = line.toCharArray();
        Integer[] parsedLine = new Integer[line.length()];
        for (int count = 0; count < chars.length; count++) {
            parsedLine[count] = Integer.parseInt(String.valueOf(chars[count]));
        }
        return parsedLine;
    }

    private static Integer[][] listToArray(List<Integer[]> mapList) {
        int numOfRow = 0;
        Integer[][] map = new Integer[mapList.size()][mapList.get(0).length];
        for (Integer[] row : mapList) {
            map[numOfRow] = row;
            numOfRow++;
        }
        return map;
    }

    private static int findCountIsland(Integer[][] map) {
        int countOfIsland = 0;

        for (int a = 0; a < map.length; a++) {
            for (int b = 0; b < map[a].length; b++) {
                if (map[a][b] == 1) {
                    countOfIsland++;
                    markTheElement(map, a, b);
                }
            }
        }
        return countOfIsland;
    }

    private static void markTheElement(Integer[][] map, int a, int b) {
        if (a < 0 || b < 0 || a >= map.length || b >= map[a].length || map[a][b] == 0)
            return;
        map[a][b] = 0;
        markTheElement(map, a, b + 1);
        markTheElement(map, a, b - 1);
        markTheElement(map, a + 1, b);
        markTheElement(map, a - 1, b);
    }
}
