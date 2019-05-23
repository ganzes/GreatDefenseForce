package gameGDFsource;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Score {
    public void Score(String titleWindowsSetTitle, String message){
        Stage score = new Stage();

        score.initModality(Modality.APPLICATION_MODAL);//blokuje to okno, poki sie nim nie zajmie
        score.setTitle(titleWindowsSetTitle);
        score.setMinWidth(400);

        Label label = new Label();
        label.setText(message);

        Button closeButton = new Button("Ok, take me back!");
        closeButton.setOnAction(e -> score.close());

        VBox layout = new VBox();
        layout.getChildren().addAll(label,closeButton);
        layout.setAlignment(Pos.TOP_RIGHT);

        Scene scene = new Scene(layout);
        score.setScene(scene);
        score.showAndWait();//wyswietla okno, ale zanim wrocisz, musisz to okno zamknac

    }

}