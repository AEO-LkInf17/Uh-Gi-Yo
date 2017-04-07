package server.logic;


/**Die Klasse Game beinhaltet eine Schleife, die den ganzen Spielverlauf organisiert. Das beinhaltet auch die einzelnen Phasen eines Zugs.
 * */
class Game {

    private static final int DRAW_PHASE = 0;
    private static final int STANDBY_PHASE = 1;
    private static final int MAIN_PHASE_I = 2;
    private static final int BATTLE_PHASE = 3;
    private static final int MAIN_PHASE_II = 4;
    private static final int END_PHASE = 5;

    private Player challenger;
    private Player opponent;

    private int phase;
    private Player currentPlayersTurn;
    private int round;


    public Game(Player c,Player o){phase = 0;round = 0;challenger = c;opponent = o;}

    public void setPhase(int p){phase = p;}
    public int getPhase(){return phase;}
    public void SetCurrentPlayersTurn(Player p){currentPlayersTurn = p;}
    public Player getCurrentPlayersTurn(){return currentPlayersTurn;}
    public void setRound(int r){round = r;}
    public int getRound(){return round;}

    public void nextPhase(){
        if (phase<5){phase = phase +1;}
        else{phase = 0;}
    }

    public void nextPlayer(){
        if (currentPlayersTurn == challenger){
            currentPlayersTurn = opponent;
        }else{
            currentPlayersTurn = challenger;
        }
    }

    public void nextRound(){
        round = round +1;
    }

    public void createStandardGame(){
        Hand h1 = new Hand(challenger);
        Hand h2 = new Hand(opponent);
        Field f1 = new Field(challenger);
        Field f2 = new Field(opponent);
        Graveyard g1 = new Graveyard(challenger);
        Graveyard g2 = new Graveyard(opponent);
        challenger.setLifepoints(8000);
        opponent.setLifepoints(8000);
    }

    public void startStandartGame(){
        createStandardGame();





        if (challenger.getLifepoints() == 0){
            // Spielende
        }
        if (opponent.getLifepoints() == 0){
            // Spielende
        }
    }

}
