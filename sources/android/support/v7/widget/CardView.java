package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* renamed from: a */
    private static final int[] f2698a = {R.attr.colorBackground};

    /* renamed from: b */
    private static final CardViewImpl f2699b;

    /* renamed from: c */
    private boolean f2700c;

    /* renamed from: d */
    private boolean f2701d;

    /* renamed from: e */
    int f2702e;

    /* renamed from: f */
    int f2703f;

    /* renamed from: g */
    final Rect f2704g;

    /* renamed from: h */
    final Rect f2705h;
    private final CardViewDelegate i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v7.widget.CardView$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements CardViewDelegate {

        /* renamed from: a */
        private Drawable f2706a;

        AnonymousClass1() {
        }

        @Override // android.support.v7.widget.CardViewDelegate
        public Drawable getCardBackground() {
            return this.f2706a;
        }

        @Override // android.support.v7.widget.CardViewDelegate
        public View getCardView() {
            return CardView.this;
        }

        @Override // android.support.v7.widget.CardViewDelegate
        public boolean getPreventCornerOverlap() {
            return CardView.this.getPreventCornerOverlap();
        }

        @Override // android.support.v7.widget.CardViewDelegate
        public boolean getUseCompatPadding() {
            return CardView.this.getUseCompatPadding();
        }

        @Override // android.support.v7.widget.CardViewDelegate
        public void setCardBackground(Drawable drawable) {
            this.f2706a = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        @Override // android.support.v7.widget.CardViewDelegate
        public void setMinWidthHeightInternal(int i, int i2) {
            CardView cardView = CardView.this;
            if (i > cardView.f2702e) {
                CardView.super.setMinimumWidth(i);
            }
            CardView cardView2 = CardView.this;
            if (i2 > cardView2.f2703f) {
                CardView.super.setMinimumHeight(i2);
            }
        }

        @Override // android.support.v7.widget.CardViewDelegate
        public void setShadowPadding(int i, int i2, int i3, int i4) {
            CardView.this.f2705h.set(i, i2, i3, i4);
            CardView cardView = CardView.this;
            Rect rect = cardView.f2704g;
            CardView.super.setPadding(i + rect.left, i2 + rect.top, i3 + rect.right, i4 + rect.bottom);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            f2699b = new CardViewApi21Impl();
        } else if (i >= 17) {
            f2699b = new CardViewApi17Impl();
        } else {
            f2699b = new CardViewBaseImpl();
        }
        f2699b.initStatic();
    }

    public CardView(Context context) {
        this(context, null);
    }

    public ColorStateList getCardBackgroundColor() {
        return f2699b.getBackgroundColor(this.i);
    }

    public float getCardElevation() {
        return f2699b.getElevation(this.i);
    }

    public int getContentPaddingBottom() {
        return this.f2704g.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f2704g.left;
    }

    public int getContentPaddingRight() {
        return this.f2704g.right;
    }

    public int getContentPaddingTop() {
        return this.f2704g.top;
    }

    public float getMaxCardElevation() {
        return f2699b.getMaxElevation(this.i);
    }

    public boolean getPreventCornerOverlap() {
        return this.f2701d;
    }

    public float getRadius() {
        return f2699b.getRadius(this.i);
    }

    public boolean getUseCompatPadding() {
        return this.f2700c;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (!(f2699b instanceof CardViewApi21Impl)) {
            int mode = View.MeasureSpec.getMode(i);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(f2699b.getMinWidth(this.i)), View.MeasureSpec.getSize(i)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i2);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(f2699b.getMinHeight(this.i)), View.MeasureSpec.getSize(i2)), mode2);
            }
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i, i2);
    }

    public void setCardBackgroundColor(int i) {
        f2699b.setBackgroundColor(this.i, ColorStateList.valueOf(i));
    }

    public void setCardElevation(float f2) {
        f2699b.setElevation(this.i, f2);
    }

    public void setContentPadding(int i, int i2, int i3, int i4) {
        this.f2704g.set(i, i2, i3, i4);
        f2699b.updatePadding(this.i);
    }

    public void setMaxCardElevation(float f2) {
        f2699b.setMaxElevation(this.i, f2);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        this.f2703f = i;
        super.setMinimumHeight(i);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
        this.f2702e = i;
        super.setMinimumWidth(i);
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f2701d) {
            this.f2701d = z;
            f2699b.onPreventCornerOverlapChanged(this.i);
        }
    }

    public void setRadius(float f2) {
        f2699b.setRadius(this.i, f2);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f2700c != z) {
            this.f2700c = z;
            f2699b.onCompatPaddingChanged(this.i);
        }
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.cardview.R.attr.cardViewStyle);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f2699b.setBackgroundColor(this.i, colorStateList);
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int color;
        ColorStateList valueOf;
        this.f2704g = new Rect();
        this.f2705h = new Rect();
        this.i = new CardViewDelegate() { // from class: android.support.v7.widget.CardView.1

            /* renamed from: a */
            private Drawable f2706a;

            AnonymousClass1() {
            }

            @Override // android.support.v7.widget.CardViewDelegate
            public Drawable getCardBackground() {
                return this.f2706a;
            }

            @Override // android.support.v7.widget.CardViewDelegate
            public View getCardView() {
                return CardView.this;
            }

            @Override // android.support.v7.widget.CardViewDelegate
            public boolean getPreventCornerOverlap() {
                return CardView.this.getPreventCornerOverlap();
            }

            @Override // android.support.v7.widget.CardViewDelegate
            public boolean getUseCompatPadding() {
                return CardView.this.getUseCompatPadding();
            }

            @Override // android.support.v7.widget.CardViewDelegate
            public void setCardBackground(Drawable drawable) {
                this.f2706a = drawable;
                CardView.this.setBackgroundDrawable(drawable);
            }

            @Override // android.support.v7.widget.CardViewDelegate
            public void setMinWidthHeightInternal(int i2, int i22) {
                CardView cardView = CardView.this;
                if (i2 > cardView.f2702e) {
                    CardView.super.setMinimumWidth(i2);
                }
                CardView cardView2 = CardView.this;
                if (i22 > cardView2.f2703f) {
                    CardView.super.setMinimumHeight(i22);
                }
            }

            @Override // android.support.v7.widget.CardViewDelegate
            public void setShadowPadding(int i2, int i22, int i3, int i4) {
                CardView.this.f2705h.set(i2, i22, i3, i4);
                CardView cardView = CardView.this;
                Rect rect = cardView.f2704g;
                CardView.super.setPadding(i2 + rect.left, i22 + rect.top, i3 + rect.right, i4 + rect.bottom);
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.cardview.R.styleable.CardView, i, android.support.v7.cardview.R.style.CardView);
        if (obtainStyledAttributes.hasValue(android.support.v7.cardview.R.styleable.CardView_cardBackgroundColor)) {
            valueOf = obtainStyledAttributes.getColorStateList(android.support.v7.cardview.R.styleable.CardView_cardBackgroundColor);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f2698a);
            int color2 = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(android.support.v7.cardview.R.color.cardview_light_background);
            } else {
                color = getResources().getColor(android.support.v7.cardview.R.color.cardview_dark_background);
            }
            valueOf = ColorStateList.valueOf(color);
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(android.support.v7.cardview.R.styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(android.support.v7.cardview.R.styleable.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(android.support.v7.cardview.R.styleable.CardView_cardMaxElevation, 0.0f);
        this.f2700c = obtainStyledAttributes.getBoolean(android.support.v7.cardview.R.styleable.CardView_cardUseCompatPadding, false);
        this.f2701d = obtainStyledAttributes.getBoolean(android.support.v7.cardview.R.styleable.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(android.support.v7.cardview.R.styleable.CardView_contentPadding, 0);
        this.f2704g.left = obtainStyledAttributes.getDimensionPixelSize(android.support.v7.cardview.R.styleable.CardView_contentPaddingLeft, dimensionPixelSize);
        this.f2704g.top = obtainStyledAttributes.getDimensionPixelSize(android.support.v7.cardview.R.styleable.CardView_contentPaddingTop, dimensionPixelSize);
        this.f2704g.right = obtainStyledAttributes.getDimensionPixelSize(android.support.v7.cardview.R.styleable.CardView_contentPaddingRight, dimensionPixelSize);
        this.f2704g.bottom = obtainStyledAttributes.getDimensionPixelSize(android.support.v7.cardview.R.styleable.CardView_contentPaddingBottom, dimensionPixelSize);
        float f2 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f2702e = obtainStyledAttributes.getDimensionPixelSize(android.support.v7.cardview.R.styleable.CardView_android_minWidth, 0);
        this.f2703f = obtainStyledAttributes.getDimensionPixelSize(android.support.v7.cardview.R.styleable.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        f2699b.initialize(this.i, context, colorStateList, dimension, dimension2, f2);
    }
}
