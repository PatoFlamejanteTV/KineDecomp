package android.support.v7.view;

import android.content.Context;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.util.SimpleArrayMap;
import android.support.v7.view.ActionMode;
import android.support.v7.view.menu.MenuWrapperFactory;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SupportActionModeWrapper extends android.view.ActionMode {

    /* renamed from: a */
    final Context f2373a;

    /* renamed from: b */
    final ActionMode f2374b;

    /* loaded from: classes.dex */
    public static class CallbackWrapper implements ActionMode.Callback {

        /* renamed from: a */
        final ActionMode.Callback f2375a;

        /* renamed from: b */
        final Context f2376b;

        /* renamed from: c */
        final ArrayList<SupportActionModeWrapper> f2377c = new ArrayList<>();

        /* renamed from: d */
        final SimpleArrayMap<Menu, Menu> f2378d = new SimpleArrayMap<>();

        public CallbackWrapper(Context context, ActionMode.Callback callback) {
            this.f2376b = context;
            this.f2375a = callback;
        }

        private Menu a(Menu menu) {
            Menu menu2 = this.f2378d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            Menu wrapSupportMenu = MenuWrapperFactory.wrapSupportMenu(this.f2376b, (SupportMenu) menu);
            this.f2378d.put(menu, wrapSupportMenu);
            return wrapSupportMenu;
        }

        public android.view.ActionMode getActionModeWrapper(ActionMode actionMode) {
            int size = this.f2377c.size();
            for (int i = 0; i < size; i++) {
                SupportActionModeWrapper supportActionModeWrapper = this.f2377c.get(i);
                if (supportActionModeWrapper != null && supportActionModeWrapper.f2374b == actionMode) {
                    return supportActionModeWrapper;
                }
            }
            SupportActionModeWrapper supportActionModeWrapper2 = new SupportActionModeWrapper(this.f2376b, actionMode);
            this.f2377c.add(supportActionModeWrapper2);
            return supportActionModeWrapper2;
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f2375a.onActionItemClicked(getActionModeWrapper(actionMode), MenuWrapperFactory.wrapSupportMenuItem(this.f2376b, (SupportMenuItem) menuItem));
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f2375a.onCreateActionMode(getActionModeWrapper(actionMode), a(menu));
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.f2375a.onDestroyActionMode(getActionModeWrapper(actionMode));
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.f2375a.onPrepareActionMode(getActionModeWrapper(actionMode), a(menu));
        }
    }

    public SupportActionModeWrapper(Context context, ActionMode actionMode) {
        this.f2373a = context;
        this.f2374b = actionMode;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f2374b.finish();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f2374b.getCustomView();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return MenuWrapperFactory.wrapSupportMenu(this.f2373a, (SupportMenu) this.f2374b.getMenu());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f2374b.getMenuInflater();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f2374b.getSubtitle();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f2374b.getTag();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f2374b.getTitle();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f2374b.getTitleOptionalHint();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f2374b.invalidate();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f2374b.isTitleOptional();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f2374b.setCustomView(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f2374b.setSubtitle(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f2374b.setTag(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f2374b.setTitle(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.f2374b.setTitleOptionalHint(z);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.f2374b.setSubtitle(i);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.f2374b.setTitle(i);
    }
}
