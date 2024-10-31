package android.support.v7.widget.util;

import android.support.v7.util.SortedList;
import android.support.v7.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class SortedListAdapterCallback<T2> extends SortedList.Callback<T2> {

    /* renamed from: a, reason: collision with root package name */
    final RecyclerView.Adapter f3212a;

    public SortedListAdapterCallback(RecyclerView.Adapter adapter) {
        this.f3212a = adapter;
    }

    @Override // android.support.v7.util.SortedList.Callback
    public void onChanged(int i, int i2) {
        this.f3212a.notifyItemRangeChanged(i, i2);
    }

    @Override // android.support.v7.util.ListUpdateCallback
    public void onInserted(int i, int i2) {
        this.f3212a.notifyItemRangeInserted(i, i2);
    }

    @Override // android.support.v7.util.ListUpdateCallback
    public void onMoved(int i, int i2) {
        this.f3212a.notifyItemMoved(i, i2);
    }

    @Override // android.support.v7.util.ListUpdateCallback
    public void onRemoved(int i, int i2) {
        this.f3212a.notifyItemRangeRemoved(i, i2);
    }

    @Override // android.support.v7.util.SortedList.Callback, android.support.v7.util.ListUpdateCallback
    public void onChanged(int i, int i2, Object obj) {
        this.f3212a.notifyItemRangeChanged(i, i2, obj);
    }
}
