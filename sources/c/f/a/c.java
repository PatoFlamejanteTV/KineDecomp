package c.f.a;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/* compiled from: StickyRecyclerHeadersDecoration.java */
/* loaded from: classes3.dex */
public class c extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    private final b f3923a;

    /* renamed from: b, reason: collision with root package name */
    private final SparseArray<Rect> f3924b;

    /* renamed from: c, reason: collision with root package name */
    private final c.f.a.a.a f3925c;

    /* renamed from: d, reason: collision with root package name */
    private final c.f.a.d.b f3926d;

    /* renamed from: e, reason: collision with root package name */
    private final a f3927e;

    /* renamed from: f, reason: collision with root package name */
    private final c.f.a.c.a f3928f;

    /* renamed from: g, reason: collision with root package name */
    private final c.f.a.b.a f3929g;

    public c(b bVar) {
        this(bVar, new c.f.a.d.a(), new c.f.a.b.a());
    }

    private void a(Rect rect, View view, int i) {
        Rect a2 = this.f3929g.a(view);
        if (i == 1) {
            rect.top = view.getHeight() + a2.top + a2.bottom;
        } else {
            rect.left = view.getWidth() + a2.left + a2.right;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition != -1 && this.f3927e.a(childAdapterPosition)) {
            a(rect, a(recyclerView, childAdapterPosition), this.f3926d.a(recyclerView));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        boolean a2;
        super.onDrawOver(canvas, recyclerView, state);
        this.f3924b.clear();
        if (recyclerView.getChildCount() <= 0 || this.f3923a.getItemCount() <= 0) {
            return;
        }
        for (int i = 0; i < recyclerView.getChildCount(); i++) {
            View childAt = recyclerView.getChildAt(i);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
            if (childAdapterPosition != -1 && ((a2 = this.f3927e.a(childAt, this.f3926d.a(recyclerView), childAdapterPosition)) || this.f3927e.a(childAdapterPosition))) {
                View a3 = this.f3925c.a(recyclerView, childAdapterPosition);
                Rect a4 = this.f3927e.a(recyclerView, a3, childAt, a2);
                this.f3928f.a(recyclerView, canvas, a3, a4);
                this.f3924b.put(childAdapterPosition, a4);
            }
        }
    }

    private c(b bVar, c.f.a.d.b bVar2, c.f.a.b.a aVar) {
        this(bVar, bVar2, aVar, new c.f.a.c.a(bVar2), new c.f.a.a.b(bVar, bVar2));
    }

    private c(b bVar, c.f.a.d.b bVar2, c.f.a.b.a aVar, c.f.a.c.a aVar2, c.f.a.a.a aVar3) {
        this(bVar, aVar2, bVar2, aVar, aVar3, new a(bVar, aVar3, bVar2, aVar));
    }

    private c(b bVar, c.f.a.c.a aVar, c.f.a.d.b bVar2, c.f.a.b.a aVar2, c.f.a.a.a aVar3, a aVar4) {
        this.f3924b = new SparseArray<>();
        this.f3923a = bVar;
        this.f3925c = aVar3;
        this.f3926d = bVar2;
        this.f3928f = aVar;
        this.f3929g = aVar2;
        this.f3927e = aVar4;
    }

    public View a(RecyclerView recyclerView, int i) {
        return this.f3925c.a(recyclerView, i);
    }

    public void a() {
        this.f3925c.invalidate();
    }
}
