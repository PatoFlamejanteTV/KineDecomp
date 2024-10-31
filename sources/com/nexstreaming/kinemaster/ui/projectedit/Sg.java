package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.layer.StickerLayer;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;
import com.nexstreaming.kinemaster.ui.projectedit.Xg;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerEditFragment.java */
/* loaded from: classes2.dex */
public class Sg implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Xg.a f22083a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Xg f22084b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Sg(Xg xg, Xg.a aVar) {
        this.f22084b = xg;
        this.f22083a = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        StickerLayer Aa;
        MarchingAnts marchingAnts;
        c.d.b.h.a aVar = this.f22083a.getItem(i) != null ? (c.d.b.h.a) this.f22083a.getItem(i) : null;
        if (aVar == null) {
            return;
        }
        Aa = this.f22084b.Aa();
        if (Aa == null) {
            int v = this.f22084b.da().v();
            StickerLayer stickerLayer = new StickerLayer();
            int intValue = this.f22084b.T().intValue();
            stickerLayer.setRelativeStartTime(v);
            stickerLayer.setRelativeEndTime(v + intValue);
            NexLayerItem.b closestKeyframe = stickerLayer.getClosestKeyframe(0.0f);
            closestKeyframe.f20232c = 640.0f;
            closestKeyframe.f20233d = 360.0f;
            closestKeyframe.f20231b = 1.0f;
            closestKeyframe.f20234e = 0.0f;
            stickerLayer.setSticker(aVar);
            this.f22084b.da().a((NexLayerItem) stickerLayer);
            this.f22084b.da().c(this.f22084b.Y());
            new Handler().post(new Rg(this, stickerLayer));
            return;
        }
        Aa.setSticker(aVar);
        this.f22084b.E = null;
        Rect rect = new Rect();
        Aa.getBounds(rect);
        marchingAnts = this.f22084b.G;
        marchingAnts.a(rect);
        this.f22084b.da().a(NexEditor.FastPreviewOption.normal, 0, true);
        this.f22084b.da().J();
    }
}
