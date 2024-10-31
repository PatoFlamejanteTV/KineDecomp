package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@zzark
/* loaded from: classes2.dex */
public final class zzaft implements zzm {
    private final Context mContext;
    private volatile zzafk zzdgm;

    public zzaft(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disconnect() {
        if (this.zzdgm == null) {
            return;
        }
        this.zzdgm.disconnect();
        Binder.flushPendingCommands();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzm
    public final zzp zzc(zzr<?> zzrVar) throws zzae {
        zzafl zzh = zzafl.zzh(zzrVar);
        long c2 = com.google.android.gms.ads.internal.zzbv.l().c();
        try {
            zzbcl zzbclVar = new zzbcl();
            this.zzdgm = new zzafk(this.mContext, com.google.android.gms.ads.internal.zzbv.u().zzaak(), new F(this, zzbclVar), new G(this, zzbclVar));
            this.zzdgm.checkAvailabilityAndConnect();
            zzbcb zza = zzbbq.zza(zzbbq.zza(zzbclVar, new C(this, zzh), zzayf.zzeky), ((Integer) zzwu.zzpz().zzd(zzaan.zzcwa)).intValue(), TimeUnit.MILLISECONDS, zzayf.zzela);
            zza.zza(new E(this), zzayf.zzeky);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zza.get();
            long c3 = com.google.android.gms.ads.internal.zzbv.l().c() - c2;
            StringBuilder sb = new StringBuilder(52);
            sb.append("Http assets remote cache took ");
            sb.append(c3);
            sb.append("ms");
            zzaxz.v(sb.toString());
            zzafn zzafnVar = (zzafn) new zzasy(parcelFileDescriptor).zza(zzafn.CREATOR);
            if (zzafnVar == null) {
                return null;
            }
            if (!zzafnVar.zzdgk) {
                if (zzafnVar.zzdgi.length != zzafnVar.zzdgj.length) {
                    return null;
                }
                HashMap hashMap = new HashMap();
                int i = 0;
                while (true) {
                    String[] strArr = zzafnVar.zzdgi;
                    if (i < strArr.length) {
                        hashMap.put(strArr[i], zzafnVar.zzdgj[i]);
                        i++;
                    } else {
                        return new zzp(zzafnVar.statusCode, zzafnVar.data, hashMap, zzafnVar.zzac, zzafnVar.zzad);
                    }
                }
            } else {
                throw new zzae(zzafnVar.zzdgl);
            }
        } catch (InterruptedException | ExecutionException unused) {
            long c4 = com.google.android.gms.ads.internal.zzbv.l().c() - c2;
            StringBuilder sb2 = new StringBuilder(52);
            sb2.append("Http assets remote cache took ");
            sb2.append(c4);
            sb2.append("ms");
            zzaxz.v(sb2.toString());
            return null;
        } catch (Throwable th) {
            long c5 = com.google.android.gms.ads.internal.zzbv.l().c() - c2;
            StringBuilder sb3 = new StringBuilder(52);
            sb3.append("Http assets remote cache took ");
            sb3.append(c5);
            sb3.append("ms");
            zzaxz.v(sb3.toString());
            throw th;
        }
    }
}
