package GUI;

import java.awt.EventQueue;

public class Main {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Records login = new Records();
                login.setVisible(true);
            }
        });

    }
}
