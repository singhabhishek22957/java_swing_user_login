import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class DbConnection {
    private String user = "root";
    private String url = "jdbc:mysql://localhost/uscs";
    private String password = "abhishek";

    private String userName;
    private int userAge;
    private String userEmail;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public boolean createUser(String name, String email, int age, String password ){
        String query = "insert into user (name ,email, age , password) values(?,?,?,?)";
        try{

            Connection conn = DriverManager.getConnection(url,user,this.password);
            if(conn==null || conn.isClosed()){
                System.out.println("Error to connect DB");
                return false;
            }
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setInt(3,age);
            pstmt.setString(4,password);
            pstmt.setString(2,email);

            int rowUpdated = pstmt.executeUpdate();

            return rowUpdated>0;


        }catch (Exception e){
            System.out.println("Error to create user "+e);
            return  false;
        }
    }

    public boolean loginUser (String email , String password){
        String query = "select * from user where email =?   limit 1";
        try{

            Connection conn = DriverManager.getConnection(url,user,this.password);
            if(conn==null || conn.isClosed()){
                System.out.println("Error to connect DB");
                return false;
            }
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1,email);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            // take user data form data base ;
            setUserAge(rs.getInt("age"));
            setUserName(rs.getString("name"));
            setUserEmail(rs.getString("email"));

            String userPassword = rs.getString("password");

            if(Objects.equals(password, userPassword)){
                System.out.println("Your Login successfully");



                return true;
            }else {
                return false;
            }




        }catch (Exception e){
            System.out.println("Error to create user "+e);
            return  false;
        }
    }
}




