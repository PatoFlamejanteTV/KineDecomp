package com.nexstreaming.kinemaster.ui.projectgallery;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.facebook.internal.ServerProtocol;

/* compiled from: ProjectGalleryDividerItemDecoration.kt */
/* loaded from: classes2.dex */
public final class Jb extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    private final int f22845a;

    /* renamed from: b, reason: collision with root package name */
    private final int f22846b;

    /* renamed from: c, reason: collision with root package name */
    private final int f22847c;

    /* renamed from: d, reason: collision with root package name */
    private final int f22848d;

    /* renamed from: e, reason: collision with root package name */
    private final int f22849e;

    /* renamed from: f, reason: collision with root package name */
    private final int f22850f;

    /* renamed from: g, reason: collision with root package name */
    private final int f22851g;

    public Jb(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f22845a = i;
        this.f22846b = i2;
        this.f22847c = i3;
        this.f22848d = i4;
        this.f22849e = i5;
        this.f22850f = i6;
        this.f22851g = i7;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        kotlin.jvm.internal.h.b(rect, "outRect");
        kotlin.jvm.internal.h.b(view, "view");
        kotlin.jvm.internal.h.b(recyclerView, "parent");
        kotlin.jvm.internal.h.b(state, ServerProtocol.DIALOG_PARAM_STATE);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i = this.f22845a;
        int i2 = (((childAdapterPosition % i) + 1) * ((this.f22847c - (this.f22846b * i)) / i)) / i;
        int i3 = this.f22848d;
        rect.left = i3;
        rect.right = i2 - i3;
        if (childAdapterPosition < i) {
            rect.top = this.f22849e;
        }
        rect.bottom = this.f22851g;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            double itemCount = adapter.getItemCount();
            double d2 = this.f22845a;
            Double.isNaN(itemCount);
            Double.isNaN(d2);
            if (childAdapterPosition / this.f22845a == ((int) Math.ceil(itemCount / d2)) - 1) {
                rect.bottom = this.f22850f;
                return;
            }
            return;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }
}
