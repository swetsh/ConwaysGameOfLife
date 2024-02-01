package org.swiggy;

import java.util.Scanner;

public class GameLog {
    private final Scanner scanner;
    private int m;
    private int n;
    private double s;

    public GameLog() {
        scanner = new Scanner(System.in);
        System.out.println("Welcome to the Conway's Game of Life");
    }

    public Board contructBoard() {

        System.out.print("Enter board height: ");
        this.m = scanner.nextInt();
        System.out.print("Enter board width: ");
        this.n = scanner.nextInt();
        System.out.print("Enter seed Value: ");
        this.s = scanner.nextDouble();
        return new Board(this.m, this.n, this.s);
    }

}