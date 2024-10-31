package com.nexstreaming.kinemaster.util.update;

import android.content.DialogInterface;

/* compiled from: AssetUpdateActivity.java */
/* loaded from: classes2.dex */
public class a implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AssetUpdateActivity f23952a;

    public a(AssetUpdateActivity assetUpdateActivity) {
        this.f23952a = assetUpdateActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f23952a.finish();
    }
}
