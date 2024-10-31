package com.nexstreaming.kinemaster.util.update;

import android.content.DialogInterface;

/* compiled from: AssetUpdateActivity.java */
/* loaded from: classes2.dex */
public class f implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AssetUpdateActivity f23957a;

    public f(AssetUpdateActivity assetUpdateActivity) {
        this.f23957a = assetUpdateActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
