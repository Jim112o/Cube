package Cube;

public class VirtualCube extends Cube{

    static Cube VirtualCube_1;
    static Cube VirtualCube_2;

    public void CreateVirtualCube(Cube RealCube){
        VirtualCube_1 = RealCube;
    }

    public void CopyVirtualCube(Cube Cube){
        VirtualCube_2 = Cube;
    }

    public Cube getVirtualCube(){
        return VirtualCube_1;
    }

    public int getMoveCount(){
        return VirtualCube_1.getMoveCount();
    }


}
