package dev.kaepsis.inventorytrolls.configs;

import net.pino.simpleconfig.BaseConfig;
import net.pino.simpleconfig.annotations.Config;
import net.pino.simpleconfig.annotations.ConfigFile;
import net.pino.simpleconfig.annotations.inside.Path;

@Config
@ConfigFile("config.yml")
public class Messages extends BaseConfig {

    private static Messages instance = null;

    private Messages() {
    }

    public static Messages getInstance() {
        if (instance == null) {
            instance = new Messages();
        }
        return instance;
    }

    @Path("global.player-not-found")
    public String playerNotFound = "&cError! A player with named {playerName} could not be found!";
    @Path("global.player-exempt")
    public String playerExempt = "&cError! {playerName} is exempt from this action!";
    @Path("global.reload-done")
    public String reloadDone = "&aReloading complete";
    @Path("shuffle.usage")
    public String shuffleUsage = "&cMissing player name! Correct usage is /inventoryshuffle <player>";
    @Path("shuffle.done")
    public String shuffleDone = "&aDone! {playerName}'s inventory has been shuffled!";
    @Path("shuffle.all.done")
    public String shuffleAllDone = "&aDone! All players' inventories have been shuffled!";
    @Path("removeitem.usage")
    public String removeItemUsage = "&cMissing player name! Correct usage is /removeitem <player> <amount>";
    @Path("removeitem.done")
    public String removeItemDone = "&aDone! {playerName}'s inventory has been modified!";
    @Path("removeitem.all.usage")
    public String removeItemAllUsage = "&cMissing amount! Correct usage is /removeitemall <amount>";
    @Path("removeitem.all.done")
    public String removeItemAllDone = "&aDone! All players' inventories have been modified!";

}
