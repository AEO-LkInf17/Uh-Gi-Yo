package server.logic.cards;

public class SpellCard extends Card {
    // private ?? effekt;
    private boolean hidden;

    /***
     * @param n name
     * @param t type
     * @param p priority
     * @param l limitation
     */
    public SpellCard(String n,String t,int p,int l){
        super(n,t,p,l);
    }

    public void conceal(){hidden = true;}
    public void reveal(){
        hidden = false;
    }

}
