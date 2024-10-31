package com.nexstreaming.kinemaster.ui.projectedit;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.usage.analytics.ApplyBackEvent;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditingFragmentBase.kt */
/* loaded from: classes2.dex */
public final class Cg implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bg f21803a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cg(Bg bg) {
        this.f21803a = bg;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FragmentManager fragmentManager = this.f21803a.getFragmentManager();
        if (fragmentManager != null) {
            Fragment findFragmentById = fragmentManager.findFragmentById(R.id.expandedOptionPanelHolder);
            if (findFragmentById == null) {
                FragmentManager fragmentManager2 = this.f21803a.getFragmentManager();
                if (fragmentManager2 == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                findFragmentById = fragmentManager2.findFragmentById(R.id.optionPanelHolder);
            }
            com.nexstreaming.kinemaster.usage.analytics.i.a(this.f21803a.Y(), findFragmentById, ApplyBackEvent.APPLY);
            if ((findFragmentById != null && (findFragmentById instanceof com.nexstreaming.kinemaster.ui.assetbrowser.i) && ((com.nexstreaming.kinemaster.ui.assetbrowser.i) findFragmentById).za()) || this.f21803a.ma()) {
                return;
            }
            while (this.f21803a.getFragmentManager() != null) {
                FragmentManager fragmentManager3 = this.f21803a.getFragmentManager();
                if (fragmentManager3 == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                if (!fragmentManager3.popBackStackImmediate()) {
                    return;
                }
            }
            return;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }
}
