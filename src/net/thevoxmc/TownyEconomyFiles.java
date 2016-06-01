package net.thevoxmc;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TownyEconomyFiles
{
    private static TownyEconomyFiles tef;
    private TownyEconomyAddon getTEA = new TownyEconomyAddon();
    private File banksf, langf = null;
    private YamlConfiguration banks, lang = null;

    private void log(String string)
    {
        getTEA.log(string);
    }

    private void createBanks()
    {
        banksf = new File(getTEA.getDataFolder() + File.separator + "banks.yml");
        banks = YamlConfiguration.loadConfiguration(banksf);

        boolean save = false;
        if (banksf.exists())
        {
            save = true;
        }

        if (save)
        {
            try
            {
                banks.save(banksf);
                log("Creating banks.yml...");
                log("Created banks.yml!");
            } catch (IOException e) {
                log("Failed to create banks.yml!");
                log("Caused by: " + e.getMessage());
            }
        }
    }

    private void createLang()
    {
        langf = new File(getTEA.getDataFolder() + File.separator + "lang.yml");
        lang = YamlConfiguration.loadConfiguration(langf);

        boolean save = false;
        if (langf.exists())
        {
            lang.set("Messages.Prefix", "&bBanks &8»");
            lang.set("Messages.NoPermission", "<prefix> &cYou do not have permission to do this!");
            lang.set("Messages.DepositAmount", "<prefix> &a$<amount> has been deposited into your account.");
            lang.set("Messages.WithdrawAmount", "<prefix> &a$<amount> has been withdrawn from your account.");
            lang.set("Messages.NotEnoughMoneyOnPlayer", "<prefix> &cYou do not have $<amount> in your player account!");
            lang.set("Messages.NotEnoughMoneyInBank", "<prefix> &cYou d not have $<amount> in your bank account!");
            lang.set("Messages.InvalidArgs", "<prefix> &cPlease enter in a number i.e. 500");
            lang.set("Messages.Bank???", "<prefix> &aInformation on the Banks Plugin can be found @ &dwww.thevoxmc.net/wikia");
            ArrayList<String> bhelp = new ArrayList<>();
            bhelp.add("&8&m---------------[&b Bank Help &8&m]---------------");
            bhelp.add("&8- &b/bank ??? &8- &7Info on what banks are for :)");
            bhelp.add("&8- &b/bank bal &8- &7View your bank balance");
            bhelp.add("&8- &b/bank add <amount &8- &7Add money to your bank");
            bhelp.add("&8- &b/bank withdraw <amount> ");
            bhelp.add("&8- &bBanks v1.0 Developed by TheMasteredPanda");
            bhelp.add("&8&m--------------------------------------------");
            lang.set("Messages.Help", bhelp);
            save = true;
        }

        if (save)
        {
            try
            {
                lang.save(langf);
                log("Creating lang.yml...");
                log("Created lang.yml!");
            } catch (IOException e) {
                log("Failed to create lang.yml.");
                log("Caused by: " + e.getMessage());
            }
        }
    }

    public void Files()
    {
        createBanks();
        createLang();
    }

    public void saveBanks()
    {
        try
        {
            banks.save(banksf);
        } catch (IOException e) {
            log("Failed to save banks.yml. Caused by: " + e.getMessage());
        }
    }

    public YamlConfiguration getBanks()
    {
        return banks;
    }

    public YamlConfiguration getLang()
    {
        return lang;
    }
}