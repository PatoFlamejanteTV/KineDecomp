package com.nexstreaming.app.kinemasterfree.wxapi;

import android.util.Log;
import com.nexstreaming.app.kinemasterfree.wxapi.e;

/* compiled from: WXEntryActivity.java */
/* loaded from: classes2.dex */
class f implements e.a<WXAccessToken> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WXEntryActivity f19927a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(WXEntryActivity wXEntryActivity) {
        this.f19927a = wXEntryActivity;
    }

    @Override // com.nexstreaming.app.kinemasterfree.wxapi.e.a
    public void onError(Exception exc) {
        Log.d("WXEntryActivity", "onError() called with: error = [" + exc + "]");
        e.c().a();
        this.f19927a.finish();
    }

    @Override // com.nexstreaming.app.kinemasterfree.wxapi.e.a
    public void a(WXAccessToken wXAccessToken) {
        Log.i("WXEntryActivity", "onResponse() called with: result = [" + wXAccessToken + "]");
        e.c().a(wXAccessToken);
        this.f19927a.finish();
    }
}
