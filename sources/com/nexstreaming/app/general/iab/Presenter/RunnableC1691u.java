package com.nexstreaming.app.general.iab.Presenter;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.network.InterfaceC1820i;
import com.nextreaming.nexeditorui.KineMasterApplication;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABGooglePresent.kt */
/* renamed from: com.nexstreaming.app.general.iab.Presenter.u, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1691u implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1692v f19409a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ io.reactivex.n f19410b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1691u(C1692v c1692v, io.reactivex.n nVar) {
        this.f19409a = c1692v;
        this.f19410b = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC1820i q = KineMasterApplication.f24058f.c().q();
        if (q != null) {
            q.e().onResultAvailable(new C1689s(this)).onFailure((Task.OnFailListener) new C1690t(this));
        } else {
            kotlin.jvm.internal.h.a();
            throw null;
        }
    }
}
