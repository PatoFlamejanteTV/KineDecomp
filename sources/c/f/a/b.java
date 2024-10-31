package c.f.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;

/* compiled from: StickyRecyclerHeadersAdapter.java */
/* loaded from: classes3.dex */
public interface b<VH extends RecyclerView.ViewHolder> {
    VH a(ViewGroup viewGroup);

    void a(VH vh, int i);

    long b(int i);

    int getItemCount();
}
