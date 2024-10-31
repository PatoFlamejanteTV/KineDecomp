package com.google.android.gms.internal;

/* loaded from: classes.dex */
class ek implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzjd f1530a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ek(zzjd zzjdVar) {
        this.f1530a = zzjdVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        super/*android.webkit.WebView*/.destroy();
    }
}
