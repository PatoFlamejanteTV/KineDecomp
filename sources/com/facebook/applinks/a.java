package com.facebook.applinks;

import android.content.Context;
import com.facebook.applinks.AppLinkData;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppLinkData.java */
/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f257a;
    final /* synthetic */ String b;
    final /* synthetic */ AppLinkData.CompletionHandler c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, String str, AppLinkData.CompletionHandler completionHandler) {
        this.f257a = context;
        this.b = str;
        this.c = completionHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppLinkData.fetchDeferredAppLinkFromServer(this.f257a, this.b, this.c);
    }
}
