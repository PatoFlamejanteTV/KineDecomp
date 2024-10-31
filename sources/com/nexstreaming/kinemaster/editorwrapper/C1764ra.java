package com.nexstreaming.kinemaster.editorwrapper;

import android.graphics.RectF;
import com.nextreaming.nexvideoeditor.LayerRenderer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexLayerItem.java */
/* renamed from: com.nexstreaming.kinemaster.editorwrapper.ra, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1764ra extends AbstractRunnableC1763qa {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexLayerItem f20353b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1764ra(NexLayerItem nexLayerItem) {
        this.f20353b = nexLayerItem;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.AbstractRunnableC1763qa
    protected void a(LayerRenderer layerRenderer) {
        AbstractRunnableC1763qa abstractRunnableC1763qa;
        int i;
        int i2;
        RectF d2;
        int i3;
        abstractRunnableC1763qa = this.f20353b.renderOut;
        i = this.f20353b.layerOutExpression;
        int f2 = layerRenderer.f() - this.f20353b.getAbsStartTime();
        int duration = this.f20353b.getDuration();
        i2 = this.f20353b.layerOutExpressionDuration;
        d2 = this.f20353b.d();
        i3 = this.f20353b.mNaturalOrientation;
        abstractRunnableC1763qa.a(layerRenderer, i, 0.0f, 0.0f, f2, duration, i2, d2, i3);
    }
}
