package android.support.v7.internal.view.menu;

import android.R;
import android.content.Context;
import android.support.v7.internal.view.menu.e;
import android.support.v7.internal.widget.ac;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements e.b, l, AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f128a = {R.attr.background, R.attr.divider};
    private e b;
    private int c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        ac a2 = ac.a(context, attributeSet, f128a, i, 0);
        if (a2.d(0)) {
            setBackgroundDrawable(a2.a(0));
        }
        if (a2.d(1)) {
            setDivider(a2.a(1));
        }
        a2.b();
    }

    @Override // android.support.v7.internal.view.menu.l
    public void a(e eVar) {
        this.b = eVar;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.support.v7.internal.view.menu.e.b
    public boolean a(f fVar) {
        return this.b.a(fVar, 0);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        a((f) getAdapter().getItem(i));
    }

    public int getWindowAnimations() {
        return this.c;
    }
}
