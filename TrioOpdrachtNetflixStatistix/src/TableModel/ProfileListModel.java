package TableModel;

import Information.Profile;

import javax.swing.*;
import java.util.List;

public class ProfileListModel extends AbstractListModel {
    private final List<Profile> list;

    public ProfileListModel(List<Profile> list) {
        this.list = list;
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Object getElementAt(int index) {
        return list.get(index);
    }

}