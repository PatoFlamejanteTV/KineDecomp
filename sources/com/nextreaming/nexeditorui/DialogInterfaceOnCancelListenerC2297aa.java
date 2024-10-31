package com.nextreaming.nexeditorui;

import android.content.DialogInterface;

/* compiled from: KineMasterBaseActivity.kt */
/* renamed from: com.nextreaming.nexeditorui.aa, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class DialogInterfaceOnCancelListenerC2297aa implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ I f24212a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterfaceOnCancelListenerC2297aa(I i) {
        this.f24212a = i;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        kotlin.jvm.internal.h.b(dialogInterface, "dialog");
        this.f24212a.n = false;
    }
}
