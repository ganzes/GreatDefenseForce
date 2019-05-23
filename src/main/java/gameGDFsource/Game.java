package gameGDFsource;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.application.Application;
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
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.xml.soap.Text;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;
import java.util.stream.Stream;


public class Game {

    private int playerTurns = 0;
    private boolean isPlayer = true;

    private class HandleBall implements EventHandler<ActionEvent>{

        private Button buttonHandleBall; //jako referencja, ze ktory to jest

        public HandleBall(Button buttonHandleBall) {//wiadomo, ktory przycisk to wywolal
            this.buttonHandleBall = buttonHandleBall;
        }


        @Override
        public void handle(ActionEvent event) {
            //cialo metody

            if (isPlayer){
                playerTurns++;
            }

            Random random = new Random();

            double playerMove = random.nextInt(100);
            double computerMove = random.nextInt(100);


            if (playerMove < 10){//to powoduje, ze 10 procent szans, ze trafi w slupek

                if (isPlayer){
                    Alert alert3 = new Alert(Alert.AlertType.INFORMATION);
                    alert3.setTitle("You're magnificent shot resulted in... ");
                    alert3.setContentText(" You've hitted a post!");
                    alert3.showAndWait();
                }

            }

            else if (computerMove < 40) {//poziom trudnosci komputera, ze pc zgadnie ruch gracza, wielkosc liczby okresla poziom trudnosci
                if (isPlayer) {
                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                    alert2.setTitle("You're magnificent shot resulted in... ");
                    alert2.setContentText(" you've missed... !");
                    alert2.showAndWait();
                }
            }

            else{//60% szans na gol
                    if (isPlayer){
                        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                        alert1.setTitle("You're magnificent shot resulted in... ");
                        alert1.setContentText(" GOOOOOL !");
                        alert1.showAndWait();
                    }
            }

            if (isPlayer && playerTurns >=5){

                isPlayer = false;
                runComputer();
            }
        }
    }

private void runComputer(){


        for (int i=0; i<5; i++ ){//5 razy ta sama czynnosc, 5 tur dla computerPlayer
            nGB1.fire();
        }
        isPlayer = true;
        playerTurns = 0;
}

    private Button nGB1;
    private Button nGB2;
    private Button nGB3;
    private Button nGB4;
    private Button nGB5;
    private Button nGB6;

    public void newGame() {

        //stage > scene > container > nods

        Image newGameBackgroundImageFile = new Image("tloNewGame.jpg");

        Image buttonNeutral = new Image("ballNeutral.jpg");
        Image buttonSelected = new Image("ballSelected.jpg");

        BackgroundSize newGameBackgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage newGameBackgroundImage = new BackgroundImage(newGameBackgroundImageFile, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, newGameBackgroundSize);
        Background newGameBackground = new Background(newGameBackgroundImage);

        Stage newGameStage = new Stage();
        newGameStage.setTitle("New Game Started");

        nGB1 = new Button();
        nGB1.setGraphic(new ImageView(buttonNeutral));//tak ustawiasz grafike buttona
        nGB1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                nGB1.setGraphic(new ImageView(buttonSelected));
            }
        });

        nGB1.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                nGB1.setGraphic(new ImageView(buttonNeutral));
            }
        });

        nGB2 = new Button();
        nGB2.setGraphic(new ImageView(buttonNeutral));//tak ustawiasz grafike buttona
        nGB2.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                nGB2.setGraphic(new ImageView(buttonSelected));
            }
        });

        nGB2.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                nGB2.setGraphic(new ImageView(buttonNeutral));
            }
        });

        nGB3 = new Button();
        nGB3.setGraphic(new ImageView(buttonNeutral));//tak ustawiasz grafike buttona
        nGB3.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                nGB3.setGraphic(new ImageView(buttonSelected));
            }
        });

        nGB3.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                nGB3.setGraphic(new ImageView(buttonNeutral));
            }
        });


        nGB4 = new Button();
        nGB4.setGraphic(new ImageView(buttonNeutral));//tak ustawiasz grafike buttona
        nGB4.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                nGB4.setGraphic(new ImageView(buttonSelected));
            }
        });

        nGB4.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                nGB4.setGraphic(new ImageView(buttonNeutral));
            }
        });


        nGB5 = new Button();
        nGB5.setGraphic(new ImageView(buttonNeutral));//tak ustawiasz grafike buttona
        nGB5.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                nGB5.setGraphic(new ImageView(buttonSelected));
            }
        });

        nGB5.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                nGB5.setGraphic(new ImageView(buttonNeutral));
            }
        });


        nGB6 = new Button();
        nGB6.setGraphic(new ImageView(buttonNeutral));//tak ustawiasz grafike buttona
        nGB6.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                nGB6.setGraphic(new ImageView(buttonSelected));
            }
        });

        nGB6.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                nGB6.setGraphic(new ImageView(buttonNeutral));
            }
        });

        GridPane newGameGridPane = new GridPane();
        newGameGridPane.add(nGB1, 0, 0, 1, 1);
        newGameGridPane.add(nGB2, 1, 0, 1, 1);
        newGameGridPane.add(nGB3, 2, 0, 1, 1);
        newGameGridPane.add(nGB4, 0, 1, 1, 1);
        newGameGridPane.add(nGB5, 1, 1, 1, 1);
        newGameGridPane.add(nGB6, 2, 1, 1, 1);
        newGameGridPane.setAlignment(Pos.CENTER);
        newGameGridPane.setVgap(50);
        newGameGridPane.setHgap(150);
        newGameGridPane.setBackground(newGameBackground);

        Scene newGameScene = new Scene(newGameGridPane, 900, 500, Color.GREEN);

        newGameStage.setScene(newGameScene);
        newGameStage.show();

        nGB1.setOnAction(new HandleBall(nGB1));
        nGB2.setOnAction(new HandleBall(nGB2));
        nGB3.setOnAction(new HandleBall(nGB3));
        nGB4.setOnAction(new HandleBall(nGB4));
        nGB5.setOnAction(new HandleBall(nGB5));
        nGB6.setOnAction(new HandleBall(nGB6));

        //nGB1.fire();//od tego pc moze zaczac
    }
}
