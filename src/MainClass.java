import java.util.Scanner;

public class MainClass {
    private static final String START_MESSAGE = "Для выбора задания №1 введите в консоль 1" +
            ", для выбора задания №2, введите в консоль 2 и для выхода из программы введите 3";
    private static final String BAD_REQUEST_MESSAGE = "Такой команды нет";

    public static void main(String[] args) {
        CountOfIsland taskOne = new CountOfIsland();
        SpiralArrayOut taskTwo = new SpiralArrayOut();

        Scanner commandScanner = new Scanner(System.in);

        System.out.println(START_MESSAGE);

        while(commandScanner.hasNextInt()){
            int command = commandScanner.nextInt();
            if(command == 3){
              break;
            }
            switch (command){
                case 1 : {
                    taskOne.startMethod();
                    break;
                }
                case 2 : {
                    taskTwo.startMethod();
                    break;
                }
                default: {
                    System.out.println(BAD_REQUEST_MESSAGE);
                    break;
                }
            }
        }
    }
}
