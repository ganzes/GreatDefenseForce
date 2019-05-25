package gameGDFsource;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class TextScore extends Text {

    //metoda musi miec zwrocona wartosc, jak return, to metoda, jak nie zwraca nic, to void > a jak void, to cos robi,
    // ale nic nie zwraca

    public TextScore() {
       // setText("SCORE");
        setFont(new Font(50));
        setFill(Color.WHITE);
        setTextAlignment(TextAlignment.CENTER);
    }
}
