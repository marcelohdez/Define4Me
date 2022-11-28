package me.marcelohdez.define4me;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.net.URL;

public class DefineController {
    private static final String API_URL = "https://api.dictionaryapi.dev/api/v2/entries/en/";

    private final DefineModel model;
    private final DefineView view;

    public DefineController(DefineModel model, DefineView view) {
        this.model = model;
        this.view = view;

        view.getPasteButton().addActionListener(e -> pasteWords());
        view.getDefineButton().addActionListener(e -> defineWords());
    }

    public void initialize() {
        view.pack(); // Make all elements fit perfectly
        view.setLocationRelativeTo(null); // Place window in center of screen
        view.setVisible(true);
    }

    private void defineWords() {
        var sb = new StringBuilder();

        // Define each word and add to sb as separate lines in the format "WORD - DEFINITION"
        for (int i = 0; i < model.getListModel().size(); i++) {
            var word = model.getListModel().get(i);

            sb.append(word).append(" - ").append(getDefinitionOf(word));
            if (i + 1 < model.getListModel().size()) sb.append('\n');
        }

        view.getTextArea().setText(sb.toString());
        view.getTabbedPane().setSelectedIndex(1); // Switch to definitions tab
    }

    private String getDefinitionOf(String word) {
        try {
            var url = new URL(API_URL + word);
            var json = new ObjectMapper();
            var def = json.readTree(url).get(0).get("meanings").get(0).get("definitions").get(0).get("definition").toString();
            return def.substring(1, def.length() - 1); // Get rid of "s
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "No definition found!"; // Default value if request times out or the json parsing fails
    }

    private void pasteWords() {
        try {
            var pastedText = Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor).toString();
            var words = pastedText.lines().toList();

            model.getListModel().clear(); // Clear list before pasting new words
            model.getListModel().addAll(words);
            view.getTabbedPane().setSelectedIndex(0); // Switch to words tab
        } catch (UnsupportedFlavorException | IOException e) {
            System.out.println("Could not paste from clipboard!");
        }
    }
}
