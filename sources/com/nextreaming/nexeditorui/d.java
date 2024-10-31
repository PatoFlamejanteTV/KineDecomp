package com.nextreaming.nexeditorui;

import android.app.Activity;
import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExpiredActivity.java */
/* loaded from: classes.dex */
public class D implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Activity f24009a;

    public D(Activity activity) {
        this.f24009a = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f24009a.finish();
    }
}
