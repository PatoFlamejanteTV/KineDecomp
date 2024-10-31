package com.facebook.applinks;

import android.content.Context;
import com.facebook.applinks.AppLinkData;

/* compiled from: AppLinkData.java */
/* loaded from: classes.dex */
public class a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f9235a;

    /* renamed from: b */
    final /* synthetic */ String f9236b;

    /* renamed from: c */
    final /* synthetic */ AppLinkData.CompletionHandler f9237c;

    public a(Context context, String str, AppLinkData.CompletionHandler completionHandler) {
        this.f9235a = context;
        this.f9236b = str;
        this.f9237c = completionHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppLinkData.fetchDeferredAppLinkFromServer(this.f9235a, this.f9236b, this.f9237c);
    }
}
