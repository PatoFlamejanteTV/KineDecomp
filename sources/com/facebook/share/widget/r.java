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
class r implements DialogPresenter.ParameterProvider {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppCall f9650a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ShareContent f9651b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f9652c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ShareDialog.c f9653d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ShareDialog.c cVar, AppCall appCall, ShareContent shareContent, boolean z) {
        this.f9653d = cVar;
        this.f9650a = appCall;
        this.f9651b = shareContent;
        this.f9652c = z;
    }

    @Override // com.facebook.internal.DialogPresenter.ParameterProvider
    public Bundle getLegacyParameters() {
        return LegacyNativeDialogParameters.create(this.f9650a.getCallId(), this.f9651b, this.f9652c);
    }

    @Override // com.facebook.internal.DialogPresenter.ParameterProvider
    public Bundle getParameters() {
        return NativeDialogParameters.create(this.f9650a.getCallId(), this.f9651b, this.f9652c);
    }
}
