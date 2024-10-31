package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuPresenter;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.PopupWindow;

/* loaded from: classes.dex */
public class MenuPopupHelper implements MenuHelper {

    /* renamed from: a, reason: collision with root package name */
    private final Context f2503a;

    /* renamed from: b, reason: collision with root package name */
    private final MenuBuilder f2504b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f2505c;

    /* renamed from: d, reason: collision with root package name */
    private final int f2506d;

    /* renamed from: e, reason: collision with root package name */
    private final int f2507e;

    /* renamed from: f, reason: collision with root package name */
    private View f2508f;

    /* renamed from: g, reason: collision with root package name */
    private int f2509g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2510h;
    private MenuPresenter.Callback i;
    private MenuPopup j;
    private PopupWindow.OnDismissListener k;
    private final PopupWindow.OnDismissListener l;

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder) {
        this(context, menuBuilder, null, false, R.attr.popupMenuStyle, 0);
    }

    private void a(int i, int i2, boolean z, boolean z2) {
        MenuPopup popup = getPopup();
        popup.setShowTitle(z2);
        if (z) {
            if ((GravityCompat.getAbsoluteGravity(this.f2509g, ViewCompat.getLayoutDirection(this.f2508f)) & 7) == 5) {
                i += this.f2508f.getWidth();
            }
            popup.setHorizontalOffset(i);
            popup.setVerticalOffset(i2);
            int i3 = (int) ((this.f2503a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            popup.setEpicenterBounds(new Rect(i - i3, i2 - i3, i + i3, i2 + i3));
        }
        popup.show();
    }

    private MenuPopup b() {
        MenuPopup standardMenuPopup;
        Display defaultDisplay = ((WindowManager) this.f2503a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        if (Math.min(point.x, point.y) >= this.f2503a.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
            standardMenuPopup = new CascadingMenuPopup(this.f2503a, this.f2508f, this.f2506d, this.f2507e, this.f2505c);
        } else {
            standardMenuPopup = new StandardMenuPopup(this.f2503a, this.f2504b, this.f2508f, this.f2506d, this.f2507e, this.f2505c);
        }
        standardMenuPopup.addMenu(this.f2504b);
        standardMenuPopup.setOnDismissListener(this.l);
        standardMenuPopup.setAnchorView(this.f2508f);
        standardMenuPopup.setCallback(this.i);
        standardMenuPopup.setForceShowIcon(this.f2510h);
        standardMenuPopup.setGravity(this.f2509g);
        return standardMenuPopup;
    }

    @Override // android.support.v7.view.menu.MenuHelper
    public void dismiss() {
        if (isShowing()) {
            this.j.dismiss();
        }
    }

    public int getGravity() {
        return this.f2509g;
    }

    public ListView getListView() {
        return getPopup().getListView();
    }

    public MenuPopup getPopup() {
        if (this.j == null) {
            this.j = b();
        }
        return this.j;
    }

    public boolean isShowing() {
        MenuPopup menuPopup = this.j;
        return menuPopup != null && menuPopup.isShowing();
    }

    public void setAnchorView(View view) {
        this.f2508f = view;
    }

    public void setForceShowIcon(boolean z) {
        this.f2510h = z;
        MenuPopup menuPopup = this.j;
        if (menuPopup != null) {
            menuPopup.setForceShowIcon(z);
        }
    }

    public void setGravity(int i) {
        this.f2509g = i;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.k = onDismissListener;
    }

    @Override // android.support.v7.view.menu.MenuHelper
    public void setPresenterCallback(MenuPresenter.Callback callback) {
        this.i = callback;
        MenuPopup menuPopup = this.j;
        if (menuPopup != null) {
            menuPopup.setCallback(callback);
        }
    }

    public void show() {
        if (!tryShow()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean tryShow() {
        if (isShowing()) {
            return true;
        }
        if (this.f2508f == null) {
            return false;
        }
        a(0, 0, false, false);
        return true;
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view) {
        this(context, menuBuilder, view, false, R.attr.popupMenuStyle, 0);
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i) {
        this(context, menuBuilder, view, z, i, 0);
    }

    public void show(int i, int i2) {
        if (!tryShow(i, i2)) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i, int i2) {
        this.f2509g = GravityCompat.START;
        this.l = new PopupWindow.OnDismissListener() { // from class: android.support.v7.view.menu.MenuPopupHelper.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                MenuPopupHelper.this.a();
            }
        };
        this.f2503a = context;
        this.f2504b = menuBuilder;
        this.f2508f = view;
        this.f2505c = z;
        this.f2506d = i;
        this.f2507e = i2;
    }

    public boolean tryShow(int i, int i2) {
        if (isShowing()) {
            return true;
        }
        if (this.f2508f == null) {
            return false;
        }
        a(i, i2, true, true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        this.j = null;
        PopupWindow.OnDismissListener onDismissListener = this.k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }
}
