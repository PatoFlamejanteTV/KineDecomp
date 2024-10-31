package android.support.v7.recyclerview.extensions;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import java.util.List;

/* loaded from: classes.dex */
public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    /* renamed from: c, reason: collision with root package name */
    private final AsyncListDiffer<T> f2284c;

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f2284c.getCurrentList().size();
    }

    public void submitList(List<T> list) {
        this.f2284c.submitList(list);
    }
}
