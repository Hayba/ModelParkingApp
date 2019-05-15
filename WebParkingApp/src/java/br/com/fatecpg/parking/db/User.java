package br.com.fatecpg.parking.db;

import br.com.fatecpg.parking.web.Db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User {
    private long id;
    private String role;
    private String name;
    private String login;
    private long passwordHash;

    public static User getUser(String login, String password) throws Exception{
        Connection con = Db.getConnection();
        String SQL = "SELECT * FROM USERS WHERE login=? AND passwordhash=?";
        PreparedStatement st = con.prepareStatement(SQL);
        st.setString(1, login);
        st.setLong(2,password.hashCode());
        ResultSet rs = st.executeQuery();
        if(rs.next()){
            return new User(
                    rs.getInt("ID"),
                    rs.getString("ROLE"),
                    rs.getString("NAME"),
                    rs.getString("LOGIN"),
                    rs.getLong("PASSWORDHASH")
            );
        }else{
            return null;
        }
    }
    
    public User(long id, String role, String name, String login, long passwordHash) {
        this.id = id;
        this.role = role;
        this.name = name;
        this.login = login;
        this.passwordHash = passwordHash;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(long passwordHash) {
        this.passwordHash = passwordHash;
    }
    
}
