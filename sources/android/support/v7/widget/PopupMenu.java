package android.support.v7.widget;

import android.content.Context;
import android.support.v7.appcompat.R;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.ShowableListMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;

/* loaded from: classes.dex */
public class PopupMenu {

    /* renamed from: a, reason: collision with root package name */
    private final Context f2863a;

    /* renamed from: b, reason: collision with root package name */
    private final MenuBuilder f2864b;

    /* renamed from: c, reason: collision with root package name */
    private final View f2865c;

    /* renamed from: d, reason: collision with root package name */
    final MenuPopupHelper f2866d;

    /* renamed from: e, reason: collision with root package name */
    OnMenuItemClickListener f2867e;

    /* renamed from: f, reason: collision with root package name */
    OnDismissListener f2868f;

    /* renamed from: g, reason: collision with root package name */
    private View.OnTouchListener f2869g;

    /* loaded from: classes.dex */
    public interface OnDismissListener {
        void onDismiss(PopupMenu popupMenu);
    }

    /* loaded from: classes.dex */
    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public PopupMenu(Context context, View view) {
        this(context, view, 0);
    }

    public void dismiss() {
        this.f2866d.dismiss();
    }

    public View.OnTouchListener getDragToOpenListener() {
        if (this.f2869g == null) {
            this.f2869g = new ForwardingListener(this.f2865c) { // from class: android.support.v7.widget.PopupMenu.3
                @Override // android.support.v7.widget.ForwardingListener
                public ShowableListMenu getPopup() {
                    return PopupMenu.this.f2866d.getPopup();
                }

                @Override // android.support.v7.widget.ForwardingListener
                protected boolean onForwardingStarted() {
                    PopupMenu.this.show();
                    return true;
                }

                @Override // android.support.v7.widget.ForwardingListener
                protected boolean onForwardingStopped() {
                    PopupMenu.this.dismiss();
                    return true;
                }
            };
        }
        return this.f2869g;
    }

    public int getGravity() {
        return this.f2866d.getGravity();
    }

    public Menu getMenu() {
        return this.f2864b;
    }

    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.f2863a);
    }

    public void inflate(int i) {
        getMenuInflater().inflate(i, this.f2864b);
    }

    public void setGravity(int i) {
        this.f2866d.setGravity(i);
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f2868f = onDismissListener;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f2867e = onMenuItemClickListener;
    }

    public void show() {
        this.f2866d.show();
    }

    public PopupMenu(Context context, View view, int i) {
        this(context, view, i, R.attr.popupMenuStyle, 0);
    }

    public PopupMenu(Context context, View view, int i, int i2, int i3) {
        this.f2863a = context;
        this.f2865c = view;
        this.f2864b = new MenuBuilder(context);
        this.f2864b.setCallback(new MenuBuilder.Callback() { // from class: android.support.v7.widget.PopupMenu.1
            @Override // android.support.v7.view.menu.MenuBuilder.Callback
            public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
                OnMenuItemClickListener onMenuItemClickListener = PopupMenu.this.f2867e;
                if (onMenuItemClickListener != null) {
                    return onMenuItemClickListener.onMenuItemClick(menuItem);
                }
                return false;
            }

            @Override // android.support.v7.view.menu.MenuBuilder.Callback
            public void onMenuModeChange(MenuBuilder menuBuilder) {
            }
        });
        this.f2866d = new MenuPopupHelper(context, this.f2864b, view, false, i2, i3);
        this.f2866d.setGravity(i);
        this.f2866d.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: android.support.v7.widget.PopupMenu.2
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                PopupMenu popupMenu = PopupMenu.this;
                OnDismissListener onDismissListener = popupMenu.f2868f;
                if (onDismissListener != null) {
                    onDismissListener.onDismiss(popupMenu);
                }
            }
        });
    }
}
