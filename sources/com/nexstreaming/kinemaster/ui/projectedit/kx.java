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
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.layer.StickerLayer;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;
import com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment;
import com.nextreaming.a.a.c;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: StickerEditFragment.java */
/* loaded from: classes.dex */
public class kx extends OptionTabFragment implements ht {

    /* renamed from: a, reason: collision with root package name */
    private Bitmap f4048a;
    private ColorMatrix d;
    private int e;
    private LayerTransformTouchHandler f;
    private View g;
    private View h;
    private VideoEditor.b b = com.nexstreaming.kinemaster.ui.layereditrender.a.b();
    private MarchingAnts c = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
    private VideoEditor.b i = new ky(this);
    private AbsListView.OnScrollListener j = new lc(this);
    private View.OnLayoutChangeListener k = new ld(this);
    private ViewTreeObserver.OnGlobalLayoutListener l = new le(this);

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp
    public Class<? extends NexTimelineItem> g() {
        return StickerLayer.class;
    }

    @Override // android.app.Fragment
    public void onStop() {
        this.c = null;
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
        this.f4048a = null;
        super.onDestroy();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment, com.nexstreaming.kinemaster.ui.projectedit.ed, android.app.Fragment
    public void onDestroyView() {
        this.f = null;
        super.onDestroyView();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    protected String a() {
        return getString(R.string.layer_menu_sticker);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    protected int[] c() {
        return new int[]{R.id.opt_in_expression, R.id.opt_overall_expression, R.id.opt_out_expression, R.id.opt_colorize_color, R.id.opt_alpha_adj, R.id.opt_split_trim, R.id.opt_rotate, R.id.opt_layer_mask, R.id.opt_layer_name};
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    protected boolean d(int i) {
        return false;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment
    protected View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.sticker_edit_tab, viewGroup, false);
        inflate.getViewTreeObserver().addOnGlobalLayoutListener(new kz(this));
        GridView gridView = (GridView) inflate.findViewById(R.id.stickerGridView);
        a aVar = new a(getActivity(), com.nexstreaming.kinemaster.e.a.b());
        gridView.setAdapter((ListAdapter) aVar);
        gridView.setOnItemClickListener(new la(this, aVar));
        this.f = new LayerTransformTouchHandler(inflate.getContext(), H(), o());
        this.g = inflate.findViewById(R.id.listViewDirectionUp);
        this.h = inflate.findViewById(R.id.listViewDirectionDown);
        gridView.setOnScrollListener(this.j);
        return inflate;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment
    protected void a(OptionTabFragment.TabId tabId) {
        if (tabId == OptionTabFragment.TabId.ItemEditTab) {
            g(0);
            if (m() != null) {
                if (this.c == null) {
                    this.c = new MarchingAnts(MarchingAnts.Feature.ROTATE_HANDLE, MarchingAnts.Feature.SIZE_HANDLE);
                }
                Rect rect = new Rect();
                H().getBounds(rect);
                this.c.a(rect);
                View w = w();
                if (w != null) {
                    w.addOnLayoutChangeListener(this.k);
                    w.getViewTreeObserver().addOnGlobalLayoutListener(this.l);
                }
            } else {
                o().a((NexLayerItem) m(), this.b, this.i);
            }
        } else {
            g(R.id.editmode_trim);
            if (H() != null) {
                if (this.c == null) {
                    this.c = new MarchingAnts(MarchingAnts.Feature.ROTATE_HANDLE, MarchingAnts.Feature.SIZE_HANDLE);
                }
                Rect rect2 = new Rect();
                H().getBounds(rect2);
                this.c.a(rect2);
                View w2 = w();
                if (w2 != null && w2 != null) {
                    w2.addOnLayoutChangeListener(this.k);
                    w2.getViewTreeObserver().addOnGlobalLayoutListener(this.l);
                }
            }
        }
        o().a(NexEditor.FastPreviewOption.normal, 0, true);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment
    protected int h() {
        return R.drawable.opthdr_sticker;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public StickerLayer H() {
        NexTimelineItem m = m();
        if (m == null || !(m instanceof StickerLayer)) {
            return null;
        }
        return (StickerLayer) m;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ht
    public boolean a(View view, MotionEvent motionEvent) {
        if (!isAdded() || H() == null || this.f == null) {
            return false;
        }
        return this.f.a(view, motionEvent);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ep.a
    public void c(int i) {
    }

    /* compiled from: StickerEditFragment.java */
    /* loaded from: classes.dex */
    public class a extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        ArrayList<com.nexstreaming.kinemaster.e.a> f4049a = new ArrayList<>();
        com.nextreaming.a.a.e b;

        public a(Context context, List<? extends com.nexstreaming.kinemaster.e.a> list) {
            if (list != null) {
                Iterator<? extends com.nexstreaming.kinemaster.e.a> it = list.iterator();
                while (it.hasNext()) {
                    this.f4049a.add(it.next());
                }
            }
            if (this.b == null) {
                this.b = new lf(this, context, kx.this, context);
                this.b.a(kx.this.getFragmentManager(), new c.a(context, "STICKER_CACHE"));
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f4049a.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.f4049a.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C0077a c0077a;
            Context context = viewGroup.getContext();
            if (view == null) {
                view = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.sticker_item, viewGroup, false);
                ImageView imageView = (ImageView) view.findViewById(R.id.stickerImageView);
                C0077a c0077a2 = new C0077a(this, null);
                c0077a2.f4050a = imageView;
                view.setTag(c0077a2);
                c0077a = c0077a2;
            } else {
                c0077a = (C0077a) view.getTag();
            }
            if (this.f4049a != null) {
                this.b.a(this.f4049a.get(i), c0077a.f4050a, R.drawable.transparent);
            }
            return view;
        }

        /* compiled from: StickerEditFragment.java */
        /* renamed from: com.nexstreaming.kinemaster.ui.projectedit.kx$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private class C0077a {

            /* renamed from: a, reason: collision with root package name */
            ImageView f4050a;

            private C0077a() {
            }

            /* synthetic */ C0077a(a aVar, ky kyVar) {
                this();
            }
        }
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
        this.f4048a = null;
        this.f.a((NexLayerItem) m());
        if (this.c == null) {
            this.c = new MarchingAnts(MarchingAnts.Feature.ROTATE_HANDLE, MarchingAnts.Feature.SIZE_HANDLE);
        }
        Rect rect = new Rect();
        H().getBounds(rect);
        this.c.a(rect);
        View w = w();
        if (w != null) {
            w.addOnLayoutChangeListener(this.k);
            w.getViewTreeObserver().addOnGlobalLayoutListener(this.l);
        }
        d(R.id.action_animation, true);
    }
}
