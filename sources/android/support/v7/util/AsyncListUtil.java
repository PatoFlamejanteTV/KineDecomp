package android.support.v7.util;

import android.support.v7.util.ThreadUtil;
import android.support.v7.util.TileList;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;

/* loaded from: classes.dex */
public class AsyncListUtil<T> {

    /* renamed from: a */
    final Class<T> f2287a;

    /* renamed from: b */
    final int f2288b;

    /* renamed from: c */
    final DataCallback<T> f2289c;

    /* renamed from: d */
    final ViewCallback f2290d;

    /* renamed from: e */
    final TileList<T> f2291e;

    /* renamed from: f */
    final ThreadUtil.MainThreadCallback<T> f2292f;

    /* renamed from: g */
    final ThreadUtil.BackgroundCallback<T> f2293g;
    boolean k;

    /* renamed from: h */
    final int[] f2294h = new int[2];
    final int[] i = new int[2];
    final int[] j = new int[2];
    private int l = 0;
    int m = 0;
    int n = 0;
    int o = this.n;
    final SparseIntArray p = new SparseIntArray();
    private final ThreadUtil.MainThreadCallback<T> q = new ThreadUtil.MainThreadCallback<T>() { // from class: android.support.v7.util.AsyncListUtil.1
        AnonymousClass1() {
        }

        private void a() {
            for (int i = 0; i < AsyncListUtil.this.f2291e.size(); i++) {
                AsyncListUtil asyncListUtil = AsyncListUtil.this;
                asyncListUtil.f2293g.recycleTile(asyncListUtil.f2291e.getAtIndex(i));
            }
            AsyncListUtil.this.f2291e.clear();
        }

        @Override // android.support.v7.util.ThreadUtil.MainThreadCallback
        public void addTile(int i, TileList.Tile<T> tile) {
            if (!a(i)) {
                AsyncListUtil.this.f2293g.recycleTile(tile);
                return;
            }
            TileList.Tile<T> addOrReplace = AsyncListUtil.this.f2291e.addOrReplace(tile);
            if (addOrReplace != null) {
                Log.e("AsyncListUtil", "duplicate tile @" + addOrReplace.mStartPosition);
                AsyncListUtil.this.f2293g.recycleTile(addOrReplace);
            }
            int i2 = tile.mStartPosition + tile.mItemCount;
            int i3 = 0;
            while (i3 < AsyncListUtil.this.p.size()) {
                int keyAt = AsyncListUtil.this.p.keyAt(i3);
                if (tile.mStartPosition > keyAt || keyAt >= i2) {
                    i3++;
                } else {
                    AsyncListUtil.this.p.removeAt(i3);
                    AsyncListUtil.this.f2290d.onItemLoaded(keyAt);
                }
            }
        }

        @Override // android.support.v7.util.ThreadUtil.MainThreadCallback
        public void removeTile(int i, int i2) {
            if (a(i)) {
                TileList.Tile<T> removeAtPos = AsyncListUtil.this.f2291e.removeAtPos(i2);
                if (removeAtPos == null) {
                    Log.e("AsyncListUtil", "tile not found @" + i2);
                    return;
                }
                AsyncListUtil.this.f2293g.recycleTile(removeAtPos);
            }
        }

        @Override // android.support.v7.util.ThreadUtil.MainThreadCallback
        public void updateItemCount(int i, int i2) {
            if (a(i)) {
                AsyncListUtil asyncListUtil = AsyncListUtil.this;
                asyncListUtil.m = i2;
                asyncListUtil.f2290d.onDataRefresh();
                AsyncListUtil asyncListUtil2 = AsyncListUtil.this;
                asyncListUtil2.n = asyncListUtil2.o;
                a();
                AsyncListUtil asyncListUtil3 = AsyncListUtil.this;
                asyncListUtil3.k = false;
                asyncListUtil3.a();
            }
        }

        private boolean a(int i) {
            return i == AsyncListUtil.this.o;
        }
    };
    private final ThreadUtil.BackgroundCallback<T> r = new ThreadUtil.BackgroundCallback<T>() { // from class: android.support.v7.util.AsyncListUtil.2

        /* renamed from: a */
        private TileList.Tile<T> f2296a;

        /* renamed from: b */
        final SparseBooleanArray f2297b = new SparseBooleanArray();

        /* renamed from: c */
        private int f2298c;

        /* renamed from: d */
        private int f2299d;

        /* renamed from: e */
        private int f2300e;

        /* renamed from: f */
        private int f2301f;

        AnonymousClass2() {
        }

        private void a(int i, int i2, int i3, boolean z) {
            int i4 = i;
            while (i4 <= i2) {
                AsyncListUtil.this.f2293g.loadTile(z ? (i2 + i) - i4 : i4, i3);
                i4 += AsyncListUtil.this.f2288b;
            }
        }

        private int b(int i) {
            return i - (i % AsyncListUtil.this.f2288b);
        }

        private boolean c(int i) {
            return this.f2297b.get(i);
        }

        private void d(int i) {
            this.f2297b.delete(i);
            AsyncListUtil.this.f2292f.removeTile(this.f2298c, i);
        }

        @Override // android.support.v7.util.ThreadUtil.BackgroundCallback
        public void loadTile(int i, int i2) {
            if (c(i)) {
                return;
            }
            TileList.Tile<T> a2 = a();
            a2.mStartPosition = i;
            a2.mItemCount = Math.min(AsyncListUtil.this.f2288b, this.f2299d - a2.mStartPosition);
            AsyncListUtil.this.f2289c.fillData(a2.mItems, a2.mStartPosition, a2.mItemCount);
            a(i2);
            a(a2);
        }

        @Override // android.support.v7.util.ThreadUtil.BackgroundCallback
        public void recycleTile(TileList.Tile<T> tile) {
            AsyncListUtil.this.f2289c.recycleData(tile.mItems, tile.mItemCount);
            tile.f2358a = this.f2296a;
            this.f2296a = tile;
        }

        @Override // android.support.v7.util.ThreadUtil.BackgroundCallback
        public void refresh(int i) {
            this.f2298c = i;
            this.f2297b.clear();
            this.f2299d = AsyncListUtil.this.f2289c.refreshData();
            AsyncListUtil.this.f2292f.updateItemCount(this.f2298c, this.f2299d);
        }

        @Override // android.support.v7.util.ThreadUtil.BackgroundCallback
        public void updateRange(int i, int i2, int i3, int i4, int i5) {
            if (i > i2) {
                return;
            }
            int b2 = b(i);
            int b3 = b(i2);
            this.f2300e = b(i3);
            this.f2301f = b(i4);
            if (i5 == 1) {
                a(this.f2300e, b3, i5, true);
                a(b3 + AsyncListUtil.this.f2288b, this.f2301f, i5, false);
            } else {
                a(b2, this.f2301f, i5, false);
                a(this.f2300e, b2 - AsyncListUtil.this.f2288b, i5, true);
            }
        }

        private TileList.Tile<T> a() {
            TileList.Tile<T> tile = this.f2296a;
            if (tile != null) {
                this.f2296a = tile.f2358a;
                return tile;
            }
            AsyncListUtil asyncListUtil = AsyncListUtil.this;
            return new TileList.Tile<>(asyncListUtil.f2287a, asyncListUtil.f2288b);
        }

        private void a(TileList.Tile<T> tile) {
            this.f2297b.put(tile.mStartPosition, true);
            AsyncListUtil.this.f2292f.addTile(this.f2298c, tile);
        }

        private void a(int i) {
            int maxCachedTiles = AsyncListUtil.this.f2289c.getMaxCachedTiles();
            while (this.f2297b.size() >= maxCachedTiles) {
                int keyAt = this.f2297b.keyAt(0);
                SparseBooleanArray sparseBooleanArray = this.f2297b;
                int keyAt2 = sparseBooleanArray.keyAt(sparseBooleanArray.size() - 1);
                int i2 = this.f2300e - keyAt;
                int i3 = keyAt2 - this.f2301f;
                if (i2 > 0 && (i2 >= i3 || i == 2)) {
                    d(keyAt);
                } else {
                    if (i3 <= 0) {
                        return;
                    }
                    if (i2 >= i3 && i != 1) {
                        return;
                    } else {
                        d(keyAt2);
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public static abstract class DataCallback<T> {
        public abstract void fillData(T[] tArr, int i, int i2);

        public int getMaxCachedTiles() {
            return 10;
        }

        public void recycleData(T[] tArr, int i) {
        }

        public abstract int refreshData();
    }

    /* loaded from: classes.dex */
    public static abstract class ViewCallback {
        public static final int HINT_SCROLL_ASC = 2;
        public static final int HINT_SCROLL_DESC = 1;
        public static final int HINT_SCROLL_NONE = 0;

        public void extendRangeInto(int[] iArr, int[] iArr2, int i) {
            int i2 = (iArr[1] - iArr[0]) + 1;
            int i3 = i2 / 2;
            iArr2[0] = iArr[0] - (i == 1 ? i2 : i3);
            int i4 = iArr[1];
            if (i != 2) {
                i2 = i3;
            }
            iArr2[1] = i4 + i2;
        }

        public abstract void getItemRangeInto(int[] iArr);

        public abstract void onDataRefresh();

        public abstract void onItemLoaded(int i);
    }

    public AsyncListUtil(Class<T> cls, int i, DataCallback<T> dataCallback, ViewCallback viewCallback) {
        this.f2287a = cls;
        this.f2288b = i;
        this.f2289c = dataCallback;
        this.f2290d = viewCallback;
        this.f2291e = new TileList<>(this.f2288b);
        MessageThreadUtil messageThreadUtil = new MessageThreadUtil();
        this.f2292f = messageThreadUtil.getMainThreadProxy(this.q);
        this.f2293g = messageThreadUtil.getBackgroundProxy(this.r);
        refresh();
    }

    private boolean b() {
        return this.o != this.n;
    }

    void a() {
        this.f2290d.getItemRangeInto(this.f2294h);
        int[] iArr = this.f2294h;
        if (iArr[0] > iArr[1] || iArr[0] < 0 || iArr[1] >= this.m) {
            return;
        }
        if (!this.k) {
            this.l = 0;
        } else {
            int i = iArr[0];
            int[] iArr2 = this.i;
            if (i <= iArr2[1] && iArr2[0] <= iArr[1]) {
                if (iArr[0] < iArr2[0]) {
                    this.l = 1;
                } else if (iArr[0] > iArr2[0]) {
                    this.l = 2;
                }
            } else {
                this.l = 0;
            }
        }
        int[] iArr3 = this.i;
        int[] iArr4 = this.f2294h;
        iArr3[0] = iArr4[0];
        iArr3[1] = iArr4[1];
        this.f2290d.extendRangeInto(iArr4, this.j, this.l);
        int[] iArr5 = this.j;
        iArr5[0] = Math.min(this.f2294h[0], Math.max(iArr5[0], 0));
        int[] iArr6 = this.j;
        iArr6[1] = Math.max(this.f2294h[1], Math.min(iArr6[1], this.m - 1));
        ThreadUtil.BackgroundCallback<T> backgroundCallback = this.f2293g;
        int[] iArr7 = this.f2294h;
        int i2 = iArr7[0];
        int i3 = iArr7[1];
        int[] iArr8 = this.j;
        backgroundCallback.updateRange(i2, i3, iArr8[0], iArr8[1], this.l);
    }

    public T getItem(int i) {
        if (i >= 0 && i < this.m) {
            T itemAt = this.f2291e.getItemAt(i);
            if (itemAt == null && !b()) {
                this.p.put(i, 0);
            }
            return itemAt;
        }
        throw new IndexOutOfBoundsException(i + " is not within 0 and " + this.m);
    }

    public int getItemCount() {
        return this.m;
    }

    public void onRangeChanged() {
        if (b()) {
            return;
        }
        a();
        this.k = true;
    }

    public void refresh() {
        this.p.clear();
        ThreadUtil.BackgroundCallback<T> backgroundCallback = this.f2293g;
        int i = this.o + 1;
        this.o = i;
        backgroundCallback.refresh(i);
    }

    /* renamed from: android.support.v7.util.AsyncListUtil$2 */
    /* loaded from: classes.dex */
    class AnonymousClass2 implements ThreadUtil.BackgroundCallback<T> {

        /* renamed from: a */
        private TileList.Tile<T> f2296a;

        /* renamed from: b */
        final SparseBooleanArray f2297b = new SparseBooleanArray();

        /* renamed from: c */
        private int f2298c;

        /* renamed from: d */
        private int f2299d;

        /* renamed from: e */
        private int f2300e;

        /* renamed from: f */
        private int f2301f;

        AnonymousClass2() {
        }

        private void a(int i, int i2, int i3, boolean z) {
            int i4 = i;
            while (i4 <= i2) {
                AsyncListUtil.this.f2293g.loadTile(z ? (i2 + i) - i4 : i4, i3);
                i4 += AsyncListUtil.this.f2288b;
            }
        }

        private int b(int i) {
            return i - (i % AsyncListUtil.this.f2288b);
        }

        private boolean c(int i) {
            return this.f2297b.get(i);
        }

        private void d(int i) {
            this.f2297b.delete(i);
            AsyncListUtil.this.f2292f.removeTile(this.f2298c, i);
        }

        @Override // android.support.v7.util.ThreadUtil.BackgroundCallback
        public void loadTile(int i, int i2) {
            if (c(i)) {
                return;
            }
            TileList.Tile<T> a2 = a();
            a2.mStartPosition = i;
            a2.mItemCount = Math.min(AsyncListUtil.this.f2288b, this.f2299d - a2.mStartPosition);
            AsyncListUtil.this.f2289c.fillData(a2.mItems, a2.mStartPosition, a2.mItemCount);
            a(i2);
            a(a2);
        }

        @Override // android.support.v7.util.ThreadUtil.BackgroundCallback
        public void recycleTile(TileList.Tile<T> tile) {
            AsyncListUtil.this.f2289c.recycleData(tile.mItems, tile.mItemCount);
            tile.f2358a = this.f2296a;
            this.f2296a = tile;
        }

        @Override // android.support.v7.util.ThreadUtil.BackgroundCallback
        public void refresh(int i) {
            this.f2298c = i;
            this.f2297b.clear();
            this.f2299d = AsyncListUtil.this.f2289c.refreshData();
            AsyncListUtil.this.f2292f.updateItemCount(this.f2298c, this.f2299d);
        }

        @Override // android.support.v7.util.ThreadUtil.BackgroundCallback
        public void updateRange(int i, int i2, int i3, int i4, int i5) {
            if (i > i2) {
                return;
            }
            int b2 = b(i);
            int b3 = b(i2);
            this.f2300e = b(i3);
            this.f2301f = b(i4);
            if (i5 == 1) {
                a(this.f2300e, b3, i5, true);
                a(b3 + AsyncListUtil.this.f2288b, this.f2301f, i5, false);
            } else {
                a(b2, this.f2301f, i5, false);
                a(this.f2300e, b2 - AsyncListUtil.this.f2288b, i5, true);
            }
        }

        private TileList.Tile<T> a() {
            TileList.Tile<T> tile = this.f2296a;
            if (tile != null) {
                this.f2296a = tile.f2358a;
                return tile;
            }
            AsyncListUtil asyncListUtil = AsyncListUtil.this;
            return new TileList.Tile<>(asyncListUtil.f2287a, asyncListUtil.f2288b);
        }

        private void a(TileList.Tile<T> tile) {
            this.f2297b.put(tile.mStartPosition, true);
            AsyncListUtil.this.f2292f.addTile(this.f2298c, tile);
        }

        private void a(int i) {
            int maxCachedTiles = AsyncListUtil.this.f2289c.getMaxCachedTiles();
            while (this.f2297b.size() >= maxCachedTiles) {
                int keyAt = this.f2297b.keyAt(0);
                SparseBooleanArray sparseBooleanArray = this.f2297b;
                int keyAt2 = sparseBooleanArray.keyAt(sparseBooleanArray.size() - 1);
                int i2 = this.f2300e - keyAt;
                int i3 = keyAt2 - this.f2301f;
                if (i2 > 0 && (i2 >= i3 || i == 2)) {
                    d(keyAt);
                } else {
                    if (i3 <= 0) {
                        return;
                    }
                    if (i2 >= i3 && i != 1) {
                        return;
                    } else {
                        d(keyAt2);
                    }
                }
            }
        }
    }

    /* renamed from: android.support.v7.util.AsyncListUtil$1 */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements ThreadUtil.MainThreadCallback<T> {
        AnonymousClass1() {
        }

        private void a() {
            for (int i = 0; i < AsyncListUtil.this.f2291e.size(); i++) {
                AsyncListUtil asyncListUtil = AsyncListUtil.this;
                asyncListUtil.f2293g.recycleTile(asyncListUtil.f2291e.getAtIndex(i));
            }
            AsyncListUtil.this.f2291e.clear();
        }

        @Override // android.support.v7.util.ThreadUtil.MainThreadCallback
        public void addTile(int i, TileList.Tile<T> tile) {
            if (!a(i)) {
                AsyncListUtil.this.f2293g.recycleTile(tile);
                return;
            }
            TileList.Tile<T> addOrReplace = AsyncListUtil.this.f2291e.addOrReplace(tile);
            if (addOrReplace != null) {
                Log.e("AsyncListUtil", "duplicate tile @" + addOrReplace.mStartPosition);
                AsyncListUtil.this.f2293g.recycleTile(addOrReplace);
            }
            int i2 = tile.mStartPosition + tile.mItemCount;
            int i3 = 0;
            while (i3 < AsyncListUtil.this.p.size()) {
                int keyAt = AsyncListUtil.this.p.keyAt(i3);
                if (tile.mStartPosition > keyAt || keyAt >= i2) {
                    i3++;
                } else {
                    AsyncListUtil.this.p.removeAt(i3);
                    AsyncListUtil.this.f2290d.onItemLoaded(keyAt);
                }
            }
        }

        @Override // android.support.v7.util.ThreadUtil.MainThreadCallback
        public void removeTile(int i, int i2) {
            if (a(i)) {
                TileList.Tile<T> removeAtPos = AsyncListUtil.this.f2291e.removeAtPos(i2);
                if (removeAtPos == null) {
                    Log.e("AsyncListUtil", "tile not found @" + i2);
                    return;
                }
                AsyncListUtil.this.f2293g.recycleTile(removeAtPos);
            }
        }

        @Override // android.support.v7.util.ThreadUtil.MainThreadCallback
        public void updateItemCount(int i, int i2) {
            if (a(i)) {
                AsyncListUtil asyncListUtil = AsyncListUtil.this;
                asyncListUtil.m = i2;
                asyncListUtil.f2290d.onDataRefresh();
                AsyncListUtil asyncListUtil2 = AsyncListUtil.this;
                asyncListUtil2.n = asyncListUtil2.o;
                a();
                AsyncListUtil asyncListUtil3 = AsyncListUtil.this;
                asyncListUtil3.k = false;
                asyncListUtil3.a();
            }
        }

        private boolean a(int i) {
            return i == AsyncListUtil.this.o;
        }
    }
}
