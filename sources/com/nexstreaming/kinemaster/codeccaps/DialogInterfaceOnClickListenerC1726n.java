package com.nexstreaming.kinemaster.codeccaps;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

/* compiled from: CapabilityCheckPopup.java */
/* renamed from: com.nexstreaming.kinemaster.codeccaps.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1726n implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1727o f20110a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterfaceOnClickListenerC1726n(C1727o c1727o) {
        this.f20110a = c1727o;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Context context;
        StringBuilder sb;
        Context context2;
        context = this.f20110a.f20111a.f20112a;
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        sb = this.f20110a.f20111a.f20116e;
        clipboardManager.setPrimaryClip(ClipData.newPlainText("codec caps", sb.toString()));
        context2 = this.f20110a.f20111a.f20112a;
        Toast.makeText(context2, "Copied to Clipboard", 0).show();
    }
}
