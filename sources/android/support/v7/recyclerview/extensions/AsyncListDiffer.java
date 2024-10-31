package android.support.v7.recyclerview.extensions;

import android.support.v7.recyclerview.extensions.AsyncDifferConfig;
import android.support.v7.util.AdapterListUpdateCallback;
import android.support.v7.util.DiffUtil;
import android.support.v7.util.ListUpdateCallback;
import android.support.v7.widget.RecyclerView;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class AsyncListDiffer<T> {

    /* renamed from: a, reason: collision with root package name */
    private final ListUpdateCallback f2272a;

    /* renamed from: b, reason: collision with root package name */
    private final AsyncDifferConfig<T> f2273b;

    /* renamed from: c, reason: collision with root package name */
    private List<T> f2274c;

    /* renamed from: d, reason: collision with root package name */
    private List<T> f2275d = Collections.emptyList();

    /* renamed from: e, reason: collision with root package name */
    private int f2276e;

    public AsyncListDiffer(RecyclerView.Adapter adapter, DiffUtil.ItemCallback<T> itemCallback) {
        this.f2272a = new AdapterListUpdateCallback(adapter);
        this.f2273b = new AsyncDifferConfig.Builder(itemCallback).build();
    }

    public List<T> getCurrentList() {
        return this.f2275d;
    }

    public void submitList(final List<T> list) {
        final List<T> list2 = this.f2274c;
        if (list == list2) {
            return;
        }
        final int i = this.f2276e + 1;
        this.f2276e = i;
        if (list == null) {
            int size = list2.size();
            this.f2274c = null;
            this.f2275d = Collections.emptyList();
            this.f2272a.onRemoved(0, size);
            return;
        }
        if (list2 == null) {
            this.f2274c = list;
            this.f2275d = Collections.unmodifiableList(list);
            this.f2272a.onInserted(0, list.size());
            return;
        }
        this.f2273b.getBackgroundThreadExecutor().execute(new Runnable() { // from class: android.support.v7.recyclerview.extensions.AsyncListDiffer.1
            @Override // java.lang.Runnable
            public void run() {
                final DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback() { // from class: android.support.v7.recyclerview.extensions.AsyncListDiffer.1.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.support.v7.util.DiffUtil.Callback
                    public boolean areContentsTheSame(int i2, int i3) {
                        return AsyncListDiffer.this.f2273b.getDiffCallback().areContentsTheSame(list2.get(i2), list.get(i3));
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.support.v7.util.DiffUtil.Callback
                    public boolean areItemsTheSame(int i2, int i3) {
                        return AsyncListDiffer.this.f2273b.getDiffCallback().areItemsTheSame(list2.get(i2), list.get(i3));
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.support.v7.util.DiffUtil.Callback
                    public Object getChangePayload(int i2, int i3) {
                        return AsyncListDiffer.this.f2273b.getDiffCallback().getChangePayload(list2.get(i2), list.get(i3));
                    }

                    @Override // android.support.v7.util.DiffUtil.Callback
                    public int getNewListSize() {
                        return list.size();
                    }

                    @Override // android.support.v7.util.DiffUtil.Callback
                    public int getOldListSize() {
                        return list2.size();
                    }
                });
                AsyncListDiffer.this.f2273b.getMainThreadExecutor().execute(new Runnable() { // from class: android.support.v7.recyclerview.extensions.AsyncListDiffer.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int i2 = AsyncListDiffer.this.f2276e;
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        if (i2 == i) {
                            AsyncListDiffer.this.a(list, calculateDiff);
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<T> list, DiffUtil.DiffResult diffResult) {
        this.f2274c = list;
        this.f2275d = Collections.unmodifiableList(list);
        diffResult.dispatchUpdatesTo(this.f2272a);
    }

    public AsyncListDiffer(ListUpdateCallback listUpdateCallback, AsyncDifferConfig<T> asyncDifferConfig) {
        this.f2272a = listUpdateCallback;
        this.f2273b = asyncDifferConfig;
    }
}
