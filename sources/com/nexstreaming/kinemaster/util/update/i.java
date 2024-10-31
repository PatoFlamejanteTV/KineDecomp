package com.nexstreaming.kinemaster.util.update;

import android.content.DialogInterface;

/* compiled from: AssetUpdateActivity.java */
/* loaded from: classes2.dex */
public class i implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ AssetUpdateActivity f23960a;

    public i(AssetUpdateActivity assetUpdateActivity) {
        this.f23960a = assetUpdateActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        this.f23960a.finish();
    }
}
