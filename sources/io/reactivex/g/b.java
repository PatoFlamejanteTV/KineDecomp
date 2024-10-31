package io.reactivex.g;

import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.internal.schedulers.i;
import io.reactivex.internal.schedulers.j;
import io.reactivex.r;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: Schedulers.java */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    static final r f28133a = io.reactivex.f.a.e(new h());

    /* renamed from: b, reason: collision with root package name */
    static final r f28134b = io.reactivex.f.a.b(new CallableC0161b());

    /* renamed from: c, reason: collision with root package name */
    static final r f28135c = io.reactivex.f.a.c(new c());

    /* renamed from: d, reason: collision with root package name */
    static final r f28136d = j.b();

    /* renamed from: e, reason: collision with root package name */
    static final r f28137e = io.reactivex.f.a.d(new f());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final r f28138a = new io.reactivex.internal.schedulers.a();
    }

    /* compiled from: Schedulers.java */
    /* renamed from: io.reactivex.g.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static final class CallableC0161b implements Callable<r> {
        CallableC0161b() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public r call() throws Exception {
            return a.f28138a;
        }
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes3.dex */
    static final class c implements Callable<r> {
        c() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public r call() throws Exception {
            return d.f28139a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* loaded from: classes3.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        static final r f28139a = new io.reactivex.internal.schedulers.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* loaded from: classes3.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        static final r f28140a = new io.reactivex.internal.schedulers.d();
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes3.dex */
    static final class f implements Callable<r> {
        f() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public r call() throws Exception {
            return e.f28140a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* loaded from: classes3.dex */
    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        static final r f28141a = new i();
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes3.dex */
    static final class h implements Callable<r> {
        h() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public r call() throws Exception {
            return g.f28141a;
        }
    }

    public static r a() {
        return io.reactivex.f.a.a(f28134b);
    }

    public static r b() {
        return io.reactivex.f.a.b(f28135c);
    }

    public static r c() {
        return io.reactivex.f.a.c(f28133a);
    }

    public static r a(Executor executor) {
        return new ExecutorScheduler(executor, false);
    }
}
