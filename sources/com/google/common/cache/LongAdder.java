package com.google.common.cache;

import com.google.common.cache.Striped64;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
final class LongAdder extends Striped64 implements Serializable, m {
    private static final long serialVersionUID = 7249069246863182397L;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.busy = 0;
        this.cells = null;
        this.base = objectInputStream.readLong();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(sum());
    }

    @Override // com.google.common.cache.m
    public void add(long j) {
        int length;
        Striped64.a aVar;
        Striped64.a[] aVarArr = this.cells;
        if (aVarArr == null) {
            long j2 = this.base;
            if (casBase(j2, j2 + j)) {
                return;
            }
        }
        int[] iArr = Striped64.threadHashCode.get();
        boolean z = true;
        if (iArr != null && aVarArr != null && (length = aVarArr.length) >= 1 && (aVar = aVarArr[(length - 1) & iArr[0]]) != null) {
            long j3 = aVar.f15252c;
            z = aVar.a(j3, j3 + j);
            if (z) {
                return;
            }
        }
        retryUpdate(j, iArr, z);
    }

    public void decrement() {
        add(-1L);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return sum();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) sum();
    }

    @Override // com.google.common.cache.Striped64
    final long fn(long j, long j2) {
        return j + j2;
    }

    @Override // com.google.common.cache.m
    public void increment() {
        add(1L);
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) sum();
    }

    @Override // java.lang.Number
    public long longValue() {
        return sum();
    }

    public void reset() {
        internalReset(0L);
    }

    @Override // com.google.common.cache.m
    public long sum() {
        long j = this.base;
        Striped64.a[] aVarArr = this.cells;
        if (aVarArr != null) {
            for (Striped64.a aVar : aVarArr) {
                if (aVar != null) {
                    j += aVar.f15252c;
                }
            }
        }
        return j;
    }

    public long sumThenReset() {
        long j = this.base;
        Striped64.a[] aVarArr = this.cells;
        this.base = 0L;
        if (aVarArr != null) {
            for (Striped64.a aVar : aVarArr) {
                if (aVar != null) {
                    j += aVar.f15252c;
                    aVar.f15252c = 0L;
                }
            }
        }
        return j;
    }

    public String toString() {
        return Long.toString(sum());
    }
}
