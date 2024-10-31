package com.nexstreaming.kinemaster.util.update;

import android.content.DialogInterface;

/* compiled from: AssetUpdateActivity.java */
/* loaded from: classes2.dex */
public class b implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AssetUpdateActivity f23953a;

    public b(AssetUpdateActivity assetUpdateActivity) {
        this.f23953a = assetUpdateActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f23953a.L();
        dialogInterface.dismiss();
    }
}
