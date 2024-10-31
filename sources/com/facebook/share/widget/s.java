package com.facebook.share.widget;

import android.os.Bundle;
import com.facebook.internal.AppCall;
import com.facebook.internal.DialogPresenter;
import com.facebook.share.internal.LegacyNativeDialogParameters;
import com.facebook.share.internal.NativeDialogParameters;
import com.facebook.share.model.ShareContent;
import com.facebook.share.widget.ShareDialog;

/* compiled from: ShareDialog.java */
/* loaded from: classes.dex */
class s implements DialogPresenter.ParameterProvider {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppCall f9654a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ShareContent f9655b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f9656c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ShareDialog.d f9657d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ShareDialog.d dVar, AppCall appCall, ShareContent shareContent, boolean z) {
        this.f9657d = dVar;
        this.f9654a = appCall;
        this.f9655b = shareContent;
        this.f9656c = z;
    }

    @Override // com.facebook.internal.DialogPresenter.ParameterProvider
    public Bundle getLegacyParameters() {
        return LegacyNativeDialogParameters.create(this.f9654a.getCallId(), this.f9655b, this.f9656c);
    }

    @Override // com.facebook.internal.DialogPresenter.ParameterProvider
    public Bundle getParameters() {
        return NativeDialogParameters.create(this.f9654a.getCallId(), this.f9655b, this.f9656c);
    }
}
