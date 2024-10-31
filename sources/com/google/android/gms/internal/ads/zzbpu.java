package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class zzbpu implements Serializable, Iterable<Byte> {
    public static final zzbpu zzfli = new zzbqd(zzbrf.zzfqr);
    private static final InterfaceC1181zh zzflj;
    private static final Comparator<zzbpu> zzflk;
    private int zzfks = 0;

    static {
        zzflj = C1083sh.a() ? new Bh(null) : new C1167yh(null);
        zzflk = new C1153xh();
    }

    public static int zzb(byte b2) {
        return b2 & 255;
    }

    public static Ah zzen(int i) {
        return new Ah(i, null);
    }

    public static zzbpu zzfw(String str) {
        return new zzbqd(str.getBytes(zzbrf.UTF_8));
    }

    public static int zzg(int i, int i2, int i3) {
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

    public static zzbpu zzi(byte[] bArr, int i, int i2) {
        zzg(i, i + i2, bArr.length);
        return new zzbqd(zzflj.a(bArr, i, i2));
    }

    public static zzbpu zzr(byte[] bArr) {
        return zzi(bArr, 0, bArr.length);
    }

    public static zzbpu zzs(byte[] bArr) {
        return new zzbqd(bArr);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zzfks;
        if (i == 0) {
            int size = size();
            i = zzf(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.zzfks = i;
        }
        return i;
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new C1139wh(this);
    }

    public abstract int size();

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return zzbrf.zzfqr;
        }
        byte[] bArr = new byte[size];
        zza(bArr, 0, 0, size);
        return bArr;
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    protected abstract String zza(Charset charset);

    public abstract void zza(zzbpt zzbptVar) throws IOException;

    protected abstract void zza(byte[] bArr, int i, int i2, int i3);

    public final String zzakn() {
        return size() == 0 ? "" : zza(zzbrf.UTF_8);
    }

    public abstract boolean zzako();

    public abstract zzbqf zzakp();

    public final int zzakq() {
        return this.zzfks;
    }

    public abstract byte zzem(int i);

    protected abstract int zzf(int i, int i2, int i3);

    public abstract zzbpu zzt(int i, int i2);
}
