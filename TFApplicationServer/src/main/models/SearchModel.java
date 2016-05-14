package main.models;

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
import main.objects.Search;
import main.objects.Company;

@Singleton
public class SearchModel {

    Object search = null;

    public SearchModel() {
        this.search = new Search();
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
    
    public SearchService(SearchModel searchModel) {
        this.searchModel = searchModel;
    }
    
    public int requestIPCount(String ip) {
        ResultSet rs = null;
        
        PreparedStatement st = (PreparedStatement) connection
                .prepareStatement("SELECT ip FROM search WHERE ip = ?");
        st.setString(1, ip);
        rs = st.executeQuery();

        if (rs != null) {
            
            // Get count and return false if logged in user and over 
            
            return true;
        }
        
        return false;
    }
    
    public Object requestTwitterInfo(int companyID) {
        ResultSet rs = null;
        
        PreparedStatement st = (PreparedStatement) connection
                .prepareStatement("SELECT * FROM company_social WHERE companyID = ?");
        st.setString(1, companyID);
        rs = st.executeQuery();

        if (rs != null) {
            
            return rs;
        }
        
        return false;
    }

    
    public Object requestStockInfo(int companyID) {
        ResultSet rs = null;
        
        PreparedStatement st = (PreparedStatement) connection
                .prepareStatement("SELECT * FROM company_stock WHERE companyID = ?");
        st.setString(1, companyID);
        rs = st.executeQuery();

        if (rs != null) {
            
            return rs;
        }
        
        return false;
    }

    
    public Object doFavorite(Object company) {
        return this.searchModel.requestStockInfo(company);
    }

    
    public Object doSearch(String ticker) {
        return this.searchModel.doSearch(ticker);
    }
}
