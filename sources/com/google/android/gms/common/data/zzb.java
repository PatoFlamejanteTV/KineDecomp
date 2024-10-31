package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class zzb<T> implements Iterator<T> {

    /* renamed from: a, reason: collision with root package name */
    protected final DataBuffer<T> f987a;
    protected int b = -1;

    public zzb(DataBuffer<T> dataBuffer) {
        this.f987a = (DataBuffer) zzx.a(dataBuffer);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.f987a.a() + (-1);
    }

    @Override // java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Cannot advance the iterator beyond " + this.b);
        }
        DataBuffer<T> dataBuffer = this.f987a;
        int i = this.b + 1;
        this.b = i;
        return dataBuffer.a(i);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
