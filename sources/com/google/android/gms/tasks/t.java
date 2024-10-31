package com.google.android.gms.tasks;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class t implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ s f14322a;

    /* renamed from: b */
    private final /* synthetic */ Callable f14323b;

    public t(s sVar, Callable callable) {
        this.f14322a = sVar;
        this.f14323b = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f14322a.a((s) this.f14323b.call());
        } catch (Exception e2) {
            this.f14322a.a(e2);
        }
    }
}
