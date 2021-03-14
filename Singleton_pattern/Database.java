package Singleton_pattern;
import java.sql.*;

public class Database
{
    private static Database instance; //declare static instance of the class, of type Database

    private Database()
    {
        String URL = "jdbc:postgresql://localhost:5432/singleton"; //providing 3 strings for URL, username and password of the user in pgadmin
        String username = "postgres";
        String password = "ict05";

        try {
            Connection con = DriverManager.getConnection(URL, username, password); //connecting to the database
        }
        catch(SQLException sqlException) //use try-catch block for connection. And provide SQLException for any exception happening
        {
            sqlException.printStackTrace();
        }
    }

    public static Database getInstance() //provide getInstance method for controlling access to our instance of the class
    {
        if(instance == null) //check if our instance is null
        {
            instance = new Database(); //then call constructor of the class
        }
        return instance; //and in the end, we will return our instance
    }

    public void query(String sql) throws SQLException
    {
        String url = "jdbc:postgresql://localhost:5432/patterns";  //providing 3 strings for URL, username and password of the user in pgadmin
        String username = "postgres";
        String password = "ict05";

        Connection connection = DriverManager.getConnection(url , username, password); //connecting to the database

        Statement statement = connection.createStatement(); //it is mindful to execute queries with the database

        ResultSet resultSet = statement.executeQuery(sql); //call executeQuery for executing queries to database. To get all results of our query

        while(resultSet.next()){ //loop will process till resultSet has the data
            //output data in provided format below
            System.out.println("User: " + resultSet.getInt(1) + " | value: " + resultSet.getInt(2));
        }
    }


}

class Application
{
    public static void main(String[] args)
    {
        //providing two instances and call query method and we can see that result will be the same
        try
        {
            Database foo = Database.getInstance();
            foo.query("SELECT * from queries");
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }

        try {
            Database bar = Database.getInstance();
            bar.query("SELECT * from queries");
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
}