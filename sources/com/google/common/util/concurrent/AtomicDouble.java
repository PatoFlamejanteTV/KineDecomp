package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

@Beta
/* loaded from: classes2.dex */
public class AtomicDouble extends Number implements Serializable {
    private static final AtomicLongFieldUpdater<AtomicDouble> b = AtomicLongFieldUpdater.newUpdater(AtomicDouble.class, "a");
    private static final long serialVersionUID = 0;

    /* renamed from: a, reason: collision with root package name */
    private volatile transient long f2958a;

    public AtomicDouble(double d) {
        this.f2958a = Double.doubleToRawLongBits(d);
    }

    public AtomicDouble() {
    }

    public final double get() {
        return Double.longBitsToDouble(this.f2958a);
    }

    public final void set(double d) {
        this.f2958a = Double.doubleToRawLongBits(d);
    }

    public final void lazySet(double d) {
        set(d);
    }

    public final double getAndSet(double d) {
        return Double.longBitsToDouble(b.getAndSet(this, Double.doubleToRawLongBits(d)));
    }

    public final boolean compareAndSet(double d, double d2) {
        return b.compareAndSet(this, Double.doubleToRawLongBits(d), Double.doubleToRawLongBits(d2));
    }

    public final boolean weakCompareAndSet(double d, double d2) {
        return b.weakCompareAndSet(this, Double.doubleToRawLongBits(d), Double.doubleToRawLongBits(d2));
    }

    public final double getAndAdd(double d) {
        long j;
        double longBitsToDouble;
        do {
            j = this.f2958a;
            longBitsToDouble = Double.longBitsToDouble(j);
        } while (!b.compareAndSet(this, j, Double.doubleToRawLongBits(longBitsToDouble + d)));
        return longBitsToDouble;
    }

    public final double addAndGet(double d) {
        long j;
        double longBitsToDouble;
        do {
            j = this.f2958a;
            longBitsToDouble = Double.longBitsToDouble(j) + d;
        } while (!b.compareAndSet(this, j, Double.doubleToRawLongBits(longBitsToDouble)));
        return longBitsToDouble;
    }

    public String toString() {
        return Double.toString(get());
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) get();
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) get();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) get();
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return get();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeDouble(get());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        set(objectInputStream.readDouble());
    }
}
