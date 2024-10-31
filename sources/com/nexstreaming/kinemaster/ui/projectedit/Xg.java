package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorMatrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import c.e.a.a.d;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.layer.StickerLayer;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;
import com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: StickerEditFragment.java */
/* loaded from: classes2.dex */
public class Xg extends OptionTabFragment implements InterfaceC1866cf {
    private Bitmap E;
    private ColorMatrix H;
    private int I;
    private LayerTransformTouchHandler J;
    private View K;
    private View L;
    private VideoEditor.b F = com.nexstreaming.kinemaster.ui.layereditrender.a.b();
    private MarchingAnts G = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
    private Object M = this;
    private VideoEditor.b N = new Pg(this);
    private AbsListView.OnScrollListener O = new Tg(this);
    private View.OnLayoutChangeListener P = new Ug(this);
    private ViewTreeObserver.OnGlobalLayoutListener Q = new Vg(this);

    /* compiled from: StickerEditFragment.java */
    /* loaded from: classes2.dex */
    public class a extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        ArrayList<c.d.b.h.a> f22172a = new ArrayList<>();

        /* renamed from: b, reason: collision with root package name */
        c.e.a.a.f f22173b;

        /* compiled from: StickerEditFragment.java */
        /* renamed from: com.nexstreaming.kinemaster.ui.projectedit.Xg$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private class C0116a {

            /* renamed from: a, reason: collision with root package name */
            ImageView f22175a;

            private C0116a() {
            }

            /* synthetic */ C0116a(a aVar, Pg pg) {
                this();
            }
        }

        public a(Context context, List<? extends c.d.b.h.a> list) {
            if (list != null) {
                Iterator<? extends c.d.b.h.a> it = list.iterator();
                while (it.hasNext()) {
                    this.f22172a.add(it.next());
                }
            }
            if (this.f22173b == null) {
                this.f22173b = new Wg(this, context, Xg.this, context);
                this.f22173b.a(Xg.this.getFragmentManager(), new d.a(context, "STICKER_CACHE"));
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f22172a.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.f22172a.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C0116a c0116a;
            Context context = viewGroup.getContext();
            if (view == null) {
                view = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.sticker_item, viewGroup, false);
                ImageView imageView = (ImageView) view.findViewById(R.id.stickerImageView);
                c0116a = new C0116a(this, null);
                c0116a.f22175a = imageView;
                view.setTag(c0116a);
            } else {
                c0116a = (C0116a) view.getTag();
            }
            ArrayList<c.d.b.h.a> arrayList = this.f22172a;
            if (arrayList != null) {
                this.f22173b.a(arrayList.get(i), c0116a.f22175a, R.drawable.transparent);
            }
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public StickerLayer Aa() {
        NexTimelineItem Y = Y();
        if (Y == null || !(Y instanceof StickerLayer)) {
            return null;
        }
        return (StickerLayer) Y;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public Class<? extends NexTimelineItem> Z() {
        return StickerLayer.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
        this.E = null;
        this.J.a((NexLayerItem) Y());
        if (this.G == null) {
            this.G = new MarchingAnts(MarchingAnts.Feature.ROTATE_HANDLE, MarchingAnts.Feature.SIZE_HANDLE);
        }
        Rect rect = new Rect();
        Aa().getBounds(rect);
        this.G.a(rect);
        View Q = Q();
        if (Q != null) {
            Q.addOnLayoutChangeListener(this.P);
            Q.getViewTreeObserver().addOnGlobalLayoutListener(this.Q);
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
    public void onDestroy() {
        this.E = null;
        super.onDestroy();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment, com.nexstreaming.kinemaster.ui.projectedit.Xc, com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.J = null;
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        this.G = null;
        da().a(this.M, (NexLayerItem) null, (VideoEditor.b) null, (VideoEditor.b) null);
        da().a(NexEditor.FastPreviewOption.normal, 0, true);
        super.onStop();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected boolean r(int i) {
        return false;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected int[] ua() {
        return new int[]{R.id.opt_in_expression, R.id.opt_overall_expression, R.id.opt_out_expression, R.id.opt_colorize_color, R.id.opt_alpha_adj, R.id.opt_split_trim, R.id.opt_rotate, R.id.opt_layer_nudge, R.id.opt_layer_mask, R.id.opt_blending, R.id.opt_information};
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected String wa() {
        getString(R.string.layer_menu_overlay);
        return getString(R.string.layer_menu_sticker);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment
    protected int za() {
        return R.drawable.opthdr_sticker;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment
    protected View b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.sticker_edit_tab, viewGroup, false);
        inflate.getViewTreeObserver().addOnGlobalLayoutListener(new Qg(this, inflate));
        GridView gridView = (GridView) inflate.findViewById(R.id.stickerGridView);
        a aVar = new a(getActivity(), c.d.b.h.a.f());
        gridView.setAdapter((ListAdapter) aVar);
        gridView.setOnItemClickListener(new Sg(this, aVar));
        this.J = new LayerTransformTouchHandler(inflate.getContext(), Aa(), da());
        this.K = inflate.findViewById(R.id.listViewDirectionUp);
        this.L = inflate.findViewById(R.id.listViewDirectionDown);
        gridView.setOnScrollListener(this.O);
        return inflate;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment
    protected void c(OptionTabFragment.TabId tabId) {
        if (tabId == OptionTabFragment.TabId.ItemEditTab) {
            o(0);
            if (Y() != null) {
                if (this.G == null) {
                    this.G = new MarchingAnts(MarchingAnts.Feature.ROTATE_HANDLE, MarchingAnts.Feature.SIZE_HANDLE);
                }
                Rect rect = new Rect();
                Aa().getBounds(rect);
                this.G.a(rect);
                View Q = Q();
                if (Q != null) {
                    Q.addOnLayoutChangeListener(this.P);
                    Q.getViewTreeObserver().addOnGlobalLayoutListener(this.Q);
                }
            } else {
                da().a(this.M, (NexLayerItem) Y(), this.F, this.N);
            }
        } else {
            o(R.id.editmode_trim);
            if (Aa() != null) {
                if (this.G == null) {
                    this.G = new MarchingAnts(MarchingAnts.Feature.ROTATE_HANDLE, MarchingAnts.Feature.SIZE_HANDLE);
                }
                Rect rect2 = new Rect();
                Aa().getBounds(rect2);
                this.G.a(rect2);
                View Q2 = Q();
                if (Q2 != null && Q2 != null) {
                    Q2.addOnLayoutChangeListener(this.P);
                    Q2.getViewTreeObserver().addOnGlobalLayoutListener(this.Q);
                }
            }
        }
        da().a(NexEditor.FastPreviewOption.normal, 0, true);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1866cf
    public boolean a(View view, MotionEvent motionEvent) {
        LayerTransformTouchHandler layerTransformTouchHandler;
        if (!isAdded() || Aa() == null || (layerTransformTouchHandler = this.J) == null) {
            return false;
        }
        return layerTransformTouchHandler.a(view, motionEvent);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, com.nexstreaming.kinemaster.ui.projectedit.C1935kd.a
    public void a(int i) {
        super.a(i);
    }
}
