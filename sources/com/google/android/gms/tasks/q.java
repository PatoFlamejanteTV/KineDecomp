package com.google.android.gms.tasks;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class q implements OnTokenCanceledListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ TaskCompletionSource f14314a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(TaskCompletionSource taskCompletionSource) {
        this.f14314a = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnTokenCanceledListener
    public final void a() {
        s sVar;
        sVar = this.f14314a.f14267a;
        sVar.f();
    }
}
