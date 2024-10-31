package com.nexstreaming.app.general.iab;

import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABManager.kt */
/* loaded from: classes2.dex */
public final class e<T> implements io.reactivex.c.e<Throwable> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IABManager f19471a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(IABManager iABManager) {
        this.f19471a = iABManager;
    }

    @Override // io.reactivex.c.e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(Throwable th) {
        String r = this.f19471a.r();
        StringBuilder sb = new StringBuilder();
        sb.append("consumeItem onError : ");
        sb.append(th != null ? th.getMessage() : null);
        Log.d(r, sb.toString());
    }
}
