package io.reactivex.internal.operators.completable;

import io.reactivex.c.h;
import io.reactivex.exceptions.CompositeException;

/* compiled from: CompletableOnErrorComplete.java */
/* loaded from: classes3.dex */
public final class d extends io.reactivex.a {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.c f28160a;

    /* renamed from: b, reason: collision with root package name */
    final h<? super Throwable> f28161b;

    /* compiled from: CompletableOnErrorComplete.java */
    /* loaded from: classes3.dex */
    final class a implements io.reactivex.b {

        /* renamed from: a, reason: collision with root package name */
        private final io.reactivex.b f28162a;

        a(io.reactivex.b bVar) {
            this.f28162a = bVar;
        }

        @Override // io.reactivex.b
        public void onComplete() {
            this.f28162a.onComplete();
        }

        @Override // io.reactivex.b
        public void onError(Throwable th) {
            try {
                if (d.this.f28161b.test(th)) {
                    this.f28162a.onComplete();
                } else {
                    this.f28162a.onError(th);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f28162a.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.b
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f28162a.onSubscribe(bVar);
        }
    }

    public d(io.reactivex.c cVar, h<? super Throwable> hVar) {
        this.f28160a = cVar;
        this.f28161b = hVar;
    }

    @Override // io.reactivex.a
    protected void b(io.reactivex.b bVar) {
        this.f28160a.a(new a(bVar));
    }
}
