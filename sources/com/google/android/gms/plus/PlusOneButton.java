package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.plus.internal.zzg;

/* loaded from: classes.dex */
public final class PlusOneButton extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private View f2154a;
    private int b;
    private int c;
    private String d;
    private int e;
    private OnPlusOneClickListener f;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class DefaultOnPlusOneClickListener implements View.OnClickListener, OnPlusOneClickListener {
        private final OnPlusOneClickListener b;

        public DefaultOnPlusOneClickListener(OnPlusOneClickListener onPlusOneClickListener) {
            this.b = onPlusOneClickListener;
        }

        @Override // com.google.android.gms.plus.PlusOneButton.OnPlusOneClickListener
        public void a(Intent intent) {
            Context context = PlusOneButton.this.getContext();
            if (!(context instanceof Activity) || intent == null) {
                return;
            }
            ((Activity) context).startActivityForResult(intent, PlusOneButton.this.e);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = (Intent) PlusOneButton.this.f2154a.getTag();
            if (this.b != null) {
                this.b.a(intent);
            } else {
                a(intent);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface OnPlusOneClickListener {
        void a(Intent intent);
    }

    private void a(Context context) {
        if (this.f2154a != null) {
            removeView(this.f2154a);
        }
        this.f2154a = zzg.a(context, this.b, this.c, this.d, this.e);
        setOnPlusOneClickListener(this.f);
        addView(this.f2154a);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f2154a.layout(0, 0, i3 - i, i4 - i2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        View view = this.f2154a;
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setAnnotation(int i) {
        this.c = i;
        a(getContext());
    }

    public void setIntent(Intent intent) {
        this.f2154a.setTag(intent);
    }

    public void setOnPlusOneClickListener(OnPlusOneClickListener onPlusOneClickListener) {
        this.f = onPlusOneClickListener;
        this.f2154a.setOnClickListener(new DefaultOnPlusOneClickListener(onPlusOneClickListener));
    }

    public void setSize(int i) {
        this.b = i;
        a(getContext());
    }
}
