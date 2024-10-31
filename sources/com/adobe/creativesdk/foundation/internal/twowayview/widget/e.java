package com.adobe.creativesdk.foundation.internal.twowayview.widget;

import android.graphics.Rect;
import android.support.v7.widget.ActivityChooserView;
import com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Lanes.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final BaseLayoutManager f6833a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f6834b;

    /* renamed from: c, reason: collision with root package name */
    private final Rect[] f6835c;

    /* renamed from: d, reason: collision with root package name */
    private final Rect[] f6836d;

    /* renamed from: e, reason: collision with root package name */
    private final int f6837e;

    /* renamed from: f, reason: collision with root package name */
    private final Rect f6838f = new Rect();

    /* renamed from: g, reason: collision with root package name */
    private final a f6839g = new a();

    /* renamed from: h, reason: collision with root package name */
    private Integer f6840h;
    private Integer i;

    /* compiled from: Lanes.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f6841a;

        /* renamed from: b, reason: collision with root package name */
        public int f6842b;

        public boolean a() {
            return this.f6841a == -1 || this.f6842b == -1;
        }

        public void b() {
            this.f6841a = -1;
            this.f6842b = -1;
        }

        public void a(int i, int i2) {
            this.f6841a = i;
            this.f6842b = i2;
        }
    }

    public e(BaseLayoutManager baseLayoutManager, TwoWayLayoutManager.Orientation orientation, Rect[] rectArr, int i) {
        this.f6833a = baseLayoutManager;
        this.f6834b = orientation == TwoWayLayoutManager.Orientation.VERTICAL;
        this.f6835c = rectArr;
        this.f6837e = i;
        this.f6836d = new Rect[this.f6835c.length];
        for (int i2 = 0; i2 < this.f6835c.length; i2++) {
            this.f6836d[i2] = new Rect();
        }
    }

    public static int a(BaseLayoutManager baseLayoutManager, int i) {
        if (baseLayoutManager.m()) {
            int paddingLeft = baseLayoutManager.getPaddingLeft();
            return ((baseLayoutManager.getWidth() - paddingLeft) - baseLayoutManager.getPaddingRight()) / i;
        }
        int paddingTop = baseLayoutManager.getPaddingTop();
        return ((baseLayoutManager.getHeight() - paddingTop) - baseLayoutManager.getPaddingBottom()) / i;
    }

    private void b(int i, int i2) {
        Rect rect = this.f6835c[i];
        int i3 = this.f6834b ? 0 : i2;
        if (!this.f6834b) {
            i2 = 0;
        }
        rect.offset(i3, i2);
    }

    private void h() {
        this.f6840h = null;
        this.i = null;
    }

    public int c() {
        Integer num = this.f6840h;
        if (num != null) {
            return num.intValue();
        }
        this.f6840h = Integer.MIN_VALUE;
        int i = 0;
        while (true) {
            Rect[] rectArr = this.f6835c;
            if (i < rectArr.length) {
                Rect rect = rectArr[i];
                this.f6840h = Integer.valueOf(Math.max(this.f6840h.intValue(), this.f6834b ? rect.top : rect.left));
                i++;
            } else {
                return this.f6840h.intValue();
            }
        }
    }

    public int d() {
        return this.f6837e;
    }

    public TwoWayLayoutManager.Orientation e() {
        return this.f6834b ? TwoWayLayoutManager.Orientation.VERTICAL : TwoWayLayoutManager.Orientation.HORIZONTAL;
    }

    public void f() {
        int i = 0;
        while (true) {
            Rect[] rectArr = this.f6835c;
            if (i >= rectArr.length) {
                return;
            }
            rectArr[i].set(this.f6836d[i]);
            i++;
        }
    }

    public void g() {
        int i = 0;
        while (true) {
            Rect[] rectArr = this.f6835c;
            if (i >= rectArr.length) {
                return;
            }
            this.f6836d[i].set(rectArr[i]);
            i++;
        }
    }

    public int b(Rect rect, int i, int i2, TwoWayLayoutManager.Direction direction) {
        int i3;
        Rect rect2 = this.f6835c[i];
        if (this.f6834b) {
            if (direction == TwoWayLayoutManager.Direction.END) {
                i3 = rect.top - rect2.bottom;
                rect2.bottom = rect.bottom + i2;
            } else {
                i3 = rect.bottom - rect2.top;
                rect2.top = rect.top - i2;
            }
        } else if (direction == TwoWayLayoutManager.Direction.END) {
            i3 = rect.left - rect2.right;
            rect2.right = rect.right + i2;
        } else {
            i3 = rect.right - rect2.left;
            rect2.left = rect.left - i2;
        }
        h();
        return i3;
    }

    public int a() {
        return this.f6835c.length;
    }

    public e(BaseLayoutManager baseLayoutManager, int i) {
        this.f6833a = baseLayoutManager;
        this.f6834b = baseLayoutManager.m();
        this.f6835c = new Rect[i];
        this.f6836d = new Rect[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.f6835c[i2] = new Rect();
            this.f6836d[i2] = new Rect();
        }
        this.f6837e = a(baseLayoutManager, i);
        int paddingLeft = baseLayoutManager.getPaddingLeft();
        int paddingTop = baseLayoutManager.getPaddingTop();
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = this.f6837e * i3;
            int i5 = (this.f6834b ? i4 : 0) + paddingLeft;
            int i6 = (this.f6834b ? 0 : i4) + paddingTop;
            this.f6835c[i3].set(i5, i6, this.f6834b ? this.f6837e + i5 : i5, this.f6834b ? i6 : this.f6837e + i6);
        }
    }

    public void a(int i) {
        for (int i2 = 0; i2 < this.f6835c.length; i2++) {
            a(i2, i);
        }
        h();
    }

    public void a(int i, int i2) {
        b(i, i2);
        h();
    }

    public void b(int i) {
        int i2 = 0;
        while (true) {
            Rect[] rectArr = this.f6835c;
            if (i2 < rectArr.length) {
                Rect rect = rectArr[i2];
                rect.offsetTo(this.f6834b ? rect.left : i, this.f6834b ? i : rect.top);
                if (this.f6834b) {
                    rect.bottom = rect.top;
                } else {
                    rect.right = rect.left;
                }
                i2++;
            } else {
                h();
                return;
            }
        }
    }

    public void a(int i, Rect rect) {
        rect.set(this.f6835c[i]);
    }

    public void a(Rect rect, int i, int i2, TwoWayLayoutManager.Direction direction) {
        Rect rect2 = this.f6835c[i];
        if (this.f6834b) {
            if (direction == TwoWayLayoutManager.Direction.END) {
                rect2.top = rect.bottom - i2;
            } else {
                rect2.bottom = rect.top + i2;
            }
        } else if (direction == TwoWayLayoutManager.Direction.END) {
            rect2.left = rect.right - i2;
        } else {
            rect2.right = rect.left + i2;
        }
        h();
    }

    public int b() {
        Integer num = this.i;
        if (num != null) {
            return num.intValue();
        }
        this.i = Integer.valueOf(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        int i = 0;
        while (true) {
            Rect[] rectArr = this.f6835c;
            if (i < rectArr.length) {
                Rect rect = rectArr[i];
                this.i = Integer.valueOf(Math.min(this.i.intValue(), this.f6834b ? rect.bottom : rect.right));
                i++;
            } else {
                return this.i.intValue();
            }
        }
    }

    public void a(Rect rect, int i, int i2, a aVar, TwoWayLayoutManager.Direction direction) {
        Rect[] rectArr = this.f6835c;
        int i3 = aVar.f6841a;
        Rect rect2 = rectArr[i3];
        if (direction == TwoWayLayoutManager.Direction.END) {
            i3 = aVar.f6842b;
        }
        Rect rect3 = this.f6835c[i3];
        if (this.f6834b) {
            rect.left = rect2.left;
            rect.top = direction == TwoWayLayoutManager.Direction.END ? rect3.bottom : rect3.top - i2;
        } else {
            rect.top = rect2.top;
            rect.left = direction == TwoWayLayoutManager.Direction.END ? rect3.right : rect3.left - i;
        }
        rect.right = rect.left + i;
        rect.bottom = rect.top + i2;
    }

    private boolean a(int i, int i2, Rect rect) {
        for (int i3 = i; i3 < i + i2; i3++) {
            if (Rect.intersects(this.f6835c[i3], rect)) {
                return true;
            }
        }
        return false;
    }

    private int a(int i, int i2, TwoWayLayoutManager.Direction direction) {
        int max = Math.max(0, (i - i2) + 1);
        int min = Math.min(max + i2, (this.f6835c.length - i2) + 1);
        while (max < min) {
            this.f6839g.a(max, i);
            a(this.f6838f, this.f6834b ? this.f6837e * i2 : 1, this.f6834b ? 1 : this.f6837e * i2, this.f6839g, direction);
            if (!a(max, i2, this.f6838f)) {
                return max;
            }
            max++;
        }
        return -1;
    }

    public void a(a aVar, int i, TwoWayLayoutManager.Direction direction) {
        int i2;
        int a2;
        aVar.b();
        int i3 = direction == TwoWayLayoutManager.Direction.END ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : Integer.MIN_VALUE;
        int i4 = 0;
        while (true) {
            Rect[] rectArr = this.f6835c;
            if (i4 >= rectArr.length) {
                return;
            }
            if (this.f6834b) {
                i2 = direction == TwoWayLayoutManager.Direction.END ? rectArr[i4].bottom : rectArr[i4].top;
            } else {
                i2 = direction == TwoWayLayoutManager.Direction.END ? rectArr[i4].right : rectArr[i4].left;
            }
            if (((direction == TwoWayLayoutManager.Direction.END && i2 < i3) || (direction == TwoWayLayoutManager.Direction.START && i2 > i3)) && (a2 = a(i4, i, direction)) != -1) {
                aVar.a(a2, i4);
                i3 = i2;
            }
            i4++;
        }
    }

    public void a(TwoWayLayoutManager.Direction direction) {
        int i = 0;
        while (true) {
            Rect[] rectArr = this.f6835c;
            if (i < rectArr.length) {
                Rect rect = rectArr[i];
                if (this.f6834b) {
                    if (direction == TwoWayLayoutManager.Direction.START) {
                        rect.bottom = rect.top;
                    } else {
                        rect.top = rect.bottom;
                    }
                } else if (direction == TwoWayLayoutManager.Direction.START) {
                    rect.right = rect.left;
                } else {
                    rect.left = rect.right;
                }
                i++;
            } else {
                h();
                return;
            }
        }
    }
}
