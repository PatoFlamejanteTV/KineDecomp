package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes2.dex */
public final class Tj implements Fm {

    /* renamed from: a */
    private final Map<String, List<zzr<?>>> f11849a = new HashMap();

    /* renamed from: b */
    private final zzd f11850b;

    public Tj(zzd zzdVar) {
        this.f11850b = zzdVar;
    }

    public final synchronized boolean b(zzr<?> zzrVar) {
        String zzf = zzrVar.zzf();
        if (this.f11849a.containsKey(zzf)) {
            List<zzr<?>> list = this.f11849a.get(zzf);
            if (list == null) {
                list = new ArrayList<>();
            }
            zzrVar.zzb("waiting-for-response");
            list.add(zzrVar);
            this.f11849a.put(zzf, list);
            if (zzaf.DEBUG) {
                zzaf.d("Request for cacheKey=%s is in flight, putting on hold.", zzf);
            }
            return true;
        }
        this.f11849a.put(zzf, null);
        zzrVar.zza((Fm) this);
        if (zzaf.DEBUG) {
            zzaf.d("new request, sending to network %s", zzf);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.Fm
    public final void a(zzr<?> zzrVar, zzx<?> zzxVar) {
        List<zzr<?>> remove;
        zzaa zzaaVar;
        zzc zzcVar = zzxVar.zzbg;
        if (zzcVar != null && !zzcVar.zzb()) {
            String zzf = zzrVar.zzf();
            synchronized (this) {
                remove = this.f11849a.remove(zzf);
            }
            if (remove != null) {
                if (zzaf.DEBUG) {
                    zzaf.v("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), zzf);
                }
                for (zzr<?> zzrVar2 : remove) {
                    zzaaVar = this.f11850b.zzk;
                    zzaaVar.zzb(zzrVar2, zzxVar);
                }
                return;
            }
            return;
        }
        a(zzrVar);
    }

    @Override // com.google.android.gms.internal.ads.Fm
    public final synchronized void a(zzr<?> zzrVar) {
        BlockingQueue blockingQueue;
        String zzf = zzrVar.zzf();
        List<zzr<?>> remove = this.f11849a.remove(zzf);
        if (remove != null && !remove.isEmpty()) {
            if (zzaf.DEBUG) {
                zzaf.v("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), zzf);
            }
            zzr<?> remove2 = remove.remove(0);
            this.f11849a.put(zzf, remove);
            remove2.zza((Fm) this);
            try {
                blockingQueue = this.f11850b.zzi;
                blockingQueue.put(remove2);
            } catch (InterruptedException e2) {
                zzaf.e("Couldn't add request to queue. %s", e2.toString());
                Thread.currentThread().interrupt();
                this.f11850b.quit();
            }
        }
    }
}
