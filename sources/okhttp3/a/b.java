package okhttp3.a;

/* compiled from: NamedRunnable.java */
/* loaded from: classes3.dex */
public abstract class b implements Runnable {

    /* renamed from: a */
    protected final String f28871a;

    public b(String str, Object... objArr) {
        this.f28871a = e.a(str, objArr);
    }

    protected abstract void c();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f28871a);
        try {
            c();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
