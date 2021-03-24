package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Controller {
    @FXML Canvas Lienzo;
    GraphicsContext context;
    @FXML ColorPicker colorPicker;
    Color colorPincel=Color.BLACK;
    @FXML Slider slider;
    @FXML ComboBox Opciones;
    @FXML protected void initialize(){
        context=Lienzo.getGraphicsContext2D();
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                pintarDibujos(newValue.intValue());
            }
        });

        Opciones.getItems().addAll("Cuadricula","Ajedrez","Estrella","Estrella Doble");

        /*context.setFill(Color.RED);
        context.fillRect(10,20,100,50);
        context.rect(200,150,200,100);*/
    }
    public void pintarDibujos(int valor){
        context.setFill(Color.WHITESMOKE);
        context.fillRect(0,0,Lienzo.getWidth(),Lienzo.getHeight());
        context.setFill(colorPincel);
        System.out.println(valor);
        if (Opciones.getSelectionModel().getSelectedIndex() == 0){
            //Cuadricula
            for (int x=0;x<valor;x++){
                int divisiones=(int) Lienzo.getWidth()/valor;
                context.strokeLine(0,divisiones*x,Lienzo.getWidth(),divisiones*x); // horizontal
                context.strokeLine(divisiones*x,Lienzo.getWidth(),divisiones*x,0); //Vertical
            }
        }else if (Opciones.getSelectionModel().getSelectedIndex()==1){
            //Ajedrez
        }else if (Opciones.getSelectionModel().getSelectedIndex()==2){
            //Estrella
            int mitadAncho=((int) Lienzo.getWidth())/2;
            int mitadAlto=((int) Lienzo.getHeight())/2;
            context.strokeLine(mitadAncho,0,mitadAlto,Lienzo.getHeight());
            context.strokeLine(0,mitadAlto,Lienzo.getWidth(),mitadAlto);
            int divi=mitadAncho/valor;
            for (int j=1;j<valor+1;j++){
                context.strokeLine(mitadAncho,divi*j,mitadAncho+(divi*j),mitadAlto);
                context.strokeLine(mitadAlto,mitadAncho+(divi*j),mitadAncho,divi*j);
                context.strokeLine(mitadAlto,mitadAncho+(divi*j),divi*j,mitadAncho);
                context.strokeLine(mitadAlto,mitadAncho-(divi*j),divi*j,mitadAncho);
            }
        }else if (Opciones.getSelectionModel().getSelectedIndex()==3){
            //Estrella Doble
        }
    }
    public void CambiarColor(ActionEvent event){
        colorPincel=colorPicker.getValue();
    }
    public void Borrar(ActionEvent event){
        context.setFill(Color.WHITESMOKE);
        context.fillRect(0,0,Lienzo.getWidth(),Lienzo.getHeight());
    }
    public void Arrastrar(MouseEvent event){
        context.setStroke(colorPincel);
        context.fillOval(event.getX(),event.getY(),10,10);
    }
}
