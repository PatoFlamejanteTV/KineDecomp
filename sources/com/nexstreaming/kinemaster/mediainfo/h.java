package com.nexstreaming.kinemaster.mediainfo;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;

/* compiled from: MediaInfoDialog.java */
/* loaded from: classes.dex */
class H implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f20667a;

    /* renamed from: b */
    final /* synthetic */ String f20668b;

    public H(Context context, String str) {
        this.f20667a = context;
        this.f20668b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ((ClipboardManager) this.f20667a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("diagnostic info", this.f20668b));
    }
}
