package de.aeoinf17.project_x17;

public class Monsterkarte extends Karte {
    protected int angriffspunkte;
    protected int verteidigungspunkte;
    protected int stufe;

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

}
