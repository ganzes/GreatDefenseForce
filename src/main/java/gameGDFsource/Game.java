package gameGDFsource;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuBar;
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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;
import java.util.stream.Stream;

public class Game {

    private int rounds = 0;
    private int playerTurns = 0;
    private boolean isPlayer = true;

    private int userScore = 0;
    private int computerScore = 0;

    private class HandleBall implements EventHandler<MouseEvent>{

       // private ImageView buttonHandleBall; //jako referencja, ze ktory to jest
        private int selectedBall;


        public HandleBall(int selectedBall) {//wiadomo, ktory przycisk to wywolal
            this.selectedBall = selectedBall;
        }

        @Override
        public void handle(MouseEvent event) {
            //cialo metody



            if (isPlayer){
                playerTurns++;
            }

            Random random = new Random();


            double computerMove = random.nextInt(6);

            if (selectedBall == computerMove){
                System.out.println("Bramkarz obronil");
            } else {
                System.out.println("Goal");
            }


            /*

            if (playerMove < 10){//to powoduje, ze 10 procent szans, ze trafi w slupek

                if (isPlayer){
                    Alert alertHumanGoalPost = new Alert(Alert.AlertType.INFORMATION);
                    alertHumanGoalPost.setTitle("You're magnificent shot resulted in... ");
                    alertHumanGoalPost.setContentText(" You've hit a post!");
                    alertHumanGoalPost.showAndWait();
                }
            }

            else if (computerMove < 40 && isPlayer ) {//poziom trudnosci komputera, ze pc zgadnie ruch gracza, wielkosc liczby okresla poziom trudnosci
                    Alert alertHumanMissed = new Alert(Alert.AlertType.INFORMATION);
                    alertHumanMissed.setTitle("You're magnificent shot resulted in... ");
                    alertHumanMissed.setContentText(" You've missed... !");
                    alertHumanMissed.showAndWait();

            }

            else{//60% szans na gol
                    if (isPlayer){
                        userScore++;
                        Alert alertHumanGoal = new Alert(Alert.AlertType.INFORMATION);
                        alertHumanGoal.setTitle("You're magnificent shot resulted in... ");
                        alertHumanGoal.setContentText(" GOOOOAAL !");
                        alertHumanGoal.showAndWait();
                    }
                    System.out.println("PUNKTY UZYTKOWNIKA "+userScore);
            }

            if (isPlayer && playerTurns >=5){

                isPlayer = false;
                Alert alertPCTurn = new Alert(Alert.AlertType.WARNING);
                alertPCTurn.setTitle("Your turn has ended!");
                alertPCTurn.setContentText("It's time for a Computer Player!");
                alertPCTurn.showAndWait();
*/
                runComputer();
           // }
        }
    }

private void runComputer(){

        //tez tu
        //nGB1 = new ImageView(buttonNeutral);

        for (int i=0; i<5; i++ ){//5 razy ta sama czynnosc, 5 tur dla computerPlayer

            Random randomButtonFire = new Random();
            double randomSelectButton = randomButtonFire.nextInt(101);

            //nGB1.fire();

            if (randomSelectButton < 10){
                Alert alertPCGoalPost = new Alert(Alert.AlertType.INFORMATION);
                alertPCGoalPost.setTitle("Computer Player shot resulted in... ");
                alertPCGoalPost.setContentText(" Computer Player hit the goal post !");
                alertPCGoalPost.showAndWait();

                String a = "Computer Player hit a Goal Poast!";
                System.out.println(a);
            }

            else if (randomSelectButton < 40){
                Alert alertPCGoal = new Alert(Alert.AlertType.INFORMATION);
                alertPCGoal.setTitle("Computer Player shot resulted in... ");
                alertPCGoal.setContentText(" Computer Player missed... !");
                alertPCGoal.showAndWait();

                System.out.println("Computer Player missed!");
            }

            else {
                computerScore++;
                Alert alertPCMissed = new Alert(Alert.AlertType.INFORMATION);
                alertPCMissed.setTitle("Computer Player shot resulted in... ");
                alertPCMissed.setContentText(" Coputer Player scored! GOOOOAAL !");
                alertPCMissed.showAndWait();System.out.println("Computer Player scored! GOOOOAAL !");
            }

            System.out.println(i);
            System.out.println("PUNKTY KOMPUTERA "+ computerScore);
        }

        isPlayer = true;
        playerTurns = 0;

        if (isPlayer = true){

            Alert alertPlayerTurn = new Alert(Alert.AlertType.CONFIRMATION);
            alertPlayerTurn.setTitle("Computer Player Turn has ended!");
            alertPlayerTurn.setContentText("It's time for a Human Player! Have fun!");
            alertPlayerTurn.showAndWait();

            if (userScore > computerScore){
                System.out.println("WYGRAL UZYTKOWNIK");
                Text winUserText = new Text();
                winUserText.setText("WYGRAL UZYTKOWNIK");
            } else if(userScore < computerScore) {
                System.out.println("WYGRAL PC");
                Text winPCUser = new Text();
                winPCUser.setText("REMIS");
            } else {
                System.out.println("REMIS");
                Text remisUserPCText = new Text();
                remisUserPCText.setText("REMIS");
            }
            rounds++;
            System.out.println("Koniec rundy " + rounds);
            System.out.println("Teraz gracz!");
        }
}
    private ImageView nGB1;
    private ImageView nGB2;
    private ImageView nGB3;
    private ImageView nGB4;
    private ImageView nGB5;
    private ImageView nGB6;
   // private Button nGB7;

    public void newGame() {
        //stage > scene > container > nods
        Image newGameBackgroundImageFile = new Image("tloNewGame.jpg");
        Image buttonNeutral = new Image("ballNeutral.png");
        Image buttonSelected = new Image("ballSelected.png");

        BackgroundSize newGameBackgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage newGameBackgroundImage = new BackgroundImage(newGameBackgroundImageFile, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, newGameBackgroundSize);
        Background newGameBackground = new Background(newGameBackgroundImage);

        Text scoreShow = new Text();
        scoreShow.setText(Integer.toString(computerScore));
        scoreShow.setFont(new Font(100));
        scoreShow.setFill(Color.WHITE);
        scoreShow.setTextAlignment(TextAlignment.CENTER);

        //scoreShow.setText(String.valueOf(computerScore));






        Stage newGameStage = new Stage();
        newGameStage.setTitle("New Game Started");
        newGameStage.initModality(Modality.APPLICATION_MODAL);

        //nGB1 = new Button();

        nGB1 = new ImageView(buttonNeutral);
        nGB1.setOnMouseEntered(event -> nGB1.setImage(buttonSelected));
        nGB1.setOnMouseExited(event -> nGB1.setImage(buttonNeutral));

        nGB2 = new ImageView(buttonNeutral);
        nGB2.setOnMouseEntered(event -> nGB2.setImage(buttonSelected));
        nGB2.setOnMouseExited(event -> nGB2.setImage(buttonNeutral));

        nGB3 = new ImageView(buttonNeutral);
        nGB3.setOnMouseEntered(event -> nGB3.setImage(buttonSelected));
        nGB3.setOnMouseExited(event -> nGB3.setImage(buttonNeutral));

        nGB4 = new ImageView(buttonNeutral);
        nGB4.setOnMouseEntered(event -> nGB4.setImage(buttonSelected));
        nGB4.setOnMouseExited(event -> nGB4.setImage(buttonNeutral));

        nGB5 = new ImageView(buttonNeutral);
        nGB5.setOnMouseEntered(event -> nGB5.setImage(buttonSelected));
        nGB5.setOnMouseExited(event -> nGB5.setImage(buttonNeutral));

        nGB6 = new ImageView(buttonNeutral);
        nGB6.setOnMouseEntered(event -> nGB6.setImage(buttonSelected));
        nGB6.setOnMouseExited(event -> nGB6.setImage(buttonNeutral));

        nGB1.setStyle("-fx-cursor: hand");
        nGB2.setStyle("-fx-cursor: hand");
        nGB3.setStyle("-fx-cursor: hand");
        nGB4.setStyle("-fx-cursor: hand");
        nGB5.setStyle("-fx-cursor: hand");
        nGB6.setStyle("-fx-cursor: hand");


        /*nGB1.setGraphic(new ImageView(buttonNeutral));//tak ustawiasz grafike buttona
        nGB1.setOnMouseEntered(event -> nGB1.setGraphic(new ImageView(buttonSelected)));
        nGB1.setOnMouseExited(event -> nGB1.setGraphic(new ImageView(buttonNeutral)));

        nGB2 = new Button();
        nGB2.setGraphic(new ImageView(buttonNeutral));//tak ustawiasz grafike buttona
        nGB2.setOnMouseEntered(event -> nGB2.setGraphic(new ImageView(buttonSelected)));
        nGB2.setOnMouseExited(event -> nGB2.setGraphic(new ImageView(buttonNeutral)));

        nGB3 = new Button();
        nGB3.setGraphic(new ImageView(buttonNeutral));//tak ustawiasz grafike buttona
        nGB3.setOnMouseEntered(event -> nGB3.setGraphic(new ImageView(buttonSelected)));
        nGB3.setOnMouseExited(event -> nGB3.setGraphic(new ImageView(buttonNeutral)));

        nGB4 = new Button();
        nGB4.setGraphic(new ImageView(buttonNeutral));//tak ustawiasz grafike buttona
        nGB4.setOnMouseEntered(event -> nGB4.setGraphic(new ImageView(buttonSelected)));
        nGB4.setOnMouseExited(event -> nGB4.setGraphic(new ImageView(buttonNeutral)));

        nGB5 = new Button();
        nGB5.setGraphic(new ImageView(buttonNeutral));//tak ustawiasz grafike buttona
        nGB5.setOnMouseEntered(event -> nGB5.setGraphic(new ImageView(buttonSelected)));
        nGB5.setOnMouseExited(event -> nGB5.setGraphic(new ImageView(buttonNeutral)));

        nGB6 = new Button();
        nGB6.setGraphic(new ImageView(buttonNeutral));//tak ustawiasz grafike buttona
        nGB6.setOnMouseEntered(event -> nGB6.setGraphic(new ImageView(buttonSelected)));
        nGB6.setOnMouseExited(event -> nGB6.setGraphic(new ImageView(buttonNeutral)));*/


       // nGB7 = new Button();
/*
        // create a menu
        javafx.scene.control.Menu m = new javafx.scene.control.Menu("Menu");
        // create menuitems
        javafx.scene.control.MenuItem m1 = new javafx.scene.control.MenuItem("menu item 1");
        javafx.scene.control.MenuItem m2 = new javafx.scene.control.MenuItem("menu item 2");
        javafx.scene.control.MenuItem m3 = new javafx.scene.control.MenuItem("menu item 3");
        // add menu items to menu
        m.getItems().add(m1);
        m.getItems().add(m2);
        m.getItems().add(m3);
        // create a menubar
        javafx.scene.control.MenuBar mb = new MenuBar();
        // add menu to menubar
        mb.getMenus().add(m);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(mb);*/


        GridPane newGameGridPane = new GridPane();
        newGameGridPane.add(nGB1, 0, 0, 1, 1);
        newGameGridPane.add(nGB2, 1, 0, 1, 1);
        newGameGridPane.add(nGB3, 2, 0, 1, 1);
        newGameGridPane.add(nGB4, 0, 1, 1, 1);
        newGameGridPane.add(nGB5, 1, 1, 1, 1);
        newGameGridPane.add(nGB6, 2, 1, 1, 1);
        newGameGridPane.getChildren().addAll(scoreShow);
        newGameGridPane.setAlignment(Pos.CENTER);
        newGameGridPane.setVgap(50);
        newGameGridPane.setHgap(150);
        newGameGridPane.setBackground(newGameBackground);

        Scene newGameScene = new Scene(newGameGridPane, 900, 500, Color.GREEN);

        newGameStage.setScene(newGameScene);
        newGameStage.show();

        //nGB1.setOnAction(new HandleBall(nGB1));


        nGB1.setOnMouseClicked(new HandleBall(1));
        nGB2.setOnMouseClicked(new HandleBall(2));
        nGB3.setOnMouseClicked(new HandleBall(3));
        nGB4.setOnMouseClicked(new HandleBall(4));
        nGB5.setOnMouseClicked(new HandleBall(5));
        nGB6.setOnMouseClicked(new HandleBall(6));
        //tu info, ktora zostala kliknieta


       /* nGB2.setOnAction(new HandleBall(nGB2));
        nGB3.setOnAction(new HandleBall(nGB3));
        nGB4.setOnAction(new HandleBall(nGB4));
        nGB5.setOnAction(new HandleBall(nGB5));
        nGB6.setOnAction(new HandleBall(nGB6));*/
        //nGB1.fire();//od tego pc moze zaczac
    }
}
