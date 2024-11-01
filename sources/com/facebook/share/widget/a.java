package com.facebook.share.widget;

import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.widget.AppInviteDialog;

/* compiled from: AppInviteDialog.java */
/* loaded from: classes.dex */
class a extends ResultProcessor {

    /* renamed from: a */
    final /* synthetic */ FacebookCallback f396a;
    final /* synthetic */ AppInviteDialog b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AppInviteDialog appInviteDialog, FacebookCallback facebookCallback, FacebookCallback facebookCallback2) {
        super(facebookCallback);
        this.b = appInviteDialog;
        this.f396a = facebookCallback2;
    }

    @Override // com.facebook.share.internal.ResultProcessor
    public void onSuccess(AppCall appCall, Bundle bundle) {
        if ("cancel".equalsIgnoreCase(ShareInternalUtility.getNativeDialogCompletionGesture(bundle))) {
            this.f396a.onCancel();
        } else {
            this.f396a.onSuccess(new AppInviteDialog.Result(bundle));
        }
    }
}
