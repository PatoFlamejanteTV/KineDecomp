package com.squareup.wire;

import java.util.Comparator;
import java.util.Map;

/* compiled from: TagMap.java */
/* loaded from: classes3.dex */
class o implements Comparator<Map.Entry<Integer, ?>> {
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(Map.Entry<Integer, ?> entry, Map.Entry<Integer, ?> entry2) {
        return entry.getKey().compareTo(entry2.getKey());
    }
}
