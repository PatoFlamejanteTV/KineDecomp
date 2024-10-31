package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.timeline.UniformTimelineView;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MultiSelectOptionFragment.java */
/* loaded from: classes2.dex */
public class Pb implements UniformTimelineView.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Qb f22012a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Pb(Qb qb) {
        this.f22012a = qb;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.UniformTimelineView.c
    public void a(Set set, com.nexstreaming.kinemaster.editorwrapper.Fa fa) {
        if (fa instanceof NexPrimaryTimelineItem) {
            if (set.contains(fa)) {
                Qb.j(this.f22012a);
            } else {
                Qb.k(this.f22012a);
            }
        }
        this.f22012a.Da();
    }
}
