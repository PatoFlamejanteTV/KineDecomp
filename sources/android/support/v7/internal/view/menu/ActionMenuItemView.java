package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.b.a;
import android.support.v7.internal.view.menu.e;
import android.support.v7.internal.view.menu.l;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.f;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/* loaded from: classes.dex */
public class ActionMenuItemView extends android.support.v7.widget.d implements l.a, ActionMenuView.a, View.OnClickListener, View.OnLongClickListener {

    /* renamed from: a */
    private f f126a;
    private CharSequence b;
    private Drawable c;
    private e.b d;
    private f.b e;
    private b f;
    private boolean g;
    private boolean h;
    private int i;
    private int j;
    private int k;

    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract android.support.v7.widget.f a();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.g = resources.getBoolean(a.b.abc_config_allowActionMenuItemTextWithIcon);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.i.ActionMenuItemView, i, 0);
        this.i = obtainStyledAttributes.getDimensionPixelSize(a.i.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.k = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        setOnLongClickListener(this);
        this.j = -1;
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        this.g = getContext().getResources().getBoolean(a.b.abc_config_allowActionMenuItemTextWithIcon);
        e();
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.j = i;
        super.setPadding(i, i2, i3, i4);
    }

    @Override // android.support.v7.internal.view.menu.l.a
    public f getItemData() {
        return this.f126a;
    }

    @Override // android.support.v7.internal.view.menu.l.a
    public void a(f fVar, int i) {
        this.f126a = fVar;
        setIcon(fVar.getIcon());
        setTitle(fVar.a((l.a) this));
        setId(fVar.getItemId());
        setVisibility(fVar.isVisible() ? 0 : 8);
        setEnabled(fVar.isEnabled());
        if (fVar.hasSubMenu() && this.e == null) {
            this.e = new a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f126a.hasSubMenu() && this.e != null && this.e.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.d != null) {
            this.d.a(this.f126a);
        }
    }

    public void setItemInvoker(e.b bVar) {
        this.d = bVar;
    }

    public void setPopupCallback(b bVar) {
        this.f = bVar;
    }

    @Override // android.support.v7.internal.view.menu.l.a
    public boolean a() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.h != z) {
            this.h = z;
            if (this.f126a != null) {
                this.f126a.h();
            }
        }
    }

    private void e() {
        boolean z = false;
        boolean z2 = !TextUtils.isEmpty(this.b);
        if (this.c == null || (this.f126a.m() && (this.g || this.h))) {
            z = true;
        }
        setText(z2 & z ? this.b : null);
    }

    public void setIcon(Drawable drawable) {
        this.c = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.k) {
                float f = this.k / intrinsicWidth;
                intrinsicWidth = this.k;
                intrinsicHeight = (int) (intrinsicHeight * f);
            }
            if (intrinsicHeight > this.k) {
                float f2 = this.k / intrinsicHeight;
                intrinsicHeight = this.k;
                intrinsicWidth = (int) (intrinsicWidth * f2);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        e();
    }

    public boolean b() {
        return !TextUtils.isEmpty(getText());
    }

    public void setTitle(CharSequence charSequence) {
        this.b = charSequence;
        setContentDescription(this.b);
        e();
    }

    @Override // android.support.v7.widget.ActionMenuView.a
    public boolean c() {
        return b() && this.f126a.getIcon() == null;
    }

    @Override // android.support.v7.widget.ActionMenuView.a
    public boolean d() {
        return b();
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (b()) {
            return false;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = iArr[1] + (height / 2);
        int i2 = iArr[0] + (width / 2);
        if (android.support.v4.g.p.a(view) == 0) {
            i2 = context.getResources().getDisplayMetrics().widthPixels - i2;
        }
        Toast makeText = Toast.makeText(context, this.f126a.getTitle(), 0);
        if (i < rect.height()) {
            makeText.setGravity(8388661, i2, height);
        } else {
            makeText.setGravity(81, 0, height);
        }
        makeText.show();
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean b2 = b();
        if (b2 && this.j >= 0) {
            super.setPadding(this.j, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.i) : this.i;
        if (mode != 1073741824 && this.i > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i2);
        }
        if (!b2 && this.c != null) {
            super.setPadding((getMeasuredWidth() - this.c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    /* loaded from: classes.dex */
    private class a extends f.b {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // android.support.v7.widget.f.b
        public android.support.v7.widget.f a() {
            if (ActionMenuItemView.this.f != null) {
                return ActionMenuItemView.this.f.a();
            }
            return null;
        }

        @Override // android.support.v7.widget.f.b
        protected boolean b() {
            android.support.v7.widget.f a2;
            return ActionMenuItemView.this.d != null && ActionMenuItemView.this.d.a(ActionMenuItemView.this.f126a) && (a2 = a()) != null && a2.b();
        }

        @Override // android.support.v7.widget.f.b
        protected boolean c() {
            android.support.v7.widget.f a2 = a();
            if (a2 == null) {
                return false;
            }
            a2.a();
            return true;
        }
    }
}
