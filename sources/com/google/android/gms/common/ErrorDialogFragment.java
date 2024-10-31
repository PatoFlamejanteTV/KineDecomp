package com.google.android.gms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public class ErrorDialogFragment extends DialogFragment {

    /* renamed from: a, reason: collision with root package name */
    private Dialog f861a = null;
    private DialogInterface.OnCancelListener b = null;

    public static ErrorDialogFragment a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
        Dialog dialog2 = (Dialog) zzx.a(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        errorDialogFragment.f861a = dialog2;
        if (onCancelListener != null) {
            errorDialogFragment.b = onCancelListener;
        }
        return errorDialogFragment;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        if (this.b != null) {
            this.b.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f861a == null) {
            setShowsDialog(false);
        }
        return this.f861a;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
