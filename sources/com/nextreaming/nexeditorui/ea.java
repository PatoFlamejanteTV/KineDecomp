package com.nextreaming.nexeditorui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;

/* compiled from: NexPrefsFrag.java */
/* loaded from: classes.dex */
class Ea implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f24020a;

    /* renamed from: b */
    final /* synthetic */ String f24021b;

    public Ea(Context context, String str) {
        this.f24020a = context;
        this.f24021b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ((ClipboardManager) this.f24020a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("diagnostic info", this.f24021b));
    }
}
