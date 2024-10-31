package io.fabric.sdk.android.services.common;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdvertisingInfoReflectionStrategy.java */
/* loaded from: classes3.dex */
public class e implements h {

    /* renamed from: a, reason: collision with root package name */
    private final Context f26891a;

    public e(Context context) {
        this.f26891a = context.getApplicationContext();
    }

    private String b() {
        try {
            return (String) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("getId", new Class[0]).invoke(c(), new Object[0]);
        } catch (Exception unused) {
            io.fabric.sdk.android.f.f().b("Fabric", "Could not call getId on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return null;
        }
    }

    private Object c() {
        try {
            return Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", Context.class).invoke(null, this.f26891a);
        } catch (Exception unused) {
            io.fabric.sdk.android.f.f().b("Fabric", "Could not call getAdvertisingIdInfo on com.google.android.gms.ads.identifier.AdvertisingIdClient");
            return null;
        }
    }

    private boolean d() {
        try {
            return ((Boolean) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(c(), new Object[0])).booleanValue();
        } catch (Exception unused) {
            io.fabric.sdk.android.f.f().b("Fabric", "Could not call isLimitAdTrackingEnabled on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return false;
        }
    }

    boolean a(Context context) {
        try {
            return ((Integer) Class.forName("com.google.android.gms.common.GooglePlayServicesUtil").getMethod("isGooglePlayServicesAvailable", Context.class).invoke(null, context)).intValue() == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // io.fabric.sdk.android.services.common.h
    public b a() {
        if (a(this.f26891a)) {
            return new b(b(), d());
        }
        return null;
    }
}
