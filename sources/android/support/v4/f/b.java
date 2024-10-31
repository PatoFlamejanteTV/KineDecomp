package android.support.v4.f;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: ArrayMap.java */
/* loaded from: classes.dex */
public class b<K, V> extends h<K, V> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f76a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f76a = aVar;
    }

    @Override // android.support.v4.f.h
    protected int a() {
        return this.f76a.h;
    }

    @Override // android.support.v4.f.h
    protected Object a(int i, int i2) {
        return this.f76a.g[(i << 1) + i2];
    }

    @Override // android.support.v4.f.h
    protected int a(Object obj) {
        return this.f76a.a(obj);
    }

    @Override // android.support.v4.f.h
    protected int b(Object obj) {
        return this.f76a.b(obj);
    }

    @Override // android.support.v4.f.h
    protected Map<K, V> b() {
        return this.f76a;
    }

    @Override // android.support.v4.f.h
    protected void a(K k, V v) {
        this.f76a.put(k, v);
    }

    @Override // android.support.v4.f.h
    protected V a(int i, V v) {
        return this.f76a.a(i, (int) v);
    }

    @Override // android.support.v4.f.h
    protected void a(int i) {
        this.f76a.d(i);
    }

    @Override // android.support.v4.f.h
    protected void c() {
        this.f76a.clear();
    }
}
