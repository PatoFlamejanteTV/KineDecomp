package io.reactivex.d.a;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: Functions.java */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    static final io.reactivex.c.f<Object, Object> f28102a = new h();

    /* renamed from: b, reason: collision with root package name */
    public static final Runnable f28103b = new d();

    /* renamed from: c, reason: collision with root package name */
    public static final io.reactivex.c.a f28104c = new C0160a();

    /* renamed from: d, reason: collision with root package name */
    static final io.reactivex.c.e<Object> f28105d = new b();

    /* renamed from: e, reason: collision with root package name */
    public static final io.reactivex.c.e<Throwable> f28106e = new f();

    /* renamed from: f, reason: collision with root package name */
    public static final io.reactivex.c.e<Throwable> f28107f = new n();

    /* renamed from: g, reason: collision with root package name */
    public static final io.reactivex.c.g f28108g = new c();

    /* renamed from: h, reason: collision with root package name */
    static final io.reactivex.c.h<Object> f28109h = new o();
    static final io.reactivex.c.h<Object> i = new g();
    static final Callable<Object> j = new m();
    static final Comparator<Object> k = new l();
    public static final io.reactivex.c.e<g.b.c> l = new k();

    /* compiled from: Functions.java */
    /* renamed from: io.reactivex.d.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static final class C0160a implements io.reactivex.c.a {
        C0160a() {
        }

        @Override // io.reactivex.c.a
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes3.dex */
    static final class b implements io.reactivex.c.e<Object> {
        b() {
        }

        @Override // io.reactivex.c.e
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes3.dex */
    static final class c implements io.reactivex.c.g {
        c() {
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes3.dex */
    static final class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Functions.java */
    /* loaded from: classes3.dex */
    public static final class e<T> implements io.reactivex.c.h<T> {

        /* renamed from: a, reason: collision with root package name */
        final T f28110a;

        e(T t) {
            this.f28110a = t;
        }

        @Override // io.reactivex.c.h
        public boolean test(T t) throws Exception {
            return io.reactivex.d.a.b.a(t, this.f28110a);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes3.dex */
    static final class f implements io.reactivex.c.e<Throwable> {
        f() {
        }

        @Override // io.reactivex.c.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            io.reactivex.f.a.b(th);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes3.dex */
    static final class g implements io.reactivex.c.h<Object> {
        g() {
        }

        @Override // io.reactivex.c.h
        public boolean test(Object obj) {
            return false;
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes3.dex */
    static final class h implements io.reactivex.c.f<Object, Object> {
        h() {
        }

        @Override // io.reactivex.c.f
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Functions.java */
    /* loaded from: classes3.dex */
    public static final class i<T, U> implements Callable<U>, io.reactivex.c.f<T, U> {

        /* renamed from: a, reason: collision with root package name */
        final U f28111a;

        i(U u) {
            this.f28111a = u;
        }

        @Override // io.reactivex.c.f
        public U apply(T t) throws Exception {
            return this.f28111a;
        }

        @Override // java.util.concurrent.Callable
        public U call() throws Exception {
            return this.f28111a;
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes3.dex */
    static final class j<T> implements io.reactivex.c.f<List<T>, List<T>> {

        /* renamed from: a, reason: collision with root package name */
        final Comparator<? super T> f28112a;

        j(Comparator<? super T> comparator) {
            this.f28112a = comparator;
        }

        public List<T> a(List<T> list) {
            Collections.sort(list, this.f28112a);
            return list;
        }

        @Override // io.reactivex.c.f
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            List<T> list = (List) obj;
            a(list);
            return list;
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes3.dex */
    static final class k implements io.reactivex.c.e<g.b.c> {
        k() {
        }

        @Override // io.reactivex.c.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(g.b.c cVar) throws Exception {
            cVar.request(Long.MAX_VALUE);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes3.dex */
    static final class l implements Comparator<Object> {
        l() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes3.dex */
    static final class m implements Callable<Object> {
        m() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes3.dex */
    static final class n implements io.reactivex.c.e<Throwable> {
        n() {
        }

        @Override // io.reactivex.c.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            io.reactivex.f.a.b(new OnErrorNotImplementedException(th));
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes3.dex */
    static final class o implements io.reactivex.c.h<Object> {
        o() {
        }

        @Override // io.reactivex.c.h
        public boolean test(Object obj) {
            return true;
        }
    }

    public static <T> io.reactivex.c.h<T> a() {
        return (io.reactivex.c.h<T>) f28109h;
    }

    public static <T> io.reactivex.c.e<T> b() {
        return (io.reactivex.c.e<T>) f28105d;
    }

    public static <T> io.reactivex.c.f<T, T> c() {
        return (io.reactivex.c.f<T, T>) f28102a;
    }

    public static <T> io.reactivex.c.h<T> a(T t) {
        return new e(t);
    }

    public static <T> Callable<T> b(T t) {
        return new i(t);
    }

    public static <T, U> io.reactivex.c.f<T, U> c(U u) {
        return new i(u);
    }

    public static <T> io.reactivex.c.f<List<T>, List<T>> a(Comparator<? super T> comparator) {
        return new j(comparator);
    }
}
