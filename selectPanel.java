package GUI;

import javax.swing.*;
import java.awt.*;

public class selectPanel extends JPanel {

    public selectPanel(){
        createComponents();
        setBackground(Color.lightGray);
        setLayout(null);
    }

    private void createComponents() {
        setLayout(null);
        JTextField select = new JTextField("Selecteer serie of film");
        Font font1 = new Font("SansSerif", Font.PLAIN, 20);
        select.setFont(font1);
        select.setBackground(Color.lightGray);
        select.setBorder(null);
        select.setEditable(false);
        select.setBounds(200,100,250,50);
        add(select);

        String [] choices = {"Selecteer serie of film","Breaking bad", "Fargo", "Sherlock", "The Abominable Bride", "The life of brian", "Pulp Fiction", "Pruimebloesem", "Reservoir Dogs", "The Good, the Bad and the Ugly","Andy Warhol's Dracula", "Ober", "Der Untergang", "De helaasheid der dingen", "A Clockwork Orange"};
        JComboBox<String> list = new JComboBox<String>(choices);
        list.setFont(font1);
        list.setBounds(500,100,300,50);
        list.setBackground(Color.white);
        list.setEditable(false);
        add(list);

        JTextField account = new JTextField("Selecteer account");
        account.setFont(font1);
        account.setBackground(Color.lightGray);
        account.setBorder(null);
        account.setEditable(false);
        account.setBounds(200,200,250,50);
        add(account);

        String [] accounts = {"Frank van Raalte", "Madelief van Raalte", "Petrus van Betlehem", "Paulus van Betlehem", "Fritz de Kat", "Diana de Kat"};
        JComboBox<String> list2 = new JComboBox<String>(accounts);
        list2.setFont(font1);
        list2.setBounds(500, 200, 300, 50);
        list2.setBackground(Color.white);
        list2.setEditable(false);
        add(list2);

        JTextField resultField = new JTextField("");
        resultField.setBackground(Color.white);
        resultField.setEditable(false);
        resultField.setBounds(100,300,690,580);
        add(resultField);
    }
}
