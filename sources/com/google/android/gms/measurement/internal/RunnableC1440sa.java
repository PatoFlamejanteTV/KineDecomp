package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.measurement.internal.sa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1440sa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f13843a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f13844b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ String f13845c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ String f13846d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ boolean f13847e;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzk f13848f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzeb f13849g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1440sa(zzeb zzebVar, AtomicReference atomicReference, String str, String str2, String str3, boolean z, zzk zzkVar) {
        this.f13849g = zzebVar;
        this.f13843a = atomicReference;
        this.f13844b = str;
        this.f13845c = str2;
        this.f13846d = str3;
        this.f13847e = z;
        this.f13848f = zzkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaj zzajVar;
        synchronized (this.f13843a) {
            try {
                try {
                    zzajVar = this.f13849g.f14019d;
                } finally {
                    this.f13843a.notify();
                }
            } catch (RemoteException e2) {
                this.f13849g.b().q().a("Failed to get user properties", zzas.a(this.f13844b), this.f13845c, e2);
                this.f13843a.set(Collections.emptyList());
            }
            if (zzajVar == null) {
                this.f13849g.b().q().a("Failed to get user properties", zzas.a(this.f13844b), this.f13845c, this.f13846d);
                this.f13843a.set(Collections.emptyList());
                return;
            }
            if (TextUtils.isEmpty(this.f13844b)) {
                this.f13843a.set(zzajVar.a(this.f13845c, this.f13846d, this.f13847e, this.f13848f));
            } else {
                this.f13843a.set(zzajVar.a(this.f13844b, this.f13845c, this.f13846d, this.f13847e));
            }
            this.f13849g.E();
            this.f13843a.notify();
        }
    }
}
