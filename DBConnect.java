/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbproject;
/**
 *
 * @author Anirudh
 */
import java.sql.*;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.SelectionMode;



public class DBConnect {
    Connection conn;
    Statement stmnt;
    
    public DBConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/railways", "root", "");
            stmnt = conn.createStatement();
        } catch(Exception e) {
            System.out.println("Cannot Connect to Database.");
        }
    }
    
    public Scene dmlOutputMessage(Button backToHome, int flag){
        Label l9 ;
        if(flag==0){
            l9 = new Label("Query Executed Successfully.");
            l9.setStyle("-fx-font: 24 arial;");
        } else {
            l9 = new Label("Query Execution was Unsuccessful.");
            l9.setStyle("-fx-font: 24 arial;");
        }
        VBox dispmain = new VBox(20);
        dispmain.setPadding(new Insets(10, 0, 0, 10));
        dispmain.getChildren().add(l9);
        dispmain.getChildren().add(backToHome);
        dispmain.setSpacing(20);
        Scene display = new Scene(dispmain, 1000, 750);
        return display;
    }
    
    public Scene insertStatement(String query, Button backToHome) {
        int flag = 0;
        try {
            stmnt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            flag++ ;
        }finally{
            return dmlOutputMessage(backToHome,flag);
        }
//        if(flag == 0){
//// display 
//        }
    }

    public Scene deleteStatement(String query, Button backToHome) {
        int flag = 0;
        try {
            int x = stmnt.executeUpdate(query);
            if(x < 1){
                throw new SQLException("Cannot delete any entries from table.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            flag++ ;
        }finally{
            return dmlOutputMessage(backToHome,flag);
//            if(flag == 0){
//  display            
//            }
        }
    }

    public Scene updateStatement(String query, Button backToHome) {
        int flag = 0;
        try {
            int x = stmnt.executeUpdate(query);
            if(x < 1){
                throw new SQLException("Cannot update any entries from table.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            flag++ ;
        }finally{
            return dmlOutputMessage(backToHome,flag);
//            if(flag == 0){
//  display            
//            }
         }
    }
    

    
    
    public Scene displayStatement(String query, String[] colName, Button backToHome) {
        
        VBox dispmain ;
        
        int flag = 0 ;
        
        try{
//            TableView tableView = new TableView<>();
//            TableColumn[] tableCol = new TableColumn[colName.length];  
//            for(int i = 0 ; i < colName.length ; i++ ){
//                tableCol[i] = new TableColumn(colName[i]) ;
//                tableCol[i].setMinWidth(100);
//                tableCol[i].setCellValueFactory(new PropertyValueFactory(colName[i]));
//                tableView.getColumns().add(tableCol[i]);
//            }
//            ObservableList<String[]> list1 = FXCollections.observableArrayList();
//            tableView.setItems();

            ResultSet rs = stmnt.executeQuery(query);
            
            Label l9 = new Label("Table Display:");
            l9.setStyle("-fx-font: 24 arial;");
       
            dispmain = new VBox(20);
            dispmain.setPadding(new Insets(10, 0, 0, 10));
            dispmain.getChildren().add(l9);
            dispmain.getChildren().add(backToHome);
        
            String s = "" ;
            
            for (String colName1 : colName) {
                s = s + colName1 + "    ";
            }
            
            Label headingCol = new Label(s) ;
            headingCol.setStyle("-fx-font: 24 arial;");
            dispmain.getChildren().add(headingCol);
            
            while (rs.next()) {
                String[] c1 = new String[colName.length];
                String q = "" ;
                for(int i = 0 ; i < colName.length ; i++ ){
                    
                    c1[i] = rs.getString(i+1);
                    
                    System.out.print(c1[i] + "    ");
                    
                    q = q + c1[i] + "       " ;
                    
                }
                
                Label label1 = new Label(q) ;
                
                label1.setStyle("-fx-font: 24 arial;");
                
                dispmain.getChildren().add(label1);
                
                System.out.println();
            }

//            tableView.setItems(list1);
//            tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//            for (TableColumn tableColumn1 : tableCol) {
//                tableView.getColumns().add(tableColumn1);
//            }
//       Label l10 = new Label("No. of Records");       
//       l10.setStyle("-fx-font: 20 arial;");
//        for(Label l : label1){
//            dispmain.getChildren().add(l);
//        }
            
            
            dispmain.setSpacing(20);
            rs.close();
            Scene display = new Scene(dispmain, 1000, 750);
            return display ;
            
            
//            while (rs.next()) {
//                for(int i = 1 ; i <= colName.length ; i++ ){
//                    System.out.print(rs.getString(i) + " ");
//                }
//                System.out.println();
//            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            flag++ ;
            return null;
        }
        
    }

    public void close() {
        try {
            stmnt.close();
            conn.close();
//            alert.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
