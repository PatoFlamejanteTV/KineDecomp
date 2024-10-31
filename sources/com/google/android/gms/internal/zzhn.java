package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzhs;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Future;

@zzgr
/* loaded from: classes.dex */
public class zzhn extends zzhz implements zzhm {
    private final Context mContext;
    private final zzhs.zza zzDe;
    private final String zzGY;
    private final zzhg zzHs;
    private final ArrayList<Future> zzHp = new ArrayList<>();
    private final ArrayList<String> zzHq = new ArrayList<>();
    private final HashSet<String> zzHr = new HashSet<>();
    private final Object zzpd = new Object();

    public zzhn(Context context, String str, zzhs.zza zzaVar, zzhg zzhgVar) {
        this.mContext = context;
        this.zzGY = str;
        this.zzDe = zzaVar;
        this.zzHs = zzhgVar;
    }

    private void zzk(String str, String str2) {
        synchronized (this.zzpd) {
            zzhh zzau = this.zzHs.zzau(str);
            if (zzau == null || zzau.zzgd() == null || zzau.zzgc() == null) {
                return;
            }
            this.zzHp.add(new zzhi(this.mContext, str, this.zzGY, str2, this.zzDe, zzau, this).zzfu());
            this.zzHq.add(str);
        }
    }

    @Override // com.google.android.gms.internal.zzhz
    public void onStop() {
    }

    @Override // com.google.android.gms.internal.zzhm
    public void zzav(String str) {
        synchronized (this.zzpd) {
            this.zzHr.add(str);
        }
    }

    @Override // com.google.android.gms.internal.zzhm
    public void zzb(String str, int i) {
    }

    @Override // com.google.android.gms.internal.zzhz
    public void zzbn() {
        for (zzed zzedVar : this.zzDe.zzHx.zzyW) {
            String str = zzedVar.zzyT;
            Iterator<String> it = zzedVar.zzyO.iterator();
            while (it.hasNext()) {
                zzk(it.next(), str);
            }
        }
        for (int i = 0; i < this.zzHp.size(); i++) {
            try {
                this.zzHp.get(i).get();
                synchronized (this.zzpd) {
                    if (this.zzHr.contains(this.zzHq.get(i))) {
                        com.google.android.gms.ads.internal.util.client.zza.f654a.post(new di(this, new zzhs(this.zzDe.zzHC.c, null, this.zzDe.zzHD.d, -2, this.zzDe.zzHD.f, this.zzDe.zzHD.j, this.zzDe.zzHD.l, this.zzDe.zzHD.k, this.zzDe.zzHC.i, this.zzDe.zzHD.h, this.zzDe.zzHx.zzyW.get(i), null, this.zzHq.get(i), this.zzDe.zzHx, null, this.zzDe.zzHD.i, this.zzDe.zzqn, this.zzDe.zzHD.g, this.zzDe.zzHz, this.zzDe.zzHD.n, this.zzDe.zzHD.o, this.zzDe.zzHw, null)));
                        return;
                    }
                }
            } catch (InterruptedException e) {
            } catch (Exception e2) {
            }
        }
        com.google.android.gms.ads.internal.util.client.zza.f654a.post(new dj(this, new zzhs(this.zzDe.zzHC.c, null, this.zzDe.zzHD.d, 3, this.zzDe.zzHD.f, this.zzDe.zzHD.j, this.zzDe.zzHD.l, this.zzDe.zzHD.k, this.zzDe.zzHC.i, this.zzDe.zzHD.h, null, null, null, this.zzDe.zzHx, null, this.zzDe.zzHD.i, this.zzDe.zzqn, this.zzDe.zzHD.g, this.zzDe.zzHz, this.zzDe.zzHD.n, this.zzDe.zzHD.o, this.zzDe.zzHw, null)));
    }
}
