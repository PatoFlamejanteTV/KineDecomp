package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.internal.zzmn;

/* loaded from: classes.dex */
public class zzc {

    /* renamed from: a, reason: collision with root package name */
    private final zzf f738a;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzc(zzf zzfVar) {
        com.google.android.gms.common.internal.zzx.a(zzfVar);
        this.f738a = zzfVar;
    }

    private static String a(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Boolean) {
            return obj == Boolean.TRUE ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
        }
        return obj instanceof Throwable ? ((Throwable) obj).toString() : obj.toString();
    }

    private void a(int i, String str, Object obj, Object obj2, Object obj3) {
        zzaf g = this.f738a != null ? this.f738a.g() : null;
        if (g != null) {
            g.a(i, str, obj, obj2, obj3);
            return;
        }
        String a2 = zzy.c.a();
        if (Log.isLoggable(a2, i)) {
            Log.println(i, a2, c(str, obj, obj2, obj3));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String c(String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            str = "";
        }
        String a2 = a(obj);
        String a3 = a(obj2);
        String a4 = a(obj3);
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

    /* JADX INFO: Access modifiers changed from: protected */
    public zzu A() {
        return this.f738a.r();
    }

    public boolean B() {
        return Log.isLoggable(zzy.c.a(), 2);
    }

    public void a(String str, Object obj) {
        a(2, str, obj, null, null);
    }

    public void a(String str, Object obj, Object obj2) {
        a(2, str, obj, obj2, null);
    }

    public void a(String str, Object obj, Object obj2, Object obj3) {
        a(3, str, obj, obj2, obj3);
    }

    public void b(String str) {
        a(2, str, null, null, null);
    }

    public void b(String str, Object obj) {
        a(3, str, obj, null, null);
    }

    public void b(String str, Object obj, Object obj2) {
        a(3, str, obj, obj2, null);
    }

    public void b(String str, Object obj, Object obj2, Object obj3) {
        a(5, str, obj, obj2, obj3);
    }

    public void c(String str) {
        a(3, str, null, null, null);
    }

    public void c(String str, Object obj) {
        a(4, str, obj, null, null);
    }

    public void c(String str, Object obj, Object obj2) {
        a(5, str, obj, obj2, null);
    }

    public void d(String str) {
        a(4, str, null, null, null);
    }

    public void d(String str, Object obj) {
        a(5, str, obj, null, null);
    }

    public void d(String str, Object obj, Object obj2) {
        a(6, str, obj, obj2, null);
    }

    public void e(String str) {
        a(5, str, null, null, null);
    }

    public void e(String str, Object obj) {
        a(6, str, obj, null, null);
    }

    public void f(String str) {
        a(6, str, null, null, null);
    }

    public zzf k() {
        return this.f738a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        if (q().a()) {
            throw new IllegalStateException("Call only supported on the client side");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        this.f738a.s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzmn n() {
        return this.f738a.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context o() {
        return this.f738a.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzaf p() {
        return this.f738a.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzr q() {
        return this.f738a.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.google.android.gms.measurement.zzg r() {
        return this.f738a.h();
    }

    public GoogleAnalytics s() {
        return this.f738a.k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzb t() {
        return this.f738a.i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzv u() {
        return this.f738a.j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzan v() {
        return this.f738a.l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzai w() {
        return this.f738a.m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzn x() {
        return this.f738a.p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zza y() {
        return this.f738a.o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzk z() {
        return this.f738a.q();
    }
}
