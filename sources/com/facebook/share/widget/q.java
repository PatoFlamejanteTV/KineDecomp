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
class q implements DialogPresenter.ParameterProvider {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppCall f9646a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ShareContent f9647b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f9648c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ShareDialog.a f9649d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ShareDialog.a aVar, AppCall appCall, ShareContent shareContent, boolean z) {
        this.f9649d = aVar;
        this.f9646a = appCall;
        this.f9647b = shareContent;
        this.f9648c = z;
    }

    @Override // com.facebook.internal.DialogPresenter.ParameterProvider
    public Bundle getLegacyParameters() {
        return LegacyNativeDialogParameters.create(this.f9646a.getCallId(), this.f9647b, this.f9648c);
    }

    @Override // com.facebook.internal.DialogPresenter.ParameterProvider
    public Bundle getParameters() {
        return NativeDialogParameters.create(this.f9646a.getCallId(), this.f9647b, this.f9648c);
    }
}
