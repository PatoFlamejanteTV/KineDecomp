package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Rect;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.layer.EffectLayer;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EffectLayerEditFragment.java */
/* loaded from: classes.dex */
public class u implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ x f4116a;
    final /* synthetic */ r b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar, x xVar) {
        this.b = rVar;
        this.f4116a = xVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        EffectLayer H;
        MarchingAnts marchingAnts;
        KMUsage.EditScreen_Sticker_Select.logEvent("effectLayer", this.f4116a.getItem(i).toString());
        H = this.b.H();
        if (H == null) {
            int u = this.b.o().u();
            EffectLayer effectLayer = new EffectLayer();
            int parseInt = Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(this.b.getActivity()).getString("add_layer_def_duration", "6000"));
            effectLayer.setRelativeStartTime(u);
            effectLayer.setRelativeEndTime(u + parseInt);
            NexLayerItem.b closestKeyframe = effectLayer.getClosestKeyframe(0.0f);
            closestKeyframe.c = 640.0f;
            closestKeyframe.d = 360.0f;
            closestKeyframe.b = 1.0f;
            closestKeyframe.e = 0.0f;
            effectLayer.setEffectId(this.f4116a.getItem(i).toString());
            Log.d("EffectLayerEditFragment", "effect layer selected    " + i + " : " + this.f4116a.getItem(i));
            this.b.o().a((NexLayerItem) effectLayer);
            this.b.c(effectLayer);
            this.b.o().a(this.b.m());
            this.b.o().a(NexEditor.FastPreviewOption.normal, 0, true);
            this.b.b(effectLayer);
            new Handler().post(new v(this, effectLayer));
        } else {
            H.setEffectId(this.f4116a.getItem(i).toString());
            Log.d("EffectLayerEditFragment", "effect layer selected !! " + i + " : " + this.f4116a.getItem(i));
            Rect rect = new Rect();
            H.getBounds(rect);
            marchingAnts = this.b.b;
            marchingAnts.a(rect);
            this.b.o().a(NexEditor.FastPreviewOption.normal, 0, true);
        }
        this.b.d();
    }
}
