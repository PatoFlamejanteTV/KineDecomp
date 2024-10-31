package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.R;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepForSdk
@Deprecated
/* loaded from: classes.dex */
public final class GoogleServices {

    /* renamed from: a */
    private static final Object f10763a = new Object();

    /* renamed from: b */
    private static GoogleServices f10764b;

    /* renamed from: c */
    private final String f10765c;

    /* renamed from: d */
    private final Status f10766d;

    /* renamed from: e */
    private final boolean f10767e;

    /* renamed from: f */
    private final boolean f10768f;

    @VisibleForTesting
    @KeepForSdk
    GoogleServices(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue));
        if (identifier != 0) {
            r3 = resources.getInteger(identifier) != 0;
            this.f10768f = !r3;
        } else {
            this.f10768f = false;
        }
        this.f10767e = r3;
        String a2 = zzp.a(context);
        a2 = a2 == null ? new StringResourceValueReader(context).a("google_app_id") : a2;
        if (TextUtils.isEmpty(a2)) {
            this.f10766d = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.f10765c = null;
        } else {
            this.f10765c = a2;
            this.f10766d = Status.f10704a;
        }
    }

    @KeepForSdk
    public static Status a(Context context) {
        Status status;
        Preconditions.a(context, "Context must not be null.");
        synchronized (f10763a) {
            if (f10764b == null) {
                f10764b = new GoogleServices(context);
            }
            status = f10764b.f10766d;
        }
        return status;
    }

    @KeepForSdk
    public static boolean b() {
        return a("isMeasurementExplicitlyDisabled").f10768f;
    }

    @KeepForSdk
    public static String a() {
        return a("getGoogleAppId").f10765c;
    }

    @KeepForSdk
    private static GoogleServices a(String str) {
        GoogleServices googleServices;
        synchronized (f10763a) {
            if (f10764b != null) {
                googleServices = f10764b;
            } else {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34);
                sb.append("Initialize must be called before ");
                sb.append(str);
                sb.append(".");
                throw new IllegalStateException(sb.toString());
            }
        }
        return googleServices;
    }
}
