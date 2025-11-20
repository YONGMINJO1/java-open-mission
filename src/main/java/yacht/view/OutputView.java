package yacht.view;

import java.util.List;
import yacht.domain.Category;

public class OutputView {

    public static void printGameStart() {
        System.out.println("게임을 시작합니다.");
    }

    public static void printRerollCancel() {
        System.out.println("재굴림을 취소합니다.");
    }

    public static void printRerollStart() {
        System.out.println();
        System.out.println("주사위를 다시 굴립니다.");
    }

    public static void printDices(List<Integer> values) {
        System.out.println();
        System.out.println("주사위를 굴립니다.");

        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < values.size(); i++) {
            if (i > 0) {
                result.append(", ");
            }
            result.append("🎲" + (i + 1) + "번 주사위 : " + values.get(i));
        }
        result.append("]");
        System.out.println(result.toString());
    }

    public static void printCategories(List<Category> categories) {
        System.out.println();
        System.out.println("선택 가능한 카테고리: ");

        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ", " + categories.get(i).getName());
        }
    }

    public static void printScore(Category category, int score) {
        System.out.println();
        System.out.println(category.getName() + ": " + score + "점이 기록되었습니다.");
    }

    public static void printFinalScore(int totalScore) {
        System.out.println();
        System.out.println("게임이 종료되었습니다.");
        System.out.println("최종 점수: " + totalScore + "점");
    }
}
