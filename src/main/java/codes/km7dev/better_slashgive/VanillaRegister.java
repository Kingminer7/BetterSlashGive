package codes.km7dev.better_slashgive;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

public class VanillaRegister {

    void registerEnchants() {
        for (Enchantment enchant : Enchantment.values()) {
            for (int i = 1; i <= enchant.getMaxLevel(); i++) {
                ItemStack stack = new ItemStack(Material.ENCHANTED_BOOK);
                stack.addUnsafeEnchantment(enchant, i);
                Better_slashgive.instance.RegisterItemToGive(stack, new Identifier("minecraft", stack.getType().name() + "." + enchant.getKey().toString().split(":")[1] + "." + i));
            }
        }
    }

    void registerPotions() {
        for (PotionType effect : PotionType.values()) {
            if (true){
                ItemStack stack = new ItemStack(Material.POTION);
                PotionMeta meta = (PotionMeta) stack.getItemMeta();
                PotionData data = new PotionData(effect, false,false);
                meta.setBasePotionData(data);
                stack.setItemMeta(meta);
                Better_slashgive.instance.RegisterItemToGive(stack, new Identifier("minecraft", stack.getType().name() + "." + effect.name() + (effect.isUpgradeable() ? ".1" : "")));

                ItemStack stack2 = new ItemStack(Material.SPLASH_POTION);
                PotionMeta meta2 = (PotionMeta) stack2.getItemMeta();
                PotionData data2 = new PotionData(effect, false,false);
                meta2.setBasePotionData(data2);
                stack2.setItemMeta(meta2);
                Better_slashgive.instance.RegisterItemToGive(stack2, new Identifier("minecraft", stack2.getType().name() + "." + effect.name() + (effect.isUpgradeable() ? ".1" : "")));

                ItemStack stack3 = new ItemStack(Material.LINGERING_POTION);
                PotionMeta meta3 = (PotionMeta) stack3.getItemMeta();
                PotionData data3 = new PotionData(effect, false,false);
                meta3.setBasePotionData(data3);
                stack3.setItemMeta(meta3);
                Better_slashgive.instance.RegisterItemToGive(stack3, new Identifier("minecraft", stack3.getType().name() + "." + effect.name() + (effect.isUpgradeable() ? ".1" : "")));

                ItemStack stack4 = new ItemStack(Material.TIPPED_ARROW);
                PotionMeta meta4 = (PotionMeta) stack4.getItemMeta();
                PotionData data4 = new PotionData(effect, false,false);
                meta4.setBasePotionData(data4);
                stack4.setItemMeta(meta4);
                Better_slashgive.instance.RegisterItemToGive(stack4, new Identifier("minecraft", stack4.getType().name() + "." + effect.name() + (effect.isUpgradeable() ? ".1" : "")));
            }
            if (effect.isUpgradeable()){
                ItemStack stack = new ItemStack(Material.POTION);
                PotionMeta meta = (PotionMeta) stack.getItemMeta();
                PotionData data = new PotionData(effect, false,true);
                meta.setBasePotionData(data);
                stack.setItemMeta(meta);
                Better_slashgive.instance.RegisterItemToGive(stack, new Identifier("minecraft", stack.getType().name() + "." + effect.name() + ".2"));

                ItemStack stack2 = new ItemStack(Material.SPLASH_POTION);
                PotionMeta meta2 = (PotionMeta) stack2.getItemMeta();
                PotionData data2 = new PotionData(effect, false,true);
                meta2.setBasePotionData(data2);
                stack2.setItemMeta(meta2);
                Better_slashgive.instance.RegisterItemToGive(stack2, new Identifier("minecraft", stack2.getType().name() + "." + effect.name() + ".2"));

                ItemStack stack3 = new ItemStack(Material.LINGERING_POTION);
                PotionMeta meta3 = (PotionMeta) stack3.getItemMeta();
                PotionData data3 = new PotionData(effect, false,true);
                meta3.setBasePotionData(data3);
                stack3.setItemMeta(meta3);
                Better_slashgive.instance.RegisterItemToGive(stack3, new Identifier("minecraft", stack3.getType().name() + "." + effect.name() + ".2"));

                ItemStack stack4 = new ItemStack(Material.TIPPED_ARROW);
                PotionMeta meta4 = (PotionMeta) stack4.getItemMeta();
                PotionData data4 = new PotionData(effect, false,true);
                meta4.setBasePotionData(data4);
                stack4.setItemMeta(meta4);
                Better_slashgive.instance.RegisterItemToGive(stack4, new Identifier("minecraft", stack4.getType().name() + "." + effect.name() + ".2"));
            }
            if (effect.isExtendable()){
                ItemStack stack = new ItemStack(Material.POTION);
                PotionMeta meta = (PotionMeta) stack.getItemMeta();
                PotionData data = new PotionData(effect, true,false);
                meta.setBasePotionData(data);
                stack.setItemMeta(meta);
                Better_slashgive.instance.RegisterItemToGive(stack, new Identifier("minecraft", stack.getType().name() + "." + effect.name() + ".extended"));

                ItemStack stack2 = new ItemStack(Material.SPLASH_POTION);
                PotionMeta meta2 = (PotionMeta) stack2.getItemMeta();
                PotionData data2 = new PotionData(effect, true,false);
                meta2.setBasePotionData(data2);
                stack2.setItemMeta(meta2);
                Better_slashgive.instance.RegisterItemToGive(stack2, new Identifier("minecraft", stack2.getType().name() + "." + effect.name() + ".extended"));

                ItemStack stack3 = new ItemStack(Material.LINGERING_POTION);
                PotionMeta meta3 = (PotionMeta) stack3.getItemMeta();
                PotionData data3 = new PotionData(effect, true,false);
                meta3.setBasePotionData(data3);
                stack3.setItemMeta(meta3);
                Better_slashgive.instance.RegisterItemToGive(stack3, new Identifier("minecraft", stack3.getType().name() + "." + effect.name() + ".extended"));

                ItemStack stack4 = new ItemStack(Material.TIPPED_ARROW);
                PotionMeta meta4 = (PotionMeta) stack4.getItemMeta();
                PotionData data4 = new PotionData(effect, true,false);
                meta4.setBasePotionData(data4);
                stack4.setItemMeta(meta4);
                Better_slashgive.instance.RegisterItemToGive(stack4, new Identifier("minecraft", stack4.getType().name() + "." + effect.name() + ".extended"));
            }
        }
    }

    public VanillaRegister() {
        for (Material material : Material.values()) {
            Better_slashgive.instance.RegisterItemToGive(new ItemStack(material), new Identifier("minecraft", material.name()));
        }
        registerEnchants();
        registerPotions();
        Better_slashgive.instance.getLogger().info("Loaded vanilla items to BetterSlashGive");
    }
    
    String translatePotion(PotionType pot) {
        if (pot == PotionType.AWKWARD) return "Awkward";
        return pot.name();
    }
}
