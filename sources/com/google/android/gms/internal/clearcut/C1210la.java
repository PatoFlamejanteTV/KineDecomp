package com.google.android.gms.internal.clearcut;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.internal.clearcut.la */
/* loaded from: classes2.dex */
public final class C1210la<E> extends AbstractC1209l<E> {

    /* renamed from: a */
    private static final C1210la<Object> f12852a;

    /* renamed from: b */
    private final List<E> f12853b;

    static {
        C1210la<Object> c1210la = new C1210la<>();
        f12852a = c1210la;
        c1210la.zzv();
    }

    C1210la() {
        this(new ArrayList(10));
    }

    private C1210la(List<E> list) {
        this.f12853b = list;
    }

    public static <E> C1210la<E> a() {
        return (C1210la<E>) f12852a;
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractList, java.util.List
    public final void add(int i, E e2) {
        zzw();
        this.f12853b.add(i, e2);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i) {
        return this.f12853b.get(i);
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractList, java.util.List
    public final E remove(int i) {
        zzw();
        E remove = this.f12853b.remove(i);
        ((AbstractList) this).modCount++;
        return remove;
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractList, java.util.List
    public final E set(int i, E e2) {
        zzw();
        E e3 = this.f12853b.set(i, e2);
        ((AbstractList) this).modCount++;
        return e3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f12853b.size();
    }

    @Override // com.google.android.gms.internal.clearcut.zzcn
    public final /* synthetic */ zzcn zzi(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.f12853b);
        return new C1210la(arrayList);
    }
}
