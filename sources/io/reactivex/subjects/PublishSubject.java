package io.reactivex.subjects;

import io.reactivex.disposables.b;
import io.reactivex.q;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class PublishSubject<T> extends a<T> {

    /* renamed from: a */
    static final PublishDisposable[] f28492a = new PublishDisposable[0];

    /* renamed from: b */
    static final PublishDisposable[] f28493b = new PublishDisposable[0];

    /* renamed from: c */
    final AtomicReference<PublishDisposable<T>[]> f28494c = new AtomicReference<>(f28493b);

    /* renamed from: d */
    Throwable f28495d;

    /* loaded from: classes3.dex */
    public static final class PublishDisposable<T> extends AtomicBoolean implements b {
        private static final long serialVersionUID = 3562861878281475070L;
        final q<? super T> downstream;
        final PublishSubject<T> parent;

        PublishDisposable(q<? super T> qVar, PublishSubject<T> publishSubject) {
            this.downstream = qVar;
            this.parent = publishSubject;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.b((PublishDisposable) this);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get();
        }

        public void onComplete() {
            if (get()) {
                return;
            }
            this.downstream.onComplete();
        }

        public void onError(Throwable th) {
            if (get()) {
                io.reactivex.f.a.b(th);
            } else {
                this.downstream.onError(th);
            }
        }

        public void onNext(T t) {
            if (get()) {
                return;
            }
            this.downstream.onNext(t);
        }
    }

    PublishSubject() {
    }

    public static <T> PublishSubject<T> f() {
        return new PublishSubject<>();
    }

    boolean a(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable<T>[] publishDisposableArr2;
        do {
            publishDisposableArr = this.f28494c.get();
            if (publishDisposableArr == f28492a) {
                return false;
            }
            int length = publishDisposableArr.length;
            publishDisposableArr2 = new PublishDisposable[length + 1];
            System.arraycopy(publishDisposableArr, 0, publishDisposableArr2, 0, length);
            publishDisposableArr2[length] = publishDisposable;
        } while (!this.f28494c.compareAndSet(publishDisposableArr, publishDisposableArr2));
        return true;
    }

    @Override // io.reactivex.m
    protected void b(q<? super T> qVar) {
        PublishDisposable<T> publishDisposable = new PublishDisposable<>(qVar, this);
        qVar.onSubscribe(publishDisposable);
        if (a((PublishDisposable) publishDisposable)) {
            if (publishDisposable.isDisposed()) {
                b((PublishDisposable) publishDisposable);
            }
        } else {
            Throwable th = this.f28495d;
            if (th != null) {
                qVar.onError(th);
            } else {
                qVar.onComplete();
            }
        }
    }

    @Override // io.reactivex.q
    public void onComplete() {
        PublishDisposable<T>[] publishDisposableArr = this.f28494c.get();
        PublishDisposable<T>[] publishDisposableArr2 = f28492a;
        if (publishDisposableArr == publishDisposableArr2) {
            return;
        }
        for (PublishDisposable<T> publishDisposable : this.f28494c.getAndSet(publishDisposableArr2)) {
            publishDisposable.onComplete();
        }
    }

    @Override // io.reactivex.q
    public void onError(Throwable th) {
        io.reactivex.d.a.b.a(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishDisposable<T>[] publishDisposableArr = this.f28494c.get();
        PublishDisposable<T>[] publishDisposableArr2 = f28492a;
        if (publishDisposableArr == publishDisposableArr2) {
            io.reactivex.f.a.b(th);
            return;
        }
        this.f28495d = th;
        for (PublishDisposable<T> publishDisposable : this.f28494c.getAndSet(publishDisposableArr2)) {
            publishDisposable.onError(th);
        }
    }

    @Override // io.reactivex.q
    public void onNext(T t) {
        io.reactivex.d.a.b.a((Object) t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (PublishDisposable<T> publishDisposable : this.f28494c.get()) {
            publishDisposable.onNext(t);
        }
    }

    @Override // io.reactivex.q
    public void onSubscribe(b bVar) {
        if (this.f28494c.get() == f28492a) {
            bVar.dispose();
        }
    }

    void b(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable<T>[] publishDisposableArr2;
        do {
            publishDisposableArr = this.f28494c.get();
            if (publishDisposableArr == f28492a || publishDisposableArr == f28493b) {
                return;
            }
            int length = publishDisposableArr.length;
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (publishDisposableArr[i2] == publishDisposable) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                publishDisposableArr2 = f28493b;
            } else {
                PublishDisposable<T>[] publishDisposableArr3 = new PublishDisposable[length - 1];
                System.arraycopy(publishDisposableArr, 0, publishDisposableArr3, 0, i);
                System.arraycopy(publishDisposableArr, i + 1, publishDisposableArr3, i, (length - i) - 1);
                publishDisposableArr2 = publishDisposableArr3;
            }
        } while (!this.f28494c.compareAndSet(publishDisposableArr, publishDisposableArr2));
    }
}
