package android.support.v7.widget;

import android.support.v4.os.TraceCompat;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class GapWorker implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    static final ThreadLocal<GapWorker> f2793a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    static Comparator<Task> f2794b = new Comparator<Task>() { // from class: android.support.v7.widget.GapWorker.1
        @Override // java.util.Comparator
        public int compare(Task task, Task task2) {
            if ((task.view == null) != (task2.view == null)) {
                return task.view == null ? 1 : -1;
            }
            boolean z = task.immediate;
            if (z != task2.immediate) {
                return z ? -1 : 1;
            }
            int i = task2.viewVelocity - task.viewVelocity;
            if (i != 0) {
                return i;
            }
            int i2 = task.distanceToItem - task2.distanceToItem;
            if (i2 != 0) {
                return i2;
            }
            return 0;
        }
    };

    /* renamed from: d, reason: collision with root package name */
    long f2796d;

    /* renamed from: e, reason: collision with root package name */
    long f2797e;

    /* renamed from: c, reason: collision with root package name */
    ArrayList<RecyclerView> f2795c = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<Task> f2798f = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Task {
        public int distanceToItem;
        public boolean immediate;
        public int position;
        public RecyclerView view;
        public int viewVelocity;

        Task() {
        }

        public void clear() {
            this.immediate = false;
            this.viewVelocity = 0;
            this.distanceToItem = 0;
            this.view = null;
            this.position = 0;
        }
    }

    private void b() {
        Task task;
        int size = this.f2795c.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.f2795c.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.qa.a(recyclerView, false);
                i += recyclerView.qa.f2802d;
            }
        }
        this.f2798f.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.f2795c.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView2.qa;
                int abs = Math.abs(layoutPrefetchRegistryImpl.f2799a) + Math.abs(layoutPrefetchRegistryImpl.f2800b);
                int i5 = i3;
                for (int i6 = 0; i6 < layoutPrefetchRegistryImpl.f2802d * 2; i6 += 2) {
                    if (i5 >= this.f2798f.size()) {
                        task = new Task();
                        this.f2798f.add(task);
                    } else {
                        task = this.f2798f.get(i5);
                    }
                    int i7 = layoutPrefetchRegistryImpl.f2801c[i6 + 1];
                    task.immediate = i7 <= abs;
                    task.viewVelocity = abs;
                    task.distanceToItem = i7;
                    task.view = recyclerView2;
                    task.position = layoutPrefetchRegistryImpl.f2801c[i6];
                    i5++;
                }
                i3 = i5;
            }
        }
        Collections.sort(this.f2798f, f2794b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.f2796d == 0) {
            this.f2796d = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.qa.a(i, i2);
    }

    public void add(RecyclerView recyclerView) {
        this.f2795c.add(recyclerView);
    }

    public void remove(RecyclerView recyclerView) {
        this.f2795c.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            TraceCompat.beginSection("RV Prefetch");
            if (!this.f2795c.isEmpty()) {
                int size = this.f2795c.size();
                long j = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = this.f2795c.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j = Math.max(recyclerView.getDrawingTime(), j);
                    }
                }
                if (j != 0) {
                    a(TimeUnit.MILLISECONDS.toNanos(j) + this.f2797e);
                }
            }
        } finally {
            this.f2796d = 0L;
            TraceCompat.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class LayoutPrefetchRegistryImpl implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {

        /* renamed from: a, reason: collision with root package name */
        int f2799a;

        /* renamed from: b, reason: collision with root package name */
        int f2800b;

        /* renamed from: c, reason: collision with root package name */
        int[] f2801c;

        /* renamed from: d, reason: collision with root package name */
        int f2802d;

        void a(int i, int i2) {
            this.f2799a = i;
            this.f2800b = i2;
        }

        @Override // android.support.v7.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry
        public void addPosition(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 >= 0) {
                int i3 = this.f2802d * 2;
                int[] iArr = this.f2801c;
                if (iArr == null) {
                    this.f2801c = new int[4];
                    Arrays.fill(this.f2801c, -1);
                } else if (i3 >= iArr.length) {
                    this.f2801c = new int[i3 * 2];
                    System.arraycopy(iArr, 0, this.f2801c, 0, iArr.length);
                }
                int[] iArr2 = this.f2801c;
                iArr2[i3] = i;
                iArr2[i3 + 1] = i2;
                this.f2802d++;
                return;
            }
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        }

        void a(RecyclerView recyclerView, boolean z) {
            this.f2802d = 0;
            int[] iArr = this.f2801c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.w;
            if (recyclerView.v == null || layoutManager == null || !layoutManager.isItemPrefetchEnabled()) {
                return;
            }
            if (z) {
                if (!recyclerView.n.c()) {
                    layoutManager.collectInitialPrefetchPositions(recyclerView.v.getItemCount(), this);
                }
            } else if (!recyclerView.hasPendingAdapterUpdates()) {
                layoutManager.collectAdjacentPrefetchPositions(this.f2799a, this.f2800b, recyclerView.ra, this);
            }
            int i = this.f2802d;
            if (i > layoutManager.m) {
                layoutManager.m = i;
                layoutManager.n = z;
                recyclerView.l.h();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(int i) {
            if (this.f2801c != null) {
                int i2 = this.f2802d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.f2801c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            int[] iArr = this.f2801c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f2802d = 0;
        }
    }

    static boolean a(RecyclerView recyclerView, int i) {
        int b2 = recyclerView.o.b();
        for (int i2 = 0; i2 < b2; i2++) {
            RecyclerView.ViewHolder d2 = RecyclerView.d(recyclerView.o.d(i2));
            if (d2.f2964c == i && !d2.h()) {
                return true;
            }
        }
        return false;
    }

    private RecyclerView.ViewHolder a(RecyclerView recyclerView, int i, long j) {
        if (a(recyclerView, i)) {
            return null;
        }
        RecyclerView.Recycler recycler = recyclerView.l;
        try {
            recyclerView.B();
            RecyclerView.ViewHolder a2 = recycler.a(i, false, j);
            if (a2 != null) {
                if (a2.g() && !a2.h()) {
                    recycler.recycleView(a2.itemView);
                } else {
                    recycler.a(a2, false);
                }
            }
            return a2;
        } finally {
            recyclerView.b(false);
        }
    }

    private void a(RecyclerView recyclerView, long j) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.N && recyclerView.o.b() != 0) {
            recyclerView.E();
        }
        LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView.qa;
        layoutPrefetchRegistryImpl.a(recyclerView, true);
        if (layoutPrefetchRegistryImpl.f2802d != 0) {
            try {
                TraceCompat.beginSection("RV Nested Prefetch");
                recyclerView.ra.a(recyclerView.v);
                for (int i = 0; i < layoutPrefetchRegistryImpl.f2802d * 2; i += 2) {
                    a(recyclerView, layoutPrefetchRegistryImpl.f2801c[i], j);
                }
            } finally {
                TraceCompat.endSection();
            }
        }
    }

    private void b(long j) {
        for (int i = 0; i < this.f2798f.size(); i++) {
            Task task = this.f2798f.get(i);
            if (task.view == null) {
                return;
            }
            a(task, j);
            task.clear();
        }
    }

    private void a(Task task, long j) {
        RecyclerView.ViewHolder a2 = a(task.view, task.position, task.immediate ? Long.MAX_VALUE : j);
        if (a2 == null || a2.f2963b == null || !a2.g() || a2.h()) {
            return;
        }
        a(a2.f2963b.get(), j);
    }

    void a(long j) {
        b();
        b(j);
    }
}
