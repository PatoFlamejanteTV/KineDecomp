package me.relex.circleindicator;

import android.database.DataSetObserver;
import android.support.v4.view.ViewPager;

/* compiled from: CircleIndicator.java */
/* loaded from: classes3.dex */
class b extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ CircleIndicator f28741a;

    public b(CircleIndicator circleIndicator) {
        this.f28741a = circleIndicator;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        ViewPager viewPager;
        ViewPager viewPager2;
        int i;
        ViewPager viewPager3;
        super.onChanged();
        viewPager = this.f28741a.f28731a;
        if (viewPager == null) {
            return;
        }
        viewPager2 = this.f28741a.f28731a;
        int count = viewPager2.getAdapter().getCount();
        if (count == this.f28741a.getChildCount()) {
            return;
        }
        i = this.f28741a.m;
        if (i >= count) {
            this.f28741a.m = -1;
        } else {
            CircleIndicator circleIndicator = this.f28741a;
            viewPager3 = circleIndicator.f28731a;
            circleIndicator.m = viewPager3.getCurrentItem();
        }
        this.f28741a.a();
    }
}
