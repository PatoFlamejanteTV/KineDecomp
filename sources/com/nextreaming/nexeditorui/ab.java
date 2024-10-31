package com.nextreaming.nexeditorui;

import android.app.Activity;
import android.content.DialogInterface;

/* compiled from: ExpiredActivity.java */
/* loaded from: classes.dex */
final class ab implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f4509a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(Activity activity) {
        this.f4509a = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f4509a.finish();
    }
}
