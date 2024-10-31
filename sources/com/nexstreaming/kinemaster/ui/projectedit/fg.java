package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionPanelDefaultFragment.java */
/* loaded from: classes.dex */
public class fg implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ez f3897a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fg(ez ezVar) {
        this.f3897a = ezVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        view = this.f3897a.b;
        if (view != null) {
            view2 = this.f3897a.b;
            view2.findViewById(R.id.camera_icon_forAnimation).setVisibility(8);
        }
    }
}
