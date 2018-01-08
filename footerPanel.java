package GUI;

import javax.swing.*;
import java.awt.*;

public class footerPanel extends JPanel {

    public footerPanel(){
        super(new GridLayout(1,2));
        createComponents();
    }

    private void createComponents() {
        add(new JTextField("Netflix Statistix"));
        add(new JTextField("Informatica, jaar 1, 23IVT1D1, Arno Nagtzaam, Jari den Ottelander, Thijs van der Woude"));
    }
}
