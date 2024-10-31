package com.nexstreaming.kinemaster.ui.settings;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingFragment.java */
/* loaded from: classes2.dex */
public class Ra implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f23078a;

    /* renamed from: b */
    final /* synthetic */ String f23079b;

    public Ra(Context context, String str) {
        this.f23078a = context;
        this.f23079b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ((ClipboardManager) this.f23078a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("diagnostic info", this.f23079b));
    }
}
