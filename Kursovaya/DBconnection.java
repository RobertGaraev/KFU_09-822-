package Kursovaya;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;

import java.sql.*;

public class DBconnection {
    static PreparedStatement ps;
    static Connection conection;
    static Statement stmt;
    static String table;

    public static boolean proverka(TextField login, PasswordField password, boolean p) throws SQLException, NullPointerException {
        conection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Kursach", "postgres", "flatron147");

        stmt = conection.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM users");
        while (resultSet.next()) {
            String check_login = resultSet.getString(5);
            String check_password = resultSet.getString(6);
            if (p && check_login.equals(login.getText()) && check_password.equals(password.getText()))
                return true;
            if (!p && check_login.equals(login.getText()))
                return true;
        }
        return false;
    }


    public static void Insert_new_information(TextField name, TextField lastname, TextField phone, TextField country, TextField login, PasswordField password) throws SQLException {
        stmt = conection.createStatement();
        table = "INSERT INTO users VALUES ('" + name.getText() + "','" + lastname.getText() + "','" + phone.getText() + "','" + country.getText() + "','" + login.getText() + "','" + password.getText() + "')";
        stmt.executeUpdate(table);
        stmt.close();
    }

    //метод для заполнения БД данными из файла, при возникновении одинаковых дат, пользователей и валют происходит перезапись данной строки на строку из файла
    public static void addtotableBD(String file) throws SQLException, IOException {
        conection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Kursach", "postgres", "flatron147");
        String date, currency;
        double open, high, low, close;
        String user_name = FirstWindowController.FirstName();

        BufferedReader br = new BufferedReader(new FileReader(new File(file)));
        String line = br.readLine();
        while (line != null) {
            date = line.substring(9, 17);
            currency = line.substring(0, 6);
            open = Double.parseDouble(line.substring(25, 35));
            high = Double.parseDouble(line.substring(36, 46));
            low = Double.parseDouble(line.substring(47, 57));
            close = Double.parseDouble(line.substring(58, 68));
            stmt = conection.createStatement();
            Statement st = conection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM tablee");
            boolean p = true;
            while (resultSet.next()) {
                String check_date = resultSet.getString(1);
                String check_user = resultSet.getString(7);
                String check_currency = resultSet.getString(6);
                if (check_date.equals(date) && check_user.equals(user_name) && check_currency.equals(currency)) {
                    table = "UPDATE tablee SET open = " + open + ", high = " + high + ", low = " + low + ", close = " + close + "  " +
                            "WHERE datee = '" + date + "' AND currency = '" + currency + "' AND user = '" + user_name + "'";
                    st.executeUpdate(table);
                    p = false;
                }
            }
            if (p) {
                table = "INSERT INTO tablee VALUES ('" + date + "'," + open + "," + high + "," + low + "," + close + ",'" + currency + "','" + user_name + "')";
                stmt.executeUpdate(table);
                stmt.close();
            }
            line = br.readLine();
        }
    }
////            table = "INSERT INTO tablee VALUES ('" + date + "'," + open + "," + high + "," + low + "," + close + ",'" + currency + "','"+user_name+"')";
////            ps = conection.prepareStatement(table);
////            ps.executeUpdate();
////            line = br.readLine();
}