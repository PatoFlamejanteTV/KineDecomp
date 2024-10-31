package com.nexstreaming.app.general.iab;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABManager.kt */
/* loaded from: classes2.dex */
public final class r implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DialogInterface.OnClickListener f19486a;

    public r(DialogInterface.OnClickListener onClickListener) {
        this.f19486a = onClickListener;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        DialogInterface.OnClickListener onClickListener = this.f19486a;
        if (onClickListener != null) {
            onClickListener.onClick(dialogInterface, i);
        }
        dialogInterface.dismiss();
    }
}
