package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

@KeepForSdk
/* loaded from: classes.dex */
public class DataBufferIterator<T> implements Iterator<T> {

    /* renamed from: a */
    protected final DataBuffer<T> f10996a;

    /* renamed from: b */
    protected int f10997b;

    public DataBufferIterator(DataBuffer<T> dataBuffer) {
        Preconditions.a(dataBuffer);
        this.f10996a = dataBuffer;
        this.f10997b = -1;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f10997b < this.f10996a.getCount() - 1;
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            DataBuffer<T> dataBuffer = this.f10996a;
            int i = this.f10997b + 1;
            this.f10997b = i;
            return dataBuffer.get(i);
        }
        int i2 = this.f10997b;
        StringBuilder sb = new StringBuilder(46);
        sb.append("Cannot advance the iterator beyond ");
        sb.append(i2);
        throw new NoSuchElementException(sb.toString());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
