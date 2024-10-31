package com.nexstreaming.app.general.iab.Presenter;

import android.content.Context;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.wxapi.WXAccessToken;
import com.nexstreaming.kinemaster.network.InterfaceC1820i;
import com.nextreaming.nexeditorui.KineMasterApplication;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABWxPresent.kt */
/* loaded from: classes2.dex */
public final class K implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ L f19345a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ io.reactivex.n f19346b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public K(L l, io.reactivex.n nVar) {
        this.f19345a = l;
        this.f19346b = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context f2 = this.f19345a.f19347a.f();
        String c2 = this.f19345a.f19347a.c();
        String k = this.f19345a.f19347a.k();
        WXAccessToken wXAccessToken = this.f19345a.f19347a.q;
        if (wXAccessToken != null) {
            String c3 = wXAccessToken.c();
            String g2 = this.f19345a.f19348b.g();
            int i = this.f19345a.f19347a.d().c(this.f19345a.f19348b.g()) ? 1 : 2;
            InterfaceC1820i q = KineMasterApplication.f24058f.c().q();
            if (q != null) {
                com.nexstreaming.kinemaster.tracelog.f.a(f2, c2, k, c3, g2, i, q.a(), this.f19345a.f19347a.h().toJson(this.f19345a.f19349c)).onResultAvailable(new I(this)).onFailure((Task.OnFailListener) new J(this));
                return;
            } else {
                kotlin.jvm.internal.h.a();
                throw null;
            }
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }
}
