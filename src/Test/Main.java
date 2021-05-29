package Test;
import java.awt.EventQueue;

public class Main {

    public static void main(String[] args) {
        //System.out.println("Hallo");
        EventQueue.invokeLater(() -> {      //keine Ahnung wofür das ist
            SchiffMain spiel1 = new SchiffMain();
            spiel1.setVisible(true);
        });
    }
}
