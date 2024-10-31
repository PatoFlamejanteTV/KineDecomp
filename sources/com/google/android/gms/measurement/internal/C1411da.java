package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
@TargetApi(14)
/* renamed from: com.google.android.gms.measurement.internal.da, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1411da implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzda f13759a;

    private C1411da(zzda zzdaVar) {
        this.f13759a = zzdaVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Uri data;
        try {
            this.f13759a.b().y().a("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent != null && (data = intent.getData()) != null && data.isHierarchical()) {
                if (bundle == null) {
                    Bundle a2 = this.f13759a.h().a(data);
                    this.f13759a.h();
                    String str = zzfy.a(intent) ? "gs" : "auto";
                    if (a2 != null) {
                        this.f13759a.b(str, "_cmp", a2);
                    }
                }
                String queryParameter = data.getQueryParameter("referrer");
                if (TextUtils.isEmpty(queryParameter)) {
                    return;
                }
                if (!(queryParameter.contains("gclid") && (queryParameter.contains("utm_campaign") || queryParameter.contains("utm_source") || queryParameter.contains("utm_medium") || queryParameter.contains("utm_term") || queryParameter.contains("utm_content")))) {
                    this.f13759a.b().x().a("Activity created with data 'referrer' param without gclid and at least one utm field");
                    return;
                } else {
                    this.f13759a.b().x().a("Activity created with referrer", queryParameter);
                    if (!TextUtils.isEmpty(queryParameter)) {
                        this.f13759a.a("auto", "_ldl", (Object) queryParameter, true);
                    }
                }
            }
        } catch (Exception e2) {
            this.f13759a.b().q().a("Throwable caught in onActivityCreated", e2);
        }
        this.f13759a.p().a(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.f13759a.p().a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        this.f13759a.p().b(activity);
        zzfd r = this.f13759a.r();
        r.zzgs().a(new Ha(r, r.a().c()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        this.f13759a.p().c(activity);
        zzfd r = this.f13759a.r();
        r.zzgs().a(new Ga(r, r.a().c()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.f13759a.p().b(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C1411da(zzda zzdaVar, T t) {
        this(zzdaVar);
    }
}
