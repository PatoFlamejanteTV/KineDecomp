package com.google.common.collect;

import com.google.common.collect.DenseImmutableTable;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: DenseImmutableTable.java */
/* loaded from: classes2.dex */
class F<K, V> extends AbstractIterator<Map.Entry<K, V>> {

    /* renamed from: c, reason: collision with root package name */
    private int f15375c = -1;

    /* renamed from: d, reason: collision with root package name */
    private final int f15376d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ DenseImmutableTable.ImmutableArrayMap f15377e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public F(DenseImmutableTable.ImmutableArrayMap immutableArrayMap) {
        this.f15377e = immutableArrayMap;
        this.f15376d = this.f15377e.keyToIndex().size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.AbstractIterator
    public Map.Entry<K, V> b() {
        int i = this.f15375c;
        while (true) {
            this.f15375c = i + 1;
            int i2 = this.f15375c;
            if (i2 < this.f15376d) {
                Object value = this.f15377e.getValue(i2);
                if (value != null) {
                    return Maps.a(this.f15377e.getKey(this.f15375c), value);
                }
                i = this.f15375c;
            } else {
                return c();
            }
        }
    }
}
