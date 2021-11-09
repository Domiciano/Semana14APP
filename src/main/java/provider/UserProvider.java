package provider;

import db.MySQL;
import entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class UserProvider {


    public ArrayList<User> getAll() throws ClassNotFoundException, SQLException {
        MySQL db = new MySQL();
        db.connect();
        ArrayList<User> users = new ArrayList<>();
        ResultSet resultSet = db.getDataBySQL("SELECT * FROM users2610");
        while(resultSet.next()){
            users.add(new User(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3)
                    ));
        }
        db.close();
        return users;
    }

    public void create(User user) throws ClassNotFoundException, SQLException {
        MySQL db = new MySQL();
        db.connect();
        String sql = "INSERT INTO users2610(id, name, age) VALUES ('%ID','%NAME',%AGE)";
        sql = sql.replace("%ID", UUID.randomUUID().toString());
        sql = sql.replace("%NAME",user.getName());
        sql = sql.replace("%AGE",""+user.getAge());
        db.commandSQL(sql);
    }

}
