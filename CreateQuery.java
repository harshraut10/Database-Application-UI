/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbproject;
import java.sql.*;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 *
 * @author Anirudh
 */
class CreateQuery {
	static Boolean[] ticketColSelected = {false,false,false,false,false};
	static String[] ticketColName={"pass_id ","coach ","fare ","route ","ticket_id "};
        static int colCountEmployee = 0;
        
        static String[] trainCols = {"trainname","trainno","depttime","arrivtime"};
        static String[] routeCols = {"routeid","source","destination"};
        static String[] passengerCols = {"passengerid","aadharno","seatno","route"};
        static String[] trainRouteCols = {"routeid","trainname","trainno","depttime","arrivtime","source","destination"};
        static String[] ticketCols = {"pass_id","coach","fare","route","ticket_id"};
        
	public static void getTicketCols(CheckBox[] ch ){
            
            int c = 0 ;
            
            colCountEmployee = 0 ;
            
            for(int i = 0; i<ticketColSelected.length;i++){
                ticketColSelected[i]=false;
	    }
            
            for(CheckBox choice1 : ch){
                if(choice1.isSelected()){
                    ticketColSelected[c] = true;
                    colCountEmployee = colCountEmployee + 1 ;
                }
                c++ ;
            }
	}
        
        
        
        // required for display query ;
        
        static String[] colName(String choice1){    
            
            switch(choice1){
                case "train" :
                    return trainCols;       // train doesn't show route-id here
                case "route" :
                    return routeCols;
                case "passenger" :
                    return passengerCols;
                case "train-route" :
                    return trainRouteCols; 
                default :
                    if(CreateQuery.colCountEmployee == 0){
                        return ticketCols;
                    }else{
                        String[] t = new String[colCountEmployee];
                        int k = 0 ;
                        for(int i = 0 ; i < ticketCols.length ; i++ ){
                            if(ticketColSelected[i] == true){
                                t[k] = ticketCols[i] ;
                                k = k + 1 ;
                            }
                        }
                        return t;
                    }
            }
    }

        
        
        
        
        
	// when submit is pressed, call following methods in EventHandler:
        
	public static String displayTicketQuery(ChoiceBox c1, ChoiceBox c2, CheckBox... ch ){
            
                getTicketCols(ch);

                Boolean cSelected[] = ticketColSelected ;
                String colName[] = ticketColName ;

		int flag=0;
		String query="SELECT ";

                for(int i=0; i<cSelected.length ;i++){
			if(cSelected[i]){
				if(flag == 0){			// run if first col.
					query = query + colName[i] ;
                                        flag++ ;
				}else{  		// run if not first col.
					query = query + " , " + colName[i];
				}
			}
		}

                if(flag == 0){      // if no checkbox selected display all ;
                    query = query + "* ";
                }

		query = query + "FROM tickets" ;

                
                if(c1.getValue() == "Passenger ID" && (ticketColSelected[0]) || flag == 0){
                    query = query + " ORDER BY pass_id " ;
                    
                    if(c2.getValue() == "Ascending"){
                        query = query + "asc" ;
                    }else{
                        query = query + "desc" ;
                    }

                }else if(c1.getValue() == "Ticket ID" && (ticketColSelected[4] || flag == 0)){
                    query = query + " ORDER BY ticket_id " ;

                    if(c2.getValue() == "Ascending"){
                        query = query + "asc" ;
                    }else{
                        query = query + "desc" ;
                    }

                }
                
                query = query + " ;" ;
                
                return query ;
	}
        
        
        
        
        public static String insertTicketQuery(ChoiceBox choice1, ChoiceBox choiceRoute, TextField... textboxes){
            
            String query = "INSERT INTO tickets(coach,fare,ticket_id,pass_id,route) VALUES('" + choice1.getValue() + "' ";
            
            switch((String)choice1.getValue()){
                case "AC-Coach" :
                    query = query + ", 1000 " ;
                    break;
                case "Non-AC Coach" :
                    query = query + ", 500 " ;
                    break;
                case "General Coach" :
                    query = query + ", 200 " ;
                    break;
                default :
                    return "" ;
            }
            
            int flag = 0 ;
            
            for(TextField t : textboxes){
                query = query + ", '" + t.getText() + "'" ;
                flag++ ;
            }
            
            switch((String)choiceRoute.getValue()){
                case "Goa-Mumbai":
                    query = query + ", '1' " ;
                    break;
                case "Mumbai-Delhi":
                    query = query + ", '2' " ;
                    break;
                case "Delhi-Gujarat":
                    query = query + ", '3' " ;
                    break;
                default :
                    return "" ;
            }
            
            query = query + ");" ;
            
            return query ;
            
        }
        
        
        
        public static String updateTicketQuery(ChoiceBox choice1, TextField id){
            
            String query = "UPDATE tickets SET coach = '" + choice1.getValue() + "' " ;
        
            switch((String)choice1.getValue()){
                case "AC-Coach" :
                    query = query + ", fare = 1000 " ;
                    break;
                case "Non-AC Coach" :
                    query = query + ", fare = 500 " ;
                    break;
                case "General Coach" :
                    query = query + ", fare = 200 " ;
                    break;
                default :
                    return "" ;
            }
            query = query + " WHERE ticket_id = " + id.getText() + " ;";
            
            return query ;
        
        }
        
        
        
        public static String deleteTicketQuery(TextField id){
            
            String query = "DELETE FROM tickets WHERE ticket_id = " + id.getText() + " ;" ;
            
            return query ;
        
        }
        
        
        
        
        public static String displaySupervisorQuery(ChoiceBox choice1){
        
            String query ; 
            
            switch((String)choice1.getValue()){
                case "train" :
                    query = "SELECT * FROM trainView ;";
                    break ;
                case "route" :
                    query = "SELECT * FROM routeView ;";
                    break ;
                case "passenger" :
                    query = "SELECT * FROM passengerView ;";
                    break ;
                case "train-route" :
                    query = "SELECT * FROM train NATURAL JOIN route ;" ;
                    break ;
                default :
                    query = "";
            }
            
            return query ;
        
        }
        
}
