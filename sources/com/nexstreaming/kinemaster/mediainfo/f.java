package com.nexstreaming.kinemaster.mediainfo;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;

/* compiled from: MediaInfoDialog.java */
/* loaded from: classes.dex */
class F implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f20665a;

    /* renamed from: b */
    final /* synthetic */ String f20666b;

    public F(Context context, String str) {
        this.f20665a = context;
        this.f20666b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ((ClipboardManager) this.f20665a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("diagnostic info", this.f20666b));
    }
}
