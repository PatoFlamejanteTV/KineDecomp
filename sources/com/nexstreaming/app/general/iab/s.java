package com.nexstreaming.app.general.iab;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABManager.kt */
/* loaded from: classes2.dex */
public final class s implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IABManager f19487a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(IABManager iABManager) {
        this.f19487a = iABManager;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f19487a.F();
        dialogInterface.dismiss();
    }
}
