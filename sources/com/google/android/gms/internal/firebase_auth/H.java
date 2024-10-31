package com.google.android.gms.internal.firebase_auth;

import java.util.Map;

/* loaded from: classes2.dex */
final class H<K> implements Map.Entry<K, Object> {

    /* renamed from: a */
    private Map.Entry<K, zzgf> f12965a;

    /* JADX INFO: Access modifiers changed from: private */
    public H(Map.Entry<K, zzgf> entry) {
        this.f12965a = entry;
    }

    public final zzgf a() {
        return this.f12965a.getValue();
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.f12965a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f12965a.getValue() == null) {
            return null;
        }
        zzgf.zzia();
        throw null;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzhc) {
            return this.f12965a.getValue().zzj((zzhc) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public /* synthetic */ H(Map.Entry entry, G g2) {
        this(entry);
    }
}
