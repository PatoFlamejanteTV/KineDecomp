package com.facebook.login;

import android.content.Intent;
import com.facebook.FacebookCallback;
import com.facebook.internal.CallbackManagerImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoginManager.java */
/* loaded from: classes.dex */
public class A implements CallbackManagerImpl.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FacebookCallback f9346a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ LoginManager f9347b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(LoginManager loginManager, FacebookCallback facebookCallback) {
        this.f9347b = loginManager;
        this.f9346a = facebookCallback;
    }

    @Override // com.facebook.internal.CallbackManagerImpl.Callback
    public boolean onActivityResult(int i, Intent intent) {
        return this.f9347b.onActivityResult(i, intent, this.f9346a);
    }
}
