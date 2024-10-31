package com.android.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: ExecutorDelivery.java */
/* loaded from: classes.dex */
public class f implements n {

    /* renamed from: a */
    private final Executor f8058a;

    /* compiled from: ExecutorDelivery.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a */
        private final Request f8059a;

        /* renamed from: b */
        private final m f8060b;

        /* renamed from: c */
        private final Runnable f8061c;

        public a(Request request, m mVar, Runnable runnable) {
            this.f8059a = request;
            this.f8060b = mVar;
            this.f8061c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f8059a.B()) {
                this.f8059a.b("canceled-at-delivery");
                return;
            }
            if (this.f8060b.a()) {
                this.f8059a.a((Request) this.f8060b.f8087a);
            } else {
                this.f8059a.a(this.f8060b.f8089c);
            }
            if (this.f8060b.f8090d) {
                this.f8059a.a("intermediate-response");
            } else {
                this.f8059a.b("done");
            }
            Runnable runnable = this.f8061c;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public f(Handler handler) {
        this.f8058a = new e(this, handler);
    }

    @Override // com.android.volley.n
    public void a(Request<?> request, m<?> mVar) {
        a(request, mVar, null);
    }

    @Override // com.android.volley.n
    public void a(Request<?> request, m<?> mVar, Runnable runnable) {
        request.C();
        request.a("post-response");
        this.f8058a.execute(new a(request, mVar, runnable));
    }

    @Override // com.android.volley.n
    public void a(Request<?> request, VolleyError volleyError) {
        request.a("post-error");
        this.f8058a.execute(new a(request, m.a(volleyError), null));
    }
}
