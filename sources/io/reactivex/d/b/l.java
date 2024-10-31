package io.reactivex.d.b;

import java.util.concurrent.Callable;

/* compiled from: ScalarCallable.java */
/* loaded from: classes3.dex */
public interface l<T> extends Callable<T> {
    @Override // java.util.concurrent.Callable
    T call();
}
