package com.facebook.share.widget;

import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.widget.GameRequestDialog;

/* compiled from: GameRequestDialog.java */
/* loaded from: classes.dex */
class g extends ResultProcessor {

    /* renamed from: a */
    final /* synthetic */ FacebookCallback f9630a;

    /* renamed from: b */
    final /* synthetic */ GameRequestDialog f9631b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(GameRequestDialog gameRequestDialog, FacebookCallback facebookCallback, FacebookCallback facebookCallback2) {
        super(facebookCallback);
        this.f9631b = gameRequestDialog;
        this.f9630a = facebookCallback2;
    }

    @Override // com.facebook.share.internal.ResultProcessor
    public void onSuccess(AppCall appCall, Bundle bundle) {
        if (bundle != null) {
            this.f9630a.onSuccess(new GameRequestDialog.Result(bundle, null));
        } else {
            onCancel(appCall);
        }
    }
}
