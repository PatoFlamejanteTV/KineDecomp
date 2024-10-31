package com.google.android.gms.internal.clearcut;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.clearcut.za */
/* loaded from: classes2.dex */
public final class C1237za<K, V> implements Comparable<C1237za>, Map.Entry<K, V> {

    /* renamed from: a */
    private final Comparable f12912a;

    /* renamed from: b */
    private V f12913b;

    /* renamed from: c */
    private final /* synthetic */ C1223sa f12914c;

    /* JADX WARN: Multi-variable type inference failed */
    public C1237za(C1223sa c1223sa, K k, V v) {
        this.f12914c = c1223sa;
        this.f12912a = k;
        this.f12913b = v;
    }

    public C1237za(C1223sa c1223sa, Map.Entry<K, V> entry) {
        this(c1223sa, (Comparable) entry.getKey(), entry.getValue());
    }

    private static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(C1237za c1237za) {
        return ((Comparable) getKey()).compareTo((Comparable) c1237za.getKey());
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return a(this.f12912a, entry.getKey()) && a(this.f12913b, entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.f12912a;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.f12913b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f12912a;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        V v = this.f12913b;
        return hashCode ^ (v != null ? v.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        this.f12914c.f();
        V v2 = this.f12913b;
        this.f12913b = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f12912a);
        String valueOf2 = String.valueOf(this.f12913b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }
}
