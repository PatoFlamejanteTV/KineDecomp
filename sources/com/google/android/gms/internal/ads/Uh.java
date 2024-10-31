package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes2.dex */
final class Uh<K> implements Map.Entry<K, Object> {

    /* renamed from: a */
    private Map.Entry<K, zzbro> f11879a;

    /* JADX INFO: Access modifiers changed from: private */
    public Uh(Map.Entry<K, zzbro> entry) {
        this.f11879a = entry;
    }

    public final zzbro a() {
        return this.f11879a.getValue();
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.f11879a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f11879a.getValue() == null) {
            return null;
        }
        zzbro.zzanm();
        throw null;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzbsl) {
            return this.f11879a.getValue().zzl((zzbsl) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public /* synthetic */ Uh(Map.Entry entry, Th th) {
        this(entry);
    }
}
