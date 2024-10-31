package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.LayerExpression;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.widget.DurationSpinner;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: OptionExpressionFragment.java */
/* loaded from: classes2.dex */
public abstract class Jc extends Bg implements AdapterView.OnItemClickListener, AbsListView.OnScrollListener {
    private ListView l;
    private Ca m;
    private View n;
    private DurationSpinner o;
    private long q;
    private View r;
    private View s;
    private Handler p = new Handler();
    VideoEditor.b t = new Cc(this);
    private Object u = this;
    private Runnable v = new Hc(this);

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        super.na();
        if (Y() != null) {
            g(ua());
            f(ta());
            NexLayerItem nexLayerItem = (NexLayerItem) Y();
            da().a(this.u, nexLayerItem, this.t, (VideoEditor.b) null);
            this.m = new Ca(sa(), nexLayerItem);
            int a2 = this.m.a(nexLayerItem.getLayerExpression(sa()).getId());
            this.l.setAdapter((ListAdapter) this.m);
            this.l.setOnItemClickListener(this);
            this.l.setItemChecked(a2, true);
            this.l.setOnScrollListener(this);
            if (sa().hasDuration()) {
                float duration = (nexLayerItem.getDuration() / 1000) / 2.0f;
                this.o.setMaxValue(duration);
                this.o.setScrollMaxValue(duration);
                this.o.a(nexLayerItem.getLayerExpressionDuration(sa()) / 1000.0f, false);
                if (nexLayerItem.getLayerExpression(sa()) == LayerExpression.None) {
                    this.o.setVisibility(8);
                } else {
                    this.o.setVisibility(0);
                }
            } else {
                this.o.setVisibility(8);
            }
            this.l.post(new Ec(this, a2));
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.n = a(layoutInflater, viewGroup, bundle);
        a(this.n);
        f(true);
        this.l = (ListView) this.n.findViewById(R.id.optionMenuList);
        this.l.setChoiceMode(1);
        this.o = (DurationSpinner) this.n.findViewById(R.id.durationSpinner);
        if (sa().hasDuration()) {
            this.o.setOnValueChangeListener(new Dc(this));
        }
        this.r = this.n.findViewById(R.id.listViewDirectionUp);
        this.s = this.n.findViewById(R.id.listViewDirectionDown);
        na();
        return this.n;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        super.onDestroyView();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        LayerExpression fromId = LayerExpression.fromId((int) j);
        ((NexLayerItem) Y()).setLayerExpression(sa(), fromId);
        da().J();
        if (this.o != null) {
            if (fromId != LayerExpression.None && sa().hasDuration()) {
                this.o.setVisibility(0);
                this.l.postOnAnimation(new Gc(this, this.m.a(fromId.getId())));
            } else {
                this.o.setVisibility(8);
            }
        }
        this.q = System.nanoTime();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        View view = this.n;
        if (view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new Fc(this));
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.r == null || this.s == null) {
            return;
        }
        int height = absListView.getHeight();
        int height2 = absListView.getChildAt(0) != null ? absListView.getChildAt(0).getHeight() : 0;
        if (i == 0 && (absListView.getChildAt(0) == null || absListView.getChildAt(0).getTop() >= 0)) {
            this.r.setVisibility(8);
        } else {
            this.r.setVisibility(0);
        }
        if (i3 > 0 && i + i2 >= i3 && absListView.getChildAt(i2 - 1).getTop() <= height - height2) {
            this.s.setVisibility(8);
        } else {
            this.s.setVisibility(0);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        da().a(this.u, (NexLayerItem) Y(), this.t, (VideoEditor.b) null);
        this.q = System.nanoTime();
        this.v.run();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        this.p.removeCallbacks(this.v);
        da().a(this.u, (NexLayerItem) null, (VideoEditor.b) null, (VideoEditor.b) null);
        da().a(NexEditor.FastPreviewOption.normal, 0, true);
        super.onStop();
    }

    public abstract LayerExpression.Type sa();

    protected String ta() {
        return null;
    }

    protected abstract String ua();

    protected View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.option_expression_fragment, viewGroup, false);
    }
}
