package com.mixpanel.android.surveys;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

@TargetApi(16)
/* loaded from: classes.dex */
public class FadeOnPressButton extends Button {

    /* renamed from: a, reason: collision with root package name */
    private boolean f3057a;

    public FadeOnPressButton(Context context) {
        super(context);
    }

    public FadeOnPressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FadeOnPressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        boolean z = false;
        int[] drawableState = getDrawableState();
        int length = drawableState.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (drawableState[i] != 16842919) {
                i++;
            } else {
                if (!this.f3057a) {
                    setAlphaBySDK(0.5f);
                }
                z = true;
            }
        }
        if (this.f3057a && !z) {
            setAlphaBySDK(1.0f);
            this.f3057a = true;
        }
        super.drawableStateChanged();
    }

    private void setAlphaBySDK(float f) {
        setAlpha(f);
    }
}
