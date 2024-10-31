package com.xiaomi.gamecenter.sdk.gam;

/* loaded from: classes3.dex */
public class c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f26601a;

    /* renamed from: b */
    final /* synthetic */ String f26602b;

    /* renamed from: c */
    final /* synthetic */ MiResponseListener f26603c;

    public c(MiResponseListener miResponseListener, int i, String str) {
        this.f26603c = miResponseListener;
        this.f26601a = i;
        this.f26602b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f26603c.onResponseStatus(this.f26601a, this.f26602b);
    }
}
