package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.layer.EffectLayer;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;
import com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.util.ArrayList;

/* compiled from: EffectLayerEditFragment.java */
/* loaded from: classes2.dex */
public class Aa extends OptionTabFragment implements InterfaceC1866cf {
    private LayerTransformTouchHandler G;
    private View H;
    private View I;
    private VideoEditor.b E = com.nexstreaming.kinemaster.ui.layereditrender.a.b();
    private MarchingAnts F = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE, MarchingAnts.Feature.CROP_HANDLES);
    private VideoEditor.b J = new C2053va(this);
    private Object K = this;
    private AbsListView.OnScrollListener L = new C2086za(this);

    public EffectLayer Aa() {
        NexTimelineItem Y = Y();
        if (Y == null || !(Y instanceof EffectLayer)) {
            return null;
        }
        return (EffectLayer) Y;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public Class<? extends NexTimelineItem> Z() {
        return EffectLayer.class;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        super.na();
        if (Aa() == null) {
            d(OptionTabFragment.TabId.ItemEditTab);
            a(OptionTabFragment.TabId.ItemOptionTab);
            return;
        }
        d(OptionTabFragment.TabId.ItemOptionTab);
        b(OptionTabFragment.TabId.ItemOptionTab);
        this.G.a((NexLayerItem) Y());
        if (this.F == null) {
            this.F = new MarchingAnts(MarchingAnts.Feature.ROTATE_HANDLE, MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.CROP_HANDLES);
        }
        Rect rect = new Rect();
        Aa().getBounds(rect);
        this.F.a(rect);
        this.F.a(S().intValue(), R().intValue());
        da().a(this.K, (NexLayerItem) Y(), this.J, this.F);
        c(R.id.action_animation, true);
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
        da().a(this.K, (NexLayerItem) null, (VideoEditor.b) null, (VideoEditor.b) null);
        da().a(NexEditor.FastPreviewOption.normal, 0, true);
        super.onStop();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected boolean r(int i) {
        return false;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected int[] ua() {
        return new int[]{R.id.opt_in_expression, R.id.opt_out_expression, R.id.opt_split_trim, R.id.opt_strength_and_variation, R.id.opt_layer_mask, R.id.opt_information};
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected String wa() {
        return getString(R.string.layer_menu_sticker);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment
    protected int za() {
        return R.drawable.opthdr_sticker;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1866cf
    public boolean a(View view, MotionEvent motionEvent) {
        LayerTransformTouchHandler layerTransformTouchHandler;
        if (!isAdded() || Aa() == null || (layerTransformTouchHandler = this.G) == null) {
            return false;
        }
        return layerTransformTouchHandler.a(view, motionEvent);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment
    protected View b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.effect_layer_edit_tab, viewGroup, false);
        inflate.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC2062wa(this, inflate));
        ListView listView = (ListView) inflate.findViewById(R.id.effectMenuList);
        ArrayList arrayList = new ArrayList();
        arrayList.add("Blur");
        arrayList.add("Mosaic");
        Ba ba = new Ba(arrayList);
        listView.setAdapter((ListAdapter) ba);
        listView.setOnItemClickListener(new C2078ya(this, ba));
        if (Aa() != null && arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (((String) arrayList.get(i)).equals(Aa().getEffectId())) {
                    listView.setItemChecked(i, true);
                    ba.notifyDataSetInvalidated();
                }
            }
        }
        this.G = new LayerTransformTouchHandler(inflate.getContext(), Aa(), da());
        this.H = inflate.findViewById(R.id.listViewDirectionUp);
        this.I = inflate.findViewById(R.id.listViewDirectionDown);
        listView.setOnScrollListener(this.L);
        return inflate;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment
    protected void c(OptionTabFragment.TabId tabId) {
        if (tabId == OptionTabFragment.TabId.ItemEditTab) {
            o(0);
            if (Y() != null) {
                if (this.F == null) {
                    this.F = new MarchingAnts(MarchingAnts.Feature.ROTATE_HANDLE, MarchingAnts.Feature.SIZE_HANDLE);
                }
                Rect rect = new Rect();
                Aa().getBounds(rect);
                this.F.a(rect);
                this.F.a(S().intValue(), R().intValue());
                da().a(this.K, (NexLayerItem) Y(), this.J, this.F);
            } else {
                da().a(this.K, (NexLayerItem) Y(), this.E, this.J);
            }
        } else {
            o(R.id.editmode_trim);
            if (Aa() != null) {
                if (this.F == null) {
                    this.F = new MarchingAnts(MarchingAnts.Feature.ROTATE_HANDLE, MarchingAnts.Feature.SIZE_HANDLE);
                }
                Rect rect2 = new Rect();
                Aa().getBounds(rect2);
                this.F.a(rect2);
                this.F.a(S().intValue(), R().intValue());
                da().a(this.K, (NexLayerItem) Y(), this.J, this.F);
            }
        }
        da().a(NexEditor.FastPreviewOption.normal, 0, true);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, com.nexstreaming.kinemaster.ui.projectedit.C1935kd.a
    public void a(int i) {
        super.a(i);
    }
}
