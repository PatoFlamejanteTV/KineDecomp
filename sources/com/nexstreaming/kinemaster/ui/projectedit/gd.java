package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.DialogInterface;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionPanelDefaultFragment.java */
/* loaded from: classes.dex */
public class gd implements DialogInterface.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ez f3921a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gd(ez ezVar) {
        this.f3921a = ezVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        View view;
        View view2;
        view = this.f3921a.b;
        if (view != null) {
            view2 = this.f3921a.b;
            view2.findViewById(R.id.layer_button_holder).setSelected(false);
        }
    }
}
