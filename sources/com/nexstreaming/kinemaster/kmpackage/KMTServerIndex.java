package com.nexstreaming.kinemaster.kmpackage;

import com.google.gson.annotations.SerializedName;
import java.net.URI;
import java.util.Map;

/* loaded from: classes.dex */
class KMTServerIndex {
    public transient URI base_uri;
    public Item[] effects;
    public Map<String, FontList> fontlists;
    public Item[] themes;

    /* loaded from: classes.dex */
    public static class FontGroupInfo {
        public Map<String, FontInfo> fonts;
        public String id;
        public Map<String, String> labels;
    }

    /* loaded from: classes.dex */
    public static class FontInfo {
        public String file;
        public String name;
        public String sample;
    }

    /* loaded from: classes.dex */
    public static class FontList {
        public FontGroupInfo[] groups;
        public String id;
        public int package_date;
        public String package_type;
        public String version;
    }

    /* loaded from: classes.dex */
    public static class Item {
        public String[] dependencies;
        public int dependency_size;
        public String id;
        public int minimum_version;
        public int optional_dependency_size;
        public int package_date;
        public int package_size;

        @SerializedName("package")
        public String pkg;
        public String preview;
        Map<String, Map<String, String>> strings;
        public String thumbnail;
        public String version;
    }

    public Item[] getItems() {
        Item[] itemArr = new Item[this.themes.length + this.effects.length];
        System.arraycopy(this.themes, 0, itemArr, 0, this.themes.length);
        System.arraycopy(this.effects, 0, itemArr, this.themes.length, this.effects.length);
        return itemArr;
    }
}
