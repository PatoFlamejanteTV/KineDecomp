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
    final /* synthetic */ AppInviteContent f9623a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AppInviteDialog.a f9624b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AppInviteDialog.a aVar, AppInviteContent appInviteContent) {
        this.f9624b = aVar;
        this.f9623a = appInviteContent;
    }

    @Override // com.facebook.internal.DialogPresenter.ParameterProvider
    public Bundle getLegacyParameters() {
        Log.e("AppInviteDialog", "Attempting to present the AppInviteDialog with an outdated Facebook app on the device");
        return new Bundle();
    }

    @Override // com.facebook.internal.DialogPresenter.ParameterProvider
    public Bundle getParameters() {
        return AppInviteDialog.createParameters(this.f9623a);
    }
}
