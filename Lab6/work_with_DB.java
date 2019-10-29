package Kurs2.lab.Lab6;

import java.sql.*;
import java.util.Scanner;

public class work_with_DB {
    static Connection conection;
    static Statement stmt;
    static String table;

    public static void main(String[] args) throws SQLException {
        try {
            Scanner scanner = new Scanner(System.in);
            String a,b,c,d,e,f;
            conection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/users", "postgres", "flatron147");
            Insert_new_information("ООО Шуба", "Russia", "Cheboksary", "ул.Петрова, д.4", "237-89-08", "mex@mail.ru");
            out_table();
            System.out.println(table);
            System.out.print("пожалуйста введите следующие данные:\n" + "Имя:");
            a=scanner.nextLine();
            System.out.print("\nСтрана:");
            b=scanner.nextLine();
            System.out.print("\nГород:");
            c=scanner.nextLine();
            System.out.print("\nАдрес:");
            d=scanner.nextLine();
            System.out.print("\nТелефон:");
            e=scanner.nextLine();
            System.out.println("\nЭлектронная почта:");
            f=scanner.nextLine();
            Insert_new_information(a, b, c, d, e, f);
            out_table();
            change();
            out_table();
            delete();
            out_table();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void Insert_new_information(String name, String country, String city, String address, String phone, String email) throws SQLException {
        stmt = conection.createStatement();
        table ="INSERT INTO users VALUES ('" + name + "','" + country + "','" + city + "','" + address + "','" + phone + "','" + email + "')";
        stmt.executeUpdate(table);
        stmt.close();
    }

    public static void change() throws SQLException {
        stmt = conection.createStatement();
        table="UPDATE users SET Имя = 'Институт ядерных технологий', Телефон = '511-11-11' WHERE Код_клиента = 4";
        stmt.executeUpdate(table);
        stmt.close();
    }

    public static void delete() throws SQLException {
        stmt = conection.createStatement();
        table="DELETE FROM users WHERE Имя='Левачев Н.Н.'";
        stmt.executeUpdate(table);
        stmt.close();
    }

    public static void out_table() throws SQLException {
        stmt = conection.createStatement();
       table="SELECT * FROM users";
        ResultSet resultSet = stmt.executeQuery(table);
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("Код_клиента") + " " + resultSet.getString("Имя") + resultSet.getString("Страна") + resultSet.getString("Город")
                    + resultSet.getString("Адрес") + resultSet.getString("Телефон") + resultSet.getString("Электронная_почта"));
        }
        stmt.close();
    }
}