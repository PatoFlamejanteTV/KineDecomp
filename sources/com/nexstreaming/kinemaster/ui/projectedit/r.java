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
/* loaded from: classes.dex */
public class r extends OptionTabFragment implements ht {
    private LayerTransformTouchHandler c;
    private View d;
    private View e;

    /* renamed from: a, reason: collision with root package name */
    private VideoEditor.b f4113a = com.nexstreaming.kinemaster.ui.layereditrender.a.b();
    private MarchingAnts b = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
    private VideoEditor.b f = new s(this);
    private AbsListView.OnScrollListener g = new w(this);

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp
    public Class<? extends NexTimelineItem> g() {
        return EffectLayer.class;
    }

    @Override // android.app.Fragment
    public void onStop() {
        this.b = null;
        o().a((NexLayerItem) null, (VideoEditor.b) null, (VideoEditor.b) null);
        o().a(NexEditor.FastPreviewOption.normal, 0, true);
        super.onStop();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (m() != null) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_animation, R.drawable.action_animation, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_send_to_back, R.string.action_send_to_back, R.id.action_bring_to_front, R.string.action_bring_to_front, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        } else {
            a(R.id.action_undo, 0, R.id.action_redo, 0);
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment, com.nexstreaming.kinemaster.ui.projectedit.ed, android.app.Fragment
    public void onDestroyView() {
        this.c = null;
        super.onDestroyView();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    protected String a() {
        return getString(R.string.layer_menu_sticker);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    protected int[] c() {
        return new int[]{R.id.opt_in_expression, R.id.opt_out_expression, R.id.opt_split_trim, R.id.opt_strength_and_variation, R.id.opt_layer_mask, R.id.opt_layer_name};
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    protected boolean d(int i) {
        return false;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment
    protected View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = 0;
        View inflate = layoutInflater.inflate(R.layout.effect_layer_edit_tab, viewGroup, false);
        inflate.getViewTreeObserver().addOnGlobalLayoutListener(new t(this));
        ListView listView = (ListView) inflate.findViewById(R.id.effectMenuList);
        ArrayList arrayList = new ArrayList();
        arrayList.add("Blur");
        arrayList.add("Mosaic");
        x xVar = new x(arrayList);
        listView.setAdapter((ListAdapter) xVar);
        listView.setOnItemClickListener(new u(this, xVar));
        if (H() != null && arrayList != null && arrayList.size() > 0) {
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                if (((String) arrayList.get(i2)).equals(H().getEffectId())) {
                    listView.setItemChecked(i2, true);
                    xVar.notifyDataSetInvalidated();
                }
                i = i2 + 1;
            }
        }
        this.c = new LayerTransformTouchHandler(inflate.getContext(), H(), o());
        this.d = inflate.findViewById(R.id.listViewDirectionUp);
        this.e = inflate.findViewById(R.id.listViewDirectionDown);
        listView.setOnScrollListener(this.g);
        return inflate;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment
    protected void a(OptionTabFragment.TabId tabId) {
        if (tabId == OptionTabFragment.TabId.ItemEditTab) {
            g(0);
            if (m() != null) {
                if (this.b == null) {
                    this.b = new MarchingAnts(MarchingAnts.Feature.ROTATE_HANDLE, MarchingAnts.Feature.SIZE_HANDLE);
                }
                Rect rect = new Rect();
                H().getBounds(rect);
                this.b.a(rect);
                this.b.a(x(), y());
                o().a((NexLayerItem) m(), this.f, this.b);
            } else {
                o().a((NexLayerItem) m(), this.f4113a, this.f);
            }
        } else {
            g(R.id.editmode_trim);
            if (H() != null) {
                if (this.b == null) {
                    this.b = new MarchingAnts(MarchingAnts.Feature.ROTATE_HANDLE, MarchingAnts.Feature.SIZE_HANDLE);
                }
                Rect rect2 = new Rect();
                H().getBounds(rect2);
                this.b.a(rect2);
                this.b.a(x(), y());
                o().a((NexLayerItem) m(), this.f, this.b);
            }
        }
        o().a(NexEditor.FastPreviewOption.normal, 0, true);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment
    protected int h() {
        return R.drawable.opthdr_sticker;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EffectLayer H() {
        NexTimelineItem m = m();
        if (m == null || !(m instanceof EffectLayer)) {
            return null;
        }
        return (EffectLayer) m;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ht
    public boolean a(View view, MotionEvent motionEvent) {
        if (!isAdded() || H() == null || this.c == null) {
            return false;
        }
        return this.c.a(view, motionEvent);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ep.a
    public void c(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed, com.nexstreaming.kinemaster.ui.projectedit.kp
    public void f() {
        super.f();
        if (H() == null) {
            b(OptionTabFragment.TabId.ItemEditTab);
            d(OptionTabFragment.TabId.ItemOptionTab);
            return;
        }
        b(OptionTabFragment.TabId.ItemOptionTab);
        c(OptionTabFragment.TabId.ItemOptionTab);
        a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_animation, R.drawable.action_animation, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_send_to_back, R.string.action_send_to_back, R.id.action_bring_to_front, R.string.action_bring_to_front, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        c(OptionTabFragment.TabId.ItemOptionTab);
        this.c.a((NexLayerItem) m());
        if (this.b == null) {
            this.b = new MarchingAnts(MarchingAnts.Feature.ROTATE_HANDLE, MarchingAnts.Feature.SIZE_HANDLE);
        }
        Rect rect = new Rect();
        H().getBounds(rect);
        this.b.a(rect);
        this.b.a(x(), y());
        o().a((NexLayerItem) m(), this.f, this.b);
        d(R.id.action_animation, true);
    }
}
