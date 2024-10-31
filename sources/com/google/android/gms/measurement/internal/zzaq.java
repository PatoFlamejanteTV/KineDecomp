package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class zzaq extends P {

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicReference<String[]> f13929c = new AtomicReference<>();

    /* renamed from: d, reason: collision with root package name */
    private static final AtomicReference<String[]> f13930d = new AtomicReference<>();

    /* renamed from: e, reason: collision with root package name */
    private static final AtomicReference<String[]> f13931e = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaq(zzbw zzbwVar) {
        super(zzbwVar);
    }

    private final boolean q() {
        zzgw();
        return this.f13672a.w() && this.f13672a.b().a(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String a(String str) {
        if (str == null) {
            return null;
        }
        return !q() ? str : a(str, zzcu.f13990b, zzcu.f13989a, f13929c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String b(String str) {
        if (str == null) {
            return null;
        }
        return !q() ? str : a(str, zzcv.f13992b, zzcv.f13991a, f13930d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String c(String str) {
        if (str == null) {
            return null;
        }
        if (!q()) {
            return str;
        }
        if (str.startsWith("_exp_")) {
            return "experiment_id(" + str + ")";
        }
        return a(str, zzcw.f13994b, zzcw.f13993a, f13931e);
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
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzbr zzgs() {
        return super.zzgs();
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzn zzgw() {
        return super.zzgw();
    }

    private static String a(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        String str2;
        Preconditions.a(strArr);
        Preconditions.a(strArr2);
        Preconditions.a(atomicReference);
        Preconditions.a(strArr.length == strArr2.length);
        for (int i = 0; i < strArr.length; i++) {
            if (zzfy.d(str, strArr[i])) {
                synchronized (atomicReference) {
                    String[] strArr3 = atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i] == null) {
                        strArr3[i] = strArr2[i] + "(" + strArr[i] + ")";
                    }
                    str2 = strArr3[i];
                }
                return str2;
            }
        }
        return str;
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzas b() {
        return super.b();
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String a(zzag zzagVar) {
        if (zzagVar == null) {
            return null;
        }
        if (!q()) {
            return zzagVar.toString();
        }
        return "origin=" + zzagVar.f13899c + ",name=" + a(zzagVar.f13897a) + ",params=" + a(zzagVar.f13898b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String a(zzab zzabVar) {
        if (zzabVar == null) {
            return null;
        }
        if (!q()) {
            return zzabVar.toString();
        }
        return "Event{appId='" + zzabVar.f13890a + "', name='" + a(zzabVar.f13891b) + "', params=" + a(zzabVar.f13895f) + "}";
    }

    private final String a(zzad zzadVar) {
        if (zzadVar == null) {
            return null;
        }
        if (!q()) {
            return zzadVar.toString();
        }
        return a(zzadVar.a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!q()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        for (String str : bundle.keySet()) {
            if (sb.length() != 0) {
                sb.append(", ");
            } else {
                sb.append("Bundle[{");
            }
            sb.append(b(str));
            sb.append("=");
            sb.append(bundle.get(str));
        }
        sb.append("}]");
        return sb.toString();
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ Clock a() {
        return super.a();
    }
}
