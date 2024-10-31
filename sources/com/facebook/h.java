package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequest;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestProgress.java */
/* loaded from: classes.dex */
public class H {

    /* renamed from: a, reason: collision with root package name */
    private final GraphRequest f9144a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f9145b;

    /* renamed from: c, reason: collision with root package name */
    private final long f9146c = FacebookSdk.getOnProgressThreshold();

    /* renamed from: d, reason: collision with root package name */
    private long f9147d;

    /* renamed from: e, reason: collision with root package name */
    private long f9148e;

    /* renamed from: f, reason: collision with root package name */
    private long f9149f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public H(Handler handler, GraphRequest graphRequest) {
        this.f9144a = graphRequest;
        this.f9145b = handler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        this.f9147d += j;
        long j2 = this.f9147d;
        if (j2 >= this.f9148e + this.f9146c || j2 >= this.f9149f) {
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(long j) {
        this.f9149f += j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.f9147d > this.f9148e) {
            GraphRequest.Callback callback = this.f9144a.getCallback();
            long j = this.f9149f;
            if (j <= 0 || !(callback instanceof GraphRequest.OnProgressCallback)) {
                return;
            }
            long j2 = this.f9147d;
            GraphRequest.OnProgressCallback onProgressCallback = (GraphRequest.OnProgressCallback) callback;
            Handler handler = this.f9145b;
            if (handler == null) {
                onProgressCallback.onProgress(j2, j);
            } else {
                handler.post(new G(this, onProgressCallback, j2, j));
            }
            this.f9148e = this.f9147d;
        }
    }
}
