package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class zzxg extends AbstractList<String> implements zzve, RandomAccess {
    private final zzve zzcch;

    public zzxg(zzve zzveVar) {
        this.zzcch = zzveVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.zzcch.get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new wb(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new vb(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzcch.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzve
    public final Object zzbp(int i) {
        return this.zzcch.zzbp(i);
    }

    @Override // com.google.android.gms.internal.measurement.zzve
    public final void zzc(zzte zzteVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.measurement.zzve
    public final List<?> zzxb() {
        return this.zzcch.zzxb();
    }

    @Override // com.google.android.gms.internal.measurement.zzve
    public final zzve zzxc() {
        return this;
    }
}
