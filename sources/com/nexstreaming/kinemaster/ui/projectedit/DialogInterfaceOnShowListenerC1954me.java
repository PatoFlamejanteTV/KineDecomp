package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Dialog;
import android.content.DialogInterface;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionPanelDefaultFragment.kt */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.me, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class DialogInterfaceOnShowListenerC1954me implements DialogInterface.OnShowListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bd f22447a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterfaceOnShowListenerC1954me(Bd bd) {
        this.f22447a = bd;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        WeakReference weakReference;
        WeakReference weakReference2;
        weakReference = this.f22447a.z;
        if (weakReference != null) {
            weakReference2 = this.f22447a.z;
            if (weakReference2 != null) {
                Dialog dialog = (Dialog) weakReference2.get();
                if (dialog instanceof LayerSubMenuPopup) {
                    ((LayerSubMenuPopup) dialog).a();
                    return;
                }
                return;
            }
            kotlin.jvm.internal.h.a();
            throw null;
        }
    }
}
