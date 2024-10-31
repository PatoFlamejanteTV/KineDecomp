package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/* loaded from: classes.dex */
class LayoutState {

    /* renamed from: b, reason: collision with root package name */
    int f2808b;

    /* renamed from: c, reason: collision with root package name */
    int f2809c;

    /* renamed from: d, reason: collision with root package name */
    int f2810d;

    /* renamed from: e, reason: collision with root package name */
    int f2811e;

    /* renamed from: h, reason: collision with root package name */
    boolean f2814h;
    boolean i;

    /* renamed from: a, reason: collision with root package name */
    boolean f2807a = true;

    /* renamed from: f, reason: collision with root package name */
    int f2812f = 0;

    /* renamed from: g, reason: collision with root package name */
    int f2813g = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(RecyclerView.State state) {
        int i = this.f2809c;
        return i >= 0 && i < state.getItemCount();
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f2808b + ", mCurrentPosition=" + this.f2809c + ", mItemDirection=" + this.f2810d + ", mLayoutDirection=" + this.f2811e + ", mStartLine=" + this.f2812f + ", mEndLine=" + this.f2813g + '}';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View a(RecyclerView.Recycler recycler) {
        View viewForPosition = recycler.getViewForPosition(this.f2809c);
        this.f2809c += this.f2810d;
        return viewForPosition;
    }
}
