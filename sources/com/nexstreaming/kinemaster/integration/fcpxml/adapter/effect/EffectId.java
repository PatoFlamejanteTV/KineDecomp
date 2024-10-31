package com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public enum EffectId {
    BASIC("basic"),
    TIMEREMAP("timeremap"),
    AUDIOLEVELS("audiolevels"),
    AUDIOPAN("audiopan"),
    CROSS_DISSOLVE("Cross Dissolve"),
    COLOR_MATTE("Color");

    private static final Map<String, EffectId> lookup = new HashMap();
    private static final Map<String, List<String>> lookupTable = new HashMap();
    private String id;

    static {
        for (EffectId effectId : values()) {
            lookup.put(effectId.getEffectId(), effectId);
        }
        lookupTable.put("basic", makeTable("Basic Motion", "motion", "motion"));
        lookupTable.put("timeremap", makeTable("Time Remap", "motion", "motion"));
        lookupTable.put("audiolevels", makeTable("Audio levels", "audiolevels", "audiolevels"));
        lookupTable.put("audiopan", makeTable("Audio Pan", "audiopan", "audiopan"));
        lookupTable.put("Cross Dissolve", makeTable("Cross Dissolve", "Dissolve", "transition"));
        lookupTable.put("Color", makeTable("Color", "Matte", "generator"));
    }

    EffectId(String str) {
        this.id = str;
    }

    public static EffectId get(String str) {
        return lookup.get(str);
    }

    public static List<String> getNameTable(String str) {
        return lookupTable.get(str);
    }

    public static List<String> makeTable(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(str2);
        arrayList.add(str3);
        return arrayList;
    }

    public String getEffectId() {
        return this.id;
    }
}
