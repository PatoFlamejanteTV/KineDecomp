package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;

/* compiled from: FlowableDoOnEach.java */
/* loaded from: classes3.dex */
public final class d<T> extends io.reactivex.internal.operators.flowable.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final io.reactivex.c.e<? super T> f28214c;

    /* renamed from: d, reason: collision with root package name */
    final io.reactivex.c.e<? super Throwable> f28215d;

    /* renamed from: e, reason: collision with root package name */
    final io.reactivex.c.a f28216e;

    /* renamed from: f, reason: collision with root package name */
    final io.reactivex.c.a f28217f;

    /* compiled from: FlowableDoOnEach.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends io.reactivex.internal.subscribers.a<T, T> {

        /* renamed from: f, reason: collision with root package name */
        final io.reactivex.c.e<? super T> f28218f;

        /* renamed from: g, reason: collision with root package name */
        final io.reactivex.c.e<? super Throwable> f28219g;

        /* renamed from: h, reason: collision with root package name */
        final io.reactivex.c.a f28220h;
        final io.reactivex.c.a i;

        a(io.reactivex.d.b.a<? super T> aVar, io.reactivex.c.e<? super T> eVar, io.reactivex.c.e<? super Throwable> eVar2, io.reactivex.c.a aVar2, io.reactivex.c.a aVar3) {
            super(aVar);
            this.f28218f = eVar;
            this.f28219g = eVar2;
            this.f28220h = aVar2;
            this.i = aVar3;
        }

        @Override // io.reactivex.d.b.a
        public boolean a(T t) {
            if (this.f28468d) {
                return false;
            }
            try {
                this.f28218f.accept(t);
                return this.f28465a.a(t);
            } catch (Throwable th) {
                a(th);
                return false;
            }
        }

        @Override // io.reactivex.internal.subscribers.a, g.b.b
        public void onComplete() {
            if (this.f28468d) {
                return;
            }
            try {
                this.f28220h.run();
                this.f28468d = true;
                this.f28465a.onComplete();
                try {
                    this.i.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    io.reactivex.f.a.b(th);
                }
            } catch (Throwable th2) {
                a(th2);
            }
        }

        @Override // io.reactivex.internal.subscribers.a, g.b.b
        public void onError(Throwable th) {
            if (this.f28468d) {
                io.reactivex.f.a.b(th);
                return;
            }
            boolean z = true;
            this.f28468d = true;
            try {
                this.f28219g.accept(th);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f28465a.onError(new CompositeException(th, th2));
                z = false;
            }
            if (z) {
                this.f28465a.onError(th);
            }
            try {
                this.i.run();
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                io.reactivex.f.a.b(th3);
            }
        }

        @Override // g.b.b
        public void onNext(T t) {
            if (this.f28468d) {
                return;
            }
            if (this.f28469e != 0) {
                this.f28465a.onNext(null);
                return;
            }
            try {
                this.f28218f.accept(t);
                this.f28465a.onNext(t);
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // io.reactivex.d.b.n
        public T poll() throws Exception {
            try {
                T poll = this.f28467c.poll();
                try {
                    if (poll != null) {
                        try {
                            this.f28218f.accept(poll);
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.b(th);
                            try {
                                this.f28219g.accept(th);
                                throw ExceptionHelper.a(th);
                            } catch (Throwable th2) {
                                throw new CompositeException(th, th2);
                            }
                        }
                    } else if (this.f28469e == 1) {
                        this.f28220h.run();
                    }
                    return poll;
                } finally {
                    this.i.run();
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                try {
                    this.f28219g.accept(th3);
                    throw ExceptionHelper.a(th3);
                } catch (Throwable th4) {
                    throw new CompositeException(th3, th4);
                }
            }
        }

        @Override // io.reactivex.d.b.j
        public int requestFusion(int i) {
            return a(i);
        }
    }

    /* compiled from: FlowableDoOnEach.java */
    /* loaded from: classes3.dex */
    static final class b<T> extends io.reactivex.internal.subscribers.b<T, T> {

        /* renamed from: f, reason: collision with root package name */
        final io.reactivex.c.e<? super T> f28221f;

        /* renamed from: g, reason: collision with root package name */
        final io.reactivex.c.e<? super Throwable> f28222g;

        /* renamed from: h, reason: collision with root package name */
        final io.reactivex.c.a f28223h;
        final io.reactivex.c.a i;

        b(g.b.b<? super T> bVar, io.reactivex.c.e<? super T> eVar, io.reactivex.c.e<? super Throwable> eVar2, io.reactivex.c.a aVar, io.reactivex.c.a aVar2) {
            super(bVar);
            this.f28221f = eVar;
            this.f28222g = eVar2;
            this.f28223h = aVar;
            this.i = aVar2;
        }

        @Override // io.reactivex.internal.subscribers.b, g.b.b
        public void onComplete() {
            if (this.f28473d) {
                return;
            }
            try {
                this.f28223h.run();
                this.f28473d = true;
                this.f28470a.onComplete();
                try {
                    this.i.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    io.reactivex.f.a.b(th);
                }
            } catch (Throwable th2) {
                a(th2);
            }
        }

        @Override // io.reactivex.internal.subscribers.b, g.b.b
        public void onError(Throwable th) {
            if (this.f28473d) {
                io.reactivex.f.a.b(th);
                return;
            }
            boolean z = true;
            this.f28473d = true;
            try {
                this.f28222g.accept(th);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f28470a.onError(new CompositeException(th, th2));
                z = false;
            }
            if (z) {
                this.f28470a.onError(th);
            }
            try {
                this.i.run();
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                io.reactivex.f.a.b(th3);
            }
        }

        @Override // g.b.b
        public void onNext(T t) {
            if (this.f28473d) {
                return;
            }
            if (this.f28474e != 0) {
                this.f28470a.onNext(null);
                return;
            }
            try {
                this.f28221f.accept(t);
                this.f28470a.onNext(t);
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // io.reactivex.d.b.n
        public T poll() throws Exception {
            try {
                T poll = this.f28472c.poll();
                try {
                    if (poll != null) {
                        try {
                            this.f28221f.accept(poll);
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.b(th);
                            try {
                                this.f28222g.accept(th);
                                throw ExceptionHelper.a(th);
                            } catch (Throwable th2) {
                                throw new CompositeException(th, th2);
                            }
                        }
                    } else if (this.f28474e == 1) {
                        this.f28223h.run();
                    }
                    return poll;
                } finally {
                    this.i.run();
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                try {
                    this.f28222g.accept(th3);
                    throw ExceptionHelper.a(th3);
                } catch (Throwable th4) {
                    throw new CompositeException(th3, th4);
                }
            }
        }

        @Override // io.reactivex.d.b.j
        public int requestFusion(int i) {
            return a(i);
        }
    }

    public d(io.reactivex.e<T> eVar, io.reactivex.c.e<? super T> eVar2, io.reactivex.c.e<? super Throwable> eVar3, io.reactivex.c.a aVar, io.reactivex.c.a aVar2) {
        super(eVar);
        this.f28214c = eVar2;
        this.f28215d = eVar3;
        this.f28216e = aVar;
        this.f28217f = aVar2;
    }

    @Override // io.reactivex.e
    protected void b(g.b.b<? super T> bVar) {
        if (bVar instanceof io.reactivex.d.b.a) {
            this.f28211b.a((io.reactivex.h) new a((io.reactivex.d.b.a) bVar, this.f28214c, this.f28215d, this.f28216e, this.f28217f));
        } else {
            this.f28211b.a((io.reactivex.h) new b(bVar, this.f28214c, this.f28215d, this.f28216e, this.f28217f));
        }
    }
}
