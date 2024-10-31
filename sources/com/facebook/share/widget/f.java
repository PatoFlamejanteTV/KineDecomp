package com.facebook.share.widget;

import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.widget.GameRequestDialog;

/* compiled from: GameRequestDialog.java */
/* loaded from: classes.dex */
class f extends ResultProcessor {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FacebookCallback f401a;
    final /* synthetic */ GameRequestDialog b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(GameRequestDialog gameRequestDialog, FacebookCallback facebookCallback, FacebookCallback facebookCallback2) {
        super(facebookCallback);
        this.b = gameRequestDialog;
        this.f401a = facebookCallback2;
    }

    @Override // com.facebook.share.internal.ResultProcessor
    public void onSuccess(AppCall appCall, Bundle bundle) {
        if (bundle != null) {
            this.f401a.onSuccess(new GameRequestDialog.Result(bundle, null));
        } else {
            onCancel(appCall);
        }
    }
}
