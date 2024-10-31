package com.facebook.share.internal;

import android.content.Intent;
import com.facebook.FacebookCallback;
import com.facebook.internal.CallbackManagerImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareInternalUtility.java */
/* loaded from: classes.dex */
public final class z implements CallbackManagerImpl.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f380a;
    final /* synthetic */ FacebookCallback b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(int i, FacebookCallback facebookCallback) {
        this.f380a = i;
        this.b = facebookCallback;
    }

    @Override // com.facebook.internal.CallbackManagerImpl.Callback
    public boolean onActivityResult(int i, Intent intent) {
        return ShareInternalUtility.handleActivityResult(this.f380a, i, intent, ShareInternalUtility.getShareResultProcessor(this.b));
    }
}
