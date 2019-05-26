package gameGDFsource;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Goal extends Stage {

    public Goal() {

        Image imageGoal = new Image("goal.png");
        ImageView showImageGoal = new ImageView(imageGoal);

        BorderPane paneGoal = new BorderPane();
        paneGoal.setCenter(showImageGoal);

        Scene sceneGoal = new Scene(paneGoal);

        initModality(Modality.APPLICATION_MODAL);
        setScene(sceneGoal);
        setAlwaysOnTop(true);
        setTitle("GOOAAALL!");
        setResizable(false);
        sizeToScene();
        show();

    }
}
