package android.support.v7.internal.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.g.a;
import android.support.v7.internal.view.menu.h;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MenuItemWrapperJB.java */
@TargetApi(16)
/* loaded from: classes.dex */
public class i extends h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, android.support.v4.c.a.b bVar) {
        super(context, bVar);
    }

    @Override // android.support.v7.internal.view.menu.h
    h.a a(ActionProvider actionProvider) {
        return new a(this.f132a, actionProvider);
    }

    /* compiled from: MenuItemWrapperJB.java */
    /* loaded from: classes.dex */
    class a extends h.a implements ActionProvider.VisibilityListener {
        a.b c;

        public a(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // android.support.v4.g.a
        public View a(MenuItem menuItem) {
            return this.f136a.onCreateActionView(menuItem);
        }

        @Override // android.support.v4.g.a
        public boolean b() {
            return this.f136a.overridesItemVisibility();
        }

        @Override // android.support.v4.g.a
        public boolean c() {
            return this.f136a.isVisible();
        }

        @Override // android.support.v4.g.a
        public void a(a.b bVar) {
            this.c = bVar;
            ActionProvider actionProvider = this.f136a;
            if (bVar == null) {
                this = null;
            }
            actionProvider.setVisibilityListener(this);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z) {
            if (this.c != null) {
                this.c.a(z);
            }
        }
    }
}
