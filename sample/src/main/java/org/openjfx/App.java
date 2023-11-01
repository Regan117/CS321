package org.openjfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
Scene main, DataEntry, Reviewer, Approver;
    @Override
    public void start(Stage stageMainStage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        //main scene
        var label = new Label("Hello, please select which screen you'd like to interact with.");
        Button dButton = new Button("DataEntry");
        dButton.setOnAction(e -> stageMainStage.setScene(DataEntry));
        Button rButton = new Button("Reviewer");
        rButton.setOnAction(e -> stageMainStage.setScene(Reviewer));
        Button aButton = new Button("Approver");
        aButton.setOnAction(e -> stageMainStage.setScene(Approver));
        VBox layout = new VBox(20);
        layout.getChildren().addAll(label,dButton,rButton,aButton);
        var main = new Scene(layout, 640, 480);

        //Data Entry
        Label label1= new Label("Welcome to Data Entry");
        TextField textFieldNamField = new TextField("Enter your name here");
        Button enterButton = new Button("Enter");
        Button button1= new Button("Go back to selection");
        button1.setOnAction(e -> stageMainStage.setScene(main));
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1,textFieldNamField, enterButton,button1);
        DataEntry = new Scene(layout1, 300, 250);

        //Reviewer
        Label label2= new Label("Welcome to Reviewer");
        Button getNextbutton = new Button("Get next");
        Button button2= new Button("Go back to selection");
        button2.setOnAction(e -> stageMainStage.setScene(main));
        VBox layout2= new VBox(20);
        //layout2.getChildren().addAll(label2,getNextbutton, button2);
        Label label4 = new Label("Full Name: ");
        TextField textfield2 = new TextField();
        HBox hb1 = new HBox(textfield2);
        hb1.setSpacing(10);
        layout2.getChildren().addAll(label2, getNextbutton,button2,label4, hb1);
        Reviewer= new Scene(layout2,300,250);
        

        //Approver
        Petition.main(null);
        Approver ap = new Approver(2);
        Label label3= new Label("Welcome to Approver");
        Label formLabel= new Label("Petition");
        Label nameLabel= new Label("Name: "+(ap.getName()));
        Label DOBLabel= new Label("Date Of Birth: "+( ap.getDOB()));
        Label emailLabel= new Label("Email Address: " +( ap.getEmail()));
        Label cooLabel= new Label("cooLabel: "+( ap.getCountry()));
        Label AnumLabel= new Label("ANumber: " +( ap.getAnum()));


        Button getNextbutton2 = new Button("Get Next:"+ ( ap.getName()));
        Button button3 = new Button("Go back to selection");
        button3.setOnAction(e -> stageMainStage.setScene(main));
        VBox layout3 = new VBox(20);
        layout3.getChildren().addAll(label3,formLabel, nameLabel, DOBLabel, emailLabel, cooLabel,AnumLabel, getNextbutton2,button3);
        Approver= new Scene(layout3,300,250);
        

        stageMainStage.setScene(main);
        stageMainStage.show();
    }

    public static void main(String[] args) {
        launch();
        //Approval newA = new Approval();
        //newA(a);
    }

}