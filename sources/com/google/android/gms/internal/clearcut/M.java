package com.google.android.gms.internal.clearcut;

import java.util.Map;

/* loaded from: classes2.dex */
final class M<K> implements Map.Entry<K, Object> {

    /* renamed from: a */
    private Map.Entry<K, zzcr> f12801a;

    /* JADX INFO: Access modifiers changed from: private */
    public M(Map.Entry<K, zzcr> entry) {
        this.f12801a = entry;
    }

    public /* synthetic */ M(Map.Entry entry, L l) {
        this(entry);
    }

    public final zzcr a() {
        return this.f12801a.getValue();
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.f12801a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f12801a.getValue() == null) {
            return null;
        }
        zzcr.zzbr();
        throw null;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzdo) {
            return this.f12801a.getValue().zzi((zzdo) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
