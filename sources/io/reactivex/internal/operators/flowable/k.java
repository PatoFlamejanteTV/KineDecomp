package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import java.util.concurrent.Callable;

/* compiled from: FlowableScalarXMap.java */
/* loaded from: classes3.dex */
public final class k {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableScalarXMap.java */
    /* loaded from: classes3.dex */
    public static final class a<T, R> extends io.reactivex.e<R> {

        /* renamed from: b, reason: collision with root package name */
        final T f28242b;

        /* renamed from: c, reason: collision with root package name */
        final io.reactivex.c.f<? super T, ? extends g.b.a<? extends R>> f28243c;

        a(T t, io.reactivex.c.f<? super T, ? extends g.b.a<? extends R>> fVar) {
            this.f28242b = t;
            this.f28243c = fVar;
        }

        @Override // io.reactivex.e
        public void b(g.b.b<? super R> bVar) {
            try {
                g.b.a<? extends R> apply = this.f28243c.apply(this.f28242b);
                io.reactivex.d.a.b.a(apply, "The mapper returned a null Publisher");
                g.b.a<? extends R> aVar = apply;
                if (aVar instanceof Callable) {
                    try {
                        Object call = ((Callable) aVar).call();
                        if (call == null) {
                            EmptySubscription.complete(bVar);
                            return;
                        } else {
                            bVar.onSubscribe(new ScalarSubscription(bVar, call));
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        EmptySubscription.error(th, bVar);
                        return;
                    }
                }
                aVar.a(bVar);
            } catch (Throwable th2) {
                EmptySubscription.error(th2, bVar);
            }
        }
    }

    public static <T, R> boolean a(g.b.a<T> aVar, g.b.b<? super R> bVar, io.reactivex.c.f<? super T, ? extends g.b.a<? extends R>> fVar) {
        if (!(aVar instanceof Callable)) {
            return false;
        }
        try {
            defpackage.a aVar2 = (Object) ((Callable) aVar).call();
            if (aVar2 == null) {
                EmptySubscription.complete(bVar);
                return true;
            }
            try {
                g.b.a<? extends R> apply = fVar.apply(aVar2);
                io.reactivex.d.a.b.a(apply, "The mapper returned a null Publisher");
                g.b.a<? extends R> aVar3 = apply;
                if (aVar3 instanceof Callable) {
                    try {
                        Object call = ((Callable) aVar3).call();
                        if (call == null) {
                            EmptySubscription.complete(bVar);
                            return true;
                        }
                        bVar.onSubscribe(new ScalarSubscription(bVar, call));
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        EmptySubscription.error(th, bVar);
                        return true;
                    }
                } else {
                    aVar3.a(bVar);
                }
                return true;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                EmptySubscription.error(th2, bVar);
                return true;
            }
        } catch (Throwable th3) {
            io.reactivex.exceptions.a.b(th3);
            EmptySubscription.error(th3, bVar);
            return true;
        }
    }

    public static <T, U> io.reactivex.e<U> a(T t, io.reactivex.c.f<? super T, ? extends g.b.a<? extends U>> fVar) {
        return io.reactivex.f.a.a(new a(t, fVar));
    }
}
