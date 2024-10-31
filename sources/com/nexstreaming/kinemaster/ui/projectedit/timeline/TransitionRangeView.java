package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import com.nextreaming.nexeditorui.NexTransitionItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* loaded from: classes2.dex */
public class TransitionRangeView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private NexTransitionItem f22644a;

    /* renamed from: b, reason: collision with root package name */
    private int f22645b;

    /* renamed from: c, reason: collision with root package name */
    private Drawable f22646c;

    /* renamed from: d, reason: collision with root package name */
    private int f22647d;

    /* renamed from: e, reason: collision with root package name */
    private int f22648e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f22649f;

    public TransitionRangeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private Rect a(NexVideoClipItem nexVideoClipItem) {
        View a2;
        UniformTimelineLayoutManager a3 = UniformTimelineLayoutManager.a((View) getParent());
        if (a3 == null || (a2 = a3.a(a3.a((Fa) nexVideoClipItem))) == null) {
            return null;
        }
        Rect rect = new Rect();
        a2.getHitRect(rect);
        return rect;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        NexTransitionItem nexTransitionItem = this.f22644a;
        if (nexTransitionItem != null && nexTransitionItem.isSet() && this.f22646c != null) {
            canvas.save();
            this.f22646c.setBounds(this.f22645b / 2, 0, getWidth() - (this.f22645b / 2), getHeight());
            if (getWidth() - this.f22645b < this.f22647d) {
                this.f22646c.setAlpha((int) (Math.max((getWidth() - this.f22645b) / this.f22647d, 0.0f) * 255.0f));
            } else {
                this.f22646c.setAlpha(255);
            }
            this.f22646c.draw(canvas);
            canvas.restore();
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public void getHitRect(Rect rect) {
        super.getHitRect(rect);
        if (rect != null) {
            if (this.f22644a.isSet()) {
                rect.inset(this.f22645b / 2, 0);
            } else {
                rect.inset(this.f22647d / 2, 0);
            }
        }
    }

    public int getPaddingHorizontal() {
        return this.f22645b;
    }

    public NexTransitionItem getTransitionItem() {
        return this.f22644a;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        TransitionIconView a2;
        super.onLayout(z, i, i2, i3, i4);
        if (this.f22644a == null || (a2 = a()) == null) {
            return;
        }
        this.f22647d = a2.getMeasuredWidth();
        this.f22648e = a2.getMeasuredHeight();
        int i5 = (i3 - i) - this.f22645b;
        int transitionOffsetPercent = (this.f22644a.getTransitionOffsetPercent() * i5) / 100;
        int transitionOverlapPercent = (i5 * this.f22644a.getTransitionOverlapPercent()) / 100;
        int i6 = (this.f22645b / 2) + transitionOffsetPercent;
        int i7 = this.f22647d;
        int i8 = (i6 - (i7 / 2)) - (transitionOverlapPercent / 2);
        int i9 = i4 - i2;
        int i10 = this.f22648e;
        int i11 = (i9 - i10) / 2;
        a2.layout(i8, i11, i7 + i8, i10 + i11);
        Rect a3 = a(this.f22644a.getLeftClip());
        Rect a4 = a(this.f22644a.getRightClip());
        if (a3 == null || a4 == null) {
            return;
        }
        int i12 = this.f22647d * 2;
        int min = Math.min(a3.width(), a4.width());
        if (i12 > min && this.f22649f) {
            a2.animate().cancel();
            a2.animate().alpha(0.0f).scaleX(0.0f).scaleY(0.0f).setDuration(200L).setInterpolator(new AnticipateInterpolator()).start();
            this.f22649f = false;
        } else {
            if (i12 >= min || this.f22649f) {
                return;
            }
            a2.animate().cancel();
            a2.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(200L).setInterpolator(new OvershootInterpolator()).start();
            this.f22649f = true;
        }
    }

    public void setTransitionItem(NexTransitionItem nexTransitionItem) {
        this.f22644a = nexTransitionItem;
    }

    public TransitionRangeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.nexstreaming.app.kinemasterfree.c.TransitionRangeView);
        if (obtainStyledAttributes != null) {
            this.f22645b = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            this.f22646c = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
        }
        setClipChildren(false);
        setClipToPadding(false);
    }

    private TransitionIconView a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof TransitionIconView) {
                return (TransitionIconView) childAt;
            }
        }
        return null;
    }

    public static TransitionRangeView a(View view) {
        if (view instanceof TransitionRangeView) {
            return (TransitionRangeView) view;
        }
        if (view.getParent() instanceof ViewGroup) {
            return a((View) view.getParent());
        }
        return null;
    }
}
