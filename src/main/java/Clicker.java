

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Clicker {
    public static boolean clicking = true;
    public static int amountclicked = 0;
    public static int rate = 0;
    public static int rate1 = 0;

    public static void main(String[] args) {
        while (rate1 == 0) {
            try {
                System.out.println("How many clicks are you wanting to do?:");
                BufferedReader xyz = new BufferedReader(new InputStreamReader(System.in));
                try {
                    rate1 = Integer.parseInt(xyz.readLine());
                    if (rate1 == 0) {
                        rate1 = 0;
                        System.out.println("Must be at least 1 click.");
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Error - please try again.");
                }
            } catch (IOException e) {
            }
        }

        while (rate == 0) {
            try {
                System.out.println("Max speed of the autoclicker?: (in miliseconds):");
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                try {
                    rate = Integer.parseInt(in.readLine());
                    if (rate < 500) {
                        rate = 0;
                        System.out.println("Must be at least 500 miliseconds.");
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Error - please try again.");
                }
            } catch (IOException e) {
            }
        }

        try {
            System.out.println("*!*!*!*! PLEASE MOVE YOUR MOUSE INTO POSITION! !*!*!*!*");
            System.out.println("*!*!*!*! MOVE MOUSE TO END AUTOCLICK! !*!*!*!*");
            System.out.println("*!*!*!*! Sleeping for 10 seconds !*!*!*!*");

            Thread.sleep(10000);

            Point p = MouseInfo.getPointerInfo().getLocation();
            System.out.println("Current Mouse Location: "+p);

            Robot robot = new Robot();
            while (clicking == true) {
                Point z = MouseInfo.getPointerInfo().getLocation();
                System.out.println("Current Mouse Location: "+z);
                int randomNum =  (new Random()).nextInt(rate+1);
//                            ThreadLocalRandom.current().nextInt(15000, rate + 1);
                System.out.println("Current Rate: " + randomNum);
//                robot.mousePress(InputEvent.BUTTON1_MASK);
//                robot.keyPress(KeyEvent.VK_WINDOWS);
                robot.keyPress(KeyEvent.VK_E);
                Thread.sleep(50);
                robot.keyRelease(KeyEvent.VK_E);
//                robot.keyRelease(KeyEvent.VK_WINDOWS);
//                robot.mouseRelease(InputEvent.BUTTON1_MASK);
                amountclicked++;
                System.out.println("Amount Clicked So Far: " + amountclicked);

                if (Math.round(z.getX()+z.getY()) != Math.round(p.getX()+p.getY())) {
                    System.out.println("MOUSE MOVED!: "+z);
                    clicking = false;
                }

                if (amountclicked == rate1) {
                    clicking = false;
                }
            }
        } catch (AWTException e) {
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
            }
}
