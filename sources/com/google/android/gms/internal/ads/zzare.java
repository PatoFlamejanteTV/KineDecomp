package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.qq.e.comm.pi.ACTD;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzare implements zzari {
    private static final Object sLock = new Object();

    @VisibleForTesting
    private static zzari zzdvf = null;

    @VisibleForTesting
    private static zzari zzdvg = null;
    private final zzbbi zzbpt;
    private final Object zzdvh;
    private final Context zzdvi;
    private final WeakHashMap<Thread, Boolean> zzdvj;
    private final ExecutorService zzsq;

    private zzare(Context context) {
        this(context, zzbbi.zzaav());
    }

    public static zzari zzc(Context context, zzbbi zzbbiVar) {
        synchronized (sLock) {
            if (zzdvg == null) {
                if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcoe)).booleanValue()) {
                    zzare zzareVar = new zzare(context, zzbbiVar);
                    Thread thread = Looper.getMainLooper().getThread();
                    if (thread != null) {
                        synchronized (zzareVar.zzdvh) {
                            zzareVar.zzdvj.put(thread, true);
                        }
                        thread.setUncaughtExceptionHandler(new C1134wc(zzareVar, thread.getUncaughtExceptionHandler()));
                    }
                    Thread.setDefaultUncaughtExceptionHandler(new C1120vc(zzareVar, Thread.getDefaultUncaughtExceptionHandler()));
                    zzdvg = zzareVar;
                } else {
                    zzdvg = new zzarj();
                }
            }
        }
        return zzdvg;
    }

    public static zzari zzn(Context context) {
        synchronized (sLock) {
            if (zzdvf == null) {
                if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcoe)).booleanValue()) {
                    zzdvf = new zzare(context);
                } else {
                    zzdvf = new zzarj();
                }
            }
        }
        return zzdvf;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003d, code lost:            if (r3 == false) goto L48;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(java.lang.Thread r10, java.lang.Throwable r11) {
        /*
            r9 = this;
            r10 = 1
            r0 = 0
            if (r11 == 0) goto L40
            r1 = r11
            r2 = 0
            r3 = 0
        L7:
            if (r1 == 0) goto L3b
            java.lang.StackTraceElement[] r4 = r1.getStackTrace()
            int r5 = r4.length
            r6 = r3
            r3 = r2
            r2 = 0
        L11:
            if (r2 >= r5) goto L34
            r7 = r4[r2]
            java.lang.String r8 = r7.getClassName()
            boolean r8 = com.google.android.gms.internal.ads.zzbat.zzej(r8)
            if (r8 == 0) goto L20
            r3 = 1
        L20:
            java.lang.Class<com.google.android.gms.internal.ads.zzare> r8 = com.google.android.gms.internal.ads.zzare.class
            java.lang.String r8 = r8.getName()
            java.lang.String r7 = r7.getClassName()
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L31
            r6 = 1
        L31:
            int r2 = r2 + 1
            goto L11
        L34:
            java.lang.Throwable r1 = r1.getCause()
            r2 = r3
            r3 = r6
            goto L7
        L3b:
            if (r2 == 0) goto L40
            if (r3 != 0) goto L40
            goto L41
        L40:
            r10 = 0
        L41:
            if (r10 == 0) goto L4a
            r10 = 1065353216(0x3f800000, float:1.0)
            java.lang.String r0 = ""
            r9.zza(r11, r0, r10)
        L4a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzare.zza(java.lang.Thread, java.lang.Throwable):void");
    }

    private zzare(Context context, zzbbi zzbbiVar) {
        this.zzdvh = new Object();
        this.zzdvj = new WeakHashMap<>();
        this.zzsq = Executors.newCachedThreadPool();
        this.zzdvi = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzbpt = zzbbiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzari
    public final void zza(Throwable th, String str) {
        zza(th, str, 1.0f);
    }

    @Override // com.google.android.gms.internal.ads.zzari
    public final void zza(Throwable th, String str, float f2) {
        if (zzbat.zzc(th) == null) {
            return;
        }
        String name = th.getClass().getName();
        StringWriter stringWriter = new StringWriter();
        zzbpe.zza(th, new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        int i = 0;
        boolean z = Math.random() < ((double) f2);
        int i2 = f2 > 0.0f ? (int) (1.0f / f2) : 1;
        if (z) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(zza(name, stringWriter2, str, i2).toString());
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                this.zzsq.submit(new RunnableC1148xc(this, new zzbbh(), (String) obj));
            }
        }
    }

    @VisibleForTesting
    private final Uri.Builder zza(String str, String str2, String str3, int i) {
        boolean z;
        String str4;
        try {
            z = Wrappers.a(this.zzdvi).a();
        } catch (Throwable th) {
            zzbbd.zzb("Error fetching instant app info", th);
            z = false;
        }
        try {
            str4 = this.zzdvi.getPackageName();
        } catch (Throwable unused) {
            zzbbd.zzeo("Cannot obtain package name, proceeding.");
            str4 = "unknown";
        }
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(z)).appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter(com.umeng.commonsdk.proguard.e.w, Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT));
        String str5 = Build.MANUFACTURER;
        String str6 = Build.MODEL;
        if (!str6.startsWith(str5)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str5).length() + 1 + String.valueOf(str6).length());
            sb.append(str5);
            sb.append(" ");
            sb.append(str6);
            str6 = sb.toString();
        }
        return appendQueryParameter.appendQueryParameter("device", str6).appendQueryParameter("js", this.zzbpt.zzdp).appendQueryParameter(ACTD.APPID_KEY, str4).appendQueryParameter("exceptiontype", str).appendQueryParameter("stacktrace", str2).appendQueryParameter("eids", TextUtils.join(",", zzaan.zzqw())).appendQueryParameter("exceptionkey", str3).appendQueryParameter("cl", "221522000").appendQueryParameter("rc", "dev").appendQueryParameter(com.umeng.analytics.pro.q.f25955c, zzwu.zzqa()).appendQueryParameter("sampling_rate", Integer.toString(i)).appendQueryParameter("pb_tm", String.valueOf(zzwu.zzpz().zzd(zzaan.zzcyf)));
    }
}
