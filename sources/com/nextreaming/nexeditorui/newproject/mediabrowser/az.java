package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.view.View;
import android.widget.GridView;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class az implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaBrowserFragment f4722a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(MediaBrowserFragment mediaBrowserFragment) {
        this.f4722a = mediaBrowserFragment;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        GridView gridView;
        int c;
        if (view instanceof GridView) {
            GridView gridView2 = (GridView) view;
            if (gridView2.getChildCount() > 1) {
                c = this.f4722a.c(1);
                View childAt = gridView2.getChildAt(0);
                View childAt2 = gridView2.getChildAt(1);
                if (childAt != null && childAt2 != null && childAt2.getLeft() - childAt.getRight() < c) {
                    gridView2.setHorizontalSpacing(c * this.f4722a.getActivity().getResources().getInteger(R.integer.mediabrowser_gridview_horizontal_spacing_int));
                }
            }
        }
        gridView = this.f4722a.k;
        gridView.removeOnLayoutChangeListener(this);
    }
}
