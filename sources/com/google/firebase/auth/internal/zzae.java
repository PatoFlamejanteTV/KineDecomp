package com.google.firebase.auth.internal;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.firebase.FirebaseApp;

/* loaded from: classes2.dex */
public final class zzae implements FirebaseApp.IdTokenListenersCountChangedListener {

    /* renamed from: a */
    private volatile int f16510a;

    /* renamed from: b */
    private volatile int f16511b;

    /* renamed from: c */
    private final zzs f16512c;

    /* renamed from: d */
    private volatile boolean f16513d;

    public zzae(FirebaseApp firebaseApp) {
        this(firebaseApp.b(), new zzs(firebaseApp));
    }

    public final boolean b() {
        return this.f16510a + this.f16511b > 0 && !this.f16513d;
    }

    @Override // com.google.firebase.FirebaseApp.IdTokenListenersCountChangedListener
    public final void a(int i) {
        if (i > 0 && this.f16510a == 0 && this.f16511b == 0) {
            this.f16510a = i;
            if (b()) {
                this.f16512c.b();
            }
        } else if (i == 0 && this.f16510a != 0 && this.f16511b == 0) {
            this.f16512c.a();
        }
        this.f16510a = i;
    }

    @VisibleForTesting
    private zzae(Context context, zzs zzsVar) {
        this.f16513d = false;
        this.f16510a = 0;
        this.f16511b = 0;
        this.f16512c = zzsVar;
        BackgroundDetector.a((Application) context.getApplicationContext());
        BackgroundDetector.a().a(new b(this));
    }

    public final void a(zzcz zzczVar) {
        if (zzczVar == null) {
            return;
        }
        long zzs = zzczVar.zzs();
        if (zzs <= 0) {
            zzs = 3600;
        }
        long zzdy = zzczVar.zzdy() + (zzs * 1000);
        zzs zzsVar = this.f16512c;
        zzsVar.f16546c = zzdy;
        zzsVar.f16547d = -1L;
        if (b()) {
            this.f16512c.b();
        }
    }

    public final void a() {
        this.f16512c.a();
    }
}
