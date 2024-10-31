package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzaku implements zzaky {
    private final Context mContext;
    private final zzalg zzbma;
    private final zzacp zzbnx;
    private final zzbbi zzbob;
    private zzwb zzbqo;
    private final zzwf zzbqu;
    private final boolean zzbum;
    private final String zzdml;
    private final long zzdmm;
    private final zzakr zzdmn;
    private final zzakq zzdmo;
    private final List<String> zzdmp;
    private final List<String> zzdmq;
    private final List<String> zzdmr;
    private final boolean zzdms;
    private final boolean zzdmt;
    private zzalj zzdmu;
    private zzalp zzdmw;
    private final Object mLock = new Object();
    private int zzdmv = -2;

    public zzaku(Context context, String str, zzalg zzalgVar, zzakr zzakrVar, zzakq zzakqVar, zzwb zzwbVar, zzwf zzwfVar, zzbbi zzbbiVar, boolean z, boolean z2, zzacp zzacpVar, List<String> list, List<String> list2, List<String> list3, boolean z3) {
        this.mContext = context;
        this.zzbma = zzalgVar;
        this.zzdmo = zzakqVar;
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            this.zzdml = zzum();
        } else {
            this.zzdml = str;
        }
        this.zzdmn = zzakrVar;
        long j = zzakqVar.zzdlo;
        if (j != -1) {
            this.zzdmm = j;
        } else {
            long j2 = zzakrVar.zzdlo;
            if (j2 != -1) {
                this.zzdmm = j2;
            } else {
                this.zzdmm = 10000L;
            }
        }
        this.zzbqo = zzwbVar;
        this.zzbqu = zzwfVar;
        this.zzbob = zzbbiVar;
        this.zzbum = z;
        this.zzdms = z2;
        this.zzbnx = zzacpVar;
        this.zzdmp = list;
        this.zzdmq = list2;
        this.zzdmr = list3;
        this.zzdmt = z3;
    }

    private final String zzcm(String str) {
        if (str != null && zzup() && !zzcp(2)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.remove("cpm_floor_cents");
                return jSONObject.toString();
            } catch (JSONException unused) {
                zzbbd.zzeo("Could not remove field. Returning the original value");
            }
        }
        return str;
    }

    private static NativeAdOptions zzcn(String str) {
        NativeAdOptions.Builder builder = new NativeAdOptions.Builder();
        if (str == null) {
            return builder.a();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = 0;
            builder.a(jSONObject.optBoolean("multiple_images", false));
            builder.b(jSONObject.optBoolean("only_urls", false));
            String optString = jSONObject.optString("native_image_orientation", "any");
            if ("landscape".equals(optString)) {
                i = 2;
            } else if ("portrait".equals(optString)) {
                i = 1;
            } else if (!"any".equals(optString)) {
                i = -1;
            }
            builder.b(i);
        } catch (JSONException e2) {
            zzbbd.zzc("Exception occurred when creating native ad options", e2);
        }
        return builder.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzcp(int i) {
        Bundle zzuw;
        try {
            if (this.zzbum) {
                zzuw = this.zzdmu.zzux();
            } else if (this.zzbqu.zzckl) {
                zzuw = this.zzdmu.getInterstitialAdapterInfo();
            } else {
                zzuw = this.zzdmu.zzuw();
            }
            return zzuw != null && (zzuw.getInt("capabilities", 0) & i) == i;
        } catch (RemoteException unused) {
            zzbbd.zzeo("Could not get adapter info. Returning false");
            return false;
        }
    }

    private final String zzum() {
        try {
            if (!TextUtils.isEmpty(this.zzdmo.zzdky)) {
                return this.zzbma.zzcq(this.zzdmo.zzdky) ? "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter" : "com.google.ads.mediation.customevent.CustomEventAdapter";
            }
        } catch (RemoteException unused) {
            zzbbd.zzeo("Fail to determine the custom event's version, assuming the old one.");
        }
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
    }

    private final zzalp zzun() {
        if (this.zzdmv != 0 || !zzup()) {
            return null;
        }
        try {
            if (zzcp(4) && this.zzdmw != null && this.zzdmw.zzur() != 0) {
                return this.zzdmw;
            }
        } catch (RemoteException unused) {
            zzbbd.zzeo("Could not get cpm value from MediationResponseMetadata");
        }
        return new BinderC0952jb(zzuq());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzalj zzuo() {
        String valueOf = String.valueOf(this.zzdml);
        zzbbd.zzen(valueOf.length() != 0 ? "Instantiating mediation adapter: ".concat(valueOf) : new String("Instantiating mediation adapter: "));
        if (!this.zzbum && !this.zzdmo.zzuk()) {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzdml)) {
                return zza(new AdMobAdapter());
            }
            if ("com.google.ads.mediation.AdUrlAdapter".equals(this.zzdml)) {
                return zza(new AdUrlAdapter());
            }
            if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(this.zzdml)) {
                return new zzamd(new zzanu());
            }
        }
        try {
            return this.zzbma.zzcp(this.zzdml);
        } catch (RemoteException e2) {
            String valueOf2 = String.valueOf(this.zzdml);
            zzbbd.zza(valueOf2.length() != 0 ? "Could not instantiate mediation adapter: ".concat(valueOf2) : new String("Could not instantiate mediation adapter: "), e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzup() {
        return this.zzdmn.zzdma != -1;
    }

    private final int zzuq() {
        String str = this.zzdmo.zzdle;
        if (str == null) {
            return 0;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzdml)) {
                return jSONObject.optInt("cpm_cents", 0);
            }
            int optInt = zzcp(2) ? jSONObject.optInt("cpm_floor_cents", 0) : 0;
            return optInt == 0 ? jSONObject.optInt("penalized_average_cpm_cents", 0) : optInt;
        } catch (JSONException unused) {
            zzbbd.zzeo("Could not convert to json. Returning 0");
            return 0;
        }
    }

    public final void cancel() {
        synchronized (this.mLock) {
            try {
                if (this.zzdmu != null) {
                    this.zzdmu.destroy();
                }
            } catch (RemoteException e2) {
                zzbbd.zzc("Could not destroy mediation adapter.", e2);
            }
            this.zzdmv = -1;
            this.mLock.notify();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaky
    public final void zza(int i, zzalp zzalpVar) {
        synchronized (this.mLock) {
            this.zzdmv = 0;
            this.zzdmw = zzalpVar;
            this.mLock.notify();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaky
    public final void zzco(int i) {
        synchronized (this.mLock) {
            this.zzdmv = i;
            this.mLock.notify();
        }
    }

    public final zzakx zzj(long j, long j2) {
        zzakx zzakxVar;
        synchronized (this.mLock) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            zzakt zzaktVar = new zzakt();
            zzayh.zzelc.post(new RunnableC0939ib(this, zzaktVar));
            long j3 = this.zzdmm;
            while (this.zzdmv == -2) {
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                long j4 = j3 - (elapsedRealtime2 - elapsedRealtime);
                long j5 = j2 - (elapsedRealtime2 - j);
                if (j4 > 0 && j5 > 0) {
                    try {
                        this.mLock.wait(Math.min(j4, j5));
                    } catch (InterruptedException unused) {
                        this.zzdmv = 5;
                    }
                } else {
                    zzbbd.zzen("Timed out waiting for adapter.");
                    this.zzdmv = 3;
                }
            }
            zzakxVar = new zzakx(this.zzdmo, this.zzdmu, this.zzdml, zzaktVar, this.zzdmv, zzun(), com.google.android.gms.ads.internal.zzbv.l().c() - elapsedRealtime);
        }
        return zzakxVar;
    }

    @VisibleForTesting
    private static zzalj zza(MediationAdapter mediationAdapter) {
        return new zzamd(mediationAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzakt zzaktVar) {
        String zzcm = zzcm(this.zzdmo.zzdle);
        try {
            if (this.zzbob.zzeov < 4100000) {
                if (this.zzbqu.zzckl) {
                    this.zzdmu.zza(ObjectWrapper.a(this.mContext), this.zzbqo, zzcm, zzaktVar);
                    return;
                } else {
                    this.zzdmu.zza(ObjectWrapper.a(this.mContext), this.zzbqu, this.zzbqo, zzcm, zzaktVar);
                    return;
                }
            }
            if (!this.zzbum && !this.zzdmo.zzuk()) {
                if (this.zzbqu.zzckl) {
                    this.zzdmu.zza(ObjectWrapper.a(this.mContext), this.zzbqo, zzcm, this.zzdmo.zzdku, zzaktVar);
                    return;
                }
                if (this.zzdms) {
                    if (this.zzdmo.zzdli != null) {
                        this.zzdmu.zza(ObjectWrapper.a(this.mContext), this.zzbqo, zzcm, this.zzdmo.zzdku, zzaktVar, new zzacp(zzcn(this.zzdmo.zzdlm)), this.zzdmo.zzdll);
                        return;
                    } else {
                        this.zzdmu.zza(ObjectWrapper.a(this.mContext), this.zzbqu, this.zzbqo, zzcm, this.zzdmo.zzdku, zzaktVar);
                        return;
                    }
                }
                this.zzdmu.zza(ObjectWrapper.a(this.mContext), this.zzbqu, this.zzbqo, zzcm, this.zzdmo.zzdku, zzaktVar);
                return;
            }
            ArrayList arrayList = new ArrayList(this.zzdmp);
            if (this.zzdmq != null) {
                for (String str : this.zzdmq) {
                    String str2 = ":false";
                    if (this.zzdmr != null && this.zzdmr.contains(str)) {
                        str2 = ":true";
                    }
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7 + str2.length());
                    sb.append("custom:");
                    sb.append(str);
                    sb.append(str2);
                    arrayList.add(sb.toString());
                }
            }
            this.zzdmu.zza(ObjectWrapper.a(this.mContext), this.zzbqo, zzcm, this.zzdmo.zzdku, zzaktVar, this.zzbnx, arrayList);
        } catch (RemoteException e2) {
            zzbbd.zzc("Could not request ad from mediation adapter.", e2);
            zzco(5);
        }
    }
}
