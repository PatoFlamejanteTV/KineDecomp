package android.support.design.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.Space;
import android.support.v4.widget.TextViewCompat;
import android.support.v4.widget.ViewGroupUtils;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DrawableUtils;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.WithHint;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout implements WithHint {
    private Drawable A;
    private Drawable B;
    private ColorStateList C;
    private boolean D;
    private PorterDuff.Mode E;
    private boolean F;
    private ColorStateList G;
    private ColorStateList H;
    private boolean I;
    final C0187m J;
    private boolean K;
    private ValueAnimator L;
    private boolean M;
    private boolean N;
    private boolean O;

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f450a;

    /* renamed from: b, reason: collision with root package name */
    EditText f451b;

    /* renamed from: c, reason: collision with root package name */
    private CharSequence f452c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f453d;

    /* renamed from: e, reason: collision with root package name */
    private CharSequence f454e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f455f;

    /* renamed from: g, reason: collision with root package name */
    private final Rect f456g;

    /* renamed from: h, reason: collision with root package name */
    private LinearLayout f457h;
    private int i;
    private Typeface j;
    private boolean k;
    TextView l;
    private int m;
    private boolean n;
    private CharSequence o;
    boolean p;
    private TextView q;
    private int r;
    private int s;
    private int t;
    private boolean u;
    private boolean v;
    private Drawable w;
    private CharSequence x;
    private CheckableImageButton y;
    private boolean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends AbsSavedState {
        public static final Parcelable.Creator<a> CREATOR = new N();

        /* renamed from: b, reason: collision with root package name */
        CharSequence f458b;

        /* renamed from: c, reason: collision with root package name */
        boolean f459c;

        a(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f458b) + "}";
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.f458b, parcel, i);
            parcel.writeInt(this.f459c ? 1 : 0);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f458b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f459c = parcel.readInt() == 1;
        }
    }

    /* loaded from: classes.dex */
    private class b extends AccessibilityDelegateCompat {
        b() {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(TextInputLayout.class.getSimpleName());
            CharSequence e2 = TextInputLayout.this.J.e();
            if (!TextUtils.isEmpty(e2)) {
                accessibilityNodeInfoCompat.setText(e2);
            }
            EditText editText = TextInputLayout.this.f451b;
            if (editText != null) {
                accessibilityNodeInfoCompat.setLabelFor(editText);
            }
            TextView textView = TextInputLayout.this.l;
            CharSequence text = textView != null ? textView.getText() : null;
            if (TextUtils.isEmpty(text)) {
                return;
            }
            accessibilityNodeInfoCompat.setContentInvalid(true);
            accessibilityNodeInfoCompat.setError(text);
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            CharSequence e2 = TextInputLayout.this.J.e();
            if (TextUtils.isEmpty(e2)) {
                return;
            }
            accessibilityEvent.getText().add(e2);
        }
    }

    public TextInputLayout(Context context) {
        this(context, null);
    }

    private void b() {
        if (this.w != null) {
            if (this.D || this.F) {
                this.w = DrawableCompat.wrap(this.w).mutate();
                if (this.D) {
                    DrawableCompat.setTintList(this.w, this.C);
                }
                if (this.F) {
                    DrawableCompat.setTintMode(this.w, this.E);
                }
                CheckableImageButton checkableImageButton = this.y;
                if (checkableImageButton != null) {
                    Drawable drawable = checkableImageButton.getDrawable();
                    Drawable drawable2 = this.w;
                    if (drawable != drawable2) {
                        this.y.setImageDrawable(drawable2);
                    }
                }
            }
        }
    }

    private void c() {
        Drawable background;
        int i = Build.VERSION.SDK_INT;
        if ((i != 21 && i != 22) || (background = this.f451b.getBackground()) == null || this.M) {
            return;
        }
        Drawable newDrawable = background.getConstantState().newDrawable();
        if (background instanceof DrawableContainer) {
            this.M = C0190p.a((DrawableContainer) background, newDrawable.getConstantState());
        }
        if (this.M) {
            return;
        }
        ViewCompat.setBackground(this.f451b, newDrawable);
        this.M = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (this.v) {
            int selectionEnd = this.f451b.getSelectionEnd();
            if (d()) {
                this.f451b.setTransformationMethod(null);
                this.z = true;
            } else {
                this.f451b.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.z = false;
            }
            this.y.setChecked(this.z);
            if (z) {
                this.y.jumpDrawablesToCurrentState();
            }
            this.f451b.setSelection(selectionEnd);
        }
    }

    private boolean e() {
        return this.v && (d() || this.z);
    }

    private void f() {
        Drawable background;
        TextView textView;
        TextView textView2;
        EditText editText = this.f451b;
        if (editText == null || (background = editText.getBackground()) == null) {
            return;
        }
        c();
        if (DrawableUtils.canSafelyMutateDrawable(background)) {
            background = background.mutate();
        }
        if (this.n && (textView2 = this.l) != null) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(textView2.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else if (this.u && (textView = this.q) != null) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            DrawableCompat.clearColorFilter(background);
            this.f451b.refreshDrawableState();
        }
    }

    private void g() {
        int i;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f450a.getLayoutParams();
        if (this.f453d) {
            if (this.f455f == null) {
                this.f455f = new Paint();
            }
            this.f455f.setTypeface(this.J.c());
            this.f455f.setTextSize(this.J.b());
            i = (int) (-this.f455f.ascent());
        } else {
            i = 0;
        }
        if (i != layoutParams.topMargin) {
            layoutParams.topMargin = i;
            this.f450a.requestLayout();
        }
    }

    private void h() {
        if (this.f451b == null) {
            return;
        }
        if (e()) {
            if (this.y == null) {
                this.y = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(b.b.d.f.design_text_input_password_icon, (ViewGroup) this.f450a, false);
                this.y.setImageDrawable(this.w);
                this.y.setContentDescription(this.x);
                this.f450a.addView(this.y);
                this.y.setOnClickListener(new L(this));
            }
            EditText editText = this.f451b;
            if (editText != null && ViewCompat.getMinimumHeight(editText) <= 0) {
                this.f451b.setMinimumHeight(ViewCompat.getMinimumHeight(this.y));
            }
            this.y.setVisibility(0);
            this.y.setChecked(this.z);
            if (this.A == null) {
                this.A = new ColorDrawable();
            }
            this.A.setBounds(0, 0, this.y.getMeasuredWidth(), 1);
            Drawable[] compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this.f451b);
            if (compoundDrawablesRelative[2] != this.A) {
                this.B = compoundDrawablesRelative[2];
            }
            TextViewCompat.setCompoundDrawablesRelative(this.f451b, compoundDrawablesRelative[0], compoundDrawablesRelative[1], this.A, compoundDrawablesRelative[3]);
            this.y.setPadding(this.f451b.getPaddingLeft(), this.f451b.getPaddingTop(), this.f451b.getPaddingRight(), this.f451b.getPaddingBottom());
            return;
        }
        CheckableImageButton checkableImageButton = this.y;
        if (checkableImageButton != null && checkableImageButton.getVisibility() == 0) {
            this.y.setVisibility(8);
        }
        if (this.A != null) {
            Drawable[] compoundDrawablesRelative2 = TextViewCompat.getCompoundDrawablesRelative(this.f451b);
            if (compoundDrawablesRelative2[2] == this.A) {
                TextViewCompat.setCompoundDrawablesRelative(this.f451b, compoundDrawablesRelative2[0], compoundDrawablesRelative2[1], this.B, compoundDrawablesRelative2[3]);
                this.A = null;
            }
        }
    }

    private void setEditText(EditText editText) {
        if (this.f451b == null) {
            if (!(editText instanceof TextInputEditText)) {
                Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.f451b = editText;
            if (!d()) {
                this.J.a(this.f451b.getTypeface());
            }
            this.J.a(this.f451b.getTextSize());
            int gravity = this.f451b.getGravity();
            this.J.b((gravity & (-113)) | 48);
            this.J.c(gravity);
            this.f451b.addTextChangedListener(new I(this));
            if (this.G == null) {
                this.G = this.f451b.getHintTextColors();
            }
            if (this.f453d && TextUtils.isEmpty(this.f454e)) {
                this.f452c = this.f451b.getHint();
                setHint(this.f452c);
                this.f451b.setHint((CharSequence) null);
            }
            if (this.q != null) {
                a(this.f451b.getText().length());
            }
            if (this.f457h != null) {
                a();
            }
            h();
            a(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setHintInternal(CharSequence charSequence) {
        this.f454e = charSequence;
        this.J.a(charSequence);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
            this.f450a.addView(view, layoutParams2);
            this.f450a.setLayoutParams(layoutParams);
            g();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        EditText editText;
        if (this.f452c != null && (editText = this.f451b) != null) {
            CharSequence hint = editText.getHint();
            this.f451b.setHint(this.f452c);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i);
                return;
            } finally {
                this.f451b.setHint(hint);
            }
        }
        super.dispatchProvideAutofillStructure(viewStructure, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.O = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.O = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f453d) {
            this.J.a(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.N) {
            return;
        }
        this.N = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        a(ViewCompat.isLaidOut(this) && isEnabled());
        f();
        C0187m c0187m = this.J;
        if (c0187m != null ? c0187m.a(drawableState) | false : false) {
            invalidate();
        }
        this.N = false;
    }

    public int getCounterMaxLength() {
        return this.r;
    }

    public EditText getEditText() {
        return this.f451b;
    }

    public CharSequence getError() {
        if (this.k) {
            return this.o;
        }
        return null;
    }

    @Override // android.support.v7.widget.WithHint
    public CharSequence getHint() {
        if (this.f453d) {
            return this.f454e;
        }
        return null;
    }

    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.x;
    }

    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.w;
    }

    public Typeface getTypeface() {
        return this.j;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        EditText editText;
        super.onLayout(z, i, i2, i3, i4);
        if (!this.f453d || (editText = this.f451b) == null) {
            return;
        }
        Rect rect = this.f456g;
        ViewGroupUtils.getDescendantRect(this, editText, rect);
        int compoundPaddingLeft = rect.left + this.f451b.getCompoundPaddingLeft();
        int compoundPaddingRight = rect.right - this.f451b.getCompoundPaddingRight();
        this.J.b(compoundPaddingLeft, rect.top + this.f451b.getCompoundPaddingTop(), compoundPaddingRight, rect.bottom - this.f451b.getCompoundPaddingBottom());
        this.J.a(compoundPaddingLeft, getPaddingTop(), compoundPaddingRight, (i4 - i2) - getPaddingBottom());
        this.J.h();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        h();
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.getSuperState());
        setError(aVar.f458b);
        if (aVar.f459c) {
            d(true);
        }
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        if (this.n) {
            aVar.f458b = getError();
        }
        aVar.f459c = this.z;
        return aVar;
    }

    public void setCounterEnabled(boolean z) {
        if (this.p != z) {
            if (z) {
                this.q = new AppCompatTextView(getContext());
                this.q.setId(b.b.d.d.textinput_counter);
                Typeface typeface = this.j;
                if (typeface != null) {
                    this.q.setTypeface(typeface);
                }
                this.q.setMaxLines(1);
                try {
                    TextViewCompat.setTextAppearance(this.q, this.s);
                } catch (Exception unused) {
                    TextViewCompat.setTextAppearance(this.q, R.style.TextAppearance_AppCompat_Caption);
                    this.q.setTextColor(ContextCompat.getColor(getContext(), R.color.error_color_material));
                }
                a(this.q, -1);
                EditText editText = this.f451b;
                if (editText == null) {
                    a(0);
                } else {
                    a(editText.getText().length());
                }
            } else {
                a(this.q);
                this.q = null;
            }
            this.p = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.r != i) {
            if (i > 0) {
                this.r = i;
            } else {
                this.r = -1;
            }
            if (this.p) {
                EditText editText = this.f451b;
                a(editText == null ? 0 : editText.getText().length());
            }
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        a((ViewGroup) this, z);
        super.setEnabled(z);
    }

    public void setError(CharSequence charSequence) {
        TextView textView;
        a(charSequence, ViewCompat.isLaidOut(this) && isEnabled() && ((textView = this.l) == null || !TextUtils.equals(textView.getText(), charSequence)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0048, code lost:            if (r5.l.getTextColors().getDefaultColor() == (-65281)) goto L20;     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setErrorEnabled(boolean r6) {
        /*
            r5 = this;
            boolean r0 = r5.k
            if (r0 == r6) goto L86
            android.widget.TextView r0 = r5.l
            if (r0 == 0) goto Lf
            android.view.ViewPropertyAnimator r0 = r0.animate()
            r0.cancel()
        Lf:
            r0 = 0
            if (r6 == 0) goto L77
            android.support.v7.widget.AppCompatTextView r1 = new android.support.v7.widget.AppCompatTextView
            android.content.Context r2 = r5.getContext()
            r1.<init>(r2)
            r5.l = r1
            android.widget.TextView r1 = r5.l
            int r2 = b.b.d.d.textinput_error
            r1.setId(r2)
            android.graphics.Typeface r1 = r5.j
            if (r1 == 0) goto L2d
            android.widget.TextView r2 = r5.l
            r2.setTypeface(r1)
        L2d:
            r1 = 1
            android.widget.TextView r2 = r5.l     // Catch: java.lang.Exception -> L4d
            int r3 = r5.m     // Catch: java.lang.Exception -> L4d
            android.support.v4.widget.TextViewCompat.setTextAppearance(r2, r3)     // Catch: java.lang.Exception -> L4d
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L4d
            r3 = 23
            if (r2 < r3) goto L4b
            android.widget.TextView r2 = r5.l     // Catch: java.lang.Exception -> L4d
            android.content.res.ColorStateList r2 = r2.getTextColors()     // Catch: java.lang.Exception -> L4d
            int r2 = r2.getDefaultColor()     // Catch: java.lang.Exception -> L4d
            r3 = -65281(0xffffffffffff00ff, float:NaN)
            if (r2 != r3) goto L4b
            goto L4d
        L4b:
            r2 = 0
            goto L4e
        L4d:
            r2 = 1
        L4e:
            if (r2 == 0) goto L66
            android.widget.TextView r2 = r5.l
            int r3 = android.support.v7.appcompat.R.style.TextAppearance_AppCompat_Caption
            android.support.v4.widget.TextViewCompat.setTextAppearance(r2, r3)
            android.widget.TextView r2 = r5.l
            android.content.Context r3 = r5.getContext()
            int r4 = android.support.v7.appcompat.R.color.error_color_material
            int r3 = android.support.v4.content.ContextCompat.getColor(r3, r4)
            r2.setTextColor(r3)
        L66:
            android.widget.TextView r2 = r5.l
            r3 = 4
            r2.setVisibility(r3)
            android.widget.TextView r2 = r5.l
            android.support.v4.view.ViewCompat.setAccessibilityLiveRegion(r2, r1)
            android.widget.TextView r1 = r5.l
            r5.a(r1, r0)
            goto L84
        L77:
            r5.n = r0
            r5.f()
            android.widget.TextView r0 = r5.l
            r5.a(r0)
            r0 = 0
            r5.l = r0
        L84:
            r5.k = r6
        L86:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.TextInputLayout.setErrorEnabled(boolean):void");
    }

    public void setErrorTextAppearance(int i) {
        this.m = i;
        TextView textView = this.l;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, i);
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.f453d) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.K = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.f453d) {
            this.f453d = z;
            CharSequence hint = this.f451b.getHint();
            if (!this.f453d) {
                if (!TextUtils.isEmpty(this.f454e) && TextUtils.isEmpty(hint)) {
                    this.f451b.setHint(this.f454e);
                }
                setHintInternal(null);
            } else if (!TextUtils.isEmpty(hint)) {
                if (TextUtils.isEmpty(this.f454e)) {
                    setHint(hint);
                }
                this.f451b.setHint((CharSequence) null);
            }
            if (this.f451b != null) {
                g();
            }
        }
    }

    public void setHintTextAppearance(int i) {
        this.J.a(i);
        this.H = this.J.a();
        if (this.f451b != null) {
            a(false);
            g();
        }
    }

    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setPasswordVisibilityToggleEnabled(boolean z) {
        EditText editText;
        if (this.v != z) {
            this.v = z;
            if (!z && this.z && (editText = this.f451b) != null) {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            this.z = false;
            h();
        }
    }

    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.C = colorStateList;
        this.D = true;
        b();
    }

    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.E = mode;
        this.F = true;
        b();
    }

    public void setTypeface(Typeface typeface) {
        Typeface typeface2 = this.j;
        if ((typeface2 == null || typeface2.equals(typeface)) && (this.j != null || typeface == null)) {
            return;
        }
        this.j = typeface;
        this.J.a(typeface);
        TextView textView = this.q;
        if (textView != null) {
            textView.setTypeface(typeface);
        }
        TextView textView2 = this.l;
        if (textView2 != null) {
            textView2.setTypeface(typeface);
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f456g = new Rect();
        this.J = new C0187m(this);
        O.a(context);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.f450a = new FrameLayout(context);
        this.f450a.setAddStatesFromChildren(true);
        addView(this.f450a);
        this.J.b(C0175a.f463b);
        this.J.a(new AccelerateInterpolator());
        this.J.b(8388659);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, b.b.d.i.TextInputLayout, i, b.b.d.h.Widget_Design_TextInputLayout);
        this.f453d = obtainStyledAttributes.getBoolean(b.b.d.i.TextInputLayout_hintEnabled, true);
        setHint(obtainStyledAttributes.getText(b.b.d.i.TextInputLayout_android_hint));
        this.K = obtainStyledAttributes.getBoolean(b.b.d.i.TextInputLayout_hintAnimationEnabled, true);
        if (obtainStyledAttributes.hasValue(b.b.d.i.TextInputLayout_android_textColorHint)) {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(b.b.d.i.TextInputLayout_android_textColorHint);
            this.H = colorStateList;
            this.G = colorStateList;
        }
        if (obtainStyledAttributes.getResourceId(b.b.d.i.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(obtainStyledAttributes.getResourceId(b.b.d.i.TextInputLayout_hintTextAppearance, 0));
        }
        this.m = obtainStyledAttributes.getResourceId(b.b.d.i.TextInputLayout_errorTextAppearance, 0);
        boolean z = obtainStyledAttributes.getBoolean(b.b.d.i.TextInputLayout_errorEnabled, false);
        boolean z2 = obtainStyledAttributes.getBoolean(b.b.d.i.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(obtainStyledAttributes.getInt(b.b.d.i.TextInputLayout_counterMaxLength, -1));
        this.s = obtainStyledAttributes.getResourceId(b.b.d.i.TextInputLayout_counterTextAppearance, 0);
        this.t = obtainStyledAttributes.getResourceId(b.b.d.i.TextInputLayout_counterOverflowTextAppearance, 0);
        this.v = obtainStyledAttributes.getBoolean(b.b.d.i.TextInputLayout_passwordToggleEnabled, false);
        this.w = obtainStyledAttributes.getDrawable(b.b.d.i.TextInputLayout_passwordToggleDrawable);
        this.x = obtainStyledAttributes.getText(b.b.d.i.TextInputLayout_passwordToggleContentDescription);
        if (obtainStyledAttributes.hasValue(b.b.d.i.TextInputLayout_passwordToggleTint)) {
            this.D = true;
            this.C = obtainStyledAttributes.getColorStateList(b.b.d.i.TextInputLayout_passwordToggleTint);
        }
        if (obtainStyledAttributes.hasValue(b.b.d.i.TextInputLayout_passwordToggleTintMode)) {
            this.F = true;
            this.E = S.a(obtainStyledAttributes.getInt(b.b.d.i.TextInputLayout_passwordToggleTintMode, -1), null);
        }
        obtainStyledAttributes.recycle();
        setErrorEnabled(z);
        setCounterEnabled(z2);
        b();
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        ViewCompat.setAccessibilityDelegate(this, new b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        a(z, false);
    }

    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.x = charSequence;
        CheckableImageButton checkableImageButton = this.y;
        if (checkableImageButton != null) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.w = drawable;
        CheckableImageButton checkableImageButton = this.y;
        if (checkableImageButton != null) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    void a(boolean z, boolean z2) {
        ColorStateList colorStateList;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.f451b;
        boolean z3 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        boolean a2 = a(getDrawableState(), android.R.attr.state_focused);
        boolean isEmpty = true ^ TextUtils.isEmpty(getError());
        ColorStateList colorStateList2 = this.G;
        if (colorStateList2 != null) {
            this.J.b(colorStateList2);
        }
        if (isEnabled && this.u && (textView = this.q) != null) {
            this.J.a(textView.getTextColors());
        } else if (isEnabled && a2 && (colorStateList = this.H) != null) {
            this.J.a(colorStateList);
        } else {
            ColorStateList colorStateList3 = this.G;
            if (colorStateList3 != null) {
                this.J.a(colorStateList3);
            }
        }
        if (!z3 && (!isEnabled() || (!a2 && !isEmpty))) {
            if (z2 || !this.I) {
                c(z);
                return;
            }
            return;
        }
        if (z2 || this.I) {
            b(z);
        }
    }

    private void b(boolean z) {
        ValueAnimator valueAnimator = this.L;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.L.cancel();
        }
        if (z && this.K) {
            a(1.0f);
        } else {
            this.J.b(1.0f);
        }
        this.I = false;
    }

    private boolean d() {
        EditText editText = this.f451b;
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private void c(boolean z) {
        ValueAnimator valueAnimator = this.L;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.L.cancel();
        }
        if (z && this.K) {
            a(0.0f);
        } else {
            this.J.b(0.0f);
        }
        this.I = true;
    }

    private void a(TextView textView, int i) {
        if (this.f457h == null) {
            this.f457h = new LinearLayout(getContext());
            this.f457h.setOrientation(0);
            addView(this.f457h, -1, -2);
            this.f457h.addView(new Space(getContext()), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.f451b != null) {
                a();
            }
        }
        this.f457h.setVisibility(0);
        this.f457h.addView(textView, i);
        this.i++;
    }

    private void a() {
        ViewCompat.setPaddingRelative(this.f457h, ViewCompat.getPaddingStart(this.f451b), 0, ViewCompat.getPaddingEnd(this.f451b), this.f451b.getPaddingBottom());
    }

    private void a(TextView textView) {
        LinearLayout linearLayout = this.f457h;
        if (linearLayout != null) {
            linearLayout.removeView(textView);
            int i = this.i - 1;
            this.i = i;
            if (i == 0) {
                this.f457h.setVisibility(8);
            }
        }
    }

    private void a(CharSequence charSequence, boolean z) {
        this.o = charSequence;
        if (!this.k) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        this.n = !TextUtils.isEmpty(charSequence);
        this.l.animate().cancel();
        if (this.n) {
            this.l.setText(charSequence);
            this.l.setVisibility(0);
            if (z) {
                if (this.l.getAlpha() == 1.0f) {
                    this.l.setAlpha(0.0f);
                }
                this.l.animate().alpha(1.0f).setDuration(200L).setInterpolator(C0175a.f465d).setListener(new J(this)).start();
            } else {
                this.l.setAlpha(1.0f);
            }
        } else if (this.l.getVisibility() == 0) {
            if (z) {
                this.l.animate().alpha(0.0f).setDuration(200L).setInterpolator(C0175a.f464c).setListener(new K(this, charSequence)).start();
            } else {
                this.l.setText(charSequence);
                this.l.setVisibility(4);
            }
        }
        f();
        a(z);
    }

    private static void a(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        boolean z = this.u;
        int i2 = this.r;
        if (i2 == -1) {
            this.q.setText(String.valueOf(i));
            this.u = false;
        } else {
            this.u = i > i2;
            boolean z2 = this.u;
            if (z != z2) {
                TextViewCompat.setTextAppearance(this.q, z2 ? this.t : this.s);
            }
            this.q.setText(getContext().getString(b.b.d.g.character_counter_pattern, Integer.valueOf(i), Integer.valueOf(this.r)));
        }
        if (this.f451b == null || z == this.u) {
            return;
        }
        a(false);
        f();
    }

    void a(float f2) {
        if (this.J.d() == f2) {
            return;
        }
        if (this.L == null) {
            this.L = new ValueAnimator();
            this.L.setInterpolator(C0175a.f462a);
            this.L.setDuration(200L);
            this.L.addUpdateListener(new M(this));
        }
        this.L.setFloatValues(this.J.d(), f2);
        this.L.start();
    }

    private static boolean a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }
}
