package com.qihoo.util;

import android.content.DialogInterface;
import android.os.Build;

/* renamed from: com.qihoo.util.ᵢˎ, reason: contains not printable characters */
/* loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC0001 implements DialogInterface.OnClickListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterfaceOnClickListenerC0001(RunnableC0000 runnableC0000) {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Thread currentThread = Thread.currentThread();
        synchronized (currentThread) {
            if (Build.VERSION.SDK_INT >= 19) {
                currentThread.notify();
            }
        }
    }
}
