package com.google.android.gms.tagmanager;

import android.os.Looper;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* loaded from: classes2.dex */
public final class F implements ContainerHolder {

    /* renamed from: a, reason: collision with root package name */
    private final Looper f14173a = null;

    /* renamed from: b, reason: collision with root package name */
    private Container f14174b;

    /* renamed from: c, reason: collision with root package name */
    private Container f14175c;

    /* renamed from: d, reason: collision with root package name */
    private Status f14176d;

    /* renamed from: e, reason: collision with root package name */
    private G f14177e;

    /* renamed from: f, reason: collision with root package name */
    private zzw f14178f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f14179g;

    /* renamed from: h, reason: collision with root package name */
    private TagManager f14180h;

    public F(Status status) {
        this.f14176d = status;
    }

    public final synchronized void a(String str) {
        if (this.f14179g) {
            return;
        }
        this.f14174b.a(str);
    }

    public final synchronized void b() {
        if (this.f14179g) {
            zzdi.c("Refreshing a released ContainerHolder.");
        } else {
            this.f14178f.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String c() {
        if (this.f14179g) {
            zzdi.c("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
            return "";
        }
        return this.f14178f.a();
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f14176d;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final synchronized void release() {
        if (this.f14179g) {
            zzdi.c("Releasing a released ContainerHolder.");
            return;
        }
        this.f14179g = true;
        this.f14180h.a(this);
        this.f14174b.b();
        this.f14174b = null;
        this.f14175c = null;
        this.f14178f = null;
        this.f14177e = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a() {
        if (this.f14179g) {
            zzdi.c("getContainerId called on a released ContainerHolder.");
            return "";
        }
        return this.f14174b.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(String str) {
        if (this.f14179g) {
            zzdi.c("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        } else {
            this.f14178f.a(str);
        }
    }
}
