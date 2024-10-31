package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.C2300c;
import com.nextreaming.nexeditorui.ColorEffect;
import com.nextreaming.nexeditorui.NexTimelineItem;
import java.util.List;

/* compiled from: OptionColorTintFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.lc, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1943lc extends Bg implements AbsListView.OnScrollListener {
    private NexTimelineItem.h l;
    private NexTimelineItem.g m;
    private List<ColorEffect> n;
    private C2300c o;
    private GridView p;
    private View q;
    private View r;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        super.na();
        if (Y() != null) {
            if (Y() != null && (Y() instanceof NexTimelineItem.h)) {
                this.l = (NexTimelineItem.h) Y();
            }
            if (Y() != null && (Y() instanceof NexTimelineItem.g)) {
                this.m = (NexTimelineItem.g) Y();
            }
            ColorEffect colorEffect = this.l.getColorEffect();
            int i = 0;
            if (colorEffect == null) {
                this.o.a(0);
            } else {
                while (true) {
                    if (i >= this.n.size()) {
                        break;
                    }
                    if (colorEffect.equals(this.n.get(i))) {
                        this.o.a(i);
                        break;
                    }
                    i++;
                }
            }
            this.p.setAdapter((ListAdapter) this.o);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.color_tint_fragment, viewGroup, false);
        a(inflate);
        n(R.string.colortint_panel_title);
        f(true);
        inflate.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC1917ic(this, inflate));
        this.p = (GridView) inflate.findViewById(R.id.gridView_color_effects);
        this.n = ColorEffect.getPresetList();
        this.o = new C2300c(getActivity(), this.n);
        this.p.setAdapter((ListAdapter) this.o);
        this.o.a(new C1934kc(this));
        this.q = inflate.findViewById(R.id.listViewDirectionUp);
        this.r = inflate.findViewById(R.id.listViewDirectionDown);
        this.p.setOnScrollListener(this);
        na();
        return inflate;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.p = null;
        this.o = null;
        this.q = null;
        this.r = null;
        super.onDestroyView();
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
}
