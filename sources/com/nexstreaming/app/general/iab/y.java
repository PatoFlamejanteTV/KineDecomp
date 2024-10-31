package com.nexstreaming.app.general.iab;

import com.nexstreaming.app.general.iab.Presenter.IABBasePresent;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABManager.kt */
/* loaded from: classes2.dex */
public final class y<T> implements io.reactivex.c.e<com.nexstreaming.app.general.iab.b.a> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IABManager f19497a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(IABManager iABManager) {
        this.f19497a = iABManager;
    }

    @Override // io.reactivex.c.e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(com.nexstreaming.app.general.iab.b.a aVar) {
        boolean z;
        boolean z2;
        if (aVar.a() == BillingResponse.OK.getIntErrorCode()) {
            this.f19497a.x();
            this.f19497a.y();
            this.f19497a.D();
            IABManager iABManager = this.f19497a;
            int ordinal = IABError.NoError.ordinal();
            z2 = this.f19497a.z;
            iABManager.a(true, ordinal, z2);
        } else {
            IABManager iABManager2 = this.f19497a;
            int ordinal2 = IABError.RemoteServiceError.ordinal();
            z = this.f19497a.z;
            iABManager2.a(false, ordinal2, z);
        }
        this.f19497a.a(IABBasePresent.State.NONE);
    }
}
