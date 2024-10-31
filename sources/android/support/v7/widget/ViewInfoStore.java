package android.support.v7.widget;

import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.Pools;
import android.support.v7.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ViewInfoStore {

    /* renamed from: a, reason: collision with root package name */
    final ArrayMap<RecyclerView.ViewHolder, InfoRecord> f3169a = new ArrayMap<>();

    /* renamed from: b, reason: collision with root package name */
    final LongSparseArray<RecyclerView.ViewHolder> f3170b = new LongSparseArray<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface ProcessCallback {
        void processAppeared(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void processDisappeared(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void processPersistent(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void unused(RecyclerView.ViewHolder viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f3169a.clear();
        this.f3170b.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.f3169a.get(viewHolder);
        return (infoRecord == null || (infoRecord.f3172b & 1) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecord = this.f3169a.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.b();
            this.f3169a.put(viewHolder, infoRecord);
        }
        infoRecord.f3173c = itemHolderInfo;
        infoRecord.f3172b |= 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.ItemAnimator.ItemHolderInfo d(RecyclerView.ViewHolder viewHolder) {
        return a(viewHolder, 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.ItemAnimator.ItemHolderInfo e(RecyclerView.ViewHolder viewHolder) {
        return a(viewHolder, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.f3169a.get(viewHolder);
        if (infoRecord == null) {
            return;
        }
        infoRecord.f3172b &= -2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(RecyclerView.ViewHolder viewHolder) {
        int size = this.f3170b.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            if (viewHolder == this.f3170b.valueAt(size)) {
                this.f3170b.removeAt(size);
                break;
            }
            size--;
        }
        InfoRecord remove = this.f3169a.remove(viewHolder);
        if (remove != null) {
            InfoRecord.a(remove);
        }
    }

    public void onViewDetached(RecyclerView.ViewHolder viewHolder) {
        f(viewHolder);
    }

    private RecyclerView.ItemAnimator.ItemHolderInfo a(RecyclerView.ViewHolder viewHolder, int i) {
        InfoRecord valueAt;
        RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo;
        int indexOfKey = this.f3169a.indexOfKey(viewHolder);
        if (indexOfKey >= 0 && (valueAt = this.f3169a.valueAt(indexOfKey)) != null) {
            int i2 = valueAt.f3172b;
            if ((i2 & i) != 0) {
                valueAt.f3172b = (i ^ (-1)) & i2;
                if (i == 4) {
                    itemHolderInfo = valueAt.f3173c;
                } else if (i == 8) {
                    itemHolderInfo = valueAt.f3174d;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((valueAt.f3172b & 12) == 0) {
                    this.f3169a.removeAt(indexOfKey);
                    InfoRecord.a(valueAt);
                }
                return itemHolderInfo;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecord = this.f3169a.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.b();
            this.f3169a.put(viewHolder, infoRecord);
        }
        infoRecord.f3174d = itemHolderInfo;
        infoRecord.f3172b |= 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class InfoRecord {

        /* renamed from: a, reason: collision with root package name */
        static Pools.Pool<InfoRecord> f3171a = new Pools.SimplePool(20);

        /* renamed from: b, reason: collision with root package name */
        int f3172b;

        /* renamed from: c, reason: collision with root package name */
        RecyclerView.ItemAnimator.ItemHolderInfo f3173c;

        /* renamed from: d, reason: collision with root package name */
        RecyclerView.ItemAnimator.ItemHolderInfo f3174d;

        private InfoRecord() {
        }

        static void a(InfoRecord infoRecord) {
            infoRecord.f3172b = 0;
            infoRecord.f3173c = null;
            infoRecord.f3174d = null;
            f3171a.release(infoRecord);
        }

        static InfoRecord b() {
            InfoRecord acquire = f3171a.acquire();
            return acquire == null ? new InfoRecord() : acquire;
        }

        static void a() {
            do {
            } while (f3171a.acquire() != null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.f3169a.get(viewHolder);
        return (infoRecord == null || (infoRecord.f3172b & 4) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        InfoRecord.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j, RecyclerView.ViewHolder viewHolder) {
        this.f3170b.put(j, viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecord = this.f3169a.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.b();
            this.f3169a.put(viewHolder, infoRecord);
        }
        infoRecord.f3172b |= 2;
        infoRecord.f3173c = itemHolderInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.ViewHolder a(long j) {
        return this.f3170b.get(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.f3169a.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.b();
            this.f3169a.put(viewHolder, infoRecord);
        }
        infoRecord.f3172b |= 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ProcessCallback processCallback) {
        for (int size = this.f3169a.size() - 1; size >= 0; size--) {
            RecyclerView.ViewHolder keyAt = this.f3169a.keyAt(size);
            InfoRecord removeAt = this.f3169a.removeAt(size);
            int i = removeAt.f3172b;
            if ((i & 3) == 3) {
                processCallback.unused(keyAt);
            } else if ((i & 1) != 0) {
                RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo = removeAt.f3173c;
                if (itemHolderInfo == null) {
                    processCallback.unused(keyAt);
                } else {
                    processCallback.processDisappeared(keyAt, itemHolderInfo, removeAt.f3174d);
                }
            } else if ((i & 14) == 14) {
                processCallback.processAppeared(keyAt, removeAt.f3173c, removeAt.f3174d);
            } else if ((i & 12) == 12) {
                processCallback.processPersistent(keyAt, removeAt.f3173c, removeAt.f3174d);
            } else if ((i & 4) != 0) {
                processCallback.processDisappeared(keyAt, removeAt.f3173c, null);
            } else if ((i & 8) != 0) {
                processCallback.processAppeared(keyAt, removeAt.f3173c, removeAt.f3174d);
            }
            InfoRecord.a(removeAt);
        }
    }
}
