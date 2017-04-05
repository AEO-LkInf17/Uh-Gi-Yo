package server.logic;


/**Die Klasse Game beinhaltet eine Schleife, die den ganzen Spielverlauf organisiert. Das beinhaltet auch die einzelnen Phasen eines Zugs.
 * */
public class Game {

    private static final int DRAW_PHASE = 0;
    private static final int STANDBY_PHASE = 1;
    private static final int MAIN_PHASE_I = 2;
    private static final int BATTLE_PHASE = 3;
    private static final int MAIN_PHASE_II = 4;
    private static final int END_PHASE = 5;

    private int phase;
    private Player currentPlayersTurn;
    private int round;

    public void setPhase(int p){phase = p;}
    public int getPhase(){return phase;}
    public void SetCurrentPlayersTurn(Player p){currentPlayersTurn = p;}
    public Player getCurrentPlayersTurn(){return currentPlayersTurn;}
    public void setRound(int r){round = r;}
    public int getRound(){return round;}
}
