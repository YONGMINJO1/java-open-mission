import calculator.CalculatorApplication;
import camp.nextstep.edu.missionutils.Console;
import lotto.LottoApplication;
import racing.RacingApplication;
import yacht.YachtApplication;

public class MainApplication {
    public static final String MENU_HEADER = "\n=== 우테코 프리코스 미션 ===";
    public static final String MENU_CALCULATOR = "1. 문자열 계산기";
    public static final String MENU_RACING = "2. 자동차 경주";
    public static final String MENU_LOTTO = "3. 로또";
    public static final String MENU_YACHT = "4. 요트 다이스";
    public static final String MENU_EXIT = "0. 종료";
    public static final String INPUT_MENU = "실행할 미션을 선택하세요: ";
    public static final String INVALID_MENU = "잘못된 선택입니다. 다시 선택해주세요.";
    public static final String EXIT_MESSAGE = "프로그램을 종료합니다.";

    public static void main(String[] args) {
        MainApplication app = new MainApplication();
        app.run();
    }

    public void run() {
        while (true) {
            printMenu();
            String choice = readChoice();

            if (choice.equals("0")) {
                System.out.println(EXIT_MESSAGE);
                break;
            }

            executeChoice(choice);
        }
    }

    private void printMenu() {
        System.out.println(MENU_HEADER);
        System.out.println(MENU_CALCULATOR);
        System.out.println(MENU_RACING);
        System.out.println(MENU_LOTTO);
        System.out.println(MENU_YACHT);
        System.out.println(MENU_EXIT);
        System.out.print(INPUT_MENU);
    }

    private String readChoice() {
        return Console.readLine();
    }

    private void executeChoice(String choice) {
        if (choice.equals("1")) {
            CalculatorApplication.main(new String[]{});
            return;
        }
        if (choice.equals("2")) {
            RacingApplication.main(new String[]{});
            return;
        }
        if (choice.equals("3")) {
            LottoApplication.main(new String[]{});
            return;
        }
        if (choice.equals("4")) {
            YachtApplication.main(new String[]{});
            return;
        }
        System.out.println(INVALID_MENU);
    }
}
