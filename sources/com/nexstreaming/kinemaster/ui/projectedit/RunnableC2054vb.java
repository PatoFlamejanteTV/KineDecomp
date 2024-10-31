package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.RectF;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LayerTransformTouchHandler.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.vb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class RunnableC2054vb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LayerTransformTouchHandler f22738a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2054vb(LayerTransformTouchHandler layerTransformTouchHandler) {
        this.f22738a = layerTransformTouchHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        NexLayerItem.b bVar;
        RectF rectF;
        NexLayerItem nexLayerItem;
        VideoEditor videoEditor;
        VideoEditor videoEditor2;
        NexLayerItem nexLayerItem2;
        RectF rectF2;
        RectF rectF3;
        RectF rectF4;
        RectF rectF5;
        NexLayerItem.b bVar2;
        NexLayerItem.b bVar3;
        long nanoTime = System.nanoTime();
        j = this.f22738a.v;
        if ((nanoTime - j) / 1000000 > 2300) {
            this.f22738a.H = false;
            bVar = this.f22738a.f21938e;
            if (bVar != null) {
                bVar2 = this.f22738a.f21938e;
                bVar3 = this.f22738a.f21937d;
                bVar2.b(bVar3);
            }
            rectF = this.f22738a.B;
            if (rectF != null) {
                rectF3 = this.f22738a.A;
                if (rectF3 != null) {
                    rectF4 = this.f22738a.B;
                    rectF5 = this.f22738a.A;
                    rectF4.set(rectF5);
                }
            }
            nexLayerItem = this.f22738a.f21935b;
            if (nexLayerItem != null) {
                nexLayerItem2 = this.f22738a.f21935b;
                rectF2 = this.f22738a.A;
                nexLayerItem2.setCropBounds(rectF2);
            }
            videoEditor = this.f22738a.f21936c;
            if (videoEditor != null) {
                videoEditor2 = this.f22738a.f21936c;
                VideoEditor.b q = videoEditor2.q();
                if (q != null && (q instanceof MarchingAnts)) {
                    ((MarchingAnts) q).c();
                }
            }
            this.f22738a.a(this);
        }
    }
}
