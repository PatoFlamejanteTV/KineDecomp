package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongArray;

@Beta
/* loaded from: classes2.dex */
public class AtomicDoubleArray implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a, reason: collision with root package name */
    private transient AtomicLongArray f2959a;

    public AtomicDoubleArray(int i) {
        this.f2959a = new AtomicLongArray(i);
    }

    public AtomicDoubleArray(double[] dArr) {
        int length = dArr.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = Double.doubleToRawLongBits(dArr[i]);
        }
        this.f2959a = new AtomicLongArray(jArr);
    }

    public final int length() {
        return this.f2959a.length();
    }

    public final double get(int i) {
        return Double.longBitsToDouble(this.f2959a.get(i));
    }

    public final void set(int i, double d) {
        this.f2959a.set(i, Double.doubleToRawLongBits(d));
    }

    public final void lazySet(int i, double d) {
        set(i, d);
    }

    public final double getAndSet(int i, double d) {
        return Double.longBitsToDouble(this.f2959a.getAndSet(i, Double.doubleToRawLongBits(d)));
    }

    public final boolean compareAndSet(int i, double d, double d2) {
        return this.f2959a.compareAndSet(i, Double.doubleToRawLongBits(d), Double.doubleToRawLongBits(d2));
    }

    public final boolean weakCompareAndSet(int i, double d, double d2) {
        return this.f2959a.weakCompareAndSet(i, Double.doubleToRawLongBits(d), Double.doubleToRawLongBits(d2));
    }

    public final double getAndAdd(int i, double d) {
        long j;
        double longBitsToDouble;
        do {
            j = this.f2959a.get(i);
            longBitsToDouble = Double.longBitsToDouble(j);
        } while (!this.f2959a.compareAndSet(i, j, Double.doubleToRawLongBits(longBitsToDouble + d)));
        return longBitsToDouble;
    }

    public double addAndGet(int i, double d) {
        long j;
        double longBitsToDouble;
        do {
            j = this.f2959a.get(i);
            longBitsToDouble = Double.longBitsToDouble(j) + d;
        } while (!this.f2959a.compareAndSet(i, j, Double.doubleToRawLongBits(longBitsToDouble)));
        return longBitsToDouble;
    }

    public String toString() {
        int length = length() - 1;
        if (length == -1) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder((length + 1) * 19);
        sb.append('[');
        int i = 0;
        while (true) {
            sb.append(Double.longBitsToDouble(this.f2959a.get(i)));
            if (i == length) {
                return sb.append(']').toString();
            }
            sb.append(',').append(' ');
            i++;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        int length = length();
        objectOutputStream.writeInt(length);
        for (int i = 0; i < length; i++) {
            objectOutputStream.writeDouble(get(i));
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        this.f2959a = new AtomicLongArray(readInt);
        for (int i = 0; i < readInt; i++) {
            set(i, objectInputStream.readDouble());
        }
    }
}
