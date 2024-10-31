package com.nexstreaming.kinemaster.ui.mediabrowser;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import com.facebook.internal.ServerProtocol;

/* compiled from: GridAutoFitLayoutManager.kt */
/* loaded from: classes.dex */
public final class GridAutoFitLayoutManager extends GridLayoutManager {
    private int R;
    private boolean S;
    private boolean T;
    private int U;
    public static final a Q = new a(null);
    private static final int P = 200;

    /* compiled from: GridAutoFitLayoutManager.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridAutoFitLayoutManager(Context context, int i) {
        super(context, 1);
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        this.S = true;
        this.T = true;
        c(a(context, i));
    }

    private final int a(Context context, int i) {
        float applyDimension;
        if (i <= 0) {
            float f2 = P;
            Resources resources = context.getResources();
            kotlin.jvm.internal.h.a((Object) resources, "context.resources");
            applyDimension = TypedValue.applyDimension(1, f2, resources.getDisplayMetrics());
        } else {
            Resources resources2 = context.getResources();
            kotlin.jvm.internal.h.a((Object) resources2, "context.resources");
            applyDimension = TypedValue.applyDimension(1, i, resources2.getDisplayMetrics());
        }
        return (int) applyDimension;
    }

    private final void c(int i) {
        if (i <= 0 || i == this.R) {
            return;
        }
        this.R = i;
        this.S = true;
    }

    @Override // android.support.v7.widget.GridLayoutManager, android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int paddingTop;
        kotlin.jvm.internal.h.b(state, ServerProtocol.DIALOG_PARAM_STATE);
        int width = getWidth();
        int height = getHeight();
        if (width != this.U) {
            this.T = true;
            this.U = width;
        }
        if ((this.S && this.R > 0 && width > 0 && height > 0) || this.T) {
            if (getOrientation() == 1) {
                paddingTop = (width - getPaddingRight()) - getPaddingLeft();
            } else {
                paddingTop = (height - getPaddingTop()) - getPaddingBottom();
            }
            setSpanCount(Math.max(1, paddingTop / this.R));
            this.S = false;
            this.T = false;
        }
        super.onLayoutChildren(recycler, state);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridAutoFitLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, 1, i2, z);
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        this.S = true;
        this.T = true;
        c(a(context, i));
    }
}
