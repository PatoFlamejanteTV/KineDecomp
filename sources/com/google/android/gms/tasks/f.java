package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Task f14290a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ e f14291b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, Task task) {
        this.f14291b = eVar;
        this.f14290a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        s sVar;
        s sVar2;
        s sVar3;
        Continuation continuation;
        try {
            continuation = this.f14291b.f14288b;
            Task task = (Task) continuation.then(this.f14290a);
            if (task == null) {
                this.f14291b.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            task.a(TaskExecutors.f14269b, (OnSuccessListener) this.f14291b);
            task.a(TaskExecutors.f14269b, (OnFailureListener) this.f14291b);
            task.a(TaskExecutors.f14269b, (OnCanceledListener) this.f14291b);
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                sVar3 = this.f14291b.f14289c;
                sVar3.a((Exception) e2.getCause());
            } else {
                sVar2 = this.f14291b.f14289c;
                sVar2.a((Exception) e2);
            }
        } catch (Exception e3) {
            sVar = this.f14291b.f14289c;
            sVar.a(e3);
        }
    }
}
