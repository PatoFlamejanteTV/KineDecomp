package com.google.android.gms.internal;

import android.webkit.WebView;
import org.keyczar.Keyczar;

/* loaded from: classes.dex */
class cj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1476a;
    final /* synthetic */ String b;
    final /* synthetic */ zzfq c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(zzfq zzfqVar, String str, String str2) {
        this.c = zzfqVar;
        this.f1476a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        WebView zzfh = this.c.zzfh();
        zzfh.setWebViewClient(new ck(this, zzfh));
        this.c.zzCr.add(zzfh);
        zzfh.loadDataWithBaseURL(this.f1476a, this.b, "text/html", Keyczar.DEFAULT_ENCODING, null);
        com.google.android.gms.ads.internal.util.client.zzb.a("Fetching assets finished.");
    }
}
