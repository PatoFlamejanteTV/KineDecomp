package io.reactivex.e;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.q;

/* compiled from: SerializedObserver.java */
/* loaded from: classes3.dex */
public final class b<T> implements q<T>, io.reactivex.disposables.b {

    /* renamed from: a, reason: collision with root package name */
    final q<? super T> f28117a;

    /* renamed from: b, reason: collision with root package name */
    final boolean f28118b;

    /* renamed from: c, reason: collision with root package name */
    io.reactivex.disposables.b f28119c;

    /* renamed from: d, reason: collision with root package name */
    boolean f28120d;

    /* renamed from: e, reason: collision with root package name */
    io.reactivex.internal.util.a<Object> f28121e;

    /* renamed from: f, reason: collision with root package name */
    volatile boolean f28122f;

    public b(q<? super T> qVar) {
        this(qVar, false);
    }

    void a() {
        io.reactivex.internal.util.a<Object> aVar;
        do {
            synchronized (this) {
                aVar = this.f28121e;
                if (aVar == null) {
                    this.f28120d = false;
                    return;
                }
                this.f28121e = null;
            }
        } while (!aVar.a((q) this.f28117a));
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.f28119c.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.f28119c.isDisposed();
    }

    @Override // io.reactivex.q
    public void onComplete() {
        if (this.f28122f) {
            return;
        }
        synchronized (this) {
            if (this.f28122f) {
                return;
            }
            if (this.f28120d) {
                io.reactivex.internal.util.a<Object> aVar = this.f28121e;
                if (aVar == null) {
                    aVar = new io.reactivex.internal.util.a<>(4);
                    this.f28121e = aVar;
                }
                aVar.a((io.reactivex.internal.util.a<Object>) NotificationLite.complete());
                return;
            }
            this.f28122f = true;
            this.f28120d = true;
            this.f28117a.onComplete();
        }
    }

    @Override // io.reactivex.q
    public void onError(Throwable th) {
        if (this.f28122f) {
            io.reactivex.f.a.b(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.f28122f) {
                if (this.f28120d) {
                    this.f28122f = true;
                    io.reactivex.internal.util.a<Object> aVar = this.f28121e;
                    if (aVar == null) {
                        aVar = new io.reactivex.internal.util.a<>(4);
                        this.f28121e = aVar;
                    }
                    Object error = NotificationLite.error(th);
                    if (this.f28118b) {
                        aVar.a((io.reactivex.internal.util.a<Object>) error);
                    } else {
                        aVar.b(error);
                    }
                    return;
                }
                this.f28122f = true;
                this.f28120d = true;
                z = false;
            }
            if (z) {
                io.reactivex.f.a.b(th);
            } else {
                this.f28117a.onError(th);
            }
        }
    }

    @Override // io.reactivex.q
    public void onNext(T t) {
        if (this.f28122f) {
            return;
        }
        if (t == null) {
            this.f28119c.dispose();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.f28122f) {
                return;
            }
            if (this.f28120d) {
                io.reactivex.internal.util.a<Object> aVar = this.f28121e;
                if (aVar == null) {
                    aVar = new io.reactivex.internal.util.a<>(4);
                    this.f28121e = aVar;
                }
                NotificationLite.next(t);
                aVar.a((io.reactivex.internal.util.a<Object>) t);
                return;
            }
            this.f28120d = true;
            this.f28117a.onNext(t);
            a();
        }
    }

    @Override // io.reactivex.q
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        if (DisposableHelper.validate(this.f28119c, bVar)) {
            this.f28119c = bVar;
            this.f28117a.onSubscribe(this);
        }
    }

    public b(q<? super T> qVar, boolean z) {
        this.f28117a = qVar;
        this.f28118b = z;
    }
}
