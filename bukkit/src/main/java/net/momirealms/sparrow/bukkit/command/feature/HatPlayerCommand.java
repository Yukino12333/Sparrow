package net.momirealms.sparrow.bukkit.command.feature;

import net.momirealms.sparrow.bukkit.command.AbstractCommand;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.incendo.cloud.Command;
import org.incendo.cloud.bukkit.BukkitCommandManager;

@SuppressWarnings("DuplicatedCode")
public class HatPlayerCommand extends AbstractCommand {

    @Override
    public String getFeatureID() {
        return "hat_player";
    }

    @Override
    public Command.Builder<? extends CommandSender> assembleCommand(BukkitCommandManager<CommandSender> manager, Command.Builder<CommandSender> builder) {
        return builder
                .senderType(Player.class)
                .handler(commandContext -> {
                    final Player player = commandContext.sender();
                    ItemStack itemInHand = player.getInventory().getItemInMainHand();
                    if (itemInHand.getType() == Material.AIR) return;
                    ItemStack previous = player.getInventory().getHelmet();
                    if (previous != null && previous.getEnchantmentLevel(Enchantment.BINDING_CURSE) != 0) {
                        return;
                    }
                    player.getInventory().setHelmet(itemInHand);
                    if (previous != null && previous.getType() != Material.AIR) {
                        player.getInventory().setItemInMainHand(previous);
                    } else {
                        player.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                    }
                });
    }
}
