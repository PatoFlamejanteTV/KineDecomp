package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.layer.AssetLayer;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: OptionLayerShapeFragment.java */
/* loaded from: classes2.dex */
public class Oc extends Bg implements InterfaceC1866cf, AbsListView.OnScrollListener, AdapterView.OnItemClickListener {
    private NexLayerItem l;
    private ViewOnLayoutChangeListenerC1995rb m;
    private View n;
    private Slider o;
    private GridView p;
    private View q;
    private View r;
    private a s;

    /* compiled from: OptionLayerShapeFragment.java */
    /* loaded from: classes2.dex */
    private class a extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        final int[] f21980a = com.nexstreaming.kinemaster.layer.a.a();

        /* renamed from: b, reason: collision with root package name */
        final LayoutInflater f21981b;

        public a() {
            this.f21981b = LayoutInflater.from(Oc.this.getActivity());
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f21980a.length;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return this.f21980a[i];
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.f21981b.inflate(R.layout.crop_layer_shape_item, viewGroup, false);
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.shape_image);
            ImageView imageView2 = (ImageView) view.findViewById(R.id.selected);
            imageView.setImageBitmap(com.nexstreaming.kinemaster.layer.a.c(this.f21980a[i]));
            imageView2.setVisibility((Oc.this.l == null || Oc.this.l.getCropShape() != this.f21980a[i]) ? 8 : 0);
            return view;
        }
    }

    private void va() {
        ViewOnLayoutChangeListenerC1995rb viewOnLayoutChangeListenerC1995rb;
        NexLayerItem nexLayerItem = this.l;
        if ((nexLayerItem != null && !nexLayerItem.isSplitScreenEnabled()) || getActivity() == null || getActivity().getIntent() == null || getActivity().getIntent().getBooleanExtra("crop_layer_guide_animation", false) || (viewOnLayoutChangeListenerC1995rb = this.m) == null) {
            return;
        }
        viewOnLayoutChangeListenerC1995rb.d();
        this.m.b();
        getActivity().getIntent().putExtra("crop_layer_guide_animation", true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        super.na();
        NexLayerItem nexLayerItem = this.l;
        if (nexLayerItem != null) {
            if (this.m == null) {
                boolean z = !nexLayerItem.isSplitScreenEnabled();
                NexLayerItem nexLayerItem2 = this.l;
                if ((nexLayerItem2 instanceof AssetLayer) && z && !((AssetLayer) nexLayerItem2).isSyncXYScale()) {
                    z = false;
                }
                this.m = new ViewOnLayoutChangeListenerC1995rb(this, z);
                Q().addOnLayoutChangeListener(this.m);
            }
            this.m.b();
            if (this.l.useCropMask()) {
                this.n.findViewById(R.id.crop_menu_alert_text).setVisibility(this.l.isSplitScreenEnabled() ? 0 : 8);
            }
            this.o.setValue(this.l.getCropMaskFeather());
            return;
        }
        this.o.setValue(0.0f);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        va();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, com.nextreaming.nexeditorui.I.a
    public boolean onBackPressed() {
        return false;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.n = layoutInflater.inflate(R.layout.pedit_option_shape_layer_fragment, viewGroup, false);
        a(this.n);
        g(getString(R.string.opt_layer_crop_shape));
        f(true);
        this.l = (NexLayerItem) Y();
        NexLayerItem nexLayerItem = this.l;
        if (nexLayerItem != null && !nexLayerItem.useCropMask()) {
            this.l.setUseCropMask(true);
            this.l.setCropShape(0);
        }
        this.o = (Slider) this.n.findViewById(R.id.crop_menu_feather_slider);
        this.o.setListener(new Nc(this));
        if (Build.VERSION.SDK_INT < 17) {
            this.o.setStep(5.0f);
        } else {
            this.o.setStep(1.0f);
        }
        this.s = new a();
        this.p = (GridView) this.n.findViewById(R.id.gridView_masks);
        this.p.setAdapter((ListAdapter) this.s);
        this.q = this.n.findViewById(R.id.listViewDirectionUp);
        this.r = this.n.findViewById(R.id.listViewDirectionDown);
        this.p.setOnScrollListener(this);
        this.p.setOnItemClickListener(this);
        na();
        return this.n;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.n = null;
        if (this.m != null) {
            Q().removeOnLayoutChangeListener(this.m);
            this.m.a();
            this.m = null;
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        NexLayerItem nexLayerItem = this.l;
        if (nexLayerItem != null) {
            nexLayerItem.setCropShape((int) j);
            this.s.notifyDataSetChanged();
            VideoEditor da = da();
            if (da != null) {
                da.c(this.l);
                da.a(NexEditor.FastPreviewOption.normal, 0, true);
                da.J();
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.q == null || this.r == null) {
            return;
        }
        int height = absListView.getHeight();
        int height2 = absListView.getChildAt(0) != null ? absListView.getChildAt(0).getHeight() : 0;
        if (i == 0 && (absListView.getChildAt(0) == null || absListView.getChildAt(0).getTop() >= 0)) {
            this.q.setVisibility(8);
        } else {
            this.q.setVisibility(0);
        }
        if (i3 > 0 && i + i2 >= i3 && i2 > 0 && absListView.getChildAt(i2 - 1).getTop() <= height - height2) {
            this.r.setVisibility(8);
        } else {
            this.r.setVisibility(0);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        ViewOnLayoutChangeListenerC1995rb viewOnLayoutChangeListenerC1995rb = this.m;
        if (viewOnLayoutChangeListenerC1995rb != null) {
            viewOnLayoutChangeListenerC1995rb.c();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1866cf
    public boolean a(View view, MotionEvent motionEvent) {
        ViewOnLayoutChangeListenerC1995rb viewOnLayoutChangeListenerC1995rb = this.m;
        return viewOnLayoutChangeListenerC1995rb != null && viewOnLayoutChangeListenerC1995rb.a(view, motionEvent);
    }
}
