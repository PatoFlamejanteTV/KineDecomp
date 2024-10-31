package com.facebook.share.internal;

import android.os.Bundle;
import android.util.Log;
import com.facebook.internal.DialogPresenter;
import com.facebook.share.internal.LikeDialog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LikeDialog.java */
/* loaded from: classes.dex */
public class A implements DialogPresenter.ParameterProvider {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LikeContent f9498a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ LikeDialog.a f9499b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(LikeDialog.a aVar, LikeContent likeContent) {
        this.f9499b = aVar;
        this.f9498a = likeContent;
    }

    @Override // com.facebook.internal.DialogPresenter.ParameterProvider
    public Bundle getLegacyParameters() {
        Log.e("LikeDialog", "Attempting to present the Like Dialog with an outdated Facebook app on the device");
        return new Bundle();
    }

    @Override // com.facebook.internal.DialogPresenter.ParameterProvider
    public Bundle getParameters() {
        return LikeDialog.createParameters(this.f9498a);
    }
}
