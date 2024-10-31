package com.facebook.login;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoginManager.java */
/* loaded from: classes.dex */
public class m implements CallbackManagerImpl.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LoginManager f317a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(LoginManager loginManager) {
        this.f317a = loginManager;
    }

    @Override // com.facebook.internal.CallbackManagerImpl.Callback
    public boolean onActivityResult(int i, Intent intent) {
        return this.f317a.onActivityResult(i, intent);
    }
}
