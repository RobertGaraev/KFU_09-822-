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
            conection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/users", "postgres", "12345");
            Insert_new_information("ÎÎÎ Øóáà", "Russia", "Cheboksary", "óë.Ïåòðîâà, ä.4", "237-89-08", "mex@mail.ru");
            out_table();
            System.out.println(table);
            System.out.print("ïîæàëóéñòà ââåäèòå ñëåäóþùèå äàííûå:\n" + "Èìÿ:");
            a=scanner.nextLine();
            System.out.print("\nÑòðàíà:");
            b=scanner.nextLine();
            System.out.print("\nÃîðîä:");
            c=scanner.nextLine();
            System.out.print("\nÀäðåñ:");
            d=scanner.nextLine();
            System.out.print("\nÒåëåôîí:");
            e=scanner.nextLine();
            System.out.println("\nÝëåêòðîííàÿ ïî÷òà:");
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
        table="UPDATE users SET Èìÿ = 'Èíñòèòóò ÿäåðíûõ òåõíîëîãèé', Òåëåôîí = '511-11-11' WHERE Êîä_êëèåíòà = 4";
        stmt.executeUpdate(table);
        stmt.close();
    }

    public static void delete() throws SQLException {
        stmt = conection.createStatement();
        table="DELETE FROM users WHERE Èìÿ='Ëåâà÷åâ Í.Í.'";
        stmt.executeUpdate(table);
        stmt.close();
    }

    public static void out_table() throws SQLException {
        stmt = conection.createStatement();
       table="SELECT * FROM users";
        ResultSet resultSet = stmt.executeQuery(table);
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("Êîä_êëèåíòà") + " " + resultSet.getString("Èìÿ") + resultSet.getString("Ñòðàíà") + resultSet.getString("Ãîðîä")
                    + resultSet.getString("Àäðåñ") + resultSet.getString("Òåëåôîí") + resultSet.getString("Ýëåêòðîííàÿ_ïî÷òà"));
        }
        stmt.close();
    }
}
