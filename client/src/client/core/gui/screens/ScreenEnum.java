package client.core.gui.screens;

import client.core.Application;

public enum ScreenEnum {
    LOADING {
        public AbstractScreen getScreen(Application application) {
            return new LoadingScreen(application);
        }
    }, MAIN_MENU {
        public AbstractScreen getScreen(Application application) {
            return new MainMenuScreen(application);
        }
    };

    public abstract AbstractScreen getScreen(Application application);
}
