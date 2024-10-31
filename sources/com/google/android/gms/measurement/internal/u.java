package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class U implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f13694a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f13695b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ long f13696c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ Bundle f13697d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ boolean f13698e;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ boolean f13699f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ boolean f13700g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ String f13701h;
    private final /* synthetic */ zzda i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public U(zzda zzdaVar, String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        this.i = zzdaVar;
        this.f13694a = str;
        this.f13695b = str2;
        this.f13696c = j;
        this.f13697d = bundle;
        this.f13698e = z;
        this.f13699f = z2;
        this.f13700g = z3;
        this.f13701h = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.i.a(this.f13694a, this.f13695b, this.f13696c, this.f13697d, this.f13698e, this.f13699f, this.f13700g, this.f13701h);
    }
}
