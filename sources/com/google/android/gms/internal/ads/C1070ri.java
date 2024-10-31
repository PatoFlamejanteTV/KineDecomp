package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.ri */
/* loaded from: classes2.dex */
public final class C1070ri<E> extends AbstractC1069rh<E> {

    /* renamed from: a */
    private static final C1070ri<Object> f12496a;

    /* renamed from: b */
    private final List<E> f12497b;

    static {
        C1070ri<Object> c1070ri = new C1070ri<>();
        f12496a = c1070ri;
        c1070ri.zzakj();
    }

    C1070ri() {
        this(new ArrayList(10));
    }

    public static <E> C1070ri<E> a() {
        return (C1070ri<E>) f12496a;
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractList, java.util.List
    public final void add(int i, E e2) {
        zzakk();
        this.f12497b.add(i, e2);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i) {
        return this.f12497b.get(i);
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractList, java.util.List
    public final E remove(int i) {
        zzakk();
        E remove = this.f12497b.remove(i);
        ((AbstractList) this).modCount++;
        return remove;
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractList, java.util.List
    public final E set(int i, E e2) {
        zzakk();
        E e3 = this.f12497b.set(i, e2);
        ((AbstractList) this).modCount++;
        return e3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f12497b.size();
    }

    @Override // com.google.android.gms.internal.ads.zzbrk
    public final /* synthetic */ zzbrk zzel(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.f12497b);
            return new C1070ri(arrayList);
        }
        throw new IllegalArgumentException();
    }

    private C1070ri(List<E> list) {
        this.f12497b = list;
    }
}
