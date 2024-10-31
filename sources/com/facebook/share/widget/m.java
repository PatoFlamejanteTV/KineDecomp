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
class m implements DialogPresenter.ParameterProvider {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppCall f407a;
    final /* synthetic */ ShareContent b;
    final /* synthetic */ boolean c;
    final /* synthetic */ MessageDialog.a d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(MessageDialog.a aVar, AppCall appCall, ShareContent shareContent, boolean z) {
        this.d = aVar;
        this.f407a = appCall;
        this.b = shareContent;
        this.c = z;
    }

    @Override // com.facebook.internal.DialogPresenter.ParameterProvider
    public Bundle getParameters() {
        return NativeDialogParameters.create(this.f407a.getCallId(), this.b, this.c);
    }

    @Override // com.facebook.internal.DialogPresenter.ParameterProvider
    public Bundle getLegacyParameters() {
        return LegacyNativeDialogParameters.create(this.f407a.getCallId(), this.b, this.c);
    }
}
