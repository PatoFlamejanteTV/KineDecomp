package com.nexstreaming.kinemaster.mediainfo;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;

/* compiled from: MediaInfoDialog.java */
/* loaded from: classes.dex */
final class ae implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f3492a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(Context context, String str) {
        this.f3492a = context;
        this.b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ((ClipboardManager) this.f3492a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("diagnostic info", this.b));
    }
}
