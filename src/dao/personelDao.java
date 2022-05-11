package dao;

import Model.personel;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class personelDao {
    DBHandler dbHandler = new DBHandler();
    public void createPersonel(personel p){
        Connection c = dbHandler.getConn();
        if(c!=null){
            try {
                Statement stmt = c.createStatement();
                String query = "insert into personel(name,age,nationalCode,hasVacation) values('"+p.getName()+"','"+p.getAge()+"','"+p.getNationalCode()+"',"+p.isHasVacation()+");";
                stmt.execute(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
