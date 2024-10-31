package com.nexstreaming.kinemaster.util.update;

import android.content.DialogInterface;

/* compiled from: AssetUpdateActivity.java */
/* loaded from: classes2.dex */
public class h implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AssetUpdateActivity f23959a;

    public h(AssetUpdateActivity assetUpdateActivity) {
        this.f23959a = assetUpdateActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
