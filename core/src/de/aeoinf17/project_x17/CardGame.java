package de.aeoinf17.project_x17;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class CardGame extends Game {
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

	public int getLebenspunkte(Spieler s){
		return s.getLebenspunkte();
	}
	public ArrayList<Karte> getDeckKarten(Spieler s){
		return s.getMomentanesDeck().getKarten();
	}
	public ArrayList<Karte> getHandkarten(Spieler s){
		return s.getHand().getKarten();
	}
	public ArrayList<Karte> getSpielfeldKarten(Spieler s){
		return s.getSpielfeldseite().getKarten();
	}
	public ArrayList<Karte> getFriedhofKarten(Spieler s){
		return s.getFriedhof().getKarten();
	}

	// Bei negativem Betrag werden Punkte abgezogen.
	public void aendereLebenspunkte(Spieler s,int betrag){
		s.setLebenspunkte(betrag);
	}

}
