/*
 * Author: Brock A. Allton
 * Purpose: Setup a GUI interface for a database to be used to track Airmen assigned
 *          to a work area
 */
package javafxairmandatabase;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;


public class JavaFXAirmanDatabase extends Application {
    
    private Stage stage;
    private Label insertLabel, searchLabel, lastNameLbl, firstNameLbl, insRankLbl,
            insDateArrivedLbl, insSectionAssignLbl, insEPR_DateLbl;
    private Button introInsertBtn, searchBtn, exitBtn, insSubmitBtn;
    private Text introHeading, insertHeading;
    private TextField lastNameField, firstNameField;
    private Scene introScene, insertScene;
    private HBox introTopPane, introInsertPane, introSearchPane, introExitPane, 
            insertTopPane, insLastNamePane, insFirstNamePane, insRankPane, 
            insDateArrivedPane, insSectionAssignedPane, insEPR_DatePane, 
            insSubmitBtnPane, insChoicePane;
    private VBox introSelectPane, insertInfoPane;
    private BorderPane mainPane, insertPane;
    private ChoiceBox rankBox, sectionBox;
    private DatePicker dateArrivedPick, EPR_DatePick;
    
    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        
        //------Setup the Intro screen that will display when started-----------
        
        //Create top pane for the introduction screen, add to HBox
        introHeading = new Text("Welcome To the Airman's Database");
        introHeading.setFont(Font.font("Verdana",FontWeight.BOLD, 15));//set the font size, set bold, and set as Verdana
        introHeading.setFill(Color.BLUE);
        introTopPane = new HBox(introHeading);//Create top pane and add intro
                                                   //heading
        introTopPane.setAlignment(Pos.CENTER);//Center the text
        introTopPane.setPadding(new Insets(20,10,20,10));/*Set padding around the top
                                                           pane*/
        
        //Create the insert label and insert button, add to introInsertPane 
        //add that pane to a HBox
        insertLabel = new Label("Insert A New Airman");
        insertLabel.setPadding(new Insets(10));
        introInsertBtn = new Button("Insert");
        introInsertBtn.setPrefWidth(80);
        introInsertBtn.setOnAction(e -> introInsertBtn_Click());
        introInsertPane = new HBox(30,insertLabel, introInsertBtn);
        introInsertPane.setPadding(new Insets(5));//Set padding around pane
        
        //Create the search label, search button, add to introSearchPane, add that
        //pane to a HBox
        searchLabel = new Label("Search the Database");
        searchLabel.setPadding(new Insets(10));
        searchBtn = new Button("Search");
        searchBtn.setPrefWidth(80);
        searchBtn.setOnAction(e -> searchBtn_Click());
        introSearchPane = new HBox(30, searchLabel, searchBtn);
        introSearchPane.setPadding(new Insets(5));//Set padding around pane
        
        //Create the exit button for the intro screen, add to an HBox
        exitBtn = new Button("Exit");
        exitBtn.setPrefWidth(80);
        exitBtn.setOnAction(e -> exitBtn_Click());
        introExitPane = new HBox(exitBtn);
        introExitPane.setPadding(new Insets(5));//Set the padding around pane
        introExitPane.setAlignment(Pos.CENTER);
        
        //Create a VBox called introSelectPane, add the introInsertPane and 
        //introSearchPane
        introSelectPane = new VBox(introInsertPane, introSearchPane, introExitPane);
        
        //Create a BorderPane called mainPane which will be the first screen
        //shown when the program starts, add introTopPane and intoSelectPane
        mainPane = new BorderPane();
        mainPane.setTop(introTopPane);
        mainPane.setCenter(introSelectPane);
     
        //Add the mainPane to the introScence
        introScene = new Scene(mainPane, 320, 200);
        
        //----------------------Setup the insert screen------------------------
        
        //Create heading for the top pane and place in a HBox
        insertHeading = new Text("Insert Airman Information");
        insertHeading.setFont(Font.font("Verdana",FontWeight.BOLD, 15));
        insertHeading.setFill(Color.BLUE);
        insertTopPane = new HBox(insertHeading);/*Create the insertTopPane HBox
                                                and place insertHeading*/
        insertTopPane.setAlignment(Pos.CENTER);
        insertTopPane.setPadding(new Insets(20,10,20,10));
        
        //Create last name label and text field and add to a HBox
        lastNameLbl = new Label("Last Name: ");
        lastNameLbl.setPrefWidth(120);
        lastNameLbl.setPadding(new Insets(5));
        lastNameLbl.setAlignment(Pos.CENTER_LEFT);
        lastNameField = new TextField();
        lastNameField.setPrefColumnCount(50);
        lastNameField.setPrefWidth(80);
        lastNameField.setMaxWidth(80);
        insLastNamePane = new HBox(10, lastNameLbl, lastNameField);
        insLastNamePane.setPadding(new Insets(5));
        
        //Ceate First Name label and text field and add to an HBox
        firstNameLbl = new Label("First Name: ");
        firstNameLbl.setPrefWidth(120);
        firstNameLbl.setPadding(new Insets(10));
        firstNameLbl.setAlignment(Pos.CENTER_LEFT);
        firstNameField = new TextField();
        firstNameField.setPrefColumnCount(50);
        firstNameField.setPrefWidth(80);
        firstNameField.setMaxWidth(80);
        insFirstNamePane = new HBox(10, firstNameLbl, firstNameField);
        insFirstNamePane.setPadding(new Insets(5));
        
        //Create Rank Label and choice box add to an HBox
        insRankLbl = new Label("Rank: ");
        insRankLbl.setPrefWidth(120);
        insRankLbl.setAlignment(Pos.CENTER_LEFT);
        insRankLbl.setPadding(new Insets(10));
        rankBox = new ChoiceBox();
        rankBox.getItems().addAll("Amn","A1C","SrA","SSgt","TSgt","MSgt","SMSgt",
                "CMSgt");
        rankBox.setValue("Amn");
        insRankPane = new HBox(10, insRankLbl, rankBox);
        insRankPane.setPadding(new Insets(5,10,5,10));
        
        //Create section assigned lable and the drop down box to select section
        insSectionAssignLbl = new Label("Section Assigned: ");
        insSectionAssignLbl.setPrefWidth(120);
        insSectionAssignLbl.setAlignment(Pos.CENTER_LEFT);
        insSectionAssignLbl.setPadding(new Insets(10));
        sectionBox = new ChoiceBox();
        sectionBox.getItems().addAll("Inspections","Maintenance","Support",
                "Management");
        sectionBox.setValue("Inspections");
        insSectionAssignedPane = new HBox(10,insSectionAssignLbl,sectionBox);
        insSectionAssignedPane.setPadding(new Insets(5,10,5,10));
        
        //Create the date arrived label and the date selecter
        insDateArrivedLbl = new Label("Date Arrived: ");
        insDateArrivedLbl.setPrefWidth(120);
        insDateArrivedLbl.setAlignment(Pos.CENTER_LEFT);
        insDateArrivedLbl.setPadding(new Insets(10));
        dateArrivedPick = new DatePicker();
        insDateArrivedPane = new HBox(10, insDateArrivedLbl, dateArrivedPick);
        insDateArrivedPane.setPadding(new Insets(5,10,5,10));
        
        //Create the EPR closeout date label and the date selector
        insEPR_DateLbl = new Label("EPR Due Date: ");
        insEPR_DateLbl.setPrefWidth(120);
        insEPR_DateLbl.setAlignment(Pos.CENTER_LEFT);
        insEPR_DateLbl.setPadding(new Insets(10));
        EPR_DatePick = new DatePicker();
        insEPR_DatePane = new HBox(10,insEPR_DateLbl,EPR_DatePick);
        insEPR_DatePane.setPadding(new Insets(5,10,5,10));
        
        //Create and add the submit button so information can be passed to the DB
        insSubmitBtn = new Button("Submit");
        insSubmitBtn.setPrefWidth(80);
        insSubmitBtn.setAlignment(Pos.CENTER);
        insSubmitBtn.setOnAction(e -> insSubmitBtn_Click());
        insSubmitBtnPane = new HBox(10, insSubmitBtn);
        insSubmitBtnPane.setAlignment(Pos.CENTER);
        insSubmitBtnPane.setPadding(new Insets(5,10,5,10));
        
        //Create insert button and exit button, add to hbox to be put into bottom
        //pane
        searchBtn = new Button("Search");
        searchBtn.setPrefWidth(50);
        searchBtn.setStyle("-fx-font-size:10");//Set font size inside button
        searchBtn.setAlignment(Pos.CENTER);
        searchBtn.setOnAction(e -> searchBtn_Click());
        exitBtn = new Button("Exit");
        exitBtn.setPrefWidth(50);
        exitBtn.setAlignment(Pos.CENTER);
        exitBtn.setStyle("-fx-font-size:10");//Set font size inside button
        exitBtn.setOnAction(e -> exitBtn_Click());
        insChoicePane = new HBox(10,searchBtn, exitBtn);
        insChoicePane.setAlignment(Pos.CENTER_RIGHT);
        insChoicePane.setPadding(new Insets(5,10,5,10));
        
        
        //Create infoInsPane VBox to hold the information fields
        insertInfoPane = new VBox(insLastNamePane, insFirstNamePane, insRankPane,
                insSectionAssignedPane, insDateArrivedPane, insEPR_DatePane, 
                insSubmitBtnPane);
        
        //Create the insert pane and add insert heading to the top, infoInsPane in the middle
        //and buttons at the bottom
        insertPane = new BorderPane();
        insertPane.setTop(insertHeading);
        insertPane.setCenter(insertInfoPane);
        insertPane.setBottom(insChoicePane);
        
        
        
        //add insertPane to a new scene called insertScene to be viewed when
        //user presses on the insert button
        insertScene = new Scene(insertPane, 370, 370);
        
        
        //Set up so the introScene starts up first for selection
        primaryStage.setScene(introScene);
        primaryStage.setTitle("Airman's Database");
        primaryStage.show();
      
  
    }

    private void introInsertBtn_Click() {
        stage.setScene(insertScene);
    }
    
    private void searchBtn_Click() {
        
    }
    
    private void exitBtn_Click() {
        stage.close();
    }
    
    private void insSubmitBtn_Click() {
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }

    

    

    

    
    
}
