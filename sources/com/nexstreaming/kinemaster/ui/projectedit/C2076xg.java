package com.nexstreaming.kinemaster.ui.projectedit;

import android.support.v4.app.Fragment;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f;
import com.nexstreaming.kinemaster.ui.widget.DurationSpinner;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTransitionItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.xg, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2076xg implements DurationSpinner.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22782a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2076xg(ProjectEditActivity projectEditActivity) {
        this.f22782a = projectEditActivity;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.DurationSpinner.a
    public void a(float f2) {
        InterfaceC2025f interfaceC2025f;
        InterfaceC2025f interfaceC2025f2;
        InterfaceC2025f interfaceC2025f3;
        interfaceC2025f = this.f22782a.T;
        if (interfaceC2025f.getSelectedItem() != null) {
            interfaceC2025f2 = this.f22782a.T;
            if (interfaceC2025f2.getSelectedItem() instanceof NexTransitionItem) {
                interfaceC2025f3 = this.f22782a.T;
                NexTransitionItem nexTransitionItem = (NexTransitionItem) interfaceC2025f3.getSelectedItem();
                NexTimeline.c beginTimeChange = this.f22782a.ja().s().a().beginTimeChange();
                nexTransitionItem.setDuration((int) (f2 * 1000.0f));
                this.f22782a.ja().c(nexTransitionItem);
                this.f22782a.e(nexTransitionItem);
                beginTimeChange.apply();
                this.f22782a.n(false);
                this.f22782a.ja().J();
                Fragment findFragmentById = this.f22782a.getSupportFragmentManager().findFragmentById(R.id.expandedOptionPanelHolder);
                if (findFragmentById == null || !(findFragmentById instanceof com.nexstreaming.kinemaster.ui.assetbrowser.i)) {
                    return;
                }
                ((com.nexstreaming.kinemaster.ui.assetbrowser.i) findFragmentById).Ba();
            }
        }
    }
}
