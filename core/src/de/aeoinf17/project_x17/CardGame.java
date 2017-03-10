package de.aeoinf17.project_x17;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class CardGame extends Game {
//idlasfzgf sdukh

	private int phase;

	private SpriteBatch batch;
	private BitmapFont font;

	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.BLACK);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		font.draw(batch, ""+Gdx.graphics.getFramesPerSecond(), 400, 300);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
	}

	public int getLifepoints(Player p){
		return p.getLifepoints();
	}
	public ArrayList<Card> getDeckCards(Player p){
		return p.getMomentaryDeck().getCards();
	}
	public ArrayList<Card> getHandkarten(Player p){
		return p.getHand().getCards();
	}
	//public ArrayList<Karte> getSpielfeldKarten(Spieler s){
	//	return s.getSpielfeldseite().getKarten();
	//}
	public ArrayList<Card> getFriedhofKarten(Player p){
		return p.getGraveyard().getKarten();
	}
	//// FEHLER
	public void setPhase (int phase){ this.phase = phase; }
	public void naechstePhase(){
		this.phase = phase + 1;
	}

	// Bei negativem Betrag werden Punkte abgezogen.
	public void aendereLebenspunkte(Player p,int betrag){
		p.setLifepoints(betrag);
	}


}
