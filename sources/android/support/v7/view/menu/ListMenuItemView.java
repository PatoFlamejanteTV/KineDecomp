package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements MenuView.ItemView {

    /* renamed from: a, reason: collision with root package name */
    private MenuItemImpl f2449a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f2450b;

    /* renamed from: c, reason: collision with root package name */
    private RadioButton f2451c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f2452d;

    /* renamed from: e, reason: collision with root package name */
    private CheckBox f2453e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f2454f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f2455g;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f2456h;
    private int i;
    private Context j;
    private boolean k;
    private Drawable l;
    private int m;
    private LayoutInflater n;
    private boolean o;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listMenuViewStyle);
    }

    private void a() {
        this.f2453e = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        addView(this.f2453e);
    }

    private void b() {
        this.f2450b = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
        addView(this.f2450b, 0);
    }

    private void c() {
        this.f2451c = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
        addView(this.f2451c);
    }

    private LayoutInflater getInflater() {
        if (this.n == null) {
            this.n = LayoutInflater.from(getContext());
        }
        return this.n;
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.f2455g;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.f2449a;
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public void initialize(MenuItemImpl menuItemImpl, int i) {
        this.f2449a = menuItemImpl;
        this.m = i;
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setTitle(menuItemImpl.a(this));
        setCheckable(menuItemImpl.isCheckable());
        setShortcut(menuItemImpl.c(), menuItemImpl.a());
        setIcon(menuItemImpl.getIcon());
        setEnabled(menuItemImpl.isEnabled());
        setSubMenuArrowVisible(menuItemImpl.hasSubMenu());
        setContentDescription(menuItemImpl.getContentDescription());
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        ViewCompat.setBackground(this, this.f2456h);
        this.f2452d = (TextView) findViewById(R.id.title);
        int i = this.i;
        if (i != -1) {
            this.f2452d.setTextAppearance(this.j, i);
        }
        this.f2454f = (TextView) findViewById(R.id.shortcut);
        this.f2455g = (ImageView) findViewById(R.id.submenuarrow);
        ImageView imageView = this.f2455g;
        if (imageView != null) {
            imageView.setImageDrawable(this.l);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.f2450b != null && this.k) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f2450b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (!z && this.f2451c == null && this.f2453e == null) {
            return;
        }
        if (this.f2449a.isExclusiveCheckable()) {
            if (this.f2451c == null) {
                c();
            }
            compoundButton = this.f2451c;
            compoundButton2 = this.f2453e;
        } else {
            if (this.f2453e == null) {
                a();
            }
            compoundButton = this.f2453e;
            compoundButton2 = this.f2451c;
        }
        if (z) {
            compoundButton.setChecked(this.f2449a.isChecked());
            int i = z ? 0 : 8;
            if (compoundButton.getVisibility() != i) {
                compoundButton.setVisibility(i);
            }
            if (compoundButton2 == null || compoundButton2.getVisibility() == 8) {
                return;
            }
            compoundButton2.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f2453e;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f2451c;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f2449a.isExclusiveCheckable()) {
            if (this.f2451c == null) {
                c();
            }
            compoundButton = this.f2451c;
        } else {
            if (this.f2453e == null) {
                a();
            }
            compoundButton = this.f2453e;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.o = z;
        this.k = z;
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public void setIcon(Drawable drawable) {
        boolean z = this.f2449a.shouldShowIcon() || this.o;
        if (z || this.k) {
            if (this.f2450b == null && drawable == null && !this.k) {
                return;
            }
            if (this.f2450b == null) {
                b();
            }
            if (drawable == null && !this.k) {
                this.f2450b.setVisibility(8);
                return;
            }
            ImageView imageView = this.f2450b;
            if (!z) {
                drawable = null;
            }
            imageView.setImageDrawable(drawable);
            if (this.f2450b.getVisibility() != 0) {
                this.f2450b.setVisibility(0);
            }
        }
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public void setShortcut(boolean z, char c2) {
        int i = (z && this.f2449a.c()) ? 0 : 8;
        if (i == 0) {
            this.f2454f.setText(this.f2449a.b());
        }
        if (this.f2454f.getVisibility() != i) {
            this.f2454f.setVisibility(i);
        }
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f2452d.setText(charSequence);
            if (this.f2452d.getVisibility() != 0) {
                this.f2452d.setVisibility(0);
                return;
            }
            return;
        }
        if (this.f2452d.getVisibility() != 8) {
            this.f2452d.setVisibility(8);
        }
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return this.o;
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getContext(), attributeSet, R.styleable.MenuView, i, 0);
        this.f2456h = obtainStyledAttributes.getDrawable(R.styleable.MenuView_android_itemBackground);
        this.i = obtainStyledAttributes.getResourceId(R.styleable.MenuView_android_itemTextAppearance, -1);
        this.k = obtainStyledAttributes.getBoolean(R.styleable.MenuView_preserveIconSpacing, false);
        this.j = context;
        this.l = obtainStyledAttributes.getDrawable(R.styleable.MenuView_subMenuArrow);
        obtainStyledAttributes.recycle();
    }
}
