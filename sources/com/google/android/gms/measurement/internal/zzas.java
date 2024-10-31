package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;

/* loaded from: classes2.dex */
public final class zzas extends P {

    /* renamed from: c */
    private char f13932c;

    /* renamed from: d */
    private long f13933d;

    /* renamed from: e */
    private String f13934e;

    /* renamed from: f */
    private final zzau f13935f;

    /* renamed from: g */
    private final zzau f13936g;

    /* renamed from: h */
    private final zzau f13937h;
    private final zzau i;
    private final zzau j;
    private final zzau k;
    private final zzau l;
    private final zzau m;
    private final zzau n;

    public zzas(zzbw zzbwVar) {
        super(zzbwVar);
        this.f13932c = (char) 0;
        this.f13933d = -1L;
        this.f13935f = new zzau(this, 6, false, false);
        this.f13936g = new zzau(this, 6, true, false);
        this.f13937h = new zzau(this, 6, false, true);
        this.i = new zzau(this, 5, false, false);
        this.j = new zzau(this, 5, true, false);
        this.k = new zzau(this, 5, false, true);
        this.l = new zzau(this, 4, false, false);
        this.m = new zzau(this, 3, false, false);
        this.n = new zzau(this, 2, false, false);
    }

    @VisibleForTesting
    private final String A() {
        String str;
        synchronized (this) {
            if (this.f13934e == null) {
                if (this.f13672a.z() != null) {
                    this.f13934e = this.f13672a.z();
                } else {
                    this.f13934e = zzq.m();
                }
            }
            str = this.f13934e;
        }
        return str;
    }

    public static Object a(String str) {
        if (str == null) {
            return null;
        }
        return new C1412e(str);
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? str : str.substring(0, lastIndexOf);
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
        return false;
    }

    public final zzau q() {
        return this.f13935f;
    }

    public final zzau r() {
        return this.f13936g;
    }

    public final zzau s() {
        return this.f13937h;
    }

    public final zzau t() {
        return this.i;
    }

    public final zzau u() {
        return this.j;
    }

    public final zzau v() {
        return this.k;
    }

    public final zzau w() {
        return this.l;
    }

    public final zzau x() {
        return this.m;
    }

    public final zzau y() {
        return this.n;
    }

    public final String z() {
        Pair<String, Long> a2 = i().f13799e.a();
        if (a2 == null || a2 == C1428m.f13797c) {
            return null;
        }
        String valueOf = String.valueOf(a2.second);
        String str = (String) a2.first;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(str).length());
        sb.append(valueOf);
        sb.append(":");
        sb.append(str);
        return sb.toString();
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzbr zzgs() {
        return super.zzgs();
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzn zzgw() {
        return super.zzgw();
    }

    public final void a(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && a(i)) {
            a(i, a(false, str, obj, obj2, obj3));
        }
        if (z2 || i < 5) {
            return;
        }
        Preconditions.a(str);
        zzbr u = this.f13672a.u();
        if (u == null) {
            a(6, "Scheduler not set. Not logging error/warn");
        } else {
            if (!u.k()) {
                a(6, "Scheduler not initialized. Not logging error/warn");
                return;
            }
            if (i < 0) {
                i = 0;
            }
            u.a(new RunnableC1410d(this, i >= 9 ? 8 : i, str, obj, obj2, obj3));
        }
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzas b() {
        return super.b();
    }

    @VisibleForTesting
    public final boolean a(int i) {
        return Log.isLoggable(A(), i);
    }

    @VisibleForTesting
    public final void a(int i, String str) {
        Log.println(i, A(), str);
    }

    public static String a(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String a2 = a(z, obj);
        String a3 = a(z, obj2);
        String a4 = a(z, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(a2)) {
            sb.append(str2);
            sb.append(a2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a3)) {
            sb.append(str2);
            sb.append(a3);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a4)) {
            sb.append(str2);
            sb.append(a4);
        }
        return sb.toString();
    }

    @VisibleForTesting
    private static String a(boolean z, Object obj) {
        String str;
        String className;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            if (!z) {
                return String.valueOf(obj);
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return String.valueOf(obj);
            }
            String str2 = String.valueOf(obj).charAt(0) == '-' ? "-" : "";
            String valueOf = String.valueOf(Math.abs(l.longValue()));
            long round = Math.round(Math.pow(10.0d, valueOf.length() - 1));
            long round2 = Math.round(Math.pow(10.0d, valueOf.length()) - 1.0d);
            StringBuilder sb = new StringBuilder(str2.length() + 43 + str2.length());
            sb.append(str2);
            sb.append(round);
            sb.append("...");
            sb.append(str2);
            sb.append(round2);
            return sb.toString();
        }
        if (obj instanceof Boolean) {
            return String.valueOf(obj);
        }
        if (obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            StringBuilder sb2 = new StringBuilder(z ? th.getClass().getName() : th.toString());
            String b2 = b(AppMeasurement.class.getCanonicalName());
            String b3 = b(zzbw.class.getCanonicalName());
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null) {
                    String b4 = b(className);
                    if (b4.equals(b2) || b4.equals(b3)) {
                        sb2.append(": ");
                        sb2.append(stackTraceElement);
                        break;
                    }
                }
            }
            return sb2.toString();
        }
        if (!(obj instanceof C1412e)) {
            return z ? "-" : String.valueOf(obj);
        }
        str = ((C1412e) obj).f13760a;
        return str;
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ Clock a() {
        return super.a();
    }
}
