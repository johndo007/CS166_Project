/*
 * Template JAVA User Interface
 * =============================
 *
 * Database Management Systems
 * Department of Computer Science &amp; Engineering
 * University of California - Riverside
 *
 * Target DBMS: 'Postgres'
 *
 */

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;

/**
 * This class defines a simple embedded SQL utility class that is designed to
 * work with PostgreSQL JDBC drivers.
 *
 */
public class ProfNetwork {
   // reference to physical database connection.
   private Connection _connection = null;

   // handling the keyboard inputs through a BufferedReader
   // This variable can be global for convenience.
   static BufferedReader in = new BufferedReader(
                                new InputStreamReader(System.in));
                                
  public static String currentUserID = "";
  public static int currentUserNumber = 0; 

/**
* Creates a new instance of ProfNetwork
*
* @param hostname the MySQL or PostgreSQL server hostname
* @param database the name of the database
* @param username the user name used to login to the database
* @param password the user login password
* @throws java.sql.SQLException when failed to make a connection.
*/
public ProfNetwork (String dbname, String dbport, String user, String passwd) throws SQLException {

  System.out.print("Connecting to database...");
  try{
	 // constructs the connection URL
	 String url = "jdbc:postgresql://localhost:" + dbport + "/" + dbname;
	 System.out.println ("Connection URL: " + url + "\n");

	 // obtain a physical connection
	 this._connection = DriverManager.getConnection(url, user, passwd);
	 System.out.println("Done");
  }catch (Exception e){
	 System.err.println("Error - Unable to Connect to Database: " + e.getMessage() );
	 System.out.println("Make sure you started postgres on this machine");
	 System.exit(-1);
  }//end catch
}//end ProfNetwork

/**
* Method to execute an update SQL statement.  Update SQL instructions
* includes CREATE, INSERT, UPDATE, DELETE, and DROP.
*
* @param sql the input SQL string
* @throws java.sql.SQLException when update failed
*/
public void executeUpdate (String sql) throws SQLException {
  // creates a statement object
  Statement stmt = this._connection.createStatement ();

  // issues the update instruction
  stmt.executeUpdate (sql);

  // close the instruction
  stmt.close ();
}//end executeUpdate

public static void PrintMessages(String[][] results) {
	System.out.println();
	
	for (int i = 0; i < results.length; i++)
	{
		if (results[i] != null)
		{
			for (int j = 0; j < 7; j++)
			{
				if (j == 0)
				{
					System.out.println("MsgID: " + results[i][j]);
				}
				else if (j == 1)
				{
					System.out.println("Sent By: " + results[i][j]);
				}
				else if (j == 2)
				{
					System.out.println("To: " + results[i][j]);
				}
				else if (j == 3) //LONG
				{
					System.out.println("Contents: " + results[i][j]);
				}
				else if (j == 4)
				{
					System.out.println("Send Time: " + results[i][j]);
				}
				else if (j == 5)
				{
					System.out.println("deleteStatus: " + results[i][j]);
				}
				else if (j == 6)
				{
					System.out.println("Status: " + results[i][j]);
				}
			}
			for (int spacing = 0; spacing < 50; spacing++)
			{
				System.out.print("-");
			}
			System.out.println();
		}
	}
	System.out.println();
}

public static void PrintWorkDetails(String[][] results) {
	System.out.println();
	
	for (int i = 0; i < results.length; i++)
	{
		if (results[i] != null)
		{
			for (int j = 0; j < 5; j++)
			{
				if (j == 0)
				{
					System.out.println("Company: " + results[i][j]);
				}
				else if (j == 1)
				{
					System.out.println("Role: " + results[i][j]);
				}
				else if (j == 2)
				{
					System.out.println("Location: " + results[i][j]);
				}
				else if (j == 3) //LONG
				{
					System.out.println("startDate: " + results[i][j]);
				}
				else if (j == 4)
				{
					System.out.println("endDate: " + results[i][j]);
				}
			}
			System.out.println();
		}
	}
	System.out.println();
}


public static void PrintEduDetails(String[][] results) {
	System.out.println();
	
	for (int i = 0; i < results.length; i++)
	{
		if (results[i] != null)
		{
			for (int j = 0; j < 5; j++)
			{
				if (j == 0)
				{
					System.out.println("Institution Name: " + results[i][j]);
				}
				else if (j == 1)
				{
					System.out.println("Major: " + results[i][j]);
				}
				else if (j == 2)
				{
					System.out.println("Degree: " + results[i][j]);
				}
				else if (j == 3) //LONG
				{
					System.out.println("startDate: " + results[i][j]);
				}
				else if (j == 4)
				{
					System.out.println("endDate: " + results[i][j]);
				}
			}
			System.out.println();
		}
	}
	System.out.println();
}


/**
 Prints results of Query from array
*/
public static void PrintResult (String[][] results) {
	int num_columns = results[0].length;
	if (results.length <= 0){
		System.out.print("Passed in empty array to PrintResult()");
		return;
	}
	
	// Print Formatting based on number of columns
	if (num_columns == 1){
		System.out.print("..............................");
		for (Object[] row : results) {
			System.out.format("%-30s\n", row);
		}
	}
	else if (num_columns == 2){
		for( int i = 0; i < num_columns; i++)
			System.out.print("..............................");
		System.out.println();
		for (Object[] row : results) {
			System.out.format("%-30s%-30s\n", row);
		}
	}
	else if (num_columns == 3){
		for( int i = 0; i < num_columns; i++)
			System.out.print("..............................");
		System.out.println();
		for (Object[] row : results) {
			System.out.format("%-30s%-30s%-30s\n", row);
		}
	}
	else if (num_columns == 4){
		for( int i = 0; i < num_columns; i++)
			System.out.print("..............................");
		System.out.println();
		for (Object[] row : results) {
			System.out.format("%-30s%-30s%-30s%-30s\n", row);
		}
	}
	else if (num_columns == 5){
		for( int i = 0; i < num_columns; i++)
			System.out.print("..............................");
		System.out.println();
		for (Object[] row : results) {
			System.out.format("%-30s%-30s%-30s%-30s%-30s\n", row);
		}
	}
	else if (num_columns == 6){
		for( int i = 0; i < num_columns; i++)
			System.out.print("..............................");
		System.out.println();
		for (Object[] row : results) {
			System.out.format("%-30s%-30s%-30s%-30s%-30s%-30s\n", row);
		}
	}
	else if (num_columns == 7){
		for( int i = 0; i < num_columns; i++)
			System.out.print("..............................");
		System.out.println();
		for (Object[] row : results) {
			System.out.format("%-30s%-30s%-30s%-30s%-30s%-30s%-30s\n", row);
		}
	}
	System.out.print("\n");
}//end executeQuery

/**
* Method to execute an input query SQL instruction (i.e. SELECT).  This
* method issues the query to the DBMS and returns the results as
* a list of records. Each record in turn is a list of attribute values
*
* @param query the input query string
* @return the query result as a list of records
* @throws java.sql.SQLException when failed to execute the query
*/
public String[][] executeQueryAndReturnResult (String query) throws SQLException {
  // creates a statement object
  Statement stmt = this._connection.createStatement ();

  // issues the query instruction
  ResultSet rs = stmt.executeQuery (query);

  /*
   ** obtains the metadata object for the returned result set.  The metadata
   ** contains row and column info.
   */
  ResultSetMetaData rsmd = rs.getMetaData ();
  int numCol = rsmd.getColumnCount ();
  int rowCount = 0;

  // iterates through the result set and saves the data returned by the query.
  boolean outputHeader = false;
  List<List<String>> result  = new ArrayList<List<String>>();
  while (rs.next()){
	  List<String> record = new ArrayList<String>();
	 for (int i=1; i<=numCol; ++i)
		record.add(rs.getString(i).trim());
	 result.add(record);
  }//end while
  stmt.close ();
    String[][] ret = new String[result.size()][];
		  String[] blankArray = new String[0];
		  for(int i=0; i < result.size(); i++) {
				ret[i] = result.get(i).toArray(blankArray);
		  }
  return ret;
}//end executeQueryAndReturnResult

/**
* Method to execute an input query SQL instruction (i.e. SELECT).  This
* method issues the query to the DBMS and returns the number of results
*
* @param query the input query string
* @return the number of rows returned
* @throws java.sql.SQLException when failed to execute the query
*/
public int executeQuery (String query) throws SQLException {
   // creates a statement object
   Statement stmt = this._connection.createStatement ();

   // issues the query instruction
   ResultSet rs = stmt.executeQuery (query);

   int rowCount = 0;

   // iterates through the result set and count nuber of results.
   if(rs.next()){
	  rowCount++;
   }//end while
   stmt.close ();
   return rowCount;
}

/**
* Method to fetch the last value from sequence. This
* method issues the query to the DBMS and returns the current
* value of sequence used for autogenerated keys
*
* @param sequence name of the DB sequence
* @return current value of a sequence
* @throws java.sql.SQLException when failed to execute the query
*/
public int getCurrSeqVal(String sequence) throws SQLException {
Statement stmt = this._connection.createStatement ();

ResultSet rs = stmt.executeQuery (String.format("Select currval('%s')", sequence));
if (rs.next())
	return rs.getInt(1);
return -1;
}

/**
* Method to close the physical connection if it is open.
*/
public void cleanup(){
  try{
	 if (this._connection != null){
		this._connection.close ();
	 }//end if
  }catch (SQLException e){
	 // ignored.
  }//end try
}//end cleanup

public static void resetUser(){
  currentUserID = "";
  currentUserNumber = 0;
}

/**
* The main execution method
*
* @param args the command line arguments this inclues the <mysql|pgsql> <login file>
*/
public static void main (String[] args) {
	if (args.length != 3) 
	{
		System.err.println (
		"Usage: " +
		"java [-classpath <classpath>] " +
		ProfNetwork.class.getName () +
		" <dbname> <port> <user>");
		return;
	}//end if

	Greeting();
	ProfNetwork esql = null;
	try{
	// use postgres JDBC driver.
	Class.forName ("org.postgresql.Driver").newInstance ();
	// instantiate the ProfNetwork object and creates a physical
	// connection.
	String dbname = args[0];
	String dbport = args[1];
	String user = args[2];
	esql = new ProfNetwork (dbname, dbport, user, "");

	boolean keepon = true;
	while(keepon) {
	// These are sample SQL statements
	System.out.println("MAIN MENU");
	System.out.println("---------");
	System.out.println("1. Create user");
	System.out.println("2. Log in");
	System.out.println("9. EXIT");
	String authorisedUser = null;
	switch (readChoice()){
	   case 1: CreateUser(esql); break;
	   case 2: authorisedUser = LogIn(esql); break;
	   case 9: keepon = false; resetUser(); break;
	   default : System.out.println("Unrecognized choice!"); break;
	}//end switch
	if (authorisedUser != null) {
	  boolean usermenu = true;
	  while(usermenu) {
		System.out.println("MAIN MENU");
		System.out.println("---------");
		System.out.println("1. Goto Friend List");
		System.out.println("2. Update Profile");
		System.out.println("3. Write a new message");
		System.out.println("4. Send Friend Request");
		System.out.println("5. Search People");
		System.out.println("6. View Messages");
		System.out.println("7. Check connection requests");
		System.out.println(".........................");
		System.out.println("9. Log out");
		switch (readChoice()){
		   case 1: FriendList(esql); break;
		   case 2: UpdateProfile(esql); break;
		   case 3: NewMessage(esql); break;
		   case 4: SendRequest(esql); break;
		   case 5: SearchPeople(esql); break;
		   case 6: ViewMessages(esql); break;
		   case 7: ConnectionRequests(esql); break;
       case 9: usermenu = false; resetUser(); break;
		   default : System.out.println("Unrecognized choice!"); break;
		}
	  }
	}
	}//end while
  }catch(Exception e) {
	 System.err.println (e.getMessage ());
  }finally{
	 // make sure to cleanup the created table and close the connection.
	 try{
		if(esql != null) {
		   System.out.print("Disconnecting from database...");
		   esql.cleanup ();
		   System.out.println("Done\n\nBye !");
		}//end if
	 }catch (Exception e) {
		// ignored.
	 }//end try
  }//end try
}//end main

public static void Greeting(){
  System.out.println(
	 "\n\n*******************************************************\n" +
	 "              User Interface      	               \n" +
	 "*******************************************************\n");
}//end Greeting

/*
* Reads the users choice given from the keyboard
* @int
**/
public static int readChoice() {
  int input;
  // returns only if a correct value is given.
  do {
	 System.out.print("Please make your choice: ");
	 try { // read the integer, parse it and break.
		input = Integer.parseInt(in.readLine());
		break;
	 }catch (Exception e) {
		System.out.println("Your input is invalid!");
		continue;
	 }//end try
  }while (true);
  return input;
}//end readChoice

/*
* Creates a new user with privided login, passowrd and phoneNum
* An empty block and contact list would be generated and associated with a user
**/
public static void CreateUser(ProfNetwork esql){
	try{
		System.out.print("\tEnter user login: ");
        String login = in.readLine();
        System.out.print("\tEnter user password: ");
        String password = in.readLine();
        System.out.print("\tEnter user email: ");
        String email = in.readLine();

		//Creating empty contact\block lists for a user
		String query = String.format("INSERT INTO USR (userId, password, email) VALUES ('%s','%s','%s')", login, password, email);
        esql.executeUpdate(query);
        System.out.println ("User successfully created!");
	}
	catch(Exception e){
		System.err.println (e.getMessage ());
	}
}//end

/*
* Check log in credentials for an existing user
* @return User login or null is the user does not exist
**/
public static String LogIn(ProfNetwork esql){
	try{
         System.out.print("\tEnter user login: ");
         String login = in.readLine();
         System.out.print("\tEnter user password: ");
         String password = in.readLine();

         String query = String.format("SELECT * FROM USR WHERE userId = '%s' AND password = '%s'", login, password);
         int userNum = esql.executeQuery(query);

		if (userNum > 0)
		{
		  currentUserID = login;
		  currentUserNumber = userNum;
				return login;
		}
		else
		{
			System.err.println("Incorrect Username or Password. Please try again. \n");
		}
	}
	catch(Exception e){
		System.err.println (e.getMessage ());
        return null;
    }
	return null;
}//end

// Rest of the functions definition go in here

  public static void SendRequest(ProfNetwork esql){
    return;
  }
  
  public static void NewMessage(ProfNetwork esql){
    try{
        String messageTarget; 
        String messageToBeSent;
        int maxMessageID = 0;
        String messageStatus = "Delivered";
        //Timestamp currentTime = 
        System.out.print("\tEnter the login of the person you want to message: ");
        messageTarget = in.readLine();     
        String query = String.format("SELECT * FROM USR WHERE userId = '%s'", messageTarget);
        int userNum = esql.executeQuery(query);
        if(userNum > 0)
        {
          System.out.print("\n\tMessage: ");
          messageToBeSent = in.readLine();
          query = String.format("SELECT COUNT( * ) FROM MESSAGE");
          String[][] g = esql.executeQueryAndReturnResult(query);
          maxMessageID = Integer.parseInt(g[0][0]) + 1;
          query = String.format("INSERT INTO MESSAGE VALUES ('%d', '%s', '%s', '%s', current_timestamp, 0, '%s')", maxMessageID, currentUserID, messageTarget, messageToBeSent, messageStatus); 
          esql.executeUpdate(query);
          
          System.out.print("\tMessage has been sent!\n\n");
        }
        else
        {
          System.out.print("\n\tThere is no person by that name.\n\n");
          return;
        }
      }catch(Exception e){
         System.err.println (e.getMessage ());
         return;
    }
  }
  
  public static void UpdateProfile(ProfNetwork esql){
    try{
        String login = "";
        String original_password = "";
        String password = "";
        String password2 = "";

        System.out.print("\tWould you like to change your password? ");
        String input = in.readLine();
        if(input.equals("Yes") || input.equals("yes") || input.equals("Y") || input.equals("y"))
        {
          System.out.print("\n\tPlease verify that you are the owner of this account\n");
          System.out.print("\tEnter your username: ");
          login = in.readLine();
          if(login.equals(currentUserID))
          {
            System.out.print("\tEnter your password: ");
            password = in.readLine();
            
            String query = String.format("SELECT * FROM USR WHERE userId = '%s' AND password = '%s'", login, password);
            int userNum = esql.executeQuery(query);
            if(userNum > 0)
            {
              System.out.print("\n\tVerification Successful!\n\n");
              original_password = password;
              while(password != password2)
              {
                System.out.print("\tEnter your new password (enter nothing to leave password unchanged): ");
                password = in.readLine();
                System.out.print("\tEnter your new password again (enter nothing again to leave password unchanged): ");
                password2 = in.readLine();
                
                password = password.trim();
                password2 = password2.trim();

                if(password.equals("") && password2.equals(""))
                {
                  System.out.print("\tNo changes made to password!\n");
                  System.out.print("\n\tReturning to Main Menu\n\n");
                  return;
                }
                else if(password.equals(password2))
                {
                  query = String.format("UPDATE USR SET password = '%s' WHERE userId = '%s' AND password = '%s'", password, login, original_password);
                  esql.executeUpdate(query);
                  if(userNum > 0)
                  {
                    System.out.print("\tPassword has been changed!\n");
                    System.out.print("\n\tReturning to Main Menu\n\n");
                    return;
                  }
                  else
                  {
                    System.out.print("\tPassword was not succesfully saved!\n");
                    return;
                  }
                }
                else
                {
                  System.out.print("\tPassword do not match!\n");
                }
              }
            }
            else
            {
              System.out.print("\n\tLogin was unsuccessful!\n\n\tReturning to Main Menu\n\n");
              return;
            }
          }
          else
          {
            System.out.print("\n\tLogin was unsuccessful!\n\n\tReturning to Main Menu\n\n");
            return;
          }
        }
      }catch(Exception e){
         System.err.println (e.getMessage ());
         return;
    }
    return;
  }
  
  //view friends, go to their profile, view their friends, send connection request to friend's friends
  public static void FriendList(ProfNetwork esql){
	int depth = 0; //if depth < 3, this is a 3rd lvl connection
	String UserID = currentUserID;
	String[][] myFriends = new String[10][3]; //allocate slots for 10 for now
	try{
		while(true)
		{
			//System.out.println("Depth: " + depth);
			String query = String.format("SELECT * FROM CONNECTION_USR WHERE (connectionId = '%s' OR UserId = '%s') AND status = '%s'", 
									UserID, UserID, "Accept");
			String[][] friend_list = esql.executeQueryAndReturnResult(query);
			if (friend_list.length <= 0)
			{
				System.out.println("The user has no friends!");
				return;
			}
			if (depth == 0)
			{
				//System.out.println("copying friend list");
				myFriends = friend_list.clone();
			}
				
			System.out.println("-------------------- Friends -------------------- ");
			//convert friend_list to their real names
			for (int i = 0; i < friend_list.length; i++)
			{
				if (friend_list[i][0].equals(UserID))
				{
					query = String.format("SELECT name FROM USR WHERE userId = '%s'", friend_list[i][1]);
				}
				else
				{
					query = String.format("SELECT name FROM USR WHERE userId = '%s'", friend_list[i][0]);
				}	
					String[][] friendName = esql.executeQueryAndReturnResult(query);
					System.out.println(i + ". " + friendName[0][0]);	
			}
			
			System.out.print("Which friend's profile to you want to view(#), X to cancel: ");
			String friend_num = in.readLine();
			if (friend_num.equals("X")) 
				return;
			int index = Integer.parseInt(friend_num);
			String friendID = "";
			if (friend_list[index][0].equals(UserID))
			{
				friendID = friend_list[index][1]; //got the ID of friend
			}
			else 
			{
				friendID = friend_list[index][0]; //got the ID of friend
			}
			
			//Outputting profile information
			query = String.format("SELECT name FROM USR WHERE userId = '%s'", friendID);
			String[][] friendName = esql.executeQueryAndReturnResult(query);
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ " + friendName[0][0] + "'s profile page ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ");
			query = String.format("SELECT company, role, location, startDate, endDate FROM WORK_EXPR WHERE userId = '%s'", friendID);
			String[][] WorkDetails = esql.executeQueryAndReturnResult(query);
			System.out.println("-------------------- Work Experience -------------------- ");
			PrintWorkDetails(WorkDetails); 
			query = String.format("SELECT instituitionName, major, degree, startdate, enddate FROM EDUCATIONAL_DETAILS WHERE userId = '%s'",
								friendID);
			String[][] EduDetails = esql.executeQueryAndReturnResult(query);
			System.out.println("-------------------- Educational Details -------------------- ");
			PrintEduDetails(EduDetails);
			System.out.println();
			
			System.out.println("Would you like to message this person: ");
			String choice = in.readLine();
			if(choice.equals("Yes") || choice.equals("yes") || choice.equals("Y") || choice.equals("y"))
			{
				System.out.print("\n\tMessage: ");
			    String messageToBeSent = in.readLine();
			    query = String.format("SELECT COUNT( * ) FROM MESSAGE");
			    String[][] g = esql.executeQueryAndReturnResult(query);
			    int maxMessageID = Integer.parseInt(g[0][0]) + 1;
			    String messageStatus = "Delivered";
			    query = String.format("INSERT INTO MESSAGE VALUES ('%d', '%s', '%s', '%s', current_timestamp, 0, '%s')", maxMessageID, currentUserID, friendID, messageToBeSent, messageStatus); 
			    esql.executeUpdate(query);
			    
			    System.out.print("\tMessage has been sent!\n\n");
			}
			if (depth > 0 && depth < 3) //2nd and 3rd lvl connections only for connection requests
			{
				  //System.out.println("CHECK friend's list: \n");
				  boolean already_friend = false;
				  
				  for(int i = 0; i < myFriends.length; i++) //check if already existing friend
				  {
					  if (myFriends == null)
						break;
					  if (myFriends[i][0].equals(currentUserID))
					  {
							//System.out.println(myFriends[i][1]);
							if(myFriends[i][1].equals(friendID)){
								already_friend = true;
								break;
							}	
					  }
					  else
					  {
							//System.out.println(myFriends[i][0]);
							if(myFriends[i][0].equals(friendID)){
								already_friend = true;
								break;
							}
					  } 
				  }
				  if(friendID.equals(currentUserID)) //Don't want to add myself
						already_friend = true;
				  if(!already_friend) //only ask to connect if not already a friend
				  {
					  //CHECK IF ALREADY SENT A REQUEST
					  query = String.format("SELECT * FROM CONNECTION_USR WHERE UserId = '%s' AND connectionId = '%s'", currentUserID, friendID);
					  int check = esql.executeQuery(query);
					  if (check <= 0) //never sent the request
					  {
						   System.out.println("Would you like to connect with this person: ");
						  String input = in.readLine();
						  if(input.equals("Yes") || input.equals("yes") || input.equals("Y") || input.equals("y"))
						  {
								 query = String.format("INSERT INTO CONNECTION_USR (userId, connectionId, status) VALUES ('%s','%s','%s')", currentUserID, friendID, "Request");
								 esql.executeUpdate(query);
								 System.out.println("Connection request sent!\n");
						  }
					  }
				  }
				  else{
					  depth = depth -1; //ventured into a 1st level friend, so depth nullified
				  }
			}
			depth = depth + 1;
			//System.out.println("explored " + UserID + "'s friend list");
			//System.out.println("friendID: " + friendID);
			UserID = friendID; //Setting up next iteration
		}
	}
	catch(Exception e){
         System.err.println (e.getMessage());
      } 
  }
  
  //Accept or Reject connection requests
  public static void ConnectionRequests(ProfNetwork esql){
	  //Only search for those with connectionID = currentUserID and with pending requests
	  //userID, connectionID, status
	  
	  try{
		  String query = String.format("SELECT * FROM CONNECTION_USR WHERE connectionId = '%s' AND status = '%s'", currentUserID, "Request");
		  String[][] conn_list = esql.executeQueryAndReturnResult(query);

		  for (int i = 0; i < conn_list.length; i++)
		  {
			  query = String.format("SELECT name FROM USR WHERE userId = '%s'", conn_list[i][0]);
			  String[][] senderName = esql.executeQueryAndReturnResult(query);
			  System.out.println(i + ". " + senderName[0][0] + " sent a connection request to you.");
		  }
		  if (conn_list.length <= 0)
		      return;
		      
		  System.out.print("Do you want to accept any connections: ");
		  String input = in.readLine();
		  if(input.equals("Yes") || input.equals("yes") || input.equals("Y") || input.equals("y"))
		  {
			  System.out.print("\nWhich connection do you want to accept(#), or 'X' to go back to menu: ");
			  String conn_num = in.readLine();
			  if (conn_num.equals("X")) 
			      return;
			  int connectionNum = Integer.parseInt(conn_num);
			  String userID = conn_list[connectionNum][0];
			  query = String.format("UPDATE CONNECTION_USR SET status = '%s' WHERE userId = '%s' AND connectionId = '%s'", "Accept", userID, currentUserID);
			  esql.executeUpdate(query);
			  System.out.println("Successfully accepted the connection.");
		  }
		  System.out.print("Do you want to reject any connections: ");
		  input = in.readLine();
		  if(input.equals("Yes") || input.equals("yes") || input.equals("Y") || input.equals("y"))
		  {
			  System.out.print("\nWhich connection do you want to reject(#), or 'X' to go back to menu: ");
			  String conn_num = in.readLine();
			  if (conn_num.equals("X")) 
			      return;
			  int connectionNum = Integer.parseInt(conn_num);
			  String userID = conn_list[connectionNum][0];
			  query = String.format("UPDATE CONNECTION_USR SET status = '%s' WHERE userId = '%s' AND connectionId = '%s'", "Reject", userID, currentUserID);
			  esql.executeUpdate(query);
			  System.out.println("Successfully rejected the connection.");
		  }
	  }
	  catch(Exception e){
         System.err.println (e.getMessage());
         return;
      } 
  }
  
  
  //View and delete messages
  public static void ViewMessages(ProfNetwork esql){
	 // delete status
	  // 0 - both did not delete
	  // 1 - sender deleted message
	  // 2 - receiver deleted message
	  // 3 - both deleted the message
	  
	  try{
			//get messages sent to me/by me
			//delivered/read where delete status = 0/1
			String query = String.format("SELECT * FROM MESSAGE WHERE (receiverID = '%s' OR senderID = '%s') AND (deleteStatus = '%s' OR deleteStatus = '%s') AND (status = '%s' OR status = '%s')", 
								  currentUserID, currentUserID, '0', '1',"Read", "Delivered");
			String[][] messages = esql.executeQueryAndReturnResult(query);
			
			for (int i = 0; i < messages.length; i++)
			{	
				if (messages[i][1].equals(currentUserID) && messages[i][5].equals("1")) //if currentUser is the sender, remove this message with delete status == 1
				{
					messages[i] = null;
				}
				else
				{
					query = String.format("SELECT name FROM USR WHERE userID = '%s'", messages[i][1]);
					String[][] senderName = esql.executeQueryAndReturnResult(query);
					messages[i][1] = senderName[0][0]; // Replace SenderID with sender's name

					query = String.format("SELECT name FROM USR WHERE userID = '%s'", messages[i][2]);
					String[][] receiverName = esql.executeQueryAndReturnResult(query);
					messages[i][2] = receiverName[0][0]; //Overwrite ReceiverID with receiver's name
				}
			}
			
			PrintMessages(messages);
			boolean hasMessage = false;
			for(int i = 0; i < messages.length; i++)
			{
				if (messages[i] != null)
					hasMessage = true;
			}
			if (!hasMessage) 
			{
				System.out.println("No messages to be read \n");
				return;
			}
			
			//Delete Messages	
			System.out.print("\tWould you like to delete a message: ");
			String input = in.readLine();
			if(input.equals("Yes") || input.equals("yes") || input.equals("Y") || input.equals("y"))
			{
				System.out.print("\tEnter MsgID: ");
				String msgID = in.readLine();
				query = String.format("SELECT senderId, receiverId FROM MESSAGE WHERE msgId = '%s'", msgID);
				String[][] send_rcv = esql.executeQueryAndReturnResult(query);
				if (send_rcv[0][0].equals(currentUserID))  //currentUser is a sender
				{
					query = String.format("UPDATE MESSAGE SET deleteStatus = '%s' WHERE msgId = '%s'",'1', msgID);
					esql.executeUpdate(query);	
				}
				else if (send_rcv[0][1].equals(currentUserID))  //currentUser is a receiver
				{
					query = String.format("UPDATE MESSAGE SET deleteStatus = '%s' WHERE msgId = '%s'",'2', msgID);
					esql.executeUpdate(query);
				}
				System.out.println("Message was successfully deleted.");
			}
	  }
	  catch(Exception e){
         System.err.println (e.getMessage());
         return;
      }
  }
  
  //Search people by Full Name
  public static void SearchPeople(ProfNetwork esql){
	  try{  
		  System.out.print("\tEnter Full Name: ");
		  String name = in.readLine();
		
		  String query = String.format("SELECT name, email, dateOfBirth FROM USR WHERE name = '%s'", name);
		  String[][] people = esql.executeQueryAndReturnResult(query);
		  if (people.length <= 0){
	  	  	System.out.print("\tNo one with that name exists \n");
	  	  	return;
		  }
		  Object[] columns = {"Name", "Email", "DateOfBirth"};
		  System.out.format("%-30s%-30s%-30s\n", columns);
		  PrintResult (people);
	  }
	  catch(Exception e){
           System.err.println (e.getMessage());
	  }
  }

}//end ProfNetwork
