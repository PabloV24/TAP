package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.util.Random;

public class Controller {
    @FXML HBox Contenedor;
    @FXML AnchorPane Padre;
    String[] palabras={"Pelota","Macarrones","Televisor","Pantalla","Cargador","Fotografia","Columpio"};
    @FXML protected void initialize(){
        Random random=new Random();
        int Aleatoreo=random.nextInt(6);
        String palabra=palabras[Aleatoreo];
        System.out.println(palabra);
        int ayuda=1;//Letras de ayuda
        PintaCuerpo();

        for (int x=0;x<palabra.length();x++){
            TextField txt1=new TextField();
            txt1.setPrefWidth(50);
            txt1.setPrefHeight(50);
            Contenedor.getChildren().add(txt1);
        }
    }
    public void PintaCuerpo(){

    }
}
