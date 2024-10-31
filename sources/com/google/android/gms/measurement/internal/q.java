package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
final class q {
    private static volatile q d;

    /* renamed from: a, reason: collision with root package name */
    private final String f2042a;
    private final Status b;
    private final boolean c;

    q(Context context) {
        boolean z = true;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", context.getPackageName());
        if (identifier != 0 && resources.getInteger(identifier) == 0) {
            z = false;
        }
        this.c = z;
        int identifier2 = resources.getIdentifier("google_app_id", "string", context.getPackageName());
        if (identifier2 == 0) {
            if (this.c) {
                this.b = new Status(10, "Missing an expected resource: 'R.string.google_app_id' for initializing Google services.  Possible causes are missing google-services.json or com.google.gms.google-services gradle plugin.");
            } else {
                this.b = Status.f979a;
            }
            this.f2042a = null;
            return;
        }
        String string = resources.getString(identifier2);
        if (!TextUtils.isEmpty(string)) {
            this.f2042a = string;
            this.b = Status.f979a;
        } else {
            if (this.c) {
                this.b = new Status(10, "The resource 'R.string.google_app_id' is invalid, expected an app  identifier and found: '" + string + "'.");
            } else {
                this.b = Status.f979a;
            }
            this.f2042a = null;
        }
    }

    public static Status a(Context context) {
        zzx.a(context, "Context must not be null.");
        if (d == null) {
            synchronized (q.class) {
                if (d == null) {
                    d = new q(context);
                }
            }
        }
        return d.b;
    }

    public static String a() {
        if (d == null) {
            synchronized (q.class) {
                if (d == null) {
                    throw new IllegalStateException("Initialize must be called before getGoogleAppId.");
                }
            }
        }
        return d.b();
    }

    public static boolean c() {
        if (d == null) {
            synchronized (q.class) {
                if (d == null) {
                    throw new IllegalStateException("Initialize must be called before isMeasurementEnabled.");
                }
            }
        }
        return d.d();
    }

    String b() {
        if (this.b.d()) {
            return this.f2042a;
        }
        throw new IllegalStateException("Initialize must be successful before calling getGoogleAppId.  The result of the previous call to initialize was: '" + this.b + "'.");
    }

    boolean d() {
        if (this.b.d()) {
            return this.c;
        }
        throw new IllegalStateException("Initialize must be successful before calling isMeasurementEnabledInternal.  The result of the previous call to initialize was: '" + this.b + "'.");
    }
}
