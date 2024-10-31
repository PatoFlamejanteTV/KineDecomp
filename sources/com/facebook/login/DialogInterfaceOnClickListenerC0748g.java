package com.facebook.login;

import android.content.DialogInterface;
import com.facebook.internal.Utility;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceAuthDialog.java */
/* renamed from: com.facebook.login.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class DialogInterfaceOnClickListenerC0748g implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f9384a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Utility.PermissionsPair f9385b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f9386c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ DeviceAuthDialog f9387d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterfaceOnClickListenerC0748g(DeviceAuthDialog deviceAuthDialog, String str, Utility.PermissionsPair permissionsPair, String str2) {
        this.f9387d = deviceAuthDialog;
        this.f9384a = str;
        this.f9385b = permissionsPair;
        this.f9386c = str2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f9387d.completeLogin(this.f9384a, this.f9385b, this.f9386c);
    }
}
