package com.squareup.wire;

import java.util.Comparator;
import java.util.Map;

/* compiled from: TagMap.java */
/* loaded from: classes.dex */
final class p implements Comparator<Map.Entry<Integer, ?>> {
    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Map.Entry<Integer, ?> entry, Map.Entry<Integer, ?> entry2) {
        return entry.getKey().compareTo(entry2.getKey());
    }
}
