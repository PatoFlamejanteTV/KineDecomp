package com.google.android.gms.internal.gtm;

import java.util.Map;

/* loaded from: classes2.dex */
public final class jb<K, V> implements Comparable<jb>, Map.Entry<K, V> {

    /* renamed from: a */
    private final Comparable f13249a;

    /* renamed from: b */
    private V f13250b;

    /* renamed from: c */
    private final /* synthetic */ C1297cb f13251c;

    public jb(C1297cb c1297cb, Map.Entry<K, V> entry) {
        this(c1297cb, (Comparable) entry.getKey(), entry.getValue());
    }

    private static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(jb jbVar) {
        return ((Comparable) getKey()).compareTo((Comparable) jbVar.getKey());
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
        return a(this.f13249a, entry.getKey()) && a(this.f13250b, entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.f13249a;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.f13250b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f13249a;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        V v = this.f13250b;
        return hashCode ^ (v != null ? v.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        this.f13251c.f();
        V v2 = this.f13250b;
        this.f13250b = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f13249a);
        String valueOf2 = String.valueOf(this.f13250b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public jb(C1297cb c1297cb, K k, V v) {
        this.f13251c = c1297cb;
        this.f13249a = k;
        this.f13250b = v;
    }
}
