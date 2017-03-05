package de.aeoinf17.project_x17;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class CardGame extends Game {



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

	public int getLebenspunkte(Player s){
		return s.getLifepoints();
	}
	public ArrayList<Card> getDeckKarten(Player s){
		return s.getMomentaryDeck().getCards();
	}
	public ArrayList<Card> getHandkarten(Player s){
		return s.getHand().getCards();
	}
	public ArrayList<Card> getSpielfeldKarten(Player s){
		return s.getGamefield().getKarten();
	}
	public ArrayList<Card> getFriedhofKarten(Player s){
		return s.getGraveyard().getKarten();
	}
	//// FEHLER
	public void setPhase (int phase){ this.phase = phase; }
	public void naechstePhase(){
		this.phase = phase + 1;
	}

	// Bei negativem Betrag werden Punkte abgezogen.
	public void aendereLebenspunkte(Player s, int betrag){
		s.setLifepoints(betrag);
	}


}
