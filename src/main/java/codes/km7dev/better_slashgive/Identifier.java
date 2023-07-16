package codes.km7dev.better_slashgive;

public class Identifier {
    public String pluginId;
    public String itemId;

    public Identifier(String pluginId, String itemId) {
        this.pluginId = pluginId.toLowerCase();
        this.itemId = itemId.toLowerCase();
    }
}
