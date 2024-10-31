package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes2.dex */
public final class Ei<K, V> implements Comparable<Ei>, Map.Entry<K, V> {

    /* renamed from: a */
    private final Comparable f11496a;

    /* renamed from: b */
    private V f11497b;

    /* renamed from: c */
    private final /* synthetic */ C1154xi f11498c;

    public Ei(C1154xi c1154xi, Map.Entry<K, V> entry) {
        this(c1154xi, (Comparable) entry.getKey(), entry.getValue());
    }

    private static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Ei ei) {
        return ((Comparable) getKey()).compareTo((Comparable) ei.getKey());
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
        return a(this.f11496a, entry.getKey()) && a(this.f11497b, entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.f11496a;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.f11497b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f11496a;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        V v = this.f11497b;
        return hashCode ^ (v != null ? v.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        this.f11498c.f();
        V v2 = this.f11497b;
        this.f11497b = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f11496a);
        String valueOf2 = String.valueOf(this.f11497b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Ei(C1154xi c1154xi, K k, V v) {
        this.f11498c = c1154xi;
        this.f11496a = k;
        this.f11497b = v;
    }
}
