package codes.km7dev.better_slashgive;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.CommandBlock;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public final class Better_slashgive extends JavaPlugin {
    public static Better_slashgive instance;
    public HashMap<String, ItemStack> items = new HashMap<>();

    @Override
    public void onEnable() {
        instance = this;
        new VanillaRegister();
        getCommand("give").setExecutor(new GiveCommandExecutor());
        getCommand("give").setTabCompleter(new GiveTabCompleter());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static class GiveCommandExecutor implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (args.length < 2) {
                return false;
            }
            int amount = 1;
            if (args.length == 3)
                amount = Integer.parseInt(args[2]);
            if (args[0].equals("@s")) {
                if (!(sender instanceof Player)) {
                    sender.sendMessage(ChatColor.RED + "You must be a player to use this command!");
                    return true;
                } else {
                    Player player = (Player) sender;
                    Better_slashgive.instance.getLogger().info(args[1]);
                    if (Better_slashgive.instance.items.containsKey(args[1])) {
                        ItemStack item = Better_slashgive.instance.items.get(args[1]);
                        item.setAmount(amount);
                        player.getInventory().addItem(item);
                        player.sendMessage("You were given " + amount + " " + args[1]);
                        return true;
                    } else {
                        if (!args[1].contains(":")) {
                            String id = "minecraft:" + args[1];
                            if (Better_slashgive.instance.items.containsKey(id)) {
                                ItemStack item = Better_slashgive.instance.items.get(id);
                                item.setAmount(amount);
                                player.getInventory().addItem(item);
                                player.sendMessage("You were given " + amount + " " + args[1]);
                                return true;
                            }
                        }
                        sender.sendMessage(ChatColor.RED + "Item does not exist or was not registered properly!");
                        return true;
                    }
                }
            } else if (args[0].equals("@a")) {
                for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                    if (Better_slashgive.instance.items.containsKey(args[1])) {
                        ItemStack item = Better_slashgive.instance.items.get(args[1]);
                        item.setAmount(amount);
                        player.getInventory().addItem(item);
                        player.sendMessage("You were given " + amount + " " + args[1]);
                        return true;
                    } else {
                        if (!args[1].contains(":")) {
                            String id = "minecraft:" + args[1];
                            if (Better_slashgive.instance.items.containsKey(id)) {
                                ItemStack item = Better_slashgive.instance.items.get(id);
                                item.setAmount(amount);
                                player.getInventory().addItem(item);
                                player.sendMessage("You were given " + amount + " " + args[1]);
                                return true;
                            }
                        }
                        sender.sendMessage(ChatColor.RED + "Item does not exist or was not registered properly!");
                        return true;
                    }
                }
            } else if (args[0].equals("@r")) {
                Random random = new Random();
                Player player = Bukkit.getServer().getOnlinePlayers().toArray(new Player[0])[random
                        .nextInt(Bukkit.getServer().getOnlinePlayers().toArray().length)];
                if (Better_slashgive.instance.items.containsKey(args[1])) {
                    ItemStack item = Better_slashgive.instance.items.get(args[1]);
                    item.setAmount(amount);
                    player.getInventory().addItem(item);
                    player.sendMessage("You were given " + amount + " " + args[1]);
                    return true;
                } else {
                    if (!args[1].contains(":")) {
                        args[1] = "minecraft:" + args[1];
                        if (Better_slashgive.instance.items.containsKey(args[1])) {
                            ItemStack item = Better_slashgive.instance.items.get(args[1]);
                            item.setAmount(amount);
                            player.getInventory().addItem(item);
                            player.sendMessage("You were given " + amount + " " + args[1]);
                            return true;
                        }
                    }
                    sender.sendMessage(ChatColor.RED + "Item does not exist or was not registered properly!");
                    return true;
                }
            } else if (args[0].equals("@p")) {
                if (sender instanceof CommandBlock) {
                    CommandBlock cmd = (CommandBlock) sender;
                    Player player = null;
                    for (Player plr : Bukkit.getServer().getOnlinePlayers()) {
                        if (player == null)
                            player = plr;
                        else if (plr.getLocation().distance(cmd.getLocation()) < player.getLocation()
                                .distance(cmd.getLocation()))
                            player = plr;
                    }
                    if (Better_slashgive.instance.items.containsKey(args[1])) {
                        ItemStack item = Better_slashgive.instance.items.get(args[1]);
                        item.setAmount(amount);
                        player.getInventory().addItem(item);
                        player.sendMessage("You were given " + amount + " " + args[1]);
                        return true;
                    } else {
                        if (!args[1].contains(":")) {
                            String id = "minecraft:" + args[1];
                            if (Better_slashgive.instance.items.containsKey(id)) {
                                ItemStack item = Better_slashgive.instance.items.get(id);
                                item.setAmount(amount);
                                player.getInventory().addItem(item);
                                player.sendMessage("You were given " + amount + " " + args[1]);
                                return true;
                            }
                        }
                        sender.sendMessage(ChatColor.RED + "Item does not exist or was not registered properly!");
                        return true;
                    }
                }
            } else if (Bukkit.getServer().getOnlinePlayers().contains(Bukkit.getServer().getPlayer(args[0]))) {
                Player player = Bukkit.getServer().getPlayer(args[0]);
                if (Better_slashgive.instance.items.containsKey(args[1])) {
                    ItemStack item = Better_slashgive.instance.items.get(args[1]);
                    item.setAmount(amount);
                    player.getInventory().addItem(item);
                    player.sendMessage("You were given " + amount + " " + args[1]);
                    return true;
                } else {
                    if (!args[1].contains(":")) {
                        String id = "minecraft:" + args[1];
                        if (Better_slashgive.instance.items.containsKey(id)) {
                            ItemStack item = Better_slashgive.instance.items.get(id);
                            item.setAmount(amount);
                            player.getInventory().addItem(item);
                            player.sendMessage("You were given " + amount + " " + args[1]);
                            return true;
                        }
                    }
                    sender.sendMessage(ChatColor.RED + "Item does not exist or was not registered properly!");
                    return true;
                }
            } else {
                sender.sendMessage(ChatColor.RED + "Player not found!");
                return true;
            }
            return true;
        }
    }

    public void RegisterItemToGive(ItemStack item, Identifier id) {
        items.put(id.pluginId + ":" + id.itemId, item);
    }

    public static class GiveTabCompleter implements TabCompleter {

        @Override
        public List<String> onTabComplete(CommandSender commandSender, Command command, String cmdName, String[] args) {
            if (args.length == 1) {

                List<String> pNames = new ArrayList<>();
                if ("@a".contains(args[0]))
                    pNames.add("@a");
                if ("@p".contains(args[0]))
                    pNames.add("@p");
                if ("@r".contains(args[0]))
                    pNames.add("@r");
                if (commandSender instanceof Player)
                    if ("@s".contains(args[0]))
                        pNames.add("@s");
                for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                    if (player.getName().contains(args[0]))
                        pNames.add(player.getName());
                }
                return pNames;
            } else if (args.length == 2) {
                List<String> tcItems = new ArrayList<>();
                for (String id : Better_slashgive.instance.items.keySet()) {
                    if (id.contains(args[1]))
                        tcItems.add(id);
                }
                return tcItems;
            } else {
                return new ArrayList<>();
            }
        }
    }
}
