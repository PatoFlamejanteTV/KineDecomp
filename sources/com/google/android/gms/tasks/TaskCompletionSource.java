package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
public class TaskCompletionSource<TResult> {

    /* renamed from: a */
    private final s<TResult> f14267a = new s<>();

    public TaskCompletionSource() {
    }

    public void a(TResult tresult) {
        this.f14267a.a((s<TResult>) tresult);
    }

    public boolean b(TResult tresult) {
        return this.f14267a.b((s<TResult>) tresult);
    }

    public void a(Exception exc) {
        this.f14267a.a(exc);
    }

    public boolean b(Exception exc) {
        return this.f14267a.b(exc);
    }

    public TaskCompletionSource(CancellationToken cancellationToken) {
        cancellationToken.a(new q(this));
    }

    public Task<TResult> a() {
        return this.f14267a;
    }
}
