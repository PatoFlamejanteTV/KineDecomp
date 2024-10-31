package com.facebook.share.widget;

import android.os.Bundle;
import android.util.Log;
import com.facebook.internal.DialogPresenter;
import com.facebook.share.model.AppInviteContent;
import com.facebook.share.widget.AppInviteDialog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppInviteDialog.java */
/* loaded from: classes.dex */
public class c implements DialogPresenter.ParameterProvider {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppInviteContent f398a;
    final /* synthetic */ AppInviteDialog.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AppInviteDialog.a aVar, AppInviteContent appInviteContent) {
        this.b = aVar;
        this.f398a = appInviteContent;
    }

    @Override // com.facebook.internal.DialogPresenter.ParameterProvider
    public Bundle getParameters() {
        return AppInviteDialog.createParameters(this.f398a);
    }

    @Override // com.facebook.internal.DialogPresenter.ParameterProvider
    public Bundle getLegacyParameters() {
        Log.e("AppInviteDialog", "Attempting to present the AppInviteDialog with an outdated Facebook app on the device");
        return new Bundle();
    }
}
