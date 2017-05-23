package server.logic;

import server.logic.Activity.Activities.DrawCardActivity;
import server.logic.Activity.Activity;
import server.logic.exceptions.NoDeckFoundException;

import java.util.ArrayList;

/**The class Game organize the game process which got all phases in it.
 *
 *
 * */
public class Game {

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
    private boolean running;
    private int roundcounter;
    private ArrayList<Activity> possibleActivities;


    public Game(Player c,Player o){phase = 0;round = 0;challenger = c;opponent = o;}

    public void setPhase(int p){phase = p;}
    public int getPhase(){return phase;}
    public void setCurrentPlayersTurn(Player p){currentPlayersTurn = p;}
    public Player getCurrentPlayersTurn(){return currentPlayersTurn;}
    public void setRound(int r){round = r;}
    public int getRound(){return round;}
    public void setRunning(boolean c){running = c;}
    public boolean getRunning(){return running;}

    public void nextPhase(){
        if (phase<5){phase = phase +1;}
        else{
            phase = 0;
            nextPlayer();
            roundcounter();
        }
    }

    public void nextPlayer(){
        if (currentPlayersTurn == challenger){
            currentPlayersTurn = opponent;
        }else{
            currentPlayersTurn = challenger;
        }
    }

    public void roundcounter(){
        if (roundcounter == 1){roundcounter = 2;}
        else {roundcounter = 1;nextRound();}
    }

    public void nextRound(){
        round = round +1;
    }

    public void timeOut (){
        nextPhase();
        sendPossibleActivities(currentPlayersTurn);
    }

    public void createStandardGame() throws NoDeckFoundException{
        if (challenger.getMomentaryDeck() == null){throw new NoDeckFoundException(challenger);}
        if (opponent.getMomentaryDeck() == null){throw new NoDeckFoundException(opponent);}
        round = 1;
        Hand h1 = new Hand(challenger);
        Hand h2 = new Hand(opponent);
        Field f1 = new Field(challenger);
        Field f2 = new Field(opponent);
        Graveyard g1 = new Graveyard(challenger);
        Graveyard g2 = new Graveyard(opponent);
        challenger.setLifepoints(8000);
        opponent.setLifepoints(8000);
    }

    public void sendPossibleActivities(Player player){
        if (currentPlayersTurn == player){
            if (phase == DRAW_PHASE){
                if (player.getDenyDrawing()==0){
                    possibleActivities.add(new DrawCardActivity(player));
                }

                possibleActivities.removeAll(possibleActivities);
            }else if (phase == STANDBY_PHASE){
                if (player.getDenyTrapCardEffect()==0){

                }

            }else if (phase == MAIN_PHASE_I){
                if (player.getDenySetSpell()==0){

                }
                if (player.getDenySetTrap()==0){

                }
                if (player.getDenySummon()==0){

                }
                if (player.getDenySpecialSummon()==0){

                }
                if (player.getDenyTrapCardEffect()==0){

                }
                if (player.getDenyMonsterCardEffect()==0){

                }


            }else if (phase == BATTLE_PHASE){
                if (player.getDenyAttack()==0){

                }
                if (player.getDenyTrapCardEffect()==0){

                }

            }else if (phase == MAIN_PHASE_II){
                if (player.getDenySetSpell()==0){

                }
                if (player.getDenySetTrap()==0){

                }
                if (player.getDenySummon()==0){

                }
                if (player.getDenySpecialSummon()==0){

                }
                if (player.getDenyTrapCardEffect()==0){

                }
                if (player.getDenyMonsterCardEffect()==0){

                }

            }else if (phase == END_PHASE){
                if (player.getDenyTrapCardEffect()==0){

                }

            }
        }else if(currentPlayersTurn != player){
            if (phase == DRAW_PHASE){
                if (player.getDenyTrapCardEffect()==0){

                }

            }else if (phase == STANDBY_PHASE){
                if (player.getDenyTrapCardEffect()==0){

                }
                //Andauernde Effekte ausführen
            }else if (phase == MAIN_PHASE_I){
                if (player.getDenyTrapCardEffect()==0){

                }

            }else if (phase == BATTLE_PHASE){
                if (player.getDenyTrapCardEffect()==0){

                }

            }else if (phase == MAIN_PHASE_II){
                if (player.getDenyTrapCardEffect()==0){

                }

            }else if (phase == END_PHASE){
                if (player.getDenyTrapCardEffect()==0){

                }

            }
        }

    }

    /*
    public void startStandardGame(){
        createStandardGame();
        setCurrentPlayersTurn(challenger);
        setPhase(0);
        setRunning(true);
        setRound(0);
        roundcounter = 2;
        while (running){
            //Drawphase
            roundcounter();
            getCurrentPlayersTurn().drawCard();
            //Anketten
            nextPhase();
            //Standbyphase
            //Fallen und Schnellzauber aktivieren
            //Anketten
            nextPhase();
            //Mainphase1
            //setzen von Zauber- Fallenkartren
            //Monster beschwören
            //Anketten
            //Fallenkarten aktivieren auch der Gegner
            //Monstereffekte
            nextPhase();
            //Battlephase
            //Angriffe
            //Fallen aktivieren + Schnellzauber
            //anketten
            nextPhase();
            //Mainphase2
            //setzen von Zauber- Fallenkartren
            //Monster beschwören
            //Anketten
            //Fallenkarten aktivieren auch der Gegner
            //Monstereffekte
            nextPhase();
            //Endphase
            //Fallen aktivieren
            //Anketten
            nextPhase();
            nextPlayer();
            if (challenger.getLifepoints() == 0){running = false;}
            if (opponent.getLifepoints() == 0){running = false;}
            if (challenger.getMomentaryDeck().getSizeCards() <= 0){running = false;}
            if (opponent.getMomentaryDeck().getSizeCards() <= 0){running = false;}


    }
    **/
}