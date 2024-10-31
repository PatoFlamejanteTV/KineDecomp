package com.google.android.gms.internal.firebase_auth;

import android.support.v7.widget.ActivityChooserView;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class zzeh implements Serializable, Iterable<Byte> {
    public static final zzeh zzso = new zzer(zzfv.EMPTY_BYTE_ARRAY);
    private static final InterfaceC1258k zzsp;
    private static final Comparator<zzeh> zzsr;
    private int zzsq = 0;

    static {
        zzsp = C1246e.a() ? new C1262m(null) : new C1256j(null);
        zzsr = new C1252h();
    }

    public static int zza(byte b2) {
        return b2 & 255;
    }

    public static zzeh zza(byte[] bArr) {
        return new zzer(bArr);
    }

    public static zzeh zzb(byte[] bArr, int i, int i2) {
        zzd(i, i + i2, bArr.length);
        return new zzer(zzsp.a(bArr, i, i2));
    }

    public static zzeh zzcz(String str) {
        return new zzer(str.getBytes(zzfv.UTF_8));
    }

    public static int zzd(int i, int i2, int i3) {
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

    public static zzeh zze(Iterable<zzeh> iterable) {
        int size = ((Collection) iterable).size();
        if (size == 0) {
            return zzso;
        }
        return zza(iterable.iterator(), size);
    }

    public static C1260l zzm(int i) {
        return new C1260l(i, null);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zzsq;
        if (i == 0) {
            int size = size();
            i = zzc(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.zzsq = i;
        }
        return i;
    }

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    protected abstract String zza(Charset charset);

    public abstract void zza(zzeg zzegVar) throws IOException;

    public abstract int zzb(int i, int i2, int i3);

    public abstract void zzb(byte[] bArr, int i, int i2, int i3);

    public abstract int zzc(int i, int i2, int i3);

    public abstract zzeh zzd(int i, int i2);

    @Override // java.lang.Iterable
    /* renamed from: zzez */
    public zzeo iterator() {
        return new C1250g(this);
    }

    public final String zzfa() {
        return size() == 0 ? "" : zza(zzfv.UTF_8);
    }

    public abstract boolean zzfb();

    public abstract int zzfc();

    public abstract boolean zzfd();

    public final int zzfe() {
        return this.zzsq;
    }

    public abstract byte zzk(int i);

    public abstract byte zzl(int i);

    private static zzeh zza(Iterator<zzeh> it, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", Integer.valueOf(i)));
        }
        if (i == 1) {
            return it.next();
        }
        int i2 = i >>> 1;
        zzeh zza = zza(it, i2);
        zzeh zza2 = zza(it, i - i2);
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - zza.size() >= zza2.size()) {
            return zzhs.zza(zza, zza2);
        }
        int size = zza.size();
        int size2 = zza2.size();
        StringBuilder sb = new StringBuilder(53);
        sb.append("ByteString would be too long: ");
        sb.append(size);
        sb.append("+");
        sb.append(size2);
        throw new IllegalArgumentException(sb.toString());
    }

    public static void zze(int i, int i2) {
        if (((i2 - (i + 1)) | i) < 0) {
            if (i < 0) {
                StringBuilder sb = new StringBuilder(22);
                sb.append("Index < 0: ");
                sb.append(i);
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            }
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Index > length: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new ArrayIndexOutOfBoundsException(sb2.toString());
        }
    }

    @Deprecated
    public final void zza(byte[] bArr, int i, int i2, int i3) {
        zzd(0, i3 + 0, size());
        zzd(i2, i2 + i3, bArr.length);
        if (i3 > 0) {
            zzb(bArr, 0, i2, i3);
        }
    }
}
