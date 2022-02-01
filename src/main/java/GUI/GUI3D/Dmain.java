package GUI.GUI3D;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Dmain extends Application{

    @Override
    public void start(Stage primaryStage) {

        Box box = createCube(); // element
        //Box box2 = createCube2();
        Group root = new Group(); //layout
        root.getChildren().add(box);
        //root.getChildren().add(box2);

        PerspectiveCamera camera = new PerspectiveCamera();

        Scene scene = new Scene(root, 850, 650); //show scene
        scene.setCamera(camera);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    Box createCube(){
        Box box = new Box();
        box.setWidth(300); //x size
        box.setHeight(300); // y size
        box.setDepth(300);// z size

        //表示位置
        box.setTranslateX(105);
        box.setTranslateY(10);
        box.setTranslateZ(0);

        PhongMaterial mat = new PhongMaterial();
        mat.setSpecularColor(Color.BLACK);
        mat.setDiffuseColor(Color.RED);

        box.setMaterial(mat);

        Rotate xRotation = new Rotate(0, Rotate.X_AXIS);
        Rotate yRotation = new Rotate(0, Rotate.Y_AXIS);
        box.getTransforms().addAll(xRotation, yRotation);

        RotateTransition rt = new RotateTransition(Duration.millis(10000), box);
        rt.setAxis(Rotate.Y_AXIS);
        rt.setByAngle(720);
        rt.setCycleCount(1);
        rt.play();
        return box;
    }

    Box createCube2(){

        Box box2 = new Box();
        box2.setWidth(30); //x size
        box2.setHeight(30); // y size
        box2.setDepth(30);// z size

        //表示位置
        box2.setTranslateX(450);
        box2.setTranslateY(30);
        box2.setTranslateZ(0);

        PhongMaterial mat2 = new PhongMaterial();
        mat2.setSpecularColor(Color.BLACK);
        mat2.setDiffuseColor(Color.ORANGE);

        box2.setMaterial(mat2);

        Rotate xRotation2 = new Rotate(0, Rotate.X_AXIS);
        Rotate yRotation2 = new Rotate(0, Rotate.Y_AXIS);
        box2.getTransforms().addAll(xRotation2, yRotation2);

        RotateTransition rt2 = new RotateTransition(Duration.millis(10000), box2);
        rt2.setAxis(Rotate.Y_AXIS);
        rt2.setByAngle(720);
        rt2.setCycleCount(1);
        rt2.play();
        return box2;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
