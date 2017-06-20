package client.core.text_UI;

/**
 * Created by die on 20.06.2017.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


        import java.util.Scanner;

/**
 *
 * @author die
 */
public class TextTest {

    public static String spielerNeu(Scanner input) {
        System.out.print("Name des Spielers: ");
        return input.next();
    }

    public static String karteLegen(Scanner input) {
        System.out.print("Nr der Karte: ");
        return input.next();
    }

    public static int farbeWaehlen(Scanner input) {
        System.out.print("Gewünschte Farbe: ");
        return Integer.parseInt(input.next());
    }

    public static void main(String[] args) throws SpielFertigException {
        Scanner eingabe_s = new Scanner(System.in);
        String eingabe = "";
        Spielleiter sl = new Spielleiter();
        Spieler s = null;
        Karte k = null;

        sl.fuegeSpielerHinzu(new Spieler("1"));
        sl.fuegeSpielerHinzu(new Spieler("2"));
        sl.kartenAusteilen();


        //int spielernr = -1;

        while (!eingabe.equals("ENDE")) {
            System.out.print("Eingabe: ");
            eingabe = eingabe_s.next();
            switch (eingabe) {
                case "SPIELER_NEU":
                    sl.fuegeSpielerHinzu(new Spieler(spielerNeu(eingabe_s)));
                    System.out.println("Anzahl Spieler " + sl.getSpieleranzahl());
                    break;
                case "KARTEN_AUSTEILEN":
                    sl.kartenAusteilen();
                    System.out.println("Karten ausgeteilt!");
                    break;
                case "BEGINNE_SPIEL":
                    //spielernr = sl.getSpielerNr();
                    System.out.println("Spiel begonnen, Spieler " + sl.getSpielerNr() + " ist dran.");
                    break;
                case "ZEIGE":
                    s = sl.getSpieler(sl.getSpielerNr());
                    for (int i = 0; i < s.getKartenanzahl(); i++) {
                        System.out.print(i + ":" + s.getKarte(i) + "/");
                    }
                    System.out.println("");
                    System.out.println("Ablagestapel: "+sl.obersteKarteAblageStapel());
                    break;
                case "LEGE":
                    s = sl.getSpieler(sl.getSpielerNr());
                    String nr = TextTest.karteLegen(eingabe_s);
                    try {
                        int nr_int = Integer.parseInt(nr);

                        k = s.getKarte(nr_int);
                        try
                        {
                            sl.legeKarteAb(k);
                            System.out.println("Lege Karte " + k.toString());
                        }
                        catch (KarteNichtMoeglichException ex)
                        {
                            System.out.println("Diese Karte kann momentan nicht gelegt werden!");
                        }
                    }
                    catch(NumberFormatException e)
                    {
                        System.out.println("Bitte eine korrekte Zahl eingeben.");
                    }
                    catch (KarteSchonGelegtException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    catch (KeineWunschFarbeException e)
                    {
                        System.out.println("Bitte Wunschfarbe angeben!");
                        int farbe = TextTest.farbeWaehlen(eingabe_s);
                        k.setgewuenschteFarbe(farbe);
                        System.out.println("Bitte nochmals legen!");
                    }
                    break;
                case "UNO": sl.UNOButton(); System.out.println("Unobutton gedrückt.");
                    break;
                case "FERTIG":
                    sl.fertigButton();
                    System.out.println("Nächster Spieler ist " + sl.getSpielerNr());
                    break;
                default: System.out.println("Befehl nicht erkannt ");
            }
        }
        System.out.println("Spiel beendet");

    }
}
