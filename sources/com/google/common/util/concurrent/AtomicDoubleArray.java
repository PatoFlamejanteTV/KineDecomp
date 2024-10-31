package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongArray;

@GwtIncompatible
/* loaded from: classes2.dex */
public class AtomicDoubleArray implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    private transient AtomicLongArray f16162a;

    public AtomicDoubleArray(int i) {
        this.f16162a = new AtomicLongArray(i);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        this.f16162a = new AtomicLongArray(readInt);
        for (int i = 0; i < readInt; i++) {
            set(i, objectInputStream.readDouble());
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

    @CanIgnoreReturnValue
    public double addAndGet(int i, double d2) {
        long j;
        double longBitsToDouble;
        do {
            j = this.f16162a.get(i);
            longBitsToDouble = Double.longBitsToDouble(j) + d2;
        } while (!this.f16162a.compareAndSet(i, j, Double.doubleToRawLongBits(longBitsToDouble)));
        return longBitsToDouble;
    }

    public final boolean compareAndSet(int i, double d2, double d3) {
        return this.f16162a.compareAndSet(i, Double.doubleToRawLongBits(d2), Double.doubleToRawLongBits(d3));
    }

    public final double get(int i) {
        return Double.longBitsToDouble(this.f16162a.get(i));
    }

    @CanIgnoreReturnValue
    public final double getAndAdd(int i, double d2) {
        long j;
        double longBitsToDouble;
        do {
            j = this.f16162a.get(i);
            longBitsToDouble = Double.longBitsToDouble(j);
        } while (!this.f16162a.compareAndSet(i, j, Double.doubleToRawLongBits(longBitsToDouble + d2)));
        return longBitsToDouble;
    }

    public final double getAndSet(int i, double d2) {
        return Double.longBitsToDouble(this.f16162a.getAndSet(i, Double.doubleToRawLongBits(d2)));
    }

    public final void lazySet(int i, double d2) {
        set(i, d2);
    }

    public final int length() {
        return this.f16162a.length();
    }

    public final void set(int i, double d2) {
        this.f16162a.set(i, Double.doubleToRawLongBits(d2));
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
            sb.append(Double.longBitsToDouble(this.f16162a.get(i)));
            if (i == length) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(',');
            sb.append(' ');
            i++;
        }
    }

    public final boolean weakCompareAndSet(int i, double d2, double d3) {
        return this.f16162a.weakCompareAndSet(i, Double.doubleToRawLongBits(d2), Double.doubleToRawLongBits(d3));
    }

    public AtomicDoubleArray(double[] dArr) {
        int length = dArr.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = Double.doubleToRawLongBits(dArr[i]);
        }
        this.f16162a = new AtomicLongArray(jArr);
    }
}
