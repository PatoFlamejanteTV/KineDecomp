package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.ui.projectedit.C2073xd;
import com.nexstreaming.kinemaster.ui.projectedit.FullScreenInputActivity;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.umeng.analytics.pro.k;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionMenuItemClickHandler.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.vd, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2056vd implements C2073xd.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2073xd f22740a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2056vd(C2073xd c2073xd) {
        this.f22740a = c2073xd;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.C2073xd.b
    public void a(C2073xd.a aVar, NexTimelineItem nexTimelineItem) {
        Bg bg;
        Bg bg2;
        Bg bg3;
        Bg bg4;
        if (nexTimelineItem instanceof NexLayerItem) {
            String layerName = ((NexLayerItem) nexTimelineItem).getLayerName();
            bg3 = this.f22740a.f22769c;
            bg4 = this.f22740a.f22769c;
            FullScreenInputActivity.a a2 = FullScreenInputActivity.a(bg4.getActivity());
            if (layerName == null) {
                layerName = "";
            }
            a2.b(layerName);
            a2.a(R.string.layer_name_hint);
            a2.f(true);
            a2.c(false);
            a2.e(false);
            bg3.startActivityForResult(a2.a(), k.a.n);
            return;
        }
        if (nexTimelineItem instanceof NexAudioClipItem) {
            String clipName = ((NexAudioClipItem) nexTimelineItem).getClipName();
            bg = this.f22740a.f22769c;
            bg2 = this.f22740a.f22769c;
            FullScreenInputActivity.a a3 = FullScreenInputActivity.a(bg2.getActivity());
            if (clipName == null) {
                clipName = "";
            }
            a3.b(clipName);
            a3.a(R.string.label_placeholder_title);
            a3.f(true);
            a3.c(false);
            a3.e(false);
            bg.startActivityForResult(a3.a(), k.a.n);
        }
    }
}
