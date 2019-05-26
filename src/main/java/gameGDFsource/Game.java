package gameGDFsource;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
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
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Popup;
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

    private int userScore;

    public int computerScore;


    TextScore textScoreComputer = new TextScore();
    TextScore textScoreUser = new TextScore();

    private class HandleBall implements EventHandler<MouseEvent>{
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
            Random random2 = new Random();

            textScoreUser.setText(Integer.toString(userScore));

            double computerMove = random.nextInt(6);
            double chancesGoal = random2.nextInt(101);

            System.out.println("NACISNALES "+ selectedBall);

            if (selectedBall == 1 && computerMove == 1){
                if (isPlayer){
                    System.out.println("KOMPUTER ORBRONIL 1");

                    Image imageGoalDefended = new Image("goalDeffended.png");
                    ImageView imageVGoalDefended = new ImageView(imageGoalDefended);

                    BorderPane paneGoalDefend = new BorderPane();
                    paneGoalDefend.setCenter(imageVGoalDefended);

                    Scene sceneGoalDefended = new Scene(paneGoalDefend);

                    Stage pcDefendsGoal = new Stage();
                    pcDefendsGoal.initModality(Modality.APPLICATION_MODAL);
                    pcDefendsGoal.setScene(sceneGoalDefended);
                    pcDefendsGoal.setAlwaysOnTop(true);
                    pcDefendsGoal.setTitle("Computer Player Defends The Goal!");
                    pcDefendsGoal.setResizable(false);
                    pcDefendsGoal.sizeToScene();
                    pcDefendsGoal.show();

                    Timeline timelineForPCDefends = new Timeline();
                    timelineForPCDefends.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
                            new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    pcDefendsGoal.close();
                                }
                            }));
                    timelineForPCDefends.play();

                }

                else {
                    //z perspektywy, ze gracz broni
                    System.out.println("BRONISZ PRZED KOMPUTEREM");

                    Image imageGoalDefended = new Image("goalDeffended.png");
                    ImageView imageVGoalDefended = new ImageView(imageGoalDefended);

                    BorderPane paneGoalDefend = new BorderPane();
                    paneGoalDefend.setCenter(imageVGoalDefended);

                    Scene sceneGoalDefended = new Scene(paneGoalDefend);

                    Stage pcDefendsGoal = new Stage();
                    pcDefendsGoal.initModality(Modality.APPLICATION_MODAL);
                    pcDefendsGoal.setScene(sceneGoalDefended);
                    pcDefendsGoal.setAlwaysOnTop(true);
                    pcDefendsGoal.setTitle("You've Defended The Goal!!!");
                    pcDefendsGoal.setResizable(false);
                    pcDefendsGoal.sizeToScene();
                    pcDefendsGoal.show();

                    Timeline timelineForPCDefends = new Timeline();
                    timelineForPCDefends.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
                            new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    pcDefendsGoal.close();
                                }
                            }));
                    timelineForPCDefends.play();
                }

            } else if (selectedBall == 1 && chancesGoal < 10) {
                if (isPlayer) {
                    Image imageLeftUpperGoalPost = new Image("leftUpperGoalPost.png");
                    ImageView showImageLeftUpperGoalPost = new ImageView(imageLeftUpperGoalPost);

                    BorderPane paneLeftUpperGoalPost = new BorderPane();
                    paneLeftUpperGoalPost.setCenter(showImageLeftUpperGoalPost);

                    Scene sceneLeftUpperGoalPost = new Scene(paneLeftUpperGoalPost);

                    Stage stageLeftUpperGoalPost = new Stage();
                    stageLeftUpperGoalPost.initModality(Modality.APPLICATION_MODAL);
                    stageLeftUpperGoalPost.setScene(sceneLeftUpperGoalPost);
                    stageLeftUpperGoalPost.setAlwaysOnTop(true);
                    stageLeftUpperGoalPost.setTitle("You've Hitted Upper Left Goal Post!");
                    stageLeftUpperGoalPost.setResizable(false);
                    stageLeftUpperGoalPost.sizeToScene();
                    stageLeftUpperGoalPost.show();

                    Timeline timelineLeftUpperGoalPost = new Timeline();
                    timelineLeftUpperGoalPost.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
                            new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    stageLeftUpperGoalPost.close();
                                }
                            }));
                    timelineLeftUpperGoalPost.play();

                    System.out.println("UDERZYLES W SLUPEK 1");
                    System.out.println("SLUPEK " + selectedBall);



                }

                else {
                //TU KOMPUTER TRAFIA W SLUPEK!
                }

                } else if (selectedBall == 1 && chancesGoal > 10 ){

                if (isPlayer){
                    System.out.println("GOOOOL " +selectedBall);
                    System.out.println("STRZELILES GOLA POLE 1");

                    Goal stageGoal = new Goal();

                    Timeline timelineGoal = new Timeline();
                    timelineGoal.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
                            new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    stageGoal.close();
                                }
                            }));
                    timelineGoal.play();

                    userScore++;
                }
                    else {
    //TU KOMPUTER TRAFIA :(
                }


                }








            if (selectedBall == 2 && computerMove == 2){
                System.out.println("KOMPUTER ORBRONIL 2");
            } else if (selectedBall == 2 && chancesGoal < 10) {
                System.out.println("UDERZYLES W POPRZECZKE 2");
                System.out.println("POPRZECZKA " +selectedBall);
            } else if (selectedBall == 2 && chancesGoal > 10 ){
                System.out.println("GOOOOL " +selectedBall);
                System.out.println("STRZELILES GOLA POLE 2");
                userScore++;
            }

            if (selectedBall == 3 && computerMove == 3){
                System.out.println("KOMPUTER ORBRONIL 3");
            } else if (selectedBall == 3 && chancesGoal < 10) {
                System.out.println("UDERZYLES W SLUPEK 3");
                System.out.println("SLUPEK " +selectedBall);
            } else if (selectedBall == 3 && chancesGoal > 10 ){
                System.out.println("GOOOOL 3" +selectedBall);
                System.out.println("STRZELILES GOLA POLE 3");
                userScore++;
            }

            if (selectedBall == 4 && computerMove == 4){
                System.out.println("KOMPUTER ORBRONIL 4");
            } else if (selectedBall == 4 && chancesGoal < 5) {
                System.out.println("UDERZYLES W SLUPEK 4");
                System.out.println("SLUPEK " +selectedBall);
            } else if (selectedBall == 4 && chancesGoal > 5 ){
                System.out.println("GOOOOL 4" +selectedBall);
                System.out.println("STRZELILES GOLA POLE 4");
                userScore++;
            }

            if (selectedBall == 5 && computerMove == 5){
                System.out.println("KOMPUTER ORBRONIL 5");
            } else if (selectedBall == 5 && chancesGoal > 102) {
                System.out.println("UDERZYLES W SLUPEK 5");
                System.out.println("SLUPEK" +selectedBall);
            } else if (selectedBall == 5 && chancesGoal < 102 ){
                System.out.println("GOOOOL 5 " +selectedBall);
                System.out.println("STRZELILES GOLA POLE 5");
                userScore++;
            }

            if (selectedBall == 6 && computerMove == 6){
                System.out.println("KOMPUTER ORBRONIL 6");
            } else if (selectedBall == 6 && chancesGoal < 5) {
                System.out.println("UDERZYLES W SLUPEK 6");
                System.out.println("SLUPEK 6" +selectedBall);
            } else if (selectedBall == 6 && chancesGoal > 5 ){
                System.out.println("GOOOOL 6" +selectedBall);
                System.out.println("STRZELILES GOLA POLE 6");
                userScore++;
            }

            System.out.println("WYNIK!! " + userScore);


           // playerTurns++;
           // if(playerTurns>=5){//tutaj rundy robimy
                isPlayer = !isPlayer;
           //     playerTurns=0;
         //   }


          }
    }

    public void runComputer(){

          for (int i=0; i<1; i++ ){//5 razy ta sama czynnosc, 5 tur dla computerPlayer


            Random randomButtonFire = new Random();
            double randomSelectButton = randomButtonFire.nextInt(101);

            if (randomSelectButton < 10){
            }

            else if (randomSelectButton < 40){
            }

            else {
                computerScore++;
                textScoreComputer.setText(Integer.toString(computerScore));
            }
        }






        isPlayer = true;
        playerTurns = 0;

        if (isPlayer = true){

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


    public void newGame() {
        //stage > scene > container > nods
        Image newGameBackgroundImageFile = new Image("tlo.jpg");
        Image buttonNeutral = new Image("ballNeutral.png");
        Image buttonSelected = new Image("ballSelected.png");

        BackgroundSize newGameBackgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage newGameBackgroundImage = new BackgroundImage(newGameBackgroundImageFile, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, newGameBackgroundSize);
        Background newGameBackground = new Background(newGameBackgroundImage);

        Stage newGameStage = new Stage();
        newGameStage.setTitle("New Game Started");
        newGameStage.initModality(Modality.APPLICATION_MODAL);

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

        GridPane newGameGridPane = new GridPane();
        newGameGridPane.add(nGB1, 0, 0, 1, 1);
        newGameGridPane.add(nGB2, 1, 0, 1, 1);
        newGameGridPane.add(nGB3, 2, 0, 1, 1);
        newGameGridPane.add(nGB4, 0, 1, 1, 1);
        newGameGridPane.add(nGB5, 1, 1, 1, 1);
        newGameGridPane.add(nGB6, 2, 1, 1, 1);

        newGameGridPane.getColumnConstraints();

        newGameGridPane.setAlignment(Pos.CENTER);
        newGameGridPane.setVgap(50);
        newGameGridPane.setHgap(100);
        newGameGridPane.setBackground(newGameBackground);

        Text textPCScore = new Text("PC");
        textPCScore.setFont(new Font(30));
        textPCScore.setFill(Color.RED);
        textPCScore.setTextAlignment(TextAlignment.CENTER);

        GridPane scoreGridComputer = new GridPane();
        scoreGridComputer.add(textPCScore,0,0);
        scoreGridComputer.add(textScoreComputer,0 , 1, 1, 1);
        scoreGridComputer.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        scoreGridComputer.setAlignment(Pos.CENTER);

        Text textUserScore = new Text("USER");
        textUserScore.setFont(new Font(30));
        textUserScore.setFill(Color.RED);
        textUserScore.setTextAlignment(TextAlignment.CENTER);

        GridPane scoreGridUser = new GridPane();
        scoreGridUser.add(textUserScore, 0, 0);
        scoreGridUser.add(textScoreUser,0 , 1, 1, 1);
        scoreGridUser.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        scoreGridUser.setAlignment(Pos.CENTER);

        newGameGridPane.add(scoreGridComputer, 3,0);
        newGameGridPane.add(scoreGridUser, 3,1);

        Scene newGameScene = new Scene(newGameGridPane, 900, 500, Color.GREEN);

        newGameStage.setScene(newGameScene);
        newGameStage.setResizable(false);
        newGameStage.sizeToScene();
        newGameStage.show();

        nGB1.setOnMouseClicked(new HandleBall(1));
        nGB2.setOnMouseClicked(new HandleBall(2));
        nGB3.setOnMouseClicked(new HandleBall(3));
        nGB4.setOnMouseClicked(new HandleBall(4));
        nGB5.setOnMouseClicked(new HandleBall(5));
        nGB6.setOnMouseClicked(new HandleBall(6));
    }
}
