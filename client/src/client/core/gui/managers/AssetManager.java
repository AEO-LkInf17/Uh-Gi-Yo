package client.core.gui.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.*;

public class AssetManager implements Disposable {

    private static AssetManager instance;

    private com.badlogic.gdx.assets.AssetManager manager;
    private JsonReader jsonReader;

    private ObjectMap<String, Array<Asset>> groups;

    private AssetManager() {
        super();
    }

    public static AssetManager getInstance() {
        if (instance == null) {
            instance = new AssetManager();
        }
        return instance;
    }

    public void initialize() {
        manager = new com.badlogic.gdx.assets.AssetManager();
        jsonReader = new JsonReader();
    }

    public void initialize(String file) {
        manager = new com.badlogic.gdx.assets.AssetManager();
        jsonReader = new JsonReader();

        loadGroups(file);
    }

    public void loadGroups(String file) {
        groups = new ObjectMap<String, Array<Asset>>();

        JsonValue root = jsonReader.parse(Gdx.files.internal(file));

        for (JsonValue group : root.get("groups")) {
            String groupName = group.get("name").asString();
            Array<Asset> assets = new Array<Asset>();

            for (JsonValue asset : group.get("assets")) {
                assets.add(new Asset(asset.get("type").asString(), asset.get("path").asString()));
            }

            groups.put(groupName, assets);
        }
    }

    public void load(String groupName) {
        Array<Asset> assets = groups.get(groupName, null);

        if (assets != null) {
            for (Asset asset : assets) {
                manager.load(asset.path, asset.type);
            }
        }
    }

    public void unload(String groupName) {
        Array<Asset> assets = groups.get(groupName, null);

        if (assets != null) {
            for (Asset asset : assets)
                if (manager.isLoaded(asset.path, asset.type))   manager.unload(asset.path);
        }
    }

    public synchronized <T> T get(String fileName) {
        return manager.get(fileName);
    }

    public synchronized <T> T get(String fileName, Class<T> type) {
        return manager.get(fileName, type);
    }

    public boolean update() {
        return manager.update();
    }

    public void finishLoading() {
        manager.finishLoading();
    }

    public float getProgress() {
        return manager.getProgress();
    }

    @Override
    public void  dispose() {
        for (ObjectMap.Entry group : groups) {
            unload(group.key.toString());
        }
        manager.dispose();
    }

    private class Asset {

        public Class<?> type;
        public String path;

        public Asset(String type, String path) {
            try {
                this.type = Class.forName(type);
                this.path = path;
            } catch (ClassNotFoundException e) { e.printStackTrace(); }
        }
    }
}
