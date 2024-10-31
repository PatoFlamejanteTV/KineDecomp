package com.nexstreaming.kinemaster.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class PopoutBookmarkListMenu extends p {

    /* renamed from: f */
    private View f23794f;

    /* renamed from: g */
    private ListView f23795g;

    /* renamed from: h */
    private List<a> f23796h;
    private ArrowDirection i;
    private boolean j;
    b k;
    private BaseAdapter l;

    /* loaded from: classes2.dex */
    public enum ArrowDirection {
        LEFT,
        RIGHT_CENTER,
        RIGHT_TOP,
        HIDDEN
    }

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a */
        final int f23797a;

        /* renamed from: b */
        final String f23798b;

        /* renamed from: c */
        final Drawable f23799c;

        /* synthetic */ a(int i, String str, Drawable drawable, i iVar) {
            this(i, str, drawable);
        }

        private a(int i, String str, Drawable drawable) {
            this.f23797a = i;
            this.f23798b = str;
            this.f23799c = drawable;
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(PopoutBookmarkListMenu popoutBookmarkListMenu, int i);
    }

    public PopoutBookmarkListMenu(Context context, boolean z) {
        super(context);
        this.f23796h = new ArrayList();
        this.i = ArrowDirection.LEFT;
        this.j = false;
        this.l = new i(this);
        this.i = z ? ArrowDirection.HIDDEN : ArrowDirection.LEFT;
    }

    public void a(int i, int i2) {
        this.f23796h.add(new a(i, this.f23879c.getResources().getString(i2), null, null));
        this.l.notifyDataSetChanged();
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.p
    public void b() {
        this.f23794f = null;
        this.f23795g = null;
        this.k = null;
        super.b();
    }

    public void a(int i, String str) {
        this.f23796h.add(new a(i, str, null, null));
        this.l.notifyDataSetChanged();
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.p
    protected View a(Context context) {
        this.f23794f = LayoutInflater.from(context).inflate(R.layout.list_menu_popout, (ViewGroup) null, false);
        int i = k.f23872a[this.i.ordinal()];
        if (i != 1 && i == 2) {
            this.f23794f.setBackground(null);
        }
        this.f23795g = (ListView) this.f23794f.findViewById(R.id.listMenuContent);
        this.f23795g.setOnItemClickListener(new j(this));
        this.f23795g.setAdapter((ListAdapter) this.l);
        int dividerHeight = this.f23795g.getDividerHeight();
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.action_overflow_popout_max_height);
        View view = null;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.l.getCount(); i4++) {
            view = this.l.getView(i4, view, this.f23795g);
            view.measure(0, 0);
            int measuredHeight = view.getMeasuredHeight();
            int measuredWidth = view.getMeasuredWidth();
            int i5 = measuredHeight + i3;
            if (i5 <= dimensionPixelSize) {
                if (i4 > 0) {
                    i5 += dividerHeight;
                }
                i3 = i5;
            }
            i2 = Math.max(i2, measuredWidth);
        }
        this.f23795g.getLayoutParams().width = i2;
        this.f23795g.getLayoutParams().height = i3;
        return this.f23794f;
    }

    public void a(b bVar) {
        this.k = bVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.p
    public void a() {
        PopupWindow popupWindow = this.f23878b;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }
}
