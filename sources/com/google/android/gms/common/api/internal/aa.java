package com.google.android.gms.common.api.internal;

import android.os.Bundle;

/* loaded from: classes.dex */
final class aa implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ LifecycleCallback f10820a;

    /* renamed from: b */
    private final /* synthetic */ String f10821b;

    /* renamed from: c */
    private final /* synthetic */ zza f10822c;

    public aa(zza zzaVar, LifecycleCallback lifecycleCallback, String str) {
        this.f10822c = zzaVar;
        this.f10820a = lifecycleCallback;
        this.f10821b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        i = this.f10822c.f10970c;
        if (i > 0) {
            LifecycleCallback lifecycleCallback = this.f10820a;
            bundle = this.f10822c.f10971d;
            if (bundle != null) {
                bundle3 = this.f10822c.f10971d;
                bundle2 = bundle3.getBundle(this.f10821b);
            } else {
                bundle2 = null;
            }
            lifecycleCallback.a(bundle2);
        }
        i2 = this.f10822c.f10970c;
        if (i2 >= 2) {
            this.f10820a.d();
        }
        i3 = this.f10822c.f10970c;
        if (i3 >= 3) {
            this.f10820a.c();
        }
        i4 = this.f10822c.f10970c;
        if (i4 >= 4) {
            this.f10820a.e();
        }
        i5 = this.f10822c.f10970c;
        if (i5 >= 5) {
            this.f10820a.b();
        }
    }
}
