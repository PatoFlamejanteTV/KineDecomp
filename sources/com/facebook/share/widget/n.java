package com.facebook.share.widget;

import android.os.Bundle;
import com.facebook.internal.AppCall;
import com.facebook.internal.DialogPresenter;
import com.facebook.share.internal.LegacyNativeDialogParameters;
import com.facebook.share.internal.NativeDialogParameters;
import com.facebook.share.model.ShareContent;
import com.facebook.share.widget.MessageDialog;

/* compiled from: MessageDialog.java */
/* loaded from: classes.dex */
class n implements DialogPresenter.ParameterProvider {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppCall f9640a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ShareContent f9641b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f9642c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ MessageDialog.a f9643d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(MessageDialog.a aVar, AppCall appCall, ShareContent shareContent, boolean z) {
        this.f9643d = aVar;
        this.f9640a = appCall;
        this.f9641b = shareContent;
        this.f9642c = z;
    }

    @Override // com.facebook.internal.DialogPresenter.ParameterProvider
    public Bundle getLegacyParameters() {
        return LegacyNativeDialogParameters.create(this.f9640a.getCallId(), this.f9641b, this.f9642c);
    }

    @Override // com.facebook.internal.DialogPresenter.ParameterProvider
    public Bundle getParameters() {
        return NativeDialogParameters.create(this.f9640a.getCallId(), this.f9641b, this.f9642c);
    }
}
