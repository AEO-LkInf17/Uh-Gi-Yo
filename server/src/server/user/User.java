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
    private long lastKeepAliveArrival = System.currentTimeMillis();

    private String username = null;

    public static final String LOGIN_STATUS_LOGGEDOUT = "LOGGEDOUT";
    public static final String LOGIN_STATUS_LOGGEDIN = "LOGGEDIN";

    private String loginStatus = LOGIN_STATUS_LOGGEDOUT;

    private static List<User> userOnline = new ArrayList<User>();

    public User(Socket clientSocket) {
        this.clientSocket = clientSocket;
        try {
            socketOut = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * login of a user
     * @param username username of the user
     * @throws ClientAlreadyLoggedinException checking whether the client is already logged in
     * @throws UserNotExistException checking whether the user does not exists
     * @throws UserIsOnlineException checking whether the user is already online
     * @throws UserBannedException checking whether the user is banned, and if so, if the user is permamently banned or temporarly, and if so, how long temporarly
     */
    public void login(String username) throws ClientAlreadyLoggedinException, UserNotExistException, UserIsOnlineException, UserBannedException {
        if(isLoggedIn()) {
            throw new ClientAlreadyLoggedinException();
        }

        //TODO->SQL TEAM: Check if the user exists, if the user doesnt exist, throw a UserNotExistException

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

        //TODO->SQL TEAM + Julian K. let the user login (mark it in the sql database, aswell as in the server(username, userOnline List, loginStatus))

        new LoginResultPacket(this).sendPacket();
    }

    //TODO->SQL TEAM: IMPLEMENT IT!!! (the register method should register an user AND automatically let him login)
    public void register(String username) throws ClientAlreadyLoggedinException, NameNotAvailableException {
        if(isLoggedIn())
            throw new ClientAlreadyLoggedinException();

        //TODO->SQL TEAM: Check if the username is avaiable. If its not, then throw a NameNotAvaiableException

        //TODO->SQL TEAM: Register this user

        //TODO->SQL TEAM + Julian K. let the user login (mark it in the sql database, aswell as in the server(username, userOnline List, loginStatus))

        new LoginResultPacket(this).sendPacket();
    }

    public void disconnect() {
        if(isLoggedIn()) logOut();
        try {
            clientSocket.close();
            System.out.println("A client disconnected");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logOut() {
        username = null;
        userOnline.remove(this);
        loginStatus=LOGIN_STATUS_LOGGEDOUT;
        System.out.println("A user logged out");
    }

    public void sendPacket(OutgoingPacket packet) {
        socketOut.println(packet.generatePacketObject().toString());
    }

    public boolean isLoggedIn() {
        return loginStatus.equals(LOGIN_STATUS_LOGGEDIN);
    }

    public void updateKeepAlive() {
        lastKeepAliveArrival = System.currentTimeMillis();
    }

    public String getUsername() {
        return username;
    }
}