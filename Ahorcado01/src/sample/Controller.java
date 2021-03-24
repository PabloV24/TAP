package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.util.Locale;
import java.util.Random;

public class Controller {
    @FXML HBox Contenedor;
    @FXML AnchorPane Padre;
    String[] palabras={"Pelota","Macarrones","Televisor","Pantalla","Cargador","Fotografia","Columpio"};
    TextField[] arrayTxt=null;
    @FXML protected void initialize(){
        Random random=new Random();
        int Aleatoreo=random.nextInt(6);
        String palabra=palabras[Aleatoreo].toLowerCase();
        System.out.println(palabra);
        arrayTxt=new TextField[palabra.length()];
        int ayuda=1;//Letras de ayuda


        for (int x=0;x<palabra.length();x++){
            arrayTxt[x]=new TextField();
            arrayTxt[x].setPrefWidth(50);
            arrayTxt[x].setPrefHeight(50);
            arrayTxt[x].setId("txt-"+x+"-"+palabra.charAt(x));
            arrayTxt[x].setOnKeyReleased(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    TextField textField=(TextField)event.getTarget();
                    String[] nombre=textField.getId().split("-");
                    if (nombre[2].equals(textField.getText().toLowerCase())){
                        System.out.println("CORRECTO "+ textField.getId());
                        textField.setDisable(true);
                    }else{
                        System.out.println("INCORRECTO");
                        textField.setText("");
                        PintaCuerpo();
                    }
                }
            });
            Contenedor.getChildren().add(arrayTxt[x]);
        }
    }
    public void PintaCuerpo(){
        ImageView head=new ImageView(new Image("sample/img/Cabeza.png"));
        head.setFitWidth(70);
        head.setFitHeight(70);
        head.setLayoutX(200);
        head.setLayoutY(250);
        ImageView Body=new ImageView(new Image("sample/img/Cuerpo.png"));
        Body.setFitWidth(70);
        Body.setFitHeight(70);
        Body.setLayoutX(200);
        Body.setLayoutY(320);
        ImageView ManoI=new ImageView(new Image("sample/img/Bizquierdo.png"));
        ManoI.setFitWidth(70);
        ManoI.setFitHeight(70);
        ManoI.setLayoutX(150);
        ManoI.setLayoutY(320);
        ImageView ManoD=new ImageView(new Image("sample/img/Bderecho.png"));
        ManoD.setFitWidth(70);
        ManoD.setFitHeight(70);
        ManoD.setLayoutX(250);
        ManoD.setLayoutY(320);
        ImageView PieI=new ImageView(new Image("sample/img/Pizquierdo.png"));
        PieI.setFitWidth(70);
        PieI.setFitHeight(70);
        PieI.setLayoutX(150);
        PieI.setLayoutY(410);
        ImageView PieD=new ImageView(new Image("sample/img/Pderecho.png"));
        PieD.setFitWidth(70);
        PieD.setFitHeight(70);
        PieD.setLayoutX(250);
        PieD.setLayoutY(410);

        Padre.getChildren().addAll(head,Body,ManoI,ManoD,PieI,PieD);
    }
}
