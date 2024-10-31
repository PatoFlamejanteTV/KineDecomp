package com.nexstreaming.app.general.iab.Presenter;

import android.content.Context;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.wxapi.WXAccessToken;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABWxPresent.kt */
/* loaded from: classes2.dex */
public final class O implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ P f19352a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ io.reactivex.n f19353b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public O(P p, io.reactivex.n nVar) {
        this.f19352a = p;
        this.f19353b = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context f2 = this.f19352a.f19354a.f();
        String c2 = this.f19352a.f19354a.c();
        WXAccessToken wXAccessToken = this.f19352a.f19354a.q;
        if (wXAccessToken != null) {
            com.nexstreaming.kinemaster.tracelog.f.b(f2, c2, wXAccessToken.c()).onResultAvailable(new M(this)).onFailure((Task.OnFailListener) new N(this));
        } else {
            kotlin.jvm.internal.h.a();
            throw null;
        }
    }
}
