package com.firebase.ui.auth.ui.email;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import com.firebase.ui.auth.ui.ExtraConstants;
import com.nexstreaming.app.kinemasterfree.R;

/* loaded from: classes.dex */
public class RecoveryEmailSentDialog extends DialogFragment {
    private static final String TAG = "RecoveryEmailSentDialog";

    /* JADX INFO: Access modifiers changed from: private */
    public void finish(int i, Intent intent) {
        getActivity().setResult(i, intent);
        getActivity().finish();
    }

    public static void show(String str, FragmentManager fragmentManager) {
        RecoveryEmailSentDialog recoveryEmailSentDialog = new RecoveryEmailSentDialog();
        Bundle bundle = new Bundle();
        bundle.putString(ExtraConstants.EXTRA_EMAIL, str);
        recoveryEmailSentDialog.setArguments(bundle);
        recoveryEmailSentDialog.show(fragmentManager, TAG);
    }

    @Override // android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        return new AlertDialog.Builder(getContext()).setTitle(R.string.title_confirm_recover_password).setMessage(getString(R.string.confirm_recovery_body, getArguments().getString(ExtraConstants.EXTRA_EMAIL))).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.firebase.ui.auth.ui.email.RecoveryEmailSentDialog.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                RecoveryEmailSentDialog.this.finish(-1, new Intent());
            }
        }).setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) null).show();
    }
}
