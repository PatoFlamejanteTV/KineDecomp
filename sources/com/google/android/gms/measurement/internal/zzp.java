package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;

/* loaded from: classes.dex */
public class zzp extends ac {

    /* renamed from: a, reason: collision with root package name */
    private final String f2062a;
    private final char b;
    private final long c;
    private final zza d;
    private final zza e;
    private final zza f;
    private final zza h;
    private final zza i;
    private final zza j;
    private final zza k;
    private final zza l;
    private final zza m;

    /* loaded from: classes.dex */
    public class zza {
        private final int b;
        private final boolean c;
        private final boolean d;

        zza(int i, boolean z, boolean z2) {
            this.b = i;
            this.c = z;
            this.d = z2;
        }

        public void a(String str) {
            zzp.this.a(this.b, this.c, this.d, str, null, null, null);
        }

        public void a(String str, Object obj) {
            zzp.this.a(this.b, this.c, this.d, str, obj, null, null);
        }

        public void a(String str, Object obj, Object obj2) {
            zzp.this.a(this.b, this.c, this.d, str, obj, obj2, null);
        }

        public void a(String str, Object obj, Object obj2, Object obj3) {
            zzp.this.a(this.b, this.c, this.d, str, obj, obj2, obj3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzp(zzv zzvVar) {
        super(zzvVar);
        this.f2062a = n().a();
        this.c = n().y();
        if (n().A()) {
            this.b = n().z() ? 'P' : 'C';
        } else {
            this.b = n().z() ? 'p' : 'c';
        }
        this.d = new zza(6, false, false);
        this.e = new zza(6, true, false);
        this.f = new zza(6, false, true);
        this.h = new zza(5, false, false);
        this.i = new zza(5, true, false);
        this.j = new zza(5, false, true);
        this.k = new zza(4, false, false);
        this.l = new zza(3, false, false);
        this.m = new zza(2, false, false);
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf != -1 ? str.substring(0, lastIndexOf) : str;
    }

    static String a(boolean z, Object obj) {
        String className;
        if (obj == null) {
            return "";
        }
        Object valueOf = obj instanceof Integer ? Long.valueOf(((Integer) obj).intValue()) : obj;
        if (valueOf instanceof Long) {
            if (z && Math.abs(((Long) valueOf).longValue()) >= 100) {
                String str = String.valueOf(valueOf).charAt(0) == '-' ? "-" : "";
                String valueOf2 = String.valueOf(Math.abs(((Long) valueOf).longValue()));
                return str + Math.round(Math.pow(10.0d, valueOf2.length() - 1)) + "..." + str + Math.round(Math.pow(10.0d, valueOf2.length()) - 1.0d);
            }
            return String.valueOf(valueOf);
        }
        if (valueOf instanceof Boolean) {
            return String.valueOf(valueOf);
        }
        if (!(valueOf instanceof Throwable)) {
            return z ? "-" : String.valueOf(valueOf);
        }
        Throwable th = (Throwable) valueOf;
        StringBuilder sb = new StringBuilder(th.toString());
        String a2 = a(com.google.android.gms.measurement.zza.class.getCanonicalName());
        String a3 = a(zzv.class.getCanonicalName());
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null) {
                String a4 = a(className);
                if (a4.equals(a2) || a4.equals(a3)) {
                    sb.append(": ");
                    sb.append(stackTraceElement);
                    break;
                }
            }
        }
        return sb.toString();
    }

    static String a(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            str = "";
        }
        String a2 = a(z, obj);
        String a3 = a(z, obj2);
        String a4 = a(z, obj3);
        StringBuilder sb = new StringBuilder();
        String str2 = "";
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

    @Override // com.google.android.gms.measurement.internal.ac
    protected void a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, String str) {
        Log.println(i, this.f2062a, str);
    }

    public void a(int i, String str, Object obj, Object obj2, Object obj3) {
        zzx.a(str);
        zzu h = this.g.h();
        if (h == null || !h.v() || h.w()) {
            a(6, "Scheduler not initialized or shutdown. Not logging error/warn.");
            return;
        }
        if (i < 0) {
            i = 0;
        }
        if (i >= "01VDIWEA?".length()) {
            i = "01VDIWEA?".length() - 1;
        }
        String str2 = AppEventsConstants.EVENT_PARAM_VALUE_YES + "01VDIWEA?".charAt(i) + this.b + this.c + ":" + a(true, str, obj, obj2, obj3);
        h.a(new r(this, str2.length() > 1024 ? str.substring(0, 1024) : str2));
    }

    protected void a(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && a(i)) {
            a(i, a(false, str, obj, obj2, obj3));
        }
        if (z2 || i < 5) {
            return;
        }
        a(i, str, obj, obj2, obj3);
    }

    protected boolean a(int i) {
        return Log.isLoggable(this.f2062a, i);
    }

    public zza b() {
        return this.d;
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ void e() {
        super.e();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzn f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzab g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzmn h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ Context i() {
        return super.i();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzag j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzu k() {
        return super.k();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzp l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzs m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzc n() {
        return super.n();
    }

    public zza o() {
        return this.h;
    }

    public zza p() {
        return this.i;
    }

    public zza q() {
        return this.j;
    }

    public zza r() {
        return this.k;
    }

    public zza s() {
        return this.l;
    }

    public zza t() {
        return this.m;
    }

    public String u() {
        Pair<String, Long> a2 = m().b.a();
        if (a2 == null) {
            return null;
        }
        return String.valueOf(a2.second) + ":" + ((String) a2.first);
    }
}
