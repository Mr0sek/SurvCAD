package net.osek.survcad.embeddedDB;

public class NoEntryException extends Exception {

    public NoEntryException (String table, String column, String param) {
        super("No entry found in table " + table + " for clause " + column + "=" + param);

    }
}
