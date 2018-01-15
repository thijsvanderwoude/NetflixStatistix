package TableModel;

import Information.Profile;

import javax.swing.table.AbstractTableModel;
import java.util.List;


public class ProfileTableModel extends AbstractTableModel {

    private static final int NAME_COL = 0;
    private static final int BIRTHDATE_COL = 1;
    private static final int ID_COL = 2;


    private String[] columnNames = { "Abonneenummer", "Profielnaam", "Geboortedatum"};
    private List<Profile> profiel;

    public ProfileTableModel(List<Profile> theAflevering){
        profiel = theAflevering;
    }

    @Override
    public int getColumnCount(){
        return columnNames.length;
    }

    @Override
    public int getRowCount(){
        return profiel.size();
    }

    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col){

        Profile tempMovie = profiel.get(row);

        switch (col) {
            case NAME_COL:
                return tempMovie.getName();
            case BIRTHDATE_COL:
                return tempMovie.getBirthDate();
            case ID_COL:
                return tempMovie.getMemberNumber();
            default:
                return tempMovie.getName();
        }
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
