package android.support.v7.util;

/* loaded from: classes.dex */
public class BatchingListUpdateCallback implements ListUpdateCallback {

    /* renamed from: a */
    final ListUpdateCallback f2303a;

    /* renamed from: b */
    int f2304b = 0;

    /* renamed from: c */
    int f2305c = -1;

    /* renamed from: d */
    int f2306d = -1;

    /* renamed from: e */
    Object f2307e = null;

    public BatchingListUpdateCallback(ListUpdateCallback listUpdateCallback) {
        this.f2303a = listUpdateCallback;
    }

    public void dispatchLastEvent() {
        int i = this.f2304b;
        if (i == 0) {
            return;
        }
        if (i == 1) {
            this.f2303a.onInserted(this.f2305c, this.f2306d);
        } else if (i == 2) {
            this.f2303a.onRemoved(this.f2305c, this.f2306d);
        } else if (i == 3) {
            this.f2303a.onChanged(this.f2305c, this.f2306d, this.f2307e);
        }
        this.f2307e = null;
        this.f2304b = 0;
    }

    @Override // android.support.v7.util.ListUpdateCallback
    public void onChanged(int i, int i2, Object obj) {
        int i3;
        if (this.f2304b == 3) {
            int i4 = this.f2305c;
            int i5 = this.f2306d;
            if (i <= i4 + i5 && (i3 = i + i2) >= i4 && this.f2307e == obj) {
                this.f2305c = Math.min(i, i4);
                this.f2306d = Math.max(i5 + i4, i3) - this.f2305c;
                return;
            }
        }
        dispatchLastEvent();
        this.f2305c = i;
        this.f2306d = i2;
        this.f2307e = obj;
        this.f2304b = 3;
    }

    @Override // android.support.v7.util.ListUpdateCallback
    public void onInserted(int i, int i2) {
        int i3;
        if (this.f2304b == 1 && i >= (i3 = this.f2305c)) {
            int i4 = this.f2306d;
            if (i <= i3 + i4) {
                this.f2306d = i4 + i2;
                this.f2305c = Math.min(i, i3);
                return;
            }
        }
        dispatchLastEvent();
        this.f2305c = i;
        this.f2306d = i2;
        this.f2304b = 1;
    }

    @Override // android.support.v7.util.ListUpdateCallback
    public void onMoved(int i, int i2) {
        dispatchLastEvent();
        this.f2303a.onMoved(i, i2);
    }

    @Override // android.support.v7.util.ListUpdateCallback
    public void onRemoved(int i, int i2) {
        int i3;
        if (this.f2304b == 2 && (i3 = this.f2305c) >= i && i3 <= i + i2) {
            this.f2306d += i2;
            this.f2305c = i;
        } else {
            dispatchLastEvent();
            this.f2305c = i;
            this.f2306d = i2;
            this.f2304b = 2;
        }
    }
}
