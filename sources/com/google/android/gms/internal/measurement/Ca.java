package com.google.android.gms.internal.measurement;

import java.util.Map;

/* loaded from: classes2.dex */
final class Ca<K> implements Map.Entry<K, Object> {

    /* renamed from: a */
    private Map.Entry<K, zzuy> f13357a;

    /* JADX INFO: Access modifiers changed from: private */
    public Ca(Map.Entry<K, zzuy> entry) {
        this.f13357a = entry;
    }

    public final zzuy a() {
        return this.f13357a.getValue();
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.f13357a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f13357a.getValue() == null) {
            return null;
        }
        zzuy.zzwz();
        throw null;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzvv) {
            return this.f13357a.getValue().zzi((zzvv) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public /* synthetic */ Ca(Map.Entry entry, Ba ba) {
        this(entry);
    }
}
