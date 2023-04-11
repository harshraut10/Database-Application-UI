/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbproject;

import java.sql.*;? 
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.application.Application;  
import javafx.scene.Group;  
import javafx.scene.Scene;  
import javafx.scene.effect.DropShadow;  
import javafx.scene.paint.Color;  
import javafx.scene.shape.Rectangle;  
import javafx.stage.Stage;  

/**
 *
 * @author harsh
 */

public class finalfx extends Application {

    DBConnect ob1 ;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        ob1 = new DBConnect() ;
      
//       Scene display = null ;
       Button back8=new Button("Go To Home");
       back8.setStyle("-fx-font: 24 arial;-fx-background-color: grey");
       
       
       
        
        Button empupsub = new Button("Submit");
        Button empdelsub = new Button("Submit");
        Button empinrsub = new Button("Submit");
        
        Button spdispsub = new Button("Submit");
        Button empdispsub = new Button("Submit");
        
        Button sp = new Button("Supervisor");
        Button emp = new Button("Employee");
         Button spdisp = new Button("Display");
        Button back1 = new Button("Back");
         Button back2 = new Button("Back");
         
         Button back3 = new Button("Back");
        Button empinr = new Button("Insert");
        Button empdel = new Button("Delete");
        Button empup = new Button("Update");
        Button empdisp = new Button("Display");
        Button back4=new Button("Back");
         Button back5=new Button("Back");
         Button back6=new Button("Back");
         Button back7=new Button("Back");
         
         //text fields
         
         TextField empTID = new TextField();    // delete
         
         TextField t3 = new TextField();
         TextField i1 = new TextField();        // insert tickt id
         TextField i2 = new TextField();        // insert pass id
         TextField i4 = new TextField();        // route id
         String st4[] = { "AC-Coach", "Non-AC Coach","General Coach"};
        ChoiceBox choice4 = new ChoiceBox(FXCollections.observableArrayList(st4));  // choicebox coach insert
         
    /////////////////////////////query output //////////////////////////////////
         
         
         
         
        
      //////////////////////////////SCENES////////////////////////////////////////////////// 
      

        Scene mainScene, spScene, spdispScene, empScene,empinrScene,empdelScene,empdispScene,empupScene;
        stage.setTitle("Railway Management");

        
        sp.setStyle("-fx-font: 24 arial;");
        emp.setStyle("-fx-font: 24 arial;");
        
        Label mainl=new Label("RAILWAYS");
        mainl.setStyle("-fx-text-fill: lightblue ; -fx-font: 120 impact;");
        
        //Parent root=FXMLLoader.load(getClass().getResource("bg.fxml"));
        
        VBox main = new VBox(20);
        main.getChildren().addAll(mainl,sp, emp);
        main.setAlignment(Pos.CENTER);
        main.setSpacing(40);
        
        
        
        /*Image image=new Image("img.jpg");
        ImageView mv=new ImageView(image);*/
        
        main.setStyle("-fx-background-color:gray");
        mainScene = new Scene(main, 1000, 750,Color.hsb(180, 1, 1));
        //mainScene.getStylesheets().add("styles/cstyle.css");
         
  
        stage.setScene(mainScene);
        stage.show();

        ////////////////////supervisor scene//////////////////////////////////////////
       
        spdisp.setStyle("-fx-font: 24 arial;");
        back1.setStyle("-fx-font: 24 arial;-fx-background-color: lightgreen");

        HBox spdispx = new HBox(20);
        spdispx.getChildren().addAll(spdisp, back1);
        spdispx.setAlignment(Pos.CENTER);
        spdispx.setSpacing(20);
        spScene = new Scene(spdispx, 1000, 750);

        ////////////////////supervisor display scene//////////////////////////////////////////
       
//        spdispsub.setOnAction(myhandler1);
        spdispsub.setStyle("-fx-font: 24 arial;");
        back2.setStyle("-fx-font: 24 arial;-fx-background-color: grey");
        GridPane gridspdisp = new GridPane();
        Label l0=new Label("Display Tables");
        Label l1 = new Label("Choose Entity");
        l1.setStyle("-fx-font: 24 arial;");
        l0.setStyle("-fx-font: 40 arial;");

        String st[] = {"train", "route", "passenger", "train-route"};
        ChoiceBox choice0 = new ChoiceBox(FXCollections.observableArrayList(st));

        gridspdisp.setVgap(5);
        gridspdisp.setHgap(30);
        gridspdisp.setAlignment(Pos.CENTER);
        gridspdisp.add(l0, 0, 0);
        gridspdisp.add(l1, 0,1 );
        gridspdisp.add(choice0, 2, 1);
        gridspdisp.add(spdispsub, 0, 10);
        gridspdisp.add(back2, 0, 14);
        gridspdisp.setStyle("-fx-background-color:silver");
        spdispScene = new Scene(gridspdisp, 1000, 750);

        ////////////////////employee scene//////////////////////////////////////////
        

        empinr.setStyle("-fx-font: 24 arial;");
        empdel.setStyle("-fx-font: 24 arial;");
        empup.setStyle("-fx-font: 24 arial;");
        empdisp.setStyle("-fx-font: 24 arial;");
        back3.setStyle("-fx-font: 24 arial;-fx-background-color: grey");

        HBox emp1 = new HBox(20);
        emp1.getChildren().addAll(empinr, empdel, empup, empdisp, back3);
        emp1.setAlignment(Pos.CENTER);
        emp1.setSpacing(20);
        emp1.setStyle("-fx-background-color:silver");
        empScene = new Scene(emp1, 1000, 750);
        
        
        ////////////////////employee display scene//////////////////////////////////////////
        
        back4.setStyle("-fx-font: 24 arial;-fx-background-color: grey");
        
//        empdispsub.setOnAction(myhandler1);
        empdispsub.setStyle("-fx-font: 24 arial;");
        
        GridPane gridempdisp=new GridPane();
        //grid.setMinSize(20, 20);
        Label l=new Label("Select attributes to display");
        l.setStyle("-fx-font: 24 arial;");
         CheckBox c1=new CheckBox("Passenger ID");
         CheckBox c2=new CheckBox("Coach");
         CheckBox c3=new CheckBox("Fare");
         CheckBox c4=new CheckBox("Route");
         CheckBox c5=new CheckBox("Ticket ID");
         
         c1.setStyle("-fx-font: 24 arial;");
         c2.setStyle("-fx-font: 24 arial;");
         c3.setStyle("-fx-font: 24 arial;");
         c4.setStyle("-fx-font: 24 arial;");
         c5.setStyle("-fx-font: 24 arial;");
         
         Button sub=new Button("Submit");
         sub.setStyle("-fx-font: 24 arial;");
         
         Label l2 = new Label("Sort order ");
         l2.setStyle("-fx-font: 24 arial;");
         
         Label l3 = new Label("Sort on ");
         l3.setStyle("-fx-font: 24 arial;");
 
 
        // string array
        String sempTID[] = { "Ascending", "Descending"};
        String st2[] = { "Passenger ID", "Ticket ID"};
        
 
        // create a choiceBox
        ChoiceBox choice1 = new ChoiceBox(FXCollections.observableArrayList(sempTID));
        ChoiceBox choice2 = new ChoiceBox(FXCollections.observableArrayList(st2));
         
         /*VBox dispp=new VBox();
         HBox disppp=new HBox();
         
         
         dispp.getChildren().addAll(l,c1,c2,c3,c4,c5);
         dispp.setAlignment(Pos.);
                 */
         gridempdisp.setVgap(5);
         gridempdisp.setHgap(30);
         gridempdisp.setAlignment(Pos.CENTER);
         gridempdisp.add(l,0,0);
         gridempdisp.add(c1, 0, 1);
         gridempdisp.add(c2, 0, 2);
         gridempdisp.add(c3, 0, 3);
         gridempdisp.add(c4, 0, 4);
         gridempdisp.add(c5, 0, 5);
         gridempdisp.add(l2,1,0);
         gridempdisp.add(choice1, 1, 1);
         gridempdisp.add(l3,2,0);
         gridempdisp.add(choice2,2, 1);
         gridempdisp.add(empdispsub,0,10);
         gridempdisp.add(back4,0,14);
         gridempdisp.setStyle("-fx-background-color:silver");
         empdispScene=new Scene(gridempdisp,1600,950);
         
         ////////////////////employee delete scene//////////////////////////////////////////
//         TextField empTID = new TextField();
         Label l4 = new Label("Enter Ticket-ID");
         l4.setStyle("-fx-font: 24 arial;");
//         empdelsub.setOnAction(myHandler);
         
       
        back5.setStyle("-fx-font: 24 arial;-fx-background-color: grey");
        
        empdelsub.setStyle("-fx-font: 24 arial;");
        empdelsub.setId("delsub");
         
         GridPane gridempdel = new GridPane();
         
         gridempdel.setVgap(5);
         gridempdel.setHgap(30);
         gridempdel.setAlignment(Pos.CENTER);
         gridempdel.add(l4,0,0);
         gridempdel.add(empTID,1,0);

        gridempdel.add(empdelsub, 0, 10);
        gridempdel.add(back5, 0, 14);
        gridempdel.setStyle("-fx-background-color:silver");
        empdelScene=new Scene(gridempdel,1600,950);
        
       ////////////////////employee update scene//////////////////////////////////////////
        
        back6.setStyle("-fx-font: 24 arial;-fx-background-color: grey");
        
        empupsub.setStyle("-fx-font: 24 arial;");
        empupsub.setId("upsub");
//       empupsub.setOnAction(myHandler);
        
        GridPane gridempup=new GridPane();
        
        Label l5 = new Label("Select Coach to update the fare price");
        l5.setStyle("-fx-font: 24 arial;");
        
        //
        Label lt4 = new Label("Enter Ticket-ID");
        lt4.setStyle("-fx-font: 24 arial;");
        
        String st3[] = { "AC-Coach", "Non-AC Coach","General Coach"};
        ChoiceBox choice3 = new ChoiceBox(FXCollections.observableArrayList(st3));
        
        
        gridempup.setVgap(5);
        gridempup.setHgap(30);
        gridempup.setAlignment(Pos.CENTER);
        gridempup.add(lt4,0,0);
        gridempup.add(t3,1,0);
        gridempup.add(l5,2,0);
        gridempup.add(choice3,3,0);
        gridempup.add(empupsub,0,10);
        gridempup.add(back6,0,14);
        gridempup.setStyle("-fx-background-color:silver");
        empupScene=new Scene(gridempup,1600,950);
         
        
        
         ////////////////////employee insert scene//////////////////////////////////////////
        String str[] = { "Goa-Mumbai", "Mumbai-Delhi","Delhi-Gujarat"};
        ChoiceBox choicer = new ChoiceBox(FXCollections.observableArrayList(str));
        
        
        back7.setStyle("-fx-font: 24 arial;-fx-background-color: grey");
//        empinrsub.setOnAction(myHandler);
        empinrsub.setStyle("-fx-font: 24 arial;");
        empinrsub.setId("inrsub");
        
        
        GridPane gridempinr=new GridPane();
        VBox emp2=new VBox(20);
        
//        TextField i1 = new TextField();
        Label il1 = new Label("Enter Ticket-ID");
        il1.setStyle("-fx-font: 24 arial;");
        
       // i1.setPrefColumnCount(7);
        
//        TextField i2 = new TextField();
        Label il2 = new Label("Enter Passenger-ID");
        il2.setStyle("-fx-font: 24 arial;");
        
       /* TextField i3 = new TextField();
        Label il3 = new Label("Enter Fare-Payed");
        il3.setStyle("-fx-font: 24 arial;");*/
        
//        TextField i4 = new TextField();
        Label il4 = new Label("Enter Route id");
        il4.setStyle("-fx-font: 24 arial;");
        
//        TextField i5= new TextField();
//        Label il5= new Label("Enter Destination");
//        il5.setStyle("-fx-font: 24 arial;");
        
        
        Label il6= new Label("Enter Coach");
        il6.setStyle("-fx-font: 24 arial;");
        
        
        
//        String st4[] = { "AC-Coach", "Non-AC Coach","General Coach"};
//        ChoiceBox choice4 = new ChoiceBox(FXCollections.observableArrayList(st4));
       
        gridempinr.setVgap(15);
        gridempinr.setHgap(10);
        gridempinr.setAlignment(Pos.CENTER);
        gridempinr.add(il1,0,0);
        gridempinr.add(i1,0,1);
        
        gridempinr.add(il2,0,2);
        gridempinr.add(i2,0,3);
        
        gridempinr.add(il6,0,4);
        gridempinr.add(choice4,0,5);
        
        gridempinr.add(il4,0,6);
        gridempinr.add(choicer,0,7);
        
//        gridempinr.add(il5,0,8);
//        gridempinr.add(i5,0,9);
        
       /* gridempinr.add(il3,0,10);
        gridempinr.add(i3,0,11);*/
        
        gridempinr.add(empinrsub,0,13);
        gridempinr.add(back7,0,14);
        
        /*emp2.getChildren().addAll(il1,i1);
        emp2.setAlignment(Pos.CENTER);
        emp2.setSpacing(20);*/
        gridempinr.setStyle("-fx-background-color:silver");
        empinrScene=new Scene(gridempinr,1600,950);
       

        

        sp.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent arg0) {
                stage.setScene(spdispScene);
            }

        });

        emp.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent arg0) {
                stage.setScene(empScene);
            }

        });

        spdisp.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent arg0) {
                stage.setScene(spdispScene);
            }

        });
        
        empdisp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                stage.setScene(empdispScene);
            }

        });
        
        empdel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                stage.setScene(empdelScene);
            }

        });
        
       empup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                stage.setScene(empupScene);
            }

        });
       
       empinr.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                stage.setScene(empinrScene);
            }

        });
        //////back buttons
        back1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                stage.setScene(mainScene);
            }

        });

        back2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                stage.setScene(mainScene);
            }

        });

        back3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                stage.setScene(mainScene);
            }

        });
        
        back4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                stage.setScene(empScene);
            }

        });
        back5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                stage.setScene(empScene);
            }

        });
        
         back6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                stage.setScene(empScene);
            }

        });
         
         back7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                stage.setScene(empScene);
            }

        });
         
         back8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                stage.setScene(mainScene);
            }

        });
        

        
         
         
         
         
         
         
         
         
         
         ///////  query o/p     ///////
         final EventHandler<ActionEvent> myHandler = new EventHandler<ActionEvent>()
         {
             @Override
             public void handle(final ActionEvent event) {
                 
                 if(event.getSource()== empupsub)
                 {
                     System.out.println();
                     System.out.println(CreateQuery.updateTicketQuery(choice3, t3)) ;
                     System.out.println();
                     // executes query and display o/p ;
                     Scene display2 = ob1.updateStatement(CreateQuery.updateTicketQuery(choice3, t3), back8);

                     stage.setScene(display2);
                     
                     //update function
                 }
                 else if(event.getSource()== empdelsub)
                 {

                     //delete function
                     
                     System.out.println();
                     System.out.println(CreateQuery.deleteTicketQuery(empTID));
                     System.out.println();
                     //execute query
                     Scene display2 = ob1.deleteStatement(CreateQuery.deleteTicketQuery(empTID), back8);
                     
                     stage.setScene(display2);
                     
                 }
                  else if(event.getSource()== empinrsub)
                 {
                     System.out.println();
                     System.out.println(CreateQuery.insertTicketQuery(choice4, choicer, i1 , i2));
                     //execute query
                     System.out.println();
                     
                     Scene display2 = ob1.insertStatement(CreateQuery.insertTicketQuery(choice4, choicer, i1 , i2), back8);
                     
                     stage.setScene(display2);
                     
//                     //insert function
                     
                 }
                 
                 
                 
             }
             
         };
         ///////////display event///////////////////////////////////
         
         final EventHandler<ActionEvent> myhandler1 = new EventHandler<ActionEvent>()
         {
             @Override
             public void handle(final ActionEvent event) {
                 
                 if(event.getSource()== spdispsub)
                 {
                     System.out.print("Display from supervisor scene\n");
                     
                     System.out.println(CreateQuery.displaySupervisorQuery(choice0));
                     
                     // executes query and edits the table ;
                     Scene display1 = ob1.displayStatement(CreateQuery.displaySupervisorQuery(choice0), CreateQuery.colName((String) choice0.getValue()), back8);
                     
                     stage.setScene(display1);
                 }
                 else if(event.getSource()==empdispsub)
                 {
                     System.out.print("Display from emp scene\n");
                     
                     //disp function
                     System.out.println(CreateQuery.displayTicketQuery(choice2, choice1, c1, c2, c3, c4, c5 )) ;
                     
                     // executes and displays o/p ;

                     Scene display2 = ob1.displayStatement(CreateQuery.displayTicketQuery(choice2, choice1, c1, c2, c3, c4, c5 ), CreateQuery.colName(""), back8) ;
                     
                     stage.setScene(display2);
                 }
                 
                 
                 
                 
             }
             
         };
         
         spdispsub.setOnAction(myhandler1);
         empdispsub.setOnAction(myhandler1);
         empdelsub.setOnAction(myHandler);
         empupsub.setOnAction(myHandler);
         empinrsub.setOnAction(myHandler);
    }

    /**
     * @param args the command line arguments
     */
    
    public void innit(String[] args) { 
        
        launch(args);
        
    }

}
