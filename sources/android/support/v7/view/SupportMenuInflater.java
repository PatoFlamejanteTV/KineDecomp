package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuItemWrapperICS;
import android.support.v7.widget.DrawableUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class SupportMenuInflater extends MenuInflater {

    /* renamed from: a, reason: collision with root package name */
    static final Class<?>[] f2379a = {Context.class};

    /* renamed from: b, reason: collision with root package name */
    static final Class<?>[] f2380b = f2379a;

    /* renamed from: c, reason: collision with root package name */
    final Object[] f2381c;

    /* renamed from: d, reason: collision with root package name */
    final Object[] f2382d;

    /* renamed from: e, reason: collision with root package name */
    Context f2383e;

    /* renamed from: f, reason: collision with root package name */
    private Object f2384f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class InflatedOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        private static final Class<?>[] f2385a = {MenuItem.class};

        /* renamed from: b, reason: collision with root package name */
        private Object f2386b;

        /* renamed from: c, reason: collision with root package name */
        private Method f2387c;

        public InflatedOnMenuItemClickListener(Object obj, String str) {
            this.f2386b = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f2387c = cls.getMethod(str, f2385a);
            } catch (Exception e2) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e2);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f2387c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f2387c.invoke(this.f2386b, menuItem)).booleanValue();
                }
                this.f2387c.invoke(this.f2386b, menuItem);
                return true;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class MenuState {
        ActionProvider A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;

        /* renamed from: a, reason: collision with root package name */
        private Menu f2388a;

        /* renamed from: b, reason: collision with root package name */
        private int f2389b;

        /* renamed from: c, reason: collision with root package name */
        private int f2390c;

        /* renamed from: d, reason: collision with root package name */
        private int f2391d;

        /* renamed from: e, reason: collision with root package name */
        private int f2392e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f2393f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f2394g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f2395h;
        private int i;
        private int j;
        private CharSequence k;
        private CharSequence l;
        private int m;
        private char n;
        private int o;
        private char p;
        private int q;
        private int r;
        private boolean s;
        private boolean t;
        private boolean u;
        private int v;
        private int w;
        private String x;
        private String y;
        private String z;

        public MenuState(Menu menu) {
            this.f2388a = menu;
            resetGroup();
        }

        private char a(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        public void addItem() {
            this.f2395h = true;
            a(this.f2388a.add(this.f2389b, this.i, this.j, this.k));
        }

        public SubMenu addSubMenuItem() {
            this.f2395h = true;
            SubMenu addSubMenu = this.f2388a.addSubMenu(this.f2389b, this.i, this.j, this.k);
            a(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean hasAddedItem() {
            return this.f2395h;
        }

        public void readGroup(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = SupportMenuInflater.this.f2383e.obtainStyledAttributes(attributeSet, R.styleable.MenuGroup);
            this.f2389b = obtainStyledAttributes.getResourceId(R.styleable.MenuGroup_android_id, 0);
            this.f2390c = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
            this.f2391d = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
            this.f2392e = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
            this.f2393f = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_visible, true);
            this.f2394g = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void readItem(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = SupportMenuInflater.this.f2383e.obtainStyledAttributes(attributeSet, R.styleable.MenuItem);
            this.i = obtainStyledAttributes.getResourceId(R.styleable.MenuItem_android_id, 0);
            this.j = (obtainStyledAttributes.getInt(R.styleable.MenuItem_android_menuCategory, this.f2390c) & SupportMenu.CATEGORY_MASK) | (obtainStyledAttributes.getInt(R.styleable.MenuItem_android_orderInCategory, this.f2391d) & SupportMenu.USER_MASK);
            this.k = obtainStyledAttributes.getText(R.styleable.MenuItem_android_title);
            this.l = obtainStyledAttributes.getText(R.styleable.MenuItem_android_titleCondensed);
            this.m = obtainStyledAttributes.getResourceId(R.styleable.MenuItem_android_icon, 0);
            this.n = a(obtainStyledAttributes.getString(R.styleable.MenuItem_android_alphabeticShortcut));
            this.o = obtainStyledAttributes.getInt(R.styleable.MenuItem_alphabeticModifiers, 4096);
            this.p = a(obtainStyledAttributes.getString(R.styleable.MenuItem_android_numericShortcut));
            this.q = obtainStyledAttributes.getInt(R.styleable.MenuItem_numericModifiers, 4096);
            if (obtainStyledAttributes.hasValue(R.styleable.MenuItem_android_checkable)) {
                this.r = obtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.r = this.f2392e;
            }
            this.s = obtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_checked, false);
            this.t = obtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_visible, this.f2393f);
            this.u = obtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_enabled, this.f2394g);
            this.v = obtainStyledAttributes.getInt(R.styleable.MenuItem_showAsAction, -1);
            this.z = obtainStyledAttributes.getString(R.styleable.MenuItem_android_onClick);
            this.w = obtainStyledAttributes.getResourceId(R.styleable.MenuItem_actionLayout, 0);
            this.x = obtainStyledAttributes.getString(R.styleable.MenuItem_actionViewClass);
            this.y = obtainStyledAttributes.getString(R.styleable.MenuItem_actionProviderClass);
            boolean z = this.y != null;
            if (z && this.w == 0 && this.x == null) {
                this.A = (ActionProvider) a(this.y, SupportMenuInflater.f2380b, SupportMenuInflater.this.f2382d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = obtainStyledAttributes.getText(R.styleable.MenuItem_contentDescription);
            this.C = obtainStyledAttributes.getText(R.styleable.MenuItem_tooltipText);
            if (obtainStyledAttributes.hasValue(R.styleable.MenuItem_iconTintMode)) {
                this.E = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(R.styleable.MenuItem_iconTintMode, -1), this.E);
            } else {
                this.E = null;
            }
            if (obtainStyledAttributes.hasValue(R.styleable.MenuItem_iconTint)) {
                this.D = obtainStyledAttributes.getColorStateList(R.styleable.MenuItem_iconTint);
            } else {
                this.D = null;
            }
            obtainStyledAttributes.recycle();
            this.f2395h = false;
        }

        public void resetGroup() {
            this.f2389b = 0;
            this.f2390c = 0;
            this.f2391d = 0;
            this.f2392e = 0;
            this.f2393f = true;
            this.f2394g = true;
        }

        private void a(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
            int i = this.v;
            if (i >= 0) {
                menuItem.setShowAsAction(i);
            }
            if (this.z != null) {
                if (!SupportMenuInflater.this.f2383e.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new InflatedOnMenuItemClickListener(SupportMenuInflater.this.a(), this.z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            boolean z2 = menuItem instanceof MenuItemImpl;
            if (z2) {
            }
            if (this.r >= 2) {
                if (z2) {
                    ((MenuItemImpl) menuItem).setExclusiveCheckable(true);
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    ((MenuItemWrapperICS) menuItem).setExclusiveCheckable(true);
                }
            }
            String str = this.x;
            if (str != null) {
                menuItem.setActionView((View) a(str, SupportMenuInflater.f2379a, SupportMenuInflater.this.f2381c));
                z = true;
            }
            int i2 = this.w;
            if (i2 > 0) {
                if (!z) {
                    menuItem.setActionView(i2);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            ActionProvider actionProvider = this.A;
            if (actionProvider != null) {
                MenuItemCompat.setActionProvider(menuItem, actionProvider);
            }
            MenuItemCompat.setContentDescription(menuItem, this.B);
            MenuItemCompat.setTooltipText(menuItem, this.C);
            MenuItemCompat.setAlphabeticShortcut(menuItem, this.n, this.o);
            MenuItemCompat.setNumericShortcut(menuItem, this.p, this.q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                MenuItemCompat.setIconTintMode(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                MenuItemCompat.setIconTintList(menuItem, colorStateList);
            }
        }

        private <T> T a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = SupportMenuInflater.this.f2383e.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e2) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e2);
                return null;
            }
        }
    }

    public SupportMenuInflater(Context context) {
        super(context);
        this.f2383e = context;
        this.f2381c = new Object[]{context};
        this.f2382d = this.f2381c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0049, code lost:            if (r6 == 2) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004c, code lost:            if (r6 == 3) goto L20;     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0050, code lost:            r6 = r13.getName();     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0054, code lost:            if (r7 == false) goto L25;     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005a, code lost:            if (r6.equals(r8) == false) goto L25;     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005c, code lost:            r8 = null;        r7 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ba, code lost:            r6 = r13.next();     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0063, code lost:            if (r6.equals("group") == false) goto L28;     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0065, code lost:            r0.resetGroup();     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006d, code lost:            if (r6.equals("item") == false) goto L38;     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0073, code lost:            if (r0.hasAddedItem() != false) goto L65;     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0075, code lost:            r6 = r0.A;     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0077, code lost:            if (r6 == null) goto L37;     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007d, code lost:            if (r6.hasSubMenu() == false) goto L37;     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007f, code lost:            r0.addSubMenuItem();     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0083, code lost:            r0.addItem();     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008b, code lost:            if (r6.equals("menu") == false) goto L68;     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008d, code lost:            r15 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008f, code lost:            if (r7 == false) goto L43;     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0092, code lost:            r6 = r13.getName();     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x009a, code lost:            if (r6.equals("group") == false) goto L46;     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009c, code lost:            r0.readGroup(r14);     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a4, code lost:            if (r6.equals("item") == false) goto L49;     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a6, code lost:            r0.readItem(r14);     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ae, code lost:            if (r6.equals("menu") == false) goto L52;     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b0, code lost:            a(r13, r14, r0.addSubMenuItem());     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b8, code lost:            r8 = r6;        r7 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c6, code lost:            throw new java.lang.RuntimeException("Unexpected end of document");     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c7, code lost:            return;     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003b, code lost:            r6 = r15;        r8 = null;        r15 = false;        r7 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0041, code lost:            if (r15 != false) goto L60;     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0043, code lost:            if (r6 == 1) goto L61;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(org.xmlpull.v1.XmlPullParser r13, android.util.AttributeSet r14, android.view.Menu r15) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r12 = this;
            android.support.v7.view.SupportMenuInflater$MenuState r0 = new android.support.v7.view.SupportMenuInflater$MenuState
            r0.<init>(r15)
            int r15 = r13.getEventType()
        L9:
            r1 = 2
            java.lang.String r2 = "menu"
            r3 = 1
            if (r15 != r1) goto L35
            java.lang.String r15 = r13.getName()
            boolean r4 = r15.equals(r2)
            if (r4 == 0) goto L1e
            int r15 = r13.next()
            goto L3b
        L1e:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "Expecting menu, got "
            r14.append(r0)
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        L35:
            int r15 = r13.next()
            if (r15 != r3) goto L9
        L3b:
            r4 = 0
            r5 = 0
            r6 = r15
            r8 = r4
            r15 = 0
            r7 = 0
        L41:
            if (r15 != 0) goto Lc7
            if (r6 == r3) goto Lbf
            java.lang.String r9 = "item"
            java.lang.String r10 = "group"
            if (r6 == r1) goto L8f
            r11 = 3
            if (r6 == r11) goto L50
            goto Lba
        L50:
            java.lang.String r6 = r13.getName()
            if (r7 == 0) goto L5f
            boolean r11 = r6.equals(r8)
            if (r11 == 0) goto L5f
            r8 = r4
            r7 = 0
            goto Lba
        L5f:
            boolean r10 = r6.equals(r10)
            if (r10 == 0) goto L69
            r0.resetGroup()
            goto Lba
        L69:
            boolean r9 = r6.equals(r9)
            if (r9 == 0) goto L87
            boolean r6 = r0.hasAddedItem()
            if (r6 != 0) goto Lba
            android.support.v4.view.ActionProvider r6 = r0.A
            if (r6 == 0) goto L83
            boolean r6 = r6.hasSubMenu()
            if (r6 == 0) goto L83
            r0.addSubMenuItem()
            goto Lba
        L83:
            r0.addItem()
            goto Lba
        L87:
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto Lba
            r15 = 1
            goto Lba
        L8f:
            if (r7 == 0) goto L92
            goto Lba
        L92:
            java.lang.String r6 = r13.getName()
            boolean r10 = r6.equals(r10)
            if (r10 == 0) goto La0
            r0.readGroup(r14)
            goto Lba
        La0:
            boolean r9 = r6.equals(r9)
            if (r9 == 0) goto Laa
            r0.readItem(r14)
            goto Lba
        Laa:
            boolean r9 = r6.equals(r2)
            if (r9 == 0) goto Lb8
            android.view.SubMenu r6 = r0.addSubMenuItem()
            r12.a(r13, r14, r6)
            goto Lba
        Lb8:
            r8 = r6
            r7 = 1
        Lba:
            int r6 = r13.next()
            goto L41
        Lbf:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.String r14 = "Unexpected end of document"
            r13.<init>(r14)
            throw r13
        Lc7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.SupportMenuInflater.a(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) {
        if (!(menu instanceof SupportMenu)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.f2383e.getResources().getLayout(i);
                    a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                } catch (IOException e2) {
                    throw new InflateException("Error inflating menu XML", e2);
                }
            } catch (XmlPullParserException e3) {
                throw new InflateException("Error inflating menu XML", e3);
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    Object a() {
        if (this.f2384f == null) {
            this.f2384f = a(this.f2383e);
        }
        return this.f2384f;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }
}
