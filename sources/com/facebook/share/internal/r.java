package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.share.internal.LikeDialog;

/* compiled from: LikeDialog.java */
/* loaded from: classes.dex */
class r extends ResultProcessor {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FacebookCallback f374a;
    final /* synthetic */ LikeDialog b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(LikeDialog likeDialog, FacebookCallback facebookCallback, FacebookCallback facebookCallback2) {
        super(facebookCallback);
        this.b = likeDialog;
        this.f374a = facebookCallback2;
    }

    @Override // com.facebook.share.internal.ResultProcessor
    public void onSuccess(AppCall appCall, Bundle bundle) {
        this.f374a.onSuccess(new LikeDialog.Result(bundle));
    }
}
