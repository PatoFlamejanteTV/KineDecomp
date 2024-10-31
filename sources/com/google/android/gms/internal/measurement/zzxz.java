package com.google.android.gms.internal.measurement;

import android.support.v7.widget.ActivityChooserView;
import com.umeng.commonsdk.proguard.ap;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzxz {
    private final byte[] buffer;
    private int zzbty;
    private int zzbue;
    private int zzbug;
    private final int zzcem;
    private final int zzcen;
    private int zzceo;
    private int zzcep;
    private zztq zzceq;
    private int zzbuh = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int zzbtz = 64;
    private int zzbua = 67108864;

    private zzxz(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzcem = i;
        int i3 = i2 + i;
        this.zzceo = i3;
        this.zzcen = i3;
        this.zzcep = i;
    }

    private final void zzau(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.zzcep;
            int i3 = i2 + i;
            int i4 = this.zzbuh;
            if (i3 <= i4) {
                if (i <= this.zzceo - i2) {
                    this.zzcep = i2 + i;
                    return;
                }
                throw zzyh.zzzd();
            }
            zzau(i4 - i2);
            throw zzyh.zzzd();
        }
        throw zzyh.zzze();
    }

    public static zzxz zzj(byte[] bArr, int i, int i2) {
        return new zzxz(bArr, 0, i2);
    }

    public static zzxz zzn(byte[] bArr) {
        return zzj(bArr, 0, bArr.length);
    }

    private final void zzvf() {
        this.zzceo += this.zzbue;
        int i = this.zzceo;
        int i2 = this.zzbuh;
        if (i > i2) {
            this.zzbue = i - i2;
            this.zzceo = i - this.zzbue;
        } else {
            this.zzbue = 0;
        }
    }

    private final byte zzvg() throws IOException {
        int i = this.zzcep;
        if (i != this.zzceo) {
            byte[] bArr = this.buffer;
            this.zzcep = i + 1;
            return bArr[i];
        }
        throw zzyh.zzzd();
    }

    private final zztq zzyx() throws IOException {
        if (this.zzceq == null) {
            this.zzceq = zztq.zzd(this.buffer, this.zzcem, this.zzcen);
        }
        int zzva = this.zzceq.zzva();
        int i = this.zzcep - this.zzcem;
        if (zzva <= i) {
            this.zzceq.zzau(i - zzva);
            this.zzceq.zzar(this.zzbtz - this.zzbty);
            return this.zzceq;
        }
        throw new IOException(String.format("CodedInputStream read ahead of CodedInputByteBufferNano: %s > %s", Integer.valueOf(zzva), Integer.valueOf(i)));
    }

    public final int getPosition() {
        return this.zzcep - this.zzcem;
    }

    public final String readString() throws IOException {
        int zzvb = zzvb();
        if (zzvb >= 0) {
            int i = this.zzceo;
            int i2 = this.zzcep;
            if (zzvb <= i - i2) {
                String str = new String(this.buffer, i2, zzvb, zzyg.UTF_8);
                this.zzcep += zzvb;
                return str;
            }
            throw zzyh.zzzd();
        }
        throw zzyh.zzze();
    }

    public final void zza(zzyi zzyiVar, int i) throws IOException {
        int i2 = this.zzbty;
        if (i2 < this.zzbtz) {
            this.zzbty = i2 + 1;
            zzyiVar.zza(this);
            zzap((i << 3) | 4);
            this.zzbty--;
            return;
        }
        throw zzyh.zzzg();
    }

    public final void zzap(int i) throws zzyh {
        if (this.zzbug != i) {
            throw new zzyh("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final boolean zzaq(int i) throws IOException {
        int zzuj;
        int i2 = i & 7;
        if (i2 == 0) {
            zzvb();
            return true;
        }
        if (i2 == 1) {
            zzve();
            return true;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                if (i2 == 4) {
                    return false;
                }
                if (i2 == 5) {
                    zzvd();
                    return true;
                }
                throw new zzyh("Protocol message tag had invalid wire type.");
            }
            do {
                zzuj = zzuj();
                if (zzuj == 0) {
                    break;
                }
            } while (zzaq(zzuj));
            zzap(((i >>> 3) << 3) | 4);
            return true;
        }
        zzau(zzvb());
        return true;
    }

    public final int zzas(int i) throws zzyh {
        if (i >= 0) {
            int i2 = i + this.zzcep;
            int i3 = this.zzbuh;
            if (i2 <= i3) {
                this.zzbuh = i2;
                zzvf();
                return i3;
            }
            throw zzyh.zzzd();
        }
        throw zzyh.zzze();
    }

    public final void zzat(int i) {
        this.zzbuh = i;
        zzvf();
    }

    public final void zzcb(int i) {
        zzt(i, this.zzbug);
    }

    public final byte[] zzs(int i, int i2) {
        if (i2 == 0) {
            return zzyl.zzcfo;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.zzcem + i, bArr, 0, i2);
        return bArr;
    }

    public final void zzt(int i, int i2) {
        int i3 = this.zzcep;
        int i4 = this.zzcem;
        if (i > i3 - i4) {
            StringBuilder sb = new StringBuilder(50);
            sb.append("Position ");
            sb.append(i);
            sb.append(" is beyond current ");
            sb.append(i3 - i4);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i >= 0) {
            this.zzcep = i4 + i;
            this.zzbug = i2;
        } else {
            StringBuilder sb2 = new StringBuilder(24);
            sb2.append("Bad position ");
            sb2.append(i);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public final int zzuj() throws IOException {
        if (this.zzcep == this.zzceo) {
            this.zzbug = 0;
            return 0;
        }
        this.zzbug = zzvb();
        int i = this.zzbug;
        if (i != 0) {
            return i;
        }
        throw new zzyh("Protocol message contained an invalid tag (zero).");
    }

    public final boolean zzup() throws IOException {
        return zzvb() != 0;
    }

    public final int zzvb() throws IOException {
        int i;
        byte zzvg = zzvg();
        if (zzvg >= 0) {
            return zzvg;
        }
        int i2 = zzvg & Byte.MAX_VALUE;
        byte zzvg2 = zzvg();
        if (zzvg2 >= 0) {
            i = zzvg2 << 7;
        } else {
            i2 |= (zzvg2 & Byte.MAX_VALUE) << 7;
            byte zzvg3 = zzvg();
            if (zzvg3 >= 0) {
                i = zzvg3 << ap.l;
            } else {
                i2 |= (zzvg3 & Byte.MAX_VALUE) << 14;
                byte zzvg4 = zzvg();
                if (zzvg4 < 0) {
                    int i3 = i2 | ((zzvg4 & Byte.MAX_VALUE) << 21);
                    byte zzvg5 = zzvg();
                    int i4 = i3 | (zzvg5 << 28);
                    if (zzvg5 >= 0) {
                        return i4;
                    }
                    for (int i5 = 0; i5 < 5; i5++) {
                        if (zzvg() >= 0) {
                            return i4;
                        }
                    }
                    throw zzyh.zzzf();
                }
                i = zzvg4 << 21;
            }
        }
        return i2 | i;
    }

    public final long zzvc() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((zzvg() & 128) == 0) {
                return j;
            }
        }
        throw zzyh.zzzf();
    }

    public final int zzvd() throws IOException {
        return (zzvg() & 255) | ((zzvg() & 255) << 8) | ((zzvg() & 255) << 16) | ((zzvg() & 255) << 24);
    }

    public final long zzve() throws IOException {
        return ((zzvg() & 255) << 8) | (zzvg() & 255) | ((zzvg() & 255) << 16) | ((zzvg() & 255) << 24) | ((zzvg() & 255) << 32) | ((zzvg() & 255) << 40) | ((zzvg() & 255) << 48) | ((zzvg() & 255) << 56);
    }

    public final int zzyy() {
        int i = this.zzbuh;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - this.zzcep;
    }

    public final void zza(zzyi zzyiVar) throws IOException {
        int zzvb = zzvb();
        if (this.zzbty < this.zzbtz) {
            int zzas = zzas(zzvb);
            this.zzbty++;
            zzyiVar.zza(this);
            zzap(0);
            this.zzbty--;
            zzat(zzas);
            return;
        }
        throw zzyh.zzzg();
    }

    public final <T extends zzuo<T, ?>> T zza(zzwf<T> zzwfVar) throws IOException {
        try {
            T t = (T) zzyx().zza(zzwfVar, zzub.zzvs());
            zzaq(this.zzbug);
            return t;
        } catch (zzuv e2) {
            throw new zzyh("", e2);
        }
    }
}
