package c.d.b.j;

import com.nexstreaming.kinemaster.editorwrapper.LayerExpression;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.layer.TextLayer;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTransitionItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* compiled from: ThemeApplicatorFactory.java */
/* loaded from: classes.dex */
class d extends a {
    @Override // c.d.b.j.a
    protected boolean a(b bVar, NexLayerItem nexLayerItem) {
        return false;
    }

    @Override // c.d.b.j.a
    protected boolean a(b bVar, NexAudioClipItem nexAudioClipItem) {
        return false;
    }

    @Override // c.d.b.j.a
    protected boolean a(b bVar, NexTimeline nexTimeline) {
        int i;
        int totalTime = nexTimeline.getTotalTime();
        String a2 = bVar.a(0);
        String a3 = bVar.a(1);
        String a4 = bVar.a(2);
        int i2 = a2 != null ? 1 : 0;
        if (a3 != null) {
            i2++;
        }
        if (a4 != null) {
            i2++;
        }
        if (i2 < 1) {
            return false;
        }
        int max = Math.max(500, Math.min(6000, (totalTime / i2) - 66));
        if (a2 != null) {
            TextLayer newInstance = TextLayer.newInstance(a2, 0, max, 640, 360, 3.0f);
            newInstance.setLayerExpression(LayerExpression.Type.In, LayerExpression.FadeIn);
            newInstance.setLayerExpression(LayerExpression.Type.Out, LayerExpression.FadeOut);
            nexTimeline.addLayer(newInstance);
            bVar.a(0, true);
        }
        if (a3 != null) {
            i = 2;
            TextLayer newInstance2 = TextLayer.newInstance(a3, totalTime - max, max, 640, 360, 2.0f);
            newInstance2.setLayerExpression(LayerExpression.Type.In, LayerExpression.FadeIn);
            newInstance2.setLayerExpression(LayerExpression.Type.Out, LayerExpression.FadeOut);
            nexTimeline.addLayer(newInstance2);
            bVar.a(1, true);
        } else {
            i = 2;
        }
        if (a4 != null) {
            int i3 = max * 2;
            TextLayer newInstance3 = TextLayer.newInstance(a4, (i3 + max) + 1000 > totalTime - max ? max + 33 : i3, max, 640, 576, 1.5f);
            newInstance3.setLayerExpression(LayerExpression.Type.In, LayerExpression.FadeIn);
            newInstance3.setLayerExpression(LayerExpression.Type.Out, LayerExpression.FadeOut);
            nexTimeline.addLayer(newInstance3);
            bVar.a(i, true);
        }
        return true;
    }

    @Override // c.d.b.j.a
    protected boolean a(b bVar, NexTransitionItem nexTransitionItem, NexVideoClipItem nexVideoClipItem, NexVideoClipItem nexVideoClipItem2, int i, int i2) {
        return false;
    }

    @Override // c.d.b.j.a
    protected boolean a(b bVar, NexVideoClipItem nexVideoClipItem, int i, int i2) {
        return false;
    }
}
