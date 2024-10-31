package org.keyczar.enums;

import org.keyczar.i18n.Messages;

/* loaded from: classes3.dex */
public enum Command {
    CREATE("create"),
    ADDKEY("addkey"),
    PUBKEY("pubkey"),
    PROMOTE("promote"),
    DEMOTE("demote"),
    REVOKE("revoke"),
    USEKEY("usekey"),
    IMPORT_KEY("importkey"),
    EXPORT_KEY("exportkey");

    private final String name;

    Command(String str) {
        this.name = str;
    }

    public static Command getCommand(String str) {
        if (str != null) {
            if (str.equalsIgnoreCase(CREATE.toString())) {
                return CREATE;
            }
            if (str.equalsIgnoreCase(ADDKEY.toString())) {
                return ADDKEY;
            }
            if (str.equalsIgnoreCase(PUBKEY.toString())) {
                return PUBKEY;
            }
            if (str.equalsIgnoreCase(PROMOTE.toString())) {
                return PROMOTE;
            }
            if (str.equalsIgnoreCase(DEMOTE.toString())) {
                return DEMOTE;
            }
            if (str.equalsIgnoreCase(REVOKE.toString())) {
                return REVOKE;
            }
            if (str.equalsIgnoreCase(USEKEY.toString())) {
                return USEKEY;
            }
            if (str.equalsIgnoreCase(IMPORT_KEY.toString())) {
                return IMPORT_KEY;
            }
            if (str.equalsIgnoreCase(EXPORT_KEY.toString())) {
                return EXPORT_KEY;
            }
            throw new IllegalArgumentException(Messages.getString("Command.UnknownCommand", str));
        }
        throw new NullPointerException();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}