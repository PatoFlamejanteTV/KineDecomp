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

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FacebookCallback f9619a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AppInviteDialog f9620b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AppInviteDialog appInviteDialog, FacebookCallback facebookCallback, FacebookCallback facebookCallback2) {
        super(facebookCallback);
        this.f9620b = appInviteDialog;
        this.f9619a = facebookCallback2;
    }

    @Override // com.facebook.share.internal.ResultProcessor
    public void onSuccess(AppCall appCall, Bundle bundle) {
        if ("cancel".equalsIgnoreCase(ShareInternalUtility.getNativeDialogCompletionGesture(bundle))) {
            this.f9619a.onCancel();
        } else {
            this.f9619a.onSuccess(new AppInviteDialog.Result(bundle));
        }
    }
}
