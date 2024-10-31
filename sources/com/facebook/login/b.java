package com.facebook.login;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoginManager.java */
/* loaded from: classes.dex */
public class B implements CallbackManagerImpl.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LoginManager f9348a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public B(LoginManager loginManager) {
        this.f9348a = loginManager;
    }

    @Override // com.facebook.internal.CallbackManagerImpl.Callback
    public boolean onActivityResult(int i, Intent intent) {
        return this.f9348a.onActivityResult(i, intent);
    }
}
