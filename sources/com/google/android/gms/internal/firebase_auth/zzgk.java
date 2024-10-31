package com.google.android.gms.internal.firebase_auth;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class zzgk extends AbstractC1244d<String> implements zzgl, RandomAccess {
    private static final zzgk zzyr;
    private static final zzgl zzys;
    private final List<Object> zzyt;

    static {
        zzgk zzgkVar = new zzgk();
        zzyr = zzgkVar;
        zzgkVar.zzev();
        zzys = zzyr;
    }

    public zzgk() {
        this(10);
    }

    private static String zzh(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzeh) {
            return ((zzeh) obj).zzfa();
        }
        return zzfv.zze((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zzew();
        this.zzyt.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zzew();
        this.zzyt.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzyt.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzeh) {
            zzeh zzehVar = (zzeh) obj;
            String zzfa = zzehVar.zzfa();
            if (zzehVar.zzfb()) {
                this.zzyt.set(i, zzfa);
            }
            return zzfa;
        }
        byte[] bArr = (byte[]) obj;
        String zze = zzfv.zze(bArr);
        if (zzfv.zzd(bArr)) {
            this.zzyt.set(i, zze);
        }
        return zze;
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        zzew();
        return zzh(this.zzyt.set(i, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzyt.size();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgl
    public final Object zzat(int i) {
        return this.zzyt.get(i);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgl
    public final void zzc(zzeh zzehVar) {
        zzew();
        this.zzyt.add(zzehVar);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, com.google.android.gms.internal.firebase_auth.zzgb
    public final /* bridge */ /* synthetic */ boolean zzeu() {
        return super.zzeu();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgl
    public final List<?> zzic() {
        return Collections.unmodifiableList(this.zzyt);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgl
    public final zzgl zzid() {
        return zzeu() ? new zzit(this) : this;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgb
    public final /* synthetic */ zzgb zzj(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzyt);
            return new zzgk((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public zzgk(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzew();
        if (collection instanceof zzgl) {
            collection = ((zzgl) collection).zzic();
        }
        boolean addAll = this.zzyt.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzew();
        Object remove = this.zzyt.remove(i);
        ((AbstractList) this).modCount++;
        return zzh(remove);
    }

    private zzgk(ArrayList<Object> arrayList) {
        this.zzyt = arrayList;
    }
}
