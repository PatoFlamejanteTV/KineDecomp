package com.nexstreaming.kinemaster.mediastore.item;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.c.h;
import kotlin.collections.z;
import kotlin.jvm.internal.f;

/* compiled from: MediaItemType.kt */
/* loaded from: classes.dex */
public enum MediaItemType {
    IMAGE(0),
    VIDEO(1),
    FOLDER(2),
    SPECIAL(3),
    FILE(4);

    public static final a Companion = new a(null);
    private static final Map<Integer, MediaItemType> map;
    private final int value;

    /* compiled from: MediaItemType.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public final MediaItemType a(int i) {
            return (MediaItemType) MediaItemType.map.get(Integer.valueOf(i));
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        int a2;
        int a3;
        MediaItemType[] values = values();
        a2 = z.a(values.length);
        a3 = h.a(a2, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(a3);
        for (MediaItemType mediaItemType : values) {
            linkedHashMap.put(Integer.valueOf(mediaItemType.value), mediaItemType);
        }
        map = linkedHashMap;
    }

    MediaItemType(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
