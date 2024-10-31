package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: Maps.java */
/* loaded from: classes2.dex */
final class bu<K, V> extends dk<Map.Entry<K, V>, V> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(Iterator it) {
        super(it);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.dk
    public V a(Map.Entry<K, V> entry) {
        return entry.getValue();
    }
}
