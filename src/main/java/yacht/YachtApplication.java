package yacht;

import yacht.controller.YachtGameController;

public class YachtApplication {
    public static void main(String[] args) {
        YachtGameController controller = new YachtGameController();
        controller.run();
    }
}
