package de.aeoinf17.project_x17;

public class MonsterCard extends Card {
    protected int angriffspunkte;
    protected int verteidigungspunkte;
    protected int stufe;
    protected boolean verdeckt;
    protected boolean angriffsmodus;

    public void setAngriffspunkte(int angriffspunkte) {
        this.angriffspunkte = angriffspunkte;
    }

    public void setVerteidigungspunkte(int verteidigungspunkte) {
        this.verteidigungspunkte = verteidigungspunkte;
    }

    public void setStufe(int stufe) {
        this.stufe = stufe;
    }

    public int getAngriffspunkte() {
        return angriffspunkte;
    }

    public int getVerteidigungspunkte() {
        return verteidigungspunkte;
    }

    public int getStufe() {
        return stufe;
    }
    public void conceal(){
        verdeckt = true;
    }
    public void reveal(){
        verdeckt = false;
    }
    public void changemode(){
        angriffsmodus = !angriffsmodus;
    }

}
