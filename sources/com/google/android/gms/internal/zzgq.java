package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.LinkedList;

@zzgr
/* loaded from: classes.dex */
public class zzgq implements Thread.UncaughtExceptionHandler {
    private Context mContext;
    private VersionInfoParcel zzBZ;
    private Thread.UncaughtExceptionHandler zzEc;
    private Thread.UncaughtExceptionHandler zzEd;

    public zzgq(Context context, VersionInfoParcel versionInfoParcel, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Thread.UncaughtExceptionHandler uncaughtExceptionHandler2) {
        this.zzEc = uncaughtExceptionHandler;
        this.zzEd = uncaughtExceptionHandler2;
        this.mContext = context;
        this.zzBZ = versionInfoParcel;
    }

    public static zzgq zza(Context context, Thread thread, VersionInfoParcel versionInfoParcel) {
        if (context == null || thread == null || versionInfoParcel == null) {
            return null;
        }
        if (!zzy(context)) {
            return null;
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = thread.getUncaughtExceptionHandler();
        zzgq zzgqVar = new zzgq(context, versionInfoParcel, uncaughtExceptionHandler, Thread.getDefaultUncaughtExceptionHandler());
        if (uncaughtExceptionHandler != null && (uncaughtExceptionHandler instanceof zzgq)) {
            return (zzgq) uncaughtExceptionHandler;
        }
        try {
            thread.setUncaughtExceptionHandler(zzgqVar);
            return zzgqVar;
        } catch (SecurityException e) {
            com.google.android.gms.ads.internal.util.client.zzb.c("Fail to set UncaughtExceptionHandler.", e);
            return null;
        }
    }

    private Throwable zzb(Throwable th) {
        Throwable th2;
        if (zzby.zzur.get().booleanValue()) {
            return th;
        }
        LinkedList linkedList = new LinkedList();
        while (th != null) {
            linkedList.push(th);
            th = th.getCause();
        }
        Throwable th3 = null;
        while (!linkedList.isEmpty()) {
            Throwable th4 = (Throwable) linkedList.pop();
            StackTraceElement[] stackTrace = th4.getStackTrace();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new StackTraceElement(th4.getClass().getName(), "<filtered>", "<filtered>", 1));
            boolean z = false;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (zzar(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                    z = true;
                } else if (zzas(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                } else {
                    arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                }
            }
            if (z) {
                th2 = th3 == null ? new Throwable(th4.getMessage()) : new Throwable(th4.getMessage(), th3);
                th2.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
            } else {
                th2 = th3;
            }
            th3 = th2;
        }
        return th3;
    }

    private static boolean zzy(Context context) {
        return zzby.zzuq.get().booleanValue();
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (zza(th)) {
            if (Looper.getMainLooper().getThread() != thread) {
                zza(th, true);
                return;
            }
            zza(th, false);
        }
        if (this.zzEc != null) {
            this.zzEc.uncaughtException(thread, th);
        } else if (this.zzEd != null) {
            this.zzEd.uncaughtException(thread, th);
        }
    }

    public void zza(Throwable th, boolean z) {
        Throwable zzb;
        if (zzy(this.mContext) && (zzb = zzb(th)) != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(zzb(zzb, z));
            com.google.android.gms.ads.internal.zzp.e().zza(this.mContext, this.zzBZ.b, arrayList, com.google.android.gms.ads.internal.zzp.h().zzgr());
        }
    }

    protected boolean zza(Throwable th) {
        if (th == null) {
            return false;
        }
        boolean z = false;
        boolean z2 = false;
        while (th != null) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (zzar(stackTraceElement.getClassName())) {
                    z2 = true;
                }
                if (getClass().getName().equals(stackTraceElement.getClassName())) {
                    z = true;
                }
            }
            th = th.getCause();
        }
        return z2 && !z;
    }

    protected boolean zzar(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("com.google.android.gms.ads") && !str.startsWith("com.google.ads")) {
            try {
                return Class.forName(str).isAnnotationPresent(zzgr.class);
            } catch (Exception e) {
                com.google.android.gms.ads.internal.util.client.zzb.a("Fail to check class type for class " + str, e);
                return false;
            }
        }
        return true;
    }

    protected boolean zzas(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("android.") || str.startsWith("java.");
    }

    String zzb(Throwable th, boolean z) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter(ShareConstants.WEB_DIALOG_PARAM_ID, "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT)).appendQueryParameter("device", com.google.android.gms.ads.internal.zzp.e().zzgE()).appendQueryParameter("js", this.zzBZ.b).appendQueryParameter("appid", this.mContext.getApplicationContext().getPackageName()).appendQueryParameter("stacktrace", stringWriter.toString()).appendQueryParameter("eids", TextUtils.join(",", zzby.zzdf())).appendQueryParameter("trapped", String.valueOf(z)).toString();
    }
}
