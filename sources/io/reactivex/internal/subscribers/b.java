package io.reactivex.internal.subscribers;

import g.b.c;
import io.reactivex.d.b.k;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* compiled from: BasicFuseableSubscriber.java */
/* loaded from: classes3.dex */
public abstract class b<T, R> implements h<T>, k<R> {

    /* renamed from: a, reason: collision with root package name */
    protected final g.b.b<? super R> f28470a;

    /* renamed from: b, reason: collision with root package name */
    protected c f28471b;

    /* renamed from: c, reason: collision with root package name */
    protected k<T> f28472c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f28473d;

    /* renamed from: e, reason: collision with root package name */
    protected int f28474e;

    public b(g.b.b<? super R> bVar) {
        this.f28470a = bVar;
    }

    protected void a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Throwable th) {
        io.reactivex.exceptions.a.b(th);
        this.f28471b.cancel();
        onError(th);
    }

    protected boolean b() {
        return true;
    }

    @Override // g.b.c
    public void cancel() {
        this.f28471b.cancel();
    }

    @Override // io.reactivex.d.b.n
    public void clear() {
        this.f28472c.clear();
    }

    @Override // io.reactivex.d.b.n
    public boolean isEmpty() {
        return this.f28472c.isEmpty();
    }

    @Override // io.reactivex.d.b.n
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // g.b.b
    public void onComplete() {
        if (this.f28473d) {
            return;
        }
        this.f28473d = true;
        this.f28470a.onComplete();
    }

    @Override // g.b.b
    public void onError(Throwable th) {
        if (this.f28473d) {
            io.reactivex.f.a.b(th);
        } else {
            this.f28473d = true;
            this.f28470a.onError(th);
        }
    }

    @Override // io.reactivex.h, g.b.b
    public final void onSubscribe(c cVar) {
        if (SubscriptionHelper.validate(this.f28471b, cVar)) {
            this.f28471b = cVar;
            if (cVar instanceof k) {
                this.f28472c = (k) cVar;
            }
            if (b()) {
                this.f28470a.onSubscribe(this);
                a();
            }
        }
    }

    @Override // g.b.c
    public void request(long j) {
        this.f28471b.request(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(int i) {
        k<T> kVar = this.f28472c;
        if (kVar == null || (i & 4) != 0) {
            return 0;
        }
        int requestFusion = kVar.requestFusion(i);
        if (requestFusion != 0) {
            this.f28474e = requestFusion;
        }
        return requestFusion;
    }
}
