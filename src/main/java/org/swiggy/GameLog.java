package org.swiggy;

import java.util.Scanner;

public class GameLog {
    private final Scanner scanner;

    public GameLog() {
        scanner = new Scanner(System.in);
        System.out.println("Welcome to the Conway's Game of Life");
    }

    public Board contructBoard() {
        System.out.print("Enter board height: ");
        int m = scanner.nextInt();
        System.out.print("Enter board width: ");
        int n = scanner.nextInt();
        System.out.print("Enter seed Value: ");
        double s = scanner.nextDouble();
        return new Board(m, n, s);
    }

}