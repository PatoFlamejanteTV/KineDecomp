package com.facebook.share.internal;

import android.content.Intent;
import com.facebook.FacebookCallback;
import com.facebook.internal.CallbackManagerImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareInternalUtility.java */
/* loaded from: classes.dex */
public class J implements CallbackManagerImpl.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f9510a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ FacebookCallback f9511b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public J(int i, FacebookCallback facebookCallback) {
        this.f9510a = i;
        this.f9511b = facebookCallback;
    }

    @Override // com.facebook.internal.CallbackManagerImpl.Callback
    public boolean onActivityResult(int i, Intent intent) {
        return ShareInternalUtility.handleActivityResult(this.f9510a, i, intent, ShareInternalUtility.getShareResultProcessor(this.f9511b));
    }
}
