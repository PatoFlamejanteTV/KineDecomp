package com.google.android.gms.internal.config;

import android.support.v7.widget.ActivityChooserView;
import com.umeng.commonsdk.proguard.ap;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzay {
    private final byte[] buffer;
    private final int zzbx;
    private int zzby;
    private int zzbz;
    private int zzcb;
    private int zzcd;
    private int zzcc = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int zzce = 64;
    private int zzcf = 67108864;
    private final int zzbw = 0;
    private int zzca = 0;

    private zzay(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        int i3 = i2 + 0;
        this.zzby = i3;
        this.zzbx = i3;
    }

    public static zzay zza(byte[] bArr, int i, int i2) {
        return new zzay(bArr, 0, i2);
    }

    private final void zzab() {
        this.zzby += this.zzbz;
        int i = this.zzby;
        int i2 = this.zzcc;
        if (i > i2) {
            this.zzbz = i - i2;
            this.zzby = i - this.zzbz;
        } else {
            this.zzbz = 0;
        }
    }

    private final byte zzac() throws IOException {
        int i = this.zzca;
        if (i != this.zzby) {
            byte[] bArr = this.buffer;
            this.zzca = i + 1;
            return bArr[i];
        }
        throw zzbg.zzag();
    }

    private final void zzg(int i) throws zzbg {
        if (this.zzcb != i) {
            throw new zzbg("Protocol message end-group tag did not match expected tag.");
        }
    }

    private final void zzi(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.zzca;
            int i3 = i2 + i;
            int i4 = this.zzcc;
            if (i3 <= i4) {
                if (i <= this.zzby - i2) {
                    this.zzca = i2 + i;
                    return;
                }
                throw zzbg.zzag();
            }
            zzi(i4 - i2);
            throw zzbg.zzag();
        }
        throw zzbg.zzah();
    }

    public final int getPosition() {
        return this.zzca - this.zzbw;
    }

    public final byte[] readBytes() throws IOException {
        int zzz = zzz();
        if (zzz < 0) {
            throw zzbg.zzah();
        }
        if (zzz == 0) {
            return zzbk.zzdd;
        }
        int i = this.zzby;
        int i2 = this.zzca;
        if (zzz <= i - i2) {
            byte[] bArr = new byte[zzz];
            System.arraycopy(this.buffer, i2, bArr, 0, zzz);
            this.zzca += zzz;
            return bArr;
        }
        throw zzbg.zzag();
    }

    public final String readString() throws IOException {
        int zzz = zzz();
        if (zzz >= 0) {
            int i = this.zzby;
            int i2 = this.zzca;
            if (zzz <= i - i2) {
                String str = new String(this.buffer, i2, zzz, zzbf.UTF_8);
                this.zzca += zzz;
                return str;
            }
            throw zzbg.zzag();
        }
        throw zzbg.zzah();
    }

    public final long zzaa() throws IOException {
        return ((zzac() & 255) << 8) | (zzac() & 255) | ((zzac() & 255) << 16) | ((zzac() & 255) << 24) | ((zzac() & 255) << 32) | ((zzac() & 255) << 40) | ((zzac() & 255) << 48) | ((zzac() & 255) << 56);
    }

    public final void zzb(int i, int i2) {
        int i3 = this.zzca;
        int i4 = this.zzbw;
        if (i > i3 - i4) {
            StringBuilder sb = new StringBuilder(50);
            sb.append("Position ");
            sb.append(i);
            sb.append(" is beyond current ");
            sb.append(i3 - i4);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i >= 0) {
            this.zzca = i4 + i;
            this.zzcb = i2;
        } else {
            StringBuilder sb2 = new StringBuilder(24);
            sb2.append("Bad position ");
            sb2.append(i);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public final boolean zzh(int i) throws IOException {
        int zzy;
        int i2 = i & 7;
        if (i2 == 0) {
            zzz();
            return true;
        }
        if (i2 == 1) {
            zzaa();
            return true;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                if (i2 == 4) {
                    return false;
                }
                if (i2 == 5) {
                    zzac();
                    zzac();
                    zzac();
                    zzac();
                    return true;
                }
                throw new zzbg("Protocol message tag had invalid wire type.");
            }
            do {
                zzy = zzy();
                if (zzy == 0) {
                    break;
                }
            } while (zzh(zzy));
            zzg(((i >>> 3) << 3) | 4);
            return true;
        }
        zzi(zzz());
        return true;
    }

    public final int zzy() throws IOException {
        if (this.zzca == this.zzby) {
            this.zzcb = 0;
            return 0;
        }
        this.zzcb = zzz();
        int i = this.zzcb;
        if (i != 0) {
            return i;
        }
        throw new zzbg("Protocol message contained an invalid tag (zero).");
    }

    public final int zzz() throws IOException {
        int i;
        byte zzac = zzac();
        if (zzac >= 0) {
            return zzac;
        }
        int i2 = zzac & Byte.MAX_VALUE;
        byte zzac2 = zzac();
        if (zzac2 >= 0) {
            i = zzac2 << 7;
        } else {
            i2 |= (zzac2 & Byte.MAX_VALUE) << 7;
            byte zzac3 = zzac();
            if (zzac3 >= 0) {
                i = zzac3 << ap.l;
            } else {
                i2 |= (zzac3 & Byte.MAX_VALUE) << 14;
                byte zzac4 = zzac();
                if (zzac4 < 0) {
                    int i3 = i2 | ((zzac4 & Byte.MAX_VALUE) << 21);
                    byte zzac5 = zzac();
                    int i4 = i3 | (zzac5 << 28);
                    if (zzac5 >= 0) {
                        return i4;
                    }
                    for (int i5 = 0; i5 < 5; i5++) {
                        if (zzac() >= 0) {
                            return i4;
                        }
                    }
                    throw new zzbg("CodedInputStream encountered a malformed varint.");
                }
                i = zzac4 << 21;
            }
        }
        return i2 | i;
    }

    public final void zza(zzbh zzbhVar) throws IOException {
        int zzz = zzz();
        if (this.zzcd >= this.zzce) {
            throw new zzbg("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        if (zzz >= 0) {
            int i = zzz + this.zzca;
            int i2 = this.zzcc;
            if (i <= i2) {
                this.zzcc = i;
                zzab();
                this.zzcd++;
                zzbhVar.zza(this);
                zzg(0);
                this.zzcd--;
                this.zzcc = i2;
                zzab();
                return;
            }
            throw zzbg.zzag();
        }
        throw zzbg.zzah();
    }

    public final byte[] zza(int i, int i2) {
        if (i2 == 0) {
            return zzbk.zzdd;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.zzbw + i, bArr, 0, i2);
        return bArr;
    }
}
