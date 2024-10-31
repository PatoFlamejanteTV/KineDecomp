package com.nexstreaming.kinemaster.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.UniformTimelineView;
import com.nextreaming.nexeditorui.EditorGlobal;

/* loaded from: classes2.dex */
public class FXGripDrawingView extends View implements UniformTimelineView.a {

    /* renamed from: a */
    private int f23750a;

    /* renamed from: b */
    private int f23751b;

    /* renamed from: c */
    private int f23752c;

    /* renamed from: d */
    private DisplayMetrics f23753d;

    /* renamed from: e */
    private WindowManager f23754e;

    /* renamed from: f */
    private boolean f23755f;

    /* renamed from: g */
    private boolean f23756g;

    /* renamed from: h */
    private float f23757h;
    private GripType i;
    private int j;
    private int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public View p;
    public ViewGroup q;
    private WindowManager.LayoutParams r;
    private int s;
    private b t;
    private a u;
    private UniformTimelineView v;
    private View w;
    private boolean x;

    /* loaded from: classes2.dex */
    public enum GripType {
        START,
        END
    }

    /* loaded from: classes2.dex */
    class a implements UniformTimelineView.a {
        a() {
        }

        @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.UniformTimelineView.a
        public void onDrawForeground(Canvas canvas) {
            if (FXGripDrawingView.this.getVisibility() != 0 || FXGripDrawingView.this.w == null || FXGripDrawingView.this.x) {
                return;
            }
            canvas.save();
            new Paint().setColor(Color.argb(128, 255, 0, 0));
            canvas.translate(FXGripDrawingView.this.w.getLeft(), FXGripDrawingView.this.getResources().getDimensionPixelSize(R.dimen.timeline3_timescale_height));
            FXGripDrawingView.this.w.draw(canvas);
            canvas.translate(-FXGripDrawingView.this.w.getLeft(), -FXGripDrawingView.this.getResources().getDimensionPixelSize(R.dimen.timeline3_timescale_height));
            Drawable drawable = FXGripDrawingView.this.getContext().getResources().getDrawable(R.drawable.timeline_item_border_sel);
            drawable.setBounds(FXGripDrawingView.this.w.getLeft(), FXGripDrawingView.this.w.getTop(), FXGripDrawingView.this.w.getRight(), FXGripDrawingView.this.w.getBottom());
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(int i, int i2);
    }

    public FXGripDrawingView(Context context) {
        super(context);
        this.u = new a();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            if (getParent().getParent().getParent().getParent() != null) {
                getParent().getParent().getParent().getParent().requestDisallowInterceptTouchEvent(true);
            }
            if (b(motionEvent)) {
                return true;
            }
        } else if (action == 1) {
            a(motionEvent, false);
        } else if (action != 2) {
            if (action == 3) {
                a(motionEvent, true);
            }
        } else if (c(motionEvent)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.nexstreaming.kinemaster.usage.analytics.b.a(FXGripDrawingView.class.getName());
        this.v = UniformTimelineView.g((View) getParent());
        UniformTimelineView uniformTimelineView = this.v;
        if (uniformTimelineView != null) {
            uniformTimelineView.a(this.u);
        }
        this.x = true;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        WindowManager windowManager;
        UniformTimelineView uniformTimelineView = this.v;
        if (uniformTimelineView != null) {
            uniformTimelineView.b(this.u);
        }
        this.v = null;
        ViewGroup viewGroup = this.q;
        if (viewGroup != null && (windowManager = this.f23754e) != null) {
            windowManager.removeViewImmediate(viewGroup);
            this.q = null;
        }
        this.x = false;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = new Rect();
        getDrawingRect(rect);
        a(rect);
        Paint paint = new Paint();
        int applyDimension = (int) TypedValue.applyDimension(1, 2.0f, this.f23753d);
        int applyDimension2 = (int) TypedValue.applyDimension(1, 1.0f, this.f23753d);
        rect.left = this.n + applyDimension;
        rect.right = this.o - applyDimension;
        rect.top += applyDimension2;
        rect.bottom -= applyDimension2;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(2147464192);
        canvas.drawRect(rect, paint);
        rect.left = this.n - applyDimension;
        rect.right = this.o + applyDimension;
        rect.top -= applyDimension2;
        rect.bottom += applyDimension2;
        int applyDimension3 = (int) TypedValue.applyDimension(1, 2.0f, this.f23753d);
        canvas.save();
        Drawable drawable = getResources().getDrawable(R.drawable.grip_yellow_for_fx);
        canvas.clipRect(rect.left + applyDimension, rect.top, rect.right - applyDimension, rect.bottom, Region.Op.REPLACE);
        int i = applyDimension * 2;
        drawable.setBounds(rect.left + i, rect.top + applyDimension3, rect.right - i, rect.bottom - applyDimension3);
        drawable.draw(canvas);
        canvas.restore();
    }

    public void setListener(b bVar) {
        this.t = bVar;
    }

    private boolean b(MotionEvent motionEvent) {
        if (this.f23756g || this.f23755f || !a(motionEvent)) {
            return false;
        }
        this.f23756g = true;
        this.f23755f = false;
        this.f23757h = motionEvent.getX();
        this.j = this.f23750a;
        this.k = this.f23751b;
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        GripType gripType = this.i;
        if (gripType == GripType.START) {
            a(i + this.n, i2);
        } else if (gripType == GripType.END) {
            a(i + this.o, i2);
        }
        return true;
    }

    private boolean c(MotionEvent motionEvent) {
        if (!this.f23756g) {
            return false;
        }
        this.f23755f = true;
        float x = motionEvent.getX() - this.f23757h;
        Rect rect = new Rect();
        getDrawingRect(rect);
        GripType gripType = this.i;
        if (gripType == GripType.START) {
            this.f23750a = (int) (this.j + ((x / rect.width()) * this.f23752c));
            if (this.f23750a < 0) {
                this.f23750a = 0;
            }
            int i = this.f23750a;
            int i2 = this.f23752c;
            if (i > i2 - 500) {
                this.f23750a = i2 - 500;
            }
            int i3 = this.f23750a;
            int i4 = this.f23751b;
            if (i3 > i4 - 500) {
                this.f23750a = i4 - 500;
            }
        } else if (gripType == GripType.END) {
            this.f23751b = (int) (this.k + ((x / rect.width()) * this.f23752c));
            if (this.f23751b < 0) {
                this.f23751b = 0;
            }
            int i5 = this.f23751b;
            int i6 = this.f23750a;
            if (i5 < i6 + 500) {
                this.f23751b = i6 + 500;
            }
            int i7 = this.f23751b;
            int i8 = this.f23752c;
            if (i7 > i8) {
                this.f23751b = i8;
            }
        }
        a(rect);
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int i9 = iArr[0];
        int applyDimension = (int) TypedValue.applyDimension(1, 4.0f, this.f23753d);
        GripType gripType2 = this.i;
        if (gripType2 == GripType.START) {
            WindowManager.LayoutParams layoutParams = this.r;
            layoutParams.x = ((i9 + this.n) - (this.s / 2)) + applyDimension;
            this.f23754e.updateViewLayout(this.q, layoutParams);
        } else if (gripType2 == GripType.END) {
            WindowManager.LayoutParams layoutParams2 = this.r;
            layoutParams2.x = ((i9 + this.o) - (this.s / 2)) - applyDimension;
            this.f23754e.updateViewLayout(this.q, layoutParams2);
        }
        View view = this.p;
        if (view != null) {
            view.invalidate();
        }
        invalidate();
        return true;
    }

    public void a(int i, int i2, int i3, View view) {
        this.f23750a = i;
        this.f23751b = i2;
        this.f23752c = i3;
        this.f23753d = getResources().getDisplayMetrics();
        this.f23754e = (WindowManager) getContext().getSystemService("window");
        this.w = view;
        int i4 = this.f23751b;
        int i5 = this.f23752c;
        if (i4 > i5) {
            this.f23751b = i5;
        }
    }

    public FXGripDrawingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.u = new a();
    }

    public FXGripDrawingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.u = new a();
    }

    public FXGripDrawingView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.u = new a();
    }

    private void a(Rect rect) {
        this.l = this.f23750a;
        this.m = this.f23751b;
        int i = this.f23752c;
        if (this.l < 0) {
            this.l = 0;
        }
        int i2 = this.m;
        if (i2 > i || i2 == 0) {
            this.m = i;
        }
        int i3 = this.m;
        int i4 = this.l;
        if (i3 < i4 + 100) {
            this.m = Math.min(i, i4 + 100);
        }
        long j = i;
        this.n = (int) (rect.left + ((this.l * rect.width()) / j));
        this.o = (int) (rect.left + ((this.m * rect.width()) / j));
    }

    private boolean a(MotionEvent motionEvent, boolean z) {
        ViewGroup viewGroup;
        if (!this.f23755f && this.f23756g) {
            return false;
        }
        if (z) {
            this.f23750a = this.j;
            this.f23751b = this.k;
        }
        this.f23755f = false;
        this.f23756g = false;
        WindowManager windowManager = this.f23754e;
        if (windowManager != null && (viewGroup = this.q) != null) {
            windowManager.removeView(viewGroup);
            this.q = null;
        }
        b bVar = this.t;
        if (bVar != null) {
            bVar.a(this.f23750a, this.f23751b);
        }
        invalidate();
        return true;
    }

    private boolean a(MotionEvent motionEvent) {
        Rect rect = new Rect();
        getDrawingRect(rect);
        a(rect);
        int applyDimension = (int) TypedValue.applyDimension(1, 20.0f, this.f23753d);
        int i = this.n;
        Rect rect2 = new Rect(i - applyDimension, rect.top, i + applyDimension, rect.bottom);
        int i2 = this.o;
        Rect rect3 = new Rect(i2 - applyDimension, rect.top, i2 + applyDimension, rect.bottom);
        if (rect2.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            this.i = GripType.START;
            return true;
        }
        if (!rect3.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        this.i = GripType.END;
        return true;
    }

    private void a(int i, int i2) {
        String string;
        Rect rect = new Rect();
        GripType gripType = this.i;
        if (gripType == GripType.START) {
            string = getResources().getString(R.string.video_drag_fxstart, EditorGlobal.a(this.f23750a));
        } else {
            string = gripType == GripType.END ? getResources().getString(R.string.video_drag_fxend, EditorGlobal.a(this.f23751b)) : "";
        }
        Paint paint = new Paint();
        paint.setTextSize(getResources().getDimensionPixelSize(R.dimen.custom_drag_text_size));
        paint.getTextBounds(string, 0, string.length(), rect);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.s = Math.max(rect.width() + 10, (int) TypedValue.applyDimension(1, 100.0f, displayMetrics));
        int applyDimension = (int) TypedValue.applyDimension(1, 32.0f, displayMetrics);
        int applyDimension2 = (i - (this.s / 2)) + ((int) TypedValue.applyDimension(1, 4.0f, this.f23753d));
        this.q = new FrameLayout(getContext());
        this.q.setBackgroundColor(0);
        this.p = new C2295c(this, getContext(), applyDimension);
        this.p.setLayoutParams(new FrameLayout.LayoutParams(this.s, applyDimension));
        this.q.addView(this.p);
        this.r = new WindowManager.LayoutParams();
        WindowManager.LayoutParams layoutParams = this.r;
        layoutParams.width = this.s;
        layoutParams.height = applyDimension;
        layoutParams.flags = 408;
        layoutParams.gravity = 51;
        layoutParams.x = applyDimension2;
        layoutParams.y = (i2 - applyDimension) + ((int) TypedValue.applyDimension(1, 2.0f, displayMetrics));
        WindowManager.LayoutParams layoutParams2 = this.r;
        layoutParams2.windowAnimations = 0;
        layoutParams2.format = -3;
        this.f23754e.addView(this.q, layoutParams2);
    }
}
