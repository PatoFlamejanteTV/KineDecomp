package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.ads.zzaan;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzwu;
import com.google.android.gms.internal.ads.zzxa;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class A extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbp f9985a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(zzbp zzbpVar) {
        this.f9985a = zzbpVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        zzxa zzxaVar;
        zzxa zzxaVar2;
        zzxaVar = this.f9985a.f10239g;
        if (zzxaVar != null) {
            try {
                zzxaVar2 = this.f9985a.f10239g;
                zzxaVar2.onAdFailedToLoad(0);
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        zzxa zzxaVar;
        zzxa zzxaVar2;
        String g2;
        zzxa zzxaVar3;
        zzxa zzxaVar4;
        zzxa zzxaVar5;
        zzxa zzxaVar6;
        zzxa zzxaVar7;
        zzxa zzxaVar8;
        if (str.startsWith(this.f9985a.B())) {
            return false;
        }
        if (str.startsWith((String) zzwu.zzpz().zzd(zzaan.zzcvd))) {
            zzxaVar7 = this.f9985a.f10239g;
            if (zzxaVar7 != null) {
                try {
                    zzxaVar8 = this.f9985a.f10239g;
                    zzxaVar8.onAdFailedToLoad(3);
                } catch (RemoteException e2) {
                    zzbbd.zzd("#007 Could not call remote method.", e2);
                }
            }
            this.f9985a.c(0);
            return true;
        }
        if (str.startsWith((String) zzwu.zzpz().zzd(zzaan.zzcve))) {
            zzxaVar5 = this.f9985a.f10239g;
            if (zzxaVar5 != null) {
                try {
                    zzxaVar6 = this.f9985a.f10239g;
                    zzxaVar6.onAdFailedToLoad(0);
                } catch (RemoteException e3) {
                    zzbbd.zzd("#007 Could not call remote method.", e3);
                }
            }
            this.f9985a.c(0);
            return true;
        }
        if (str.startsWith((String) zzwu.zzpz().zzd(zzaan.zzcvf))) {
            zzxaVar3 = this.f9985a.f10239g;
            if (zzxaVar3 != null) {
                try {
                    zzxaVar4 = this.f9985a.f10239g;
                    zzxaVar4.onAdLoaded();
                } catch (RemoteException e4) {
                    zzbbd.zzd("#007 Could not call remote method.", e4);
                }
            }
            this.f9985a.c(this.f9985a.f(str));
            return true;
        }
        if (str.startsWith("gmsg://")) {
            return true;
        }
        zzxaVar = this.f9985a.f10239g;
        if (zzxaVar != null) {
            try {
                zzxaVar2 = this.f9985a.f10239g;
                zzxaVar2.onAdLeftApplication();
            } catch (RemoteException e5) {
                zzbbd.zzd("#007 Could not call remote method.", e5);
            }
        }
        g2 = this.f9985a.g(str);
        this.f9985a.h(g2);
        return true;
    }
}
