package server.user;

import server.communication.packet.OutgoingPacket;
import server.communication.packet.packets.outgoing.LoginResultPacket;
import server.user.exceptions.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class User {
    private Socket clientSocket;
    private PrintWriter socketOut;

    private Connection con;
    private Statement st;
    private ResultSet rs;

    private String username = null;
    private String password = null;

    private String loginStatus = LOGIN_STATUS_LOGGEDOUT;

    public static final String LOGIN_STATUS_LOGGEDIN = "LOGGEDIN";
    public static final String LOGIN_STATUS_LOGGEDOUT = "LOGGEDOUT";

    private static List<User> userOnline = new ArrayList<User>();

    public User(Socket clientSocket, String username, String password) {
        this.clientSocket = clientSocket;
        this.username = username;
        this.password = password;
        try {
            socketOut = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");

            // Connection of database with driver manager
            String host = "dbserver-w10-die.einstein";
            String databaseName="UhGiYo_INFLK17";
            String userName = "root";
            String password = "w10";

            con = DriverManager.getConnection("jdbc:mysql://"+host+":3306/"+databaseName,userName,password);
            st = con.createStatement();

        } catch(Exception ex) {
            System.out.println("Error: " + ex);
        }

        // registration
        try {
            register(username, password);
        } catch(ClientAlreadyLoggedinException ex) {
            System.out.println(ex.getMessage());
        } catch(NameNotAvailableException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * login of a user
     * @param username username of the user
     * @param password of the user
     * @throws ClientAlreadyLoggedinException checking whether the client is already logged in
     * @throws UserNotExistException checking whether the user does not exists
     * @throws UserIsOnlineException checking whether the user is already online
     * @throws UserBannedException checking whether the user is banned
     */
    public void login(String username, String password) throws ClientAlreadyLoggedinException, UserNotExistException, UserIsOnlineException, UserBannedException {
        boolean permitted = false;
        if(isLoggedIn())
            throw new ClientAlreadyLoggedinException();

        // Checking whether the user exists
        try {
            String query = "SELECT username,password FROM users";
            rs = st.executeQuery(query);
            while(rs.next()) {
                String un = rs.getString("username");
                String pw = rs.getString("password");
                if(username.equals(un) && password.equals(pw))
                    permitted = true;
            }
            if(!permitted)
                throw new UserNotExistException();
        } catch(SQLException e) {
            e.printStackTrace();
        }

        boolean userIsOnline = false;
        for(User user : userOnline) {
            if(!user.isLoggedIn()) continue;
            if(user.getUsername().equals(username)) {
                userIsOnline = true;
                break;
            }
        }
        if(userIsOnline)
            throw new UserIsOnlineException();

        //TODO->SQL TEAM: Check if the user is banned and if so throw a UserBanned exception (look into the class contructor comment, inside the class to give correct parameters regarding the amount of minutes left banned/being banned permamently)
        try {
            String query = "SELECT username FROM users WHERE username = '" + username + "'";
            rs = st.executeQuery(query);
            while(rs.next()) {
                int banned = Integer.parseInt(rs.getString("banned")); // 0 = not banned, 1 = banned
                int banLength = Integer.parseInt(rs.getString("banLength"));
                if(banned == 1) {
                    throw new UserBannedException(banLength);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        //TODO->SQL TEAM + Julian K. let the user login (mark it in the sql database, aswell as in the server(add itself to userOnline))
        //TODO fill this.username
        new LoginResultPacket(this).sendPacket();
    }

    /**
     * registration and automatic login of a user
     * @param username username of the user
     * @param password password of the user
     * @throws ClientAlreadyLoggedinException checking whether the client is already logged in
     * @throws NameNotAvailableException checking whether the username is available
     */
    public void register(String username, String password) throws ClientAlreadyLoggedinException, NameNotAvailableException {
        if(isLoggedIn())
            throw new ClientAlreadyLoggedinException();

        // Checking whether the username is available
        try {
        String query = "SELECT username FROM users";
        rs = st.executeQuery(query);
        while(rs.next()) {
            String un = rs.getString("username");
            if(username.equals(un)) throw new NameNotAvailableException();
        }
        st.executeUpdate("INSERT INTO users (username, password) "
                + "VALUES ('" + username + "', '" + password + "')");
        JOptionPane.showMessageDialog(null, "Saved");
        } catch(SQLException e) {
            e.printStackTrace();
        }
        // login automically
        try {
            login(username,password);
        } catch (ClientAlreadyLoggedinException ex) {
            System.out.println(ex.getMessage());
        } catch(UserNotExistException ex) {
            System.out.println(ex.getMessage());
        } catch(UserIsOnlineException ex) {
            System.out.println(ex.getMessage());
        } catch(UserBannedException ex) {
            System.out.println(ex.getMessage());
        }

        //TODO->SQL TEAM + Julian K. let the user login (mark it in the sql database, aswell as in the server(add itself to userOnline))
        new LoginResultPacket(this).sendPacket();
    }

    public void disconnect() {
        System.out.println("A client disconnected");
        if(isLoggedIn()) logOut();
        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logOut() {

    }

    public void sendPacket(OutgoingPacket packet) {
        socketOut.println(packet.generatePacketObject().toString());
    }

    public boolean isLoggedIn() {
        return loginStatus.equals(LOGIN_STATUS_LOGGEDIN);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() { return password; }
}
