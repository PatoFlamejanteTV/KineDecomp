package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzan;
import com.google.android.gms.measurement.internal.zzbw;
import com.google.android.gms.measurement.internal.zzn;
import com.google.firebase.iid.FirebaseInstanceId;

/* loaded from: classes2.dex */
public final class FirebaseAnalytics {

    /* renamed from: a, reason: collision with root package name */
    private static volatile FirebaseAnalytics f16340a;

    /* renamed from: b, reason: collision with root package name */
    private final zzbw f16341b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f16342c;

    /* loaded from: classes2.dex */
    public static class Event {
        protected Event() {
        }
    }

    /* loaded from: classes2.dex */
    public static class Param {
        protected Param() {
        }
    }

    /* loaded from: classes2.dex */
    public static class UserProperty {
        protected UserProperty() {
        }
    }

    private FirebaseAnalytics(zzbw zzbwVar) {
        Preconditions.a(zzbwVar);
        this.f16341b = zzbwVar;
        this.f16342c = new Object();
    }

    @Keep
    public static FirebaseAnalytics getInstance(Context context) {
        if (f16340a == null) {
            synchronized (FirebaseAnalytics.class) {
                if (f16340a == null) {
                    f16340a = new FirebaseAnalytics(zzbw.a(context, (zzan) null));
                }
            }
        }
        return f16340a;
    }

    public final void a(String str, Bundle bundle) {
        this.f16341b.v().a(str, bundle);
    }

    @Keep
    public final String getFirebaseInstanceId() {
        return FirebaseInstanceId.b().a();
    }

    @Keep
    public final void setCurrentScreen(Activity activity, String str, String str2) {
        if (!zzn.a()) {
            this.f16341b.b().t().a("setCurrentScreen must be called from the main thread");
        } else {
            this.f16341b.k().a(activity, str, str2);
        }
    }

    public final void a(String str, String str2) {
        this.f16341b.v().a(str, str2);
    }

    public final void a(boolean z) {
        this.f16341b.v().b(z);
    }
}
