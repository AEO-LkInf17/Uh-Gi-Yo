package server.user.exceptions;

public class UserBannedException extends Exception {
    private int banLength;

    public static final int BANNED_PERM = 0;

    public UserBannedException(int banLength) {
        super(banLength==0 ? "User is permamently banned!" : "User is banned for " + banLength + " minutes!");
        this.banLength = banLength;
    }

    public int getBanLength() {
        return banLength;
    }
}
