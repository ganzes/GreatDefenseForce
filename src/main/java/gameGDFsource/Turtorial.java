package gameGDFsource;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;


public class Turtorial {

    public void turtorialWinMeth(String titleWindowsSetTitle, String message){
        Stage turtorialWindow = new Stage();

        turtorialWindow.initModality(Modality.APPLICATION_MODAL);//blokuje to okno, poki sie nim nie zajmie
        turtorialWindow.setTitle(titleWindowsSetTitle);
        turtorialWindow.setMinWidth(400);

        Label label = new Label();
        label.setText(message);

        Button closeButton = new Button("Ok, take me back!");
        closeButton.setOnAction(e -> turtorialWindow.close());

        VBox layout = new VBox();
        layout.getChildren().addAll(label,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        turtorialWindow.setScene(scene);
        turtorialWindow.showAndWait();//wyswietla okno, ale zanim wrocisz, musisz to okno zamknac
    }
}
