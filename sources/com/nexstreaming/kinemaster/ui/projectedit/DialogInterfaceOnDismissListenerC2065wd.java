package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionMenuItemClickHandler.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.wd, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class DialogInterfaceOnDismissListenerC2065wd implements DialogInterface.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2073xd f22753a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterfaceOnDismissListenerC2065wd(C2073xd c2073xd) {
        this.f22753a = c2073xd;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f22753a.f22773g = null;
    }
}
