package com.nexstreaming.app.kinemasterfree.wxapi;

import android.util.Log;
import com.nexstreaming.app.kinemasterfree.wxapi.b;

/* compiled from: WXEntryActivity.java */
/* loaded from: classes.dex */
class e implements b.a<WXAccessToken> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WXEntryActivity f3252a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WXEntryActivity wXEntryActivity) {
        this.f3252a = wXEntryActivity;
    }

    @Override // com.nexstreaming.app.kinemasterfree.wxapi.b.a
    public void a(WXAccessToken wXAccessToken) {
        Log.i("WXEntryActivity", "onResponse() called with: result = [" + wXAccessToken + "]");
        b.a().a(wXAccessToken);
        this.f3252a.finish();
    }

    @Override // com.nexstreaming.app.kinemasterfree.wxapi.b.a
    public void a(Exception exc) {
        Log.d("WXEntryActivity", "onError() called with: error = [" + exc + "]");
        b.a().c();
        this.f3252a.finish();
    }
}
