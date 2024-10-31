package com.nextreaming.nexeditorui.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.nexstreaming.app.general.util.o;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: NexPopupMenu.java */
/* loaded from: classes.dex */
public class a implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    private Context f4505a;
    private Menu b;
    private int c;
    private int d;
    private int e = 0;
    private LayoutInflater f;
    private View g;
    private ListView h;
    private ListAdapter i;
    private ViewGroup j;
    private PopupWindow k;
    private InterfaceC0083a l;

    /* compiled from: NexPopupMenu.java */
    /* renamed from: com.nextreaming.nexeditorui.a.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0083a {
        boolean a(MenuItem menuItem, int i);
    }

    public a(Context context, View view) {
        this.f4505a = context;
        this.g = view;
        this.b = new o(context);
        this.f = LayoutInflater.from(context);
        Resources resources = context.getResources();
        this.c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.popup_dimension_pixel_size));
        this.d = Math.max(resources.getDisplayMetrics().heightPixels / 2, resources.getDimensionPixelSize(R.dimen.popup_dimension_pixel_size));
        Log.d("bbong", "mPopupMaxWidth : " + this.c);
    }

    public Menu a() {
        return this.b;
    }

    public void a(int i) {
        new MenuInflater(this.f4505a).inflate(i, this.b);
    }

    public void a(InterfaceC0083a interfaceC0083a) {
        this.l = interfaceC0083a;
    }

    public ListView a(Context context) {
        this.h = new b(this, context, new Path());
        this.i = new c(context, this.b);
        this.h.setLayerType(1, null);
        this.h.setChoiceMode(1);
        this.h.setAdapter(this.i);
        this.h.setOnItemClickListener(this);
        return this.h;
    }

    public void b(int i) {
        if (this.h == null) {
            this.h = a(this.f4505a);
        }
        Log.d("bbong", "NexPopupMenu >> position : " + i);
        this.h.setItemChecked(i, true);
    }

    public void b() {
        if (this.h == null) {
            this.h = a(this.f4505a);
        }
        this.k = new PopupWindow(this.h, e(), f());
        this.k.setOutsideTouchable(false);
        this.k.setTouchable(true);
        this.k.setFocusable(true);
        this.k.setBackgroundDrawable(new BitmapDrawable(this.f4505a.getResources(), ""));
        this.k.showAsDropDown(this.g);
    }

    public void c() {
        if (this.k != null) {
            this.k.dismiss();
        }
    }

    public boolean d() {
        if (this.k != null) {
            return this.k.isShowing();
        }
        return false;
    }

    private int e() {
        View view;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = this.i.getCount();
        int i = 0;
        int i2 = 0;
        View view2 = null;
        int i3 = 0;
        while (i < count) {
            int itemViewType = this.i.getItemViewType(i);
            if (itemViewType != i2) {
                i2 = itemViewType;
                view = null;
            } else {
                view = view2;
            }
            if (this.j == null) {
                this.j = new FrameLayout(this.f4505a);
            }
            view2 = this.i.getView(i, view, this.j);
            view2.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view2.getMeasuredWidth();
            if (measuredWidth >= this.c) {
                return this.c;
            }
            if (measuredWidth <= i3) {
                measuredWidth = i3;
            }
            i++;
            i3 = measuredWidth;
        }
        return i3;
    }

    private int f() {
        View view;
        int i = 0;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = this.i.getCount();
        int i2 = 0;
        int i3 = 0;
        View view2 = null;
        while (i2 < count) {
            int itemViewType = this.i.getItemViewType(i2);
            if (itemViewType != i3) {
                view = null;
            } else {
                itemViewType = i3;
                view = view2;
            }
            if (this.j == null) {
                this.j = new FrameLayout(this.f4505a);
            }
            view2 = this.i.getView(i2, view, this.j);
            view2.measure(makeMeasureSpec, makeMeasureSpec2);
            this.e = this.h.getDividerHeight() * (this.h.getCount() - 1);
            int measuredHeight = view2.getMeasuredHeight();
            if (this.i.getCount() * measuredHeight >= this.d) {
                return this.d + this.e;
            }
            if (this.i.getCount() * measuredHeight > i) {
                i = (this.i.getCount() * measuredHeight) + this.e;
            }
            i2++;
            i3 = itemViewType;
        }
        return i;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        MenuItem menuItem = (MenuItem) this.i.getItem(i);
        if (this.l != null) {
            this.l.a(menuItem, i);
        }
        view.setActivated(true);
        view.setPressed(true);
        this.k.dismiss();
    }
}
