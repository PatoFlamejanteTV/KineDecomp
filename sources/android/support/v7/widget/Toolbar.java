package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.g.p;
import android.support.v7.a.a;
import android.support.v7.b.a;
import android.support.v7.internal.view.menu.e;
import android.support.v7.internal.view.menu.k;
import android.support.v7.internal.widget.ab;
import android.support.v7.internal.widget.ac;
import android.support.v7.internal.widget.ad;
import android.support.v7.internal.widget.af;
import android.support.v7.internal.widget.r;
import android.support.v7.widget.ActionMenuView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    private boolean A;
    private final ArrayList<View> B;
    private final int[] C;
    private c D;
    private final ActionMenuView.e E;
    private ad F;
    private a G;
    private k.a H;
    private e.a I;
    private boolean J;
    private final Runnable K;
    private final ab L;

    /* renamed from: a, reason: collision with root package name */
    View f205a;
    private ActionMenuView b;
    private TextView c;
    private TextView d;
    private ImageButton e;
    private ImageView f;
    private Drawable g;
    private CharSequence h;
    private ImageButton i;
    private Context j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private final r t;
    private int u;
    private CharSequence v;
    private CharSequence w;
    private int x;
    private int y;
    private boolean z;

    /* loaded from: classes.dex */
    public interface c {
        boolean a(MenuItem menuItem);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0016a.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.t = new r();
        this.u = 8388627;
        this.B = new ArrayList<>();
        this.C = new int[2];
        this.E = new l(this);
        this.K = new m(this);
        ac a2 = ac.a(getContext(), attributeSet, a.i.Toolbar, i, 0);
        this.l = a2.f(a.i.Toolbar_titleTextAppearance, 0);
        this.m = a2.f(a.i.Toolbar_subtitleTextAppearance, 0);
        this.u = a2.b(a.i.Toolbar_android_gravity, this.u);
        this.n = 48;
        int c2 = a2.c(a.i.Toolbar_titleMargins, 0);
        this.s = c2;
        this.r = c2;
        this.q = c2;
        this.p = c2;
        int c3 = a2.c(a.i.Toolbar_titleMarginStart, -1);
        if (c3 >= 0) {
            this.p = c3;
        }
        int c4 = a2.c(a.i.Toolbar_titleMarginEnd, -1);
        if (c4 >= 0) {
            this.q = c4;
        }
        int c5 = a2.c(a.i.Toolbar_titleMarginTop, -1);
        if (c5 >= 0) {
            this.r = c5;
        }
        int c6 = a2.c(a.i.Toolbar_titleMarginBottom, -1);
        if (c6 >= 0) {
            this.s = c6;
        }
        this.o = a2.d(a.i.Toolbar_maxButtonHeight, -1);
        int c7 = a2.c(a.i.Toolbar_contentInsetStart, NexEditorDeviceProfile.UNKNOWN);
        int c8 = a2.c(a.i.Toolbar_contentInsetEnd, NexEditorDeviceProfile.UNKNOWN);
        this.t.b(a2.d(a.i.Toolbar_contentInsetLeft, 0), a2.d(a.i.Toolbar_contentInsetRight, 0));
        if (c7 != Integer.MIN_VALUE || c8 != Integer.MIN_VALUE) {
            this.t.a(c7, c8);
        }
        this.g = a2.a(a.i.Toolbar_collapseIcon);
        this.h = a2.b(a.i.Toolbar_collapseContentDescription);
        CharSequence b2 = a2.b(a.i.Toolbar_title);
        if (!TextUtils.isEmpty(b2)) {
            setTitle(b2);
        }
        CharSequence b3 = a2.b(a.i.Toolbar_subtitle);
        if (!TextUtils.isEmpty(b3)) {
            setSubtitle(b3);
        }
        this.j = getContext();
        setPopupTheme(a2.f(a.i.Toolbar_popupTheme, 0));
        Drawable a3 = a2.a(a.i.Toolbar_navigationIcon);
        if (a3 != null) {
            setNavigationIcon(a3);
        }
        CharSequence b4 = a2.b(a.i.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(b4)) {
            setNavigationContentDescription(b4);
        }
        a2.b();
        this.L = a2.c();
    }

    public void setPopupTheme(int i) {
        if (this.k != i) {
            this.k = i;
            if (i == 0) {
                this.j = getContext();
            } else {
                this.j = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.k;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        this.t.a(i == 1);
    }

    public void setLogo(int i) {
        setLogo(this.L.a(i));
    }

    public boolean a() {
        return this.b != null && this.b.e();
    }

    public boolean b() {
        return this.b != null && this.b.d();
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            e();
            if (this.f.getParent() == null) {
                a(this.f);
                e(this.f);
            }
        } else if (this.f != null && this.f.getParent() != null) {
            removeView(this.f);
        }
        if (this.f != null) {
            this.f.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        if (this.f != null) {
            return this.f.getDrawable();
        }
        return null;
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            e();
        }
        if (this.f != null) {
            this.f.setContentDescription(charSequence);
        }
    }

    public CharSequence getLogoDescription() {
        if (this.f != null) {
            return this.f.getContentDescription();
        }
        return null;
    }

    private void e() {
        if (this.f == null) {
            this.f = new ImageView(getContext());
        }
    }

    public void c() {
        android.support.v7.internal.view.menu.f fVar = this.G == null ? null : this.G.b;
        if (fVar != null) {
            fVar.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.v;
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.c == null) {
                Context context = getContext();
                this.c = new TextView(context);
                this.c.setSingleLine();
                this.c.setEllipsize(TextUtils.TruncateAt.END);
                if (this.l != 0) {
                    this.c.setTextAppearance(context, this.l);
                }
                if (this.x != 0) {
                    this.c.setTextColor(this.x);
                }
            }
            if (this.c.getParent() == null) {
                a(this.c);
                e(this.c);
            }
        } else if (this.c != null && this.c.getParent() != null) {
            removeView(this.c);
        }
        if (this.c != null) {
            this.c.setText(charSequence);
        }
        this.v = charSequence;
    }

    public CharSequence getSubtitle() {
        return this.w;
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.d == null) {
                Context context = getContext();
                this.d = new TextView(context);
                this.d.setSingleLine();
                this.d.setEllipsize(TextUtils.TruncateAt.END);
                if (this.m != 0) {
                    this.d.setTextAppearance(context, this.m);
                }
                if (this.y != 0) {
                    this.d.setTextColor(this.y);
                }
            }
            if (this.d.getParent() == null) {
                a(this.d);
                e(this.d);
            }
        } else if (this.d != null && this.d.getParent() != null) {
            removeView(this.d);
        }
        if (this.d != null) {
            this.d.setText(charSequence);
        }
        this.w = charSequence;
    }

    public void a(Context context, int i) {
        this.l = i;
        if (this.c != null) {
            this.c.setTextAppearance(context, i);
        }
    }

    public void b(Context context, int i) {
        this.m = i;
        if (this.d != null) {
            this.d.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(int i) {
        this.x = i;
        if (this.c != null) {
            this.c.setTextColor(i);
        }
    }

    public void setSubtitleTextColor(int i) {
        this.y = i;
        if (this.d != null) {
            this.d.setTextColor(i);
        }
    }

    public CharSequence getNavigationContentDescription() {
        if (this.e != null) {
            return this.e.getContentDescription();
        }
        return null;
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            h();
        }
        if (this.e != null) {
            this.e.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(this.L.a(i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            h();
            if (this.e.getParent() == null) {
                a(this.e);
                e(this.e);
            }
        } else if (this.e != null && this.e.getParent() != null) {
            removeView(this.e);
        }
        if (this.e != null) {
            this.e.setImageDrawable(drawable);
        }
    }

    public Drawable getNavigationIcon() {
        if (this.e != null) {
            return this.e.getDrawable();
        }
        return null;
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        h();
        this.e.setOnClickListener(onClickListener);
    }

    public Menu getMenu() {
        f();
        return this.b.getMenu();
    }

    private void f() {
        g();
        if (this.b.c() == null) {
            android.support.v7.internal.view.menu.e eVar = (android.support.v7.internal.view.menu.e) this.b.getMenu();
            if (this.G == null) {
                this.G = new a(this, null);
            }
            this.b.setExpandedActionViewsExclusive(true);
            eVar.a(this.G, this.j);
        }
    }

    private void g() {
        if (this.b == null) {
            this.b = new ActionMenuView(getContext());
            this.b.setPopupTheme(this.k);
            this.b.setOnMenuItemClickListener(this.E);
            this.b.a(this.H, this.I);
            b generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f116a = 8388613 | (this.n & 112);
            this.b.setLayoutParams(generateDefaultLayoutParams);
            a(this.b);
        }
    }

    private MenuInflater getMenuInflater() {
        return new android.support.v7.internal.view.b(getContext());
    }

    public void setOnMenuItemClickListener(c cVar) {
        this.D = cVar;
    }

    public void a(int i, int i2) {
        this.t.a(i, i2);
    }

    public int getContentInsetStart() {
        return this.t.c();
    }

    public int getContentInsetEnd() {
        return this.t.d();
    }

    public int getContentInsetLeft() {
        return this.t.a();
    }

    public int getContentInsetRight() {
        return this.t.b();
    }

    private void h() {
        if (this.e == null) {
            this.e = new ImageButton(getContext(), null, a.C0016a.toolbarNavigationButtonStyle);
            b generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f116a = 8388611 | (this.n & 112);
            this.e.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.i == null) {
            this.i = new ImageButton(getContext(), null, a.C0016a.toolbarNavigationButtonStyle);
            this.i.setImageDrawable(this.g);
            this.i.setContentDescription(this.h);
            b generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f116a = 8388611 | (this.n & 112);
            generateDefaultLayoutParams.b = 2;
            this.i.setLayoutParams(generateDefaultLayoutParams);
            this.i.setOnClickListener(new n(this));
        }
    }

    private void a(View view) {
        b bVar;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            bVar = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams)) {
            bVar = generateLayoutParams(layoutParams);
        } else {
            bVar = (b) layoutParams;
        }
        bVar.b = 1;
        addView(view, bVar);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.G != null && this.G.b != null) {
            savedState.f206a = this.G.b.getItemId();
        }
        savedState.b = a();
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        android.support.v7.internal.view.menu.e c2 = this.b != null ? this.b.c() : null;
        if (savedState.f206a != 0 && this.G != null && c2 != null && (findItem = c2.findItem(savedState.f206a)) != null) {
            android.support.v4.g.k.a(findItem);
        }
        if (savedState.b) {
            j();
        }
    }

    private void j() {
        removeCallbacks(this.K);
        post(this.K);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.K);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a2 = android.support.v4.g.n.a(motionEvent);
        if (a2 == 0) {
            this.z = false;
        }
        if (!this.z) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a2 == 0 && !onTouchEvent) {
                this.z = true;
            }
        }
        if (a2 == 1 || a2 == 3) {
            this.z = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a2 = android.support.v4.g.n.a(motionEvent);
        if (a2 == 9) {
            this.A = false;
        }
        if (!this.A) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a2 == 9 && !onHoverEvent) {
                this.A = true;
            }
        }
        if (a2 == 10 || a2 == 3) {
            this.A = false;
        }
        return true;
    }

    private void a(View view, int i, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private int a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + max + i2, marginLayoutParams.width), getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private boolean k() {
        if (!this.J) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (b(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        char c2;
        char c3;
        int i3;
        int i4;
        int i5 = 0;
        int i6 = 0;
        int[] iArr = this.C;
        if (af.a(this)) {
            c2 = 0;
            c3 = 1;
        } else {
            c2 = 1;
            c3 = 0;
        }
        int i7 = 0;
        if (b(this.e)) {
            a(this.e, i, 0, i2, 0, this.o);
            i7 = this.e.getMeasuredWidth() + c(this.e);
            int max = Math.max(0, this.e.getMeasuredHeight() + d(this.e));
            i6 = af.a(0, p.c(this.e));
            i5 = max;
        }
        if (b(this.i)) {
            a(this.i, i, 0, i2, 0, this.o);
            i7 = this.i.getMeasuredWidth() + c(this.i);
            i5 = Math.max(i5, this.i.getMeasuredHeight() + d(this.i));
            i6 = af.a(i6, p.c(this.i));
        }
        int contentInsetStart = getContentInsetStart();
        int max2 = 0 + Math.max(contentInsetStart, i7);
        iArr[c3] = Math.max(0, contentInsetStart - i7);
        int i8 = 0;
        if (b(this.b)) {
            a(this.b, i, max2, i2, 0, this.o);
            i8 = this.b.getMeasuredWidth() + c(this.b);
            i5 = Math.max(i5, this.b.getMeasuredHeight() + d(this.b));
            i6 = af.a(i6, p.c(this.b));
        }
        int contentInsetEnd = getContentInsetEnd();
        int max3 = max2 + Math.max(contentInsetEnd, i8);
        iArr[c2] = Math.max(0, contentInsetEnd - i8);
        if (b(this.f205a)) {
            max3 += a(this.f205a, i, max3, i2, 0, iArr);
            i5 = Math.max(i5, this.f205a.getMeasuredHeight() + d(this.f205a));
            i6 = af.a(i6, p.c(this.f205a));
        }
        if (b(this.f)) {
            max3 += a(this.f, i, max3, i2, 0, iArr);
            i5 = Math.max(i5, this.f.getMeasuredHeight() + d(this.f));
            i6 = af.a(i6, p.c(this.f));
        }
        int childCount = getChildCount();
        int i9 = 0;
        int i10 = i5;
        int i11 = i6;
        while (i9 < childCount) {
            View childAt = getChildAt(i9);
            if (((b) childAt.getLayoutParams()).b != 0) {
                i3 = i11;
                i4 = i10;
            } else if (b(childAt)) {
                max3 += a(childAt, i, max3, i2, 0, iArr);
                int max4 = Math.max(i10, childAt.getMeasuredHeight() + d(childAt));
                i3 = af.a(i11, p.c(childAt));
                i4 = max4;
            } else {
                i3 = i11;
                i4 = i10;
            }
            i9++;
            i11 = i3;
            i10 = i4;
        }
        int i12 = 0;
        int i13 = 0;
        int i14 = this.r + this.s;
        int i15 = this.p + this.q;
        if (b(this.c)) {
            a(this.c, i, max3 + i15, i2, i14, iArr);
            i12 = c(this.c) + this.c.getMeasuredWidth();
            i13 = this.c.getMeasuredHeight() + d(this.c);
            i11 = af.a(i11, p.c(this.c));
        }
        if (b(this.d)) {
            i12 = Math.max(i12, a(this.d, i, max3 + i15, i2, i14 + i13, iArr));
            i13 += this.d.getMeasuredHeight() + d(this.d);
            i11 = af.a(i11, p.c(this.d));
        }
        int max5 = Math.max(i10, i13);
        int paddingLeft = i12 + max3 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max5 + getPaddingTop() + getPaddingBottom();
        int a2 = p.a(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, (-16777216) & i11);
        int a3 = p.a(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, i11 << 16);
        if (k()) {
            a3 = 0;
        }
        setMeasuredDimension(a2, a3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int max;
        boolean z2 = p.a(this) == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i15 = width - paddingRight;
        int[] iArr = this.C;
        iArr[1] = 0;
        iArr[0] = 0;
        int e = p.e(this);
        if (!b(this.e)) {
            i5 = paddingLeft;
        } else if (z2) {
            i15 = b(this.e, i15, iArr, e);
            i5 = paddingLeft;
        } else {
            i5 = a(this.e, paddingLeft, iArr, e);
        }
        if (b(this.i)) {
            if (z2) {
                i15 = b(this.i, i15, iArr, e);
            } else {
                i5 = a(this.i, i5, iArr, e);
            }
        }
        if (b(this.b)) {
            if (z2) {
                i5 = a(this.b, i5, iArr, e);
            } else {
                i15 = b(this.b, i15, iArr, e);
            }
        }
        iArr[0] = Math.max(0, getContentInsetLeft() - i5);
        iArr[1] = Math.max(0, getContentInsetRight() - ((width - paddingRight) - i15));
        int max2 = Math.max(i5, getContentInsetLeft());
        int min = Math.min(i15, (width - paddingRight) - getContentInsetRight());
        if (b(this.f205a)) {
            if (z2) {
                min = b(this.f205a, min, iArr, e);
            } else {
                max2 = a(this.f205a, max2, iArr, e);
            }
        }
        if (!b(this.f)) {
            i6 = min;
            i7 = max2;
        } else if (z2) {
            i6 = b(this.f, min, iArr, e);
            i7 = max2;
        } else {
            i6 = min;
            i7 = a(this.f, max2, iArr, e);
        }
        boolean b2 = b(this.c);
        boolean b3 = b(this.d);
        int i16 = 0;
        if (b2) {
            b bVar = (b) this.c.getLayoutParams();
            i16 = 0 + bVar.bottomMargin + bVar.topMargin + this.c.getMeasuredHeight();
        }
        if (b3) {
            b bVar2 = (b) this.d.getLayoutParams();
            i8 = bVar2.bottomMargin + bVar2.topMargin + this.d.getMeasuredHeight() + i16;
        } else {
            i8 = i16;
        }
        if (b2 || b3) {
            TextView textView = b2 ? this.c : this.d;
            TextView textView2 = b3 ? this.d : this.c;
            b bVar3 = (b) textView.getLayoutParams();
            b bVar4 = (b) textView2.getLayoutParams();
            boolean z3 = (b2 && this.c.getMeasuredWidth() > 0) || (b3 && this.d.getMeasuredWidth() > 0);
            switch (this.u & 112) {
                case 48:
                    i9 = bVar3.topMargin + getPaddingTop() + this.r;
                    break;
                case 80:
                    i9 = (((height - paddingBottom) - bVar4.bottomMargin) - this.s) - i8;
                    break;
                default:
                    int i17 = (((height - paddingTop) - paddingBottom) - i8) / 2;
                    if (i17 < bVar3.topMargin + this.r) {
                        max = bVar3.topMargin + this.r;
                    } else {
                        int i18 = (((height - paddingBottom) - i8) - i17) - paddingTop;
                        max = i18 < bVar3.bottomMargin + this.s ? Math.max(0, i17 - ((bVar4.bottomMargin + this.s) - i18)) : i17;
                    }
                    i9 = paddingTop + max;
                    break;
            }
            if (z2) {
                int i19 = (z3 ? this.p : 0) - iArr[1];
                int max3 = i6 - Math.max(0, i19);
                iArr[1] = Math.max(0, -i19);
                if (b2) {
                    b bVar5 = (b) this.c.getLayoutParams();
                    int measuredWidth = max3 - this.c.getMeasuredWidth();
                    int measuredHeight = this.c.getMeasuredHeight() + i9;
                    this.c.layout(measuredWidth, i9, max3, measuredHeight);
                    int i20 = measuredWidth - this.q;
                    i9 = measuredHeight + bVar5.bottomMargin;
                    i13 = i20;
                } else {
                    i13 = max3;
                }
                if (b3) {
                    b bVar6 = (b) this.d.getLayoutParams();
                    int i21 = bVar6.topMargin + i9;
                    int measuredWidth2 = max3 - this.d.getMeasuredWidth();
                    int measuredHeight2 = this.d.getMeasuredHeight() + i21;
                    this.d.layout(measuredWidth2, i21, max3, measuredHeight2);
                    int i22 = max3 - this.q;
                    int i23 = bVar6.bottomMargin + measuredHeight2;
                    i14 = i22;
                } else {
                    i14 = max3;
                }
                i6 = z3 ? Math.min(i13, i14) : max3;
            } else {
                int i24 = (z3 ? this.p : 0) - iArr[0];
                i7 += Math.max(0, i24);
                iArr[0] = Math.max(0, -i24);
                if (b2) {
                    b bVar7 = (b) this.c.getLayoutParams();
                    int measuredWidth3 = this.c.getMeasuredWidth() + i7;
                    int measuredHeight3 = this.c.getMeasuredHeight() + i9;
                    this.c.layout(i7, i9, measuredWidth3, measuredHeight3);
                    int i25 = measuredWidth3 + this.q;
                    int i26 = bVar7.bottomMargin + measuredHeight3;
                    i10 = i25;
                    i11 = i26;
                } else {
                    i10 = i7;
                    i11 = i9;
                }
                if (b3) {
                    b bVar8 = (b) this.d.getLayoutParams();
                    int i27 = i11 + bVar8.topMargin;
                    int measuredWidth4 = this.d.getMeasuredWidth() + i7;
                    int measuredHeight4 = this.d.getMeasuredHeight() + i27;
                    this.d.layout(i7, i27, measuredWidth4, measuredHeight4);
                    int i28 = this.q + measuredWidth4;
                    int i29 = bVar8.bottomMargin + measuredHeight4;
                    i12 = i28;
                } else {
                    i12 = i7;
                }
                if (z3) {
                    i7 = Math.max(i10, i12);
                }
            }
        }
        a(this.B, 3);
        int size = this.B.size();
        int i30 = i7;
        for (int i31 = 0; i31 < size; i31++) {
            i30 = a(this.B.get(i31), i30, iArr, e);
        }
        a(this.B, 5);
        int size2 = this.B.size();
        for (int i32 = 0; i32 < size2; i32++) {
            i6 = b(this.B.get(i32), i6, iArr, e);
        }
        a(this.B, 1);
        int a2 = a(this.B, iArr);
        int i33 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (a2 / 2);
        int i34 = a2 + i33;
        if (i33 < i30) {
            i33 = i30;
        } else if (i34 > i6) {
            i33 -= i34 - i6;
        }
        int size3 = this.B.size();
        int i35 = i33;
        for (int i36 = 0; i36 < size3; i36++) {
            i35 = a(this.B.get(i36), i35, iArr, e);
        }
        this.B.clear();
    }

    private int a(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        int i5 = i2;
        int i6 = i;
        while (i3 < size) {
            View view = list.get(i3);
            b bVar = (b) view.getLayoutParams();
            int i7 = bVar.leftMargin - i6;
            int i8 = bVar.rightMargin - i5;
            int max = Math.max(0, i7);
            int max2 = Math.max(0, i8);
            i6 = Math.max(0, -i7);
            i5 = Math.max(0, -i8);
            i3++;
            i4 += view.getMeasuredWidth() + max + max2;
        }
        return i4;
    }

    private int a(View view, int i, int[] iArr, int i2) {
        b bVar = (b) view.getLayoutParams();
        int i3 = bVar.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        int a2 = a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, a2, max + measuredWidth, view.getMeasuredHeight() + a2);
        return bVar.rightMargin + measuredWidth + max;
    }

    private int b(View view, int i, int[] iArr, int i2) {
        b bVar = (b) view.getLayoutParams();
        int i3 = bVar.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int a2 = a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, a2, max, view.getMeasuredHeight() + a2);
        return max - (bVar.leftMargin + measuredWidth);
    }

    private int a(View view, int i) {
        int max;
        b bVar = (b) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        switch (a(bVar.f116a)) {
            case 48:
                return getPaddingTop() - i2;
            case 80:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - bVar.bottomMargin) - i2;
            default:
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int i3 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                if (i3 < bVar.topMargin) {
                    max = bVar.topMargin;
                } else {
                    int i4 = (((height - paddingBottom) - measuredHeight) - i3) - paddingTop;
                    max = i4 < bVar.bottomMargin ? Math.max(0, i3 - (bVar.bottomMargin - i4)) : i3;
                }
                return max + paddingTop;
        }
    }

    private int a(int i) {
        int i2 = i & 112;
        switch (i2) {
            case 16:
            case 48:
            case 80:
                return i2;
            default:
                return this.u & 112;
        }
    }

    private void a(List<View> list, int i) {
        boolean z = p.a(this) == 1;
        int childCount = getChildCount();
        int a2 = android.support.v4.g.b.a(i, p.a(this));
        list.clear();
        if (z) {
            for (int i2 = childCount - 1; i2 >= 0; i2--) {
                View childAt = getChildAt(i2);
                b bVar = (b) childAt.getLayoutParams();
                if (bVar.b == 0 && b(childAt) && b(bVar.f116a) == a2) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = getChildAt(i3);
            b bVar2 = (b) childAt2.getLayoutParams();
            if (bVar2.b == 0 && b(childAt2) && b(bVar2.f116a) == a2) {
                list.add(childAt2);
            }
        }
    }

    private int b(int i) {
        int a2 = p.a(this);
        int a3 = android.support.v4.g.b.a(i, a2) & 7;
        switch (a3) {
            case 1:
            case 3:
            case 5:
                return a3;
            case 2:
            case 4:
            default:
                return a2 == 1 ? 5 : 3;
        }
    }

    private boolean b(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int c(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return android.support.v4.g.i.b(marginLayoutParams) + android.support.v4.g.i.a(marginLayoutParams);
    }

    private int d(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    @Override // android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof b) {
            return new b((b) layoutParams);
        }
        if (layoutParams instanceof a.C0015a) {
            return new b((a.C0015a) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof b);
    }

    public android.support.v7.internal.widget.m getWrapper() {
        if (this.F == null) {
            this.F = new ad(this, true);
        }
        return this.F;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChildVisibilityForExpandedActionView(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (((b) childAt.getLayoutParams()).b != 2 && childAt != this.b) {
                childAt.setVisibility(z ? 8 : 0);
            }
        }
    }

    private void e(View view) {
        if (((b) view.getLayoutParams()).b != 2 && view != this.b) {
            view.setVisibility(this.f205a != null ? 8 : 0);
        }
    }

    public void setCollapsible(boolean z) {
        this.J = z;
        requestLayout();
    }

    /* loaded from: classes.dex */
    public static class b extends a.C0015a {
        int b;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = 0;
        }

        public b(int i, int i2) {
            super(i, i2);
            this.b = 0;
            this.f116a = 8388627;
        }

        public b(b bVar) {
            super((a.C0015a) bVar);
            this.b = 0;
            this.b = bVar.b;
        }

        public b(a.C0015a c0015a) {
            super(c0015a);
            this.b = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.b = 0;
            a(marginLayoutParams);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = 0;
        }

        void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    /* loaded from: classes.dex */
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new o();

        /* renamed from: a, reason: collision with root package name */
        public int f206a;
        public boolean b;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f206a = parcel.readInt();
            this.b = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f206a);
            parcel.writeInt(this.b ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements android.support.v7.internal.view.menu.k {

        /* renamed from: a, reason: collision with root package name */
        android.support.v7.internal.view.menu.e f207a;
        android.support.v7.internal.view.menu.f b;

        private a() {
        }

        /* synthetic */ a(Toolbar toolbar, l lVar) {
            this();
        }

        @Override // android.support.v7.internal.view.menu.k
        public void a(Context context, android.support.v7.internal.view.menu.e eVar) {
            if (this.f207a != null && this.b != null) {
                this.f207a.d(this.b);
            }
            this.f207a = eVar;
        }

        @Override // android.support.v7.internal.view.menu.k
        public void b(boolean z) {
            boolean z2 = false;
            if (this.b != null) {
                if (this.f207a != null) {
                    int size = this.f207a.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                        if (this.f207a.getItem(i) != this.b) {
                            i++;
                        } else {
                            z2 = true;
                            break;
                        }
                    }
                }
                if (!z2) {
                    b(this.f207a, this.b);
                }
            }
        }

        @Override // android.support.v7.internal.view.menu.k
        public boolean a(android.support.v7.internal.view.menu.o oVar) {
            return false;
        }

        @Override // android.support.v7.internal.view.menu.k
        public void a(android.support.v7.internal.view.menu.e eVar, boolean z) {
        }

        @Override // android.support.v7.internal.view.menu.k
        public boolean b() {
            return false;
        }

        @Override // android.support.v7.internal.view.menu.k
        public boolean a(android.support.v7.internal.view.menu.e eVar, android.support.v7.internal.view.menu.f fVar) {
            Toolbar.this.i();
            if (Toolbar.this.i.getParent() != Toolbar.this) {
                Toolbar.this.addView(Toolbar.this.i);
            }
            Toolbar.this.f205a = fVar.getActionView();
            this.b = fVar;
            if (Toolbar.this.f205a.getParent() != Toolbar.this) {
                b generateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                generateDefaultLayoutParams.f116a = 8388611 | (Toolbar.this.n & 112);
                generateDefaultLayoutParams.b = 2;
                Toolbar.this.f205a.setLayoutParams(generateDefaultLayoutParams);
                Toolbar.this.addView(Toolbar.this.f205a);
            }
            Toolbar.this.setChildVisibilityForExpandedActionView(true);
            Toolbar.this.requestLayout();
            fVar.e(true);
            if (Toolbar.this.f205a instanceof android.support.v7.e.a) {
                ((android.support.v7.e.a) Toolbar.this.f205a).a();
            }
            return true;
        }

        @Override // android.support.v7.internal.view.menu.k
        public boolean b(android.support.v7.internal.view.menu.e eVar, android.support.v7.internal.view.menu.f fVar) {
            if (Toolbar.this.f205a instanceof android.support.v7.e.a) {
                ((android.support.v7.e.a) Toolbar.this.f205a).b();
            }
            Toolbar.this.removeView(Toolbar.this.f205a);
            Toolbar.this.removeView(Toolbar.this.i);
            Toolbar.this.f205a = null;
            Toolbar.this.setChildVisibilityForExpandedActionView(false);
            this.b = null;
            Toolbar.this.requestLayout();
            fVar.e(false);
            return true;
        }
    }
}
