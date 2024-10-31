package com.google.android.gms.internal.gtm;

import android.support.v7.widget.ActivityChooserView;
import com.umeng.commonsdk.proguard.ap;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzun {
    private final byte[] buffer;
    private int zzawf;
    private int zzawl;
    private int zzawn;
    private final int zzbgu;
    private final int zzbgv;
    private int zzbgw;
    private int zzbgx;
    private zzqe zzbgy;
    private int zzawo = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int zzawg = 64;
    private int zzawh = 67108864;

    private zzun(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzbgu = i;
        int i3 = i2 + i;
        this.zzbgw = i3;
        this.zzbgv = i3;
        this.zzbgx = i;
    }

    private final void zzas(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.zzbgx;
            int i3 = i2 + i;
            int i4 = this.zzawo;
            if (i3 <= i4) {
                if (i <= this.zzbgw - i2) {
                    this.zzbgx = i2 + i;
                    return;
                }
                throw zzuv.zzsa();
            }
            zzas(i4 - i2);
            throw zzuv.zzsa();
        }
        throw zzuv.zzsb();
    }

    public static zzun zzj(byte[] bArr, int i, int i2) {
        return new zzun(bArr, 0, i2);
    }

    public static zzun zzk(byte[] bArr) {
        return zzj(bArr, 0, bArr.length);
    }

    private final void zzoe() {
        this.zzbgw += this.zzawl;
        int i = this.zzbgw;
        int i2 = this.zzawo;
        if (i > i2) {
            this.zzawl = i - i2;
            this.zzbgw = i - this.zzawl;
        } else {
            this.zzawl = 0;
        }
    }

    private final byte zzof() throws IOException {
        int i = this.zzbgx;
        if (i != this.zzbgw) {
            byte[] bArr = this.buffer;
            this.zzbgx = i + 1;
            return bArr[i];
        }
        throw zzuv.zzsa();
    }

    private final zzqe zzru() throws IOException {
        if (this.zzbgy == null) {
            this.zzbgy = zzqe.zzd(this.buffer, this.zzbgu, this.zzbgv);
        }
        int zznz = this.zzbgy.zznz();
        int i = this.zzbgx - this.zzbgu;
        if (zznz <= i) {
            this.zzbgy.zzas(i - zznz);
            this.zzbgy.zzap(this.zzawg - this.zzawf);
            return this.zzbgy;
        }
        throw new IOException(String.format("CodedInputStream read ahead of CodedInputByteBufferNano: %s > %s", Integer.valueOf(zznz), Integer.valueOf(i)));
    }

    public final int getPosition() {
        return this.zzbgx - this.zzbgu;
    }

    public final String readString() throws IOException {
        int zzoa = zzoa();
        if (zzoa >= 0) {
            int i = this.zzbgw;
            int i2 = this.zzbgx;
            if (zzoa <= i - i2) {
                String str = new String(this.buffer, i2, zzoa, zzuu.UTF_8);
                this.zzbgx += zzoa;
                return str;
            }
            throw zzuv.zzsa();
        }
        throw zzuv.zzsb();
    }

    public final void zza(zzuw zzuwVar, int i) throws IOException {
        int i2 = this.zzawf;
        if (i2 < this.zzawg) {
            this.zzawf = i2 + 1;
            zzuwVar.zza(this);
            zzan((i << 3) | 4);
            this.zzawf--;
            return;
        }
        throw zzuv.zzsd();
    }

    public final void zzan(int i) throws zzuv {
        if (this.zzawn != i) {
            throw new zzuv("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final boolean zzao(int i) throws IOException {
        int zzni;
        int i2 = i & 7;
        if (i2 == 0) {
            zzoa();
            return true;
        }
        if (i2 == 1) {
            zzof();
            zzof();
            zzof();
            zzof();
            zzof();
            zzof();
            zzof();
            zzof();
            return true;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                if (i2 == 4) {
                    return false;
                }
                if (i2 == 5) {
                    zzoc();
                    return true;
                }
                throw new zzuv("Protocol message tag had invalid wire type.");
            }
            do {
                zzni = zzni();
                if (zzni == 0) {
                    break;
                }
            } while (zzao(zzni));
            zzan(((i >>> 3) << 3) | 4);
            return true;
        }
        zzas(zzoa());
        return true;
    }

    public final int zzaq(int i) throws zzuv {
        if (i >= 0) {
            int i2 = i + this.zzbgx;
            int i3 = this.zzawo;
            if (i2 <= i3) {
                this.zzawo = i2;
                zzoe();
                return i3;
            }
            throw zzuv.zzsa();
        }
        throw zzuv.zzsb();
    }

    public final void zzar(int i) {
        this.zzawo = i;
        zzoe();
    }

    public final void zzbz(int i) {
        zzu(i, this.zzawn);
    }

    public final int zzni() throws IOException {
        if (this.zzbgx == this.zzbgw) {
            this.zzawn = 0;
            return 0;
        }
        this.zzawn = zzoa();
        int i = this.zzawn;
        if (i != 0) {
            return i;
        }
        throw new zzuv("Protocol message contained an invalid tag (zero).");
    }

    public final boolean zzno() throws IOException {
        return zzoa() != 0;
    }

    public final int zzoa() throws IOException {
        int i;
        byte zzof = zzof();
        if (zzof >= 0) {
            return zzof;
        }
        int i2 = zzof & Byte.MAX_VALUE;
        byte zzof2 = zzof();
        if (zzof2 >= 0) {
            i = zzof2 << 7;
        } else {
            i2 |= (zzof2 & Byte.MAX_VALUE) << 7;
            byte zzof3 = zzof();
            if (zzof3 >= 0) {
                i = zzof3 << ap.l;
            } else {
                i2 |= (zzof3 & Byte.MAX_VALUE) << 14;
                byte zzof4 = zzof();
                if (zzof4 < 0) {
                    int i3 = i2 | ((zzof4 & Byte.MAX_VALUE) << 21);
                    byte zzof5 = zzof();
                    int i4 = i3 | (zzof5 << 28);
                    if (zzof5 >= 0) {
                        return i4;
                    }
                    for (int i5 = 0; i5 < 5; i5++) {
                        if (zzof() >= 0) {
                            return i4;
                        }
                    }
                    throw zzuv.zzsc();
                }
                i = zzof4 << 21;
            }
        }
        return i2 | i;
    }

    public final long zzob() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((zzof() & 128) == 0) {
                return j;
            }
        }
        throw zzuv.zzsc();
    }

    public final int zzoc() throws IOException {
        return (zzof() & 255) | ((zzof() & 255) << 8) | ((zzof() & 255) << 16) | ((zzof() & 255) << 24);
    }

    public final int zzrv() {
        int i = this.zzawo;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - this.zzbgx;
    }

    public final byte[] zzt(int i, int i2) {
        if (i2 == 0) {
            return zzuz.zzbhw;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.zzbgu + i, bArr, 0, i2);
        return bArr;
    }

    public final void zzu(int i, int i2) {
        int i3 = this.zzbgx;
        int i4 = this.zzbgu;
        if (i > i3 - i4) {
            StringBuilder sb = new StringBuilder(50);
            sb.append("Position ");
            sb.append(i);
            sb.append(" is beyond current ");
            sb.append(i3 - i4);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i >= 0) {
            this.zzbgx = i4 + i;
            this.zzawn = i2;
        } else {
            StringBuilder sb2 = new StringBuilder(24);
            sb2.append("Bad position ");
            sb2.append(i);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public final void zza(zzuw zzuwVar) throws IOException {
        int zzoa = zzoa();
        if (this.zzawf < this.zzawg) {
            int zzaq = zzaq(zzoa);
            this.zzawf++;
            zzuwVar.zza(this);
            zzan(0);
            this.zzawf--;
            zzar(zzaq);
            return;
        }
        throw zzuv.zzsd();
    }

    public final <T extends zzrc<T, ?>> T zza(zzsu<T> zzsuVar) throws IOException {
        try {
            T t = (T) zzru().zza(zzsuVar, zzqp.zzor());
            zzao(this.zzawn);
            return t;
        } catch (zzrk e2) {
            throw new zzuv("", e2);
        }
    }
}
