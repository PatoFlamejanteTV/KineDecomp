package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

@zzgr
/* loaded from: classes.dex */
public class zzay implements zzba {
    private final VersionInfoParcel zzpb;
    private final Object zzpd = new Object();
    private final WeakHashMap<zzhs, zzaz> zzqX = new WeakHashMap<>();
    private final ArrayList<zzaz> zzqY = new ArrayList<>();
    private final Context zzqZ;
    private final zzdz zzra;

    public zzay(Context context, VersionInfoParcel versionInfoParcel, zzdz zzdzVar) {
        this.zzqZ = context.getApplicationContext();
        this.zzpb = versionInfoParcel;
        this.zzra = zzdzVar;
    }

    public zzaz zza(AdSizeParcel adSizeParcel, zzhs zzhsVar) {
        return zza(adSizeParcel, zzhsVar, zzhsVar.zzBD.getView());
    }

    public zzaz zza(AdSizeParcel adSizeParcel, zzhs zzhsVar, View view) {
        zzaz zzazVar;
        synchronized (this.zzpd) {
            if (zzd(zzhsVar)) {
                zzazVar = this.zzqX.get(zzhsVar);
            } else {
                zzazVar = new zzaz(adSizeParcel, zzhsVar, this.zzpb, view, this.zzra);
                zzazVar.zza(this);
                this.zzqX.put(zzhsVar, zzazVar);
                this.zzqY.add(zzazVar);
            }
        }
        return zzazVar;
    }

    @Override // com.google.android.gms.internal.zzba
    public void zza(zzaz zzazVar) {
        synchronized (this.zzpd) {
            if (!zzazVar.zzcd()) {
                this.zzqY.remove(zzazVar);
                Iterator<Map.Entry<zzhs, zzaz>> it = this.zzqX.entrySet().iterator();
                while (it.hasNext()) {
                    if (it.next().getValue() == zzazVar) {
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean zzd(zzhs zzhsVar) {
        boolean z;
        synchronized (this.zzpd) {
            zzaz zzazVar = this.zzqX.get(zzhsVar);
            z = zzazVar != null && zzazVar.zzcd();
        }
        return z;
    }

    public void zze(zzhs zzhsVar) {
        synchronized (this.zzpd) {
            zzaz zzazVar = this.zzqX.get(zzhsVar);
            if (zzazVar != null) {
                zzazVar.zzcb();
            }
        }
    }

    public void zzf(zzhs zzhsVar) {
        synchronized (this.zzpd) {
            zzaz zzazVar = this.zzqX.get(zzhsVar);
            if (zzazVar != null) {
                zzazVar.stop();
            }
        }
    }

    public void zzg(zzhs zzhsVar) {
        synchronized (this.zzpd) {
            zzaz zzazVar = this.zzqX.get(zzhsVar);
            if (zzazVar != null) {
                zzazVar.pause();
            }
        }
    }

    public void zzh(zzhs zzhsVar) {
        synchronized (this.zzpd) {
            zzaz zzazVar = this.zzqX.get(zzhsVar);
            if (zzazVar != null) {
                zzazVar.resume();
            }
        }
    }
}
