package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@zzark
/* loaded from: classes2.dex */
public final class zzaww {
    private final AtomicReference<ThreadPoolExecutor> zzegt = new AtomicReference<>(null);
    private final Object zzegu = new Object();
    private String zzegv = null;
    private String zzegw = null;

    @VisibleForTesting
    private final AtomicBoolean zzegx = new AtomicBoolean(false);

    @VisibleForTesting
    private final AtomicInteger zzegy = new AtomicInteger(-1);
    private final AtomicReference<Object> zzegz = new AtomicReference<>(null);
    private final AtomicReference<Object> zzeha = new AtomicReference<>(null);
    private ConcurrentMap<String, Method> zzehb = new ConcurrentHashMap(9);
    private final AtomicReference<zzbik> zzehc = new AtomicReference<>(null);
    private final List<FutureTask> zzehd = new ArrayList();

    private final Method zzab(Context context) {
        Method method = this.zzehb.get("logEventInternal");
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod("logEventInternal", String.class, String.class, Bundle.class);
            this.zzehb.put("logEventInternal", declaredMethod);
            return declaredMethod;
        } catch (Exception e2) {
            zza(e2, "logEventInternal", true);
            return null;
        }
    }

    private final void zzb(Context context, String str, Bundle bundle) {
        if (zzv(context) && zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzegz, true)) {
            try {
                zzab(context).invoke(this.zzegz.get(), "am", str, bundle);
            } catch (Exception e2) {
                zza(e2, "logEventInternal", true);
            }
        }
    }

    private final Method zzi(Context context, String str) {
        Method method = this.zzehb.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, String.class);
            this.zzehb.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e2) {
            zza(e2, str, false);
            return null;
        }
    }

    private final Method zzj(Context context, String str) {
        Method method = this.zzehb.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[0]);
            this.zzehb.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e2) {
            zza(e2, str, false);
            return null;
        }
    }

    private final Method zzk(Context context, String str) {
        Method method = this.zzehb.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod(str, Activity.class, String.class, String.class);
            this.zzehb.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e2) {
            zza(e2, str, false);
            return null;
        }
    }

    public final void zza(Context context, String str, String str2, String str3, int i) {
        if (zzv(context)) {
            Bundle zzf = zzf(str, false);
            zzf.putString("_ai", str2);
            zzf.putString("type", str3);
            zzf.putInt("value", i);
            zzb(context, "_ar", zzf);
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 75);
            sb.append("Log a Firebase reward video event, reward type: ");
            sb.append(str3);
            sb.append(", reward value: ");
            sb.append(i);
            zzaxz.v(sb.toString());
        }
    }

    public final String zzaa(Context context) {
        if (!zzv(context)) {
            return null;
        }
        synchronized (this.zzegu) {
            if (this.zzegw != null) {
                return this.zzegw;
            }
            this.zzegw = "fa";
            return this.zzegw;
        }
    }

    public final /* synthetic */ String zzac(Context context) throws Exception {
        return (String) zza("getAppInstanceId", context);
    }

    public final void zzc(Context context, String str) {
        if (zzv(context)) {
            zzb(context, str, "beginAdUnitExposure");
        }
    }

    public final void zzd(Context context, String str) {
        if (zzv(context)) {
            zzb(context, str, "endAdUnitExposure");
        }
    }

    public final void zze(Context context, String str) {
        if (zzv(context) && (context instanceof Activity) && zza(context, "com.google.firebase.analytics.FirebaseAnalytics", this.zzeha, false)) {
            try {
                zzk(context, "setCurrentScreen").invoke(this.zzeha.get(), (Activity) context, str, context.getPackageName());
            } catch (Exception e2) {
                zza(e2, "setCurrentScreen", false);
            }
        }
    }

    public final void zzf(Context context, String str) {
        zza(context, "_ac", str);
    }

    public final void zzg(Context context, String str) {
        zza(context, "_ai", str);
    }

    public final void zzh(Context context, String str) {
        zza(context, "_aq", str);
    }

    public final boolean zzv(Context context) {
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcqp)).booleanValue() && !this.zzegx.get()) {
            if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcqy)).booleanValue()) {
                return true;
            }
            if (this.zzegy.get() == -1) {
                zzwu.zzpv();
                if (!zzbat.zzc(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                    zzwu.zzpv();
                    if (zzbat.zzbh(context)) {
                        zzbbd.zzeo("Google Play Service is out of date, the Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires updated Google Play Service.");
                        this.zzegy.set(0);
                    }
                }
                this.zzegy.set(1);
            }
            if (this.zzegy.get() == 1) {
                return true;
            }
        }
        return false;
    }

    public final String zzw(Context context) {
        if (!zzv(context) || !zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzegz, true)) {
            return "";
        }
        try {
            String str = (String) zzj(context, "getCurrentScreenName").invoke(this.zzegz.get(), new Object[0]);
            if (str == null) {
                str = (String) zzj(context, "getCurrentScreenClass").invoke(this.zzegz.get(), new Object[0]);
            }
            return str != null ? str : "";
        } catch (Exception e2) {
            zza(e2, "getCurrentScreenName", false);
            return "";
        }
    }

    public final String zzx(Context context) {
        if (!zzv(context)) {
            return null;
        }
        synchronized (this.zzegu) {
            if (this.zzegv != null) {
                return this.zzegv;
            }
            this.zzegv = (String) zza("getGmpAppId", context);
            return this.zzegv;
        }
    }

    public final String zzy(Context context) {
        if (!zzv(context)) {
            return null;
        }
        long longValue = ((Long) zzwu.zzpz().zzd(zzaan.zzcqu)).longValue();
        if (longValue < 0) {
            return (String) zza("getAppInstanceId", context);
        }
        if (this.zzegt.get() == null) {
            this.zzegt.compareAndSet(null, new ThreadPoolExecutor(((Integer) zzwu.zzpz().zzd(zzaan.zzcqv)).intValue(), ((Integer) zzwu.zzpz().zzd(zzaan.zzcqv)).intValue(), 1L, TimeUnit.MINUTES, new LinkedBlockingQueue(), new ThreadFactoryC0982ld(this)));
        }
        Future submit = this.zzegt.get().submit(new Callable(this, context) { // from class: com.google.android.gms.internal.ads.kd

            /* renamed from: a, reason: collision with root package name */
            private final zzaww f12255a;

            /* renamed from: b, reason: collision with root package name */
            private final Context f12256b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12255a = this;
                this.f12256b = context;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f12255a.zzac(this.f12256b);
            }
        });
        try {
            return (String) submit.get(longValue, TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            submit.cancel(true);
            if (e2 instanceof TimeoutException) {
                return "TIME_OUT";
            }
            return null;
        }
    }

    public final String zzz(Context context) {
        Object zza;
        if (zzv(context) && (zza = zza("generateEventId", context)) != null) {
            return zza.toString();
        }
        return null;
    }

    private static Bundle zzf(String str, boolean z) {
        Bundle bundle = new Bundle();
        try {
            bundle.putLong("_aeid", Long.parseLong(str));
        } catch (NullPointerException | NumberFormatException e2) {
            String valueOf = String.valueOf(str);
            zzbbd.zzb(valueOf.length() != 0 ? "Invalid event ID: ".concat(valueOf) : new String("Invalid event ID: "), e2);
        }
        if (z) {
            bundle.putInt("_r", 1);
        }
        return bundle;
    }

    private final void zzb(Context context, String str, String str2) {
        if (zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzegz, true)) {
            try {
                zzi(context, str2).invoke(this.zzegz.get(), str);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 37 + String.valueOf(str).length());
                sb.append("Invoke Firebase method ");
                sb.append(str2);
                sb.append(", Ad Unit Id: ");
                sb.append(str);
                zzaxz.v(sb.toString());
            } catch (Exception e2) {
                zza(e2, str2, false);
            }
        }
    }

    public final void zza(Context context, String str, String str2) {
        if (zzv(context)) {
            zzb(context, str, zzf(str2, "_ac".equals(str)));
        }
    }

    private final Object zza(String str, Context context) {
        if (!zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzegz, true)) {
            return null;
        }
        try {
            return zzj(context, str).invoke(this.zzegz.get(), new Object[0]);
        } catch (Exception e2) {
            zza(e2, str, true);
            return null;
        }
    }

    private final void zza(Exception exc, String str, boolean z) {
        if (this.zzegx.get()) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 30);
        sb.append("Invoke Firebase method ");
        sb.append(str);
        sb.append(" error.");
        zzbbd.zzeo(sb.toString());
        if (z) {
            zzbbd.zzeo("The Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires the latest Firebase SDK jar, but Firebase SDK is either missing or out of date");
            this.zzegx.set(true);
        }
    }

    private final boolean zza(Context context, String str, AtomicReference<Object> atomicReference, boolean z) {
        if (atomicReference.get() == null) {
            try {
                atomicReference.compareAndSet(null, context.getClassLoader().loadClass(str).getDeclaredMethod("getInstance", Context.class).invoke(null, context));
            } catch (Exception e2) {
                zza(e2, "getInstance", z);
                return false;
            }
        }
        return true;
    }
}
