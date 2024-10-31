package com.google.android.gms.internal.firebase_auth;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase_auth.ga */
/* loaded from: classes2.dex */
public final class C1251ga<E> extends AbstractC1244d<E> {

    /* renamed from: a */
    private static final C1251ga<Object> f13032a;

    /* renamed from: b */
    private final List<E> f13033b;

    static {
        C1251ga<Object> c1251ga = new C1251ga<>();
        f13032a = c1251ga;
        c1251ga.zzev();
    }

    C1251ga() {
        this(new ArrayList(10));
    }

    public static <E> C1251ga<E> a() {
        return (C1251ga<E>) f13032a;
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractList, java.util.List
    public final void add(int i, E e2) {
        zzew();
        this.f13033b.add(i, e2);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i) {
        return this.f13033b.get(i);
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractList, java.util.List
    public final E remove(int i) {
        zzew();
        E remove = this.f13033b.remove(i);
        ((AbstractList) this).modCount++;
        return remove;
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractList, java.util.List
    public final E set(int i, E e2) {
        zzew();
        E e3 = this.f13033b.set(i, e2);
        ((AbstractList) this).modCount++;
        return e3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f13033b.size();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgb
    public final /* synthetic */ zzgb zzj(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.f13033b);
            return new C1251ga(arrayList);
        }
        throw new IllegalArgumentException();
    }

    private C1251ga(List<E> list) {
        this.f13033b = list;
    }
}
