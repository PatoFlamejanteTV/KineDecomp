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
public class PopoutListMenu extends p {

    /* renamed from: f */
    private View f23800f;

    /* renamed from: g */
    private ListView f23801g;

    /* renamed from: h */
    private List<a> f23802h;
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
        final int f23803a;

        /* renamed from: b */
        final String f23804b;

        /* renamed from: c */
        final Drawable f23805c;

        /* synthetic */ a(int i, String str, Drawable drawable, l lVar) {
            this(i, str, drawable);
        }

        private a(int i, String str, Drawable drawable) {
            this.f23803a = i;
            this.f23804b = str;
            this.f23805c = drawable;
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(PopoutListMenu popoutListMenu, int i);
    }

    public PopoutListMenu(Context context) {
        super(context);
        this.f23802h = new ArrayList();
        this.i = ArrowDirection.LEFT;
        this.j = false;
        this.l = new l(this);
    }

    public void a(int i, int i2, int i3) {
        this.f23802h.add(new a(i, this.f23879c.getResources().getString(i2), i3 == 0 ? null : this.f23879c.getResources().getDrawable(i3), null));
        this.l.notifyDataSetChanged();
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.p
    public void b() {
        this.f23800f = null;
        this.f23801g = null;
        this.k = null;
        super.b();
    }

    public void a(int i, int i2) {
        this.f23802h.add(new a(i, this.f23879c.getResources().getString(i2), null, null));
        this.l.notifyDataSetChanged();
    }

    public PopoutListMenu(Context context, ArrowDirection arrowDirection) {
        super(context);
        this.f23802h = new ArrayList();
        this.i = ArrowDirection.LEFT;
        this.j = false;
        this.l = new l(this);
        this.i = arrowDirection;
    }

    public void a(int i, String str) {
        this.f23802h.add(new a(i, str, null, null));
        this.l.notifyDataSetChanged();
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.p
    protected View a(Context context) {
        this.f23800f = LayoutInflater.from(context).inflate(R.layout.list_menu_popout, (ViewGroup) null, false);
        int i = n.f23875a[this.i.ordinal()];
        if (i != 1 && i == 2) {
            this.f23800f.setBackground(null);
        }
        this.f23801g = (ListView) this.f23800f.findViewById(R.id.listMenuContent);
        this.f23801g.setOnItemClickListener(new m(this));
        this.f23801g.setAdapter((ListAdapter) this.l);
        int dividerHeight = this.f23801g.getDividerHeight();
        context.getResources().getDimensionPixelSize(R.dimen.action_overflow_popout_max_height);
        View view = null;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.l.getCount(); i4++) {
            view = this.l.getView(i4, view, this.f23801g);
            view.measure(0, 0);
            i2 += view.getMeasuredHeight() + dividerHeight;
            i3 = Math.max(i3, view.getMeasuredWidth());
        }
        this.f23801g.getLayoutParams().width = i3;
        this.f23801g.getLayoutParams().height = i2 - dividerHeight;
        return this.f23800f;
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
