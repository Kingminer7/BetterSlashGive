package codes.km7dev.better_slashgive;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class Better_slashgive extends JavaPlugin implements CommandExecutor {
    public static Better_slashgive instance;
    List<ItemStack> items = new ArrayList<>();
    @Override
    public void onEnable() {
        instance = this;
        new VanillaRegister();
        getCommand("give").setExecutor(this);
        getCommand("give").setTabCompleter(new GiveTabCompleter());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage();
            return true;
        }
        return false;
    }

    public void RegisterItemToGive(ItemStack item) {
        items.add(item);
    }

    public static class GiveTabCompleter implements TabCompleter {

        @Override
        public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
            if(strings.length == 1) {
                List<String> pNames = new ArrayList<>();
                pNames.add("@a");
                pNames.add("@p");
                pNames.add("@r");
                if(commandSender instanceof Player) pNames.add("@s");
                for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                    pNames.add(player.getName());
                }
                return pNames;
            } else if (strings.length == 2) {
                List<String> tcItems = new ArrayList<>();
                for (Material item : Material.values()) {
                    tcItems.add(item.name());
                }
            }
            return null;
        }
    }
}
