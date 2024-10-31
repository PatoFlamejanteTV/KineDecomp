package io.reactivex.internal.operators.completable;

/* compiled from: CompletableFromAction.java */
/* loaded from: classes3.dex */
public final class b extends io.reactivex.a {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.c.a f28158a;

    public b(io.reactivex.c.a aVar) {
        this.f28158a = aVar;
    }

    @Override // io.reactivex.a
    protected void b(io.reactivex.b bVar) {
        io.reactivex.disposables.b b2 = io.reactivex.disposables.c.b();
        bVar.onSubscribe(b2);
        try {
            this.f28158a.run();
            if (b2.isDisposed()) {
                return;
            }
            bVar.onComplete();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            if (!b2.isDisposed()) {
                bVar.onError(th);
            } else {
                io.reactivex.f.a.b(th);
            }
        }
    }
}
