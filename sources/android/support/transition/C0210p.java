package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* compiled from: ChangeBounds.java */
/* renamed from: android.support.transition.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0210p extends M {
    private static final String[] K = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> L = new C0201g(PointF.class, "boundsOrigin");
    private static final Property<a, PointF> M = new C0202h(PointF.class, "topLeft");
    private static final Property<a, PointF> N = new C0203i(PointF.class, "bottomRight");
    private static final Property<View, PointF> O = new C0204j(PointF.class, "bottomRight");
    private static final Property<View, PointF> P = new C0205k(PointF.class, "topLeft");
    private static final Property<View, PointF> Q = new C0206l(PointF.class, "position");
    private static H R = new H();
    private int[] S = new int[2];
    private boolean T = false;
    private boolean U = false;

    private void d(V v) {
        View view = v.f561b;
        if (!ViewCompat.isLaidOut(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        v.f560a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        v.f560a.put("android:changeBounds:parent", v.f561b.getParent());
        if (this.U) {
            v.f561b.getLocationInWindow(this.S);
            v.f560a.put("android:changeBounds:windowX", Integer.valueOf(this.S[0]));
            v.f560a.put("android:changeBounds:windowY", Integer.valueOf(this.S[1]));
        }
        if (this.T) {
            v.f560a.put("android:changeBounds:clip", ViewCompat.getClipBounds(view));
        }
    }

    @Override // android.support.transition.M
    public void a(V v) {
        d(v);
    }

    @Override // android.support.transition.M
    public void c(V v) {
        d(v);
    }

    @Override // android.support.transition.M
    public String[] k() {
        return K;
    }

    private boolean a(View view, View view2) {
        if (!this.U) {
            return true;
        }
        V a2 = a(view, true);
        if (a2 == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == a2.f561b) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChangeBounds.java */
    /* renamed from: android.support.transition.p$a */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f617a;

        /* renamed from: b, reason: collision with root package name */
        private int f618b;

        /* renamed from: c, reason: collision with root package name */
        private int f619c;

        /* renamed from: d, reason: collision with root package name */
        private int f620d;

        /* renamed from: e, reason: collision with root package name */
        private View f621e;

        /* renamed from: f, reason: collision with root package name */
        private int f622f;

        /* renamed from: g, reason: collision with root package name */
        private int f623g;

        a(View view) {
            this.f621e = view;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(PointF pointF) {
            this.f619c = Math.round(pointF.x);
            this.f620d = Math.round(pointF.y);
            this.f623g++;
            if (this.f622f == this.f623g) {
                a();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b(PointF pointF) {
            this.f617a = Math.round(pointF.x);
            this.f618b = Math.round(pointF.y);
            this.f622f++;
            if (this.f622f == this.f623g) {
                a();
            }
        }

        private void a() {
            ka.a(this.f621e, this.f617a, this.f618b, this.f619c, this.f620d);
            this.f622f = 0;
            this.f623g = 0;
        }
    }

    @Override // android.support.transition.M
    public Animator a(ViewGroup viewGroup, V v, V v2) {
        int i;
        View view;
        int i2;
        Rect rect;
        ObjectAnimator objectAnimator;
        Animator a2;
        if (v == null || v2 == null) {
            return null;
        }
        Map<String, Object> map = v.f560a;
        Map<String, Object> map2 = v2.f560a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = v2.f561b;
        if (a(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) v.f560a.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) v2.f560a.get("android:changeBounds:bounds");
            int i3 = rect2.left;
            int i4 = rect3.left;
            int i5 = rect2.top;
            int i6 = rect3.top;
            int i7 = rect2.right;
            int i8 = rect3.right;
            int i9 = rect2.bottom;
            int i10 = rect3.bottom;
            int i11 = i7 - i3;
            int i12 = i9 - i5;
            int i13 = i8 - i4;
            int i14 = i10 - i6;
            Rect rect4 = (Rect) v.f560a.get("android:changeBounds:clip");
            Rect rect5 = (Rect) v2.f560a.get("android:changeBounds:clip");
            if ((i11 == 0 || i12 == 0) && (i13 == 0 || i14 == 0)) {
                i = 0;
            } else {
                i = (i3 == i4 && i5 == i6) ? 0 : 1;
                if (i7 != i8 || i9 != i10) {
                    i++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i++;
            }
            if (i <= 0) {
                return null;
            }
            if (!this.T) {
                view = view2;
                ka.a(view, i3, i5, i7, i9);
                if (i == 2) {
                    if (i11 == i13 && i12 == i14) {
                        a2 = C0216w.a(view, Q, e().a(i3, i5, i4, i6));
                    } else {
                        a aVar = new a(view);
                        ObjectAnimator a3 = C0216w.a(aVar, M, e().a(i3, i5, i4, i6));
                        ObjectAnimator a4 = C0216w.a(aVar, N, e().a(i7, i9, i8, i10));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(a3, a4);
                        animatorSet.addListener(new C0207m(this, aVar));
                        a2 = animatorSet;
                    }
                } else if (i3 == i4 && i5 == i6) {
                    a2 = C0216w.a(view, O, e().a(i7, i9, i8, i10));
                } else {
                    a2 = C0216w.a(view, P, e().a(i3, i5, i4, i6));
                }
            } else {
                view = view2;
                ka.a(view, i3, i5, Math.max(i11, i13) + i3, Math.max(i12, i14) + i5);
                ObjectAnimator a5 = (i3 == i4 && i5 == i6) ? null : C0216w.a(view, Q, e().a(i3, i5, i4, i6));
                if (rect4 == null) {
                    i2 = 0;
                    rect = new Rect(0, 0, i11, i12);
                } else {
                    i2 = 0;
                    rect = rect4;
                }
                Rect rect6 = rect5 == null ? new Rect(i2, i2, i13, i14) : rect5;
                if (rect.equals(rect6)) {
                    objectAnimator = null;
                } else {
                    ViewCompat.setClipBounds(view, rect);
                    H h2 = R;
                    Object[] objArr = new Object[2];
                    objArr[i2] = rect;
                    objArr[1] = rect6;
                    objectAnimator = ObjectAnimator.ofObject(view, "clipBounds", h2, objArr);
                    objectAnimator.addListener(new C0208n(this, view, rect5, i4, i6, i8, i10));
                }
                a2 = U.a(a5, objectAnimator);
            }
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                aa.a(viewGroup4, true);
                a(new C0209o(this, viewGroup4));
            }
            return a2;
        }
        int intValue = ((Integer) v.f560a.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) v.f560a.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) v2.f560a.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) v2.f560a.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.S);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float c2 = ka.c(view2);
        ka.a(view2, 0.0f);
        ka.b(viewGroup).a(bitmapDrawable);
        A e2 = e();
        int[] iArr = this.S;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, C.a(L, e2.a(intValue - iArr[0], intValue2 - iArr[1], intValue3 - iArr[0], intValue4 - iArr[1])));
        ofPropertyValuesHolder.addListener(new C0200f(this, viewGroup, bitmapDrawable, view2, c2));
        return ofPropertyValuesHolder;
    }
}
