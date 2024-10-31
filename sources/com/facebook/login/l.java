package com.facebook.login;

import android.content.Intent;
import com.facebook.FacebookCallback;
import com.facebook.internal.CallbackManagerImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoginManager.java */
/* loaded from: classes.dex */
public class l implements CallbackManagerImpl.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FacebookCallback f316a;
    final /* synthetic */ LoginManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LoginManager loginManager, FacebookCallback facebookCallback) {
        this.b = loginManager;
        this.f316a = facebookCallback;
    }

    @Override // com.facebook.internal.CallbackManagerImpl.Callback
    public boolean onActivityResult(int i, Intent intent) {
        return this.b.onActivityResult(i, intent, this.f316a);
    }
}
