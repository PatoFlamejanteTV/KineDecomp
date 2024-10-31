package com.mixpanel.android.surveys;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.CheckedTextView;

/* loaded from: classes.dex */
public class SurveyChoiceView extends CheckedTextView {

    /* renamed from: a, reason: collision with root package name */
    private Drawable f3061a;
    private float b;
    private float c;

    public SurveyChoiceView(Context context) {
        super(context);
        a();
    }

    public SurveyChoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public SurveyChoiceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        this.f3061a = drawable;
    }

    @Override // android.widget.CheckedTextView, android.widget.Checkable
    public void setChecked(boolean z) {
        boolean isChecked = isChecked();
        super.setChecked(z);
        if (isChecked() && !isChecked) {
            a aVar = new a();
            aVar.setDuration(300L);
            startAnimation(aVar);
        }
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i = 0;
        Drawable drawable = this.f3061a;
        float f = getResources().getDisplayMetrics().density;
        int i2 = (drawable == null || !isChecked()) ? 0 : (int) (14.0f * f);
        int i3 = (int) (12.0f * f);
        int i4 = (int) (f * 22.0f);
        setCheckMarkDrawable((Drawable) null);
        setPadding((int) (i4 + (this.c * i2)), i3, i4, i3);
        super.onDraw(canvas);
        int i5 = (int) (i4 + (this.b * i2));
        setPadding(i5, i3, i4, i3);
        setCheckMarkDrawable(drawable);
        if (drawable != null) {
            switch (getGravity() & 112) {
                case 16:
                    i = (getHeight() - i2) / 2;
                    break;
                case 80:
                    i = getHeight() - i2;
                    break;
            }
            drawable.setBounds(i5 + getScrollX(), i, i2 + i5 + getScrollX(), i + i2);
            drawable.draw(canvas);
        }
        setPadding(i4, i3, i4, i3);
    }

    private void a() {
        this.b = 0.0f;
        this.c = 1.5f;
    }

    /* loaded from: classes.dex */
    private class a extends Animation {
        private a() {
        }

        @Override // android.view.animation.Animation
        public boolean willChangeTransformationMatrix() {
            return false;
        }

        @Override // android.view.animation.Animation
        public boolean willChangeBounds() {
            return false;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            float f2 = 0.0f;
            float f3 = 1.0f;
            if (f > 0.5f) {
                f3 = 1.0f + ((f - 0.5f) * 2.0f);
            } else {
                f2 = f - 0.5f;
            }
            SurveyChoiceView.this.b = f2;
            SurveyChoiceView.this.c = f3;
            SurveyChoiceView.this.requestLayout();
        }
    }
}
