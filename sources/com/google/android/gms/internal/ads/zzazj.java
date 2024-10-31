package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzazj {
    private final Object mLock = new Object();
    private String zzemd = "";
    private String zzeme = "";
    private boolean zzemf = false;

    @VisibleForTesting
    private String zzemg = "";

    private final String zzbc(Context context) {
        String str;
        synchronized (this.mLock) {
            if (TextUtils.isEmpty(this.zzemd)) {
                com.google.android.gms.ads.internal.zzbv.e();
                this.zzemd = zzayh.zzp(context, "debug_signals_id.txt");
                if (TextUtils.isEmpty(this.zzemd)) {
                    com.google.android.gms.ads.internal.zzbv.e();
                    this.zzemd = zzayh.zzzs();
                    com.google.android.gms.ads.internal.zzbv.e();
                    zzayh.zzd(context, "debug_signals_id.txt", this.zzemd);
                }
            }
            str = this.zzemd;
        }
        return str;
    }

    private final Uri zzc(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("linkedDeviceId", zzbc(context));
        buildUpon.appendQueryParameter("adSlotPath", str2);
        buildUpon.appendQueryParameter("afmaVersion", str3);
        return buildUpon.build();
    }

    @VisibleForTesting
    private final boolean zzg(Context context, String str, String str2) {
        String zzi = zzi(context, zzc(context, (String) zzwu.zzpz().zzd(zzaan.zzcwg), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzi)) {
            zzbbd.zzdn("Not linked for in app preview.");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(zzi.trim());
            String optString = jSONObject.optString("gct");
            this.zzemg = jSONObject.optString("status");
            synchronized (this.mLock) {
                this.zzeme = optString;
            }
            return true;
        } catch (JSONException e2) {
            zzbbd.zzc("Fail to get in app preview response json.", e2);
            return false;
        }
    }

    @VisibleForTesting
    private final boolean zzh(Context context, String str, String str2) {
        String zzi = zzi(context, zzc(context, (String) zzwu.zzpz().zzd(zzaan.zzcwh), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzi)) {
            zzbbd.zzdn("Not linked for debug signals.");
            return false;
        }
        try {
            boolean equals = "1".equals(new JSONObject(zzi.trim()).optString("debug_mode"));
            synchronized (this.mLock) {
                this.zzemf = equals;
            }
            return equals;
        } catch (JSONException e2) {
            zzbbd.zzc("Fail to get debug mode response json.", e2);
            return false;
        }
    }

    @VisibleForTesting
    private static String zzi(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(io.fabric.sdk.android.services.common.a.HEADER_USER_AGENT, com.google.android.gms.ads.internal.zzbv.e().zzo(context, str2));
        zzbcb<String> zzc = new zzazs(context).zzc(str, hashMap);
        try {
            return zzc.get(((Integer) zzwu.zzpz().zzd(zzaan.zzcwj)).intValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            String valueOf = String.valueOf(str);
            zzbbd.zzb(valueOf.length() != 0 ? "Interrupted while retriving a response from: ".concat(valueOf) : new String("Interrupted while retriving a response from: "), e2);
            zzc.cancel(true);
            return null;
        } catch (TimeoutException e3) {
            String valueOf2 = String.valueOf(str);
            zzbbd.zzb(valueOf2.length() != 0 ? "Timeout while retriving a response from: ".concat(valueOf2) : new String("Timeout while retriving a response from: "), e3);
            zzc.cancel(true);
            return null;
        } catch (Exception e4) {
            String valueOf3 = String.valueOf(str);
            zzbbd.zzb(valueOf3.length() != 0 ? "Error retriving a response from: ".concat(valueOf3) : new String("Error retriving a response from: "), e4);
            return null;
        }
    }

    private final void zzj(Context context, String str, String str2) {
        com.google.android.gms.ads.internal.zzbv.e();
        zzayh.zza(context, zzc(context, (String) zzwu.zzpz().zzd(zzaan.zzcwf), str, str2));
    }

    public final void zza(Context context, String str, String str2, @Nullable String str3) {
        boolean zzaah = zzaah();
        if (zzh(context, str, str2)) {
            if (!zzaah && !TextUtils.isEmpty(str3)) {
                zzb(context, str2, str3, str);
            }
            zzbbd.zzdn("Device is linked for debug signals.");
            zza(context, "The device is successfully linked for troubleshooting.", false, true);
            return;
        }
        zzj(context, str, str2);
    }

    public final String zzaag() {
        String str;
        synchronized (this.mLock) {
            str = this.zzeme;
        }
        return str;
    }

    public final boolean zzaah() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzemf;
        }
        return z;
    }

    public final void zzb(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = zzc(context, (String) zzwu.zzpz().zzd(zzaan.zzcwi), str3, str).buildUpon();
        buildUpon.appendQueryParameter("debugData", str2);
        com.google.android.gms.ads.internal.zzbv.e();
        zzayh.zzc(context, str, buildUpon.build().toString());
    }

    public final void zzf(Context context, String str, String str2) {
        if (!zzg(context, str, str2)) {
            zza(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
            return;
        }
        if ("2".equals(this.zzemg)) {
            zzbbd.zzdn("Creative is not pushed for this device.");
            zza(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if ("1".equals(this.zzemg)) {
            zzbbd.zzdn("The app is not linked for creative preview.");
            zzj(context, str, str2);
        } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(this.zzemg)) {
            zzbbd.zzdn("Device is linked for in app preview.");
            zza(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    @VisibleForTesting
    private final void zza(Context context, String str, boolean z, boolean z2) {
        if (!(context instanceof Activity)) {
            zzbbd.zzen("Can not create dialog without Activity Context");
        } else {
            zzayh.zzelc.post(new Nd(this, context, str, z, z2));
        }
    }
}
