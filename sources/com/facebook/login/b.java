package com.facebook.login;

import android.os.Bundle;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.login.LoginClient;

/* compiled from: GetTokenLoginMethodHandler.java */
/* loaded from: classes.dex */
class b implements PlatformServiceClient.CompletedListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LoginClient.Request f311a;
    final /* synthetic */ GetTokenLoginMethodHandler b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(GetTokenLoginMethodHandler getTokenLoginMethodHandler, LoginClient.Request request) {
        this.b = getTokenLoginMethodHandler;
        this.f311a = request;
    }

    @Override // com.facebook.internal.PlatformServiceClient.CompletedListener
    public void completed(Bundle bundle) {
        this.b.a(this.f311a, bundle);
    }
}
