package client.core.screens;

import client.core.Game;

public enum ScreenEnum {
    SPLASH{
        public AbstractScreen getScreen(Game game) {
            return new SplashScreen(game);
        }

    }, MAIN_MENU{
        public AbstractScreen getScreen(Game game) {
            return new MainMenuScreen(game);
        }
    };

    public abstract AbstractScreen getScreen(Game game);
}
