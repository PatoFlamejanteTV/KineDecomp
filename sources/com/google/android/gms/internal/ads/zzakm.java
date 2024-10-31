package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import java.util.Map;

@zzark
/* loaded from: classes2.dex */
public final class zzakm extends zzbil {
    private static final Object lock = new Object();
    private static zzakm zzdkq;
    private final AppMeasurementSdk zzdkr;

    private zzakm(AppMeasurementSdk appMeasurementSdk) {
        this.zzdkr = appMeasurementSdk;
    }

    public static void zza(final Context context, String str, Bundle bundle) {
        synchronized (lock) {
            if (zzdkq != null) {
                return;
            }
            final zzakm zzakmVar = new zzakm(AppMeasurementSdk.a(context, "Ads", "am", str, bundle));
            zzdkq = zzakmVar;
            new Thread(new Runnable(context, zzakmVar) { // from class: com.google.android.gms.internal.ads.gb

                /* renamed from: a, reason: collision with root package name */
                private final Context f12170a;

                /* renamed from: b, reason: collision with root package name */
                private final zzakm f12171b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f12170a = context;
                    this.f12171b = zzakmVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzakm.zza(this.f12170a, this.f12171b);
                }
            }).start();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbik
    public final void beginAdUnitExposure(String str) throws RemoteException {
        this.zzdkr.a(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbik
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        this.zzdkr.a(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbik
    public final void endAdUnitExposure(String str) throws RemoteException {
        this.zzdkr.b(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbik
    public final long generateEventId() throws RemoteException {
        return this.zzdkr.a();
    }

    @Override // com.google.android.gms.internal.ads.zzbik
    public final String getAppIdOrigin() throws RemoteException {
        return this.zzdkr.b();
    }

    @Override // com.google.android.gms.internal.ads.zzbik
    public final String getAppInstanceId() throws RemoteException {
        return this.zzdkr.c();
    }

    @Override // com.google.android.gms.internal.ads.zzbik
    public final List getConditionalUserProperties(String str, String str2) throws RemoteException {
        return this.zzdkr.a(str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbik
    public final String getCurrentScreenClass() throws RemoteException {
        return this.zzdkr.d();
    }

    @Override // com.google.android.gms.internal.ads.zzbik
    public final String getCurrentScreenName() throws RemoteException {
        return this.zzdkr.e();
    }

    @Override // com.google.android.gms.internal.ads.zzbik
    public final String getGmpAppId() throws RemoteException {
        return this.zzdkr.f();
    }

    @Override // com.google.android.gms.internal.ads.zzbik
    public final int getMaxUserProperties(String str) throws RemoteException {
        return this.zzdkr.c(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbik
    public final Map getUserProperties(String str, String str2, boolean z) throws RemoteException {
        return this.zzdkr.a(str, str2, z);
    }

    @Override // com.google.android.gms.internal.ads.zzbik
    public final void logEvent(String str, String str2, Bundle bundle) throws RemoteException {
        this.zzdkr.b(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbik
    public final void performAction(Bundle bundle) throws RemoteException {
        this.zzdkr.a(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbik
    public final Bundle performActionWithResponse(Bundle bundle) throws RemoteException {
        return this.zzdkr.b(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbik
    public final void setConditionalUserProperty(Bundle bundle) throws RemoteException {
        this.zzdkr.c(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbik
    public final void zzb(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        this.zzdkr.a(iObjectWrapper != null ? (Activity) ObjectWrapper.a(iObjectWrapper) : null, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbik
    public final void zza(String str, String str2, IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zzdkr.a(str, str2, iObjectWrapper != null ? ObjectWrapper.a(iObjectWrapper) : null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void zza(Context context, zzakm zzakmVar) {
        try {
            ((zzbim) zzbbe.zza(context, "com.google.android.gms.ads.measurement.DynamiteMeasurementManager", C0925hb.f12188a)).zza(zzakmVar);
        } catch (RemoteException | zzbbg | NullPointerException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }
}
