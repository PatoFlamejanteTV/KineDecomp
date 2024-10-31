package android.support.v7.widget;

import android.graphics.PointF;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/* loaded from: classes.dex */
public class LinearSnapHelper extends SnapHelper {

    /* renamed from: d, reason: collision with root package name */
    private OrientationHelper f2840d;

    /* renamed from: e, reason: collision with root package name */
    private OrientationHelper f2841e;

    private int a(RecyclerView.LayoutManager layoutManager, View view, OrientationHelper orientationHelper) {
        int end;
        int decoratedStart = orientationHelper.getDecoratedStart(view) + (orientationHelper.getDecoratedMeasurement(view) / 2);
        if (layoutManager.getClipToPadding()) {
            end = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2);
        } else {
            end = orientationHelper.getEnd() / 2;
        }
        return decoratedStart - end;
    }

    private View b(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int end;
        int childCount = layoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        if (layoutManager.getClipToPadding()) {
            end = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2);
        } else {
            end = orientationHelper.getEnd() / 2;
        }
        int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = layoutManager.getChildAt(i2);
            int abs = Math.abs((orientationHelper.getDecoratedStart(childAt) + (orientationHelper.getDecoratedMeasurement(childAt) / 2)) - end);
            if (abs < i) {
                view = childAt;
                i = abs;
            }
        }
        return view;
    }

    private OrientationHelper c(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f2841e;
        if (orientationHelper == null || orientationHelper.f2858a != layoutManager) {
            this.f2841e = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.f2841e;
    }

    private OrientationHelper d(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f2840d;
        if (orientationHelper == null || orientationHelper.f2858a != layoutManager) {
            this.f2840d = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.f2840d;
    }

    @Override // android.support.v7.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = a(layoutManager, view, c(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = a(layoutManager, view, d(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // android.support.v7.widget.SnapHelper
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return b(layoutManager, d(layoutManager));
        }
        if (layoutManager.canScrollHorizontally()) {
            return b(layoutManager, c(layoutManager));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v7.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        int itemCount;
        View findSnapView;
        int position;
        int i3;
        PointF computeScrollVectorForPosition;
        int i4;
        int i5;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (itemCount = layoutManager.getItemCount()) == 0 || (findSnapView = findSnapView(layoutManager)) == null || (position = layoutManager.getPosition(findSnapView)) == -1 || (computeScrollVectorForPosition = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return -1;
        }
        if (layoutManager.canScrollHorizontally()) {
            i4 = a(layoutManager, c(layoutManager), i, 0);
            if (computeScrollVectorForPosition.x < 0.0f) {
                i4 = -i4;
            }
        } else {
            i4 = 0;
        }
        if (layoutManager.canScrollVertically()) {
            i5 = a(layoutManager, d(layoutManager), 0, i2);
            if (computeScrollVectorForPosition.y < 0.0f) {
                i5 = -i5;
            }
        } else {
            i5 = 0;
        }
        if (layoutManager.canScrollVertically()) {
            i4 = i5;
        }
        if (i4 == 0) {
            return -1;
        }
        int i6 = position + i4;
        if (i6 < 0) {
            i6 = 0;
        }
        return i6 >= itemCount ? i3 : i6;
    }

    private int a(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper, int i, int i2) {
        int[] calculateScrollDistance = calculateScrollDistance(i, i2);
        float a2 = a(layoutManager, orientationHelper);
        if (a2 <= 0.0f) {
            return 0;
        }
        return Math.round((Math.abs(calculateScrollDistance[0]) > Math.abs(calculateScrollDistance[1]) ? calculateScrollDistance[0] : calculateScrollDistance[1]) / a2);
    }

    private float a(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int childCount = layoutManager.getChildCount();
        if (childCount == 0) {
            return 1.0f;
        }
        View view = null;
        View view2 = null;
        int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = layoutManager.getChildAt(i3);
            int position = layoutManager.getPosition(childAt);
            if (position != -1) {
                if (position < i) {
                    view = childAt;
                    i = position;
                }
                if (position > i2) {
                    view2 = childAt;
                    i2 = position;
                }
            }
        }
        if (view == null || view2 == null) {
            return 1.0f;
        }
        int max = Math.max(orientationHelper.getDecoratedEnd(view), orientationHelper.getDecoratedEnd(view2)) - Math.min(orientationHelper.getDecoratedStart(view), orientationHelper.getDecoratedStart(view2));
        if (max == 0) {
            return 1.0f;
        }
        return (max * 1.0f) / ((i2 - i) + 1);
    }
}