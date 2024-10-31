package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzsr {
    private final int zzbwy;
    private final int zzbwz;
    private final int zzbxa;
    private final zzte zzbxb;
    private final zztn zzbxc;
    private int zzbxj;
    private final Object mLock = new Object();
    private ArrayList<String> zzbxd = new ArrayList<>();
    private ArrayList<String> zzbxe = new ArrayList<>();
    private ArrayList<zztc> zzbxf = new ArrayList<>();
    private int zzbxg = 0;
    private int zzbxh = 0;
    private int zzbxi = 0;
    private String zzbxk = "";
    private String zzbxl = "";
    private String zzbxm = "";

    public zzsr(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.zzbwy = i;
        this.zzbwz = i2;
        this.zzbxa = i3;
        this.zzbxb = new zzte(i4);
        this.zzbxc = new zztn(i5, i6, i7);
    }

    private final void zzc(String str, boolean z, float f2, float f3, float f4, float f5) {
        if (str == null || str.length() < this.zzbxa) {
            return;
        }
        synchronized (this.mLock) {
            this.zzbxd.add(str);
            this.zzbxg += str.length();
            if (z) {
                this.zzbxe.add(str);
                this.zzbxf.add(new zztc(f2, f3, f4, f5, this.zzbxe.size() - 1));
            }
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzsr)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        String str = ((zzsr) obj).zzbxk;
        return str != null && str.equals(this.zzbxk);
    }

    public final int getScore() {
        return this.zzbxj;
    }

    public final int hashCode() {
        return this.zzbxk.hashCode();
    }

    public final String toString() {
        int i = this.zzbxh;
        int i2 = this.zzbxj;
        int i3 = this.zzbxg;
        String zza = zza(this.zzbxd, 100);
        String zza2 = zza(this.zzbxe, 100);
        String str = this.zzbxk;
        String str2 = this.zzbxl;
        String str3 = this.zzbxm;
        StringBuilder sb = new StringBuilder(String.valueOf(zza).length() + 165 + String.valueOf(zza2).length() + String.valueOf(str).length() + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append("ActivityContent fetchId: ");
        sb.append(i);
        sb.append(" score:");
        sb.append(i2);
        sb.append(" total_length:");
        sb.append(i3);
        sb.append("\n text: ");
        sb.append(zza);
        sb.append("\n viewableText");
        sb.append(zza2);
        sb.append("\n signture: ");
        sb.append(str);
        sb.append("\n viewableSignture: ");
        sb.append(str2);
        sb.append("\n viewableSignatureForVertical: ");
        sb.append(str3);
        return sb.toString();
    }

    public final void zza(String str, boolean z, float f2, float f3, float f4, float f5) {
        zzc(str, z, f2, f3, f4, f5);
        synchronized (this.mLock) {
            if (this.zzbxi < 0) {
                zzbbd.zzdn("ActivityContent: negative number of WebViews.");
            }
            zznp();
        }
    }

    public final void zzb(String str, boolean z, float f2, float f3, float f4, float f5) {
        zzc(str, z, f2, f3, f4, f5);
    }

    public final void zzbx(int i) {
        this.zzbxh = i;
    }

    public final boolean zzni() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzbxi == 0;
        }
        return z;
    }

    public final String zznj() {
        return this.zzbxk;
    }

    public final String zznk() {
        return this.zzbxl;
    }

    public final String zznl() {
        return this.zzbxm;
    }

    public final void zznm() {
        synchronized (this.mLock) {
            this.zzbxj -= 100;
        }
    }

    public final void zznn() {
        synchronized (this.mLock) {
            this.zzbxi--;
        }
    }

    public final void zzno() {
        synchronized (this.mLock) {
            this.zzbxi++;
        }
    }

    public final void zznp() {
        synchronized (this.mLock) {
            int i = (this.zzbxg * this.zzbwy) + (this.zzbxh * this.zzbwz);
            if (i > this.zzbxj) {
                this.zzbxj = i;
                if (!com.google.android.gms.ads.internal.zzbv.i().zzyq().zzzc()) {
                    this.zzbxk = this.zzbxb.zza(this.zzbxd);
                    this.zzbxl = this.zzbxb.zza(this.zzbxe);
                }
                if (!com.google.android.gms.ads.internal.zzbv.i().zzyq().zzze()) {
                    this.zzbxm = this.zzbxc.zza(this.zzbxe, this.zzbxf);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final int zznq() {
        return this.zzbxg;
    }

    private static String zza(ArrayList<String> arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            String str = arrayList.get(i2);
            i2++;
            sb.append(str);
            sb.append(' ');
            if (sb.length() > 100) {
                break;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        String sb2 = sb.toString();
        return sb2.length() < 100 ? sb2 : sb2.substring(0, 100);
    }
}
