package com.facebook.login;

import android.os.Bundle;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.login.LoginClient;

/* compiled from: GetTokenLoginMethodHandler.java */
/* loaded from: classes.dex */
class o implements PlatformServiceClient.CompletedListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LoginClient.Request f9391a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0753r f9392b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(C0753r c0753r, LoginClient.Request request) {
        this.f9392b = c0753r;
        this.f9391a = request;
    }

    @Override // com.facebook.internal.PlatformServiceClient.CompletedListener
    public void completed(Bundle bundle) {
        this.f9392b.b(this.f9391a, bundle);
    }
}
