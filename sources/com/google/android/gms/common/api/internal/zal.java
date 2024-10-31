package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zap;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class zal extends LifecycleCallback implements DialogInterface.OnCancelListener {

    /* renamed from: b */
    protected volatile boolean f10949b;

    /* renamed from: c */
    protected final AtomicReference<P> f10950c;

    /* renamed from: d */
    private final Handler f10951d;

    /* renamed from: e */
    protected final GoogleApiAvailability f10952e;

    public zal(LifecycleFragment lifecycleFragment) {
        this(lifecycleFragment, GoogleApiAvailability.a());
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void a(Bundle bundle) {
        super.a(bundle);
        if (bundle != null) {
            this.f10950c.set(bundle.getBoolean("resolving_error", false) ? new P(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    public abstract void a(ConnectionResult connectionResult, int i);

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void b(Bundle bundle) {
        super.b(bundle);
        P p = this.f10950c.get();
        if (p != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", p.b());
            bundle.putInt("failed_status", p.a().a());
            bundle.putParcelable("failed_resolution", p.a().P());
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void d() {
        super.d();
        this.f10949b = true;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void e() {
        super.e();
        this.f10949b = false;
    }

    protected abstract void f();

    public final void g() {
        this.f10950c.set(null);
        f();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        a(new ConnectionResult(13, null), a(this.f10950c.get()));
        g();
    }

    @VisibleForTesting
    private zal(LifecycleFragment lifecycleFragment, GoogleApiAvailability googleApiAvailability) {
        super(lifecycleFragment);
        this.f10950c = new AtomicReference<>(null);
        this.f10951d = new zap(Looper.getMainLooper());
        this.f10952e = googleApiAvailability;
    }

    public final void b(ConnectionResult connectionResult, int i) {
        P p = new P(connectionResult, i);
        if (this.f10950c.compareAndSet(null, p)) {
            this.f10951d.post(new Q(this, p));
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void a(int i, int i2, Intent intent) {
        P p = this.f10950c.get();
        if (i != 1) {
            if (i == 2) {
                int c2 = this.f10952e.c(a());
                r1 = c2 == 0;
                if (p == null) {
                    return;
                }
                if (p.a().a() == 18 && c2 == 18) {
                    return;
                }
            }
            r1 = false;
        } else if (i2 != -1) {
            if (i2 == 0) {
                P p2 = new P(new ConnectionResult(intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null), a(p));
                this.f10950c.set(p2);
                p = p2;
            }
            r1 = false;
        }
        if (r1) {
            g();
        } else if (p != null) {
            a(p.a(), p.b());
        }
    }

    private static int a(P p) {
        if (p == null) {
            return -1;
        }
        return p.b();
    }
}
