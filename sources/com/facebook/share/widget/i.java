package com.facebook.share.widget;

import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.widget.JoinAppGroupDialog;

/* compiled from: JoinAppGroupDialog.java */
/* loaded from: classes.dex */
class i extends ResultProcessor {

    /* renamed from: a */
    final /* synthetic */ FacebookCallback f9634a;

    /* renamed from: b */
    final /* synthetic */ JoinAppGroupDialog f9635b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(JoinAppGroupDialog joinAppGroupDialog, FacebookCallback facebookCallback, FacebookCallback facebookCallback2) {
        super(facebookCallback);
        this.f9635b = joinAppGroupDialog;
        this.f9634a = facebookCallback2;
    }

    @Override // com.facebook.share.internal.ResultProcessor
    public void onSuccess(AppCall appCall, Bundle bundle) {
        this.f9634a.onSuccess(new JoinAppGroupDialog.Result(bundle, null));
    }
}
