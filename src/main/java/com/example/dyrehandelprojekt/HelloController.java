package com.example.dyrehandelprojekt;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

//import java.lang.Math;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class HelloController {

   /* @FXML
    private Button tilføjButton;
*/
    @FXML
    private Button tilføjOrdreButton;

    @FXML
    void visVarer(MouseEvent event) {
        System.out.println(ordreList.getSelectionModel().getSelectedItem());
        Ordre valgtordre = (Ordre) ordreList.getSelectionModel().getSelectedItem();
        System.out.println(valgtordre.getVareList());
        for (Vare v : valgtordre.getVareList())
            vare.getItems().add(v);
    }

    @FXML
    void onHelloButtonClick(MouseEvent event) {

    }

    @FXML
    void tilføjOrdre(ActionEvent event) {

    }

    @FXML
    private Label welcomeText;

    @FXML
    private  ListView vareNrBeskriv = new ListView<>();
    @FXML
    private ListView ordreList = new ListView<>();
    @FXML
    private  ListView vare = new ListView<>();


    // Vi sætter en knap mere på, som tilføjer tilfældige frugter
    //Button tilføjButton = new Button("Tilføj vare");
    @FXML
    void tilføjVare(ActionEvent event){

        String flereVare[] = {"Måge mad", "Lort poser", "Fugle snore"};
        vare.getItems().add(flereVare[(int)(Math.random()*flereVare.length)]);
        // Scroll til sidste frugt på listen, så man kan se den er tilføjet
        vare.scrollTo(vare.getItems().size()-1);
    }


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void initialize() {

        Ordre ordre1 = new Ordre(100, "Green, Joe", 1732022);
        Ordre ordre2 = new Ordre(101, "Blue, Sam", 1732022);
        Ordre ordre3 = new Ordre(102, "Red, Jane", 1732022);
        Ordre ordre4 = new Ordre(103, "Black, Kim", 1732022);
        Ordre ordre5 = new Ordre(104, "Brown, Jack", 1732022);

        ordreList.getItems().add(ordre1);
        ordreList.getItems().add(ordre2);
        ordreList.getItems().add(ordre3);
        ordreList.getItems().add(ordre4);
        ordreList.getItems().add(ordre5);




        Vare v1 = new Vare(1200, "Hunde mad");
        Vare v2 = new Vare(1205, "Hunde krave");
        Vare v3 = new Vare(1209, "Tygge legetøj");
        Vare v4 = new Vare(1300, "Katte mad");
        Vare v5 = new Vare(1340, "Kradsetræ");
        Vare v6 = new Vare(1355, "Katte snor");
        Vare v7 = new Vare(1400, "Fugle mad");
        Vare v8 = new Vare(1460, "Fugle bur");
        Vare v9 = new Vare(1500, "Fiske mad");
        Vare v10 = new Vare(1599, "Akvarium");

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

}