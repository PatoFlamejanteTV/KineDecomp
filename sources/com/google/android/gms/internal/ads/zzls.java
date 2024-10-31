package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class zzls implements zzii {
    private final zzot zzawq;
    private final int zzaym;
    private C1157xl zzayq;
    private C1157xl zzayr;
    private zzfs zzays;
    private boolean zzayt;
    private zzfs zzayu;
    private long zzayv;
    private long zzayw;
    private int zzayx;
    private zzlu zzayy;
    private final C1143wl zzayn = new C1143wl();
    private final zzlr zzayo = new zzlr();
    private final zzpx zzahz = new zzpx(32);
    private final AtomicInteger zzayp = new AtomicInteger();

    public zzls(zzot zzotVar) {
        this.zzawq = zzotVar;
        this.zzaym = zzotVar.zzgr();
        int i = this.zzaym;
        this.zzayx = i;
        this.zzayq = new C1157xl(0L, i);
        this.zzayr = this.zzayq;
    }

    private final void zzad(long j) {
        while (true) {
            C1157xl c1157xl = this.zzayq;
            if (j < c1157xl.f12669b) {
                return;
            }
            this.zzawq.zza(c1157xl.f12671d);
            this.zzayq = this.zzayq.a();
        }
    }

    private final int zzas(int i) {
        if (this.zzayx == this.zzaym) {
            this.zzayx = 0;
            C1157xl c1157xl = this.zzayr;
            if (c1157xl.f12670c) {
                this.zzayr = c1157xl.f12672e;
            }
            C1157xl c1157xl2 = this.zzayr;
            zzos zzgq = this.zzawq.zzgq();
            C1157xl c1157xl3 = new C1157xl(this.zzayr.f12669b, this.zzaym);
            c1157xl2.f12671d = zzgq;
            c1157xl2.f12672e = c1157xl3;
            c1157xl2.f12670c = true;
        }
        return Math.min(i, this.zzaym - this.zzayx);
    }

    private final void zzfi() {
        this.zzayn.b();
        zza(this.zzayq);
        this.zzayq = new C1157xl(0L, this.zzaym);
        this.zzayr = this.zzayq;
        this.zzayw = 0L;
        this.zzayx = this.zzaym;
        this.zzawq.zzo();
    }

    private final boolean zzfq() {
        return this.zzayp.compareAndSet(0, 1);
    }

    private final void zzfr() {
        if (this.zzayp.compareAndSet(1, 0)) {
            return;
        }
        zzfi();
    }

    public final void disable() {
        if (this.zzayp.getAndSet(2) == 0) {
            zzfi();
        }
    }

    public final int zza(zzfu zzfuVar, zzho zzhoVar, boolean z, boolean z2, long j) {
        int i;
        int a2 = this.zzayn.a(zzfuVar, zzhoVar, z, z2, this.zzays, this.zzayo);
        if (a2 == -5) {
            this.zzays = zzfuVar.zzaad;
            return -5;
        }
        if (a2 != -4) {
            if (a2 == -3) {
                return -3;
            }
            throw new IllegalStateException();
        }
        if (!zzhoVar.zzdp()) {
            if (zzhoVar.zzago < j) {
                zzhoVar.zzq(Integer.MIN_VALUE);
            }
            if (zzhoVar.zzdt()) {
                zzlr zzlrVar = this.zzayo;
                long j2 = zzlrVar.zzapb;
                this.zzahz.reset(1);
                zza(j2, this.zzahz.data, 1);
                long j3 = j2 + 1;
                byte b2 = this.zzahz.data[0];
                boolean z3 = (b2 & 128) != 0;
                int i2 = b2 & Byte.MAX_VALUE;
                zzhk zzhkVar = zzhoVar.zzagn;
                if (zzhkVar.iv == null) {
                    zzhkVar.iv = new byte[16];
                }
                zza(j3, zzhoVar.zzagn.iv, i2);
                long j4 = j3 + i2;
                if (z3) {
                    this.zzahz.reset(2);
                    zza(j4, this.zzahz.data, 2);
                    j4 += 2;
                    i = this.zzahz.readUnsignedShort();
                } else {
                    i = 1;
                }
                int[] iArr = zzhoVar.zzagn.numBytesOfClearData;
                if (iArr == null || iArr.length < i) {
                    iArr = new int[i];
                }
                int[] iArr2 = iArr;
                int[] iArr3 = zzhoVar.zzagn.numBytesOfEncryptedData;
                if (iArr3 == null || iArr3.length < i) {
                    iArr3 = new int[i];
                }
                int[] iArr4 = iArr3;
                if (z3) {
                    int i3 = i * 6;
                    this.zzahz.reset(i3);
                    zza(j4, this.zzahz.data, i3);
                    j4 += i3;
                    this.zzahz.setPosition(0);
                    for (int i4 = 0; i4 < i; i4++) {
                        iArr2[i4] = this.zzahz.readUnsignedShort();
                        iArr4[i4] = this.zzahz.zzhg();
                    }
                } else {
                    iArr2[0] = 0;
                    iArr4[0] = zzlrVar.size - ((int) (j4 - zzlrVar.zzapb));
                }
                zzij zzijVar = zzlrVar.zzajw;
                zzhk zzhkVar2 = zzhoVar.zzagn;
                zzhkVar2.set(i, iArr2, iArr4, zzijVar.zzahh, zzhkVar2.iv, zzijVar.zzahg);
                long j5 = zzlrVar.zzapb;
                int i5 = (int) (j4 - j5);
                zzlrVar.zzapb = j5 + i5;
                zzlrVar.size -= i5;
            }
            zzhoVar.zzs(this.zzayo.size);
            zzlr zzlrVar2 = this.zzayo;
            long j6 = zzlrVar2.zzapb;
            ByteBuffer byteBuffer = zzhoVar.zzdd;
            int i6 = zzlrVar2.size;
            zzad(j6);
            while (i6 > 0) {
                int i7 = (int) (j6 - this.zzayq.f12668a);
                int min = Math.min(i6, this.zzaym - i7);
                zzos zzosVar = this.zzayq.f12671d;
                byteBuffer.put(zzosVar.data, zzosVar.zzbf(i7), min);
                j6 += min;
                i6 -= min;
                if (j6 == this.zzayq.f12669b) {
                    this.zzawq.zza(zzosVar);
                    this.zzayq = this.zzayq.a();
                }
            }
            zzad(this.zzayo.zzayl);
        }
        return -4;
    }

    public final void zzae(long j) {
        if (this.zzayv != j) {
            this.zzayv = j;
            this.zzayt = true;
        }
    }

    public final void zzar(int i) {
        this.zzayw = this.zzayn.a(i);
        long j = this.zzayw;
        C1157xl c1157xl = this.zzayq;
        if (j == c1157xl.f12668a) {
            zza(c1157xl);
            this.zzayq = new C1157xl(j, this.zzaym);
            this.zzayr = this.zzayq;
            return;
        }
        C1157xl c1157xl2 = c1157xl.f12672e;
        while (true) {
            C1157xl c1157xl3 = c1157xl2;
            C1157xl c1157xl4 = c1157xl;
            c1157xl = c1157xl3;
            if (j > c1157xl.f12668a) {
                c1157xl2 = c1157xl.f12672e;
            } else {
                zza(c1157xl);
                this.zzayr = c1157xl4;
                C1157xl c1157xl5 = this.zzayr;
                c1157xl5.f12672e = new C1157xl(c1157xl5.f12669b, this.zzaym);
                this.zzayx = (int) (j - this.zzayr.f12668a);
                return;
            }
        }
    }

    public final boolean zze(long j, boolean z) {
        long a2 = this.zzayn.a(j, z);
        if (a2 == -1) {
            return false;
        }
        zzad(a2);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzii
    public final void zzf(zzfs zzfsVar) {
        zzfs zzfsVar2;
        long j = this.zzayv;
        if (zzfsVar == null) {
            zzfsVar2 = null;
        } else {
            if (j != 0) {
                long j2 = zzfsVar.zzzy;
                if (j2 != Long.MAX_VALUE) {
                    zzfsVar2 = zzfsVar.zzj(j2 + j);
                }
            }
            zzfsVar2 = zzfsVar;
        }
        boolean a2 = this.zzayn.a(zzfsVar2);
        this.zzayu = zzfsVar;
        this.zzayt = false;
        zzlu zzluVar = this.zzayy;
        if (zzluVar == null || !a2) {
            return;
        }
        zzluVar.zzg(zzfsVar2);
    }

    public final long zzfc() {
        return this.zzayn.a();
    }

    public final int zzfk() {
        return this.zzayn.d();
    }

    public final int zzfl() {
        return this.zzayn.e();
    }

    public final boolean zzfm() {
        return this.zzayn.f();
    }

    public final zzfs zzfn() {
        return this.zzayn.g();
    }

    public final void zzfp() {
        long h2 = this.zzayn.h();
        if (h2 != -1) {
            zzad(h2);
        }
    }

    public final void zzh(boolean z) {
        int andSet = this.zzayp.getAndSet(z ? 0 : 2);
        zzfi();
        this.zzayn.c();
        if (andSet == 2) {
            this.zzays = null;
        }
    }

    private final void zza(long j, byte[] bArr, int i) {
        zzad(j);
        int i2 = 0;
        while (i2 < i) {
            int i3 = (int) (j - this.zzayq.f12668a);
            int min = Math.min(i - i2, this.zzaym - i3);
            zzos zzosVar = this.zzayq.f12671d;
            System.arraycopy(zzosVar.data, zzosVar.zzbf(i3), bArr, i2, min);
            j += min;
            i2 += min;
            if (j == this.zzayq.f12669b) {
                this.zzawq.zza(zzosVar);
                this.zzayq = this.zzayq.a();
            }
        }
    }

    public final void zza(zzlu zzluVar) {
        this.zzayy = zzluVar;
    }

    @Override // com.google.android.gms.internal.ads.zzii
    public final int zza(zzia zziaVar, int i, boolean z) throws IOException, InterruptedException {
        if (!zzfq()) {
            int zzv = zziaVar.zzv(i);
            if (zzv != -1) {
                return zzv;
            }
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
        try {
            int zzas = zzas(i);
            zzos zzosVar = this.zzayr.f12671d;
            int read = zziaVar.read(zzosVar.data, zzosVar.zzbf(this.zzayx), zzas);
            if (read == -1) {
                if (z) {
                    return -1;
                }
                throw new EOFException();
            }
            this.zzayx += read;
            this.zzayw += read;
            return read;
        } finally {
            zzfr();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzii
    public final void zza(zzpx zzpxVar, int i) {
        if (!zzfq()) {
            zzpxVar.zzbl(i);
            return;
        }
        while (i > 0) {
            int zzas = zzas(i);
            zzos zzosVar = this.zzayr.f12671d;
            zzpxVar.zze(zzosVar.data, zzosVar.zzbf(this.zzayx), zzas);
            this.zzayx += zzas;
            this.zzayw += zzas;
            i -= zzas;
        }
        zzfr();
    }

    @Override // com.google.android.gms.internal.ads.zzii
    public final void zza(long j, int i, int i2, int i3, zzij zzijVar) {
        if (this.zzayt) {
            zzf(this.zzayu);
        }
        if (!zzfq()) {
            this.zzayn.a(j);
            return;
        }
        try {
            this.zzayn.a(j + this.zzayv, i, (this.zzayw - i2) - i3, i2, zzijVar);
        } finally {
            zzfr();
        }
    }

    private final void zza(C1157xl c1157xl) {
        if (c1157xl.f12670c) {
            C1157xl c1157xl2 = this.zzayr;
            boolean z = c1157xl2.f12670c;
            zzos[] zzosVarArr = new zzos[(z ? 1 : 0) + (((int) (c1157xl2.f12668a - c1157xl.f12668a)) / this.zzaym)];
            for (int i = 0; i < zzosVarArr.length; i++) {
                zzosVarArr[i] = c1157xl.f12671d;
                c1157xl = c1157xl.a();
            }
            this.zzawq.zza(zzosVarArr);
        }
    }
}
