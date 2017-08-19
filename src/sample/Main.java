package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class Main extends Application {

  /*  @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

*/
    double angle=0.0;
    double glowVal=0.0;
    boolean shadow=false;
    double scaleFactor=1.0;

    Glow glow= new Glow(0.0);
    InnerShadow innerShadow= new InnerShadow(10.0, Color.RED);
    Rotate rotate= new Rotate();
    Scale scale= new Scale(scaleFactor,scaleFactor);

    Button btnRotate =new Button("Rotate");
    Button btnGlow= new Button("Glow");
    Button btnScale = new Button("Scale");
    Button btnInnerShadow =new Button("InnerShadow");


    public void start(Stage myStage)
    {
        myStage.setTitle("Effects and Transformation Demo");
        final FlowPane rootNode= new FlowPane(10,10);
        rootNode.setAlignment(Pos.CENTER);
        final Scene scene = new Scene(rootNode,300,300);
        myStage.setScene(scene);

        btnGlow.setEffect(glow);
        btnRotate.getTransforms().add(rotate);
        btnScale.getTransforms().add(scale);

        btnRotate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                angle+=30.0;
                rotate.setAngle(angle);
                rotate.setPivotX(btnRotate.getWidth()/2);
                rotate.setPivotY(btnRotate.getWidth()/2);
            }
        });
        btnScale.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scaleFactor+=0.1;
                if (scaleFactor>1.0)
                    scaleFactor=0.5;
                scale.setX(scaleFactor);
                scale.setY(scaleFactor);
            }
        });

        btnGlow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                glowVal+=0.1;
                if (glowVal>1.0)
                    glowVal=0.0;
                glow.setLevel(glowVal);
            }
        });

        btnInnerShadow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                shadow=!shadow;
                if (shadow)
                {
                    btnInnerShadow.setEffect(innerShadow);
                    btnInnerShadow.setText("Shadow On");
                }
                else
                {
                    btnInnerShadow.setEffect(null);
                    btnInnerShadow.setText("Shadow Off");
                }
            }
        });

        rootNode.getChildren().addAll(btnRotate,btnScale,btnGlow,btnInnerShadow);
        myStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
