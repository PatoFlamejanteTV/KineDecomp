package com.nexstreaming.kinemaster.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: StrokeSizePopout.java */
/* loaded from: classes.dex */
public class n extends j {

    /* renamed from: a, reason: collision with root package name */
    private float f4399a;
    private float d;
    private float e;
    private float f;
    private float g;
    private float[] h;
    private int i;
    private int j;
    private int k;
    private float l;
    private b m;
    private a n;

    /* compiled from: StrokeSizePopout.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(float f);
    }

    public n(Context context) {
        super(context);
        this.f4399a = -1.0f;
        this.d = -1.0f;
        this.g = 1.0f;
        this.h = new float[]{5.0f, 10.0f, 15.0f, 20.0f, 25.0f};
        this.j = context.getResources().getDimensionPixelSize(R.dimen.handwriting_toolPopupSelMinSize);
        this.k = context.getResources().getDimensionPixelSize(R.dimen.handwriting_toolPopupSelBorder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(float f) {
        return Math.max(this.j, (int) Math.ceil(this.g * f)) + this.c.getResources().getDimensionPixelSize(R.dimen.handwriting_toolPopupMargins) + (this.k * 2);
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.j
    protected View a(Context context) {
        int i = 0;
        this.f = this.d < 0.0f ? this.h[0] : this.d;
        this.e = this.f4399a < 0.0f ? this.h[0] : this.f4399a;
        this.i = 0;
        for (float f : this.h) {
            this.f = Math.max(f, this.f);
            this.e = Math.min(f, this.e);
            int c = c(f);
            i += c;
            this.i = Math.max(c, this.i);
        }
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundResource(R.drawable.popup_bg_arrow_right);
        this.n = new a(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, this.i);
        layoutParams.gravity = 19;
        frameLayout.addView(this.n, layoutParams);
        return frameLayout;
    }

    public n a(float... fArr) {
        this.h = fArr;
        return this;
    }

    public n a(float f) {
        this.g = f;
        return this;
    }

    public void b(float f) {
        if (this.l != f) {
            this.l = f;
            if (this.n != null) {
                this.n.invalidate();
            }
        }
    }

    public void a(b bVar) {
        this.m = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float d(float f) {
        int i = 0;
        for (float f2 : this.h) {
            int c = c(f2);
            if (f > i + c) {
                i += c;
            } else {
                return f2;
            }
        }
        return this.h[this.h.length - 1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.widget.j
    public void b() {
        this.n = null;
        this.m = null;
        super.b();
    }

    /* compiled from: StrokeSizePopout.java */
    /* loaded from: classes.dex */
    private class a extends View {

        /* renamed from: a, reason: collision with root package name */
        Paint f4400a;

        public a(Context context) {
            super(context);
            this.f4400a = new Paint();
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (n.this.h != null) {
                this.f4400a.setStyle(Paint.Style.FILL);
                this.f4400a.setAntiAlias(true);
                this.f4400a.setColor(getResources().getColor(R.color.brush_size_color));
                int i = 0;
                for (float f : n.this.h) {
                    int c = n.this.c(f);
                    if (Math.abs(n.this.l - f) < 0.25f) {
                        this.f4400a.setColor(getResources().getColor(R.color.brush_size_color_sel));
                        canvas.drawCircle((c / 2) + i, getHeight() / 2, ((n.this.g * f) / 2.0f) + n.this.k, this.f4400a);
                        this.f4400a.setColor(getResources().getColor(R.color.brush_size_color));
                    }
                    canvas.drawCircle((c / 2) + i, getHeight() / 2, (f * n.this.g) / 2.0f, this.f4400a);
                    i += c;
                }
            }
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    float d = n.this.d(motionEvent.getX());
                    if (d != n.this.l) {
                        n.this.l = d;
                        if (n.this.m != null) {
                            n.this.m.a(n.this.l);
                            n.this.b.dismiss();
                        }
                        invalidate();
                        break;
                    }
                    break;
            }
            return super.onTouchEvent(motionEvent);
        }
    }
}
