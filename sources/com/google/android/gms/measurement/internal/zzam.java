package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;

/* loaded from: classes2.dex */
public final class zzam extends Aa {

    /* renamed from: c, reason: collision with root package name */
    private String f13914c;

    /* renamed from: d, reason: collision with root package name */
    private String f13915d;

    /* renamed from: e, reason: collision with root package name */
    private int f13916e;

    /* renamed from: f, reason: collision with root package name */
    private String f13917f;

    /* renamed from: g, reason: collision with root package name */
    private String f13918g;

    /* renamed from: h, reason: collision with root package name */
    private long f13919h;
    private long i;
    private int j;
    private String k;
    private String l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzam(zzbw zzbwVar) {
        super(zzbwVar);
    }

    @VisibleForTesting
    private final String D() {
        try {
            Class<?> loadClass = getContext().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            if (loadClass == null) {
                return null;
            }
            try {
                Object invoke = loadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, getContext());
                if (invoke == null) {
                    return null;
                }
                try {
                    return (String) loadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(invoke, new Object[0]);
                } catch (Exception unused) {
                    b().v().a("Failed to retrieve Firebase Instance Id");
                    return null;
                }
            } catch (Exception unused2) {
                b().u().a("Failed to obtain Firebase Analytics instance");
                return null;
            }
        } catch (ClassNotFoundException unused3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String A() {
        t();
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int B() {
        t();
        return this.f13916e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int C() {
        t();
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzk a(String str) {
        c();
        d();
        String z = z();
        String y = y();
        t();
        String str2 = this.f13915d;
        long B = B();
        t();
        String str3 = this.f13917f;
        long l = j().l();
        t();
        c();
        if (this.f13919h == 0) {
            this.f13919h = this.f13672a.p().a(getContext(), getContext().getPackageName());
        }
        long j = this.f13919h;
        boolean c2 = this.f13672a.c();
        boolean z2 = !i().v;
        c();
        d();
        String D = (!j().h(this.f13914c) || this.f13672a.c()) ? D() : null;
        t();
        long j2 = this.i;
        long C = this.f13672a.C();
        int C2 = C();
        zzq j3 = j();
        j3.d();
        Boolean b2 = j3.b("google_analytics_adid_collection_enabled");
        boolean booleanValue = Boolean.valueOf(b2 == null || b2.booleanValue()).booleanValue();
        zzq j4 = j();
        j4.d();
        Boolean b3 = j4.b("google_analytics_ssaid_collection_enabled");
        return new zzk(z, y, str2, B, str3, l, j, str, c2, z2, D, j2, C, C2, booleanValue, Boolean.valueOf(b3 == null || b3.booleanValue()).booleanValue(), i().w(), A());
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzas b() {
        return super.b();
    }

    @Override // com.google.android.gms.measurement.internal.C1417ga, com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.C1417ga, com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ void d() {
        super.d();
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

    @Override // com.google.android.gms.measurement.internal.Aa
    protected final boolean v() {
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(23:1|(1:3)(6:65|66|(1:68)(2:83|(1:85))|69|70|(22:72|(1:74)(1:81)|75|76|5|(1:64)(1:9)|10|(1:63)(1:14)|15|(1:(1:18)(1:19))|(2:21|(2:23|(1:25))(1:(1:(11:36|37|(1:41)|42|43|(1:45)(1:59)|46|(1:48)|(1:50)|52|(2:54|55)(2:57|58))(1:35))(2:29|(1:31))))|62|37|(2:39|41)|42|43|(0)(0)|46|(0)|(0)|52|(0)(0)))|4|5|(1:7)|64|10|(1:12)|63|15|(0)|(0)|62|37|(0)|42|43|(0)(0)|46|(0)|(0)|52|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01ce, code lost:            r1 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01cf, code lost:            b().q().a("getGoogleAppId or isMeasurementEnabled failed with exception. appId", com.google.android.gms.measurement.internal.zzas.a(r0), r1);     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01a9 A[Catch: IllegalStateException -> 0x01ce, TryCatch #0 {IllegalStateException -> 0x01ce, blocks: (B:43:0x0195, B:46:0x01a1, B:48:0x01a9, B:50:0x01bc), top: B:42:0x0195 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01bc A[Catch: IllegalStateException -> 0x01ce, TRY_LEAVE, TryCatch #0 {IllegalStateException -> 0x01ce, blocks: (B:43:0x0195, B:46:0x01a1, B:48:0x01a9, B:50:0x01bc), top: B:42:0x0195 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00ad  */
    @Override // com.google.android.gms.measurement.internal.Aa
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void w() {
        /*
            Method dump skipped, instructions count: 500
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.w():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String y() {
        t();
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String z() {
        t();
        return this.f13914c;
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
