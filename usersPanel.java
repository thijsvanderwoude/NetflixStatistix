package GUI;

import javax.swing.*;
import java.awt.*;

public class usersPanel extends JPanel {

    public usersPanel(){
        super(new GridLayout(10, 1, 5, 0));
        createComponents();
        setBackground(Color.white);
    }

    private void createComponents() {
        add(new JButton("Overzicht1"));
        add(new JButton("Overzicht2"));
        add(new JButton("Overzicht3"));
        add(new JButton("Overzicht4"));
    }
}
