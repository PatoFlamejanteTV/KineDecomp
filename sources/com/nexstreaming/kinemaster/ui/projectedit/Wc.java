package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import android.widget.AbsListView;

/* compiled from: OptionListFragment.java */
/* loaded from: classes2.dex */
public class Wc implements AbsListView.OnScrollListener {

    /* renamed from: a */
    final /* synthetic */ Xc f22164a;

    public Wc(Xc xc) {
        this.f22164a = xc;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        View view;
        View view2;
        View view3;
        View view4;
        View view5;
        View view6;
        view = this.f22164a.m;
        if (view != null) {
            view2 = this.f22164a.n;
            if (view2 == null) {
                return;
            }
            int height = absListView.getHeight();
            View childAt = absListView.getChildAt(i2 - 1);
            int bottom = childAt != null ? childAt.getBottom() : 0;
            if (i != 0 || (absListView.getChildAt(0) != null && absListView.getChildAt(0).getTop() < 0)) {
                view3 = this.f22164a.m;
                view3.setVisibility(0);
            } else {
                view6 = this.f22164a.m;
                view6.setVisibility(8);
            }
            if (i3 <= 0 || i + i2 < i3 || i2 <= 0 || bottom > height + 5) {
                view4 = this.f22164a.n;
                view4.setVisibility(0);
            } else {
                view5 = this.f22164a.n;
                view5.setVisibility(8);
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
