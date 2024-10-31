package io.reactivex;

import android.support.v7.widget.ActivityChooserView;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.operators.flowable.FlowableCreate;
import io.reactivex.internal.operators.flowable.FlowableFlatMap;
import io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe;
import io.reactivex.internal.operators.flowable.FlowableFlattenIterable;
import io.reactivex.internal.operators.flowable.FlowableFromArray;
import io.reactivex.internal.operators.flowable.FlowableFromIterable;
import io.reactivex.internal.operators.flowable.FlowableInternalHelper$RequestMax;
import io.reactivex.internal.operators.flowable.FlowableObserveOn;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBuffer;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureDrop;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureLatest;
import io.reactivex.internal.operators.flowable.FlowablePublish;
import io.reactivex.internal.subscribers.LambdaSubscriber;
import io.reactivex.internal.subscribers.StrictSubscriber;
import io.reactivex.internal.util.ErrorMode;
import java.util.Comparator;
import java.util.List;

/* compiled from: Flowable.java */
/* loaded from: classes3.dex */
public abstract class e<T> implements g.b.a<T> {

    /* renamed from: a, reason: collision with root package name */
    static final int f28116a = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    public static int a() {
        return f28116a;
    }

    public static <T> e<T> b() {
        return io.reactivex.f.a.a(io.reactivex.internal.operators.flowable.f.f28231b);
    }

    protected abstract void b(g.b.b<? super T> bVar);

    public final i<T> c() {
        return a(0L);
    }

    public final <R> e<R> d(io.reactivex.c.f<? super T, ? extends R> fVar) {
        io.reactivex.d.a.b.a(fVar, "mapper is null");
        return io.reactivex.f.a.a(new io.reactivex.internal.operators.flowable.j(this, fVar));
    }

    public final e<T> e() {
        return io.reactivex.f.a.a(new FlowableOnBackpressureDrop(this));
    }

    public final e<T> f() {
        return io.reactivex.f.a.a(new FlowableOnBackpressureLatest(this));
    }

    public final io.reactivex.b.a<T> g() {
        return a(a());
    }

    public final s<List<T>> h() {
        return io.reactivex.f.a.a(new io.reactivex.internal.operators.flowable.l(this));
    }

    public static <T> e<T> a(g<T> gVar, BackpressureStrategy backpressureStrategy) {
        io.reactivex.d.a.b.a(gVar, "source is null");
        io.reactivex.d.a.b.a(backpressureStrategy, "mode is null");
        return io.reactivex.f.a.a(new FlowableCreate(gVar, backpressureStrategy));
    }

    public final <U> e<U> b(io.reactivex.c.f<? super T, ? extends Iterable<? extends U>> fVar) {
        return b(fVar, a());
    }

    public final <R> e<R> c(io.reactivex.c.f<? super T, ? extends k<? extends R>> fVar) {
        return b(fVar, false, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public final <U> e<U> b(io.reactivex.c.f<? super T, ? extends Iterable<? extends U>> fVar, int i) {
        io.reactivex.d.a.b.a(fVar, "mapper is null");
        io.reactivex.d.a.b.a(i, "bufferSize");
        return io.reactivex.f.a.a(new FlowableFlattenIterable(this, fVar, i));
    }

    public final e<T> d() {
        return a(a(), false, true);
    }

    public static <T> e<T> a(T... tArr) {
        io.reactivex.d.a.b.a(tArr, "items is null");
        if (tArr.length == 0) {
            return b();
        }
        if (tArr.length == 1) {
            return a(tArr[0]);
        }
        return io.reactivex.f.a.a(new FlowableFromArray(tArr));
    }

    public final <R> e<R> b(io.reactivex.c.f<? super T, ? extends k<? extends R>> fVar, boolean z, int i) {
        io.reactivex.d.a.b.a(fVar, "mapper is null");
        io.reactivex.d.a.b.a(i, "maxConcurrency");
        return io.reactivex.f.a.a(new FlowableFlatMapMaybe(this, fVar, z, i));
    }

    public final io.reactivex.disposables.b b(io.reactivex.c.e<? super T> eVar) {
        return a(eVar, io.reactivex.d.a.a.f28107f, io.reactivex.d.a.a.f28104c, FlowableInternalHelper$RequestMax.INSTANCE);
    }

    public static <T> e<T> a(Iterable<? extends T> iterable) {
        io.reactivex.d.a.b.a(iterable, "source is null");
        return io.reactivex.f.a.a(new FlowableFromIterable(iterable));
    }

    public static <T> e<T> a(T t) {
        io.reactivex.d.a.b.a((Object) t, "item is null");
        return io.reactivex.f.a.a((e) new io.reactivex.internal.operators.flowable.i(t));
    }

    public static <T> e<T> a(g.b.a<? extends T> aVar, g.b.a<? extends T> aVar2) {
        io.reactivex.d.a.b.a(aVar, "source1 is null");
        io.reactivex.d.a.b.a(aVar2, "source2 is null");
        return a((Object[]) new g.b.a[]{aVar, aVar2}).a(io.reactivex.d.a.a.c(), false, 2);
    }

    public final <R> e<R> a(io.reactivex.c.f<? super T, ? extends g.b.a<? extends R>> fVar) {
        return a(fVar, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> e<R> a(io.reactivex.c.f<? super T, ? extends g.b.a<? extends R>> fVar, int i) {
        io.reactivex.d.a.b.a(fVar, "mapper is null");
        io.reactivex.d.a.b.a(i, "prefetch");
        if (this instanceof io.reactivex.d.b.l) {
            Object call = ((io.reactivex.d.b.l) this).call();
            if (call == null) {
                return b();
            }
            return io.reactivex.internal.operators.flowable.k.a(call, fVar);
        }
        return io.reactivex.f.a.a(new FlowableConcatMap(this, fVar, i, ErrorMode.IMMEDIATE));
    }

    private e<T> a(io.reactivex.c.e<? super T> eVar, io.reactivex.c.e<? super Throwable> eVar2, io.reactivex.c.a aVar, io.reactivex.c.a aVar2) {
        io.reactivex.d.a.b.a(eVar, "onNext is null");
        io.reactivex.d.a.b.a(eVar2, "onError is null");
        io.reactivex.d.a.b.a(aVar, "onComplete is null");
        io.reactivex.d.a.b.a(aVar2, "onAfterTerminate is null");
        return io.reactivex.f.a.a(new io.reactivex.internal.operators.flowable.d(this, eVar, eVar2, aVar, aVar2));
    }

    public final e<T> a(io.reactivex.c.e<? super T> eVar) {
        io.reactivex.c.e<? super Throwable> b2 = io.reactivex.d.a.a.b();
        io.reactivex.c.a aVar = io.reactivex.d.a.a.f28104c;
        return a(eVar, b2, aVar, aVar);
    }

    public final i<T> a(long j) {
        if (j >= 0) {
            return io.reactivex.f.a.a(new io.reactivex.internal.operators.flowable.e(this, j));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j);
    }

    public final e<T> a(io.reactivex.c.h<? super T> hVar) {
        io.reactivex.d.a.b.a(hVar, "predicate is null");
        return io.reactivex.f.a.a(new io.reactivex.internal.operators.flowable.g(this, hVar));
    }

    public final <R> e<R> a(io.reactivex.c.f<? super T, ? extends g.b.a<? extends R>> fVar, boolean z, int i) {
        return a(fVar, z, i, a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> e<R> a(io.reactivex.c.f<? super T, ? extends g.b.a<? extends R>> fVar, boolean z, int i, int i2) {
        io.reactivex.d.a.b.a(fVar, "mapper is null");
        io.reactivex.d.a.b.a(i, "maxConcurrency");
        io.reactivex.d.a.b.a(i2, "bufferSize");
        if (this instanceof io.reactivex.d.b.l) {
            Object call = ((io.reactivex.d.b.l) this).call();
            if (call == null) {
                return b();
            }
            return io.reactivex.internal.operators.flowable.k.a(call, fVar);
        }
        return io.reactivex.f.a.a(new FlowableFlatMap(this, fVar, z, i, i2));
    }

    public final e<T> a(r rVar) {
        return a(rVar, false, a());
    }

    public final e<T> a(r rVar, boolean z, int i) {
        io.reactivex.d.a.b.a(rVar, "scheduler is null");
        io.reactivex.d.a.b.a(i, "bufferSize");
        return io.reactivex.f.a.a(new FlowableObserveOn(this, rVar, z, i));
    }

    public final e<T> a(int i, boolean z, boolean z2) {
        io.reactivex.d.a.b.a(i, "capacity");
        return io.reactivex.f.a.a(new FlowableOnBackpressureBuffer(this, i, z2, z, io.reactivex.d.a.a.f28104c));
    }

    public final io.reactivex.b.a<T> a(int i) {
        io.reactivex.d.a.b.a(i, "bufferSize");
        return FlowablePublish.a(this, i);
    }

    public final e<T> a(Comparator<? super T> comparator) {
        io.reactivex.d.a.b.a(comparator, "sortFunction");
        return h().c().d(io.reactivex.d.a.a.a((Comparator) comparator)).b((io.reactivex.c.f<? super R, ? extends Iterable<? extends U>>) io.reactivex.d.a.a.c());
    }

    public final io.reactivex.disposables.b a(io.reactivex.c.e<? super T> eVar, io.reactivex.c.e<? super Throwable> eVar2, io.reactivex.c.a aVar, io.reactivex.c.e<? super g.b.c> eVar3) {
        io.reactivex.d.a.b.a(eVar, "onNext is null");
        io.reactivex.d.a.b.a(eVar2, "onError is null");
        io.reactivex.d.a.b.a(aVar, "onComplete is null");
        io.reactivex.d.a.b.a(eVar3, "onSubscribe is null");
        LambdaSubscriber lambdaSubscriber = new LambdaSubscriber(eVar, eVar2, aVar, eVar3);
        a((h) lambdaSubscriber);
        return lambdaSubscriber;
    }

    @Override // g.b.a
    public final void a(g.b.b<? super T> bVar) {
        if (bVar instanceof h) {
            a((h) bVar);
        } else {
            io.reactivex.d.a.b.a(bVar, "s is null");
            a((h) new StrictSubscriber(bVar));
        }
    }

    public final void a(h<? super T> hVar) {
        io.reactivex.d.a.b.a(hVar, "s is null");
        try {
            g.b.b<? super T> a2 = io.reactivex.f.a.a(this, hVar);
            io.reactivex.d.a.b.a(a2, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            b(a2);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            io.reactivex.f.a.b(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
