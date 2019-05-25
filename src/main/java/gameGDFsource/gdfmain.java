package gameGDFsource;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

import java.awt.*;
import java.util.Stack;


public class gdfmain extends Application {//zawsze extends Application, by zastosowac javafx

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;

    Image buttonSelected = new Image("ballSelected.png");

    Image imageBackgroundPrimaryStage = new Image("tlo.jpg");
    //Image newGameBackgroundImageFile = new Image("tloNewGame.jpg");

    public static void main(String[] args) {
        launch(args);//metoda w klasie Application,
    }



    @Override //start powoduje, ze launch wchodzi w Application, wszystko przygotowuje i odpala start
    public void start(Stage primaryStage) throws Exception {//nasz glowny kod w javafx
        //grafika dla primaryStage
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageBackgroundPrimaryStage, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        button1 = new Button();
        button1.setText("New Game");
        //button1.setOnAction(event -> primaryStage.setScene(scene2));


        button2 = new Button();
        button2.setText("Load Game");

        button3 = new Button();
        button3.setText("High Score");

        button4 = new Button();
        button4.setText("Turtorial");

        button5 = new Button();
        button5.setText("Exit");

        //tutaj ustawiam sobie buttony PrimaryStage, ich pozycje
        GridPane.setRowIndex(button1, 0);
        GridPane.setColumnIndex(button1, 1);
        GridPane.setRowIndex(button2, 1);
        GridPane.setColumnIndex(button2, 1);
        GridPane.setRowIndex(button3, 2);
        GridPane.setColumnIndex(button3, 1);
        GridPane.setRowIndex(button4, 3);
        GridPane.setColumnIndex(button4, 1);
        GridPane.setRowIndex(button5, 4);
        GridPane.setColumnIndex(button5, 1);

        GridPane gridPrimaryStage = new GridPane();
        gridPrimaryStage.setBackground(background);

        button4.setOnAction(e -> {
            Turtorial turtoriaWindow = new Turtorial();
            turtoriaWindow.turtorialWinMeth("Turtorial",
                    "\n" + "   New Game = starting a new game  " + "\n" +
                            "   Load Game = continue youre previous game    " + "\n" +
                            "   High Score = see your biggest score yet!    " + "\n" +
                            "   GDF - Great Defense Force - is a penalty kicker simulation. " +
                            "Simply select a desired spot and hope for the best! " + "\n");
        });

        /*Turtorial.turtorialWinMeth("Turtorial",
                "\n" + "   New Game = starting a new game  " + "\n" +
                        "   Load Game = continue youre previous game    " + "\n" +
                        "   High Score = see your biggest score yet!    " + "\n" +
                        "   GDF - Great Defense Force - is a penalty kicker simulation. Simply select a desired spot and hope for the best! " + "\n"));*/
        //usowa mi z grida, ktory mi wyswietla elementy

        button1.setOnAction(event -> {
           // gridPrimaryStage.getChildren().removeAll(button1, button2, button3, button4);
            Game game = new Game();
            game.newGame();
        });

        button5.setOnAction(event -> {
            primaryStage.close();
        });

        Circle circle = new Circle();
        circle.setFill(new ImagePattern(buttonSelected));
        circle.setRadius(50);

        RotateTransition rotateBall = new RotateTransition(Duration.millis(3000), circle);
        rotateBall.setByAngle(360);
        rotateBall.setCycleCount(Animation.INDEFINITE);
        rotateBall.setAutoReverse(false);
        rotateBall.setInterpolator(Interpolator.LINEAR);
        rotateBall.play();

        gridPrimaryStage.setAlignment(Pos.CENTER_LEFT);
        gridPrimaryStage.setVgap(20);
        gridPrimaryStage.setHgap(30);
        GridPane.setColumnIndex(circle,0);
        GridPane.setRowIndex(circle,0);

        gridPrimaryStage.getChildren().addAll(button1, button4, button5, circle);

        Scene scene = new Scene(gridPrimaryStage, 900, 500, Color.GREEN);

        primaryStage.setTitle("GFD");//tytul okna
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();
    }
}
