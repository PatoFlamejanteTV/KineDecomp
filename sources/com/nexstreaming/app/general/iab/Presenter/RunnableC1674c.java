package com.nexstreaming.app.general.iab.Presenter;

import com.nexstreaming.kinemaster.network.InterfaceC1820i;
import com.nextreaming.nexeditorui.KineMasterApplication;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABBasePresent.kt */
/* renamed from: com.nexstreaming.app.general.iab.Presenter.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1674c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1675d f19370a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ io.reactivex.n f19371b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1674c(C1675d c1675d, io.reactivex.n nVar) {
        this.f19370a = c1675d;
        this.f19371b = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC1820i q = KineMasterApplication.f24058f.c().q();
        if (q != null) {
            q.d().onResultAvailable(new C1673b(this));
        } else {
            kotlin.jvm.internal.h.a();
            throw null;
        }
    }
}
