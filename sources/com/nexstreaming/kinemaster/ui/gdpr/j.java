package com.nexstreaming.kinemaster.ui.gdpr;

import android.app.DialogFragment;
import android.content.DialogInterface;
import com.nexstreaming.kinemaster.ui.a.k;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PrivacyPolicyAgreeUtil.java */
/* loaded from: classes.dex */
public class j implements k.b {

    /* renamed from: a */
    final /* synthetic */ k.b f21609a;

    public j(k.b bVar) {
        this.f21609a = bVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.a.k.b
    public void onDialogCanceled(DialogInterface dialogInterface, DialogFragment dialogFragment) {
        dialogInterface.dismiss();
        l.f21612b = false;
        k.b bVar = this.f21609a;
        if (bVar != null) {
            bVar.onDialogCanceled(dialogInterface, dialogFragment);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.a.k.b
    public void onDialogOk(DialogInterface dialogInterface, DialogFragment dialogFragment) {
        dialogInterface.dismiss();
        l.f21612b = false;
        k.b bVar = this.f21609a;
        if (bVar != null) {
            bVar.onDialogOk(dialogInterface, dialogFragment);
        }
    }
}
