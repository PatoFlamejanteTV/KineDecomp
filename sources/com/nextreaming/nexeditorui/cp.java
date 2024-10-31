package com.nextreaming.nexeditorui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;

/* compiled from: NexPrefsFrag.java */
/* loaded from: classes.dex */
final class cp implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f4580a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(Context context, String str) {
        this.f4580a = context;
        this.b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ((ClipboardManager) this.f4580a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("diagnostic info", this.b));
    }
}
