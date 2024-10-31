package io.reactivex.internal.observers;

import io.reactivex.d.b.i;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.q;

/* compiled from: BasicFuseableObserver.java */
/* loaded from: classes3.dex */
public abstract class a<T, R> implements q<T>, i<R> {

    /* renamed from: a, reason: collision with root package name */
    protected final q<? super R> f28144a;

    /* renamed from: b, reason: collision with root package name */
    protected io.reactivex.disposables.b f28145b;

    /* renamed from: c, reason: collision with root package name */
    protected i<T> f28146c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f28147d;

    /* renamed from: e, reason: collision with root package name */
    protected int f28148e;

    public a(q<? super R> qVar) {
        this.f28144a = qVar;
    }

    protected void a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Throwable th) {
        io.reactivex.exceptions.a.b(th);
        this.f28145b.dispose();
        onError(th);
    }

    protected boolean b() {
        return true;
    }

    @Override // io.reactivex.d.b.n
    public void clear() {
        this.f28146c.clear();
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.f28145b.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.f28145b.isDisposed();
    }

    @Override // io.reactivex.d.b.n
    public boolean isEmpty() {
        return this.f28146c.isEmpty();
    }

    @Override // io.reactivex.d.b.n
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.q
    public void onComplete() {
        if (this.f28147d) {
            return;
        }
        this.f28147d = true;
        this.f28144a.onComplete();
    }

    @Override // io.reactivex.q
    public void onError(Throwable th) {
        if (this.f28147d) {
            io.reactivex.f.a.b(th);
        } else {
            this.f28147d = true;
            this.f28144a.onError(th);
        }
    }

    @Override // io.reactivex.q
    public final void onSubscribe(io.reactivex.disposables.b bVar) {
        if (DisposableHelper.validate(this.f28145b, bVar)) {
            this.f28145b = bVar;
            if (bVar instanceof i) {
                this.f28146c = (i) bVar;
            }
            if (b()) {
                this.f28144a.onSubscribe(this);
                a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(int i) {
        i<T> iVar = this.f28146c;
        if (iVar == null || (i & 4) != 0) {
            return 0;
        }
        int requestFusion = iVar.requestFusion(i);
        if (requestFusion != 0) {
            this.f28148e = requestFusion;
        }
        return requestFusion;
    }
}
