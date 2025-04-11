package autoclicker;

import java.awt.*;
import java.awt.event.InputEvent;

public class AutoClicker {
    private int interval;
    private int duration;
    private int x;
    private int y;
    private boolean singleClick;
    private boolean running;

    public AutoClicker(int interval, int duration, int x, int y, String clickType) {
        this.interval = interval;
        this.duration = duration;
        this.x = x;
        this.y = y;
        this.singleClick = clickType.equals("Single Click");
    }

    public void start() {
        running = true;
        new Thread(() -> {
            long endTime = System.currentTimeMillis() + duration;
            try {
                Robot robot = new Robot();
                while (running && System.currentTimeMillis() < endTime) {
                    robot.mouseMove(x, y);
                    if (singleClick) {
                        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                    } else {
                        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                    }
                    Thread.sleep(interval);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void stop() {
        running = false;
    }
}
