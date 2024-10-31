package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.widget.MenuPopupWindow;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

/* loaded from: classes.dex */
final class StandardMenuPopup extends MenuPopup implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, MenuPresenter, View.OnKeyListener {

    /* renamed from: b, reason: collision with root package name */
    private final Context f2512b;

    /* renamed from: c, reason: collision with root package name */
    private final MenuBuilder f2513c;

    /* renamed from: d, reason: collision with root package name */
    private final MenuAdapter f2514d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f2515e;

    /* renamed from: f, reason: collision with root package name */
    private final int f2516f;

    /* renamed from: g, reason: collision with root package name */
    private final int f2517g;

    /* renamed from: h, reason: collision with root package name */
    private final int f2518h;
    final MenuPopupWindow i;
    private PopupWindow.OnDismissListener l;
    private View m;
    View n;
    private MenuPresenter.Callback o;
    private ViewTreeObserver p;
    private boolean q;
    private boolean r;
    private int s;
    private boolean u;
    private final ViewTreeObserver.OnGlobalLayoutListener j = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.view.menu.StandardMenuPopup.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!StandardMenuPopup.this.isShowing() || StandardMenuPopup.this.i.isModal()) {
                return;
            }
            View view = StandardMenuPopup.this.n;
            if (view != null && view.isShown()) {
                StandardMenuPopup.this.i.show();
            } else {
                StandardMenuPopup.this.dismiss();
            }
        }
    };
    private final View.OnAttachStateChangeListener k = new View.OnAttachStateChangeListener() { // from class: android.support.v7.view.menu.StandardMenuPopup.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (StandardMenuPopup.this.p != null) {
                if (!StandardMenuPopup.this.p.isAlive()) {
                    StandardMenuPopup.this.p = view.getViewTreeObserver();
                }
                StandardMenuPopup.this.p.removeGlobalOnLayoutListener(StandardMenuPopup.this.j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private int t = 0;

    public StandardMenuPopup(Context context, MenuBuilder menuBuilder, View view, int i, int i2, boolean z) {
        this.f2512b = context;
        this.f2513c = menuBuilder;
        this.f2515e = z;
        this.f2514d = new MenuAdapter(menuBuilder, LayoutInflater.from(context), this.f2515e);
        this.f2517g = i;
        this.f2518h = i2;
        Resources resources = context.getResources();
        this.f2516f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.m = view;
        this.i = new MenuPopupWindow(this.f2512b, null, this.f2517g, this.f2518h);
        menuBuilder.addMenuPresenter(this, context);
    }

    @Override // android.support.v7.view.menu.MenuPopup
    public void addMenu(MenuBuilder menuBuilder) {
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    public void dismiss() {
        if (isShowing()) {
            this.i.dismiss();
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    public ListView getListView() {
        return this.i.getListView();
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    public boolean isShowing() {
        return !this.q && this.i.isShowing();
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder != this.f2513c) {
            return;
        }
        dismiss();
        MenuPresenter.Callback callback = this.o;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.q = true;
        this.f2513c.close();
        ViewTreeObserver viewTreeObserver = this.p;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.p = this.n.getViewTreeObserver();
            }
            this.p.removeGlobalOnLayoutListener(this.j);
            this.p = null;
        }
        this.n.removeOnAttachStateChangeListener(this.k);
        PopupWindow.OnDismissListener onDismissListener = this.l;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        return null;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (subMenuBuilder.hasVisibleItems()) {
            MenuPopupHelper menuPopupHelper = new MenuPopupHelper(this.f2512b, subMenuBuilder, this.n, this.f2515e, this.f2517g, this.f2518h);
            menuPopupHelper.setPresenterCallback(this.o);
            menuPopupHelper.setForceShowIcon(MenuPopup.a(subMenuBuilder));
            menuPopupHelper.setGravity(this.t);
            menuPopupHelper.setOnDismissListener(this.l);
            this.l = null;
            this.f2513c.close(false);
            if (menuPopupHelper.tryShow(this.i.getHorizontalOffset(), this.i.getVerticalOffset())) {
                MenuPresenter.Callback callback = this.o;
                if (callback == null) {
                    return true;
                }
                callback.onOpenSubMenu(subMenuBuilder);
                return true;
            }
        }
        return false;
    }

    @Override // android.support.v7.view.menu.MenuPopup
    public void setAnchorView(View view) {
        this.m = view;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        this.o = callback;
    }

    @Override // android.support.v7.view.menu.MenuPopup
    public void setForceShowIcon(boolean z) {
        this.f2514d.setForceShowIcon(z);
    }

    @Override // android.support.v7.view.menu.MenuPopup
    public void setGravity(int i) {
        this.t = i;
    }

    @Override // android.support.v7.view.menu.MenuPopup
    public void setHorizontalOffset(int i) {
        this.i.setHorizontalOffset(i);
    }

    @Override // android.support.v7.view.menu.MenuPopup
    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.l = onDismissListener;
    }

    @Override // android.support.v7.view.menu.MenuPopup
    public void setShowTitle(boolean z) {
        this.u = z;
    }

    @Override // android.support.v7.view.menu.MenuPopup
    public void setVerticalOffset(int i) {
        this.i.setVerticalOffset(i);
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    public void show() {
        if (!b()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        this.r = false;
        MenuAdapter menuAdapter = this.f2514d;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }

    private boolean b() {
        View view;
        if (isShowing()) {
            return true;
        }
        if (this.q || (view = this.m) == null) {
            return false;
        }
        this.n = view;
        this.i.setOnDismissListener(this);
        this.i.setOnItemClickListener(this);
        this.i.setModal(true);
        View view2 = this.n;
        boolean z = this.p == null;
        this.p = view2.getViewTreeObserver();
        if (z) {
            this.p.addOnGlobalLayoutListener(this.j);
        }
        view2.addOnAttachStateChangeListener(this.k);
        this.i.setAnchorView(view2);
        this.i.setDropDownGravity(this.t);
        if (!this.r) {
            this.s = MenuPopup.a(this.f2514d, null, this.f2512b, this.f2516f);
            this.r = true;
        }
        this.i.setContentWidth(this.s);
        this.i.setInputMethodMode(2);
        this.i.setEpicenterBounds(getEpicenterBounds());
        this.i.show();
        ListView listView = this.i.getListView();
        listView.setOnKeyListener(this);
        if (this.u && this.f2513c.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f2512b).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) listView, false);
            TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
            if (textView != null) {
                textView.setText(this.f2513c.getHeaderTitle());
            }
            frameLayout.setEnabled(false);
            listView.addHeaderView(frameLayout, null, false);
        }
        this.i.setAdapter(this.f2514d);
        this.i.show();
        return true;
    }
}
