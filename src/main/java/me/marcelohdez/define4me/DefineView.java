package me.marcelohdez.define4me;

import javax.swing.*;
import java.awt.*;

public class DefineView extends JFrame {
    private final JTabbedPane tabbedPane = new JTabbedPane();
    private final JList<String> listOfWords;
    private final JTextArea textArea = new JTextArea("No words have been defined");
    private final JButton pasteButton = new JButton("Paste");
    private final JButton defineButton = new JButton("Define");

    public DefineView(DefaultListModel<String> model) {
        listOfWords = new JList<>(model);
        textArea.setEditable(false);
        textArea.setLineWrap(true);

        setTitle("Define4Me");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        var buttonRow = new JPanel();
        buttonRow.add(pasteButton);
        buttonRow.add(defineButton);

        tabbedPane.addTab("Words", new JScrollPane(listOfWords));
        tabbedPane.addTab("Definitions", new JScrollPane(textArea));

        add(tabbedPane, BorderLayout.CENTER);
        add(buttonRow, BorderLayout.SOUTH);
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public JList<String> getListOfWords() {
        return listOfWords;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public JButton getPasteButton() {
        return pasteButton;
    }

    public JButton getDefineButton() {
        return defineButton;
    }
}
