package dao;

import Model.personel;
import dao.DBHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dataFetcher {
    static Connection conn;
    static Statement stmt;

    static void startFetching() {
        DBHandler dbHandler = new DBHandler();
        dbHandler.openConnection();
        conn = dbHandler.getConn();
        createTableIfNotExist();
        getData();
    }

    public static void getData() {

        String sql = "select * from Personel where  left join Vacation on Personel.id = vacation.PersonelID";
        ResultSet rs;
        try {
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String nationalCode = rs.getString("NationalCode");
                personel p = personel.getPersonelByCode(nationalCode);
                if (p == null) {
                    int id = rs.getInt("ID");
                    String name = rs.getString("Name");
                    int age = rs.getInt("age");
                    boolean hasVacation = rs.getBoolean("hasVacation");
                    p = new personel(name, age, nationalCode);
                    p.setHasVacation(hasVacation);
                    if (hasVacation) {
                        int vacationDay = rs.getInt("VacationDay");
                        p.addVacation(vacationDay);
                    }
                } else {
                    boolean hasVacation = rs.getBoolean("hasVacation");
                    if (hasVacation) {
                        int vacationDay = rs.getInt("VacationDay");
                        p.addVacation(vacationDay);
                    }
                }

            }
    } catch(
    SQLException e)

    {
        e.printStackTrace();
    }

}

    public static void createTableIfNotExist() {
        try {
            stmt = conn.createStatement();
            String query = "";
            query = "CREATE TABLE Personel (\n" +
                    "     ID int AUTO_INCREMENT PRIMARY KEY,\n" +
                    "    Name varchar(255),\n" +
                    "    Age int,\n" +
                    "    NationalCode varchar(255),\n" +
                    "    HasVacation boolean \n" +
                    ");";
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            String query = "CREATE TABLE Vacation (\n" +
                    "     ID int AUTO_INCREMENT PRIMARY KEY,\n" +
                    "    VacationDay int, \n" +
                    "    PersonelID int, \n" +
                    "    foreign key (PersonelID) references Personel(ID)" +
                    ");";
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
