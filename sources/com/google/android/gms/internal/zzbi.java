package com.google.android.gms.internal;

import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzgr
/* loaded from: classes.dex */
public class zzbi {
    private int zzrX;
    private final Object zzpd = new Object();
    private List<zzbh> zzrY = new LinkedList();

    public boolean zza(zzbh zzbhVar) {
        boolean z;
        synchronized (this.zzpd) {
            z = this.zzrY.contains(zzbhVar);
        }
        return z;
    }

    public boolean zzb(zzbh zzbhVar) {
        boolean z;
        synchronized (this.zzpd) {
            Iterator<zzbh> it = this.zzrY.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                zzbh next = it.next();
                if (zzbhVar != next && next.zzcm().equals(zzbhVar.zzcm())) {
                    it.remove();
                    z = true;
                    break;
                }
            }
        }
        return z;
    }

    public void zzc(zzbh zzbhVar) {
        synchronized (this.zzpd) {
            if (this.zzrY.size() >= 10) {
                com.google.android.gms.ads.internal.util.client.zzb.a("Queue is full, current size = " + this.zzrY.size());
                this.zzrY.remove(0);
            }
            int i = this.zzrX;
            this.zzrX = i + 1;
            zzbhVar.zzg(i);
            this.zzrY.add(zzbhVar);
        }
    }

    public zzbh zzcs() {
        int i;
        zzbh zzbhVar;
        zzbh zzbhVar2 = null;
        synchronized (this.zzpd) {
            if (this.zzrY.size() == 0) {
                com.google.android.gms.ads.internal.util.client.zzb.a("Queue empty");
                return null;
            }
            if (this.zzrY.size() < 2) {
                zzbh zzbhVar3 = this.zzrY.get(0);
                zzbhVar3.zzcn();
                return zzbhVar3;
            }
            int i2 = NexEditorDeviceProfile.UNKNOWN;
            for (zzbh zzbhVar4 : this.zzrY) {
                int score = zzbhVar4.getScore();
                if (score > i2) {
                    zzbhVar = zzbhVar4;
                    i = score;
                } else {
                    i = i2;
                    zzbhVar = zzbhVar2;
                }
                i2 = i;
                zzbhVar2 = zzbhVar;
            }
            this.zzrY.remove(zzbhVar2);
            return zzbhVar2;
        }
    }
}
