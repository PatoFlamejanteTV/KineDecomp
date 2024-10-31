package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class zzte implements Serializable, Iterable<Byte> {
    public static final zzte zzbtq = new zzto(zzuq.zzbza);
    private static final InterfaceC1367ha zzbtr;
    private static final Comparator<zzte> zzbts;
    private int zzbsi = 0;

    static {
        zzbtr = C1349ba.a() ? new C1372ja(null) : new C1364ga(null);
        zzbts = new C1358ea();
    }

    public static int zza(byte b2) {
        return b2 & 255;
    }

    public static C1370ia zzao(int i) {
        return new C1370ia(i, null);
    }

    public static zzte zzb(byte[] bArr, int i, int i2) {
        zzb(i, i + i2, bArr.length);
        return new zzto(zzbtr.a(bArr, i, i2));
    }

    public static zzte zzga(String str) {
        return new zzto(str.getBytes(zzuq.UTF_8));
    }

    public static zzte zzi(byte[] bArr) {
        return new zzto(bArr);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zzbsi;
        if (i == 0) {
            int size = size();
            i = zza(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.zzbsi = i;
        }
        return i;
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new C1355da(this);
    }

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    protected abstract int zza(int i, int i2, int i3);

    protected abstract String zza(Charset charset);

    public abstract void zza(zztd zztdVar) throws IOException;

    public abstract byte zzam(int i);

    public abstract byte zzan(int i);

    public abstract zzte zzb(int i, int i2);

    public final String zzud() {
        return size() == 0 ? "" : zza(zzuq.UTF_8);
    }

    public abstract boolean zzue();

    public final int zzuf() {
        return this.zzbsi;
    }

    public static int zzb(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("End index: ");
        sb3.append(i2);
        sb3.append(" >= ");
        sb3.append(i3);
        throw new IndexOutOfBoundsException(sb3.toString());
    }
}
