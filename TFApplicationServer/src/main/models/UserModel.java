package ngdemo.repositories.impl.mock;

import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import main.objects.Null;
import main.objects.User;

@Singleton
public class UserModel {

    public UserModel() {
        this.users = new ArrayList<>();
    }

    public static Connection connect () throws SQLException
    {
        String connectionURL = "jdbc:mysql://localhost:3306/twitterfinancial";
        Connection connection = null;
        String dbUsername = "mherr059";
        String dbPassword = "test123";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.out.println(" Unable to load driver. ");
        }
        
        connection = (Connection) DriverManager.getConnection(connectionURL, dbUsername, dbPassword);
        System.out.println(" Connection Established. ");
        
        return connection;  
    }

    public boolean create(int id) {
        ResultSet rs = null;
        
        PreparedStatement st = (PreparedStatement) connection.prepareStatement("SELECT * FROM users WHERE email = ?");
        st.setString(1, email);
        rs = st.executeQuery();
    
        //return false if email already taken
        if (rs == null) {
            connection.close();
            return false;
        } else {
            String query = "INSERT INTO users (" + " email," + " fname,"
                    + " lname," + " password ) VALUES (" + "?, ?, ?, ?)";

            st = (PreparedStatement) connection.prepareStatement(query);
            st.setString(1, email);
            st.setString(2, fName);
            st.setString(3, lName);
            st.setString(4, pass);
            st.setString(5, "u");

            st.executeUpdate();
            connection.close();
        }
        
        return true;
    }
    
    public void remove(int id) {
        this.users.remove(id);
    }

    public boolean doLogin(String email, String password) {
        ResultSet rs = null;
        
        PreparedStatement st = (PreparedStatement) connection
                .prepareStatement("SELECT username, password FROM Users WHERE username = ?");
        st.setString(1, username);
        rs = st.executeQuery();

        if (rs != null) {
            String user = "";
            String pass = "";

            while (rs.next()) {
                user = rs.getString("username");
                pass = rs.getString("password");
            }

            connection.close();
            if (username.compareTo(user) == 0
                    && password.compareTo(pass) == 0)
                return true;
        }
        
        return false;
    }

}
