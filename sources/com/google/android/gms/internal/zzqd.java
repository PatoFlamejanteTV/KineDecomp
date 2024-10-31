package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.playlog.internal.LogEvent;
import com.google.android.gms.playlog.internal.PlayLoggerContext;

@Deprecated
/* loaded from: classes.dex */
public class zzqd {
    private final com.google.android.gms.playlog.internal.zzf zzaRE;
    private PlayLoggerContext zzaRF;

    /* loaded from: classes.dex */
    public interface zza {
        void zzBr();

        void zzBs();

        void zzf(PendingIntent pendingIntent);
    }

    public zzqd(Context context, int i, String str, String str2, zza zzaVar, boolean z, String str3) {
        String packageName = context.getPackageName();
        int i2 = 0;
        try {
            i2 = context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.wtf("PlayLogger", "This can't happen.", e);
        }
        this.zzaRF = new PlayLoggerContext(packageName, i2, i, str, str2, z);
        this.zzaRE = new com.google.android.gms.playlog.internal.zzf(context, context.getMainLooper(), new com.google.android.gms.playlog.internal.zzd(zzaVar), new com.google.android.gms.common.internal.zzf(null, null, null, 49, null, packageName, str3, null));
    }

    public void start() {
        this.zzaRE.a();
    }

    public void stop() {
        this.zzaRE.b();
    }

    public void zza(long j, String str, byte[] bArr, String... strArr) {
        this.zzaRE.a(this.zzaRF, new LogEvent(j, 0L, str, bArr, strArr));
    }

    public void zzb(String str, byte[] bArr, String... strArr) {
        zza(System.currentTimeMillis(), str, bArr, strArr);
    }
}
