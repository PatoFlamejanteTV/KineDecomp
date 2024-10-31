package com.nexstreaming.app.general.util;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class SeedableRandom implements Serializable {

    /* renamed from: a */
    private static volatile long f19844a = 0;
    private static final long serialVersionUID = 3905348978240129619L;
    private long seed;

    public SeedableRandom() {
        setSeed(System.nanoTime() + f19844a);
        f19844a++;
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
            bArr[i3] = (byte) i2;
            i2 >>= 8;
        }
    }

    public double nextDouble() {
        double next = (next(26) << 27) + next(27);
        Double.isNaN(next);
        return next / 9.007199254740992E15d;
    }

    public float nextFloat() {
        return next(24) / 1.6777216E7f;
    }

    public int nextInt() {
        return next(32);
    }

    public long nextLong() {
        return (next(32) << 32) + next(32);
    }

    public synchronized void restoreSeed(long j) {
        this.seed = j;
    }

    public synchronized long saveSeed() {
        return this.seed;
    }

    public synchronized void setSeed(long j) {
        this.seed = (j ^ 25214903917L) & 281474976710655L;
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

    public SeedableRandom(long j) {
        setSeed(j);
    }
}
