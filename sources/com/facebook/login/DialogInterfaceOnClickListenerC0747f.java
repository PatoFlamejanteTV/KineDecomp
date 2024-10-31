package com.facebook.login;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import com.facebook.login.LoginClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceAuthDialog.java */
/* renamed from: com.facebook.login.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class DialogInterfaceOnClickListenerC0747f implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DeviceAuthDialog f9383a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterfaceOnClickListenerC0747f(DeviceAuthDialog deviceAuthDialog) {
        this.f9383a = deviceAuthDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Dialog dialog;
        LoginClient.Request request;
        View initializeContentView = this.f9383a.initializeContentView(false);
        dialog = this.f9383a.dialog;
        dialog.setContentView(initializeContentView);
        DeviceAuthDialog deviceAuthDialog = this.f9383a;
        request = deviceAuthDialog.mRequest;
        deviceAuthDialog.startLogin(request);
    }
}
