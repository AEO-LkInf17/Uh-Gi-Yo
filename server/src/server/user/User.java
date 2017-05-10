package server.user;

import server.Main;
import server.communication.packet.OutgoingPacket;
import server.communication.packet.packets.outgoing.ActivityListPacket;
import server.communication.packet.packets.outgoing.LoginResultPacket;
import server.communication.packet.packets.outgoing.RegisterResultPacket;
import server.logic.Activity.Activity;
import server.sql.SQL;
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

    public static boolean isUserOnline(String username) {
        boolean userIsOnline = false;
        for(User user : userOnline) {
            if(!user.isLoggedIn()) continue;
            if(user.getUsername().equals(username)) {
                userIsOnline = true;
                break;
            }
        }
        return userIsOnline;
    }

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

        if(!Main.getSql().userExists(username)) {
            throw new UserNotExistException();
        }

        if(isUserOnline(username))
            throw new UserIsOnlineException();

        int banLength = 0;
        if(Main.getSql().userIsBanned(username)) {
            throw new UserBannedException(banLength);
        }

        Main.getSql().changeLoginStatusTo(true, username);

        userOnline.add(this);
        loginStatus = LOGIN_STATUS_LOGGEDIN;

        new LoginResultPacket(this).sendPacket();
    }

    public void register(String username) throws ClientAlreadyLoggedinException, NameNotAvailableException {
        if(isLoggedIn())
            throw new ClientAlreadyLoggedinException();

        if(!Main.getSql().usernameIsAvailable(username)) {
            throw new NameNotAvailableException();
        }

        Main.getSql().saveNewUsername(username);
        Main.getSql().changeLoginStatusTo(true, username);
        userOnline.add(this);
        loginStatus = LOGIN_STATUS_LOGGEDIN;

        new RegisterResultPacket(this).sendPacket();
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
        Main.getSql().changeLoginStatusTo(false, username);
        userOnline.remove(this);
        loginStatus=LOGIN_STATUS_LOGGEDOUT;
        username = null;
        System.out.println("A user logged out");
    }

    public void sendActivityList(int time, Activity ... activities) {
        new ActivityListPacket(this, time);
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