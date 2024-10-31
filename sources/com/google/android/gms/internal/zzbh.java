package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;

@zzgr
/* loaded from: classes.dex */
public class zzbh {
    private final int zzrN;
    private final int zzrO;
    private final int zzrP;
    private final zzbm zzrQ;
    private int zzrV;
    private final Object zzpd = new Object();
    private ArrayList<String> zzrR = new ArrayList<>();
    private int zzrS = 0;
    private int zzrT = 0;
    private int zzrU = 0;
    private String zzrW = "";

    public zzbh(int i, int i2, int i3, int i4) {
        this.zzrN = i;
        this.zzrO = i2;
        this.zzrP = i3;
        this.zzrQ = new zzbm(i4);
    }

    private String zza(ArrayList<String> arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
            stringBuffer.append(' ');
            if (stringBuffer.length() > i) {
                break;
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() >= i ? stringBuffer2.substring(0, i) : stringBuffer2;
    }

    private void zzx(String str) {
        if (str == null || str.length() < this.zzrP) {
            return;
        }
        synchronized (this.zzpd) {
            this.zzrR.add(str);
            this.zzrS += str.length();
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzbh)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        zzbh zzbhVar = (zzbh) obj;
        return zzbhVar.zzcm() != null && zzbhVar.zzcm().equals(zzcm());
    }

    public int getScore() {
        return this.zzrV;
    }

    public int hashCode() {
        return zzcm().hashCode();
    }

    public String toString() {
        return "ActivityContent fetchId: " + this.zzrT + " score:" + this.zzrV + " total_length:" + this.zzrS + "\n text: " + zza(this.zzrR, 200) + "\n signture: " + this.zzrW;
    }

    int zza(int i, int i2) {
        return (this.zzrN * i) + (this.zzrO * i2);
    }

    public boolean zzcl() {
        boolean z;
        synchronized (this.zzpd) {
            z = this.zzrU == 0;
        }
        return z;
    }

    public String zzcm() {
        return this.zzrW;
    }

    public void zzcn() {
        synchronized (this.zzpd) {
            this.zzrV -= 100;
        }
    }

    public void zzco() {
        synchronized (this.zzpd) {
            this.zzrU--;
        }
    }

    public void zzcp() {
        synchronized (this.zzpd) {
            this.zzrU++;
        }
    }

    public void zzcq() {
        synchronized (this.zzpd) {
            int zza = zza(this.zzrS, this.zzrT);
            if (zza > this.zzrV) {
                this.zzrV = zza;
                this.zzrW = this.zzrQ.zza(this.zzrR);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int zzcr() {
        return this.zzrS;
    }

    public void zzg(int i) {
        this.zzrT = i;
    }

    public void zzv(String str) {
        zzx(str);
        synchronized (this.zzpd) {
            if (this.zzrU < 0) {
                com.google.android.gms.ads.internal.util.client.zzb.a("ActivityContent: negative number of WebViews.");
            }
            zzcq();
        }
    }

    public void zzw(String str) {
        zzx(str);
    }
}
