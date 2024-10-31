package com.adobe.creativesdk.foundation.internal.utils;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Property;
import android.widget.RelativeLayout;

/* loaded from: classes.dex */
public class DrawShadowRelativeLayout extends RelativeLayout {

    /* renamed from: a */
    private static Property<DrawShadowRelativeLayout, Float> f6843a = new r(Float.class, "shadowAlpha");

    /* renamed from: b */
    private final boolean f6844b;

    /* renamed from: c */
    private Drawable f6845c;

    /* renamed from: d */
    private NinePatchDrawable f6846d;

    /* renamed from: e */
    private int f6847e;

    /* renamed from: f */
    private boolean f6848f;

    /* renamed from: g */
    private int f6849g;

    /* renamed from: h */
    private int f6850h;
    private ObjectAnimator i;
    private float j;

    public DrawShadowRelativeLayout(Context context) {
        this(context, null, 0);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f6845c == null || !this.f6848f) {
            return;
        }
        NinePatchDrawable ninePatchDrawable = this.f6846d;
        if (ninePatchDrawable != null) {
            ninePatchDrawable.getPaint().setAlpha((int) (this.j * 255.0f));
        }
        this.f6845c.draw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f6849g = i;
        this.f6850h = i2;
        if (this.f6844b) {
            this.f6847e = this.f6850h;
        }
        a();
    }

    public void setShadowTopOffset(int i) {
        this.f6847e = i;
        a();
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public DrawShadowRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawShadowRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = 1.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.adobe.creativesdk.foundation.auth.t.AdobeCSDKDrawShadowFrameLayout, 0, 0);
        this.f6848f = obtainStyledAttributes.getBoolean(com.adobe.creativesdk.foundation.auth.t.AdobeCSDKDrawShadowFrameLayout_adobeCSDKShadowVisible, true);
        this.f6844b = obtainStyledAttributes.getBoolean(com.adobe.creativesdk.foundation.auth.t.AdobeCSDKDrawShadowFrameLayout_adobeCSDKShadowBottom, false);
        this.f6845c = obtainStyledAttributes.getDrawable(com.adobe.creativesdk.foundation.auth.t.AdobeCSDKDrawShadowFrameLayout_adobeCSDKShadowDrawable);
        if (this.f6845c == null && this.f6848f) {
            this.f6845c = context.getResources().getDrawable(com.adobe.creativesdk.foundation.auth.o.adobe_csdk_drop_shadow);
        }
        Drawable drawable = this.f6845c;
        if (drawable != null) {
            drawable.setCallback(this);
            Drawable drawable2 = this.f6845c;
            if (drawable2 instanceof NinePatchDrawable) {
                this.f6846d = (NinePatchDrawable) drawable2;
            }
        }
        setWillNotDraw(!this.f6848f);
        obtainStyledAttributes.recycle();
    }

    private void a() {
        Drawable drawable = this.f6845c;
        if (drawable != null) {
            drawable.setBounds(0, this.f6847e, this.f6849g, this.f6850h);
        }
    }

    public void a(boolean z, boolean z2) {
        this.f6848f = z;
        ObjectAnimator objectAnimator = this.i;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.i = null;
        }
        if (z2 && this.f6845c != null) {
            Property<DrawShadowRelativeLayout, Float> property = f6843a;
            float[] fArr = new float[2];
            fArr[0] = z ? 0.0f : 1.0f;
            fArr[1] = z ? 1.0f : 0.0f;
            this.i = ObjectAnimator.ofFloat(this, property, fArr);
            this.i.setDuration(1000L);
            this.i.start();
        }
        ViewCompat.postInvalidateOnAnimation(this);
        setWillNotDraw(!this.f6848f);
    }
}
