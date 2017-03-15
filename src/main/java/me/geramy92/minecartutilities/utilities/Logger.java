package me.geramy92.minecartutilities.utilities;

import me.geramy92.minecartutilities.MineCartUtilities;
import org.bukkit.Bukkit;

public class Logger {
    public class AnsiColors {
        public static final String BLACK = "\u001B[30m";
        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String BLUE = "\u001B[34m";
        public static final String MAGENTA = "\u001B[35m";
        public static final String CYAN = "\u001B[36m";
        public static final String WHITE = "\u001B[37m";

        private AnsiColors(){}
    }

    public static void info(String msg) {
        Logger.runLogging("info", AnsiColors.CYAN, msg);
    }

    public static void error(String msg) {
        Logger.runLogging("error", AnsiColors.RED, msg);
    }

    public static void debug(String msg) {
        Logger.runLogging("debug", AnsiColors.BLUE, msg);
    }

    public static void success(String msg) {
        Logger.runLogging("info", AnsiColors.GREEN, msg);
    }

    public static void customInfo(String color, String msg) {
        Logger.runLogging("info", color, msg);
    }

    public static void warning(String msg) {
        Logger.runLogging("warning", AnsiColors.YELLOW, msg);
    }

    public static void log(String msg) {
        Logger.runLogging("log", AnsiColors.WHITE, msg);
    }

    private static void runLogging(String logLevel, String color, String msg) {
        String name = MineCartUtilities.getInstance().getDescription().getName();
        String version = MineCartUtilities.getInstance().getDescription().getVersion();

        String sendMsg = "[" + name + " " + version + "][" + logLevel.toUpperCase() + "] " + msg;
        Bukkit.getConsoleSender().sendMessage(color + sendMsg);
    }
}
