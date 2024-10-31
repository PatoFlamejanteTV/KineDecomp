package com.nextreaming.nexeditorui.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.nexstreaming.app.general.util.w;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: NexPopupMenu.java */
/* loaded from: classes.dex */
public class b implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    private Context f24202a;

    /* renamed from: b */
    private Menu f24203b;

    /* renamed from: c */
    private int f24204c;

    /* renamed from: d */
    private int f24205d;

    /* renamed from: f */
    private int f24207f;

    /* renamed from: g */
    private LayoutInflater f24208g;

    /* renamed from: h */
    private View f24209h;
    private ListView i;
    private ListAdapter j;
    private ViewGroup k;
    private PopupWindow l;
    private a n;

    /* renamed from: e */
    private int f24206e = 0;
    private int m = -1;

    /* compiled from: NexPopupMenu.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(MenuItem menuItem, int i);
    }

    public b(Context context, View view) {
        this.f24202a = context;
        this.f24209h = view;
        this.f24203b = new w(context);
        this.f24208g = LayoutInflater.from(context);
        Resources resources = context.getResources();
        this.f24204c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.popup_dimension_pixel_size));
        this.f24205d = Math.max(resources.getDisplayMetrics().heightPixels / 2, resources.getDimensionPixelSize(R.dimen.popup_dimension_pixel_size));
        Log.d("bbong", "mPopupMaxWidth : " + this.f24204c);
        this.f24207f = (int) TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics());
    }

    private int e() {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = this.j.getCount();
        if (this.k == null) {
            this.k = new FrameLayout(this.f24202a);
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < count; i3++) {
            int itemViewType = this.j.getItemViewType(i3);
            if (itemViewType != i2) {
                i2 = itemViewType;
            }
            View view = this.j.getView(i3, null, this.k);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i += view.getMeasuredHeight();
        }
        this.f24206e = this.i.getDividerHeight() * (count - 1);
        int i4 = this.f24206e;
        int i5 = i + i4;
        int i6 = this.f24205d;
        return i5 > i6 ? i6 + i4 : i5;
    }

    private int f() {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = this.j.getCount();
        View view = null;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < count; i3++) {
            int itemViewType = this.j.getItemViewType(i3);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            if (this.k == null) {
                this.k = new FrameLayout(this.f24202a);
            }
            view = this.j.getView(i3, view, this.k);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            int i4 = this.f24204c;
            if (measuredWidth >= i4) {
                return i4 + this.f24207f;
            }
            if (measuredWidth > i) {
                i = measuredWidth;
            }
        }
        return i + this.f24207f;
    }

    public void a(int i) {
        new MenuInflater(this.f24202a).inflate(i, this.f24203b);
    }

    public Menu b() {
        return this.f24203b;
    }

    public boolean c() {
        PopupWindow popupWindow = this.l;
        if (popupWindow != null) {
            return popupWindow.isShowing();
        }
        return false;
    }

    public void d() {
        this.i = a(this.f24202a);
        int i = this.m;
        if (i != -1) {
            this.i.setItemChecked(i, true);
        }
        LinearLayout linearLayout = new LinearLayout(this.f24202a);
        linearLayout.addView(this.i, -1, -2);
        int i2 = this.f24207f;
        linearLayout.setPadding(i2 / 2, 0, i2 / 2, 0);
        linearLayout.setClipToPadding(false);
        this.l = new PopupWindow(linearLayout, f(), e());
        this.l.setOutsideTouchable(false);
        this.l.setTouchable(true);
        this.l.setFocusable(true);
        this.l.setBackgroundDrawable(new BitmapDrawable(this.f24202a.getResources(), ""));
        this.l.showAsDropDown(this.f24209h);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        MenuItem menuItem = (MenuItem) this.j.getItem(i);
        a aVar = this.n;
        if (aVar != null) {
            aVar.a(menuItem, i);
        }
        view.setActivated(true);
        view.setPressed(true);
        this.l.dismiss();
    }

    public void a(a aVar) {
        this.n = aVar;
    }

    public void b(int i) {
        Log.d("bbong", "NexPopupMenu >> position : " + i);
        ListView listView = this.i;
        if (listView != null) {
            listView.setItemChecked(i, true);
        }
        this.m = i;
    }

    public ListView a(Context context) {
        this.i = new com.nextreaming.nexeditorui.a.a.a(this, context, new Path());
        this.j = new c(context, this.f24203b);
        this.i.setLayerType(1, null);
        this.i.setChoiceMode(1);
        this.i.setAdapter(this.j);
        this.i.setOnItemClickListener(this);
        return this.i;
    }

    public void a() {
        PopupWindow popupWindow = this.l;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }
}
