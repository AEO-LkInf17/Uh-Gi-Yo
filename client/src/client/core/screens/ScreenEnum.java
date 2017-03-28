package client.core.screens;

import client.core.Game;

public enum ScreenEnum {
    SPLASH{
        public Screen getScreen(Game game) {
            return new SplashScreen(game);
        }

    }, MAIN_MENU{
        public Screen getScreen(Game game) {
            return new MainMenuScreen(game);
        }
    };

    public abstract Screen getScreen(Game game);
}
