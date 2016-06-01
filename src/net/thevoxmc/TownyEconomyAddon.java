package net.thevoxmc;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class TownyEconomyAddon extends JavaPlugin
{
    private TownyEconomyFiles getTEF = new TownyEconomyFiles();
    private static Economy econ;

    public static Economy getEcon()
    {
        return econ;
    }

    public void log(String string)
    {
        System.out.println("[TownyEconomyAddon] " + string);
    }

    @Override
    public void onEnable()
    {
        getTEF.Files();
        getEconomy();
        getServer().getPluginManager().registerEvents(new TownyEconomyEvents(), this);
        log("Is now enabled.");
    }

    @Override
    public void onDisable()
    {
        log("Is now disabled, cya!");
    }

    private boolean getEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            econ = economyProvider.getProvider();
        }

        return (econ != null);
    }
}
