package com.nexstreaming.kinemaster.ui.settings;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;

/* compiled from: SettingFragment.java */
/* loaded from: classes.dex */
final class aj implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f4239a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(Context context, String str) {
        this.f4239a = context;
        this.b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ((ClipboardManager) this.f4239a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("diagnostic info", this.b));
    }
}
