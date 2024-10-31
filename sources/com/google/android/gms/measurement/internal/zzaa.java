package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.util.Clock;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class zzaa extends P {

    /* renamed from: c, reason: collision with root package name */
    private long f13887c;

    /* renamed from: d, reason: collision with root package name */
    private String f13888d;

    /* renamed from: e, reason: collision with root package name */
    private Boolean f13889e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaa(zzbw zzbwVar) {
        super(zzbwVar);
    }

    public final boolean a(Context context) {
        if (this.f13889e == null) {
            zzgw();
            this.f13889e = false;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageManager.getPackageInfo("com.google.android.gms", 128);
                    this.f13889e = true;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return this.f13889e.booleanValue();
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzas b() {
        return super.b();
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ zzaa f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ zzaq g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ zzfy h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ C1428m i() {
        return super.i();
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ zzq j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.P
    protected final boolean n() {
        Calendar calendar = Calendar.getInstance();
        this.f13887c = TimeUnit.MINUTES.convert(calendar.get(15) + calendar.get(16), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String lowerCase = locale.getLanguage().toLowerCase(Locale.ENGLISH);
        String lowerCase2 = locale.getCountry().toLowerCase(Locale.ENGLISH);
        StringBuilder sb = new StringBuilder(String.valueOf(lowerCase).length() + 1 + String.valueOf(lowerCase2).length());
        sb.append(lowerCase);
        sb.append("-");
        sb.append(lowerCase2);
        this.f13888d = sb.toString();
        return false;
    }

    public final long q() {
        l();
        return this.f13887c;
    }

    public final String r() {
        l();
        return this.f13888d;
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzbr zzgs() {
        return super.zzgs();
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzn zzgw() {
        return super.zzgw();
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ Clock a() {
        return super.a();
    }
}
