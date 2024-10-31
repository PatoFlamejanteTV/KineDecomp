package com.facebook.share.widget;

import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.widget.JoinAppGroupDialog;

/* compiled from: JoinAppGroupDialog.java */
/* loaded from: classes.dex */
class h extends ResultProcessor {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FacebookCallback f403a;
    final /* synthetic */ JoinAppGroupDialog b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(JoinAppGroupDialog joinAppGroupDialog, FacebookCallback facebookCallback, FacebookCallback facebookCallback2) {
        super(facebookCallback);
        this.b = joinAppGroupDialog;
        this.f403a = facebookCallback2;
    }

    @Override // com.facebook.share.internal.ResultProcessor
    public void onSuccess(AppCall appCall, Bundle bundle) {
        this.f403a.onSuccess(new JoinAppGroupDialog.Result(bundle, null));
    }
}
