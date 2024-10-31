package com.nexstreaming.kinemaster.ui.d;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.I;
import com.nextreaming.nexeditorui.NexTimelineItem;
import java.util.List;

/* compiled from: OptionGroupFragment.java */
/* loaded from: classes.dex */
public abstract class m extends com.nexstreaming.kinemaster.ui.b.c implements I.a {
    private View r;
    protected ListView s;
    protected GridView t;
    protected g v;
    protected e w;
    protected List<n> u = null;
    protected int x = -1;
    private boolean y = false;
    private f z = null;
    private Animation.AnimationListener A = new j(this);
    private AdapterView.OnItemClickListener B = new k(this);
    private AdapterView.OnItemClickListener C = new l(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OptionGroupFragment.java */
    /* loaded from: classes.dex */
    public class a extends Animation {

        /* renamed from: a */
        private final float f21557a;

        /* renamed from: b */
        private final float f21558b;

        /* renamed from: c */
        private View f21559c;

        public a(float f2, float f3, View view) {
            this.f21557a = f2;
            this.f21558b = f3 - f2;
            this.f21559c = view;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f2, Transformation transformation) {
            ((RelativeLayout.LayoutParams) this.f21559c.getLayoutParams()).width = (int) (this.f21557a + (this.f21558b * f2));
            this.f21559c.requestLayout();
        }

        @Override // android.view.animation.Animation
        public boolean willChangeBounds() {
            return true;
        }
    }

    public abstract boolean Aa();

    protected abstract void Ba();

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public Class<? extends NexTimelineItem> Z() {
        return null;
    }

    public abstract void a(f fVar);

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public boolean ja() {
        return true;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        Ba();
        super.na();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.r = layoutInflater.inflate(R.layout.option_group_fragment, viewGroup, false);
        this.r.setOnClickListener(new i(this));
        a(this.r);
        n(za());
        f(true);
        g(false);
        this.s = (ListView) this.r.findViewById(R.id.groupList);
        this.t = (GridView) this.r.findViewById(R.id.childGridView);
        this.u = ya();
        this.v = new g(getContext(), this.u);
        this.s.setOnItemClickListener(xa());
        this.t.setOnItemClickListener(wa());
        this.s.setAdapter((ListAdapter) this.v);
        this.t.setVisibility(0);
        na();
        return this.r;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroy() {
        this.r = null;
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        if (this.y) {
            this.y = false;
            G();
        }
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        m(false);
        super.onStart();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        fa();
        super.onStop();
    }

    public void q(int i) {
        GridView gridView;
        if (i < 0 || (gridView = this.t) == null || gridView.getAdapter() == null) {
            return;
        }
        GridView gridView2 = this.t;
        gridView2.performItemClick(gridView2.getChildAt(i), i, this.t.getAdapter().getItemId(i));
        this.t.setSelection(i);
    }

    public void r(int i) {
        ListView listView;
        if (i < 0 || (listView = this.s) == null || listView.getAdapter() == null) {
            return;
        }
        ListView listView2 = this.s;
        listView2.performItemClick(listView2.getChildAt(i), i, this.s.getAdapter().getItemId(i));
        this.s.setSelection(i);
    }

    public void va() {
        e eVar = this.w;
        if (eVar != null) {
            eVar.a(-1);
        }
    }

    protected abstract AdapterView.OnItemClickListener wa();

    protected abstract AdapterView.OnItemClickListener xa();

    protected abstract List<n> ya();

    public abstract int za();

    public void a(float f2) {
        if (this.s.getLayoutParams().width == f2) {
            return;
        }
        a aVar = new a(this.s.getLayoutParams().width, f2, this.s);
        aVar.setDuration(100L);
        aVar.setAnimationListener(this.A);
        this.s.startAnimation(aVar);
    }
}
