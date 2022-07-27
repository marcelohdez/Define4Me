package me.marcelohdez.define4me;

import javax.swing.*;

public class Define4Me {
    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Could not set look and feel!");
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        setLookAndFeel();

        var model = new DefineModel();
        var view = new DefineView(model.getListModel());

        new DefineController(model, view).initialize();
    }
}
