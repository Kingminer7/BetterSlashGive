package codes.km7dev.betterslashgive;

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

import java.util.*;

public final class BetterSlashGive extends JavaPlugin {
    public static BetterSlashGive instance;
    public HashMap<String, ItemStack> items = new HashMap<>();

    @Override
    public void onEnable() {
        instance = this;
        new VanillaRegister();
        Objects.requireNonNull(getCommand("give")).setExecutor(new GiveCommandExecutor());
        Objects.requireNonNull(getCommand("give")).setTabCompleter(new GiveTabCompleter());
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
            if (args.length == 3) {
                float t = Float.parseFloat(args[2]);
                if (t > Integer.MAX_VALUE) amount = Integer.MAX_VALUE;
                else amount = Integer.parseInt(args[2]);
            }
            if (args[0].equals("@s")) {
                if (!(sender instanceof Player)) {
                    sender.sendMessage(ChatColor.RED + "You must be a player to use this command!");
                } else {
                    Player player = (Player) sender;
                    BetterSlashGive.instance.getLogger().info(args[1]);
                    if (BetterSlashGive.instance.items.containsKey(args[1])) {
                        ItemStack item = BetterSlashGive.instance.items.get(args[1]);
                        item.setAmount(amount);
                        player.getInventory().addItem(item);
                        sender.sendMessage("Gave " +  amount + " [" + item.getTranslationKey() + "] to " + player.getName());
                    } else {
                        if (!args[1].contains(":")) {
                            String id = "minecraft:" + args[1];
                            if (BetterSlashGive.instance.items.containsKey(id)) {
                                ItemStack item = BetterSlashGive.instance.items.get(id);
                                item.setAmount(amount);
                                player.getInventory().addItem(item);
                                sender.sendMessage("Gave " +  amount + " [" + item.getTranslationKey() + "] to " + player.getName());
                                return true;
                            }
                        }
                        sender.sendMessage(ChatColor.RED + "Item does not exist or was not registered properly!");
                    }
                }
                return true;
            } else if (args[0].equals("@a")) {
                for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                    if (BetterSlashGive.instance.items.containsKey(args[1])) {
                        ItemStack item = BetterSlashGive.instance.items.get(args[1]);
                        item.setAmount(amount);
                        player.getInventory().addItem(item);
                        sender.sendMessage("Gave " +  amount + " [" + item.getTranslationKey() + "] to " + player.getName());
                    } else {
                        if (!args[1].contains(":")) {
                            String id = "minecraft:" + args[1];
                            if (BetterSlashGive.instance.items.containsKey(id)) {
                                ItemStack item = BetterSlashGive.instance.items.get(id);
                                item.setAmount(amount);
                                player.getInventory().addItem(item);
                                sender.sendMessage("Gave " +  amount + " [" + item.getTranslationKey() + "] to " + player.getName());
                                return true;
                            }
                        }
                        sender.sendMessage(ChatColor.RED + "Item does not exist or was not registered properly!");
                    }
                    return true;
                }
            } else if (args[0].equals("@r")) {
                Random random = new Random();
                Player player = Bukkit.getServer().getOnlinePlayers().toArray(new Player[0])[random
                        .nextInt(Bukkit.getServer().getOnlinePlayers().toArray().length)];
                if (BetterSlashGive.instance.items.containsKey(args[1])) {
                    ItemStack item = BetterSlashGive.instance.items.get(args[1]);
                    item.setAmount(amount);
                    player.getInventory().addItem(item);
                    sender.sendMessage("Gave " +  amount + " [" + item.getTranslationKey() + "] to " + player.getName());
                } else {
                    if (!args[1].contains(":")) {
                        args[1] = "minecraft:" + args[1];
                        if (BetterSlashGive.instance.items.containsKey(args[1])) {
                            ItemStack item = BetterSlashGive.instance.items.get(args[1]);
                            item.setAmount(amount);
                            player.getInventory().addItem(item);
                            sender.sendMessage("Gave " +  amount + " [" + item.getTranslationKey() + "] to " + player.getName());
                            return true;
                        }
                    }
                    sender.sendMessage(ChatColor.RED + "Item does not exist or was not registered properly!");
                }
                return true;
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
                    if (BetterSlashGive.instance.items.containsKey(args[1])) {
                        ItemStack item = BetterSlashGive.instance.items.get(args[1]);
                        item.setAmount(amount);
                        player.getInventory().addItem(item);
                        sender.sendMessage("Gave " +  amount + " [" + item.getTranslationKey() + "] to " + player.getName());
                    } else {
                        if (!args[1].contains(":")) {
                            String id = "minecraft:" + args[1];
                            if (BetterSlashGive.instance.items.containsKey(id)) {
                                ItemStack item = BetterSlashGive.instance.items.get(id);
                                item.setAmount(amount);
                                player.getInventory().addItem(item);
                                sender.sendMessage("Gave " +  amount + " [" + item.getTranslationKey() + "] to " + player.getName());
                                return true;
                            }
                        }
                        sender.sendMessage(ChatColor.RED + "Item does not exist or was not registered properly!");
                    }
                    return true;
                }
            } else if (Bukkit.getServer().getOnlinePlayers().contains(Bukkit.getServer().getPlayer(args[0]))) {
                Player player = Bukkit.getServer().getPlayer(args[0]);
                if (BetterSlashGive.instance.items.containsKey(args[1])) {
                    ItemStack item = BetterSlashGive.instance.items.get(args[1]);
                    item.setAmount(amount);
                    player.getInventory().addItem(item);
                    sender.sendMessage("Gave " +  amount + " [" + item.getTranslationKey() + "] to " + player.getName());
                } else {
                    if (!args[1].contains(":")) {
                        String id = "minecraft:" + args[1];
                        if (BetterSlashGive.instance.items.containsKey(id)) {
                            ItemStack item = BetterSlashGive.instance.items.get(id);
                            item.setAmount(amount);
                            player.getInventory().addItem(item);
                            sender.sendMessage("Gave " +  amount + " [" + item.getTranslationKey() + "] to " + player.getName());
                            return true;
                        }
                    }
                    sender.sendMessage(ChatColor.RED + "Item does not exist or was not registered properly!");
                }
                return true;
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
                for (String id : BetterSlashGive.instance.items.keySet()) {
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
