package codes.km7dev.betterslashgive;

public class Identifier {
    public String pluginId;
    public String itemId;

    public Identifier(String pluginId, String itemId) {
        this.pluginId = pluginId.toLowerCase();
        this.itemId = itemId.toLowerCase();
    }
}
