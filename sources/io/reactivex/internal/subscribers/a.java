package io.reactivex.internal.subscribers;

import g.b.c;
import io.reactivex.d.b.k;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* compiled from: BasicFuseableConditionalSubscriber.java */
/* loaded from: classes3.dex */
public abstract class a<T, R> implements io.reactivex.d.b.a<T>, k<R> {

    /* renamed from: a, reason: collision with root package name */
    protected final io.reactivex.d.b.a<? super R> f28465a;

    /* renamed from: b, reason: collision with root package name */
    protected c f28466b;

    /* renamed from: c, reason: collision with root package name */
    protected k<T> f28467c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f28468d;

    /* renamed from: e, reason: collision with root package name */
    protected int f28469e;

    public a(io.reactivex.d.b.a<? super R> aVar) {
        this.f28465a = aVar;
    }

    protected void a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Throwable th) {
        io.reactivex.exceptions.a.b(th);
        this.f28466b.cancel();
        onError(th);
    }

    protected boolean b() {
        return true;
    }

    @Override // g.b.c
    public void cancel() {
        this.f28466b.cancel();
    }

    @Override // io.reactivex.d.b.n
    public void clear() {
        this.f28467c.clear();
    }

    @Override // io.reactivex.d.b.n
    public boolean isEmpty() {
        return this.f28467c.isEmpty();
    }

    @Override // io.reactivex.d.b.n
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // g.b.b
    public void onComplete() {
        if (this.f28468d) {
            return;
        }
        this.f28468d = true;
        this.f28465a.onComplete();
    }

    @Override // g.b.b
    public void onError(Throwable th) {
        if (this.f28468d) {
            io.reactivex.f.a.b(th);
        } else {
            this.f28468d = true;
            this.f28465a.onError(th);
        }
    }

    @Override // io.reactivex.h, g.b.b
    public final void onSubscribe(c cVar) {
        if (SubscriptionHelper.validate(this.f28466b, cVar)) {
            this.f28466b = cVar;
            if (cVar instanceof k) {
                this.f28467c = (k) cVar;
            }
            if (b()) {
                this.f28465a.onSubscribe(this);
                a();
            }
        }
    }

    @Override // g.b.c
    public void request(long j) {
        this.f28466b.request(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(int i) {
        k<T> kVar = this.f28467c;
        if (kVar == null || (i & 4) != 0) {
            return 0;
        }
        int requestFusion = kVar.requestFusion(i);
        if (requestFusion != 0) {
            this.f28469e = requestFusion;
        }
        return requestFusion;
    }
}
