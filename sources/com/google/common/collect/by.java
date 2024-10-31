package com.google.common.collect;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [K, V2] */
/* compiled from: Maps.java */
/* loaded from: classes2.dex */
public class by<K, V2> extends Maps.a<K, V2> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Maps.d f2831a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(Maps.d dVar) {
        this.f2831a = dVar;
    }

    @Override // com.google.common.collect.Maps.a
    Map<K, V2> a() {
        return this.f2831a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Map.Entry<K, V2>> iterator() {
        return new bz(this, this.f2831a.f2738a.entrySet().iterator());
    }
}
