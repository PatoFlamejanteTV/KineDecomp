package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class _a<E> extends AbstractC1346aa<E> {

    /* renamed from: a */
    private static final _a<Object> f13411a;

    /* renamed from: b */
    private final List<E> f13412b;

    static {
        _a<Object> _aVar = new _a<>();
        f13411a = _aVar;
        _aVar.zzsw();
    }

    _a() {
        this(new ArrayList(10));
    }

    public static <E> _a<E> a() {
        return (_a<E>) f13411a;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.List
    public final void add(int i, E e2) {
        zzua();
        this.f13412b.add(i, e2);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i) {
        return this.f13412b.get(i);
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.List
    public final E remove(int i) {
        zzua();
        E remove = this.f13412b.remove(i);
        ((AbstractList) this).modCount++;
        return remove;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.List
    public final E set(int i, E e2) {
        zzua();
        E e3 = this.f13412b.set(i, e2);
        ((AbstractList) this).modCount++;
        return e3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f13412b.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzuu
    public final /* synthetic */ zzuu zzal(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.f13412b);
            return new _a(arrayList);
        }
        throw new IllegalArgumentException();
    }

    private _a(List<E> list) {
        this.f13412b = list;
    }
}
