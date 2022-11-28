package me.marcelohdez.define4me;

import javax.swing.*;

public class DefineModel {
    // Model that holds the words we want to define
    private final DefaultListModel<String> listModel = new DefaultListModel<>();

    public DefaultListModel<String> getListModel() {
        return listModel;
    }
}
