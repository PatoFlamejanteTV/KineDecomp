package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Sa {
    private boolean A;
    private long B;
    private long C;

    /* renamed from: a, reason: collision with root package name */
    private final zzbw f13685a;

    /* renamed from: b, reason: collision with root package name */
    private final String f13686b;

    /* renamed from: c, reason: collision with root package name */
    private String f13687c;

    /* renamed from: d, reason: collision with root package name */
    private String f13688d;

    /* renamed from: e, reason: collision with root package name */
    private String f13689e;

    /* renamed from: f, reason: collision with root package name */
    private String f13690f;

    /* renamed from: g, reason: collision with root package name */
    private long f13691g;

    /* renamed from: h, reason: collision with root package name */
    private long f13692h;
    private long i;
    private String j;
    private long k;
    private String l;
    private long m;
    private long n;
    private boolean o;
    private long p;
    private boolean q;
    private boolean r;
    private String s;
    private long t;
    private long u;
    private long v;
    private long w;
    private long x;
    private long y;
    private String z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Sa(zzbw zzbwVar, String str) {
        Preconditions.a(zzbwVar);
        Preconditions.b(str);
        this.f13685a = zzbwVar;
        this.f13686b = str;
        this.f13685a.zzgs().c();
    }

    public final String A() {
        this.f13685a.zzgs().c();
        String str = this.z;
        h((String) null);
        return str;
    }

    public final long B() {
        this.f13685a.zzgs().c();
        return this.p;
    }

    public final boolean C() {
        this.f13685a.zzgs().c();
        return this.q;
    }

    public final boolean D() {
        this.f13685a.zzgs().c();
        return this.r;
    }

    public final String a() {
        this.f13685a.zzgs().c();
        return this.f13687c;
    }

    public final void b(String str) {
        this.f13685a.zzgs().c();
        this.A |= !zzfy.d(this.f13687c, str);
        this.f13687c = str;
    }

    public final String c() {
        this.f13685a.zzgs().c();
        return this.f13688d;
    }

    public final void d(String str) {
        this.f13685a.zzgs().c();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.A |= !zzfy.d(this.s, str);
        this.s = str;
    }

    public final void e(String str) {
        this.f13685a.zzgs().c();
        this.A |= !zzfy.d(this.f13689e, str);
        this.f13689e = str;
    }

    public final String f() {
        this.f13685a.zzgs().c();
        return this.f13686b;
    }

    public final void g() {
        this.f13685a.zzgs().c();
        this.A = false;
    }

    public final String h() {
        this.f13685a.zzgs().c();
        return this.s;
    }

    public final String i() {
        this.f13685a.zzgs().c();
        return this.f13689e;
    }

    public final long j() {
        this.f13685a.zzgs().c();
        return this.f13692h;
    }

    public final long k() {
        this.f13685a.zzgs().c();
        return this.i;
    }

    public final long l() {
        this.f13685a.zzgs().c();
        return this.k;
    }

    public final String m() {
        this.f13685a.zzgs().c();
        return this.l;
    }

    public final long n() {
        this.f13685a.zzgs().c();
        return this.m;
    }

    public final long o() {
        this.f13685a.zzgs().c();
        return this.n;
    }

    public final long p() {
        this.f13685a.zzgs().c();
        return this.f13691g;
    }

    public final long q() {
        this.f13685a.zzgs().c();
        return this.B;
    }

    public final long r() {
        this.f13685a.zzgs().c();
        return this.C;
    }

    public final void s() {
        this.f13685a.zzgs().c();
        long j = this.f13691g + 1;
        if (j > 2147483647L) {
            this.f13685a.b().t().a("Bundle index overflow. appId", zzas.a(this.f13686b));
            j = 0;
        }
        this.A = true;
        this.f13691g = j;
    }

    public final long t() {
        this.f13685a.zzgs().c();
        return this.t;
    }

    public final long u() {
        this.f13685a.zzgs().c();
        return this.u;
    }

    public final long v() {
        this.f13685a.zzgs().c();
        return this.v;
    }

    public final long w() {
        this.f13685a.zzgs().c();
        return this.w;
    }

    public final long x() {
        this.f13685a.zzgs().c();
        return this.y;
    }

    public final long y() {
        this.f13685a.zzgs().c();
        return this.x;
    }

    public final String z() {
        this.f13685a.zzgs().c();
        return this.z;
    }

    public final void a(String str) {
        this.f13685a.zzgs().c();
        this.A |= !zzfy.d(this.j, str);
        this.j = str;
    }

    public final void c(String str) {
        this.f13685a.zzgs().c();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.A |= !zzfy.d(this.f13688d, str);
        this.f13688d = str;
    }

    public final void f(String str) {
        this.f13685a.zzgs().c();
        this.A |= !zzfy.d(this.f13690f, str);
        this.f13690f = str;
    }

    public final void g(String str) {
        this.f13685a.zzgs().c();
        this.A |= !zzfy.d(this.l, str);
        this.l = str;
    }

    public final void h(long j) {
        this.f13685a.zzgs().c();
        this.A |= this.n != j;
        this.n = j;
    }

    public final void i(long j) {
        Preconditions.a(j >= 0);
        this.f13685a.zzgs().c();
        this.A = (this.f13691g != j) | this.A;
        this.f13691g = j;
    }

    public final void j(long j) {
        this.f13685a.zzgs().c();
        this.A |= this.B != j;
        this.B = j;
    }

    public final void k(long j) {
        this.f13685a.zzgs().c();
        this.A |= this.C != j;
        this.C = j;
    }

    public final void l(long j) {
        this.f13685a.zzgs().c();
        this.A |= this.t != j;
        this.t = j;
    }

    public final void m(long j) {
        this.f13685a.zzgs().c();
        this.A |= this.u != j;
        this.u = j;
    }

    public final void n(long j) {
        this.f13685a.zzgs().c();
        this.A |= this.v != j;
        this.v = j;
    }

    public final void o(long j) {
        this.f13685a.zzgs().c();
        this.A |= this.w != j;
        this.w = j;
    }

    public final String b() {
        this.f13685a.zzgs().c();
        return this.f13690f;
    }

    public final void e(long j) {
        this.f13685a.zzgs().c();
        this.A |= this.i != j;
        this.i = j;
    }

    public final void d(long j) {
        this.f13685a.zzgs().c();
        this.A |= this.f13692h != j;
        this.f13692h = j;
    }

    public final void a(boolean z) {
        this.f13685a.zzgs().c();
        this.A |= this.o != z;
        this.o = z;
    }

    public final void b(long j) {
        this.f13685a.zzgs().c();
        this.A |= this.x != j;
        this.x = j;
    }

    public final void f(long j) {
        this.f13685a.zzgs().c();
        this.A |= this.k != j;
        this.k = j;
    }

    public final void g(long j) {
        this.f13685a.zzgs().c();
        this.A |= this.m != j;
        this.m = j;
    }

    public final void h(String str) {
        this.f13685a.zzgs().c();
        this.A |= !zzfy.d(this.z, str);
        this.z = str;
    }

    public final void c(long j) {
        this.f13685a.zzgs().c();
        this.A |= this.p != j;
        this.p = j;
    }

    public final String e() {
        this.f13685a.zzgs().c();
        return this.j;
    }

    public final boolean d() {
        this.f13685a.zzgs().c();
        return this.o;
    }

    public final void a(long j) {
        this.f13685a.zzgs().c();
        this.A |= this.y != j;
        this.y = j;
    }

    public final void b(boolean z) {
        this.f13685a.zzgs().c();
        this.A = this.q != z;
        this.q = z;
    }

    public final void c(boolean z) {
        this.f13685a.zzgs().c();
        this.A = this.r != z;
        this.r = z;
    }
}
