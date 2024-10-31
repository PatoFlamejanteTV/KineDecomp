package android.support.v7.widget;

import android.support.v4.util.Pools;
import android.support.v7.widget.OpReorderer;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class AdapterHelper implements OpReorderer.Callback {

    /* renamed from: a */
    private Pools.Pool<UpdateOp> f2593a;

    /* renamed from: b */
    final ArrayList<UpdateOp> f2594b;

    /* renamed from: c */
    final ArrayList<UpdateOp> f2595c;

    /* renamed from: d */
    final Callback f2596d;

    /* renamed from: e */
    Runnable f2597e;

    /* renamed from: f */
    final boolean f2598f;

    /* renamed from: g */
    final OpReorderer f2599g;

    /* renamed from: h */
    private int f2600h;

    /* loaded from: classes.dex */
    public interface Callback {
        RecyclerView.ViewHolder findViewHolder(int i);

        void markViewHoldersUpdated(int i, int i2, Object obj);

        void offsetPositionsForAdd(int i, int i2);

        void offsetPositionsForMove(int i, int i2);

        void offsetPositionsForRemovingInvisible(int i, int i2);

        void offsetPositionsForRemovingLaidOutOrNewView(int i, int i2);

        void onDispatchFirstPass(UpdateOp updateOp);

        void onDispatchSecondPass(UpdateOp updateOp);
    }

    /* loaded from: classes.dex */
    public static class UpdateOp {

        /* renamed from: a */
        int f2601a;

        /* renamed from: b */
        int f2602b;

        /* renamed from: c */
        Object f2603c;

        /* renamed from: d */
        int f2604d;

        UpdateOp(int i, int i2, int i3, Object obj) {
            this.f2601a = i;
            this.f2602b = i2;
            this.f2604d = i3;
            this.f2603c = obj;
        }

        String a() {
            int i = this.f2601a;
            return i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || UpdateOp.class != obj.getClass()) {
                return false;
            }
            UpdateOp updateOp = (UpdateOp) obj;
            int i = this.f2601a;
            if (i != updateOp.f2601a) {
                return false;
            }
            if (i == 8 && Math.abs(this.f2604d - this.f2602b) == 1 && this.f2604d == updateOp.f2602b && this.f2602b == updateOp.f2604d) {
                return true;
            }
            if (this.f2604d != updateOp.f2604d || this.f2602b != updateOp.f2602b) {
                return false;
            }
            Object obj2 = this.f2603c;
            if (obj2 != null) {
                if (!obj2.equals(updateOp.f2603c)) {
                    return false;
                }
            } else if (updateOp.f2603c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f2601a * 31) + this.f2602b) * 31) + this.f2604d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f2602b + "c:" + this.f2604d + ",p:" + this.f2603c + "]";
        }
    }

    public AdapterHelper(Callback callback) {
        this(callback, false);
    }

    private void b(UpdateOp updateOp) {
        f(updateOp);
    }

    private void c(UpdateOp updateOp) {
        boolean z;
        char c2;
        int i = updateOp.f2602b;
        int i2 = updateOp.f2604d + i;
        int i3 = 0;
        char c3 = 65535;
        int i4 = i;
        while (i4 < i2) {
            if (this.f2596d.findViewHolder(i4) != null || c(i4)) {
                if (c3 == 0) {
                    e(obtainUpdateOp(2, i, i3, null));
                    z = true;
                } else {
                    z = false;
                }
                c2 = 1;
            } else {
                if (c3 == 1) {
                    f(obtainUpdateOp(2, i, i3, null));
                    z = true;
                } else {
                    z = false;
                }
                c2 = 0;
            }
            if (z) {
                i4 -= i3;
                i2 -= i3;
                i3 = 1;
            } else {
                i3++;
            }
            i4++;
            c3 = c2;
        }
        if (i3 != updateOp.f2604d) {
            recycleUpdateOp(updateOp);
            updateOp = obtainUpdateOp(2, i, i3, null);
        }
        if (c3 == 0) {
            e(updateOp);
        } else {
            f(updateOp);
        }
    }

    private void d(UpdateOp updateOp) {
        int i = updateOp.f2602b;
        int i2 = updateOp.f2604d + i;
        int i3 = i;
        int i4 = 0;
        char c2 = 65535;
        while (i < i2) {
            if (this.f2596d.findViewHolder(i) != null || c(i)) {
                if (c2 == 0) {
                    e(obtainUpdateOp(4, i3, i4, updateOp.f2603c));
                    i3 = i;
                    i4 = 0;
                }
                c2 = 1;
            } else {
                if (c2 == 1) {
                    f(obtainUpdateOp(4, i3, i4, updateOp.f2603c));
                    i3 = i;
                    i4 = 0;
                }
                c2 = 0;
            }
            i4++;
            i++;
        }
        if (i4 != updateOp.f2604d) {
            Object obj = updateOp.f2603c;
            recycleUpdateOp(updateOp);
            updateOp = obtainUpdateOp(4, i3, i4, obj);
        }
        if (c2 == 0) {
            e(updateOp);
        } else {
            f(updateOp);
        }
    }

    public void a() {
        int size = this.f2595c.size();
        for (int i = 0; i < size; i++) {
            this.f2596d.onDispatchSecondPass(this.f2595c.get(i));
        }
        a(this.f2595c);
        this.f2600h = 0;
    }

    public int applyPendingUpdatesToPosition(int i) {
        int size = this.f2594b.size();
        for (int i2 = 0; i2 < size; i2++) {
            UpdateOp updateOp = this.f2594b.get(i2);
            int i3 = updateOp.f2601a;
            if (i3 != 1) {
                if (i3 == 2) {
                    int i4 = updateOp.f2602b;
                    if (i4 <= i) {
                        int i5 = updateOp.f2604d;
                        if (i4 + i5 > i) {
                            return -1;
                        }
                        i -= i5;
                    } else {
                        continue;
                    }
                } else if (i3 == 8) {
                    int i6 = updateOp.f2602b;
                    if (i6 == i) {
                        i = updateOp.f2604d;
                    } else {
                        if (i6 < i) {
                            i--;
                        }
                        if (updateOp.f2604d <= i) {
                            i++;
                        }
                    }
                }
            } else if (updateOp.f2602b <= i) {
                i += updateOp.f2604d;
            }
        }
        return i;
    }

    public void e() {
        this.f2599g.a(this.f2594b);
        int size = this.f2594b.size();
        for (int i = 0; i < size; i++) {
            UpdateOp updateOp = this.f2594b.get(i);
            int i2 = updateOp.f2601a;
            if (i2 == 1) {
                a(updateOp);
            } else if (i2 == 2) {
                c(updateOp);
            } else if (i2 == 4) {
                d(updateOp);
            } else if (i2 == 8) {
                b(updateOp);
            }
            Runnable runnable = this.f2597e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f2594b.clear();
    }

    public void f() {
        a(this.f2594b);
        a(this.f2595c);
        this.f2600h = 0;
    }

    @Override // android.support.v7.widget.OpReorderer.Callback
    public UpdateOp obtainUpdateOp(int i, int i2, int i3, Object obj) {
        UpdateOp acquire = this.f2593a.acquire();
        if (acquire == null) {
            return new UpdateOp(i, i2, i3, obj);
        }
        acquire.f2601a = i;
        acquire.f2602b = i2;
        acquire.f2604d = i3;
        acquire.f2603c = obj;
        return acquire;
    }

    @Override // android.support.v7.widget.OpReorderer.Callback
    public void recycleUpdateOp(UpdateOp updateOp) {
        if (this.f2598f) {
            return;
        }
        updateOp.f2603c = null;
        this.f2593a.release(updateOp);
    }

    AdapterHelper(Callback callback, boolean z) {
        this.f2593a = new Pools.SimplePool(30);
        this.f2594b = new ArrayList<>();
        this.f2595c = new ArrayList<>();
        this.f2600h = 0;
        this.f2596d = callback;
        this.f2598f = z;
        this.f2599g = new OpReorderer(this);
    }

    public boolean b(int i) {
        return (i & this.f2600h) != 0;
    }

    public boolean b(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.f2594b.add(obtainUpdateOp(1, i, i2, null));
        this.f2600h |= 1;
        return this.f2594b.size() == 1;
    }

    private void f(UpdateOp updateOp) {
        this.f2595c.add(updateOp);
        int i = updateOp.f2601a;
        if (i == 1) {
            this.f2596d.offsetPositionsForAdd(updateOp.f2602b, updateOp.f2604d);
            return;
        }
        if (i == 2) {
            this.f2596d.offsetPositionsForRemovingLaidOutOrNewView(updateOp.f2602b, updateOp.f2604d);
            return;
        }
        if (i == 4) {
            this.f2596d.markViewHoldersUpdated(updateOp.f2602b, updateOp.f2604d, updateOp.f2603c);
        } else {
            if (i == 8) {
                this.f2596d.offsetPositionsForMove(updateOp.f2602b, updateOp.f2604d);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + updateOp);
        }
    }

    void a(UpdateOp updateOp, int i) {
        this.f2596d.onDispatchFirstPass(updateOp);
        int i2 = updateOp.f2601a;
        if (i2 == 2) {
            this.f2596d.offsetPositionsForRemovingInvisible(i, updateOp.f2604d);
        } else {
            if (i2 == 4) {
                this.f2596d.markViewHoldersUpdated(i, updateOp.f2604d, updateOp.f2603c);
                return;
            }
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    public void b() {
        a();
        int size = this.f2594b.size();
        for (int i = 0; i < size; i++) {
            UpdateOp updateOp = this.f2594b.get(i);
            int i2 = updateOp.f2601a;
            if (i2 == 1) {
                this.f2596d.onDispatchSecondPass(updateOp);
                this.f2596d.offsetPositionsForAdd(updateOp.f2602b, updateOp.f2604d);
            } else if (i2 == 2) {
                this.f2596d.onDispatchSecondPass(updateOp);
                this.f2596d.offsetPositionsForRemovingInvisible(updateOp.f2602b, updateOp.f2604d);
            } else if (i2 == 4) {
                this.f2596d.onDispatchSecondPass(updateOp);
                this.f2596d.markViewHoldersUpdated(updateOp.f2602b, updateOp.f2604d, updateOp.f2603c);
            } else if (i2 == 8) {
                this.f2596d.onDispatchSecondPass(updateOp);
                this.f2596d.offsetPositionsForMove(updateOp.f2602b, updateOp.f2604d);
            }
            Runnable runnable = this.f2597e;
            if (runnable != null) {
                runnable.run();
            }
        }
        a(this.f2594b);
        this.f2600h = 0;
    }

    private void a(UpdateOp updateOp) {
        f(updateOp);
    }

    public int a(int i) {
        return a(i, 0);
    }

    private void e(UpdateOp updateOp) {
        int i;
        int i2 = updateOp.f2601a;
        if (i2 != 1 && i2 != 8) {
            int d2 = d(updateOp.f2602b, i2);
            int i3 = updateOp.f2602b;
            int i4 = updateOp.f2601a;
            if (i4 == 2) {
                i = 0;
            } else {
                if (i4 != 4) {
                    throw new IllegalArgumentException("op should be remove or update." + updateOp);
                }
                i = 1;
            }
            int i5 = d2;
            int i6 = i3;
            int i7 = 1;
            for (int i8 = 1; i8 < updateOp.f2604d; i8++) {
                int d3 = d(updateOp.f2602b + (i * i8), updateOp.f2601a);
                int i9 = updateOp.f2601a;
                if (i9 == 2 ? d3 == i5 : i9 == 4 && d3 == i5 + 1) {
                    i7++;
                } else {
                    UpdateOp obtainUpdateOp = obtainUpdateOp(updateOp.f2601a, i5, i7, updateOp.f2603c);
                    a(obtainUpdateOp, i6);
                    recycleUpdateOp(obtainUpdateOp);
                    if (updateOp.f2601a == 4) {
                        i6 += i7;
                    }
                    i5 = d3;
                    i7 = 1;
                }
            }
            Object obj = updateOp.f2603c;
            recycleUpdateOp(updateOp);
            if (i7 > 0) {
                UpdateOp obtainUpdateOp2 = obtainUpdateOp(updateOp.f2601a, i5, i7, obj);
                a(obtainUpdateOp2, i6);
                recycleUpdateOp(obtainUpdateOp2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    int a(int i, int i2) {
        int size = this.f2595c.size();
        while (i2 < size) {
            UpdateOp updateOp = this.f2595c.get(i2);
            int i3 = updateOp.f2601a;
            if (i3 == 8) {
                int i4 = updateOp.f2602b;
                if (i4 == i) {
                    i = updateOp.f2604d;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (updateOp.f2604d <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = updateOp.f2602b;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = updateOp.f2604d;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += updateOp.f2604d;
                }
            }
            i2++;
        }
        return i;
    }

    private boolean c(int i) {
        int size = this.f2595c.size();
        for (int i2 = 0; i2 < size; i2++) {
            UpdateOp updateOp = this.f2595c.get(i2);
            int i3 = updateOp.f2601a;
            if (i3 == 8) {
                if (a(updateOp.f2604d, i2 + 1) == i) {
                    return true;
                }
            } else if (i3 == 1) {
                int i4 = updateOp.f2602b;
                int i5 = updateOp.f2604d + i4;
                while (i4 < i5) {
                    if (a(i4, i2 + 1) == i) {
                        return true;
                    }
                    i4++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private int d(int i, int i2) {
        for (int size = this.f2595c.size() - 1; size >= 0; size--) {
            UpdateOp updateOp = this.f2595c.get(size);
            int i3 = updateOp.f2601a;
            if (i3 == 8) {
                int i4 = updateOp.f2602b;
                int i5 = updateOp.f2604d;
                if (i4 >= i5) {
                    i5 = i4;
                    i4 = i5;
                }
                if (i >= i4 && i <= i5) {
                    int i6 = updateOp.f2602b;
                    if (i4 == i6) {
                        if (i2 == 1) {
                            updateOp.f2604d++;
                        } else if (i2 == 2) {
                            updateOp.f2604d--;
                        }
                        i++;
                    } else {
                        if (i2 == 1) {
                            updateOp.f2602b = i6 + 1;
                        } else if (i2 == 2) {
                            updateOp.f2602b = i6 - 1;
                        }
                        i--;
                    }
                } else {
                    int i7 = updateOp.f2602b;
                    if (i < i7) {
                        if (i2 == 1) {
                            updateOp.f2602b = i7 + 1;
                            updateOp.f2604d++;
                        } else if (i2 == 2) {
                            updateOp.f2602b = i7 - 1;
                            updateOp.f2604d--;
                        }
                    }
                }
            } else {
                int i8 = updateOp.f2602b;
                if (i8 <= i) {
                    if (i3 == 1) {
                        i -= updateOp.f2604d;
                    } else if (i3 == 2) {
                        i += updateOp.f2604d;
                    }
                } else if (i2 == 1) {
                    updateOp.f2602b = i8 + 1;
                } else if (i2 == 2) {
                    updateOp.f2602b = i8 - 1;
                }
            }
        }
        for (int size2 = this.f2595c.size() - 1; size2 >= 0; size2--) {
            UpdateOp updateOp2 = this.f2595c.get(size2);
            if (updateOp2.f2601a == 8) {
                int i9 = updateOp2.f2604d;
                if (i9 == updateOp2.f2602b || i9 < 0) {
                    this.f2595c.remove(size2);
                    recycleUpdateOp(updateOp2);
                }
            } else if (updateOp2.f2604d <= 0) {
                this.f2595c.remove(size2);
                recycleUpdateOp(updateOp2);
            }
        }
        return i;
    }

    public boolean c() {
        return this.f2594b.size() > 0;
    }

    public boolean a(int i, int i2, Object obj) {
        if (i2 < 1) {
            return false;
        }
        this.f2594b.add(obtainUpdateOp(4, i, i2, obj));
        this.f2600h |= 4;
        return this.f2594b.size() == 1;
    }

    public boolean c(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.f2594b.add(obtainUpdateOp(2, i, i2, null));
        this.f2600h |= 2;
        return this.f2594b.size() == 1;
    }

    public boolean a(int i, int i2, int i3) {
        if (i == i2) {
            return false;
        }
        if (i3 == 1) {
            this.f2594b.add(obtainUpdateOp(8, i, i2, null));
            this.f2600h |= 8;
            return this.f2594b.size() == 1;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    void a(List<UpdateOp> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            recycleUpdateOp(list.get(i));
        }
        list.clear();
    }

    public boolean d() {
        return (this.f2595c.isEmpty() || this.f2594b.isEmpty()) ? false : true;
    }
}
