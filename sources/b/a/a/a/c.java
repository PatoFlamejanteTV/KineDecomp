package b.a.a.a;

import java.util.concurrent.Executor;

/* compiled from: ArchTaskExecutor.java */
/* loaded from: classes.dex */
public class c extends e {

    /* renamed from: a */
    private static volatile c f3215a;

    /* renamed from: b */
    private static final Executor f3216b = new a();

    /* renamed from: c */
    private static final Executor f3217c = new b();

    /* renamed from: e */
    private e f3219e = new d();

    /* renamed from: d */
    private e f3218d = this.f3219e;

    private c() {
    }

    public static c b() {
        if (f3215a != null) {
            return f3215a;
        }
        synchronized (c.class) {
            if (f3215a == null) {
                f3215a = new c();
            }
        }
        return f3215a;
    }

    @Override // b.a.a.a.e
    public void a(Runnable runnable) {
        this.f3218d.a(runnable);
    }

    @Override // b.a.a.a.e
    public boolean a() {
        return this.f3218d.a();
    }

    @Override // b.a.a.a.e
    public void b(Runnable runnable) {
        this.f3218d.b(runnable);
    }
}
