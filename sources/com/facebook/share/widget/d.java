package com.facebook.share.widget;

import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.widget.CreateAppGroupDialog;

/* compiled from: CreateAppGroupDialog.java */
/* loaded from: classes.dex */
class d extends ResultProcessor {

    /* renamed from: a */
    final /* synthetic */ FacebookCallback f9625a;

    /* renamed from: b */
    final /* synthetic */ CreateAppGroupDialog f9626b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(CreateAppGroupDialog createAppGroupDialog, FacebookCallback facebookCallback, FacebookCallback facebookCallback2) {
        super(facebookCallback);
        this.f9626b = createAppGroupDialog;
        this.f9625a = facebookCallback2;
    }

    @Override // com.facebook.share.internal.ResultProcessor
    public void onSuccess(AppCall appCall, Bundle bundle) {
        this.f9625a.onSuccess(new CreateAppGroupDialog.Result(bundle.getString("id"), null));
    }
}
