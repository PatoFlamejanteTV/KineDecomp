package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.share.internal.LikeDialog;

/* compiled from: LikeDialog.java */
/* loaded from: classes.dex */
class y extends ResultProcessor {

    /* renamed from: a */
    final /* synthetic */ FacebookCallback f9600a;

    /* renamed from: b */
    final /* synthetic */ LikeDialog f9601b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(LikeDialog likeDialog, FacebookCallback facebookCallback, FacebookCallback facebookCallback2) {
        super(facebookCallback);
        this.f9601b = likeDialog;
        this.f9600a = facebookCallback2;
    }

    @Override // com.facebook.share.internal.ResultProcessor
    public void onSuccess(AppCall appCall, Bundle bundle) {
        this.f9600a.onSuccess(new LikeDialog.Result(bundle));
    }
}
