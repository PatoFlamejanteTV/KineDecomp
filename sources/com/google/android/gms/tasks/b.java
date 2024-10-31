package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
final class b implements OnSuccessListener<Void> {

    /* renamed from: a */
    private final /* synthetic */ OnTokenCanceledListener f14281a;

    public b(a aVar, OnTokenCanceledListener onTokenCanceledListener) {
        this.f14281a = onTokenCanceledListener;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final /* synthetic */ void onSuccess(Void r1) {
        this.f14281a.a();
    }
}
