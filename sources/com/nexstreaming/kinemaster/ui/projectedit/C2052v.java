package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.layer.AssetLayer;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;
import com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: AssetLayerEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.v, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2052v extends OptionTabFragment implements InterfaceC1866cf {
    private LayerTransformTouchHandler G;
    private VideoEditor.b E = com.nexstreaming.kinemaster.ui.layereditrender.a.b();
    private MarchingAnts F = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
    private Object H = this;
    private VideoEditor.b I = new C2002s(this);
    private View.OnLayoutChangeListener J = new ViewOnLayoutChangeListenerC2011t(this);
    private ViewTreeObserver.OnGlobalLayoutListener K = new ViewTreeObserverOnGlobalLayoutListenerC2043u(this);

    private AssetLayer Aa() {
        NexTimelineItem Y = Y();
        if (Y == null || !(Y instanceof AssetLayer)) {
            return null;
        }
        return (AssetLayer) Y;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public Class<? extends NexTimelineItem> Z() {
        return AssetLayer.class;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, com.nexstreaming.kinemaster.ui.projectedit.C1935kd.a
    public void a(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        super.na();
        d(OptionTabFragment.TabId.ItemOptionTab);
        b(OptionTabFragment.TabId.ItemOptionTab);
        this.G.a((NexLayerItem) Y());
        if (this.F == null) {
            this.F = new MarchingAnts(MarchingAnts.Feature.ROTATE_HANDLE, MarchingAnts.Feature.SIZE_HANDLE);
        }
        if (Aa() != null) {
            if (Aa().getCropBounds(new RectF())) {
                this.F.a((int) r0.left, (int) r0.top, (int) r0.right, (int) r0.bottom);
            } else {
                Rect rect = new Rect();
                Aa().getBounds(rect);
                this.F.a(rect);
            }
        }
        View Q = Q();
        if (Q != null) {
            Q.addOnLayoutChangeListener(this.J);
            Q.getViewTreeObserver().addOnGlobalLayoutListener(this.K);
        }
        c(R.id.action_animation, true);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void oa() {
        if (Y() instanceof NexLayerItem) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_animation, R.drawable.action_animation, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip, R.id.action_bring_to_front, R.string.action_bring_to_front, R.id.action_bring_forward, R.string.action_bring_forward, R.id.action_send_backward, R.string.action_send_backward, R.id.action_send_to_back, R.string.action_send_to_back, R.id.action_align_center_horizontal, R.string.action_center_horizontal, R.id.action_align_center_vertical, R.string.action_center_vertical);
        } else {
            super.oa();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (Y() == null) {
            a(R.id.action_undo, 0, R.id.action_redo, 0);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment, com.nexstreaming.kinemaster.ui.projectedit.Xc, com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.G = null;
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        this.F = null;
        da().a(this.H, (NexLayerItem) null, (VideoEditor.b) null, (VideoEditor.b) null);
        da().a(NexEditor.FastPreviewOption.normal, 0, true);
        super.onStop();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected boolean r(int i) {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0058  */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected int[] ua() {
        /*
            r5 = this;
            com.nextreaming.nexeditorui.NexTimelineItem r0 = r5.Y()
            if (r0 == 0) goto L2b
            com.nexstreaming.kinemaster.layer.AssetLayer r0 = (com.nexstreaming.kinemaster.layer.AssetLayer) r0
            java.lang.String r0 = r0.getEffectItemID()
            if (r0 == 0) goto L2b
            r1 = 0
            android.support.v4.app.FragmentActivity r2 = r5.getActivity()     // Catch: java.lang.Throwable -> L17
            com.nexstreaming.app.general.nexasset.assetpackage.u r1 = com.nexstreaming.app.general.nexasset.assetpackage.y.a(r2, r0)     // Catch: java.lang.Throwable -> L17
        L17:
            if (r1 == 0) goto L2b
            java.util.List r0 = r1.e()
            if (r0 == 0) goto L2b
            java.util.List r0 = r1.e()
            int r0 = r0.size()
            if (r0 <= 0) goto L2b
            r0 = 1
            goto L2c
        L2b:
            r0 = 0
        L2c:
            com.nexstreaming.kinemaster.layer.AssetLayer r1 = r5.Aa()
            r2 = 11
            r3 = 10
            if (r1 == 0) goto L50
            com.nexstreaming.kinemaster.layer.AssetLayer r1 = r5.Aa()
            com.nexstreaming.kinemaster.layer.AssetLayer$AssetLayerType r1 = r1.getLayerType()
            com.nexstreaming.kinemaster.layer.AssetLayer$AssetLayerType r4 = com.nexstreaming.kinemaster.layer.AssetLayer.AssetLayerType.EFFECT_LAYER
            if (r1 != r4) goto L50
            if (r0 == 0) goto L4a
            int[] r0 = new int[r2]
            r0 = {x005e: FILL_ARRAY_DATA , data: [2131363119, 2131363134, 2131363132, 2131363087, 2131363085, 2131363143, 2131363127, 2131363126, 2131363137, 2131363125, 2131363120} // fill-array
            return r0
        L4a:
            int[] r0 = new int[r3]
            r0 = {x0078: FILL_ARRAY_DATA , data: [2131363119, 2131363134, 2131363132, 2131363085, 2131363143, 2131363127, 2131363126, 2131363137, 2131363125, 2131363120} // fill-array
            return r0
        L50:
            if (r0 == 0) goto L58
            int[] r0 = new int[r2]
            r0 = {x0090: FILL_ARRAY_DATA , data: [2131363119, 2131363134, 2131363132, 2131363087, 2131363085, 2131363143, 2131363137, 2131363126, 2131363125, 2131363096, 2131363120} // fill-array
            return r0
        L58:
            int[] r0 = new int[r3]
            r0 = {x00aa: FILL_ARRAY_DATA , data: [2131363119, 2131363134, 2131363132, 2131363085, 2131363143, 2131363137, 2131363126, 2131363125, 2131363096, 2131363120} // fill-array
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectedit.C2052v.ua():int[]");
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected String wa() {
        return getString(R.string.layer_menu_overlay);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment
    protected int za() {
        return (Aa() == null || Aa().getLayerType() != AssetLayer.AssetLayerType.EFFECT_LAYER) ? R.drawable.opthdr_sticker : R.drawable.opt_clip_effect;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment
    protected View b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        d(OptionTabFragment.TabId.ItemOptionTab);
        this.G = new LayerTransformTouchHandler(getActivity(), Aa(), da());
        return null;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment
    protected void c(OptionTabFragment.TabId tabId) {
        if (tabId == OptionTabFragment.TabId.ItemEditTab) {
            o(0);
            if (Y() != null) {
                da().a(this.H, (NexLayerItem) Y(), this.E, this.I);
                da().a(NexEditor.FastPreviewOption.normal, 0, true);
                if (Aa() != null && Aa().getLayerType() == AssetLayer.AssetLayerType.OVERLAY_LAYER) {
                    com.nexstreaming.kinemaster.ui.assetbrowser.o oVar = new com.nexstreaming.kinemaster.ui.assetbrowser.o();
                    oVar.a((com.nexstreaming.kinemaster.ui.assetbrowser.o) Y());
                    Bg.f21786a.a(getFragmentManager().beginTransaction(), oVar.ja()).setTransition(4097).replace(R.id.expandedOptionPanelHolder, oVar).addToBackStack("newOverlaysBrowser").remove(this).commit();
                } else {
                    com.nexstreaming.kinemaster.ui.assetbrowser.n nVar = new com.nexstreaming.kinemaster.ui.assetbrowser.n();
                    nVar.a((com.nexstreaming.kinemaster.ui.assetbrowser.n) Y());
                    Bg.f21786a.a(getFragmentManager().beginTransaction(), nVar.ja()).setTransition(4097).replace(R.id.expandedOptionPanelHolder, nVar).addToBackStack("newEffectBrowser").remove(this).commit();
                }
            } else {
                da().a(this.H, (NexLayerItem) Y(), this.E, this.I);
            }
        } else {
            o(R.id.editmode_trim);
            if (Aa() != null) {
                if (this.F == null) {
                    this.F = new MarchingAnts(MarchingAnts.Feature.ROTATE_HANDLE, MarchingAnts.Feature.SIZE_HANDLE);
                }
                if (Aa().getCropBounds(new RectF())) {
                    this.F.a((int) r8.left, (int) r8.top, (int) r8.right, (int) r8.bottom);
                } else {
                    Rect rect = new Rect();
                    Aa().getBounds(rect);
                    this.F.a(rect);
                }
                View Q = Q();
                if (Q != null && Q != null) {
                    Q.addOnLayoutChangeListener(this.J);
                    Q.getViewTreeObserver().addOnGlobalLayoutListener(this.K);
                }
            }
        }
        da().a(NexEditor.FastPreviewOption.normal, 0, true);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1866cf
    public boolean a(View view, MotionEvent motionEvent) {
        LayerTransformTouchHandler layerTransformTouchHandler;
        if (!isAdded() || Aa() == null || (layerTransformTouchHandler = this.G) == null) {
            return false;
        }
        return layerTransformTouchHandler.a(view, motionEvent);
    }
}
