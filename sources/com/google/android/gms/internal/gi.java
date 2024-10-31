package com.google.android.gms.internal;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* loaded from: classes.dex */
class gi<K, V> extends gj<K, V> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzme f1572a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gi(zzme zzmeVar) {
        this.f1572a = zzmeVar;
    }

    @Override // com.google.android.gms.internal.gj
    protected int a() {
        return this.f1572a.mSize;
    }

    @Override // com.google.android.gms.internal.gj
    protected int a(Object obj) {
        return obj == null ? this.f1572a.indexOfNull() : this.f1572a.indexOf(obj, obj.hashCode());
    }

    @Override // com.google.android.gms.internal.gj
    protected Object a(int i, int i2) {
        return this.f1572a.mArray[(i << 1) + i2];
    }

    @Override // com.google.android.gms.internal.gj
    protected V a(int i, V v) {
        return this.f1572a.setValueAt(i, v);
    }

    @Override // com.google.android.gms.internal.gj
    protected void a(int i) {
        this.f1572a.removeAt(i);
    }

    @Override // com.google.android.gms.internal.gj
    protected void a(K k, V v) {
        this.f1572a.put(k, v);
    }

    @Override // com.google.android.gms.internal.gj
    protected int b(Object obj) {
        return this.f1572a.indexOfValue(obj);
    }

    @Override // com.google.android.gms.internal.gj
    protected Map<K, V> b() {
        return this.f1572a;
    }

    @Override // com.google.android.gms.internal.gj
    protected void c() {
        this.f1572a.clear();
    }
}
