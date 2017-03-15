package me.geramy92.minecartutilities.utilities;

import me.geramy92.minecartutilities.MineCartUtilities;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Logger {
    private Logger() {}

    public static void info(String msg) {
        Logger.runLogging("info", ChatColor.BLUE, msg);
    }

    public static void error(String msg) {
        Logger.runLogging("error", ChatColor.RED, msg);
    }

    public static void debug(String msg) {
        Logger.runLogging("debug", ChatColor.DARK_BLUE, msg);
    }

    public static void success(String msg) {
        Logger.runLogging("info", ChatColor.GREEN, msg);
    }

    public static void customInfo(ChatColor color, String msg) {
        Logger.runLogging("info", color, msg);
    }

    public static void warning(String msg) {
        Logger.runLogging("warning", ChatColor.YELLOW, msg);
    }

    public static void log(String msg) {
        Logger.runLogging("log", ChatColor.WHITE, msg);
    }

    private static void runLogging(String logLevel, ChatColor color, String msg) {
        String name = MineCartUtilities.getInstance().getDescription().getName();
        String version = MineCartUtilities.getInstance().getDescription().getVersion();

        String sendMsg = "[" + name + " " + version + "] [" + logLevel.toUpperCase() + "] " + msg;
        Bukkit.getConsoleSender().sendMessage(color + sendMsg);
    }
}
