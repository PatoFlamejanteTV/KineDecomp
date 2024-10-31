package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class zacm<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {

    /* renamed from: a, reason: collision with root package name */
    private ResultTransform<? super R, ? extends Result> f10916a;

    /* renamed from: b, reason: collision with root package name */
    private zacm<? extends Result> f10917b;

    /* renamed from: c, reason: collision with root package name */
    private volatile ResultCallbacks<? super R> f10918c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f10919d;

    /* renamed from: e, reason: collision with root package name */
    private Status f10920e;

    /* renamed from: f, reason: collision with root package name */
    private final WeakReference<GoogleApiClient> f10921f;

    /* renamed from: g, reason: collision with root package name */
    private final K f10922g;

    private final void a(Status status) {
        synchronized (this.f10919d) {
            this.f10920e = status;
            b(this.f10920e);
        }
    }

    private final void b(Status status) {
        synchronized (this.f10919d) {
            if (this.f10916a != null) {
                Status a2 = this.f10916a.a(status);
                Preconditions.a(a2, "onFailure must not return null");
                this.f10917b.a(a2);
            } else if (b()) {
                this.f10918c.a(status);
            }
        }
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final void onResult(R r) {
        synchronized (this.f10919d) {
            if (r.getStatus().Q()) {
                if (this.f10916a != null) {
                    zacc.a().submit(new J(this, r));
                } else if (b()) {
                    this.f10918c.a((ResultCallbacks<? super R>) r);
                }
            } else {
                a(r.getStatus());
                a(r);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.f10918c = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e2) {
                String valueOf = String.valueOf(result);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("TransformedResultImpl", sb.toString(), e2);
            }
        }
    }

    private final boolean b() {
        return (this.f10918c == null || this.f10921f.get() == null) ? false : true;
    }
}
