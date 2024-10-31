package com.facebook.share.widget;

import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.widget.CreateAppGroupDialog;

/* compiled from: CreateAppGroupDialog.java */
/* loaded from: classes.dex */
class d extends ResultProcessor {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FacebookCallback f399a;
    final /* synthetic */ CreateAppGroupDialog b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(CreateAppGroupDialog createAppGroupDialog, FacebookCallback facebookCallback, FacebookCallback facebookCallback2) {
        super(facebookCallback);
        this.b = createAppGroupDialog;
        this.f399a = facebookCallback2;
    }

    @Override // com.facebook.share.internal.ResultProcessor
    public void onSuccess(AppCall appCall, Bundle bundle) {
        this.f399a.onSuccess(new CreateAppGroupDialog.Result(bundle.getString(ShareConstants.WEB_DIALOG_PARAM_ID), null));
    }
}
