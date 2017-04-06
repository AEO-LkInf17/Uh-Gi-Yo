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
    public void login(String username) throws ClientAlreadyLoggedinException, UserNotExistException, UserIsOnlineException, UserBannedException {
        //TODO->Julian K. edit protocol diagramms -> add ClientAlreadyLoggedinFailure

        if(isLoggedIn())
            throw new ClientAlreadyLoggedinException();
        //TODO->SQL TEAM: Check if the user exists, if the user doesnt exist, throw a UserNotExistException

        //TODO->Julian K. Check if the user is online (implement the way, how to aswell) and the user is actually online, throw a UserIsOnlineException

        //TODO->SQL TEAM: Check if the user is banned and if so throw a UserBanned exception (look into the class contructor comment, inside the class to give correct parameters regarding the amount of minutes left banned/being banned permamently)

        //TODO->SQL TEAM + Julian K. let the user login (mark it in the sql database, aswell as in the server)
    }

    //TODO->SQL TEAM: IMPLEMENT IT!!! (the register method should register an user AND automatically let him login)
    public void register(String username) throws ClientAlreadyLoggedinException, NameNotAvaiableException {
        if(isLoggedIn())
            throw new ClientAlreadyLoggedinException();

        //TODO->SQL TEAM: Check if the username is avaiable. If its not, then throw a NameNotAvaiableException

        //TODO->SQL TEAM: Register this user
        //TODO->SQL TEAM + Julian K. let the user login (mark it in the sql database, aswell as in the server)
    }

    public void sendPacket(OutgoingPacket packet) {

    }

    public boolean isLoggedIn() {
        return loginStatus.equals(LOGIN_STATUS_LOGGEDIN);
    }
}
