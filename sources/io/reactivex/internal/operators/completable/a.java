package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: CompletableEmpty.java */
/* loaded from: classes3.dex */
public final class a extends io.reactivex.a {

    /* renamed from: a, reason: collision with root package name */
    public static final io.reactivex.a f28157a = new a();

    private a() {
    }

    @Override // io.reactivex.a
    public void b(io.reactivex.b bVar) {
        EmptyDisposable.complete(bVar);
    }
}
