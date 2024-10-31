package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.measurement.internal.ea, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1413ea extends La {
    public C1413ea(zzfo zzfoVar) {
        super(zzfoVar);
    }

    private static String b(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }

    public final byte[] a(zzag zzagVar, String str) {
        Sa b2;
        c();
        this.f13672a.e();
        Preconditions.a(zzagVar);
        Preconditions.b(str);
        if (!j().d(str, zzai.za)) {
            b().x().a("Generating ScionPayload disabled. packageName", str);
            return new byte[0];
        }
        if (!"_iap".equals(zzagVar.f13897a) && !"_iapx".equals(zzagVar.f13897a)) {
            b().x().a("Generating a payload for this event is not available. package_name, event_name", str, zzagVar.f13897a);
            return null;
        }
        com.google.android.gms.internal.measurement.zzfv zzfvVar = new com.google.android.gms.internal.measurement.zzfv();
        m().r();
        try {
            b2 = m().b(str);
        } catch (SecurityException e2) {
            b().x().a("Resettable device id encryption failed", e2.getMessage());
            return new byte[0];
        } catch (SecurityException e3) {
            b().x().a("app instance id encryption failed", e3.getMessage());
            return new byte[0];
        } finally {
        }
        if (b2 == null) {
            b().x().a("Log and bundle not available. package_name", str);
            return new byte[0];
        }
        if (!b2.d()) {
            b().x().a("Log and bundle disabled. package_name", str);
            return new byte[0];
        }
        com.google.android.gms.internal.measurement.zzfw zzfwVar = new com.google.android.gms.internal.measurement.zzfw();
        zzfvVar.zzaxf = new com.google.android.gms.internal.measurement.zzfw[]{zzfwVar};
        zzfwVar.zzaxh = 1;
        zzfwVar.zzaxp = "android";
        zzfwVar.zztt = b2.f();
        zzfwVar.zzafp = b2.m();
        zzfwVar.zzts = b2.e();
        long l = b2.l();
        zzfwVar.zzayb = l == -2147483648L ? null : Integer.valueOf((int) l);
        zzfwVar.zzaxt = Long.valueOf(b2.n());
        zzfwVar.zzafi = b2.c();
        if (TextUtils.isEmpty(zzfwVar.zzafi)) {
            zzfwVar.zzawp = b2.h();
        }
        zzfwVar.zzaxx = Long.valueOf(b2.o());
        if (this.f13672a.c() && zzq.s() && j().c(zzfwVar.zztt)) {
            zzfwVar.zzayh = null;
        }
        Pair<String, Boolean> a2 = i().a(b2.f());
        if (b2.C() && a2 != null && !TextUtils.isEmpty((CharSequence) a2.first)) {
            b((String) a2.first, Long.toString(zzagVar.f13900d));
            throw null;
        }
        f().l();
        zzfwVar.zzaxr = Build.MODEL;
        f().l();
        zzfwVar.zzaxq = Build.VERSION.RELEASE;
        zzfwVar.zzaxs = Integer.valueOf((int) f().q());
        zzfwVar.zzahr = f().r();
        b(b2.a(), Long.toString(zzagVar.f13900d));
        throw null;
        m().s();
    }

    @Override // com.google.android.gms.measurement.internal.La
    protected final boolean p() {
        return false;
    }
}
