package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.editorwrapper.LayerExpression;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nextreaming.nexvideoeditor.LayerRenderer;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionExpressionFragment.java */
/* loaded from: classes.dex */
public class du extends com.nexstreaming.kinemaster.ui.layereditrender.e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ dt f3856a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public du(dt dtVar) {
        this.f3856a = dtVar;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.b
    public void a(NexLayerItem nexLayerItem, LayerRenderer layerRenderer) {
        long j;
        LayerExpression.Type a2 = this.f3856a.a();
        int min = Math.min(a2.hasDuration() ? nexLayerItem.getLayerExpressionDuration(a2) : nexLayerItem.getAbsEndTime() - nexLayerItem.getAbsStartTime(), nexLayerItem.getDuration() / 2);
        int i = a2 == LayerExpression.Type.Overall ? min : min + LicenseErrCode.LICENSE_STATUS_NOT_LICENSED;
        long nanoTime = System.nanoTime();
        j = this.f3856a.g;
        int i2 = ((int) ((nanoTime - j) / 1000000)) % i;
        layerRenderer.l();
        switch (a2) {
            case In:
                if (i2 < min) {
                    layerRenderer.a(i2 + nexLayerItem.getAbsStartTime());
                    break;
                } else if (i2 < min + 500) {
                    layerRenderer.a(nexLayerItem.getAbsStartTime() + min);
                    break;
                } else {
                    layerRenderer.a(nexLayerItem.getAbsStartTime());
                    break;
                }
            case Out:
                if (i2 < min) {
                    layerRenderer.a(i2 + (nexLayerItem.getAbsEndTime() - min));
                    break;
                } else if (i2 < min + 500) {
                    layerRenderer.a(nexLayerItem.getAbsEndTime());
                    break;
                } else {
                    layerRenderer.a(nexLayerItem.getAbsEndTime() - min);
                    break;
                }
            default:
                layerRenderer.a(i2 + nexLayerItem.getAbsStartTime());
                break;
        }
        nexLayerItem.renderLayer(layerRenderer, true);
        layerRenderer.m();
    }
}
