package server.logic;


import server.logic.cards.EffectMonsterCard;

import java.sql.*;
import java.util.ArrayList;

/**
 * This class is representing the deck editor of the game
 */
public class DeckEditor {

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private ArrayList<EffectMonsterCard> cards = new ArrayList<>();

    public DeckEditor() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            // connection of the database with the driver-manager
            String host = "dbserver-w10-die.einstein";
            String databaseName="sampleSchema";
            String userName = "root";
            String password = "w10";

            con = DriverManager.getConnection("jdbc:mysql://"+host+":3306/"+databaseName,userName,password);
            st = con.createStatement();

        } catch(Exception ex) {
            System.out.println("Error: " + ex);
        }

        for(EffectMonsterCard c : getCards()) {
            System.out.println("Name: " + c.getName());
            System.out.println("Type: " + c.getType());
            System.out.println("Priority: " + c.getPriority());
            System.out.println("Level: " + c.getLevel());
            System.out.println("Attack Points: " + c.getAttackpoints());
            System.out.println("Defense Points: " + c.getDefensepoints());
            System.out.println("Effect Name: " + c.getEffectName());
            System.out.println("Effect Description: " + c.getEffectDescription());
        }
    }

    /**
     * the effectmonstercards are being pulled from the database and
     * are being returned with their parameters in an arraylist
     * @return arraylist with effectmonstercards
     */
    private ArrayList<EffectMonsterCard> getCards() {
        try {
            String query = "select * from effectmonsters";
            rs = st.executeQuery(query);
            // As long as there is something in the database
            while(rs.next()) {
                String name = rs.getString("name");
                String type = rs.getString("type");
                int priority = Integer.parseInt(rs.getString("priority"));
                int level = Integer.parseInt(rs.getString("level"));
                int attack_points = Integer.parseInt(rs.getString("attack points"));
                int defense_points = Integer.parseInt(rs.getString("defense points"));
                String effect_name = rs.getString("effect name");
                String effect_description = rs.getString("effect description");
                //cards.add(new EffectMonsterCard(name,type,priority,attack_points,defense_points,level,effect_name,effect_description));
            }
            return this.cards;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Records from database");
        return null;
    }

    public static void main(String[] args) {
        new DeckEditor();
    }
}

