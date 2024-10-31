package com.facebook.share.widget;

import android.os.Bundle;
import com.facebook.internal.AppCall;
import com.facebook.internal.DialogPresenter;
import com.facebook.share.internal.LegacyNativeDialogParameters;
import com.facebook.share.internal.NativeDialogParameters;
import com.facebook.share.model.ShareContent;
import com.facebook.share.widget.ShareDialog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareDialog.java */
/* loaded from: classes.dex */
public class p implements DialogPresenter.ParameterProvider {

    /* renamed from: a */
    final /* synthetic */ AppCall f410a;
    final /* synthetic */ ShareContent b;
    final /* synthetic */ boolean c;
    final /* synthetic */ ShareDialog.b d;

    public p(ShareDialog.b bVar, AppCall appCall, ShareContent shareContent, boolean z) {
        this.d = bVar;
        this.f410a = appCall;
        this.b = shareContent;
        this.c = z;
    }

    @Override // com.facebook.internal.DialogPresenter.ParameterProvider
    public Bundle getParameters() {
        return NativeDialogParameters.create(this.f410a.getCallId(), this.b, this.c);
    }

    @Override // com.facebook.internal.DialogPresenter.ParameterProvider
    public Bundle getLegacyParameters() {
        return LegacyNativeDialogParameters.create(this.f410a.getCallId(), this.b, this.c);
    }
}
