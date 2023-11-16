package org.openjfx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application{
    Petition petition = new Petition();
    WorkFlow wf = new WorkFlow();
    int id = wf.getApproverNext();
    
static Scene main;
Scene DataEntry;
Scene Reviewer;
Scene Approver;
Scene emailScene;
Scene Edit;
Scene DisplayEdit;
Scene noWork;
Scene rej;
boolean avaliable = true;
    @Override
    public void start(Stage stageMainStage) {
        boolean stop = false;
        //
        //
        //Approver
        class Approval{
            public void approveScreen(){
            
                    Approver ap = new Approver(id);
                    Label label3= new Label("Welcome to Approver");
                    Label formLabel= new Label("Petition");
                    Label nameLabel= new Label("Name: "+(ap.getName()));
                    Label DOBLabel= new Label("Date Of Birth: "+( ap.getDOB()));
                    Label emailLabel= new Label("Email Address: " +( ap.getEmail()));
                    Label cooLabel= new Label("Country of Orgin : "+( ap.getCountry()));
                    Label AnumLabel= new Label("ANumber: " +( ap.getAnum()));

                Button approvebutton = new Button("Approve");
                Button rejectbutton = new Button("Reject");

            
                approvebutton.setOnAction(e ->{
                    avaliable = false;
                    approveScreen();
                    wf.StoreFinishedTasks(id, "Aprover");
                    stageMainStage.setScene(emailScene);
                });
                
                rejectbutton.setOnAction(e ->{
                    avaliable = false;
                    approveScreen();
                    wf.sendBack(id);
                    stageMainStage.setScene(rej);

                    //stageMainStage.setScene(main);
                    //start(stageMainStage);
                }
                );
        
                Button selectionButton = new Button("Go back to selection");
                selectionButton.setOnAction(e ->start(stageMainStage));
                //next button
                Button next = new Button("Next");
                next.setOnAction(e->{
                    /*
                    Approver ap2 = new Approver(wf.getApproverNext());
                    nameLabel.setText("Name: "+(ap2.getName()));
                    DOBLabel.setText("Date Of Birth: "+( ap2.getDOB()));
                    emailLabel.setText("Email Address: " +( ap2.getEmail()));
                    cooLabel.setText("Country of Orgin : "+( ap2.getCountry()));
                    AnumLabel.setText("ANumber: " +( ap2.getAnum()));
                    */
                    id = wf.getApproverNext();
                    if(id == -1){
                        avaliable = true;
                        stageMainStage.setScene(noWork);
                    }
                    else{
                        avaliable = true;
                    approveScreen();
                    stageMainStage.setScene(Approver);
                    }
                });
                
        
                VBox layout3 = new VBox(20);
                FlowPane decison = new FlowPane(30,30, approvebutton, rejectbutton);

        
                next.setDisable(true);
            
                FlowPane decison2 = new FlowPane(30,30,selectionButton,next);
                
                if(avaliable == false){
                    decison.setDisable(true);
                    next.setDisable(false);
                    layout3.getChildren().addAll(label3,formLabel, nameLabel, DOBLabel, emailLabel, cooLabel,AnumLabel,decison , decison2);

                }
                else{
                layout3.getChildren().addAll(label3,formLabel, nameLabel, DOBLabel, emailLabel, cooLabel,AnumLabel, decison, decison2);
                }
                layout3.setBackground((new Background(new BackgroundFill(Color.LIGHTSTEELBLUE, CornerRadii.EMPTY, Insets.EMPTY))));

                Approver= new Scene(layout3, 640,480);
        
                //Email
                Label message = new Label("New Message");
                Label to = new Label("To: "+ (ap.getEmail()));
                Label subj = new Label("Subject: Petition for Alien Fiancé(e) and Children");
                Label text = new Label("Hello " + (ap.getName()) + ", \n I'm pleased to inform you that your form has been approved! \n Sincerly, Immigrant Services");
                Button send = new Button("Send");
                send.setOnAction(e ->stageMainStage.setScene(Approver));
                VBox layout4 = new VBox(20);
                layout4.getChildren().addAll(message,to,subj,text,send);
                layout4.setBackground((new Background(new BackgroundFill(Color.LIGHTYELLOW, CornerRadii.EMPTY, Insets.EMPTY))));
                emailScene= new Scene(layout4, 640,480);
            }
        }
        //
        //
        //
        
        
       // while(stop != true){
        //main scene
        var label = new Label("Hello, please select which screen you'd like to interact with.");
        Button dButton = new Button("DataEntry");
        dButton.setOnAction(e -> stageMainStage.setScene(DataEntry));
        Button rButton = new Button("Reviewer");
        rButton.setOnAction(e -> stageMainStage.setScene(Reviewer));
        Button aButton = new Button("Approver");
        aButton.setOnAction(e -> {
            if(id != -1){
                new Approval().approveScreen();
                //approveScreen(id);
                stageMainStage.setScene(Approver);
            }
            else{
                stageMainStage.setScene(noWork);
            }
        });
        Button exit = new Button("Exit");
        exit.setOnAction(e->{
           // stop = true;
           Platform.exit();
           System.exit(0);
        });
        VBox layout = new VBox(20);
        layout.getChildren().addAll(label,dButton,rButton,aButton, exit);
        var main = new Scene(layout, 640, 480);

        //Data Entry
        
    //do{
        Label label1 = new Label("Welcome to Data Entry");
        Label wrong = new Label("Incorrect Input Values");
        wrong.setStyle("-fx-text-fill: red");
        wrong.setVisible(false);
        //ANumber
        Label anumlabel = new Label("Enter Alien Number Below:");
        final TextField aNumData = new TextField();
        aNumData.setPromptText("Enter Alien Number: '123456789'.");
        //Name Fields
        Label namelabel = new Label("Enter Name Below:");
        final TextField firstNameData = new TextField();
        firstNameData.setPromptText("Enter First Name: 'John'.");
        final TextField middleNameData = new TextField();
        middleNameData.setPromptText("Enter Middle Name.");
        //Add Opt out box for middle name
        CheckBox removeMiddle = new CheckBox("No Middle Name");
        removeMiddle.setOnAction(e -> {
            if(removeMiddle.isSelected()){
                middleNameData.setDisable(true);
            } else {
                middleNameData.setDisable(false);
            }
        });
        final TextField lastNameData = new TextField();
        lastNameData.setPromptText("Enter Last Name: 'Doe'.");
        //Date Of Birth
        Label doblabel = new Label("Enter Date of Birth Below:");
        final TextField dobData = new TextField();
        dobData.setPromptText("Enter DOB: 'MM-DD-YYYY'.");
        //Email
        Label emaillabel = new Label("Enter E-mail Below:");
        final TextField emailData = new TextField();
        emailData.setPromptText("Enter E-mail: 'johndoe@aol.com'.");
        //Country of Origin List
        Label countrylabel = new Label("Select Country Below:");
        ChoiceBox<String> countryBox = new ChoiceBox<>();
        countryBox.getItems().addAll("Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua & Deps", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Central African Rep", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo", "Congo {Democratic Rep}", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland {Republic}", "Israel", "Italy", "Ivory Coast", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea North", "Korea South", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar, {Burma}", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russian Federation", "Rwanda", "St Kitts & Nevis", "St Lucia", "Saint Vincent & the Grenadines", "Samoa", "San Marino", "Sao Tome & Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad & Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe");
        countryBox.setValue("Null");
        //Buttons
        Button saveDataButton = new Button("Submit");
        saveDataButton.setOnAction(e -> {
            int anum = Integer.parseInt(aNumData.getText());
            petition.setAnum(anum);
            String fullName = firstNameData.getText() + "" + middleNameData.getText() + "" + lastNameData.getText();
            petition.setName(fullName);
            petition.setDOB(dobData.getText());
            petition.setEmail(emailData.getText());
            petition.setCountry(countryBox.getValue());
            petition.setiD(wf.getUniqueID());
            petition.displayPetition();
            if(petition.validateEntry() == false || petition.searchDB(petition) == true){
                stageMainStage.setScene(DataEntry);
                wrong.setVisible(true);
                System.out.println("Petition Exists or Failed to Validate");
            } else {
                petition.writeToDB();
                wf.StoreFinishedTasks(petition.getiD(), "Review");
                if(id == -1){
                    id = wf.getApproverNext();
                }
                stageMainStage.setScene(main);
                wrong.setVisible(false);
                aNumData.clear();
                firstNameData.clear();
                middleNameData.clear();
                lastNameData.clear();
                dobData.clear();
                emailData.clear();
                countryBox.setValue("Null");
                System.out.println("Petition Doesn't Exist and Succeeded Validation");
            }
        });
        Button button1= new Button("Go back to selection");
        button1.setOnAction(e -> stageMainStage.setScene(main));
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, wrong, anumlabel, aNumData, namelabel, firstNameData, middleNameData, removeMiddle, lastNameData, doblabel, dobData, emaillabel, emailData, countrylabel, countryBox, saveDataButton, button1);
        DataEntry = new Scene(layout1, 300, 800);
    //}while((petition.validateEntry() == false) && (petition.searchDB(petition) == true));
    //petition.writeToDB();




    //Reviewer
    Petition.main(null);
    Review r = new Review();
        //Reviewer
        Label label2= new Label("Welcome to Reviewer");
        //Label personName = new Label("Name: Tariq");
        //Button getNextbutton = new Button("Get next");
        //Review review = new Review(1);
        Button button2= new Button("Go back to selection");
        button2.setOnAction(e -> stageMainStage.setScene(main));
        VBox layout2= new VBox(20);
        VBox editLayout= new VBox(20);

        //layout2.getChildren().addAll(label2,getNextbutton, button2);
        Label personName = new Label("Full Name: "+r.getName() );
        Label personDob = new Label("Date of Birth: 08-22-1965"+r.getDOB());
        Label personCountry = new Label ("Country of Birth: "+r.getCountry());
        Label personAnum = new Label("ANumber: " + r.getAnum());
        Label emaiLabel = new Label("Email: " + r.getEmail());
        Button editButton= new Button("Edit");
        editButton.setOnAction(e -> stageMainStage.setScene(Edit));
        layout2.getChildren().addAll(label2,personName,personDob,emaiLabel,personCountry,personAnum, editButton,button2);
        Reviewer= new Scene(layout2,640,480);



        Label anuml = new Label("Alien Number Below:");
        String anumInString = Integer.toString(r.getAnum());
        final TextField anumVal = new TextField(anumInString);
        //Name Fields
        Label namel = new Label("Enter Name Below:");
        final TextField firstName = new TextField(r.getName());
        firstNameData.setPromptText("Enter First Name: ");
        //Date Of Birth
        Label dobl = new Label("Enter Date of Birth Below:");
        final TextField dobT = new TextField(r.getDOB());
        dobT.setPromptText("Enter DOB: 'MM-DD-YYYY'.");
        //Email
        Label emailn = new Label("Enter E-mail Below:");
        final TextField emailT = new TextField(r.getEmail());
        emailT.setPromptText("Enter E-mail: 'johndoe@aol.com'.");
        //Country of Origin List
        Label countryTLabel = new Label("Select Country Below:");
        ChoiceBox<String> countryT = new ChoiceBox<>();
        countryT.getItems().addAll("Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua & Deps", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Central African Rep", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo", "Congo {Democratic Rep}", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland {Republic}", "Israel", "Italy", "Ivory Coast", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea North", "Korea South", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar, {Burma}", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russian Federation", "Rwanda", "St Kitts & Nevis", "St Lucia", "Saint Vincent & the Grenadines", "Samoa", "San Marino", "Sao Tome & Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad & Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe");
        countryT.setValue("Null");
        Button saveEdit = new Button("Save");
        saveEdit.setOnAction(e -> {
            Petition toSave = new Petition();
            toSave.setName(firstName.getText());
            toSave.setDOB(dobT.getText());
            toSave.setEmail(emailT.getText());
            toSave.setCountry(countryT.getValue());
            //if(toSave.validateEntry()==false){
            //    System.err.println("Invalid Input");
            //}else{
            toSave.writeToDB();
            stageMainStage.setScene(main);
            //}

        });
        editLayout.getChildren().addAll(anuml, anumVal, namel, firstName, dobl, dobT, emailn,emailT, countryTLabel, countryT, saveEdit);
        
        Edit= new Scene(editLayout, 640,480);
        

        
        
        
        //noWork
        Label message = new Label("Sorry, there is no work at the momment.\nPlease check back later.");
        message.setFont(new Font("Arial", 20));
        Button back = new Button("Return to Selection");
        back.setOnAction(e ->stageMainStage.setScene(main));
        VBox layout4 = new VBox(20);
        layout4.getChildren().addAll(message, back);
        layout4.setBackground((new Background(new BackgroundFill(Color.LIGHTSTEELBLUE, CornerRadii.EMPTY, Insets.EMPTY))));
        noWork= new Scene(layout4, 640,480);
        //reject 
        Label notice = new Label("The form has been rejected.");
        notice.setFont(new Font("Arial", 20));
        Button returnA = new Button("Return to Approval");
        
        returnA.setOnAction(e ->stageMainStage.setScene(Approver));
        VBox layoutrej = new VBox(20);
        layoutrej.getChildren().addAll(notice, returnA);
        layoutrej.setBackground((new Background(new BackgroundFill(Color.LIGHTYELLOW, CornerRadii.EMPTY, Insets.EMPTY))));
        rej= new Scene(layoutrej, 640,480);
        //}
        stageMainStage.setScene(main);
        stageMainStage.show();

    
    }


    /*public Scene returnScene(Scene toBeReturned){
        return toBeReturned;
    }*/
    public static void main(String[] args) {
        launch();
        //Approval newA = new Approval();
        //newA(a);
    }

}