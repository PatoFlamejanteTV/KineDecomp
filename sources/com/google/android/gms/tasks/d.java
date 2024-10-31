package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Task f14285a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ c f14286b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, Task task) {
        this.f14286b = cVar;
        this.f14285a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        s sVar;
        s sVar2;
        s sVar3;
        Continuation continuation;
        s sVar4;
        s sVar5;
        if (this.f14285a.c()) {
            sVar5 = this.f14286b.f14284c;
            sVar5.f();
            return;
        }
        try {
            continuation = this.f14286b.f14283b;
            Object then = continuation.then(this.f14285a);
            sVar4 = this.f14286b.f14284c;
            sVar4.a((s) then);
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                sVar3 = this.f14286b.f14284c;
                sVar3.a((Exception) e2.getCause());
            } else {
                sVar2 = this.f14286b.f14284c;
                sVar2.a((Exception) e2);
            }
        } catch (Exception e3) {
            sVar = this.f14286b.f14284c;
            sVar.a(e3);
        }
    }
}
