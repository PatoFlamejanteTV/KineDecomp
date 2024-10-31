package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.b.a;
import android.support.v7.internal.view.menu.l;
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
public class ListMenuItemView extends LinearLayout implements l.a {

    /* renamed from: a, reason: collision with root package name */
    private f f129a;
    private ImageView b;
    private RadioButton c;
    private TextView d;
    private CheckBox e;
    private TextView f;
    private Drawable g;
    private int h;
    private Context i;
    private boolean j;
    private int k;
    private Context l;
    private LayoutInflater m;
    private boolean n;

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.l = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.i.MenuView, i, 0);
        this.g = obtainStyledAttributes.getDrawable(a.i.MenuView_android_itemBackground);
        this.h = obtainStyledAttributes.getResourceId(a.i.MenuView_android_itemTextAppearance, -1);
        this.j = obtainStyledAttributes.getBoolean(a.i.MenuView_preserveIconSpacing, false);
        this.i = context;
        obtainStyledAttributes.recycle();
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(this.g);
        this.d = (TextView) findViewById(a.e.title);
        if (this.h != -1) {
            this.d.setTextAppearance(this.i, this.h);
        }
        this.f = (TextView) findViewById(a.e.shortcut);
    }

    @Override // android.support.v7.internal.view.menu.l.a
    public void a(f fVar, int i) {
        this.f129a = fVar;
        this.k = i;
        setVisibility(fVar.isVisible() ? 0 : 8);
        setTitle(fVar.a((l.a) this));
        setCheckable(fVar.isCheckable());
        a(fVar.f(), fVar.d());
        setIcon(fVar.getIcon());
        setEnabled(fVar.isEnabled());
    }

    public void setForceShowIcon(boolean z) {
        this.n = z;
        this.j = z;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.d.setText(charSequence);
            if (this.d.getVisibility() != 0) {
                this.d.setVisibility(0);
                return;
            }
            return;
        }
        if (this.d.getVisibility() != 8) {
            this.d.setVisibility(8);
        }
    }

    @Override // android.support.v7.internal.view.menu.l.a
    public f getItemData() {
        return this.f129a;
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (z || this.c != null || this.e != null) {
            if (this.f129a.g()) {
                if (this.c == null) {
                    c();
                }
                compoundButton = this.c;
                compoundButton2 = this.e;
            } else {
                if (this.e == null) {
                    d();
                }
                compoundButton = this.e;
                compoundButton2 = this.c;
            }
            if (z) {
                compoundButton.setChecked(this.f129a.isChecked());
                int i = z ? 0 : 8;
                if (compoundButton.getVisibility() != i) {
                    compoundButton.setVisibility(i);
                }
                if (compoundButton2 != null && compoundButton2.getVisibility() != 8) {
                    compoundButton2.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.e != null) {
                this.e.setVisibility(8);
            }
            if (this.c != null) {
                this.c.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f129a.g()) {
            if (this.c == null) {
                c();
            }
            compoundButton = this.c;
        } else {
            if (this.e == null) {
                d();
            }
            compoundButton = this.e;
        }
        compoundButton.setChecked(z);
    }

    public void a(boolean z, char c) {
        int i = (z && this.f129a.f()) ? 0 : 8;
        if (i == 0) {
            this.f.setText(this.f129a.e());
        }
        if (this.f.getVisibility() != i) {
            this.f.setVisibility(i);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f129a.i() || this.n;
        if (z || this.j) {
            if (this.b != null || drawable != null || this.j) {
                if (this.b == null) {
                    b();
                }
                if (drawable != null || this.j) {
                    ImageView imageView = this.b;
                    if (!z) {
                        drawable = null;
                    }
                    imageView.setImageDrawable(drawable);
                    if (this.b.getVisibility() != 0) {
                        this.b.setVisibility(0);
                        return;
                    }
                    return;
                }
                this.b.setVisibility(8);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.b != null && this.j) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    private void b() {
        this.b = (ImageView) getInflater().inflate(a.g.abc_list_menu_item_icon, (ViewGroup) this, false);
        addView(this.b, 0);
    }

    private void c() {
        this.c = (RadioButton) getInflater().inflate(a.g.abc_list_menu_item_radio, (ViewGroup) this, false);
        addView(this.c);
    }

    private void d() {
        this.e = (CheckBox) getInflater().inflate(a.g.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        addView(this.e);
    }

    @Override // android.support.v7.internal.view.menu.l.a
    public boolean a() {
        return false;
    }

    private LayoutInflater getInflater() {
        if (this.m == null) {
            this.m = LayoutInflater.from(this.l);
        }
        return this.m;
    }
}
