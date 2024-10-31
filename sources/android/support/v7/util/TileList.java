package android.support.v7.util;

import android.util.SparseArray;
import java.lang.reflect.Array;

/* loaded from: classes.dex */
class TileList<T> {

    /* renamed from: a */
    final int f2355a;

    /* renamed from: b */
    private final SparseArray<Tile<T>> f2356b = new SparseArray<>(10);

    /* renamed from: c */
    Tile<T> f2357c;

    /* loaded from: classes.dex */
    public static class Tile<T> {

        /* renamed from: a */
        Tile<T> f2358a;
        public int mItemCount;
        public final T[] mItems;
        public int mStartPosition;

        public Tile(Class<T> cls, int i) {
            this.mItems = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i));
        }

        boolean a(int i) {
            int i2 = this.mStartPosition;
            return i2 <= i && i < i2 + this.mItemCount;
        }

        T b(int i) {
            return this.mItems[i - this.mStartPosition];
        }
    }

    public TileList(int i) {
        this.f2355a = i;
    }

    public Tile<T> addOrReplace(Tile<T> tile) {
        int indexOfKey = this.f2356b.indexOfKey(tile.mStartPosition);
        if (indexOfKey < 0) {
            this.f2356b.put(tile.mStartPosition, tile);
            return null;
        }
        Tile<T> valueAt = this.f2356b.valueAt(indexOfKey);
        this.f2356b.setValueAt(indexOfKey, tile);
        if (this.f2357c == valueAt) {
            this.f2357c = tile;
        }
        return valueAt;
    }

    public void clear() {
        this.f2356b.clear();
    }

    public Tile<T> getAtIndex(int i) {
        return this.f2356b.valueAt(i);
    }

    public T getItemAt(int i) {
        Tile<T> tile = this.f2357c;
        if (tile == null || !tile.a(i)) {
            int indexOfKey = this.f2356b.indexOfKey(i - (i % this.f2355a));
            if (indexOfKey < 0) {
                return null;
            }
            this.f2357c = this.f2356b.valueAt(indexOfKey);
        }
        return this.f2357c.b(i);
    }

    public Tile<T> removeAtPos(int i) {
        Tile<T> tile = this.f2356b.get(i);
        if (this.f2357c == tile) {
            this.f2357c = null;
        }
        this.f2356b.delete(i);
        return tile;
    }

    public int size() {
        return this.f2356b.size();
    }
}
