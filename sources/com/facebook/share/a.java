package com.facebook.share;

import android.content.Intent;
import com.facebook.FacebookCallback;
import com.facebook.FacebookRequestError;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.DeviceShareDialog;

/* compiled from: DeviceShareDialog.java */
/* loaded from: classes.dex */
class a implements CallbackManagerImpl.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FacebookCallback f9469a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ DeviceShareDialog f9470b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(DeviceShareDialog deviceShareDialog, FacebookCallback facebookCallback) {
        this.f9470b = deviceShareDialog;
        this.f9469a = facebookCallback;
    }

    @Override // com.facebook.internal.CallbackManagerImpl.Callback
    public boolean onActivityResult(int i, Intent intent) {
        if (intent.hasExtra("error")) {
            this.f9469a.onError(((FacebookRequestError) intent.getParcelableExtra("error")).getException());
            return true;
        }
        this.f9469a.onSuccess(new DeviceShareDialog.Result());
        return true;
    }
}
