package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class zzbtx extends AbstractList<String> implements zzbru, RandomAccess {
    private final zzbru zzftz;

    public zzbtx(zzbru zzbruVar) {
        this.zzftz = zzbruVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.zzftz.get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new Oi(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new Ni(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzftz.size();
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final List<?> zzano() {
        return this.zzftz.zzano();
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final zzbru zzanp() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void zzap(zzbpu zzbpuVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final Object zzfp(int i) {
        return this.zzftz.zzfp(i);
    }
}
