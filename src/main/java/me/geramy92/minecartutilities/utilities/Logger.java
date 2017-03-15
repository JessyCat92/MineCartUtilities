package me.geramy92.minecartutilities.utilities;

import me.geramy92.minecartutilities.MineCartUtilities;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Logger {
    private Logger() {}
    public enum LogLevel {
        INFO,
        ERROR,
        DEBUG,
        WARNING,
        LOG
    }

    public static void info(String msg) {
        Logger.runLogging(LogLevel.INFO, ChatColor.BLUE, msg);
    }

    public static void error(String msg) {
        Logger.runLogging(LogLevel.ERROR, ChatColor.RED, msg);
    }

    public static void debug(String msg) {
        Logger.runLogging(LogLevel.DEBUG, ChatColor.LIGHT_PURPLE, msg);
    }

    public static void debugOnDebug(String msg) {
        if (MineCartUtilities.getInstance().getConfig().getBoolean("debug")) {
            Logger.runLogging(LogLevel.DEBUG, ChatColor.LIGHT_PURPLE, msg);
        }
    }

    public static void success(String msg) {
        Logger.runLogging(LogLevel.INFO, ChatColor.GREEN, msg);
    }

    public static void custom(LogLevel loglevel, ChatColor color, String msg) {
        Logger.runLogging(loglevel, color, msg);
    }

    public static void warning(String msg) {
        Logger.runLogging(LogLevel.WARNING, ChatColor.YELLOW, msg);
    }

    public static void log(String msg) {
        Logger.runLogging(LogLevel.LOG, ChatColor.WHITE, msg);
    }

    private static void runLogging(LogLevel logLevel, ChatColor color, String msg) {
        String name = MineCartUtilities.getInstance().getDescription().getName();
        String version = MineCartUtilities.getInstance().getDescription().getVersion();

        String sendMsg = "[" + name + " " + version + "] [" + logLevel.name() + "] " + msg;
        Bukkit.getConsoleSender().sendMessage(color + sendMsg);
    }
}
