package com.nextreaming.nexeditorui;

import android.content.DialogInterface;

/* compiled from: NexPrefsFrag.java */
/* loaded from: classes.dex */
class Ba implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ La f23982a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ba(La la) {
        this.f23982a = la;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
