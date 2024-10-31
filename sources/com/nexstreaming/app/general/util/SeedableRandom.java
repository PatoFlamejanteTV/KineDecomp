package com.nexstreaming.app.general.util;

import java.io.Serializable;

/* loaded from: classes.dex */
public class SeedableRandom implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private static volatile long f3222a = 0;
    private static final long serialVersionUID = 3905348978240129619L;
    private long seed;

    public SeedableRandom() {
        setSeed(System.nanoTime() + f3222a);
        f3222a++;
    }

    public SeedableRandom(long j) {
        setSeed(j);
    }

    protected synchronized int next(int i) {
        this.seed = ((this.seed * 25214903917L) + 11) & 281474976710655L;
        return (int) (this.seed >>> (48 - i));
    }

    public boolean nextBoolean() {
        return next(1) != 0;
    }

    public void nextBytes(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            if (i == 0) {
                i2 = nextInt();
                i = 3;
            } else {
                i--;
            }
            int i4 = i2;
            bArr[i3] = (byte) i4;
            i2 = i4 >> 8;
        }
    }

    public double nextDouble() {
        return ((next(26) << 27) + next(27)) / 9.007199254740992E15d;
    }

    public float nextFloat() {
        return next(24) / 1.6777216E7f;
    }

    public int nextInt() {
        return next(32);
    }

    public int nextInt(int i) {
        int next;
        int i2;
        if (i <= 0) {
            throw new IllegalArgumentException("n <= 0: " + i);
        }
        if (((-i) & i) == i) {
            return (int) ((i * next(31)) >> 31);
        }
        do {
            next = next(31);
            i2 = next % i;
        } while ((next - i2) + (i - 1) < 0);
        return i2;
    }

    public long nextLong() {
        return (next(32) << 32) + next(32);
    }

    public synchronized void setSeed(long j) {
        this.seed = (25214903917L ^ j) & 281474976710655L;
    }

    public synchronized long saveSeed() {
        return this.seed;
    }

    public synchronized void restoreSeed(long j) {
        this.seed = j;
    }
}
