package gameGDFsource;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.*;
import java.util.HashMap;
import java.util.Random;

public class Game {
    File file = new File("fileSaveGame.txt");

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

            double computerMove = random.nextInt(5)+1;//dzieki temu nigdy zera nie bedzie
            double chancesGoal = random2.nextInt(101);

            System.out.println("NACISNALES "+ selectedBall);
            System.out.println("KOMPUTER WYBRAL "+ computerMove);

//DLA POLA PIERWSZEGO
            if (selectedBall == 1 && computerMove == 1){
                if (isPlayer){
                    System.out.println("KOMPUTER OBRONIL TWOJ STRZAL POLA 1");

                    displayScene();

                }
                else {
                    //z perspektywy, ze gracz broni
                    System.out.println("OBRONILES PRZED KOMPUTEREM POLE 1");

                    displayScene2();
                }

            } else if (selectedBall == 1 && chancesGoal < 10) {
                if (isPlayer) {
                    displayScene3("You've Hitted Upper Left Goal Post!");

                    System.out.println("UDERZYLES W SLUPEK 1");
                    System.out.println("SLUPEK " + selectedBall);
                }
                else {
                //TU KOMPUTER TRAFIA W SLUPEK!
                    displayScene3("Computer Hitted Upper Goal Post!");

                    System.out.println("KOMPUTER UDERZYL W SLUPEK 1");
                    System.out.println("KOMPUTER SLUPEK 1 " + selectedBall);
                }

                } else if (selectedBall == 1 && chancesGoal > 10 ){

                if (isPlayer){
                    System.out.println("GOOOOL " +selectedBall);
                    System.out.println("STRZELILES GOLA POLE 1");

                    displayScene4();
                }
                    else {
    //TU KOMPUTER TRAFIA :(

                    System.out.println("GOOOOL KOMPUTERA" +selectedBall);
                    System.out.println("KOMPUTER STRZELIL POLE 1");

                    displayScene5();
                }
            }


//DLA POLA 2


            if (selectedBall == 2 && computerMove == 2){
                if (isPlayer){
                    System.out.println("KOMPUTER ORBRONIL 2");

                    displayScene();

                }

                else {
                    //z perspektywy, ze gracz broni
                    System.out.println("BRONISZ PRZED KOMPUTEREM");

                    displayScene2();
                }

            } else if (selectedBall == 2 && chancesGoal < 10) {
                if (isPlayer) {
                    Image imageBarGoalPost = new Image("barGoalPost.png");
                    ImageView showImageBarGoalPost = new ImageView(imageBarGoalPost);

                    BorderPane paneBarGoalPost = new BorderPane();
                    paneBarGoalPost.setCenter(showImageBarGoalPost);

                    Scene sceneLeftUpperGoalPost = new Scene(paneBarGoalPost);

                    Stage stageLeftUpperGoalPost = new Stage();
                    stageLeftUpperGoalPost.initModality(Modality.APPLICATION_MODAL);
                    stageLeftUpperGoalPost.setScene(sceneLeftUpperGoalPost);
                    stageLeftUpperGoalPost.setAlwaysOnTop(true);
                    stageLeftUpperGoalPost.setTitle("You've Hitted The Bar!");
                    stageLeftUpperGoalPost.setResizable(false);
                    stageLeftUpperGoalPost.sizeToScene();
                    stageLeftUpperGoalPost.show();

                    Timeline timelineBarGoalPost = new Timeline();
                    timelineBarGoalPost.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
                            new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    stageLeftUpperGoalPost.close();
                                }
                            }));
                    timelineBarGoalPost.play();

                    System.out.println("UDERZYLES W POPRZECZKE 2");
                    System.out.println("POPRZECZKA  " + selectedBall);
                }
                else {
                    //TU KOMPUTER TRAFIA W POPRZECZKE
                    Image imageBarGoalPost = new Image("barGoalPost.png");
                    ImageView showImageBarGoalPost = new ImageView(imageBarGoalPost);

                    BorderPane paneBarGoalPost = new BorderPane();
                    paneBarGoalPost.setCenter(showImageBarGoalPost);

                    Scene sceneBarGoalPost = new Scene(paneBarGoalPost);

                    Stage stageBarGoalPost = new Stage();
                    stageBarGoalPost.initModality(Modality.APPLICATION_MODAL);
                    stageBarGoalPost.setScene(sceneBarGoalPost);
                    stageBarGoalPost.setAlwaysOnTop(true);
                    stageBarGoalPost.setTitle("Computer Hitted The Bar!");
                    stageBarGoalPost.setResizable(false);
                    stageBarGoalPost.sizeToScene();
                    stageBarGoalPost.show();

                    Timeline timelineBarGoalPost = new Timeline();
                    timelineBarGoalPost.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
                            new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    stageBarGoalPost.close();
                                }
                            }));
                    timelineBarGoalPost.play();

                    System.out.println("KOMPUTER UDERZYL W POPRZECZKE 2");
                    System.out.println("KOMPUTER POPRZECZKA 2 " + selectedBall);
                }

            } else if (selectedBall == 2 && chancesGoal > 10 ){

                if (isPlayer){
                    System.out.println("GOOOOL " +selectedBall);
                    System.out.println("STRZELILES GOLA POLE 2");

                    displayScene4();
                }
                else {
                    //TU KOMPUTER TRAFIA :(

                    System.out.println("GOOOOL KOMPUTERA" +selectedBall);
                    System.out.println("KOMPUTER STRZELIL POLE 2");

                    displayScene5();
                }
            }



//TUTAJ POLE 3
            if (selectedBall == 3 && computerMove == 3){
                if (isPlayer){
                    System.out.println("KOMPUTER ORBRONIL 3");

                    displayScene();

                }
                else {
                    //z perspektywy, ze gracz broni
                    System.out.println("BRONISZ PRZED KOMPUTEREM");

                    displayScene2();
                }

            } else if (selectedBall == 3 && chancesGoal < 10) {
                if (isPlayer) {
                    Image imageRightUpperGoalPost = new Image("rightUpperGoalPost.png");
                    ImageView showImageRightUpperGoalPost = new ImageView(imageRightUpperGoalPost);

                    BorderPane paneRightUpperGoalPost = new BorderPane();
                    paneRightUpperGoalPost.setCenter(showImageRightUpperGoalPost);

                    Scene sceneRightUpperGoalPost = new Scene(paneRightUpperGoalPost);

                    Stage stageRightUpperGoalPost = new Stage();
                    stageRightUpperGoalPost.initModality(Modality.APPLICATION_MODAL);
                    stageRightUpperGoalPost.setScene(sceneRightUpperGoalPost);
                    stageRightUpperGoalPost.setAlwaysOnTop(true);
                    stageRightUpperGoalPost.setTitle("You've Hitted Upper Right Goal Post!");
                    stageRightUpperGoalPost.setResizable(false);
                    stageRightUpperGoalPost.sizeToScene();
                    stageRightUpperGoalPost.show();

                    Timeline timelineRightUpperGoalPost = new Timeline();
                    timelineRightUpperGoalPost.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
                            new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    stageRightUpperGoalPost.close();
                                }
                            }));
                    timelineRightUpperGoalPost.play();

                    System.out.println("UDERZYLES W SLUPEK 3");
                    System.out.println("SLUPEK " + selectedBall);
                }
                else {
                    //TU KOMPUTER TRAFIA W SLUPEK!
                    Image imageRightUpperGoalPost = new Image("rightUpperGoalPost.png");
                    ImageView showImageRightUpperGoalPost = new ImageView(imageRightUpperGoalPost);

                    BorderPane paneRightUpperGoalPost = new BorderPane();
                    paneRightUpperGoalPost.setCenter(showImageRightUpperGoalPost);

                    Scene sceneRightUpperGoalPost = new Scene(paneRightUpperGoalPost);

                    Stage stageRightUpperGoalPost = new Stage();
                    stageRightUpperGoalPost.initModality(Modality.APPLICATION_MODAL);
                    stageRightUpperGoalPost.setScene(sceneRightUpperGoalPost);
                    stageRightUpperGoalPost.setAlwaysOnTop(true);
                    stageRightUpperGoalPost.setTitle("Computer Hitted Right Goal Post!");
                    stageRightUpperGoalPost.setResizable(false);
                    stageRightUpperGoalPost.sizeToScene();
                    stageRightUpperGoalPost.show();

                    Timeline timelineRightUpperGoalPost = new Timeline();
                    timelineRightUpperGoalPost.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
                            new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    stageRightUpperGoalPost.close();
                                }
                            }));
                    timelineRightUpperGoalPost.play();

                    System.out.println("KOMPUTER UDERZYL W SLUPEK 3");
                    System.out.println("SLUPEK " + selectedBall);
                }

            } else if (selectedBall == 3 && chancesGoal > 10 ){

                if (isPlayer){
                    System.out.println("GOOOOL " +selectedBall);
                    System.out.println("STRZELILES GOLA POLE 3");

                    displayScene4();
                }
                else {
                    //TU KOMPUTER TRAFIA :(

                    System.out.println("GOOOOL KOMPUTERA" +selectedBall);
                    System.out.println("KOMPUTER STRZELIL POLE 3");

                    displayScene5();
                }
            }

//TUTAJ POLE 4


            if (selectedBall == 4 && computerMove == 4){
                if (isPlayer){
                    System.out.println("KOMPUTER ORBRONIL 4");

                    displayScene();

                }
                else {
                    //z perspektywy, ze gracz broni
                    System.out.println("BRONISZ PRZED KOMPUTEREM");

                    displayScene2();
                }

            } else if (selectedBall == 4 && chancesGoal < 5) {
                if (isPlayer) {
                    Image imageLeftLowerGoalPost = new Image("leftLowerGoalPost.png");
                    ImageView showImageLeftLowerGoalPost = new ImageView(imageLeftLowerGoalPost);

                    BorderPane paneLeftLowerGoalPost = new BorderPane();
                    paneLeftLowerGoalPost.setCenter(showImageLeftLowerGoalPost);

                    Scene sceneLeftLowerGoalPost = new Scene(paneLeftLowerGoalPost);

                    Stage stageLeftLowerGoalPost = new Stage();
                    stageLeftLowerGoalPost.initModality(Modality.APPLICATION_MODAL);
                    stageLeftLowerGoalPost.setScene(sceneLeftLowerGoalPost);
                    stageLeftLowerGoalPost.setAlwaysOnTop(true);
                    stageLeftLowerGoalPost.setTitle("You've Hitted Lower Left Goal Post!");
                    stageLeftLowerGoalPost.setResizable(false);
                    stageLeftLowerGoalPost.sizeToScene();
                    stageLeftLowerGoalPost.show();

                    Timeline timelineLeftLowerGoalPost = new Timeline();
                    timelineLeftLowerGoalPost.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
                            new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    stageLeftLowerGoalPost.close();
                                }
                            }));
                    timelineLeftLowerGoalPost.play();

                    System.out.println("UDERZYLES W SLUPEK 4");
                    System.out.println("SLUPEK " + selectedBall);
                }
                else {
                    //TU KOMPUTER TRAFIA W SLUPEK!
                    Image imageLeftLowerGoalPost = new Image("leftLowerGoalPost.png");
                    ImageView showImageLeftLowerGoalPost = new ImageView(imageLeftLowerGoalPost);

                    BorderPane paneLeftLowerGoalPost = new BorderPane();
                    paneLeftLowerGoalPost.setCenter(showImageLeftLowerGoalPost);

                    Scene sceneLeftLowerGoalPost = new Scene(paneLeftLowerGoalPost);

                    Stage stageLeftLowerGoalPost = new Stage();
                    stageLeftLowerGoalPost.initModality(Modality.APPLICATION_MODAL);
                    stageLeftLowerGoalPost.setScene(sceneLeftLowerGoalPost);
                    stageLeftLowerGoalPost.setAlwaysOnTop(true);
                    stageLeftLowerGoalPost.setTitle("Computer Hitted Lowet Left Goal Post!");
                    stageLeftLowerGoalPost.setResizable(false);
                    stageLeftLowerGoalPost.sizeToScene();
                    stageLeftLowerGoalPost.show();

                    Timeline timelineLeftLowerGoalPost = new Timeline();
                    timelineLeftLowerGoalPost.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
                            new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    stageLeftLowerGoalPost.close();
                                }
                            }));
                    timelineLeftLowerGoalPost.play();

                    System.out.println("KOMPUTER TRAFIA W SLUPEK 4");
                    System.out.println("SLUPEK " + selectedBall);
                }

            } else if (selectedBall == 4 && chancesGoal > 5 ){

                if (isPlayer){
                    System.out.println("GOOOOL " +selectedBall);
                    System.out.println("STRZELILES GOLA POLE 4");

                    displayScene4();
                }
                else {
                    //TU KOMPUTER TRAFIA :(

                    System.out.println("GOOOOL KOMPUTERA" +selectedBall);
                    System.out.println("KOMPUTER STRZELIL POLE 4");

                    displayScene5();
                }
            }

//POLE DLA POLA 5

            if (selectedBall == 5 && computerMove == 5){
                if (isPlayer){
                    System.out.println("KOMPUTER ORBRONIL 5");

                    displayScene();

                }
                else {
                    //z perspektywy, ze gracz broni
                    System.out.println("BRONISZ PRZED KOMPUTEREM");

                    displayScene2();
                }

            } else if (selectedBall == 5 && chancesGoal < 0) {
                if (isPlayer) {
                    Image imageLeftLowerGoalPost = new Image("leftLowerGoalPost.png");
                    ImageView showImageLeftLowerGoalPost = new ImageView(imageLeftLowerGoalPost);

                    BorderPane paneLeftLowerGoalPost = new BorderPane();
                    paneLeftLowerGoalPost.setCenter(showImageLeftLowerGoalPost);

                    Scene sceneLeftLowerGoalPost = new Scene(paneLeftLowerGoalPost);

                    Stage stageLeftLowerGoalPost = new Stage();
                    stageLeftLowerGoalPost.initModality(Modality.APPLICATION_MODAL);
                    stageLeftLowerGoalPost.setScene(sceneLeftLowerGoalPost);
                    stageLeftLowerGoalPost.setAlwaysOnTop(true);
                    stageLeftLowerGoalPost.setTitle("You've Hitted Lower Left Goal Post!");
                    stageLeftLowerGoalPost.setResizable(false);
                    stageLeftLowerGoalPost.sizeToScene();
                    stageLeftLowerGoalPost.show();

                    Timeline timelineLeftLowerGoalPost = new Timeline();
                    timelineLeftLowerGoalPost.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
                            new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    stageLeftLowerGoalPost.close();
                                }
                            }));
                    timelineLeftLowerGoalPost.play();

                    System.out.println("UDERZYLES W SLUPEK 4");
                    System.out.println("SLUPEK " + selectedBall);
                }
                else {
                    //TU KOMPUTER TRAFIA W SLUPEK!
                    Image imageLeftLowerGoalPost = new Image("leftLowerGoalPost.png");
                    ImageView showImageLeftLowerGoalPost = new ImageView(imageLeftLowerGoalPost);

                    BorderPane paneLeftLowerGoalPost = new BorderPane();
                    paneLeftLowerGoalPost.setCenter(showImageLeftLowerGoalPost);

                    Scene sceneLeftLowerGoalPost = new Scene(paneLeftLowerGoalPost);

                    Stage stageLeftLowerGoalPost = new Stage();
                    stageLeftLowerGoalPost.initModality(Modality.APPLICATION_MODAL);
                    stageLeftLowerGoalPost.setScene(sceneLeftLowerGoalPost);
                    stageLeftLowerGoalPost.setAlwaysOnTop(true);
                    stageLeftLowerGoalPost.setTitle("Computer Hitted Lowet Left Goal Post!");
                    stageLeftLowerGoalPost.setResizable(false);
                    stageLeftLowerGoalPost.sizeToScene();
                    stageLeftLowerGoalPost.show();

                    Timeline timelineLeftLowerGoalPost = new Timeline();
                    timelineLeftLowerGoalPost.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
                            new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    stageLeftLowerGoalPost.close();
                                }
                            }));
                    timelineLeftLowerGoalPost.play();

                    System.out.println("KOMPUTER TRAFIA W SLUPEK 4");
                    System.out.println("SLUPEK " + selectedBall);
                }

            } else if (selectedBall == 5 && chancesGoal > 0 ){

                if (isPlayer){
                    System.out.println("GOOOOL " +selectedBall);
                    System.out.println("STRZELILES GOLA POLE 5");

                    displayScene4();
                }
                else {
                    //TU KOMPUTER TRAFIA :(

                    System.out.println("GOOOOL KOMPUTERA" +selectedBall);
                    System.out.println("KOMPUTER STRZELIL POLE 5");

                    displayScene5();
                }
            }

//TU DLA 6

            if (selectedBall == 6 && computerMove == 6){
                if (isPlayer){
                    System.out.println("KOMPUTER ORBRONIL 6");

                    displayScene();

                }
                else {
                    //z perspektywy, ze gracz broni
                    System.out.println("BRONISZ PRZED KOMPUTEREM");

                    displayScene2();
                }

            } else if (selectedBall == 6 && chancesGoal < 5) {
                if (isPlayer) {
                    Image imageRightLowerGoalPost = new Image("rightLowerGoalPost.png");
                    ImageView showImageRightLowerGoalPost = new ImageView(imageRightLowerGoalPost);

                    BorderPane paneRightLowerGoalPost = new BorderPane();
                    paneRightLowerGoalPost.setCenter(showImageRightLowerGoalPost);

                    Scene sceneRightLowerGoalPost = new Scene(paneRightLowerGoalPost);

                    Stage stageRightLowerGoalPost = new Stage();
                    stageRightLowerGoalPost.initModality(Modality.APPLICATION_MODAL);
                    stageRightLowerGoalPost.setScene(sceneRightLowerGoalPost);
                    stageRightLowerGoalPost.setAlwaysOnTop(true);
                    stageRightLowerGoalPost.setTitle("You've Hitted Lower Right Goal Post!");
                    stageRightLowerGoalPost.setResizable(false);
                    stageRightLowerGoalPost.sizeToScene();
                    stageRightLowerGoalPost.show();

                    Timeline timelineLeftLowerGoalPost = new Timeline();
                    timelineLeftLowerGoalPost.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
                            new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    stageRightLowerGoalPost.close();
                                }
                            }));
                    timelineLeftLowerGoalPost.play();

                    System.out.println("UDERZYLES W SLUPEK 6");
                    System.out.println("SLUPEK " + selectedBall);
                }
                else {
                    //TU KOMPUTER TRAFIA W SLUPEK!

                    Image imageRightLowerGoalPost = new Image("rightLowerGoalPost.png");
                    ImageView showImageRightLowerGoalPost = new ImageView(imageRightLowerGoalPost);

                    BorderPane paneRightLowerGoalPost = new BorderPane();
                    paneRightLowerGoalPost.setCenter(showImageRightLowerGoalPost);

                    Scene sceneRightLowerGoalPost = new Scene(paneRightLowerGoalPost);

                    Stage stageRightLowerGoalPost = new Stage();
                    stageRightLowerGoalPost.initModality(Modality.APPLICATION_MODAL);
                    stageRightLowerGoalPost.setScene(sceneRightLowerGoalPost);
                    stageRightLowerGoalPost.setAlwaysOnTop(true);
                    stageRightLowerGoalPost.setTitle("Computer Hitted Lower Right Goal Post!");
                    stageRightLowerGoalPost.setResizable(false);
                    stageRightLowerGoalPost.sizeToScene();
                    stageRightLowerGoalPost.show();

                    Timeline timelineLeftLowerGoalPost = new Timeline();
                    timelineLeftLowerGoalPost.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
                            new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    stageRightLowerGoalPost.close();
                                }
                            }));
                    timelineLeftLowerGoalPost.play();
                    System.out.println("KOMPUTER TRAFIA W SLUPEK 6");
                    System.out.println("SLUPEK " + selectedBall);
                }

            } else if (selectedBall == 6 && chancesGoal > 5 ){

                if (isPlayer){
                    System.out.println("GOOOOL " +selectedBall);
                    System.out.println("STRZELILES GOLA POLE 6");

                    displayScene4();
                }
                else {
                    //TU KOMPUTER TRAFIA :(

                    System.out.println("GOOOOL KOMPUTERA" +selectedBall);
                    System.out.println("KOMPUTER STRZELIL POLE 6");

                    displayScene5();
                }
            }

            System.out.println("WYNIK!! " + "USER "+  userScore +"   COMPUTER " +computerScore  );


           // playerTurns++;
           // if(playerTurns>=5){//tutaj rundy robimy
                isPlayer = !isPlayer;
           //     playerTurns=0;
         //   }
          }

        private void displayScene5() {
            Goal stageGoal = new Goal();
            stageGoal.setTitle("Computer Scored! Oh no, but... GOALL!");

            Timeline timelineGoal = new Timeline();
            timelineGoal.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
                    new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            stageGoal.close();
                        }
                    }));
            timelineGoal.play();

            computerScore++;
            textScoreComputer.setText(Integer.toString(computerScore));
        }

        private void displayScene4() {
            Goal stageGoal = new Goal();
            stageGoal.setTitle("You've Scored! GOALL!");

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

        private void displayScene3(String s) {
            Image imageLeftUpperGoalPost = new Image("leftUpperGoalPost.png");
            ImageView showImageLeftUpperGoalPost = new ImageView(imageLeftUpperGoalPost);

            BorderPane paneLeftUpperGoalPost = new BorderPane();
            paneLeftUpperGoalPost.setCenter(showImageLeftUpperGoalPost);

            Scene sceneLeftUpperGoalPost = new Scene(paneLeftUpperGoalPost);

            Stage stageLeftUpperGoalPost = new Stage();
            stageLeftUpperGoalPost.initModality(Modality.APPLICATION_MODAL);
            stageLeftUpperGoalPost.setScene(sceneLeftUpperGoalPost);
            stageLeftUpperGoalPost.setAlwaysOnTop(true);
            stageLeftUpperGoalPost.setTitle(s);
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
        }

        private void displayScene2() {
            Image imageGoalDefendedUser = new Image("goalDeffendedUser.png");
            ImageView imageVGoalDefendedUser = new ImageView(imageGoalDefendedUser);

            BorderPane paneGoalDefend = new BorderPane();
            paneGoalDefend.setCenter(imageVGoalDefendedUser);

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

        private void displayScene() {
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

        Button save = new Button();
        save.setText("Save Current Game");

        save.setOnAction(event -> {
            HashMap<String, Integer> map = new HashMap<>();
            map.put("User ", userScore);
            map.put("PC", computerScore);

            try {
                ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(map);
                oos.close();
            } catch (Exception a){
                System.out.println(a);
            }
        });

Button load = new Button();
load.setText("Load Saved Game");

load.setOnAction(event -> {
    try {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Object readMap = ois.readObject();//zwraca mi to obiekt

        HashMap<String, Integer> map2 = new HashMap<>();

        System.out.println(readMap);
    } catch (Exception a){
        System.out.println(a);
    }
});

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
       // newGameGridPane.add(save, 3,2);
       // newGameGridPane.add(load, 3, 3);

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
