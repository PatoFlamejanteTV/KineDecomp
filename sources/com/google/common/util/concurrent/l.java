package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.errorprone.annotations.ForOverride;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractTransformFuture.java */
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class l<I, O, F, T> extends AbstractFuture.h<O> implements Runnable {

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    ListenableFuture<? extends I> f16205h;

    @Nullable
    F i;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractTransformFuture.java */
    /* loaded from: classes2.dex */
    public static final class a<I, O> extends l<I, O, Function<? super I, ? extends O>, O> {
        a(ListenableFuture<? extends I> listenableFuture, Function<? super I, ? extends O> function) {
            super(listenableFuture, function);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.l
        /* bridge */ /* synthetic */ Object a(Object obj, Object obj2) throws Exception {
            return a((Function<? super Function<? super I, ? extends O>, ? extends O>) obj, (Function<? super I, ? extends O>) obj2);
        }

        @Override // com.google.common.util.concurrent.l
        void b(@Nullable O o) {
            a((a<I, O>) o);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Nullable
        O a(Function<? super I, ? extends O> function, @Nullable I i) {
            return function.apply(i);
        }
    }

    l(ListenableFuture<? extends I> listenableFuture, F f2) {
        Preconditions.a(listenableFuture);
        this.f16205h = listenableFuture;
        Preconditions.a(f2);
        this.i = f2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <I, O> ListenableFuture<O> a(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function) {
        Preconditions.a(function);
        a aVar = new a(listenableFuture, function);
        listenableFuture.a(aVar, MoreExecutors.a());
        return aVar;
    }

    @Nullable
    @ForOverride
    abstract T a(F f2, @Nullable I i) throws Exception;

    @ForOverride
    abstract void b(@Nullable T t);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void c() {
        a((Future<?>) this.f16205h);
        this.f16205h = null;
        this.i = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        ListenableFuture<? extends I> listenableFuture = this.f16205h;
        F f2 = this.i;
        if ((isCancelled() | (listenableFuture == null)) || (f2 == null)) {
            return;
        }
        this.f16205h = null;
        this.i = null;
        try {
            try {
                b((l<I, O, F, T>) a((l<I, O, F, T>) f2, (F) Futures.a((Future) listenableFuture)));
            } catch (UndeclaredThrowableException e2) {
                a(e2.getCause());
            } catch (Throwable th) {
                a(th);
            }
        } catch (Error e3) {
            a((Throwable) e3);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (RuntimeException e4) {
            a((Throwable) e4);
        } catch (ExecutionException e5) {
            a(e5.getCause());
        }
    }
}
