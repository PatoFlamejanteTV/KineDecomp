package c.f.a.c;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import c.f.a.d.b;

/* compiled from: HeaderRenderer.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final c.f.a.b.a f3930a;

    /* renamed from: b, reason: collision with root package name */
    private final b f3931b;

    public a(b bVar) {
        this(bVar, new c.f.a.b.a());
    }

    public void a(RecyclerView recyclerView, Canvas canvas, View view, Rect rect) {
        canvas.save();
        if (recyclerView.getLayoutManager().getClipToPadding()) {
            canvas.clipRect(a(recyclerView, view));
        }
        canvas.translate(rect.left, rect.top);
        view.draw(canvas);
        canvas.restore();
    }

    private a(b bVar, c.f.a.b.a aVar) {
        this.f3931b = bVar;
        this.f3930a = aVar;
    }

    private Rect a(RecyclerView recyclerView, View view) {
        Rect a2 = this.f3930a.a(view);
        if (this.f3931b.a(recyclerView) == 1) {
            return new Rect(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), (recyclerView.getWidth() - recyclerView.getPaddingRight()) - a2.right, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        }
        return new Rect(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getWidth() - recyclerView.getPaddingRight(), (recyclerView.getHeight() - recyclerView.getPaddingBottom()) - a2.bottom);
    }
}
