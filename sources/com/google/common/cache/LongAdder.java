package com.google.common.cache;

import com.google.common.cache.Striped64;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
final class LongAdder extends Striped64 implements Serializable {
    private static final long serialVersionUID = 7249069246863182397L;

    @Override // com.google.common.cache.Striped64
    final long fn(long j, long j2) {
        return j + j2;
    }

    public void add(long j) {
        int length;
        Striped64.a aVar;
        boolean z = true;
        Striped64.a[] aVarArr = this.cells;
        if (aVarArr == null) {
            long j2 = this.base;
            if (casBase(j2, j2 + j)) {
                return;
            }
        }
        Striped64.b bVar = threadHashCode.get();
        int i = bVar.b;
        if (aVarArr != null && (length = aVarArr.length) >= 1 && (aVar = aVarArr[i & (length - 1)]) != null) {
            long j3 = aVar.f2625a;
            z = aVar.a(j3, j3 + j);
            if (z) {
                return;
            }
        }
        retryUpdate(j, bVar, z);
    }

    public void increment() {
        add(1L);
    }

    public void decrement() {
        add(-1L);
    }

    public long sum() {
        long j = this.base;
        Striped64.a[] aVarArr = this.cells;
        if (aVarArr != null) {
            for (Striped64.a aVar : aVarArr) {
                if (aVar != null) {
                    j += aVar.f2625a;
                }
            }
        }
        return j;
    }

    public void reset() {
        internalReset(0L);
    }

    public long sumThenReset() {
        long j = this.base;
        Striped64.a[] aVarArr = this.cells;
        this.base = 0L;
        if (aVarArr != null) {
            for (Striped64.a aVar : aVarArr) {
                if (aVar != null) {
                    j += aVar.f2625a;
                    aVar.f2625a = 0L;
                }
            }
        }
        return j;
    }

    public String toString() {
        return Long.toString(sum());
    }

    @Override // java.lang.Number
    public long longValue() {
        return sum();
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) sum();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) sum();
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return sum();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(sum());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.busy = 0;
        this.cells = null;
        this.base = objectInputStream.readLong();
    }
}
