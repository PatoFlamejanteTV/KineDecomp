package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.util.TypedValue;
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

/* compiled from: OptionCropLayerFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.oc, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class ViewOnClickListenerC1970oc extends Bg implements InterfaceC1866cf, AbsListView.OnScrollListener, AdapterView.OnItemClickListener, View.OnClickListener {
    private NexLayerItem l;
    private ViewOnLayoutChangeListenerC1995rb m;
    private View n;
    private View o;
    private View p;
    private SwitchCompat q;
    private Slider r;
    private GridView s;
    private View t;
    private View u;
    private a v;
    private boolean w;
    private int x;
    private String y;

    /* compiled from: OptionCropLayerFragment.java */
    /* renamed from: com.nexstreaming.kinemaster.ui.projectedit.oc$a */
    /* loaded from: classes2.dex */
    private class a extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        final int[] f22466a = com.nexstreaming.kinemaster.layer.a.a();

        /* renamed from: b, reason: collision with root package name */
        final LayoutInflater f22467b;

        public a() {
            this.f22467b = LayoutInflater.from(ViewOnClickListenerC1970oc.this.getActivity());
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f22466a.length;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return this.f22466a[i];
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.f22467b.inflate(R.layout.crop_layer_shape_item, viewGroup, false);
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.shape_image);
            ImageView imageView2 = (ImageView) view.findViewById(R.id.selected);
            imageView.setImageBitmap(com.nexstreaming.kinemaster.layer.a.c(this.f22466a[i]));
            imageView2.setVisibility((ViewOnClickListenerC1970oc.this.l == null || ViewOnClickListenerC1970oc.this.l.getCropShape() != this.f22466a[i]) ? 8 : 0);
            return view;
        }
    }

    private void va() {
        this.o.setVisibility(0);
        this.p.setVisibility(8);
        g(this.y);
        this.w = false;
    }

    private void wa() {
        ViewOnLayoutChangeListenerC1995rb viewOnLayoutChangeListenerC1995rb;
        NexLayerItem nexLayerItem = this.l;
        if ((nexLayerItem != null && !nexLayerItem.isSplitScreenEnabled()) || getActivity() == null || getActivity().getIntent() == null || getActivity().getIntent().getBooleanExtra("crop_layer_guide_animation", false) || (viewOnLayoutChangeListenerC1995rb = this.m) == null) {
            return;
        }
        viewOnLayoutChangeListenerC1995rb.d();
        this.m.b();
        getActivity().getIntent().putExtra("crop_layer_guide_animation", true);
    }

    private void xa() {
        this.o.setVisibility(8);
        this.p.setVisibility(0);
        n(R.string.opt_layer_crop_shape);
        this.w = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ya() {
        NexLayerItem nexLayerItem = this.l;
        if (nexLayerItem != null) {
            boolean isSplitScreenEnabled = nexLayerItem.isSplitScreenEnabled();
            this.n.findViewById(R.id.crop_menu_mask).setEnabled(!isSplitScreenEnabled);
            this.n.findViewById(R.id.crop_menu_alert_text).setVisibility(isSplitScreenEnabled ? 0 : 8);
        }
        boolean isChecked = this.q.isChecked();
        this.n.findViewById(R.id.crop_menu_shape).setEnabled(isChecked);
        this.n.findViewById(R.id.crop_menu_feather).setEnabled(isChecked);
    }

    private void za() {
        ImageView imageView = (ImageView) this.n.findViewById(R.id.crop_menu_shape_icon);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), com.nexstreaming.kinemaster.layer.a.c(this.l.getCropShape()));
        int i = this.x;
        bitmapDrawable.setBounds(0, 0, i, i);
        imageView.setImageDrawable(bitmapDrawable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        super.na();
        this.l = (NexLayerItem) Y();
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
                boolean isSplitScreenEnabled = this.l.isSplitScreenEnabled();
                this.q.setChecked(!isSplitScreenEnabled);
                this.n.findViewById(R.id.crop_menu_alert_text).setVisibility(isSplitScreenEnabled ? 0 : 8);
            } else {
                this.q.setChecked(false);
            }
            this.r.setValue(this.l.getCropMaskFeather());
            za();
        } else {
            this.q.setChecked(false);
            this.r.setValue(0.0f);
        }
        ya();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.x = (int) TypedValue.applyDimension(1, 28.0f, getResources().getDisplayMetrics());
        wa();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, com.nextreaming.nexeditorui.I.a
    public boolean onBackPressed() {
        if (!this.w) {
            return false;
        }
        va();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.crop_menu_shape) {
            return;
        }
        xa();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.n = layoutInflater.inflate(R.layout.pedit_option_crop_layer_fragment, viewGroup, false);
        a(this.n);
        this.y = getString(R.string.opt_crop);
        g(this.y);
        f(true);
        this.o = this.n.findViewById(R.id.crop_menu_container);
        this.p = this.n.findViewById(R.id.shape_list_container);
        this.q = (SwitchCompat) this.n.findViewById(R.id.crop_menu_mask_on_off);
        this.q.setOnCheckedChangeListener(new C1952mc(this));
        this.r = (Slider) this.n.findViewById(R.id.crop_menu_feather_slider);
        this.r.setListener(new C1961nc(this));
        if (Build.VERSION.SDK_INT < 17) {
            this.r.setStep(5.0f);
        } else {
            this.r.setStep(1.0f);
        }
        this.n.findViewById(R.id.crop_menu_shape).setOnClickListener(this);
        this.v = new a();
        this.s = (GridView) this.n.findViewById(R.id.gridView_masks);
        this.s.setAdapter((ListAdapter) this.v);
        this.t = this.n.findViewById(R.id.listViewDirectionUp);
        this.u = this.n.findViewById(R.id.listViewDirectionDown);
        this.s.setOnScrollListener(this);
        this.s.setOnItemClickListener(this);
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
            this.v.notifyDataSetChanged();
            VideoEditor da = da();
            if (da != null) {
                da.c(this.l);
                da.a(NexEditor.FastPreviewOption.normal, 0, true);
                da.J();
            }
            za();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.t == null || this.u == null) {
            return;
        }
        int height = absListView.getHeight();
        int height2 = absListView.getChildAt(0) != null ? absListView.getChildAt(0).getHeight() : 0;
        if (i == 0 && (absListView.getChildAt(0) == null || absListView.getChildAt(0).getTop() >= 0)) {
            this.t.setVisibility(8);
        } else {
            this.t.setVisibility(0);
        }
        if (i3 > 0 && i + i2 >= i3 && i2 > 0 && absListView.getChildAt(i2 - 1).getTop() <= height - height2) {
            this.u.setVisibility(8);
        } else {
            this.u.setVisibility(0);
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
