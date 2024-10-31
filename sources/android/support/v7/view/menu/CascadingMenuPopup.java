package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.widget.MenuItemHoverListener;
import android.support.v7.widget.MenuPopupWindow;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
final class CascadingMenuPopup extends MenuPopup implements MenuPresenter, View.OnKeyListener, PopupWindow.OnDismissListener {
    boolean A;

    /* renamed from: b, reason: collision with root package name */
    private final Context f2432b;

    /* renamed from: c, reason: collision with root package name */
    private final int f2433c;

    /* renamed from: d, reason: collision with root package name */
    private final int f2434d;

    /* renamed from: e, reason: collision with root package name */
    private final int f2435e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f2436f;

    /* renamed from: g, reason: collision with root package name */
    final Handler f2437g;
    private View o;
    View p;
    private boolean r;
    private boolean s;
    private int t;
    private int u;
    private boolean w;
    private MenuPresenter.Callback x;
    private ViewTreeObserver y;
    private PopupWindow.OnDismissListener z;

    /* renamed from: h, reason: collision with root package name */
    private final List<MenuBuilder> f2438h = new ArrayList();
    final List<CascadingMenuInfo> i = new ArrayList();
    private final ViewTreeObserver.OnGlobalLayoutListener j = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.view.menu.CascadingMenuPopup.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!CascadingMenuPopup.this.isShowing() || CascadingMenuPopup.this.i.size() <= 0 || CascadingMenuPopup.this.i.get(0).window.isModal()) {
                return;
            }
            View view = CascadingMenuPopup.this.p;
            if (view != null && view.isShown()) {
                Iterator<CascadingMenuInfo> it = CascadingMenuPopup.this.i.iterator();
                while (it.hasNext()) {
                    it.next().window.show();
                }
                return;
            }
            CascadingMenuPopup.this.dismiss();
        }
    };
    private final View.OnAttachStateChangeListener k = new View.OnAttachStateChangeListener() { // from class: android.support.v7.view.menu.CascadingMenuPopup.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (CascadingMenuPopup.this.y != null) {
                if (!CascadingMenuPopup.this.y.isAlive()) {
                    CascadingMenuPopup.this.y = view.getViewTreeObserver();
                }
                CascadingMenuPopup.this.y.removeGlobalOnLayoutListener(CascadingMenuPopup.this.j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private final MenuItemHoverListener l = new MenuItemHoverListener() { // from class: android.support.v7.view.menu.CascadingMenuPopup.3
        @Override // android.support.v7.widget.MenuItemHoverListener
        public void onItemHoverEnter(final MenuBuilder menuBuilder, final MenuItem menuItem) {
            CascadingMenuPopup.this.f2437g.removeCallbacksAndMessages(null);
            int size = CascadingMenuPopup.this.i.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (menuBuilder == CascadingMenuPopup.this.i.get(i).menu) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                return;
            }
            int i2 = i + 1;
            final CascadingMenuInfo cascadingMenuInfo = i2 < CascadingMenuPopup.this.i.size() ? CascadingMenuPopup.this.i.get(i2) : null;
            CascadingMenuPopup.this.f2437g.postAtTime(new Runnable() { // from class: android.support.v7.view.menu.CascadingMenuPopup.3.1
                @Override // java.lang.Runnable
                public void run() {
                    CascadingMenuInfo cascadingMenuInfo2 = cascadingMenuInfo;
                    if (cascadingMenuInfo2 != null) {
                        CascadingMenuPopup.this.A = true;
                        cascadingMenuInfo2.menu.close(false);
                        CascadingMenuPopup.this.A = false;
                    }
                    if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                        menuBuilder.performItemAction(menuItem, 4);
                    }
                }
            }, menuBuilder, SystemClock.uptimeMillis() + 200);
        }

        @Override // android.support.v7.widget.MenuItemHoverListener
        public void onItemHoverExit(MenuBuilder menuBuilder, MenuItem menuItem) {
            CascadingMenuPopup.this.f2437g.removeCallbacksAndMessages(menuBuilder);
        }
    };
    private int m = 0;
    private int n = 0;
    private boolean v = false;
    private int q = c();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class CascadingMenuInfo {
        public final MenuBuilder menu;
        public final int position;
        public final MenuPopupWindow window;

        public CascadingMenuInfo(MenuPopupWindow menuPopupWindow, MenuBuilder menuBuilder, int i) {
            this.window = menuPopupWindow;
            this.menu = menuBuilder;
            this.position = i;
        }

        public ListView getListView() {
            return this.window.getListView();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface HorizPosition {
    }

    public CascadingMenuPopup(Context context, View view, int i, int i2, boolean z) {
        this.f2432b = context;
        this.o = view;
        this.f2434d = i;
        this.f2435e = i2;
        this.f2436f = z;
        Resources resources = context.getResources();
        this.f2433c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f2437g = new Handler();
    }

    private int c() {
        return ViewCompat.getLayoutDirection(this.o) == 1 ? 0 : 1;
    }

    @Override // android.support.v7.view.menu.MenuPopup
    protected boolean a() {
        return false;
    }

    @Override // android.support.v7.view.menu.MenuPopup
    public void addMenu(MenuBuilder menuBuilder) {
        menuBuilder.addMenuPresenter(this, this.f2432b);
        if (isShowing()) {
            c(menuBuilder);
        } else {
            this.f2438h.add(menuBuilder);
        }
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    public void dismiss() {
        int size = this.i.size();
        if (size > 0) {
            CascadingMenuInfo[] cascadingMenuInfoArr = (CascadingMenuInfo[]) this.i.toArray(new CascadingMenuInfo[size]);
            for (int i = size - 1; i >= 0; i--) {
                CascadingMenuInfo cascadingMenuInfo = cascadingMenuInfoArr[i];
                if (cascadingMenuInfo.window.isShowing()) {
                    cascadingMenuInfo.window.dismiss();
                }
            }
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    public ListView getListView() {
        if (this.i.isEmpty()) {
            return null;
        }
        return this.i.get(r0.size() - 1).getListView();
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    public boolean isShowing() {
        return this.i.size() > 0 && this.i.get(0).window.isShowing();
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        int b2 = b(menuBuilder);
        if (b2 < 0) {
            return;
        }
        int i = b2 + 1;
        if (i < this.i.size()) {
            this.i.get(i).menu.close(false);
        }
        CascadingMenuInfo remove = this.i.remove(b2);
        remove.menu.removeMenuPresenter(this);
        if (this.A) {
            remove.window.setExitTransition(null);
            remove.window.setAnimationStyle(0);
        }
        remove.window.dismiss();
        int size = this.i.size();
        if (size > 0) {
            this.q = this.i.get(size - 1).position;
        } else {
            this.q = c();
        }
        if (size != 0) {
            if (z) {
                this.i.get(0).menu.close(false);
                return;
            }
            return;
        }
        dismiss();
        MenuPresenter.Callback callback = this.x;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, true);
        }
        ViewTreeObserver viewTreeObserver = this.y;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.y.removeGlobalOnLayoutListener(this.j);
            }
            this.y = null;
        }
        this.p.removeOnAttachStateChangeListener(this.k);
        this.z.onDismiss();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        CascadingMenuInfo cascadingMenuInfo;
        int size = this.i.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                cascadingMenuInfo = null;
                break;
            }
            cascadingMenuInfo = this.i.get(i);
            if (!cascadingMenuInfo.window.isShowing()) {
                break;
            } else {
                i++;
            }
        }
        if (cascadingMenuInfo != null) {
            cascadingMenuInfo.menu.close(false);
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
        for (CascadingMenuInfo cascadingMenuInfo : this.i) {
            if (subMenuBuilder == cascadingMenuInfo.menu) {
                cascadingMenuInfo.getListView().requestFocus();
                return true;
            }
        }
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        addMenu(subMenuBuilder);
        MenuPresenter.Callback callback = this.x;
        if (callback != null) {
            callback.onOpenSubMenu(subMenuBuilder);
        }
        return true;
    }

    @Override // android.support.v7.view.menu.MenuPopup
    public void setAnchorView(View view) {
        if (this.o != view) {
            this.o = view;
            this.n = GravityCompat.getAbsoluteGravity(this.m, ViewCompat.getLayoutDirection(this.o));
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        this.x = callback;
    }

    @Override // android.support.v7.view.menu.MenuPopup
    public void setForceShowIcon(boolean z) {
        this.v = z;
    }

    @Override // android.support.v7.view.menu.MenuPopup
    public void setGravity(int i) {
        if (this.m != i) {
            this.m = i;
            this.n = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this.o));
        }
    }

    @Override // android.support.v7.view.menu.MenuPopup
    public void setHorizontalOffset(int i) {
        this.r = true;
        this.t = i;
    }

    @Override // android.support.v7.view.menu.MenuPopup
    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.z = onDismissListener;
    }

    @Override // android.support.v7.view.menu.MenuPopup
    public void setShowTitle(boolean z) {
        this.w = z;
    }

    @Override // android.support.v7.view.menu.MenuPopup
    public void setVerticalOffset(int i) {
        this.s = true;
        this.u = i;
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    public void show() {
        if (isShowing()) {
            return;
        }
        Iterator<MenuBuilder> it = this.f2438h.iterator();
        while (it.hasNext()) {
            c(it.next());
        }
        this.f2438h.clear();
        this.p = this.o;
        if (this.p != null) {
            boolean z = this.y == null;
            this.y = this.p.getViewTreeObserver();
            if (z) {
                this.y.addOnGlobalLayoutListener(this.j);
            }
            this.p.addOnAttachStateChangeListener(this.k);
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        Iterator<CascadingMenuInfo> it = this.i.iterator();
        while (it.hasNext()) {
            MenuPopup.a(it.next().getListView().getAdapter()).notifyDataSetChanged();
        }
    }

    private MenuPopupWindow b() {
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.f2432b, null, this.f2434d, this.f2435e);
        menuPopupWindow.setHoverListener(this.l);
        menuPopupWindow.setOnItemClickListener(this);
        menuPopupWindow.setOnDismissListener(this);
        menuPopupWindow.setAnchorView(this.o);
        menuPopupWindow.setDropDownGravity(this.n);
        menuPopupWindow.setModal(true);
        menuPopupWindow.setInputMethodMode(2);
        return menuPopupWindow;
    }

    private void c(MenuBuilder menuBuilder) {
        CascadingMenuInfo cascadingMenuInfo;
        View view;
        int i;
        int i2;
        int i3;
        LayoutInflater from = LayoutInflater.from(this.f2432b);
        MenuAdapter menuAdapter = new MenuAdapter(menuBuilder, from, this.f2436f);
        if (!isShowing() && this.v) {
            menuAdapter.setForceShowIcon(true);
        } else if (isShowing()) {
            menuAdapter.setForceShowIcon(MenuPopup.a(menuBuilder));
        }
        int a2 = MenuPopup.a(menuAdapter, null, this.f2432b, this.f2433c);
        MenuPopupWindow b2 = b();
        b2.setAdapter(menuAdapter);
        b2.setContentWidth(a2);
        b2.setDropDownGravity(this.n);
        if (this.i.size() > 0) {
            List<CascadingMenuInfo> list = this.i;
            cascadingMenuInfo = list.get(list.size() - 1);
            view = a(cascadingMenuInfo, menuBuilder);
        } else {
            cascadingMenuInfo = null;
            view = null;
        }
        if (view != null) {
            b2.setTouchModal(false);
            b2.setEnterTransition(null);
            int a3 = a(a2);
            boolean z = a3 == 1;
            this.q = a3;
            if (Build.VERSION.SDK_INT >= 26) {
                b2.setAnchorView(view);
                i2 = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.o.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.n & 7) == 5) {
                    iArr[0] = iArr[0] + this.o.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i = iArr2[0] - iArr[0];
                i2 = iArr2[1] - iArr[1];
            }
            if ((this.n & 5) == 5) {
                if (!z) {
                    a2 = view.getWidth();
                    i3 = i - a2;
                }
                i3 = i + a2;
            } else {
                if (z) {
                    a2 = view.getWidth();
                    i3 = i + a2;
                }
                i3 = i - a2;
            }
            b2.setHorizontalOffset(i3);
            b2.setOverlapAnchor(true);
            b2.setVerticalOffset(i2);
        } else {
            if (this.r) {
                b2.setHorizontalOffset(this.t);
            }
            if (this.s) {
                b2.setVerticalOffset(this.u);
            }
            b2.setEpicenterBounds(getEpicenterBounds());
        }
        this.i.add(new CascadingMenuInfo(b2, menuBuilder, this.q));
        b2.show();
        ListView listView = b2.getListView();
        listView.setOnKeyListener(this);
        if (cascadingMenuInfo == null && this.w && menuBuilder.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) listView, false);
            TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(menuBuilder.getHeaderTitle());
            listView.addHeaderView(frameLayout, null, false);
            b2.show();
        }
    }

    private int a(int i) {
        List<CascadingMenuInfo> list = this.i;
        ListView listView = list.get(list.size() - 1).getListView();
        int[] iArr = new int[2];
        listView.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.p.getWindowVisibleDisplayFrame(rect);
        return this.q == 1 ? (iArr[0] + listView.getWidth()) + i > rect.right ? 0 : 1 : iArr[0] - i < 0 ? 1 : 0;
    }

    private int b(MenuBuilder menuBuilder) {
        int size = this.i.size();
        for (int i = 0; i < size; i++) {
            if (menuBuilder == this.i.get(i).menu) {
                return i;
            }
        }
        return -1;
    }

    private MenuItem a(MenuBuilder menuBuilder, MenuBuilder menuBuilder2) {
        int size = menuBuilder.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = menuBuilder.getItem(i);
            if (item.hasSubMenu() && menuBuilder2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View a(CascadingMenuInfo cascadingMenuInfo, MenuBuilder menuBuilder) {
        MenuAdapter menuAdapter;
        int i;
        int firstVisiblePosition;
        MenuItem a2 = a(cascadingMenuInfo.menu, menuBuilder);
        if (a2 == null) {
            return null;
        }
        ListView listView = cascadingMenuInfo.getListView();
        ListAdapter adapter = listView.getAdapter();
        int i2 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i = headerViewListAdapter.getHeadersCount();
            menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
        } else {
            menuAdapter = (MenuAdapter) adapter;
            i = 0;
        }
        int count = menuAdapter.getCount();
        while (true) {
            if (i2 >= count) {
                i2 = -1;
                break;
            }
            if (a2 == menuAdapter.getItem(i2)) {
                break;
            }
            i2++;
        }
        if (i2 != -1 && (firstVisiblePosition = (i2 + i) - listView.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listView.getChildCount()) {
            return listView.getChildAt(firstVisiblePosition);
        }
        return null;
    }
}
