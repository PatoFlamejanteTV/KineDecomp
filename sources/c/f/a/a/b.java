package c.f.a.a;

import android.support.v4.util.LongSparseArray;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: HeaderViewCache.java */
/* loaded from: classes3.dex */
public class b implements a {

    /* renamed from: a, reason: collision with root package name */
    private final c.f.a.b f3920a;

    /* renamed from: b, reason: collision with root package name */
    private final LongSparseArray<View> f3921b = new LongSparseArray<>();

    /* renamed from: c, reason: collision with root package name */
    private final c.f.a.d.b f3922c;

    public b(c.f.a.b bVar, c.f.a.d.b bVar2) {
        this.f3920a = bVar;
        this.f3922c = bVar2;
    }

    @Override // c.f.a.a.a
    public View a(RecyclerView recyclerView, int i) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        long b2 = this.f3920a.b(i);
        View view = this.f3921b.get(b2);
        if (view == null) {
            RecyclerView.ViewHolder a2 = this.f3920a.a(recyclerView);
            this.f3920a.a(a2, i);
            view = a2.itemView;
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            if (this.f3922c.a(recyclerView) == 1) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824);
                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 0);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 0);
                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824);
            }
            view.measure(ViewGroup.getChildMeasureSpec(makeMeasureSpec, recyclerView.getPaddingLeft() + recyclerView.getPaddingRight(), view.getLayoutParams().width), ViewGroup.getChildMeasureSpec(makeMeasureSpec2, recyclerView.getPaddingTop() + recyclerView.getPaddingBottom(), view.getLayoutParams().height));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            this.f3921b.put(b2, view);
        }
        return view;
    }

    @Override // c.f.a.a.a
    public void invalidate() {
        this.f3921b.clear();
    }
}
