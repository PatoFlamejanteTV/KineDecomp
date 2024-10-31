package com.google.android.gms.internal.firebase_abt;

import android.support.v7.widget.ActivityChooserView;
import com.umeng.commonsdk.proguard.ap;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zza {
    private final byte[] buffer;
    private final int zzh;
    private final int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private int zzo;
    private int zzn = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int zzp = 64;
    private int zzq = 67108864;

    private zza(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzh = i;
        int i3 = i2 + i;
        this.zzj = i3;
        this.zzi = i3;
        this.zzl = i;
    }

    public static zza zza(byte[] bArr, int i, int i2) {
        return new zza(bArr, 0, i2);
    }

    private final void zzc(int i) throws IOException {
        if (i < 0) {
            throw zzi.zzm();
        }
        int i2 = this.zzl;
        int i3 = i2 + i;
        int i4 = this.zzn;
        if (i3 > i4) {
            zzc(i4 - i2);
            throw zzi.zzl();
        }
        if (i > this.zzj - i2) {
            throw zzi.zzl();
        }
        this.zzl = i2 + i;
    }

    private final void zzh() {
        this.zzj += this.zzk;
        int i = this.zzj;
        int i2 = this.zzn;
        if (i <= i2) {
            this.zzk = 0;
        } else {
            this.zzk = i - i2;
            this.zzj = i - this.zzk;
        }
    }

    private final byte zzi() throws IOException {
        int i = this.zzl;
        if (i == this.zzj) {
            throw zzi.zzl();
        }
        byte[] bArr = this.buffer;
        this.zzl = i + 1;
        return bArr[i];
    }

    public final int getPosition() {
        return this.zzl - this.zzh;
    }

    public final String readString() throws IOException {
        int zzg = zzg();
        if (zzg < 0) {
            throw zzi.zzm();
        }
        int i = this.zzj;
        int i2 = this.zzl;
        if (zzg > i - i2) {
            throw zzi.zzl();
        }
        String str = new String(this.buffer, i2, zzg, zzh.UTF_8);
        this.zzl += zzg;
        return str;
    }

    public final void zza(int i) throws zzi {
        if (this.zzm != i) {
            throw new zzi("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final void zza(zzj zzjVar) throws IOException {
        int zzg = zzg();
        if (this.zzo >= this.zzp) {
            throw new zzi("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        if (zzg < 0) {
            throw zzi.zzm();
        }
        int i = zzg + this.zzl;
        int i2 = this.zzn;
        if (i > i2) {
            throw zzi.zzl();
        }
        this.zzn = i;
        zzh();
        this.zzo++;
        zzjVar.zza(this);
        zza(0);
        this.zzo--;
        this.zzn = i2;
        zzh();
    }

    public final byte[] zza(int i, int i2) {
        if (i2 == 0) {
            return zzm.zzao;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.zzh + i, bArr, 0, i2);
        return bArr;
    }

    public final void zzb(int i, int i2) {
        int i3 = this.zzl;
        int i4 = this.zzh;
        if (i > i3 - i4) {
            StringBuilder sb = new StringBuilder(50);
            sb.append("Position ");
            sb.append(i);
            sb.append(" is beyond current ");
            sb.append(i3 - i4);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i >= 0) {
            this.zzl = i4 + i;
            this.zzm = 106;
        } else {
            StringBuilder sb2 = new StringBuilder(24);
            sb2.append("Bad position ");
            sb2.append(i);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public final boolean zzb(int i) throws IOException {
        int zzd;
        int i2 = i & 7;
        if (i2 == 0) {
            zzg();
            return true;
        }
        if (i2 == 1) {
            zzi();
            zzi();
            zzi();
            zzi();
            zzi();
            zzi();
            zzi();
            zzi();
            return true;
        }
        if (i2 == 2) {
            zzc(zzg());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw new zzi("Protocol message tag had invalid wire type.");
            }
            zzi();
            zzi();
            zzi();
            zzi();
            return true;
        }
        do {
            zzd = zzd();
            if (zzd == 0) {
                break;
            }
        } while (zzb(zzd));
        zza(((i >>> 3) << 3) | 4);
        return true;
    }

    public final int zzd() throws IOException {
        if (this.zzl == this.zzj) {
            this.zzm = 0;
            return 0;
        }
        this.zzm = zzg();
        int i = this.zzm;
        if (i != 0) {
            return i;
        }
        throw new zzi("Protocol message contained an invalid tag (zero).");
    }

    public final long zze() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((zzi() & 128) == 0) {
                return j;
            }
        }
        throw zzi.zzn();
    }

    public final int zzf() throws IOException {
        return zzg();
    }

    public final int zzg() throws IOException {
        int i;
        byte zzi = zzi();
        if (zzi >= 0) {
            return zzi;
        }
        int i2 = zzi & Byte.MAX_VALUE;
        byte zzi2 = zzi();
        if (zzi2 >= 0) {
            i = zzi2 << 7;
        } else {
            i2 |= (zzi2 & Byte.MAX_VALUE) << 7;
            byte zzi3 = zzi();
            if (zzi3 >= 0) {
                i = zzi3 << ap.l;
            } else {
                i2 |= (zzi3 & Byte.MAX_VALUE) << 14;
                byte zzi4 = zzi();
                if (zzi4 < 0) {
                    int i3 = i2 | ((zzi4 & Byte.MAX_VALUE) << 21);
                    byte zzi5 = zzi();
                    int i4 = i3 | (zzi5 << 28);
                    if (zzi5 >= 0) {
                        return i4;
                    }
                    for (int i5 = 0; i5 < 5; i5++) {
                        if (zzi() >= 0) {
                            return i4;
                        }
                    }
                    throw zzi.zzn();
                }
                i = zzi4 << 21;
            }
        }
        return i2 | i;
    }
}
