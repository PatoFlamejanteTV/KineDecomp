package com.google.android.gms.internal.measurement;

import java.util.Map;

/* loaded from: classes2.dex */
public final class mb<K, V> implements Comparable<mb>, Map.Entry<K, V> {

    /* renamed from: a */
    private final Comparable f13489a;

    /* renamed from: b */
    private V f13490b;

    /* renamed from: c */
    private final /* synthetic */ C1362fb f13491c;

    public mb(C1362fb c1362fb, Map.Entry<K, V> entry) {
        this(c1362fb, (Comparable) entry.getKey(), entry.getValue());
    }

    private static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(mb mbVar) {
        return ((Comparable) getKey()).compareTo((Comparable) mbVar.getKey());
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
        return a(this.f13489a, entry.getKey()) && a(this.f13490b, entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.f13489a;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.f13490b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f13489a;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        V v = this.f13490b;
        return hashCode ^ (v != null ? v.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        this.f13491c.f();
        V v2 = this.f13490b;
        this.f13490b = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f13489a);
        String valueOf2 = String.valueOf(this.f13490b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public mb(C1362fb c1362fb, K k, V v) {
        this.f13491c = c1362fb;
        this.f13489a = k;
        this.f13490b = v;
    }
}
