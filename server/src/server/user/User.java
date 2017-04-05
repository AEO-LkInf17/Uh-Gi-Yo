package server.user;

import server.communication.packet.OutgoingPacket;
import server.user.UserExceptions.*;

import java.net.Socket;

public class User {
    private Socket clientSocket;

    private String loginStatus = LOGIN_STATUS_LOGGEDOFF;

    public static final String LOGIN_STATUS_LOGGEDIN = "LOGGEDIN";
    public static final String LOGIN_STATUS_LOGGEDOFF = "LOGGEDOFF";

    public User(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    //TODO->SQL TEAM: IMPLEMENT IT!!!
    public void login(String username) throws UserNotExistException, UserIsOnlineException, UserBannedException {

    }

    //TODO->SQL TEAM: IMPLEMENT IT!!! (the register method should register an user AND automatically let him login)
    public void register(String username) throws ClientAlreadyLoggedinException, NameNotAvaiableException {

    }

    public void sendPacket(OutgoingPacket packet) {

    }

    public boolean isLoggedIn() {
        return loginStatus.equals(LOGIN_STATUS_LOGGEDIN);
    }
}
