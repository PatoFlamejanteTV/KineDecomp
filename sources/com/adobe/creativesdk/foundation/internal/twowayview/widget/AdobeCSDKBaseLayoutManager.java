package com.adobe.creativesdk.foundation.internal.twowayview.widget;

import android.content.Context;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager;

/* loaded from: classes.dex */
public abstract class AdobeCSDKBaseLayoutManager extends TwoWayLayoutManager {
    private final boolean A;
    private OrientationHelper z;

    public AdobeCSDKBaseLayoutManager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.A = true;
    }

    private View o() {
        return getChildAt(getChildCount() - 1);
    }

    private View p() {
        return getChildAt(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(RecyclerView.State state) {
        int e2;
        if (this.z == null) {
            this.z = OrientationHelper.createOrientationHelper(this, 1);
        }
        int itemCount = state.getItemCount();
        if (itemCount != 0 && h() == -1 && (e2 = e()) >= 0 && e2 < itemCount) {
            View findViewByPosition = findViewByPosition(e2);
            if (findViewByPosition != null) {
                c(e2, b(findViewByPosition));
            } else {
                c(-1, 0);
            }
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return f.a(state, this.z, p(), o(), this, true);
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return f.a(state, this.z, p(), o(), this, true, false);
    }

    @Override // com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return f.b(state, this.z, p(), o(), this, true);
    }

    public AdobeCSDKBaseLayoutManager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.A = true;
    }

    public AdobeCSDKBaseLayoutManager(TwoWayLayoutManager.Orientation orientation) {
        super(orientation);
        this.A = true;
    }
}
