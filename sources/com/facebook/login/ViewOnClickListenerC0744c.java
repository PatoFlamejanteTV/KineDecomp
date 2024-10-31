package com.facebook.login;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceAuthDialog.java */
/* renamed from: com.facebook.login.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ViewOnClickListenerC0744c implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DeviceAuthDialog f9380a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC0744c(DeviceAuthDialog deviceAuthDialog) {
        this.f9380a = deviceAuthDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f9380a.onCancel();
    }
}
