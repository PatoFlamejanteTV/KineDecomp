package com.nexstreaming.app.general.iab.Presenter;

import android.content.Context;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.wxapi.WXAccessToken;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABWxPresent.kt */
/* loaded from: classes2.dex */
public final class T implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ U f19358a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ io.reactivex.n f19359b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public T(U u, io.reactivex.n nVar) {
        this.f19358a = u;
        this.f19359b = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        Context f2 = this.f19358a.f19360a.f();
        String c2 = this.f19358a.f19360a.c();
        WXAccessToken wXAccessToken = this.f19358a.f19360a.q;
        if (wXAccessToken != null) {
            String c3 = wXAccessToken.c();
            z = this.f19358a.f19360a.r;
            com.nexstreaming.kinemaster.tracelog.f.a(f2, c2, c3, z).onResultAvailable(new Q(this)).onFailure((Task.OnFailListener) new S(this));
            return;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }
}
