package com.facebook.share.internal;

import android.os.Bundle;
import android.util.Log;
import com.facebook.internal.DialogPresenter;
import com.facebook.share.internal.LikeDialog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LikeDialog.java */
/* loaded from: classes.dex */
public class t implements DialogPresenter.ParameterProvider {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LikeContent f376a;
    final /* synthetic */ LikeDialog.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(LikeDialog.a aVar, LikeContent likeContent) {
        this.b = aVar;
        this.f376a = likeContent;
    }

    @Override // com.facebook.internal.DialogPresenter.ParameterProvider
    public Bundle getParameters() {
        return LikeDialog.createParameters(this.f376a);
    }

    @Override // com.facebook.internal.DialogPresenter.ParameterProvider
    public Bundle getLegacyParameters() {
        Log.e("LikeDialog", "Attempting to present the Like Dialog with an outdated Facebook app on the device");
        return new Bundle();
    }
}
