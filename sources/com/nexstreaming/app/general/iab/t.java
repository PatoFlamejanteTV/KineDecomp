package com.nexstreaming.app.general.iab;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABManager.kt */
/* loaded from: classes2.dex */
public final class t implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IABManager f19488a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(IABManager iABManager) {
        this.f19488a = iABManager;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f19488a.E();
        dialogInterface.dismiss();
    }
}
