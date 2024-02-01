package org.swiggy;

public class GameEntryPoint {
    private final Board board;

    public GameEntryPoint() {
        GameLog gameLog = new GameLog();
        this.board = gameLog.contructBoard();
    }

    void start() throws InterruptedException {
        int loopCount = 100;
        do{
            System.out.println(board);
            board.evolve();
            Thread.sleep(1000);
        }while (loopCount-- > 0);
    }
    public static void main(String[] args) throws InterruptedException {
        GameEntryPoint gameEntryPoint = new GameEntryPoint();
        gameEntryPoint.start();
    }
}
