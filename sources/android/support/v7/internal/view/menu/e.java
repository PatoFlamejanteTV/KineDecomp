package android.support.v7.internal.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.b.a;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MenuBuilder.java */
/* loaded from: classes.dex */
public class e implements android.support.v4.c.a.a {
    private static final int[] d = {1, 4, 5, 3, 2, 0};

    /* renamed from: a, reason: collision with root package name */
    CharSequence f133a;
    Drawable b;
    View c;
    private final Context e;
    private final Resources f;
    private boolean g;
    private boolean h;
    private a i;
    private ContextMenu.ContextMenuInfo q;
    private f x;
    private boolean y;
    private int p = 0;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private ArrayList<f> v = new ArrayList<>();
    private CopyOnWriteArrayList<WeakReference<k>> w = new CopyOnWriteArrayList<>();
    private ArrayList<f> j = new ArrayList<>();
    private ArrayList<f> k = new ArrayList<>();
    private boolean l = true;
    private ArrayList<f> m = new ArrayList<>();
    private ArrayList<f> n = new ArrayList<>();
    private boolean o = true;

    /* compiled from: MenuBuilder.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(e eVar);

        boolean a(e eVar, MenuItem menuItem);
    }

    /* compiled from: MenuBuilder.java */
    /* loaded from: classes.dex */
    public interface b {
        boolean a(f fVar);
    }

    public e(Context context) {
        this.e = context;
        this.f = context.getResources();
        d(true);
    }

    public void a(k kVar, Context context) {
        this.w.add(new WeakReference<>(kVar));
        kVar.a(context, this);
        this.o = true;
    }

    private void c(boolean z) {
        if (!this.w.isEmpty()) {
            f();
            Iterator<WeakReference<k>> it = this.w.iterator();
            while (it.hasNext()) {
                WeakReference<k> next = it.next();
                k kVar = next.get();
                if (kVar == null) {
                    this.w.remove(next);
                } else {
                    kVar.b(z);
                }
            }
            g();
        }
    }

    private boolean a(o oVar, k kVar) {
        if (this.w.isEmpty()) {
            return false;
        }
        boolean a2 = kVar != null ? kVar.a(oVar) : false;
        Iterator<WeakReference<k>> it = this.w.iterator();
        while (true) {
            boolean z = a2;
            if (!it.hasNext()) {
                return z;
            }
            WeakReference<k> next = it.next();
            k kVar2 = next.get();
            if (kVar2 == null) {
                this.w.remove(next);
            } else if (!z) {
                z = kVar2.a(oVar);
            }
            a2 = z;
        }
    }

    public void a(a aVar) {
        this.i = aVar;
    }

    private MenuItem a(int i, int i2, int i3, CharSequence charSequence) {
        int c = c(i3);
        f a2 = a(i, i2, i3, c, charSequence, this.p);
        if (this.q != null) {
            a2.a(this.q);
        }
        this.j.add(a(this.j, c), a2);
        b(true);
        return a2;
    }

    private f a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new f(this, i, i2, i3, i4, charSequence, i5);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return a(0, 0, 0, this.f.getString(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(i, i2, i3, this.f.getString(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f.getString(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        f fVar = (f) a(i, i2, i3, charSequence);
        o oVar = new o(this.e, this, fVar);
        fVar.a(oVar);
        return oVar;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f.getString(i4));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.e.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i5);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        a(a(i), true);
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        int b2 = b(i);
        if (b2 >= 0) {
            int size = this.j.size() - b2;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || this.j.get(b2).getGroupId() != i) {
                    break;
                }
                a(b2, false);
                i2 = i3;
            }
            b(true);
        }
    }

    private void a(int i, boolean z) {
        if (i >= 0 && i < this.j.size()) {
            this.j.remove(i);
            if (z) {
                b(true);
            }
        }
    }

    @Override // android.view.Menu
    public void clear() {
        if (this.x != null) {
            d(this.x);
        }
        this.j.clear();
        b(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            f fVar = this.j.get(i);
            if (fVar.getGroupId() == groupId && fVar.g() && fVar.isCheckable()) {
                fVar.b(fVar == menuItem);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            f fVar = this.j.get(i2);
            if (fVar.getGroupId() == i) {
                fVar.a(z2);
                fVar.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        int size = this.j.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            f fVar = this.j.get(i2);
            i2++;
            z2 = (fVar.getGroupId() == i && fVar.c(z)) ? true : z2;
        }
        if (z2) {
            b(true);
        }
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            f fVar = this.j.get(i2);
            if (fVar.getGroupId() == i) {
                fVar.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.y) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.j.get(i).isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        MenuItem findItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            f fVar = this.j.get(i2);
            if (fVar.getItemId() != i) {
                if (fVar.hasSubMenu() && (findItem = fVar.getSubMenu().findItem(i)) != null) {
                    return findItem;
                }
            } else {
                return fVar;
            }
        }
        return null;
    }

    public int a(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.j.get(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public int b(int i) {
        return a(i, 0);
    }

    public int a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (this.j.get(i3).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    @Override // android.view.Menu
    public int size() {
        return this.j.size();
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return this.j.get(i);
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return a(i, keyEvent) != null;
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.g = z;
        b(false);
    }

    private static int c(int i) {
        int i2 = ((-65536) & i) >> 16;
        if (i2 < 0 || i2 >= d.length) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        return (d[i2] << 16) | (65535 & i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.g;
    }

    private void d(boolean z) {
        this.h = z && this.f.getConfiguration().keyboard != 1 && this.f.getBoolean(a.b.abc_config_showMenuShortcutsWhenKeyboardPresent);
    }

    public boolean b() {
        return this.h;
    }

    Resources c() {
        return this.f;
    }

    public Context d() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(e eVar, MenuItem menuItem) {
        return this.i != null && this.i.a(eVar, menuItem);
    }

    public void e() {
        if (this.i != null) {
            this.i.a(this);
        }
    }

    private static int a(ArrayList<f> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).c() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        f a2 = a(i, keyEvent);
        boolean z = false;
        if (a2 != null) {
            z = a(a2, i2);
        }
        if ((i2 & 2) != 0) {
            a(true);
        }
        return z;
    }

    void a(List<f> list, int i, KeyEvent keyEvent) {
        boolean a2 = a();
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.j.size();
            for (int i2 = 0; i2 < size; i2++) {
                f fVar = this.j.get(i2);
                if (fVar.hasSubMenu()) {
                    ((e) fVar.getSubMenu()).a(list, i, keyEvent);
                }
                char alphabeticShortcut = a2 ? fVar.getAlphabeticShortcut() : fVar.getNumericShortcut();
                if ((metaState & 5) == 0 && alphabeticShortcut != 0 && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (a2 && alphabeticShortcut == '\b' && i == 67)) && fVar.isEnabled())) {
                    list.add(fVar);
                }
            }
        }
    }

    f a(int i, KeyEvent keyEvent) {
        ArrayList<f> arrayList = this.v;
        arrayList.clear();
        a(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean a2 = a();
        for (int i2 = 0; i2 < size; i2++) {
            f fVar = arrayList.get(i2);
            char alphabeticShortcut = a2 ? fVar.getAlphabeticShortcut() : fVar.getNumericShortcut();
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return fVar;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return fVar;
            }
            if (a2 && alphabeticShortcut == '\b' && i == 67) {
                return fVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return a(findItem(i), i2);
    }

    public boolean a(MenuItem menuItem, int i) {
        return a(menuItem, (k) null, i);
    }

    public boolean a(MenuItem menuItem, k kVar, int i) {
        f fVar = (f) menuItem;
        if (fVar == null || !fVar.isEnabled()) {
            return false;
        }
        boolean b2 = fVar.b();
        android.support.v4.g.a a2 = fVar.a();
        boolean z = a2 != null && a2.e();
        if (fVar.n()) {
            boolean expandActionView = fVar.expandActionView() | b2;
            if (expandActionView) {
                a(true);
                return expandActionView;
            }
            return expandActionView;
        }
        if (fVar.hasSubMenu() || z) {
            a(false);
            if (!fVar.hasSubMenu()) {
                fVar.a(new o(d(), this, fVar));
            }
            o oVar = (o) fVar.getSubMenu();
            if (z) {
                a2.a(oVar);
            }
            boolean a3 = a(oVar, kVar) | b2;
            if (!a3) {
                a(true);
                return a3;
            }
            return a3;
        }
        if ((i & 1) == 0) {
            a(true);
        }
        return b2;
    }

    public final void a(boolean z) {
        if (!this.u) {
            this.u = true;
            Iterator<WeakReference<k>> it = this.w.iterator();
            while (it.hasNext()) {
                WeakReference<k> next = it.next();
                k kVar = next.get();
                if (kVar == null) {
                    this.w.remove(next);
                } else {
                    kVar.a(this, z);
                }
            }
            this.u = false;
        }
    }

    @Override // android.view.Menu
    public void close() {
        a(true);
    }

    public void b(boolean z) {
        if (!this.r) {
            if (z) {
                this.l = true;
                this.o = true;
            }
            c(z);
            return;
        }
        this.s = true;
    }

    public void f() {
        if (!this.r) {
            this.r = true;
            this.s = false;
        }
    }

    public void g() {
        this.r = false;
        if (this.s) {
            this.s = false;
            b(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(f fVar) {
        this.l = true;
        b(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(f fVar) {
        this.o = true;
        b(true);
    }

    public ArrayList<f> h() {
        if (!this.l) {
            return this.k;
        }
        this.k.clear();
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            f fVar = this.j.get(i);
            if (fVar.isVisible()) {
                this.k.add(fVar);
            }
        }
        this.l = false;
        this.o = true;
        return this.k;
    }

    public void i() {
        boolean b2;
        ArrayList<f> h = h();
        if (this.o) {
            Iterator<WeakReference<k>> it = this.w.iterator();
            boolean z = false;
            while (it.hasNext()) {
                WeakReference<k> next = it.next();
                k kVar = next.get();
                if (kVar == null) {
                    this.w.remove(next);
                    b2 = z;
                } else {
                    b2 = kVar.b() | z;
                }
                z = b2;
            }
            if (z) {
                this.m.clear();
                this.n.clear();
                int size = h.size();
                for (int i = 0; i < size; i++) {
                    f fVar = h.get(i);
                    if (fVar.j()) {
                        this.m.add(fVar);
                    } else {
                        this.n.add(fVar);
                    }
                }
            } else {
                this.m.clear();
                this.n.clear();
                this.n.addAll(h());
            }
            this.o = false;
        }
    }

    public ArrayList<f> j() {
        i();
        return this.m;
    }

    public ArrayList<f> k() {
        i();
        return this.n;
    }

    public void clearHeader() {
        this.b = null;
        this.f133a = null;
        this.c = null;
        b(false);
    }

    private void a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources c = c();
        if (view != null) {
            this.c = view;
            this.f133a = null;
            this.b = null;
        } else {
            if (i > 0) {
                this.f133a = c.getText(i);
            } else if (charSequence != null) {
                this.f133a = charSequence;
            }
            if (i2 > 0) {
                this.b = android.support.v4.a.a.a(d(), i2);
            } else if (drawable != null) {
                this.b = drawable;
            }
            this.c = null;
        }
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e a(CharSequence charSequence) {
        a(0, charSequence, 0, null, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e a(Drawable drawable) {
        a(0, null, 0, drawable, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e a(View view) {
        a(0, null, 0, null, view);
        return this;
    }

    public e l() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m() {
        return this.t;
    }

    public boolean c(f fVar) {
        boolean z = false;
        if (!this.w.isEmpty()) {
            f();
            Iterator<WeakReference<k>> it = this.w.iterator();
            while (true) {
                boolean z2 = z;
                if (!it.hasNext()) {
                    z = z2;
                    break;
                }
                WeakReference<k> next = it.next();
                k kVar = next.get();
                if (kVar == null) {
                    this.w.remove(next);
                    z = z2;
                } else {
                    z = kVar.a(this, fVar);
                    if (z) {
                        break;
                    }
                }
            }
            g();
            if (z) {
                this.x = fVar;
            }
        }
        return z;
    }

    public boolean d(f fVar) {
        boolean z = false;
        if (!this.w.isEmpty() && this.x == fVar) {
            f();
            Iterator<WeakReference<k>> it = this.w.iterator();
            while (true) {
                boolean z2 = z;
                if (!it.hasNext()) {
                    z = z2;
                    break;
                }
                WeakReference<k> next = it.next();
                k kVar = next.get();
                if (kVar == null) {
                    this.w.remove(next);
                    z = z2;
                } else {
                    z = kVar.b(this, fVar);
                    if (z) {
                        break;
                    }
                }
            }
            g();
            if (z) {
                this.x = null;
            }
        }
        return z;
    }

    public f n() {
        return this.x;
    }
}
