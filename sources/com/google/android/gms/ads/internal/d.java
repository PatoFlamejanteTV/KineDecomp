package com.google.android.gms.ads.internal;

import android.os.AsyncTask;
import android.webkit.WebView;
import com.google.android.gms.internal.ads.zzaan;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzcu;
import com.google.android.gms.internal.ads.zzwu;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
final class D extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbp f9988a;

    private D(zzbp zzbpVar) {
        this.f9988a = zzbpVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final String doInBackground(Void... voidArr) {
        Future future;
        try {
            zzbp zzbpVar = this.f9988a;
            future = this.f9988a.f10235c;
            zzbpVar.f10240h = (zzcu) future.get(((Long) zzwu.zzpz().zzd(zzaan.zzcvi)).longValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            zzbbd.zzc("", e2);
        }
        return this.f9988a.A();
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(String str) {
        WebView webView;
        WebView webView2;
        String str2 = str;
        webView = this.f9988a.f10238f;
        if (webView == null || str2 == null) {
            return;
        }
        webView2 = this.f9988a.f10238f;
        webView2.loadUrl(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ D(zzbp zzbpVar, A a2) {
        this(zzbpVar);
    }
}
