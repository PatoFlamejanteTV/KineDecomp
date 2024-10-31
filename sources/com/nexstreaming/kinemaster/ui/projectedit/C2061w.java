package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.projectedit.D;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: AssetSettingsFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.w, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C2061w implements D.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2069x f22746a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2061w(C2069x c2069x) {
        this.f22746a = c2069x;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.D.a
    public void a(boolean z) {
        VideoEditor da = this.f22746a.da();
        if (da != null) {
            NexTimelineItem Y = this.f22746a.Y();
            if (Y instanceof NexLayerItem) {
                da.d((NexLayerItem) Y);
            }
            NexEditor.c n = da.n();
            n.a(NexEditor.FastPreviewOption.normal, 0);
            n.execute();
            if (z) {
                this.f22746a.G();
            }
        }
    }
}
