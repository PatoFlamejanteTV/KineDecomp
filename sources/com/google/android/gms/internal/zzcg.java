package com.google.android.gms.internal;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class zzcg {
    boolean zzvA;
    private String zzvT;
    private zzce zzvU;
    private zzcg zzvV;
    private final List<zzce> zzvR = new LinkedList();
    private final Map<String, String> zzvS = new LinkedHashMap();
    private final Object zzpd = new Object();

    public zzcg(boolean z, String str, String str2) {
        this.zzvA = z;
        this.zzvS.put(NativeProtocol.WEB_DIALOG_ACTION, str);
        this.zzvS.put("ad_format", str2);
    }

    public void zzT(String str) {
        if (this.zzvA) {
            synchronized (this.zzpd) {
                this.zzvT = str;
            }
        }
    }

    public boolean zza(zzce zzceVar, long j, String... strArr) {
        synchronized (this.zzpd) {
            for (String str : strArr) {
                this.zzvR.add(new zzce(j, str, zzceVar));
            }
        }
        return true;
    }

    public boolean zza(zzce zzceVar, String... strArr) {
        if (!this.zzvA || zzceVar == null) {
            return false;
        }
        return zza(zzceVar, com.google.android.gms.ads.internal.zzp.i().elapsedRealtime(), strArr);
    }

    public zzce zzb(long j) {
        if (this.zzvA) {
            return new zzce(j, null, null);
        }
        return null;
    }

    public void zzc(zzcg zzcgVar) {
        synchronized (this.zzpd) {
            this.zzvV = zzcgVar;
        }
    }

    public zzce zzdn() {
        return zzb(com.google.android.gms.ads.internal.zzp.i().elapsedRealtime());
    }

    public void zzdo() {
        synchronized (this.zzpd) {
            this.zzvU = zzdn();
        }
    }

    public String zzdp() {
        String sb;
        StringBuilder sb2 = new StringBuilder();
        synchronized (this.zzpd) {
            for (zzce zzceVar : this.zzvR) {
                long time = zzceVar.getTime();
                String zzdk = zzceVar.zzdk();
                zzce zzdl = zzceVar.zzdl();
                if (zzdl != null && time > 0) {
                    sb2.append(zzdk).append('.').append(time - zzdl.getTime()).append(',');
                }
            }
            this.zzvR.clear();
            if (!TextUtils.isEmpty(this.zzvT)) {
                sb2.append(this.zzvT);
            } else if (sb2.length() > 0) {
                sb2.setLength(sb2.length() - 1);
            }
            sb = sb2.toString();
        }
        return sb;
    }

    public zzce zzdq() {
        zzce zzceVar;
        synchronized (this.zzpd) {
            zzceVar = this.zzvU;
        }
        return zzceVar;
    }

    public void zze(String str, String str2) {
        zzca zzgo;
        if (!this.zzvA || TextUtils.isEmpty(str2) || (zzgo = com.google.android.gms.ads.internal.zzp.h().zzgo()) == null) {
            return;
        }
        synchronized (this.zzpd) {
            zzgo.zzR(str).zza(this.zzvS, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> zzn() {
        Map<String, String> zza;
        synchronized (this.zzpd) {
            zzca zzgo = com.google.android.gms.ads.internal.zzp.h().zzgo();
            zza = (zzgo == null || this.zzvV == null) ? this.zzvS : zzgo.zza(this.zzvS, this.zzvV.zzn());
        }
        return zza;
    }
}
