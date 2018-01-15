package TableModel;

import Information.Aflevering;

import javax.swing.table.AbstractTableModel;
import java.util.List;


public class EpisodeTableModel extends AbstractTableModel {

    private static final int SERIE_COL = 0;
    private static final int SEASON_COL = 1;
    private static final int AGO_COL = 2;
    private static final int LANGUAGE_COL = 3;
    private static final int GENRE_COL = 4;

    private String[] columnNames = { "Serie", "Seizoen", "Leeftijd", "Taal", "Genre", "LijktEenBeetjeOp"};
    private List<Aflevering> aflevering;

    public EpisodeTableModel(List<Aflevering> theSeries){
        aflevering = theSeries;
    }

    @Override
    public int getColumnCount(){
        return columnNames.length;
    }

    @Override
    public int getRowCount(){
        return aflevering.size();
    }

    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col){

        Aflevering tempMovie = aflevering.get(row);

        switch (col) {
            case SERIE_COL:
                return tempMovie.getShow();
            case SEASON_COL:
                return tempMovie.getSeason();
            case AGO_COL:
                return tempMovie.getId();
            case LANGUAGE_COL:
                return tempMovie.getLength();
            case GENRE_COL:
                return tempMovie.getTitle();
            default:
                return tempMovie.getShow();
        }
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
