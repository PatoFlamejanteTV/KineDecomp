package android.support.v7.util;

import android.support.v7.widget.RecyclerView;

/* loaded from: classes.dex */
public final class AdapterListUpdateCallback implements ListUpdateCallback {

    /* renamed from: a, reason: collision with root package name */
    private final RecyclerView.Adapter f2286a;

    public AdapterListUpdateCallback(RecyclerView.Adapter adapter) {
        this.f2286a = adapter;
    }

    @Override // android.support.v7.util.ListUpdateCallback
    public void onChanged(int i, int i2, Object obj) {
        this.f2286a.notifyItemRangeChanged(i, i2, obj);
    }

    @Override // android.support.v7.util.ListUpdateCallback
    public void onInserted(int i, int i2) {
        this.f2286a.notifyItemRangeInserted(i, i2);
    }

    @Override // android.support.v7.util.ListUpdateCallback
    public void onMoved(int i, int i2) {
        this.f2286a.notifyItemMoved(i, i2);
    }

    @Override // android.support.v7.util.ListUpdateCallback
    public void onRemoved(int i, int i2) {
        this.f2286a.notifyItemRangeRemoved(i, i2);
    }
}
