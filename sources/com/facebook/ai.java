package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequest;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestProgress.java */
/* loaded from: classes.dex */
public class ai {

    /* renamed from: a, reason: collision with root package name */
    private final GraphRequest f244a;
    private final Handler b;
    private final long c = FacebookSdk.getOnProgressThreshold();
    private long d;
    private long e;
    private long f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(Handler handler, GraphRequest graphRequest) {
        this.f244a = graphRequest;
        this.b = handler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        this.d += j;
        if (this.d >= this.e + this.c || this.d >= this.f) {
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(long j) {
        this.f += j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.d > this.e) {
            GraphRequest.Callback callback = this.f244a.getCallback();
            if (this.f > 0 && (callback instanceof GraphRequest.OnProgressCallback)) {
                long j = this.d;
                long j2 = this.f;
                GraphRequest.OnProgressCallback onProgressCallback = (GraphRequest.OnProgressCallback) callback;
                if (this.b == null) {
                    onProgressCallback.onProgress(j, j2);
                } else {
                    this.b.post(new aj(this, onProgressCallback, j, j2));
                }
                this.e = this.d;
            }
        }
    }
}
