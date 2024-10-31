package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.support.v7.app.AlertDialog;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuPresenter;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/* loaded from: classes.dex */
class MenuDialogHelper implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, MenuPresenter.Callback {

    /* renamed from: a, reason: collision with root package name */
    private MenuBuilder f2481a;

    /* renamed from: b, reason: collision with root package name */
    private AlertDialog f2482b;

    /* renamed from: c, reason: collision with root package name */
    ListMenuPresenter f2483c;

    /* renamed from: d, reason: collision with root package name */
    private MenuPresenter.Callback f2484d;

    public MenuDialogHelper(MenuBuilder menuBuilder) {
        this.f2481a = menuBuilder;
    }

    public void dismiss() {
        AlertDialog alertDialog = this.f2482b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2481a.performItemAction((MenuItemImpl) this.f2483c.getAdapter().getItem(i), 0);
    }

    @Override // android.support.v7.view.menu.MenuPresenter.Callback
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (z || menuBuilder == this.f2481a) {
            dismiss();
        }
        MenuPresenter.Callback callback = this.f2484d;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z);
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f2483c.onCloseMenu(this.f2481a, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f2482b.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f2482b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f2481a.close(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f2481a.performShortcut(i, keyEvent, 0);
    }

    @Override // android.support.v7.view.menu.MenuPresenter.Callback
    public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        MenuPresenter.Callback callback = this.f2484d;
        if (callback != null) {
            return callback.onOpenSubMenu(menuBuilder);
        }
        return false;
    }

    public void setPresenterCallback(MenuPresenter.Callback callback) {
        this.f2484d = callback;
    }

    public void show(IBinder iBinder) {
        MenuBuilder menuBuilder = this.f2481a;
        AlertDialog.Builder builder = new AlertDialog.Builder(menuBuilder.getContext());
        this.f2483c = new ListMenuPresenter(builder.getContext(), R.layout.abc_list_menu_item_layout);
        this.f2483c.setCallback(this);
        this.f2481a.addMenuPresenter(this.f2483c);
        builder.setAdapter(this.f2483c.getAdapter(), this);
        View headerView = menuBuilder.getHeaderView();
        if (headerView != null) {
            builder.setCustomTitle(headerView);
        } else {
            builder.setIcon(menuBuilder.getHeaderIcon()).setTitle(menuBuilder.getHeaderTitle());
        }
        builder.setOnKeyListener(this);
        this.f2482b = builder.create();
        this.f2482b.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f2482b.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f2482b.show();
    }
}
