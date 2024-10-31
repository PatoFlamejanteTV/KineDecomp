package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

@GwtIncompatible
/* loaded from: classes2.dex */
public class AtomicDouble extends Number implements Serializable {

    /* renamed from: a */
    private static final AtomicLongFieldUpdater<AtomicDouble> f16160a = AtomicLongFieldUpdater.newUpdater(AtomicDouble.class, "b");
    private static final long serialVersionUID = 0;

    /* renamed from: b */
    private volatile transient long f16161b;

    public AtomicDouble(double d2) {
        this.f16161b = Double.doubleToRawLongBits(d2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        set(objectInputStream.readDouble());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeDouble(get());
    }

    @CanIgnoreReturnValue
    public final double addAndGet(double d2) {
        long j;
        double longBitsToDouble;
        do {
            j = this.f16161b;
            longBitsToDouble = Double.longBitsToDouble(j) + d2;
        } while (!f16160a.compareAndSet(this, j, Double.doubleToRawLongBits(longBitsToDouble)));
        return longBitsToDouble;
    }

    public final boolean compareAndSet(double d2, double d3) {
        return f16160a.compareAndSet(this, Double.doubleToRawLongBits(d2), Double.doubleToRawLongBits(d3));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return get();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) get();
    }

    public final double get() {
        return Double.longBitsToDouble(this.f16161b);
    }

    @CanIgnoreReturnValue
    public final double getAndAdd(double d2) {
        long j;
        double longBitsToDouble;
        do {
            j = this.f16161b;
            longBitsToDouble = Double.longBitsToDouble(j);
        } while (!f16160a.compareAndSet(this, j, Double.doubleToRawLongBits(longBitsToDouble + d2)));
        return longBitsToDouble;
    }

    public final double getAndSet(double d2) {
        return Double.longBitsToDouble(f16160a.getAndSet(this, Double.doubleToRawLongBits(d2)));
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) get();
    }

    public final void lazySet(double d2) {
        set(d2);
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) get();
    }

    public final void set(double d2) {
        this.f16161b = Double.doubleToRawLongBits(d2);
    }

    public String toString() {
        return Double.toString(get());
    }

    public final boolean weakCompareAndSet(double d2, double d3) {
        return f16160a.weakCompareAndSet(this, Double.doubleToRawLongBits(d2), Double.doubleToRawLongBits(d3));
    }

    public AtomicDouble() {
    }
}
