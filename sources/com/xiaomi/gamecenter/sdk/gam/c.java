package com.xiaomi.gamecenter.sdk.gam;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4894a;
    final /* synthetic */ String b;
    final /* synthetic */ MiResponseListener c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(MiResponseListener miResponseListener, int i, String str) {
        this.c = miResponseListener;
        this.f4894a = i;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.onResponseStatus(this.f4894a, this.b);
    }
}
