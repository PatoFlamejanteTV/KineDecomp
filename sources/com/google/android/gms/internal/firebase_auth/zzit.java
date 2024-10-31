package com.google.android.gms.internal.firebase_auth;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class zzit extends AbstractList<String> implements zzgl, RandomAccess {
    private final zzgl zzabr;

    public zzit(zzgl zzglVar) {
        this.zzabr = zzglVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.zzabr.get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new Ia(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new Ha(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzabr.size();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgl
    public final Object zzat(int i) {
        return this.zzabr.zzat(i);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgl
    public final void zzc(zzeh zzehVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgl
    public final List<?> zzic() {
        return this.zzabr.zzic();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgl
    public final zzgl zzid() {
        return this;
    }
}
