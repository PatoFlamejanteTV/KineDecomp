package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionPanelDefaultFragment.java */
/* loaded from: classes.dex */
public class fe implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ez f3895a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fe(ez ezVar) {
        this.f3895a = ezVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this.f3895a.getActivity().getPackageName(), null));
        this.f3895a.startActivityForResult(intent, R.id.req_perm_settings);
    }
}
