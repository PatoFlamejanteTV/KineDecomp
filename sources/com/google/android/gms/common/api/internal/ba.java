package com.google.android.gms.common.api.internal;

import android.os.Bundle;

/* loaded from: classes.dex */
final class ba implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ LifecycleCallback f10825a;

    /* renamed from: b */
    private final /* synthetic */ String f10826b;

    /* renamed from: c */
    private final /* synthetic */ zzc f10827c;

    public ba(zzc zzcVar, LifecycleCallback lifecycleCallback, String str) {
        this.f10827c = zzcVar;
        this.f10825a = lifecycleCallback;
        this.f10826b = str;
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
        i = this.f10827c.f10974c;
        if (i > 0) {
            LifecycleCallback lifecycleCallback = this.f10825a;
            bundle = this.f10827c.f10975d;
            if (bundle != null) {
                bundle3 = this.f10827c.f10975d;
                bundle2 = bundle3.getBundle(this.f10826b);
            } else {
                bundle2 = null;
            }
            lifecycleCallback.a(bundle2);
        }
        i2 = this.f10827c.f10974c;
        if (i2 >= 2) {
            this.f10825a.d();
        }
        i3 = this.f10827c.f10974c;
        if (i3 >= 3) {
            this.f10825a.c();
        }
        i4 = this.f10827c.f10974c;
        if (i4 >= 4) {
            this.f10825a.e();
        }
        i5 = this.f10827c.f10974c;
        if (i5 >= 5) {
            this.f10825a.b();
        }
    }
}
