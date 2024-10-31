package com.google.android.gms.internal.ads;

import android.support.v7.widget.ActivityChooserView;
import com.umeng.commonsdk.proguard.ap;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzbuq {
    private final byte[] buffer;
    private final int zzack;
    private int zzflq;
    private int zzflw;
    private int zzfly;
    private final int zzfwe;
    private int zzfwf;
    private int zzfwg;
    private zzbqf zzfwh;
    private int zzflz = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int zzflr = 64;
    private int zzfls = 67108864;

    private zzbuq(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzfwe = i;
        int i3 = i2 + i;
        this.zzfwf = i3;
        this.zzack = i3;
        this.zzfwg = i;
    }

    private final void zzalq() {
        this.zzfwf += this.zzflw;
        int i = this.zzfwf;
        int i2 = this.zzflz;
        if (i > i2) {
            this.zzflw = i - i2;
            this.zzfwf = i - this.zzflw;
        } else {
            this.zzflw = 0;
        }
    }

    private final byte zzalr() throws IOException {
        int i = this.zzfwg;
        if (i != this.zzfwf) {
            byte[] bArr = this.buffer;
            this.zzfwg = i + 1;
            return bArr[i];
        }
        throw zzbuy.zzapo();
    }

    private final void zzet(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.zzfwg;
            int i3 = i2 + i;
            int i4 = this.zzflz;
            if (i3 <= i4) {
                if (i <= this.zzfwf - i2) {
                    this.zzfwg = i2 + i;
                    return;
                }
                throw zzbuy.zzapo();
            }
            zzet(i4 - i2);
            throw zzbuy.zzapo();
        }
        throw zzbuy.zzapp();
    }

    public static zzbuq zzq(byte[] bArr, int i, int i2) {
        return new zzbuq(bArr, 0, i2);
    }

    public final int getPosition() {
        return this.zzfwg - this.zzfwe;
    }

    public final byte[] readBytes() throws IOException {
        int zzalm = zzalm();
        if (zzalm < 0) {
            throw zzbuy.zzapp();
        }
        if (zzalm == 0) {
            return zzbvc.zzfxe;
        }
        int i = this.zzfwf;
        int i2 = this.zzfwg;
        if (zzalm <= i - i2) {
            byte[] bArr = new byte[zzalm];
            System.arraycopy(this.buffer, i2, bArr, 0, zzalm);
            this.zzfwg += zzalm;
            return bArr;
        }
        throw zzbuy.zzapo();
    }

    public final String readString() throws IOException {
        int zzalm = zzalm();
        if (zzalm >= 0) {
            int i = this.zzfwf;
            int i2 = this.zzfwg;
            if (zzalm <= i - i2) {
                String str = new String(this.buffer, i2, zzalm, zzbux.UTF_8);
                this.zzfwg += zzalm;
                return str;
            }
            throw zzbuy.zzapo();
        }
        throw zzbuy.zzapp();
    }

    public final void zza(zzbuz zzbuzVar) throws IOException {
        int zzalm = zzalm();
        if (this.zzflq < this.zzflr) {
            int zzer = zzer(zzalm);
            this.zzflq++;
            zzbuzVar.zza(this);
            zzeo(0);
            this.zzflq--;
            zzes(zzer);
            return;
        }
        throw new zzbuy("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    public final int zzaku() throws IOException {
        if (this.zzfwg == this.zzfwf) {
            this.zzfly = 0;
            return 0;
        }
        this.zzfly = zzalm();
        int i = this.zzfly;
        if (i != 0) {
            return i;
        }
        throw new zzbuy("Protocol message contained an invalid tag (zero).");
    }

    public final long zzakw() throws IOException {
        return zzaln();
    }

    public final int zzakx() throws IOException {
        return zzalm();
    }

    public final boolean zzala() throws IOException {
        return zzalm() != 0;
    }

    public final int zzalm() throws IOException {
        int i;
        byte zzalr = zzalr();
        if (zzalr >= 0) {
            return zzalr;
        }
        int i2 = zzalr & Byte.MAX_VALUE;
        byte zzalr2 = zzalr();
        if (zzalr2 >= 0) {
            i = zzalr2 << 7;
        } else {
            i2 |= (zzalr2 & Byte.MAX_VALUE) << 7;
            byte zzalr3 = zzalr();
            if (zzalr3 >= 0) {
                i = zzalr3 << ap.l;
            } else {
                i2 |= (zzalr3 & Byte.MAX_VALUE) << 14;
                byte zzalr4 = zzalr();
                if (zzalr4 < 0) {
                    int i3 = i2 | ((zzalr4 & Byte.MAX_VALUE) << 21);
                    byte zzalr5 = zzalr();
                    int i4 = i3 | (zzalr5 << 28);
                    if (zzalr5 >= 0) {
                        return i4;
                    }
                    for (int i5 = 0; i5 < 5; i5++) {
                        if (zzalr() >= 0) {
                            return i4;
                        }
                    }
                    throw zzbuy.zzapq();
                }
                i = zzalr4 << 21;
            }
        }
        return i2 | i;
    }

    public final long zzaln() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((zzalr() & 128) == 0) {
                return j;
            }
        }
        throw zzbuy.zzapq();
    }

    public final byte[] zzam(int i, int i2) {
        if (i2 == 0) {
            return zzbvc.zzfxe;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.zzfwe + i, bArr, 0, i2);
        return bArr;
    }

    public final void zzan(int i, int i2) {
        int i3 = this.zzfwg;
        int i4 = this.zzfwe;
        if (i > i3 - i4) {
            StringBuilder sb = new StringBuilder(50);
            sb.append("Position ");
            sb.append(i);
            sb.append(" is beyond current ");
            sb.append(i3 - i4);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i >= 0) {
            this.zzfwg = i4 + i;
            this.zzfly = i2;
        } else {
            StringBuilder sb2 = new StringBuilder(24);
            sb2.append("Bad position ");
            sb2.append(i);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public final int zzapl() {
        int i = this.zzflz;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - this.zzfwg;
    }

    public final void zzeo(int i) throws zzbuy {
        if (this.zzfly != i) {
            throw new zzbuy("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final boolean zzep(int i) throws IOException {
        int zzaku;
        int i2 = i & 7;
        if (i2 == 0) {
            zzalm();
            return true;
        }
        if (i2 == 1) {
            zzalr();
            zzalr();
            zzalr();
            zzalr();
            zzalr();
            zzalr();
            zzalr();
            zzalr();
            return true;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                if (i2 == 4) {
                    return false;
                }
                if (i2 == 5) {
                    zzalr();
                    zzalr();
                    zzalr();
                    zzalr();
                    return true;
                }
                throw new zzbuy("Protocol message tag had invalid wire type.");
            }
            do {
                zzaku = zzaku();
                if (zzaku == 0) {
                    break;
                }
            } while (zzep(zzaku));
            zzeo(((i >>> 3) << 3) | 4);
            return true;
        }
        zzet(zzalm());
        return true;
    }

    public final int zzer(int i) throws zzbuy {
        if (i >= 0) {
            int i2 = i + this.zzfwg;
            int i3 = this.zzflz;
            if (i2 <= i3) {
                this.zzflz = i2;
                zzalq();
                return i3;
            }
            throw zzbuy.zzapo();
        }
        throw zzbuy.zzapp();
    }

    public final void zzes(int i) {
        this.zzflz = i;
        zzalq();
    }

    public final void zzgc(int i) {
        zzan(i, this.zzfly);
    }

    public final <T extends zzbrd<T, ?>> T zza(zzbsw<T> zzbswVar) throws IOException {
        try {
            if (this.zzfwh == null) {
                this.zzfwh = zzbqf.zzk(this.buffer, this.zzfwe, this.zzack);
            }
            int zzall = this.zzfwh.zzall();
            int i = this.zzfwg - this.zzfwe;
            if (zzall <= i) {
                this.zzfwh.zzet(i - zzall);
                this.zzfwh.zzeq(this.zzflr - this.zzflq);
                T t = (T) this.zzfwh.zza(zzbswVar, zzbqq.zzame());
                zzep(this.zzfly);
                return t;
            }
            throw new IOException(String.format("CodedInputStream read ahead of CodedInputByteBufferNano: %s > %s", Integer.valueOf(zzall), Integer.valueOf(i)));
        } catch (zzbrl e2) {
            throw new zzbuy("", e2);
        }
    }
}
