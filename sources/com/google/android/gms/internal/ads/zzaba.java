package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzaba {

    @VisibleForTesting
    private boolean zzczj;
    private String zzczm;
    private zzaba zzczn;
    private final List<zzaay> zzczk = new LinkedList();
    private final Map<String, String> zzczl = new LinkedHashMap();
    private final Object mLock = new Object();

    public zzaba(boolean z, String str, String str2) {
        this.zzczj = z;
        this.zzczl.put(NativeProtocol.WEB_DIALOG_ACTION, str);
        this.zzczl.put("ad_format", str2);
    }

    public final boolean zza(zzaay zzaayVar, String... strArr) {
        if (!this.zzczj || zzaayVar == null) {
            return false;
        }
        return zza(zzaayVar, com.google.android.gms.ads.internal.zzbv.l().c(), strArr);
    }

    public final zzaay zzao(long j) {
        if (this.zzczj) {
            return new zzaay(j, null, null);
        }
        return null;
    }

    public final void zzbp(String str) {
        if (this.zzczj) {
            synchronized (this.mLock) {
                this.zzczm = str;
            }
        }
    }

    public final void zzc(zzaba zzabaVar) {
        synchronized (this.mLock) {
            this.zzczn = zzabaVar;
        }
    }

    public final void zzg(String str, String str2) {
        zzaaq zzyh;
        if (!this.zzczj || TextUtils.isEmpty(str2) || (zzyh = com.google.android.gms.ads.internal.zzbv.i().zzyh()) == null) {
            return;
        }
        synchronized (this.mLock) {
            zzaau zzbn = zzyh.zzbn(str);
            Map<String, String> map = this.zzczl;
            map.put(str, zzbn.zzf(map.get(str), str2));
        }
    }

    public final zzaay zzrg() {
        return zzao(com.google.android.gms.ads.internal.zzbv.l().c());
    }

    public final String zzrh() {
        String sb;
        StringBuilder sb2 = new StringBuilder();
        synchronized (this.mLock) {
            for (zzaay zzaayVar : this.zzczk) {
                long time = zzaayVar.getTime();
                String zzrd = zzaayVar.zzrd();
                zzaay zzre = zzaayVar.zzre();
                if (zzre != null && time > 0) {
                    long time2 = time - zzre.getTime();
                    sb2.append(zzrd);
                    sb2.append('.');
                    sb2.append(time2);
                    sb2.append(',');
                }
            }
            this.zzczk.clear();
            if (!TextUtils.isEmpty(this.zzczm)) {
                sb2.append(this.zzczm);
            } else if (sb2.length() > 0) {
                sb2.setLength(sb2.length() - 1);
            }
            sb = sb2.toString();
        }
        return sb;
    }

    @VisibleForTesting
    public final Map<String, String> zzri() {
        synchronized (this.mLock) {
            zzaaq zzyh = com.google.android.gms.ads.internal.zzbv.i().zzyh();
            if (zzyh != null && this.zzczn != null) {
                return zzyh.zza(this.zzczl, this.zzczn.zzri());
            }
            return this.zzczl;
        }
    }

    public final zzaay zzrj() {
        synchronized (this.mLock) {
        }
        return null;
    }

    public final boolean zza(zzaay zzaayVar, long j, String... strArr) {
        synchronized (this.mLock) {
            for (String str : strArr) {
                this.zzczk.add(new zzaay(j, str, zzaayVar));
            }
        }
        return true;
    }
}
