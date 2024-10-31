package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: OptionPanelDefaultFragment.java */
/* loaded from: classes.dex */
class fa implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ez f3891a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fa(ez ezVar) {
        this.f3891a = ezVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (this.f3891a.getActivity() == null || !(this.f3891a.getActivity() instanceof ProjectEditActivity)) {
            return false;
        }
        ((ProjectEditActivity) this.f3891a.getActivity()).j(R.id.action_play_pause);
        return true;
    }
}
