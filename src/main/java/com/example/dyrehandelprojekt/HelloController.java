package com.example.dyrehandelprojekt;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class HelloController {

    @FXML
    private  ListView vareNrBeskriv = new ListView<>();
    @FXML
    private ListView ordreList = new ListView<>();
    @FXML
    private  ListView vare = new ListView<>();
    @FXML
    private TextField vareBeskrivInput;
    @FXML
    private TextField varenrInput;

    @FXML
    private Button tilføjTilOrdre;
    @FXML
    private Button slet;

    @FXML
    void visVarer(MouseEvent event) {
        vare.getItems().clear();
        System.out.println(ordreList.getSelectionModel().getSelectedItem());
        Ordre valgtordre = (Ordre) ordreList.getSelectionModel().getSelectedItem();
        System.out.println(valgtordre.getVareList());
        for (Vare v : valgtordre.getVareList())
            vare.getItems().add(v);

    }
// Print out item from vareNrBesriv when clicked on.
    @FXML
    void valgVare(MouseEvent event) {
        Vare valgtVare = (Vare) vareNrBeskriv.getSelectionModel().getSelectedItem();
    }

// Cick on "Tilføj til ordre" button must get selected vare (in vareNrBeskriv) and add
// it to selected order (in ordreList) not just to the listView vare in scenebuilder.
    @FXML
    void tilføjTilOrdre(ActionEvent event) {
        try {
            vare.getItems().add(vareNrBeskriv.getSelectionModel().getSelectedItem());
            Ordre valgtordre = (Ordre) ordreList.getSelectionModel().getSelectedItem();
            Vare vare = (Vare) vareNrBeskriv.getSelectionModel().getSelectedItem();
            valgtordre.addVare(vare);
        } catch (Exception e) {
            System.out.println("Noget gik galt, tjek om der er insat et valid nr");
        }
    }
    //Slet button removes an item from a selected order. ***But does not remove original
    // order's items, only newly added ones.***
    @FXML
    void sletVareFraOrdre(ActionEvent event) {
       Ordre valgtordre = (Ordre) ordreList.getSelectionModel().getSelectedItem();
       System.out.println("Valgtordr="+valgtordre);
        Vare valgtvare = (Vare)vare.getSelectionModel().getSelectedItem();
        System.out.println("Valgtvare=" +valgtvare);
        valgtordre.removeVare(valgtvare);
        vare.getItems().remove(vare.getSelectionModel().getSelectedItem());
    }

    @FXML
    void onHelloButtonClick(MouseEvent event) {
    }

    @FXML
    private Label welcomeText;

    @FXML
    void tilføjVare(ActionEvent event) {
        try {
            Vare vare = new Vare(Integer.parseInt(varenrInput.getText()), " " + vareBeskrivInput.getText());
            vareNrBeskriv.getItems().add(vare);
            vareNrBeskriv.scrollTo(vareNrBeskriv.getItems().size() - 1);

        } catch (Exception e) {
            System.out.println("Noget gik galt, tjek om der er insat et valid nr");
        }
        varenrInput.clear();
        vareBeskrivInput.clear();
        }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void initialize() {

        Ordre ordre1 = new Ordre(100, " Green, Joe ", 1732022);
        Ordre ordre2 = new Ordre(101, " Blue, Sam ", 1732022);
        Ordre ordre3 = new Ordre(102, " Red, Jane ", 1732022);
        Ordre ordre4 = new Ordre(103, " Black, Kim ", 1732022);
        Ordre ordre5 = new Ordre(104, " Brown, Jack ", 1732022);

        ordreList.getItems().add(ordre1);
        ordreList.getItems().add(ordre2);
        ordreList.getItems().add(ordre3);
        ordreList.getItems().add(ordre4);
        ordreList.getItems().add(ordre5);

        Vare v1 = new Vare(1200, " Hunde mad");
        Vare v2 = new Vare(1205, " Hunde krave");
        Vare v3 = new Vare(1209, " Tygge legetøj");
        Vare v4 = new Vare(1300, " Katte mad");
        Vare v5 = new Vare(1340, " Kradsetræ");
        Vare v6 = new Vare(1355, " Katte snor");
        Vare v7 = new Vare(1400, " Fugle mad");
        Vare v8 = new Vare(1460, " Fugle bur");
        Vare v9 = new Vare(1500, " Fiske mad");
        Vare v10 = new Vare(1599, " Akvarium");

        //Eksperiment... man an putte hele objekter på listen, bare de har toString()-metode
        //Vare v = new Vare(1300, "bbb");
        vareNrBeskriv.getItems().add(v1);
        vareNrBeskriv.getItems().add(v2);
        vareNrBeskriv.getItems().add(v3);
        vareNrBeskriv.getItems().add(v4);
        vareNrBeskriv.getItems().add(v5);
        vareNrBeskriv.getItems().add(v6);
        vareNrBeskriv.getItems().add(v7);
        vareNrBeskriv.getItems().add(v8);
        vareNrBeskriv.getItems().add(v9);
        vareNrBeskriv.getItems().add(v10);

        ordre1.addVare(v6);
        ordre1.addVare(v5);
        ordre2.addVare(v9);
        ordre2.addVare(v10);
        ordre3.addVare(v4);
        ordre3.addVare(v8);
        ordre3.addVare(v3);
        ordre4.addVare(v7);
        ordre4.addVare(v2);
        ordre5.addVare(v1);
   }


    //Eksempel på enkel modal dialog med to felter
    @FXML
    public void dialogKnap(ActionEvent e) {
        // Dialogen defineres med "ButtonTyes", hvilket betyder at vi kan bestemmer at
        // dialogen afsluttes med at vi tester på knapperne
        Dialog<ButtonType> dialog = new Dialog();

        // Her sættes vinduet op
        dialog.setTitle("Eksempel på dialog");
        dialog.setHeaderText("Her kan stå noget tekst");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        TextField felt1 = new TextField();
        TextField felt2 = new TextField();
        VBox box = new VBox(felt1, felt2);
        dialog.getDialogPane().setContent(box);

        // Her afsluttes dialogen med at man kan trykke på OK
        Optional<ButtonType> knap = dialog.showAndWait();
        // Derefter kan vi henter felternes indhold ud og gøre hvad der skal gøres...
        if (knap.get() == ButtonType.OK)
            System.out.println("Felt1 = " + felt1.getText() + " felt2 = " + felt2.getText());
    }

}