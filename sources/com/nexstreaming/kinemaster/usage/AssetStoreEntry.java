package com.nexstreaming.kinemaster.usage;

/* loaded from: classes2.dex */
public enum AssetStoreEntry {
    UNKNOWN("unknown"),
    PROJECT_LIST("Project List"),
    EDITING("Editing"),
    STORE("Store"),
    PUSH("Push"),
    TIP("tip"),
    DYNAMIC_LINK("dynamic_link"),
    PROJECT("project");

    String mEntry;

    AssetStoreEntry(String str) {
        this.mEntry = str;
    }

    public String getValue() {
        return this.mEntry;
    }
}
