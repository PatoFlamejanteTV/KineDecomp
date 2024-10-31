package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Rect;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.layer.EffectLayer;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EffectLayerEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ya, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2078ya implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ba f22786a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Aa f22787b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2078ya(Aa aa, Ba ba) {
        this.f22787b = aa;
        this.f22786a = ba;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        EffectLayer Aa;
        MarchingAnts marchingAnts;
        Aa = this.f22787b.Aa();
        if (Aa == null) {
            int v = this.f22787b.da().v();
            EffectLayer effectLayer = new EffectLayer();
            int intValue = this.f22787b.T().intValue();
            effectLayer.setRelativeStartTime(v);
            effectLayer.setRelativeEndTime(v + intValue);
            NexLayerItem.b closestKeyframe = effectLayer.getClosestKeyframe(0.0f);
            closestKeyframe.f20232c = EditorGlobal.n() / 2;
            closestKeyframe.f20233d = EditorGlobal.m() / 2;
            closestKeyframe.f20231b = 1.0f;
            closestKeyframe.f20234e = 0.0f;
            effectLayer.setEffectId(this.f22786a.getItem(i).toString());
            Log.d("EffectLayerEditFragment", "effect layer selected    " + i + " : " + this.f22786a.getItem(i));
            this.f22787b.da().a((NexLayerItem) effectLayer);
            this.f22787b.f(effectLayer);
            this.f22787b.da().c(this.f22787b.Y());
            this.f22787b.da().a(NexEditor.FastPreviewOption.normal, 0, true);
            this.f22787b.a((NexTimelineItem) effectLayer);
            new Handler().post(new RunnableC2070xa(this, effectLayer));
        } else {
            Aa.setEffectId(this.f22786a.getItem(i).toString());
            Log.d("EffectLayerEditFragment", "effect layer selected !! " + i + " : " + this.f22786a.getItem(i));
            Rect rect = new Rect();
            Aa.getBounds(rect);
            marchingAnts = this.f22787b.F;
            marchingAnts.a(rect);
            this.f22787b.da().a(NexEditor.FastPreviewOption.normal, 0, true);
        }
        this.f22787b.G();
    }
}
