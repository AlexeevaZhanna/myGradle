package ru.my.shop.Person;

import ru.my.shop.MySqlConnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonService extends MySqlConnect {

    public static void insertPerson(Person p) throws SQLException {
        Statement st = getConnection().createStatement();
        String query = "INSERT INTO person (uname, lname, age, tel, address, login, password)  VALUES ('" + p.getUname() + "',  '" + p.getLname() + "' , '" + p.getAge() + "', '" + p.getTel() + "', '" + p.getAddress() + "','" + p.getLogin() + "','" + p.getPassword() + "')";
        st.executeUpdate(query);
        int row = st.executeUpdate(query);
        System.out.println(row);
    }

    public static ResultSet foundPerson(Person p) throws SQLException {
        Statement st = getConnection().createStatement();
        String query = "SELECT * FROM person WHERE login = '" + p.getLogin() + "' AND password = '" + p.getPassword() + "'";
        System.out.println(query);
        ResultSet row = st.executeQuery(query);
        System.out.println(row);
        return row;
    }

    public static ResultSet searchPerson(String uname, String lname, String age, String tel, String login) throws SQLException {
        Statement st = getConnection().createStatement();
        String query = "SELECT * FROM person WHERE uname = '" + uname + "' OR lname = '" + lname + "' OR age = '" + age + "' OR tel = '" + tel + "' OR login = '" + login + "'";
        System.out.println(query);
        ResultSet row = st.executeQuery(query);
        System.out.println(row); 
        return row;
    }

    public static void deletePerson(String login) throws SQLException {
        Statement st = getConnection().createStatement();
        String query = "DELETE FROM person WHERE login = '" + login + "'";
        st.executeUpdate(query);
        int row = st.executeUpdate(query);
        System.out.println(row);
    }
}

