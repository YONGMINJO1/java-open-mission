package yacht.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static void throwDice() {
        System.out.println();
        System.out.println("주사위를 굴리려면 Enter를 눌러주세요.");
        Console.readLine();
    }

    public static int readCategoryNumber() {
        System.out.println();
        System.out.print("선택할 카테고리 번호를 입력하세요: ");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
