package com.google.android.gms.internal.gtm;

import java.util.Map;

/* loaded from: classes2.dex */
final class Aa<K> implements Map.Entry<K, Object> {

    /* renamed from: a */
    private Map.Entry<K, zzrn> f13124a;

    /* JADX INFO: Access modifiers changed from: private */
    public Aa(Map.Entry<K, zzrn> entry) {
        this.f13124a = entry;
    }

    public final zzrn a() {
        return this.f13124a.getValue();
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.f13124a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f13124a.getValue() == null) {
            return null;
        }
        zzrn.zzpy();
        throw null;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzsk) {
            return this.f13124a.getValue().zzi((zzsk) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public /* synthetic */ Aa(Map.Entry entry, C1344za c1344za) {
        this(entry);
    }
}
