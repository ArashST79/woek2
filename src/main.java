import Model.personel;
import View.viewHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class main {
    public static void main(String[] args) {
        DBHandler dbHandler = new DBHandler();
        dbHandler.openConnection();
        Connection conn = dbHandler.getConn();
        try {
            Statement stmt = conn.createStatement();
            String query = "CREATE TABLE Persons (\n" +
                    "    PersonID int,\n" +
                    "    LastName varchar(255),\n" +
                    "    FirstName varchar(255),\n" +
                    "    Address varchar(255),\n" +
                    "    City varchar(255)\n" +
                    ");";
            stmt.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String query = "select * from persons";
            ResultSet rs=stmt.executeQuery(query);
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        viewHandler.startView();
    }
}
