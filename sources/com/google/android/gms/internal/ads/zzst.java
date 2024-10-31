package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.google.android.gms.common.util.PlatformVersion;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzst {
    private final Object zzbxp = new Object();
    private Bm zzbxq = null;
    private boolean zzbxr = false;

    public final Activity getActivity() {
        synchronized (this.zzbxp) {
            if (!PlatformVersion.a()) {
                return null;
            }
            if (this.zzbxq == null) {
                return null;
            }
            return this.zzbxq.a();
        }
    }

    public final Context getContext() {
        synchronized (this.zzbxp) {
            if (!PlatformVersion.a()) {
                return null;
            }
            if (this.zzbxq == null) {
                return null;
            }
            return this.zzbxq.b();
        }
    }

    public final void initialize(Context context) {
        synchronized (this.zzbxp) {
            if (!this.zzbxr) {
                if (!PlatformVersion.a()) {
                    return;
                }
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = context;
                }
                Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
                if (application == null) {
                    zzbbd.zzeo("Can not cast Context to Application");
                    return;
                }
                if (this.zzbxq == null) {
                    this.zzbxq = new Bm();
                }
                this.zzbxq.a(application, context);
                this.zzbxr = true;
            }
        }
    }

    public final void zza(zzsw zzswVar) {
        synchronized (this.zzbxp) {
            if (PlatformVersion.a()) {
                if (this.zzbxq == null) {
                    this.zzbxq = new Bm();
                }
                this.zzbxq.a(zzswVar);
            }
        }
    }
}
