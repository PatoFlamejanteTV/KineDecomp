package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.layer.HandwritingLayer;
import com.nexstreaming.kinemaster.ui.mediabrowser.C1829g;
import com.nexstreaming.kinemaster.ui.projectedit.Bg;
import com.nexstreaming.kinemaster.ui.projectedit.FullScreenInputActivity;
import com.nexstreaming.kinemaster.ui.projectedit.LayerSubMenuPopup;
import com.nextreaming.nexeditorui.NexTimelineItem;
import kotlin.TypeCastException;

/* compiled from: OptionPanelDefaultFragment.kt */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.le, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1945le implements LayerSubMenuPopup.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bd f22435a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1945le(Bd bd) {
        this.f22435a = bd;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.LayerSubMenuPopup.a
    public void a(LayerSubMenuPopup layerSubMenuPopup, LayerSubMenuPopup.LayerType layerType) {
        kotlin.jvm.internal.h.b(layerSubMenuPopup, "dialog");
        if (layerType == null) {
            layerSubMenuPopup.dismiss();
            return;
        }
        switch (Cd.f21800a[layerType.ordinal()]) {
            case 1:
                com.nexstreaming.kinemaster.ui.assetbrowser.n nVar = new com.nexstreaming.kinemaster.ui.assetbrowser.n();
                Bg.a aVar = Bg.f21786a;
                FragmentManager fragmentManager = this.f22435a.getFragmentManager();
                if (fragmentManager != null) {
                    FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                    kotlin.jvm.internal.h.a((Object) beginTransaction, "fragmentManager!!.beginTransaction()");
                    aVar.a(beginTransaction, nVar.ja()).setTransition(4097).replace(R.id.expandedOptionPanelHolder, nVar).addToBackStack("newEffectBrowser").commit();
                    layerSubMenuPopup.dismiss();
                    return;
                }
                kotlin.jvm.internal.h.a();
                throw null;
            case 2:
            case 3:
            case 4:
                C1829g.a a2 = C1829g.f21680a.a();
                a2.b(R.id.req_add_image_layer);
                a2.b(true);
                a2.a(true);
                C1829g a3 = a2.a();
                FragmentActivity requireActivity = this.f22435a.requireActivity();
                if (requireActivity != null) {
                    a3.a((ProjectEditActivity) requireActivity);
                    this.f22435a.requireFragmentManager().beginTransaction().setTransition(4097).replace(PreferenceManager.getDefaultSharedPreferences(this.f22435a.requireActivity()).getBoolean("pref_mbrowser_full", false) ? R.id.fullscreenFragmentHolder : R.id.aboveTimelineFragmentHolder, a3).addToBackStack("mediaBrowser").commit();
                    layerSubMenuPopup.dismiss();
                    this.f22435a.Ga();
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity");
            case 5:
                com.nexstreaming.kinemaster.ui.assetbrowser.o oVar = new com.nexstreaming.kinemaster.ui.assetbrowser.o();
                Bg.a aVar2 = Bg.f21786a;
                FragmentManager fragmentManager2 = this.f22435a.getFragmentManager();
                if (fragmentManager2 != null) {
                    FragmentTransaction beginTransaction2 = fragmentManager2.beginTransaction();
                    kotlin.jvm.internal.h.a((Object) beginTransaction2, "fragmentManager!!.beginTransaction()");
                    aVar2.a(beginTransaction2, oVar.ja()).setTransition(4097).replace(R.id.expandedOptionPanelHolder, oVar).addToBackStack("newOverlaysBrowser").commit();
                    layerSubMenuPopup.dismiss();
                    return;
                }
                kotlin.jvm.internal.h.a();
                throw null;
            case 6:
                VideoEditor da = this.f22435a.da();
                if (da != null) {
                    da.M();
                    FullScreenInputActivity.a a4 = FullScreenInputActivity.a(this.f22435a.getActivity());
                    a4.c(true);
                    a4.f(true);
                    this.f22435a.startActivityForResult(a4.a(), FullScreenInputActivity.s());
                    layerSubMenuPopup.dismiss();
                    return;
                }
                kotlin.jvm.internal.h.a();
                throw null;
            case 7:
                VideoEditor da2 = this.f22435a.da();
                if (da2 != null) {
                    int v = da2.v();
                    HandwritingLayer handwritingLayer = new HandwritingLayer();
                    Integer T = this.f22435a.T();
                    if (T != null) {
                        int intValue = T.intValue();
                        handwritingLayer.setRelativeStartTime(v);
                        handwritingLayer.setRelativeEndTime(v + intValue);
                        VideoEditor da3 = this.f22435a.da();
                        if (da3 != null) {
                            da3.a((NexLayerItem) handwritingLayer);
                            VideoEditor da4 = this.f22435a.da();
                            if (da4 != null) {
                                da4.H();
                                this.f22435a.a((NexTimelineItem) handwritingLayer);
                                new Handler().post(new RunnableC1936ke(this, handwritingLayer));
                                this.f22435a.b(handwritingLayer);
                                layerSubMenuPopup.dismiss();
                                return;
                            }
                            kotlin.jvm.internal.h.a();
                            throw null;
                        }
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                kotlin.jvm.internal.h.a();
                throw null;
            default:
                return;
        }
    }
}
