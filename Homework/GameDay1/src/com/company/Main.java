package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int xP = 0, yP = 3;
        int xE1, xE2, yE1, yE2;
        Random random = new Random();
        while (true) {
            xE1 = random.nextInt(4);
            yE1 = random.nextInt(4);
            if ((xE1 != xP) || (yE1 != yP)) break;
        }
        while (true) {
            xE2 = random.nextInt(4);
            yE2 = random.nextInt(4);
            if (((xE2 != xP) || (yE2 != yP)) && ((xE2 != xE1) || (yE2 != yE1))) break;
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (((i == xE1) && (j == yE1)) || ((i == xE2) && (j == yE2)))
                    System.out.print('E');
                else if ((i == xP) && (j == yP))
                    System.out.print('P');
                else
                    System.out.print('*');
            }
            System.out.println();
        }
        while (true) {
            String  a = scanner.next();
            switch (a) {
                case "a":
                    if (yP > 0) yP--;
                    else yP = 3;
                    break;
                case "s":
                    if (xP < 3) xP++;
                    else xP = 0;
                    break;
                case "d":
                    if (yP < 3) yP++;
                    else yP = 0;
                    break;
                case "w":
                    if (xP > 0) xP--;
                    else xP = 3;
                    break;
                case "x":
                    System.out.print("Exited!");
                    return;
            }
            yE1 = (yE1 + 1) % 4;
            xE2 = (xE2 + 1) % 4;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (((i == xE1) && (j == yE1)) || ((i == xE2) && (j == yE2)))
                        System.out.print('E');
                    else if ((i == xP) && (j == yP))
                        System.out.print('P');
                    else
                        System.out.print('*');
                }
                System.out.println();
            }
            if (((xP == xE1) && (yP == yE1)) || ((xP == xE2) && (yP == yE2))) {
                System.out.print("Game over!");
                return;
            }
        }
    }
}
