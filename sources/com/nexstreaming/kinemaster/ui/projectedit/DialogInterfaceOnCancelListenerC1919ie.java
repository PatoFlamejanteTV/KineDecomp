package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.DialogInterface;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionPanelDefaultFragment.kt */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ie, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class DialogInterfaceOnCancelListenerC1919ie implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bd f22393a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterfaceOnCancelListenerC1919ie(Bd bd) {
        this.f22393a = bd;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        View view;
        View view2;
        view = this.f22393a.o;
        if (view != null) {
            view2 = this.f22393a.o;
            if (view2 == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            View findViewById = view2.findViewById(R.id.layer_button_holder);
            kotlin.jvm.internal.h.a((Object) findViewById, "contentView!!.findViewBy…R.id.layer_button_holder)");
            findViewById.setSelected(false);
        }
    }
}
