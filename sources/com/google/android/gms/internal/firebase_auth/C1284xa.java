package com.google.android.gms.internal.firebase_auth;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase_auth.xa */
/* loaded from: classes2.dex */
public final class C1284xa<K, V> implements Comparable<C1284xa>, Map.Entry<K, V> {

    /* renamed from: a */
    private final Comparable f13089a;

    /* renamed from: b */
    private V f13090b;

    /* renamed from: c */
    private final /* synthetic */ C1269pa f13091c;

    public C1284xa(C1269pa c1269pa, Map.Entry<K, V> entry) {
        this(c1269pa, (Comparable) entry.getKey(), entry.getValue());
    }

    private static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(C1284xa c1284xa) {
        return ((Comparable) getKey()).compareTo((Comparable) c1284xa.getKey());
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
        return a(this.f13089a, entry.getKey()) && a(this.f13090b, entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.f13089a;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.f13090b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f13089a;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        V v = this.f13090b;
        return hashCode ^ (v != null ? v.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        this.f13091c.f();
        V v2 = this.f13090b;
        this.f13090b = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f13089a);
        String valueOf2 = String.valueOf(this.f13090b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C1284xa(C1269pa c1269pa, K k, V v) {
        this.f13091c = c1269pa;
        this.f13089a = k;
        this.f13090b = v;
    }
}
