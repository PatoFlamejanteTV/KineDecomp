package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class Nf implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Lf f11711a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Nf(Lf lf) {
        this.f11711a = lf;
    }

    @Override // java.lang.Runnable
    public final void run() {
        super/*android.webkit.WebView*/.destroy();
    }
}
