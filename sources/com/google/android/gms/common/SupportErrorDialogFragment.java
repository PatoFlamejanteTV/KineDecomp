package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public class SupportErrorDialogFragment extends android.support.v4.app.i {

    /* renamed from: a, reason: collision with root package name */
    private Dialog f865a = null;
    private DialogInterface.OnCancelListener b = null;

    public static SupportErrorDialogFragment a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        SupportErrorDialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
        Dialog dialog2 = (Dialog) zzx.a(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        supportErrorDialogFragment.f865a = dialog2;
        if (onCancelListener != null) {
            supportErrorDialogFragment.b = onCancelListener;
        }
        return supportErrorDialogFragment;
    }

    @Override // android.support.v4.app.i, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        if (this.b != null) {
            this.b.onCancel(dialogInterface);
        }
    }

    @Override // android.support.v4.app.i
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f865a == null) {
            setShowsDialog(false);
        }
        return this.f865a;
    }

    @Override // android.support.v4.app.i
    public void show(android.support.v4.app.p pVar, String str) {
        super.show(pVar, str);
    }
}
