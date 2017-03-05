package de.aeoinf17.project_x17;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class CardGame extends Game {

	// Phasen: Draw- Standby- Main- Battle- Main2- End-
	private static final int DRAW_PHASE = 0;
	private static final int STANDBY_PHASE = 1;
	private static final int MAIN_PHASE_I = 2;
	private static final int BATTLE_PHASE = 3;
	private static final int MAIN_PHASE_II = 4;
	private static final int END_PHASE = 5;

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

	public int getLebenspunkte(Spieler s){
		return s.getLebenspunkte();
	}
	public ArrayList<Karte> getDeckKarten(Spieler s){
		return s.getMomentanesDeck().getKarten();
	}
	public ArrayList<Karte> getHandkarten(Spieler s){
		return s.getHand().getKarten();
	}
	//public ArrayList<Karte> getSpielfeldKarten(Spieler s){
	//	return s.getSpielfeldseite().getKarten();
	//}
	public ArrayList<Karte> getFriedhofKarten(Spieler s){
		return s.getFriedhof().getKarten();
	}
	//// FEHLER
	public void setPhase (int phase){ this.phase = phase; }
	public void naechstePhase(){
		this.phase = phase + 1;
	}

	// Bei negativem Betrag werden Punkte abgezogen.
	public void aendereLebenspunkte(Spieler s,int betrag){
		s.setLebenspunkte(betrag);
	}


}
