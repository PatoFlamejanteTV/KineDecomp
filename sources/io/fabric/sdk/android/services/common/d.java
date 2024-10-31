package io.fabric.sdk.android.services.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;

/* compiled from: AdvertisingInfoProvider.java */
/* loaded from: classes3.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    private final Context f26889a;

    /* renamed from: b, reason: collision with root package name */
    private final io.fabric.sdk.android.a.c.c f26890b;

    public d(Context context) {
        this.f26889a = context.getApplicationContext();
        this.f26890b = new io.fabric.sdk.android.a.c.d(context, "TwitterAdvertisingInfoPreferences");
    }

    private void b(b bVar) {
        new Thread(new c(this, bVar)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CommitPrefEdits"})
    public void c(b bVar) {
        if (a(bVar)) {
            io.fabric.sdk.android.a.c.c cVar = this.f26890b;
            cVar.a(cVar.edit().putString("advertising_id", bVar.f26885a).putBoolean("limit_ad_tracking_enabled", bVar.f26886b));
        } else {
            io.fabric.sdk.android.a.c.c cVar2 = this.f26890b;
            cVar2.a(cVar2.edit().remove("advertising_id").remove("limit_ad_tracking_enabled"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b e() {
        b a2 = c().a();
        if (!a(a2)) {
            a2 = d().a();
            if (!a(a2)) {
                io.fabric.sdk.android.f.f().d("Fabric", "AdvertisingInfo not present");
            } else {
                io.fabric.sdk.android.f.f().d("Fabric", "Using AdvertisingInfo from Service Provider");
            }
        } else {
            io.fabric.sdk.android.f.f().d("Fabric", "Using AdvertisingInfo from Reflection Provider");
        }
        return a2;
    }

    public h d() {
        return new g(this.f26889a);
    }

    public b a() {
        b b2 = b();
        if (a(b2)) {
            io.fabric.sdk.android.f.f().d("Fabric", "Using AdvertisingInfo from Preference Store");
            b(b2);
            return b2;
        }
        b e2 = e();
        c(e2);
        return e2;
    }

    protected b b() {
        return new b(this.f26890b.get().getString("advertising_id", ""), this.f26890b.get().getBoolean("limit_ad_tracking_enabled", false));
    }

    private boolean a(b bVar) {
        return (bVar == null || TextUtils.isEmpty(bVar.f26885a)) ? false : true;
    }

    public h c() {
        return new e(this.f26889a);
    }
}
