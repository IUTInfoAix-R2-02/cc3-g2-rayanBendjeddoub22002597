package fr.amu.iut.cc3;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
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
    private double valeurComp1 = 0;
    private double valeurComp2 = 0;
    private double valeurComp3;
    private double valeurComp4;
    private double valeurComp5;
    private double valeurComp6;

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
    private Label labelErreur;
    @FXML
    private Button tracer;
    @FXML
    private Button vider;
    @FXML
    private Pane toile;
    private ArrayList<Line> tabLigne = new ArrayList<Line>();
    private ArrayList<Circle> tabPoint = new ArrayList<Circle>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Initialisation..");
        comp1.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!comp1.getText().isEmpty()) {
                    valeurComp1 = Double.parseDouble(comp1.getText());
                    if(valeurComp1 < 0 || valeurComp1 > noteMaximale){
                        labelErreur.setText("Erreur de saisie :\nLes valeurs doivent être entre 0 et 20");
                    } else {
                        pointComp1.setCenterX(getXRadarChart(valeurComp1, 1));
                        pointComp1.setCenterY(getYRadarChart(valeurComp1, 1));
                        pointComp1.setRadius(5);
                        labelErreur.setText("");
                    }
                }
            }
        });

        comp1.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

            }
        });

        comp2.setOnKeyReleased(event -> {
            if(event.getCode() == KeyCode.ENTER){
                if (!comp2.getText().isEmpty()) {
                    valeurComp2 = Double.parseDouble(comp2.getText());
                    if(valeurComp2 < 0 || valeurComp2 > noteMaximale){
                        labelErreur.setText("Erreur de saisie :\nLes valeurs doivent être entre 0 et 20");
                    } else {
                        pointComp2.setCenterX(getXRadarChart(valeurComp2, 2));
                        pointComp2.setCenterY(getYRadarChart(valeurComp2, 2));
                        pointComp2.setRadius(5);
                        labelErreur.setText("");
                    }
                }
            }
        });
        comp3.setOnKeyReleased(event -> {
            if(event.getCode() == KeyCode.ENTER){
                if (!comp3.getText().isEmpty()) {
                    valeurComp3 = Double.parseDouble(comp3.getText());
                    if(valeurComp3 < 0 || valeurComp3 > noteMaximale){
                        labelErreur.setText("Erreur de saisie :\nLes valeurs doivent être entre 0 et 20");
                    } else {
                        pointComp3.setCenterX(getXRadarChart(valeurComp3, 3));
                        pointComp3.setCenterY(getYRadarChart(valeurComp3, 3));
                        pointComp3.setRadius(5);
                        labelErreur.setText("");
                    }
                }
            }
        });
        comp4.setOnKeyReleased(event -> {
            if(event.getCode() == KeyCode.ENTER){
                if (!comp4.getText().isEmpty()) {
                    valeurComp4 = Double.parseDouble(comp4.getText());
                    if(valeurComp4 < 0 || valeurComp4 > noteMaximale){
                        labelErreur.setText("Erreur de saisie :\nLes valeurs doivent être entre 0 et 20");
                    } else {
                        pointComp4.setCenterX(getXRadarChart(valeurComp4, 4));
                        pointComp4.setCenterY(getYRadarChart(valeurComp4, 4));
                        pointComp4.setRadius(5);
                        labelErreur.setText("");
                    }
                }
            }
        });
        comp5.setOnKeyReleased(event -> {
            if(event.getCode() == KeyCode.ENTER){
                if (!comp5.getText().isEmpty()) {
                    valeurComp5 = Double.parseDouble(comp5.getText());
                    if(valeurComp5 < 0 || valeurComp5 > noteMaximale){
                        labelErreur.setText("Erreur de saisie :\nLes valeurs doivent être entre 0 et 20");
                    } else {
                        pointComp5.setCenterX(getXRadarChart(valeurComp5, 5));
                        pointComp5.setCenterY(getYRadarChart(valeurComp5, 5));
                        pointComp5.setRadius(5);
                        labelErreur.setText("");
                    }
                }
            }
        });
        comp6.setOnKeyReleased(event -> {
            if(event.getCode() == KeyCode.ENTER){
                if (!comp6.getText().isEmpty()) {
                    valeurComp6 = Double.parseDouble(comp6.getText());
                    if(valeurComp6 < 0 || valeurComp6 > noteMaximale){
                        labelErreur.setText("Erreur de saisie :\nLes valeurs doivent être entre 0 et 20");
                    } else {
                        pointComp6.setCenterX(getXRadarChart(valeurComp6, 6));
                        pointComp6.setCenterY(getYRadarChart(valeurComp6, 6));
                        pointComp6.setRadius(5);
                        labelErreur.setText("");
                    }
                }
            }
        });
        toile.getChildren().add(pointComp1);
        toile.getChildren().add(pointComp2);
        toile.getChildren().add(pointComp3);
        toile.getChildren().add(pointComp4);
        toile.getChildren().add(pointComp5);
        toile.getChildren().add(pointComp6);
        labelErreur.setStyle("-fx-text-fill: red");
        labelErreur.setText("");
    }

    int getXRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur + Math.cos(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }

    int getYRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur - Math.sin(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }

    public void vider() {
        pointComp1.setCenterX(getXRadarChart(0, 0));
        pointComp1.setCenterY(getYRadarChart(0, 0));
        pointComp2.setCenterX(getXRadarChart(0, 0));
        pointComp2.setCenterY(getYRadarChart(0, 0));
        pointComp3.setCenterX(getXRadarChart(0, 0));
        pointComp3.setCenterY(getYRadarChart(0, 0));
        pointComp4.setCenterX(getXRadarChart(0, 0));
        pointComp4.setCenterY(getYRadarChart(0, 0));
        pointComp5.setCenterX(getXRadarChart(0, 0));
        pointComp5.setCenterY(getYRadarChart(0, 0));
        pointComp6.setCenterX(getXRadarChart(0, 0));
        pointComp6.setCenterY(getYRadarChart(0, 0));
        for(int i = 0; i < toile.getChildren().size(); ++i){
            if(toile.getChildren().get(i) instanceof Line){
                toile.getChildren().remove(i);
            }
        }
        tabLigne.clear();
        tabPoint.clear();
    }

    public void tracer() {
        for(int i = 0; i < toile.getChildren().size(); ++i){
            tabPoint.add((Circle) toile.getChildren().get(i));
        }
        for(int i = 0; i < tabPoint.size() - 1; ++i){
            tabLigne.add(new Line(tabPoint.get(i).getCenterX(), tabPoint.get(i).getCenterY(), tabPoint.get(i+1).getCenterX(), tabPoint.get(i+1).getCenterY()));
        }
        for(int i = 0; i < tabLigne.size(); ++i){
            toile.getChildren().add(tabLigne.get(i));
        }
    }

}
