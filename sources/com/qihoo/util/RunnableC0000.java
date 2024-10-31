package com.qihoo.util;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Looper;

/* renamed from: com.qihoo.util.ᵢˋ, reason: contains not printable characters */
/* loaded from: classes.dex */
final class RunnableC0000 implements Runnable {

    /* renamed from: ᵢˋ, reason: contains not printable characters */
    private /* synthetic */ Context f0;

    /* renamed from: ᵢˎ, reason: contains not printable characters */
    private /* synthetic */ String f1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0000(Context context, String str) {
        this.f0 = context;
        this.f1 = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Looper.prepare();
        AlertDialog create = new AlertDialog.Builder(this.f0).setMessage(this.f1).setCancelable(false).setPositiveButton("确定", new DialogInterfaceOnClickListenerC0001(this)).create();
        create.getWindow().setType(2005);
        create.show();
        Looper.loop();
    }
}
