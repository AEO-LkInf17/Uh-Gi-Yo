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

    private String username = null;

    private String loginStatus = LOGIN_STATUS_LOGGEDOFF;

    public static final String LOGIN_STATUS_LOGGEDIN = "LOGGEDIN";
    public static final String LOGIN_STATUS_LOGGEDOFF = "LOGGEDOFF";

    private static List<User> userOnline = new ArrayList<User>();

    public User(Socket clientSocket) {
        this.clientSocket = clientSocket;
        try {
            socketOut = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TODO->SQL TEAM: IMPLEMENT IT!!!
    public void login(String username) throws ClientAlreadyLoggedinException, UserNotExistException, UserIsOnlineException, UserBannedException {
        if(isLoggedIn())
            throw new ClientAlreadyLoggedinException();

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

        //TODO->SQL TEAM + Julian K. let the user login (mark it in the sql database, aswell as in the server(add itself to userOnline))
        //TODO fill this.username
        new LoginResultPacket(this).sendPacket();
    }

    //TODO->SQL TEAM: IMPLEMENT IT!!! (the register method should register an user AND automatically let him login)
    public void register(String username) throws ClientAlreadyLoggedinException, NameNotAvaiableException {
        if(isLoggedIn())
            throw new ClientAlreadyLoggedinException();

        //TODO->SQL TEAM: Check if the username is avaiable. If its not, then throw a NameNotAvaiableException

        //TODO->SQL TEAM: Register this user
        //TODO->SQL TEAM + Julian K. let the user login (mark it in the sql database, aswell as in the server(add itself to userOnline))
        new LoginResultPacket(this).sendPacket();
    }

    public void disconnect() {
        System.out.println("A client disconnected");
        if(isLoggedIn()) logOff();
        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logOff() {

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
}
