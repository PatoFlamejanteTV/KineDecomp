package com.google.android.gms.tasks;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class a extends CancellationToken {

    /* renamed from: a */
    private final s<Void> f14280a = new s<>();

    @Override // com.google.android.gms.tasks.CancellationToken
    public final CancellationToken a(OnTokenCanceledListener onTokenCanceledListener) {
        this.f14280a.a(new b(this, onTokenCanceledListener));
        return this;
    }

    public final void a() {
        this.f14280a.b((s<Void>) null);
    }
}
