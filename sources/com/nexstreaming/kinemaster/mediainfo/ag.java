package com.nexstreaming.kinemaster.mediainfo;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;

/* compiled from: MediaInfoDialog.java */
/* loaded from: classes.dex */
final class ag implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f3493a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(Context context, String str) {
        this.f3493a = context;
        this.b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ((ClipboardManager) this.f3493a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("diagnostic info", this.b));
    }
}
