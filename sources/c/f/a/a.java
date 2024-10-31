package c.f.a;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: HeaderPositionCalculator.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final b f3916a;

    /* renamed from: b, reason: collision with root package name */
    private final c.f.a.d.b f3917b;

    /* renamed from: c, reason: collision with root package name */
    private final c.f.a.a.a f3918c;

    /* renamed from: d, reason: collision with root package name */
    private final c.f.a.b.a f3919d;

    public a(b bVar, c.f.a.a.a aVar, c.f.a.d.b bVar2, c.f.a.b.a aVar2) {
        this.f3916a = bVar;
        this.f3918c = aVar;
        this.f3917b = bVar2;
        this.f3919d = aVar2;
    }

    private boolean b(int i) {
        return i < 0 || i >= this.f3916a.getItemCount();
    }

    public boolean a(View view, int i, int i2) {
        int left;
        int i3;
        if (i == 1) {
            left = view.getTop();
            i3 = this.f3919d.a(view).top;
        } else {
            left = view.getLeft();
            i3 = this.f3919d.a(view).left;
        }
        return left <= i3 && this.f3916a.b(i2) >= 0;
    }

    private boolean b(RecyclerView recyclerView, View view) {
        View a2 = a(recyclerView, view);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(a2);
        if (childAdapterPosition != -1 && childAdapterPosition > 0 && a(childAdapterPosition)) {
            View a3 = this.f3918c.a(recyclerView, childAdapterPosition);
            Rect a4 = this.f3919d.a(a3);
            Rect a5 = this.f3919d.a(view);
            if (this.f3917b.a(recyclerView) == 1) {
                if (((a2.getTop() - a4.bottom) - a3.getHeight()) - a4.top < recyclerView.getPaddingTop() + view.getBottom() + a5.top + a5.bottom) {
                    return true;
                }
            } else if (((a2.getLeft() - a4.right) - a3.getWidth()) - a4.left < recyclerView.getPaddingLeft() + view.getRight() + a5.left + a5.right) {
                return true;
            }
        }
        return false;
    }

    public boolean a(int i) {
        if (b(i)) {
            return false;
        }
        long b2 = this.f3916a.b(i);
        if (b2 < 0) {
            return false;
        }
        return i == 0 || b2 != this.f3916a.b(i - 1);
    }

    public Rect a(RecyclerView recyclerView, View view, View view2, boolean z) {
        Rect a2 = a(recyclerView, view, view2, this.f3917b.a(recyclerView));
        if (z && b(recyclerView, view)) {
            View a3 = a(recyclerView, view);
            a(recyclerView, this.f3917b.a(recyclerView), a2, view, a3, this.f3918c.a(recyclerView, recyclerView.getChildAdapterPosition(a3)));
        }
        return a2;
    }

    private boolean b(RecyclerView recyclerView, View view, View view2, int i) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        Rect a2 = this.f3919d.a(view2);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition == -1 || this.f3918c.a(recyclerView, childAdapterPosition) != view2) {
            return false;
        }
        if (i == 1) {
            if (view.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin > view2.getBottom() + a2.bottom + a2.top) {
                return false;
            }
        } else if (view.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin > view2.getRight() + a2.right + a2.left) {
            return false;
        }
        return true;
    }

    private Rect a(RecyclerView recyclerView, View view, View view2, int i) {
        int top;
        int max;
        Rect a2 = this.f3919d.a(view);
        if (i == 1) {
            int left = view2.getLeft() + a2.left;
            top = Math.max((view2.getTop() - view.getHeight()) - a2.bottom, b(recyclerView) + a2.top);
            max = left;
        } else {
            top = view2.getTop() + a2.top;
            max = Math.max((view2.getLeft() - view.getWidth()) - a2.right, a(recyclerView) + a2.left);
        }
        return new Rect(max, top, view.getWidth() + max, view.getHeight() + top);
    }

    private int b(RecyclerView recyclerView) {
        if (recyclerView.getLayoutManager().getClipToPadding()) {
            return recyclerView.getPaddingTop();
        }
        return 0;
    }

    private void a(RecyclerView recyclerView, int i, Rect rect, View view, View view2, View view3) {
        Rect a2 = this.f3919d.a(view3);
        Rect a3 = this.f3919d.a(view);
        if (i == 1) {
            int b2 = b(recyclerView) + a3.top + a3.bottom;
            int top = ((((view2.getTop() - view3.getHeight()) - a2.bottom) - a2.top) - view.getHeight()) - b2;
            if (top < b2) {
                rect.top += top;
                return;
            }
            return;
        }
        int a4 = a(recyclerView) + a3.left + a3.right;
        int left = ((((view2.getLeft() - view3.getWidth()) - a2.right) - a2.left) - view.getWidth()) - a4;
        if (left < a4) {
            rect.left += left;
        }
    }

    private View a(RecyclerView recyclerView, View view) {
        for (int i = 0; i < recyclerView.getChildCount(); i++) {
            View childAt = recyclerView.getChildAt(i);
            if (!b(recyclerView, childAt, view, this.f3917b.a(recyclerView))) {
                return childAt;
            }
        }
        return null;
    }

    private int a(RecyclerView recyclerView) {
        if (recyclerView.getLayoutManager().getClipToPadding()) {
            return recyclerView.getPaddingLeft();
        }
        return 0;
    }
}
