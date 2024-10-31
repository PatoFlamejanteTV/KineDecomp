package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzrf implements zzrn {
    private final zzbbi zzbob;
    private final Context zzbup;
    private final zzait zzbuq;
    private final Object mLock = new Object();
    private final WeakHashMap<zzaxf, zzrg> zzbun = new WeakHashMap<>();
    private final ArrayList<zzrg> zzbuo = new ArrayList<>();

    public zzrf(Context context, zzbbi zzbbiVar) {
        this.zzbup = context.getApplicationContext();
        this.zzbob = zzbbiVar;
        this.zzbuq = new zzait(context.getApplicationContext(), zzbbiVar, (String) zzwu.zzpz().zzd(zzaan.zzcnw));
    }

    private final boolean zzg(zzaxf zzaxfVar) {
        boolean z;
        synchronized (this.mLock) {
            zzrg zzrgVar = this.zzbun.get(zzaxfVar);
            z = zzrgVar != null && zzrgVar.zzmz();
        }
        return z;
    }

    public final void zza(zzwf zzwfVar, zzaxf zzaxfVar) {
        zza(zzwfVar, zzaxfVar, zzaxfVar.zzdrv.getView());
    }

    public final void zzh(zzaxf zzaxfVar) {
        synchronized (this.mLock) {
            zzrg zzrgVar = this.zzbun.get(zzaxfVar);
            if (zzrgVar != null) {
                zzrgVar.zzmx();
            }
        }
    }

    public final void zzi(zzaxf zzaxfVar) {
        synchronized (this.mLock) {
            zzrg zzrgVar = this.zzbun.get(zzaxfVar);
            if (zzrgVar != null) {
                zzrgVar.stop();
            }
        }
    }

    public final void zzj(zzaxf zzaxfVar) {
        synchronized (this.mLock) {
            zzrg zzrgVar = this.zzbun.get(zzaxfVar);
            if (zzrgVar != null) {
                zzrgVar.pause();
            }
        }
    }

    public final void zzk(zzaxf zzaxfVar) {
        synchronized (this.mLock) {
            zzrg zzrgVar = this.zzbun.get(zzaxfVar);
            if (zzrgVar != null) {
                zzrgVar.resume();
            }
        }
    }

    public final void zza(zzwf zzwfVar, zzaxf zzaxfVar, View view) {
        zza(zzwfVar, zzaxfVar, new zzrm(view, zzaxfVar), (zzbgg) null);
    }

    public final void zza(zzwf zzwfVar, zzaxf zzaxfVar, View view, zzbgg zzbggVar) {
        zza(zzwfVar, zzaxfVar, new zzrm(view, zzaxfVar), zzbggVar);
    }

    public final void zza(zzwf zzwfVar, zzaxf zzaxfVar, zzsq zzsqVar, zzbgg zzbggVar) {
        zzrg zzrgVar;
        synchronized (this.mLock) {
            if (zzg(zzaxfVar)) {
                zzrgVar = this.zzbun.get(zzaxfVar);
            } else {
                zzrg zzrgVar2 = new zzrg(this.zzbup, zzwfVar, zzaxfVar, this.zzbob, zzsqVar);
                zzrgVar2.zza(this);
                this.zzbun.put(zzaxfVar, zzrgVar2);
                this.zzbuo.add(zzrgVar2);
                zzrgVar = zzrgVar2;
            }
            if (zzbggVar != null) {
                zzrgVar.zza(new zzro(zzrgVar, zzbggVar));
            } else {
                zzrgVar.zza(new zzrs(zzrgVar, this.zzbuq, this.zzbup));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzrn
    public final void zza(zzrg zzrgVar) {
        synchronized (this.mLock) {
            if (!zzrgVar.zzmz()) {
                this.zzbuo.remove(zzrgVar);
                Iterator<Map.Entry<zzaxf, zzrg>> it = this.zzbun.entrySet().iterator();
                while (it.hasNext()) {
                    if (it.next().getValue() == zzrgVar) {
                        it.remove();
                    }
                }
            }
        }
    }
}
