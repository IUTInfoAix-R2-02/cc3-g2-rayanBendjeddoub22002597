package fr.amu.iut.cc3;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ToileController implements Initializable {

    private static int rayonCercleExterieur = 200;
    private static int angleEnDegre = 60;
    private static int angleDepart = 90;
    private static int noteMaximale = 20;

    private Circle pointComp1 = new Circle();
    private Circle pointComp2 = new Circle();
    private Circle pointComp3 = new Circle();
    private Circle pointComp4 = new Circle();
    private Circle pointComp5 = new Circle();
    private Circle pointComp6 = new Circle();

    @FXML
    private TextField comp1;
    @FXML
    private TextField comp2;
    @FXML
    private TextField comp3;
    @FXML
    private TextField comp4;
    @FXML
    private TextField comp5;
    @FXML
    private TextField comp6;
    @FXML
    private Button tracer;
    @FXML
    private Button vider;
    @FXML
    private Pane toile;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        toile.getChildren().add(pointComp1);
        toile.getChildren().add(pointComp2);
        toile.getChildren().add(pointComp3);
        toile.getChildren().add(pointComp4);
        toile.getChildren().add(pointComp5);
        toile.getChildren().add(pointComp6);
    }

    int getXRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur + Math.cos(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }

    int getYRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur - Math.sin(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }

    public void ajoutPoint(){
        if (!comp1.getText().isEmpty()) {
            pointComp1.setCenterX(getXRadarChart(Double.parseDouble(comp1.getText()), 1));
            pointComp1.setCenterY(getYRadarChart(Double.parseDouble(comp1.getText()), 1));
            pointComp1.setRadius(5);
        }
        if (!comp2.getText().isEmpty()) {
            pointComp2.setCenterX(getXRadarChart(Double.parseDouble(comp2.getText()), 2));
            pointComp2.setCenterY(getYRadarChart(Double.parseDouble(comp2.getText()), 2));
            pointComp2.setRadius(5);
        }
        if (!comp3.getText().isEmpty()) {
            pointComp3.setCenterX(getXRadarChart(Double.parseDouble(comp3.getText()), 3));
            pointComp3.setCenterY(getYRadarChart(Double.parseDouble(comp3.getText()), 3));
            pointComp3.setRadius(5);
        }
        if (!comp4.getText().isEmpty()) {
            pointComp4.setCenterX(getXRadarChart(Double.parseDouble(comp4.getText()), 4));
            pointComp4.setCenterY(getYRadarChart(Double.parseDouble(comp4.getText()), 4));
            pointComp4.setRadius(5);
        }
        if (!comp5.getText().isEmpty()) {
            pointComp5.setCenterX(getXRadarChart(Double.parseDouble(comp5.getText()), 5));
            pointComp5.setCenterY(getYRadarChart(Double.parseDouble(comp5.getText()), 5));
            pointComp5.setRadius(5);
        }
        if (!comp6.getText().isEmpty()) {
            pointComp6.setCenterX(getXRadarChart(Double.parseDouble(comp6.getText()), 6));
            pointComp6.setCenterY(getYRadarChart(Double.parseDouble(comp6.getText()), 6));
            pointComp6.setRadius(5);
        }

    }



}
