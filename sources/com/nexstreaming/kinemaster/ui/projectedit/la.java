package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Rect;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.layer.StickerLayer;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;
import com.nexstreaming.kinemaster.ui.projectedit.kx;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerEditFragment.java */
/* loaded from: classes.dex */
public class la implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ kx.a f4054a;
    final /* synthetic */ kx b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public la(kx kxVar, kx.a aVar) {
        this.b = kxVar;
        this.f4054a = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        StickerLayer H;
        MarchingAnts marchingAnts;
        com.nexstreaming.kinemaster.e.a aVar = this.f4054a.getItem(i) != null ? (com.nexstreaming.kinemaster.e.a) this.f4054a.getItem(i) : null;
        if (aVar != null) {
            KMUsage.EditScreen_Sticker_Select.logEvent("sticker", aVar.f(this.b.i()));
            H = this.b.H();
            if (H == null) {
                int u = this.b.o().u();
                StickerLayer stickerLayer = new StickerLayer();
                int parseInt = Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(this.b.getActivity()).getString("add_layer_def_duration", "6000"));
                stickerLayer.setRelativeStartTime(u);
                stickerLayer.setRelativeEndTime(u + parseInt);
                NexLayerItem.b closestKeyframe = stickerLayer.getClosestKeyframe(0.0f);
                closestKeyframe.c = 640.0f;
                closestKeyframe.d = 360.0f;
                closestKeyframe.b = 1.0f;
                closestKeyframe.e = 0.0f;
                stickerLayer.setSticker(aVar);
                this.b.o().a((NexLayerItem) stickerLayer);
                this.b.c(stickerLayer);
                this.b.o().a(this.b.m());
                this.b.o().a(NexEditor.FastPreviewOption.normal, 0, true);
                this.b.b(stickerLayer);
                new Handler().post(new lb(this, stickerLayer));
            } else {
                H.setSticker(aVar);
                this.b.f4048a = null;
                Rect rect = new Rect();
                H.getBounds(rect);
                marchingAnts = this.b.c;
                marchingAnts.a(rect);
                this.b.o().a(NexEditor.FastPreviewOption.normal, 0, true);
            }
            this.b.d();
        }
    }
}
