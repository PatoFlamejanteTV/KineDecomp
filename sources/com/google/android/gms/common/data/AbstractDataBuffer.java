package com.google.android.gms.common.data;

import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class AbstractDataBuffer<T> implements DataBuffer<T> {

    /* renamed from: a, reason: collision with root package name */
    protected final DataHolder f982a;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDataBuffer(DataHolder dataHolder) {
        this.f982a = dataHolder;
        if (this.f982a != null) {
            this.f982a.a(this);
        }
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public int a() {
        if (this.f982a == null) {
            return 0;
        }
        return this.f982a.g();
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new zzb(this);
    }

    @Override // com.google.android.gms.common.api.Releasable
    public void release() {
        if (this.f982a != null) {
            this.f982a.i();
        }
    }
}
