package com.nextreaming.nexeditorui;

import android.content.DialogInterface;

/* compiled from: KineMasterBaseActivity.kt */
/* loaded from: classes.dex */
public final class Z implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ I f24195a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Z(I i) {
        this.f24195a = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        kotlin.jvm.internal.h.b(dialogInterface, "dialog");
        dialogInterface.dismiss();
        this.f24195a.n = false;
    }
}
