package com.nexstreaming.kinemaster.util.update;

import android.content.DialogInterface;

/* compiled from: AssetUpdateActivity.java */
/* loaded from: classes2.dex */
public class g implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ AssetUpdateActivity f23958a;

    public g(AssetUpdateActivity assetUpdateActivity) {
        this.f23958a = assetUpdateActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        this.f23958a.finish();
    }
}
