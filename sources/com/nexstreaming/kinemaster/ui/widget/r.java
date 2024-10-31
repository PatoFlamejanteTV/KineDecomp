package com.nexstreaming.kinemaster.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: StrokeSizePopout.java */
/* loaded from: classes2.dex */
public class r extends p {

    /* renamed from: f */
    private float f23883f;

    /* renamed from: g */
    private float f23884g;

    /* renamed from: h */
    private float f23885h;
    private float i;
    private float j;
    private float[] k;
    private int l;
    private int m;
    private int n;
    private float o;
    private b p;
    private a q;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StrokeSizePopout.java */
    /* loaded from: classes2.dex */
    public class a extends View {

        /* renamed from: a */
        Paint f23886a;

        public a(Context context) {
            super(context);
            this.f23886a = new Paint();
        }

        @Override // android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            com.nexstreaming.kinemaster.usage.analytics.b.a(a.class.getName());
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (r.this.k != null) {
                this.f23886a.setStyle(Paint.Style.FILL);
                this.f23886a.setAntiAlias(true);
                this.f23886a.setColor(getResources().getColor(R.color.brush_size_color));
                int i = 0;
                for (float f2 : r.this.k) {
                    int c2 = r.this.c(f2);
                    if (Math.abs(r.this.o - f2) < 0.25f) {
                        this.f23886a.setColor(getResources().getColor(R.color.brush_size_color_sel));
                        canvas.drawCircle((c2 / 2) + i, getHeight() / 2, ((r.this.j * f2) / 2.0f) + r.this.n, this.f23886a);
                        this.f23886a.setColor(getResources().getColor(R.color.brush_size_color));
                    }
                    canvas.drawCircle((c2 / 2) + i, getHeight() / 2, (f2 * r.this.j) / 2.0f, this.f23886a);
                    i += c2;
                }
            }
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() == 0) {
                float d2 = r.this.d(motionEvent.getX());
                if (d2 != r.this.o) {
                    r.this.o = d2;
                    if (r.this.p != null) {
                        r.this.p.a(r.this.o);
                        r.this.f23878b.dismiss();
                    }
                    invalidate();
                }
            }
            return super.onTouchEvent(motionEvent);
        }
    }

    /* compiled from: StrokeSizePopout.java */
    /* loaded from: classes2.dex */
    public interface b {
        void a(float f2);
    }

    public r(Context context) {
        super(context);
        this.f23883f = -1.0f;
        this.f23884g = -1.0f;
        this.j = 1.0f;
        this.k = new float[]{5.0f, 10.0f, 15.0f, 20.0f, 25.0f};
        this.m = context.getResources().getDimensionPixelSize(R.dimen.handwriting_toolPopupSelMinSize);
        this.n = context.getResources().getDimensionPixelSize(R.dimen.handwriting_toolPopupSelBorder);
    }

    public float d(float f2) {
        int i = 0;
        for (float f3 : this.k) {
            i += c(f3);
            if (f2 <= i) {
                return f3;
            }
        }
        return this.k[r7.length - 1];
    }

    public int c(float f2) {
        return Math.max(this.m, (int) Math.ceil(f2 * this.j)) + this.f23879c.getResources().getDimensionPixelSize(R.dimen.handwriting_toolPopupMargins) + (this.n * 2);
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.p
    protected View a(Context context) {
        float f2 = this.f23884g;
        if (f2 < 0.0f) {
            f2 = this.k[0];
        }
        this.i = f2;
        float f3 = this.f23883f;
        if (f3 < 0.0f) {
            f3 = this.k[0];
        }
        this.f23885h = f3;
        this.l = 0;
        int i = 0;
        for (float f4 : this.k) {
            this.i = Math.max(f4, this.i);
            this.f23885h = Math.min(f4, this.f23885h);
            int c2 = c(f4);
            i += c2;
            this.l = Math.max(c2, this.l);
        }
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundResource(R.drawable.popup_bg_no_arrow);
        this.q = new a(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, this.l);
        layoutParams.gravity = 19;
        frameLayout.addView(this.q, layoutParams);
        return frameLayout;
    }

    public r b(float f2) {
        this.j = f2;
        return this;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.p
    public void b() {
        this.q = null;
        this.p = null;
        super.b();
    }

    public r a(float... fArr) {
        this.k = fArr;
        return this;
    }

    public void a(float f2) {
        if (this.o != f2) {
            this.o = f2;
            a aVar = this.q;
            if (aVar != null) {
                aVar.invalidate();
            }
        }
    }

    public void a(b bVar) {
        this.p = bVar;
    }
}
