package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

/* loaded from: classes.dex */
public class zzan extends zzd {

    /* renamed from: a */
    protected String f736a;
    protected String b;
    protected boolean c;
    protected int d;
    protected boolean e;
    protected int f;
    protected boolean g;
    protected boolean h;

    public zzan(zzf zzfVar) {
        super(zzfVar);
    }

    private static int a(String str) {
        String lowerCase = str.toLowerCase();
        if ("verbose".equals(lowerCase)) {
            return 0;
        }
        if ("info".equals(lowerCase)) {
            return 1;
        }
        if ("warning".equals(lowerCase)) {
            return 2;
        }
        return "error".equals(lowerCase) ? 3 : -1;
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void a() {
        j();
    }

    void a(zzaa zzaaVar) {
        int a2;
        b("Loading global XML config values");
        if (zzaaVar.a()) {
            String b = zzaaVar.b();
            this.b = b;
            b("XML config - app name", b);
        }
        if (zzaaVar.c()) {
            String d = zzaaVar.d();
            this.f736a = d;
            b("XML config - app version", d);
        }
        if (zzaaVar.e() && (a2 = a(zzaaVar.f())) >= 0) {
            this.d = a2;
            a("XML config - log level", Integer.valueOf(a2));
        }
        if (zzaaVar.g()) {
            int h = zzaaVar.h();
            this.f = h;
            this.e = true;
            b("XML config - dispatch period (sec)", Integer.valueOf(h));
        }
        if (zzaaVar.i()) {
            boolean j = zzaaVar.j();
            this.h = j;
            this.g = true;
            b("XML config - dry run", Boolean.valueOf(j));
        }
    }

    public String b() {
        D();
        return this.f736a;
    }

    public String c() {
        D();
        return this.b;
    }

    public boolean d() {
        D();
        return this.c;
    }

    public int e() {
        D();
        return this.d;
    }

    public boolean f() {
        D();
        return this.e;
    }

    public int g() {
        D();
        return this.f;
    }

    public boolean h() {
        D();
        return this.g;
    }

    public boolean i() {
        D();
        return this.h;
    }

    protected void j() {
        ApplicationInfo applicationInfo;
        int i;
        zzaa a2;
        Context o = o();
        try {
            applicationInfo = o.getPackageManager().getApplicationInfo(o.getPackageName(), 129);
        } catch (PackageManager.NameNotFoundException e) {
            d("PackageManager doesn't know about the app package", e);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            e("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle == null || (i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource")) <= 0 || (a2 = new zzz(k()).a(i)) == null) {
            return;
        }
        a(a2);
    }
}
