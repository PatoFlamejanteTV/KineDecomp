package org.keyczar.enums;

/* loaded from: classes3.dex */
public enum KeyStatus {
    PRIMARY(0, "primary"),
    ACTIVE(1, "active"),
    INACTIVE(2, "inactive");

    private String name;
    private int value;

    KeyStatus(int i, String str) {
        this.value = i;
        this.name = str;
    }

    public static KeyStatus getStatus(int i) {
        if (i == 0) {
            return PRIMARY;
        }
        if (i == 1) {
            return ACTIVE;
        }
        if (i != 2) {
            return null;
        }
        return INACTIVE;
    }

    String getName() {
        return this.name;
    }

    int getValue() {
        return this.value;
    }

    public static KeyStatus getStatus(String str) {
        if (str != null) {
            if (str.equalsIgnoreCase(PRIMARY.getName())) {
                return PRIMARY;
            }
            if (str.equalsIgnoreCase(ACTIVE.getName())) {
                return ACTIVE;
            }
            if (str.equalsIgnoreCase(INACTIVE.getName())) {
                return INACTIVE;
            }
        }
        return ACTIVE;
    }
}
