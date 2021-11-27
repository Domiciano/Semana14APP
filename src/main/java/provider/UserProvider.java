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
                    resultSet.getInt(3),
                    resultSet.getBoolean(4)
                    ));
        }
        db.close();
        return users;
    }

    public void create(User user) throws ClassNotFoundException, SQLException {
        MySQL db = new MySQL();
        db.connect();
        String sql = "INSERT INTO users2610(id, name, age, blocked) VALUES ('%ID','%NAME',%AGE, %BLOCKED)";
        sql = sql.replace("%ID", UUID.randomUUID().toString());
        sql = sql.replace("%NAME",user.getName());
        sql = sql.replace("%AGE",""+user.getAge());
        sql = sql.replace("%BLOCKED",""+user.isBlocked());
        db.commandSQL(sql);
        db.close();
    }

    public ArrayList<User> getPage(int page, int limit) throws ClassNotFoundException, SQLException {
        ArrayList<User> users = new ArrayList<>();
        MySQL db = new MySQL();
        db.connect();
        String sql = "SELECT * FROM users2610 ORDER BY id LIMIT $LIMIT OFFSET $OFFSET";
        sql = sql.replace("$LIMIT", limit+"");
        sql = sql.replace("$OFFSET", ""+(page*limit));
        ResultSet resultSet = db.getDataBySQL(sql);
        while (resultSet.next()){
            users.add(new User(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getBoolean(4)
            ));
        }
        db.close();
        return users;
    }



}
