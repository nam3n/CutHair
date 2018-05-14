package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int xP = 0, yP = 3;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if ((i == xP) && (j == yP)) System.out.print('P');
                else System.out.print('*');
            }
            System.out.println();
        }
        while (true) {
            String a = scanner.next();
            switch (a) {
                case "a":
                    if (yP > 0) yP--;
                    else System.out.println("Can't move");
                    break;
                case "s":
                    if (xP < 3) xP++;
                    else System.out.println("Can't move");
                    break;
                case "d":
                    if (yP < 3) yP++;
                    else System.out.println("Can't move");
                    break;
                case "w":
                    if (xP > 0) xP--;
                    else System.out.println("Can't move");
                    break;
                case "x":
                    return;
            }
            ;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if ((i == xP) && (j == yP)) System.out.print('P');
                    else System.out.print('*');
                }
                System.out.println();
            }
        }
    }
}
