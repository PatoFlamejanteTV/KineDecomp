package com.nexstreaming.app.general.iab.Presenter;

import android.content.Context;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.wxapi.WXAccessToken;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABWxPresent.kt */
/* loaded from: classes2.dex */
public final class X implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Y f19363a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ io.reactivex.n f19364b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public X(Y y, io.reactivex.n nVar) {
        this.f19363a = y;
        this.f19364b = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context f2 = this.f19363a.f19365a.f();
        String c2 = this.f19363a.f19365a.c();
        WXAccessToken wXAccessToken = this.f19363a.f19365a.q;
        if (wXAccessToken != null) {
            com.nexstreaming.kinemaster.tracelog.f.b(f2, c2, wXAccessToken.c()).onResultAvailable(new V(this)).onFailure((Task.OnFailListener) new W(this));
        } else {
            kotlin.jvm.internal.h.a();
            throw null;
        }
    }
}
