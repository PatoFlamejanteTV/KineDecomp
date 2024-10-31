package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzbj {

    /* renamed from: a, reason: collision with root package name */
    final zzbw f13963a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbj(zzbw zzbwVar) {
        this.f13963a = zzbwVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(String str) {
        if (str != null && !str.isEmpty()) {
            this.f13963a.zzgs().c();
            if (!a()) {
                this.f13963a.b().w().a("Install Referrer Reporter is not available");
                return;
            }
            this.f13963a.b().w().a("Install Referrer Reporter is initializing");
            zzbk zzbkVar = new zzbk(this, str);
            this.f13963a.zzgs().c();
            Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
            intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
            PackageManager packageManager = this.f13963a.getContext().getPackageManager();
            if (packageManager == null) {
                this.f13963a.b().t().a("Failed to obtain Package Manager to verify binding conditions");
                return;
            }
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                ResolveInfo resolveInfo = queryIntentServices.get(0);
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                if (serviceInfo != null) {
                    String str2 = serviceInfo.packageName;
                    if (resolveInfo.serviceInfo.name != null && "com.android.vending".equals(str2) && a()) {
                        try {
                            this.f13963a.b().w().a("Install Referrer Service is", ConnectionTracker.a().a(this.f13963a.getContext(), new Intent(intent), zzbkVar, 1) ? "available" : "not available");
                            return;
                        } catch (Exception e2) {
                            this.f13963a.b().q().a("Exception occurred while binding to Install Referrer Service", e2.getMessage());
                            return;
                        }
                    }
                    this.f13963a.b().w().a("Play Store missing or incompatible. Version 8.3.73 or later required");
                    return;
                }
                return;
            }
            this.f13963a.b().w().a("Play Service for fetching Install Referrer is unavailable on device");
            return;
        }
        this.f13963a.b().w().a("Install Referrer Reporter was called with invalid app package name");
    }

    @VisibleForTesting
    private final boolean a() {
        try {
            PackageManagerWrapper a2 = Wrappers.a(this.f13963a.getContext());
            if (a2 != null) {
                return a2.b("com.android.vending", 128).versionCode >= 80837300;
            }
            this.f13963a.b().w().a("Failed to retrieve Package Manager to check Play Store compatibility");
            return false;
        } catch (Exception e2) {
            this.f13963a.b().w().a("Failed to retrieve Play Store version", e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final Bundle a(String str, com.google.android.gms.internal.measurement.zzu zzuVar) {
        this.f13963a.zzgs().c();
        if (zzuVar == null) {
            this.f13963a.b().t().a("Attempting to use Install Referrer Service while it is not initialized");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString(com.umeng.commonsdk.proguard.e.n, str);
        try {
            Bundle zza = zzuVar.zza(bundle);
            if (zza != null) {
                return zza;
            }
            this.f13963a.b().q().a("Install Referrer Service returned a null response");
            return null;
        } catch (Exception e2) {
            this.f13963a.b().q().a("Exception occurred while retrieving the Install Referrer", e2.getMessage());
            return null;
        }
    }
}
