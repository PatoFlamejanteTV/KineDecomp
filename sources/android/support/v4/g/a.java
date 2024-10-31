package android.support.v4.g;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: ActionProvider.java */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private final Context f87a;
    private InterfaceC0009a b;
    private b c;

    /* compiled from: ActionProvider.java */
    /* renamed from: android.support.v4.g.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0009a {
        void a(boolean z);
    }

    /* compiled from: ActionProvider.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(boolean z);
    }

    public abstract View a();

    public a(Context context) {
        this.f87a = context;
    }

    public View a(MenuItem menuItem) {
        return a();
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return true;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return false;
    }

    public void a(SubMenu subMenu) {
    }

    public void a(boolean z) {
        if (this.b != null) {
            this.b.a(z);
        }
    }

    public void a(InterfaceC0009a interfaceC0009a) {
        this.b = interfaceC0009a;
    }

    public void a(b bVar) {
        if (this.c != null && bVar != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.c = bVar;
    }
}
