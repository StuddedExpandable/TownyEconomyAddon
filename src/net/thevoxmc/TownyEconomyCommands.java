package net.thevoxmc;

import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TownyEconomyCommands implements CommandExecutor
{
    private TownyEconomyFiles getTEF = new TownyEconomyFiles();
    private TownyEconomyAddon getTEA = new TownyEconomyAddon();
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args)
    {
        Player p = (Player) s;
        if (cmd.getName().equalsIgnoreCase("bank") && (s.hasPermission("vox.banks.player")))
        {
            if (args.length == 0)
            {
               for (String help : getTEF.getLang().getStringList("Messages.Help")) {
                   s.sendMessage(ChatColor.translateAlternateColorCodes('&', help));
               }
            } else if ((args.length == 1) && (args[0].equalsIgnoreCase("???"))) {
                s.sendMessage(ChatColor.translateAlternateColorCodes('&', getTEF.getLang().getString("Messages.Bank???")));
            } else if (args.length == 2) {
                Double amount = null;
                if (args[2].equalsIgnoreCase("deposit"))
                {
                   if (s instanceof Player)
                   {
                       try
                       {
                           amount = Double.parseDouble(args[1]);
                       } catch (NumberFormatException e) {
                           s.sendMessage(ChatColor.translateAlternateColorCodes('&', getTEF.getLang().getString("Messages.InvalidArgs")));
                       }

                       if (getTEA.getEcon().has(s.getName(), amount))
                       {
                           EconomyResponse  wDp =getTEA.getEcon().withdrawPlayer(s.getName(), amount);
                           getTEF.getBanks().(p.getUniqueId().toString() + ".bank");
                           s.sendMessage(ChatColor.translateAlternateColorCodes('&', getTEF.getLang().getString("Messages.WithdrawAmount")));
                       } else {

                       }


                   }
                }



            }
        }
        return true;
    }

}
