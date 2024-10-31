package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ChildHelper {

    /* renamed from: a, reason: collision with root package name */
    final Callback f2711a;

    /* renamed from: b, reason: collision with root package name */
    final Bucket f2712b = new Bucket();

    /* renamed from: c, reason: collision with root package name */
    final List<View> f2713c = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface Callback {
        void addView(View view, int i);

        void attachViewToParent(View view, int i, ViewGroup.LayoutParams layoutParams);

        void detachViewFromParent(int i);

        View getChildAt(int i);

        int getChildCount();

        RecyclerView.ViewHolder getChildViewHolder(View view);

        int indexOfChild(View view);

        void onEnteredHiddenState(View view);

        void onLeftHiddenState(View view);

        void removeAllViews();

        void removeViewAt(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChildHelper(Callback callback) {
        this.f2711a = callback;
    }

    private int f(int i) {
        if (i < 0) {
            return -1;
        }
        int childCount = this.f2711a.getChildCount();
        int i2 = i;
        while (i2 < childCount) {
            int b2 = i - (i2 - this.f2712b.b(i2));
            if (b2 == 0) {
                while (this.f2712b.c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += b2;
        }
        return -1;
    }

    private void g(View view) {
        this.f2713c.add(view);
        this.f2711a.onEnteredHiddenState(view);
    }

    private boolean h(View view) {
        if (!this.f2713c.remove(view)) {
            return false;
        }
        this.f2711a.onLeftHiddenState(view);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, boolean z) {
        a(view, -1, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View b(int i) {
        int size = this.f2713c.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.f2713c.get(i2);
            RecyclerView.ViewHolder childViewHolder = this.f2711a.getChildViewHolder(view);
            if (childViewHolder.getLayoutPosition() == i && !childViewHolder.h() && !childViewHolder.i()) {
                return view;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View c(int i) {
        return this.f2711a.getChildAt(f(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(View view) {
        int indexOfChild = this.f2711a.indexOfChild(view);
        if (indexOfChild < 0) {
            return;
        }
        if (this.f2712b.d(indexOfChild)) {
            h(view);
        }
        this.f2711a.removeViewAt(indexOfChild);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(int i) {
        int f2 = f(i);
        View childAt = this.f2711a.getChildAt(f2);
        if (childAt == null) {
            return;
        }
        if (this.f2712b.d(f2)) {
            h(childAt);
        }
        this.f2711a.removeViewAt(f2);
    }

    public String toString() {
        return this.f2712b.toString() + ", hidden list:" + this.f2713c.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Bucket {

        /* renamed from: a, reason: collision with root package name */
        long f2714a = 0;

        /* renamed from: b, reason: collision with root package name */
        Bucket f2715b;

        Bucket() {
        }

        private void b() {
            if (this.f2715b == null) {
                this.f2715b = new Bucket();
            }
        }

        void a(int i) {
            if (i >= 64) {
                Bucket bucket = this.f2715b;
                if (bucket != null) {
                    bucket.a(i - 64);
                    return;
                }
                return;
            }
            this.f2714a &= (1 << i) ^ (-1);
        }

        boolean c(int i) {
            if (i < 64) {
                return (this.f2714a & (1 << i)) != 0;
            }
            b();
            return this.f2715b.c(i - 64);
        }

        boolean d(int i) {
            if (i >= 64) {
                b();
                return this.f2715b.d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f2714a & j) != 0;
            this.f2714a &= j ^ (-1);
            long j2 = j - 1;
            long j3 = this.f2714a;
            this.f2714a = Long.rotateRight(j3 & (j2 ^ (-1)), 1) | (j3 & j2);
            Bucket bucket = this.f2715b;
            if (bucket != null) {
                if (bucket.c(0)) {
                    e(63);
                }
                this.f2715b.d(0);
            }
            return z;
        }

        void e(int i) {
            if (i >= 64) {
                b();
                this.f2715b.e(i - 64);
            } else {
                this.f2714a |= 1 << i;
            }
        }

        public String toString() {
            if (this.f2715b == null) {
                return Long.toBinaryString(this.f2714a);
            }
            return this.f2715b.toString() + "xx" + Long.toBinaryString(this.f2714a);
        }

        int b(int i) {
            Bucket bucket = this.f2715b;
            if (bucket == null) {
                if (i >= 64) {
                    return Long.bitCount(this.f2714a);
                }
                return Long.bitCount(this.f2714a & ((1 << i) - 1));
            }
            if (i < 64) {
                return Long.bitCount(this.f2714a & ((1 << i) - 1));
            }
            return bucket.b(i - 64) + Long.bitCount(this.f2714a);
        }

        void a() {
            this.f2714a = 0L;
            Bucket bucket = this.f2715b;
            if (bucket != null) {
                bucket.a();
            }
        }

        void a(int i, boolean z) {
            if (i >= 64) {
                b();
                this.f2715b.a(i - 64, z);
                return;
            }
            boolean z2 = (this.f2714a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            long j2 = this.f2714a;
            this.f2714a = ((j2 & (j ^ (-1))) << 1) | (j2 & j);
            if (z) {
                e(i);
            } else {
                a(i);
            }
            if (z2 || this.f2715b != null) {
                b();
                this.f2715b.a(0, z2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, int i, boolean z) {
        int f2;
        if (i < 0) {
            f2 = this.f2711a.getChildCount();
        } else {
            f2 = f(i);
        }
        this.f2712b.a(f2, z);
        if (z) {
            g(view);
        }
        this.f2711a.addView(view, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f2712b.a();
        for (int size = this.f2713c.size() - 1; size >= 0; size--) {
            this.f2711a.onLeftHiddenState(this.f2713c.get(size));
            this.f2713c.remove(size);
        }
        this.f2711a.removeAllViews();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(View view) {
        int indexOfChild = this.f2711a.indexOfChild(view);
        if (indexOfChild >= 0) {
            if (this.f2712b.c(indexOfChild)) {
                this.f2712b.a(indexOfChild);
                h(view);
                return;
            } else {
                throw new RuntimeException("trying to unhide a view that was not hidden" + view);
            }
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View d(int i) {
        return this.f2711a.getChildAt(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(View view) {
        int indexOfChild = this.f2711a.indexOfChild(view);
        if (indexOfChild == -1) {
            h(view);
            return true;
        }
        if (!this.f2712b.c(indexOfChild)) {
            return false;
        }
        this.f2712b.d(indexOfChild);
        h(view);
        this.f2711a.removeViewAt(indexOfChild);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int f2;
        if (i < 0) {
            f2 = this.f2711a.getChildCount();
        } else {
            f2 = f(i);
        }
        this.f2712b.a(f2, z);
        if (z) {
            g(view);
        }
        this.f2711a.attachViewToParent(view, f2, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f2711a.getChildCount();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(View view) {
        int indexOfChild = this.f2711a.indexOfChild(view);
        if (indexOfChild == -1 || this.f2712b.c(indexOfChild)) {
            return -1;
        }
        return indexOfChild - this.f2712b.b(indexOfChild);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(View view) {
        return this.f2713c.contains(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f2711a.getChildCount() - this.f2713c.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        int f2 = f(i);
        this.f2712b.d(f2);
        this.f2711a.detachViewFromParent(f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view) {
        int indexOfChild = this.f2711a.indexOfChild(view);
        if (indexOfChild >= 0) {
            this.f2712b.e(indexOfChild);
            g(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }
}
