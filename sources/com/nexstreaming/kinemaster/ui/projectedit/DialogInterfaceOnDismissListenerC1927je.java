package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.DialogInterface;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionPanelDefaultFragment.kt */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.je, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class DialogInterfaceOnDismissListenerC1927je implements DialogInterface.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bd f22406a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterfaceOnDismissListenerC1927je(Bd bd) {
        this.f22406a = bd;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        View view;
        WeakReference weakReference;
        View view2;
        view = this.f22406a.o;
        if (view != null) {
            view2 = this.f22406a.o;
            if (view2 == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            View findViewById = view2.findViewById(R.id.layer_button_holder);
            kotlin.jvm.internal.h.a((Object) findViewById, "contentView!!.findViewBy…R.id.layer_button_holder)");
            findViewById.setSelected(false);
        }
        weakReference = this.f22406a.z;
        if (weakReference != null) {
            this.f22406a.z = null;
        }
        this.f22406a.B = false;
    }
}
