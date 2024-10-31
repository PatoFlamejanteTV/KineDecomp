package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.DialogInterface;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionPanelDefaultFragment.java */
/* loaded from: classes.dex */
public class gc implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ez f3920a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gc(ez ezVar) {
        this.f3920a = ezVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        View view;
        View view2;
        view = this.f3920a.b;
        if (view != null) {
            view2 = this.f3920a.b;
            view2.findViewById(R.id.layer_button_holder).setSelected(false);
        }
    }
}
