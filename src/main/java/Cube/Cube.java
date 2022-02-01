package Cube;


//@FunctionalInterface
public class Cube {

    private Cube cube;
    private int moveCount;
    private int[][] front;
    private int[][] back;
    private int[][] up;
    private int[][] down;
    private int[][] right;
    private int[][] left;

    public Cube(){
        this.moveCount = 0;
    }

    public void setMoveCount(int count){
        this.moveCount = count;
    }

    public void addMoveCount(int count){
        this.moveCount += count;
    }

    public int getMoveCount(){
        return moveCount;
    }

    public Cube getCube() {
        return cube;
    }

    public void setCube(Cube cube) {
        this.cube = cube;
    }

    private void setFront(int cp,int ep){
        this.front = new int[cp][ep];
    }

}
