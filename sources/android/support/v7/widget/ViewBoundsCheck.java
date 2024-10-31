package android.support.v7.widget;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ViewBoundsCheck {

    /* renamed from: a */
    final Callback f3162a;

    /* renamed from: b */
    BoundFlags f3163b = new BoundFlags();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface Callback {
        View getChildAt(int i);

        int getChildCount();

        int getChildEnd(View view);

        int getChildStart(View view);

        View getParent();

        int getParentEnd();

        int getParentStart();
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ViewBounds {
    }

    public ViewBoundsCheck(Callback callback) {
        this.f3162a = callback;
    }

    public View a(int i, int i2, int i3, int i4) {
        int parentStart = this.f3162a.getParentStart();
        int parentEnd = this.f3162a.getParentEnd();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View childAt = this.f3162a.getChildAt(i);
            this.f3163b.a(parentStart, parentEnd, this.f3162a.getChildStart(childAt), this.f3162a.getChildEnd(childAt));
            if (i3 != 0) {
                this.f3163b.b();
                this.f3163b.a(i3);
                if (this.f3163b.a()) {
                    return childAt;
                }
            }
            if (i4 != 0) {
                this.f3163b.b();
                this.f3163b.a(i4);
                if (this.f3163b.a()) {
                    view = childAt;
                }
            }
            i += i5;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class BoundFlags {

        /* renamed from: a */
        int f3164a = 0;

        /* renamed from: b */
        int f3165b;

        /* renamed from: c */
        int f3166c;

        /* renamed from: d */
        int f3167d;

        /* renamed from: e */
        int f3168e;

        BoundFlags() {
        }

        int a(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        void a(int i, int i2, int i3, int i4) {
            this.f3165b = i;
            this.f3166c = i2;
            this.f3167d = i3;
            this.f3168e = i4;
        }

        void b() {
            this.f3164a = 0;
        }

        void a(int i) {
            this.f3164a = i | this.f3164a;
        }

        boolean a() {
            int i = this.f3164a;
            if ((i & 7) != 0 && (i & (a(this.f3167d, this.f3165b) << 0)) == 0) {
                return false;
            }
            int i2 = this.f3164a;
            if ((i2 & 112) != 0 && (i2 & (a(this.f3167d, this.f3166c) << 4)) == 0) {
                return false;
            }
            int i3 = this.f3164a;
            if ((i3 & 1792) != 0 && (i3 & (a(this.f3168e, this.f3165b) << 8)) == 0) {
                return false;
            }
            int i4 = this.f3164a;
            return (i4 & 28672) == 0 || (i4 & (a(this.f3168e, this.f3166c) << 12)) != 0;
        }
    }

    public boolean a(View view, int i) {
        this.f3163b.a(this.f3162a.getParentStart(), this.f3162a.getParentEnd(), this.f3162a.getChildStart(view), this.f3162a.getChildEnd(view));
        if (i == 0) {
            return false;
        }
        this.f3163b.b();
        this.f3163b.a(i);
        return this.f3163b.a();
    }
}
