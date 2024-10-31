package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class zzvd extends AbstractC1346aa<String> implements zzve, RandomAccess {
    private static final zzvd zzbzx;
    private static final zzve zzbzy;
    private final List<Object> zzbzz;

    static {
        zzvd zzvdVar = new zzvd();
        zzbzx = zzvdVar;
        zzvdVar.zzsw();
        zzbzy = zzbzx;
    }

    public zzvd() {
        this(10);
    }

    private static String zzaa(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzte) {
            return ((zzte) obj).zzud();
        }
        return zzuq.zzm((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zzua();
        this.zzbzz.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zzua();
        this.zzbzz.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzbzz.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzte) {
            zzte zzteVar = (zzte) obj;
            String zzud = zzteVar.zzud();
            if (zzteVar.zzue()) {
                this.zzbzz.set(i, zzud);
            }
            return zzud;
        }
        byte[] bArr = (byte[]) obj;
        String zzm = zzuq.zzm(bArr);
        if (zzuq.zzl(bArr)) {
            this.zzbzz.set(i, zzm);
        }
        return zzm;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        zzua();
        return zzaa(this.zzbzz.set(i, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzbzz.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzuu
    public final /* synthetic */ zzuu zzal(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzbzz);
            return new zzvd((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.measurement.zzve
    public final Object zzbp(int i) {
        return this.zzbzz.get(i);
    }

    @Override // com.google.android.gms.internal.measurement.zzve
    public final void zzc(zzte zzteVar) {
        zzua();
        this.zzbzz.add(zzteVar);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, com.google.android.gms.internal.measurement.zzuu
    public final /* bridge */ /* synthetic */ boolean zztz() {
        return super.zztz();
    }

    @Override // com.google.android.gms.internal.measurement.zzve
    public final List<?> zzxb() {
        return Collections.unmodifiableList(this.zzbzz);
    }

    @Override // com.google.android.gms.internal.measurement.zzve
    public final zzve zzxc() {
        return zztz() ? new zzxg(this) : this;
    }

    public zzvd(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzua();
        if (collection instanceof zzve) {
            collection = ((zzve) collection).zzxb();
        }
        boolean addAll = this.zzbzz.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzua();
        Object remove = this.zzbzz.remove(i);
        ((AbstractList) this).modCount++;
        return zzaa(remove);
    }

    private zzvd(ArrayList<Object> arrayList) {
        this.zzbzz = arrayList;
    }
}
