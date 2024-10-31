package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzabk implements zzbwk {
    private b.b.c.m zzczs;
    private b.b.c.h zzczt;
    private b.b.c.l zzczu;
    private zzabl zzczv;

    public static boolean zzj(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        if (queryIntentActivities != null && resolveActivity != null) {
            for (int i = 0; i < queryIntentActivities.size(); i++) {
                if (resolveActivity.activityInfo.name.equals(queryIntentActivities.get(i).activityInfo.name)) {
                    return resolveActivity.activityInfo.packageName.equals(zzbwi.zzbp(context));
                }
            }
        }
        return false;
    }

    public final boolean mayLaunchUrl(Uri uri, Bundle bundle, List<Bundle> list) {
        b.b.c.h hVar = this.zzczt;
        if (hVar == null) {
            return false;
        }
        if (hVar == null) {
            this.zzczs = null;
        } else if (this.zzczs == null) {
            this.zzczs = hVar.a((b.b.c.a) null);
        }
        b.b.c.m mVar = this.zzczs;
        if (mVar == null) {
            return false;
        }
        return mVar.a(uri, null, null);
    }

    public final void zza(zzabl zzablVar) {
        this.zzczv = zzablVar;
    }

    public final void zzc(Activity activity) {
        b.b.c.l lVar = this.zzczu;
        if (lVar == null) {
            return;
        }
        activity.unbindService(lVar);
        this.zzczt = null;
        this.zzczs = null;
        this.zzczu = null;
    }

    public final void zzd(Activity activity) {
        String zzbp;
        if (this.zzczt == null && (zzbp = zzbwi.zzbp(activity)) != null) {
            this.zzczu = new zzbwj(this);
            b.b.c.h.a(activity, zzbp, this.zzczu);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwk
    public final void zzrl() {
        this.zzczt = null;
        this.zzczs = null;
        zzabl zzablVar = this.zzczv;
        if (zzablVar != null) {
            zzablVar.zzrn();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwk
    public final void zza(b.b.c.h hVar) {
        this.zzczt = hVar;
        this.zzczt.a(0L);
        zzabl zzablVar = this.zzczv;
        if (zzablVar != null) {
            zzablVar.zzrm();
        }
    }
}
