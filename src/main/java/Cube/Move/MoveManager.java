package Cube.Move;

public class MoveManager {


    public static Object Move(int moveNum, Object cube){
        Object returnCube;
        switch (moveNum){
            case 0: //right
                returnCube = Move.Move(cube,cube);
                break;
            case 1: //left
                break;
            case 2: //top
                break;
            case 3: //bottom
                break;
            case 4: //front
                break;
            case 5: //back
                break;
            case 6: //middle
                break;
        }
        return cube;
    }

}
