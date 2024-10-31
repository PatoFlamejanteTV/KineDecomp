package bolts;

/* compiled from: TaskCompletionSource.java */
/* loaded from: classes.dex */
public class q<TResult> {

    /* renamed from: a */
    private final p<TResult> f3415a = new p<>();

    public p<TResult> a() {
        return this.f3415a;
    }

    public boolean b(TResult tresult) {
        return this.f3415a.b((p<TResult>) tresult);
    }

    public boolean c() {
        return this.f3415a.i();
    }

    public void a(TResult tresult) {
        if (!b((q<TResult>) tresult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    public boolean b(Exception exc) {
        return this.f3415a.b(exc);
    }

    public void b() {
        if (!c()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public void a(Exception exc) {
        if (!b(exc)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }
}
