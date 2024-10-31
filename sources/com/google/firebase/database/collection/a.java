package com.google.firebase.database.collection;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database-collection@@16.0.1 */
/* loaded from: classes2.dex */
public class a<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a */
    int f16716a;

    /* renamed from: b */
    final /* synthetic */ int f16717b;

    /* renamed from: c */
    final /* synthetic */ boolean f16718c;

    /* renamed from: d */
    final /* synthetic */ ArraySortedMap f16719d;

    public a(ArraySortedMap arraySortedMap, int i, boolean z) {
        this.f16719d = arraySortedMap;
        this.f16717b = i;
        this.f16718c = z;
        this.f16716a = this.f16717b;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        Object[] objArr;
        if (!this.f16718c) {
            int i = this.f16716a;
            objArr = this.f16719d.f16690a;
            if (i < objArr.length) {
                return true;
            }
        } else if (this.f16716a >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Can't remove elements from ImmutableSortedMap");
    }

    @Override // java.util.Iterator
    public Map.Entry<K, V> next() {
        Object[] objArr;
        Object[] objArr2;
        objArr = this.f16719d.f16690a;
        Object obj = objArr[this.f16716a];
        objArr2 = this.f16719d.f16691b;
        int i = this.f16716a;
        Object obj2 = objArr2[i];
        this.f16716a = this.f16718c ? i - 1 : i + 1;
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }
}
