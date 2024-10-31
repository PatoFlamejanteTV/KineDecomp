package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class zzbrt extends AbstractC1069rh<String> implements zzbru, RandomAccess {
    private static final zzbrt zzfro;
    private static final zzbru zzfrp;
    private final List<Object> zzfrq;

    static {
        zzbrt zzbrtVar = new zzbrt();
        zzfro = zzbrtVar;
        zzbrtVar.zzakj();
        zzfrp = zzfro;
    }

    public zzbrt() {
        this(10);
    }

    private static String zzu(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzbpu) {
            return ((zzbpu) obj).zzakn();
        }
        return zzbrf.zzw((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zzakk();
        this.zzfrq.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zzakk();
        this.zzfrq.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzfrq.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzbpu) {
            zzbpu zzbpuVar = (zzbpu) obj;
            String zzakn = zzbpuVar.zzakn();
            if (zzbpuVar.zzako()) {
                this.zzfrq.set(i, zzakn);
            }
            return zzakn;
        }
        byte[] bArr = (byte[]) obj;
        String zzw = zzbrf.zzw(bArr);
        if (zzbrf.zzv(bArr)) {
            this.zzfrq.set(i, zzw);
        }
        return zzw;
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        zzakk();
        return zzu(this.zzfrq.set(i, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzfrq.size();
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, com.google.android.gms.internal.ads.zzbrk
    public final /* bridge */ /* synthetic */ boolean zzaki() {
        return super.zzaki();
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final List<?> zzano() {
        return Collections.unmodifiableList(this.zzfrq);
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final zzbru zzanp() {
        return zzaki() ? new zzbtx(this) : this;
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void zzap(zzbpu zzbpuVar) {
        zzakk();
        this.zzfrq.add(zzbpuVar);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzbrk
    public final /* synthetic */ zzbrk zzel(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzfrq);
            return new zzbrt((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final Object zzfp(int i) {
        return this.zzfrq.get(i);
    }

    public zzbrt(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzakk();
        if (collection instanceof zzbru) {
            collection = ((zzbru) collection).zzano();
        }
        boolean addAll = this.zzfrq.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzakk();
        Object remove = this.zzfrq.remove(i);
        ((AbstractList) this).modCount++;
        return zzu(remove);
    }

    private zzbrt(ArrayList<Object> arrayList) {
        this.zzfrq = arrayList;
    }
}
