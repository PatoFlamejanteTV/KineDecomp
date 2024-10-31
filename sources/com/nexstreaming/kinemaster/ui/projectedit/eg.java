package com.nexstreaming.kinemaster.ui.projectedit;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.usage.analytics.ApplyBackEvent;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditingFragmentBase.kt */
/* loaded from: classes2.dex */
public final class Eg implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bg f21833a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Eg(Bg bg) {
        this.f21833a = bg;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        z = this.f21833a.f21793h;
        if (!z || this.f21833a.onBackPressed()) {
            return;
        }
        FragmentManager fragmentManager = this.f21833a.getFragmentManager();
        if (fragmentManager != null) {
            Fragment findFragmentById = fragmentManager.findFragmentById(R.id.optionPanelHolder);
            if (findFragmentById == null) {
                FragmentManager fragmentManager2 = this.f21833a.getFragmentManager();
                if (fragmentManager2 == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                findFragmentById = fragmentManager2.findFragmentById(R.id.expandedOptionPanelHolder);
            }
            com.nexstreaming.kinemaster.usage.analytics.i.a(this.f21833a.Y(), findFragmentById, ApplyBackEvent.BACK_TO);
            if (findFragmentById != null) {
                if (findFragmentById instanceof He) {
                    if (((He) findFragmentById).onBackPressed()) {
                        return;
                    }
                } else if ((findFragmentById instanceof com.nexstreaming.kinemaster.ui.assetbrowser.i) && ((com.nexstreaming.kinemaster.ui.assetbrowser.i) findFragmentById).onBackPressed()) {
                    return;
                }
            }
            this.f21833a.sa();
            return;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }
}
