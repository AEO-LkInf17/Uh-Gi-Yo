package server.logic;

import java.util.ArrayList;

public class DeckEditor {

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private ArrayList<EffectMonsterCard> cards = new ArrayList<>();

    public DeckEditor() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            // Verbindung der Datenbank mit dem Treiber-Manager
            String host = "dbserver-w10-die.einstein";
            String databaseName="sampleSchema";
            String userName = "root";
            String password = "w10";

            con = DriverManager.getConnection("jdbc:mysql://"+host+":3306/"+databaseName,userName,password);
            st = con.createStatement();

        } catch(Exception ex) {
            System.out.println("Error: " + ex);
        }

        for(Effektmonsterkarte c : getCards()) {
            System.out.println("Name: " + c.getName());
            System.out.println("Type: " + c.getType());
            System.out.println("Priority: " + c.getPriority());
            /*System.out.println("Level: " + c.getLevel());
            System.out.println("Attack Points: " + c.getAttackPoints());
            System.out.println("Defense Points: " + c.getDefensePoints());
            System.out.println("Effect Name: " + c.getEffectName());
            System.out.println("Effect Description: " + c.getEffectDescription());*/

        }
    }

    private ArrayList<Effektmonsterkarte> getCards() {
        try {
            String query = "select * from effectmonsters";
            rs = st.executeQuery(query);
            // Solange noch etwas in der Datenbank ist
            while(rs.next()) {
                String name = rs.getString("name");
                String type = rs.getString("type");
                int priority = Integer.parseInt(rs.getString("priority"));
                int level = Integer.parseInt(rs.getString("level"));
                int attack_points = Integer.parseInt(rs.getString("attack points"));
                int defense_points = Integer.parseInt(rs.getString("defense points"));
                String effect_name = rs.getString("effect name");
                String effect_description = rs.getString("effect description");
                //cards.add(new Effektmonsterkarte(name,type,priority,attack_points,defense_points,level,effect_name,effect_description));
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

