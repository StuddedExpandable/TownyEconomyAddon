package net.thevoxmc;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class TownyEconomyEvents implements Listener
{
    private TownyEconomyFiles getTEF = new TownyEconomyFiles();
    private TownyEconomyAddon getTEA = new TownyEconomyAddon();

    @EventHandler
    public void onJoin(PlayerJoinEvent e)
    {

    }

}
