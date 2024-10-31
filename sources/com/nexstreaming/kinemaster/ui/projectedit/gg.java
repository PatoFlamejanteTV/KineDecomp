package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Dialog;
import android.content.DialogInterface;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionPanelDefaultFragment.java */
/* loaded from: classes.dex */
public class gg implements DialogInterface.OnShowListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ez f3924a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gg(ez ezVar) {
        this.f3924a = ezVar;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        WeakReference weakReference;
        WeakReference weakReference2;
        weakReference = this.f3924a.c;
        if (weakReference != null) {
            weakReference2 = this.f3924a.c;
            Dialog dialog = (Dialog) weakReference2.get();
            if (dialog != null && (dialog instanceof LayerSubMenuPopup)) {
                ((LayerSubMenuPopup) dialog).a();
            }
        }
    }
}
