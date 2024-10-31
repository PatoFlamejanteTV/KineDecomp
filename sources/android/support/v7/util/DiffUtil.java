package android.support.v7.util;

import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class DiffUtil {

    /* renamed from: a */
    private static final Comparator<Snake> f2308a = new Comparator<Snake>() { // from class: android.support.v7.util.DiffUtil.1
        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        public int compare(Snake snake, Snake snake2) {
            int i = snake.f2323a - snake2.f2323a;
            return i == 0 ? snake.f2324b - snake2.f2324b : i;
        }
    };

    /* renamed from: android.support.v7.util.DiffUtil$1 */
    /* loaded from: classes.dex */
    static class AnonymousClass1 implements Comparator<Snake> {
        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        public int compare(Snake snake, Snake snake2) {
            int i = snake.f2323a - snake2.f2323a;
            return i == 0 ? snake.f2324b - snake2.f2324b : i;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i, int i2);

        public abstract boolean areItemsTheSame(int i, int i2);

        public Object getChangePayload(int i, int i2) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    /* loaded from: classes.dex */
    public static class DiffResult {

        /* renamed from: a */
        private final List<Snake> f2309a;

        /* renamed from: b */
        private final int[] f2310b;

        /* renamed from: c */
        private final int[] f2311c;

        /* renamed from: d */
        private final Callback f2312d;

        /* renamed from: e */
        private final int f2313e;

        /* renamed from: f */
        private final int f2314f;

        /* renamed from: g */
        private final boolean f2315g;

        DiffResult(Callback callback, List<Snake> list, int[] iArr, int[] iArr2, boolean z) {
            this.f2309a = list;
            this.f2310b = iArr;
            this.f2311c = iArr2;
            Arrays.fill(this.f2310b, 0);
            Arrays.fill(this.f2311c, 0);
            this.f2312d = callback;
            this.f2313e = callback.getOldListSize();
            this.f2314f = callback.getNewListSize();
            this.f2315g = z;
            a();
            b();
        }

        private void a() {
            Snake snake = this.f2309a.isEmpty() ? null : this.f2309a.get(0);
            if (snake != null && snake.f2323a == 0 && snake.f2324b == 0) {
                return;
            }
            Snake snake2 = new Snake();
            snake2.f2323a = 0;
            snake2.f2324b = 0;
            snake2.f2326d = false;
            snake2.f2325c = 0;
            snake2.f2327e = false;
            this.f2309a.add(0, snake2);
        }

        private void b() {
            int i = this.f2313e;
            int i2 = this.f2314f;
            for (int size = this.f2309a.size() - 1; size >= 0; size--) {
                Snake snake = this.f2309a.get(size);
                int i3 = snake.f2323a;
                int i4 = snake.f2325c;
                int i5 = i3 + i4;
                int i6 = snake.f2324b + i4;
                if (this.f2315g) {
                    while (i > i5) {
                        a(i, i2, size);
                        i--;
                    }
                    while (i2 > i6) {
                        b(i, i2, size);
                        i2--;
                    }
                }
                for (int i7 = 0; i7 < snake.f2325c; i7++) {
                    int i8 = snake.f2323a + i7;
                    int i9 = snake.f2324b + i7;
                    int i10 = this.f2312d.areContentsTheSame(i8, i9) ? 1 : 2;
                    this.f2310b[i8] = (i9 << 5) | i10;
                    this.f2311c[i9] = (i8 << 5) | i10;
                }
                i = snake.f2323a;
                i2 = snake.f2324b;
            }
        }

        public void dispatchUpdatesTo(RecyclerView.Adapter adapter) {
            dispatchUpdatesTo(new AdapterListUpdateCallback(adapter));
        }

        public void dispatchUpdatesTo(ListUpdateCallback listUpdateCallback) {
            BatchingListUpdateCallback batchingListUpdateCallback;
            if (listUpdateCallback instanceof BatchingListUpdateCallback) {
                batchingListUpdateCallback = (BatchingListUpdateCallback) listUpdateCallback;
            } else {
                batchingListUpdateCallback = new BatchingListUpdateCallback(listUpdateCallback);
            }
            ArrayList arrayList = new ArrayList();
            int i = this.f2313e;
            int i2 = this.f2314f;
            for (int size = this.f2309a.size() - 1; size >= 0; size--) {
                Snake snake = this.f2309a.get(size);
                int i3 = snake.f2325c;
                int i4 = snake.f2323a + i3;
                int i5 = snake.f2324b + i3;
                if (i4 < i) {
                    b(arrayList, batchingListUpdateCallback, i4, i - i4, i4);
                }
                if (i5 < i2) {
                    a(arrayList, batchingListUpdateCallback, i4, i2 - i5, i5);
                }
                for (int i6 = i3 - 1; i6 >= 0; i6--) {
                    int[] iArr = this.f2310b;
                    int i7 = snake.f2323a;
                    if ((iArr[i7 + i6] & 31) == 2) {
                        batchingListUpdateCallback.onChanged(i7 + i6, 1, this.f2312d.getChangePayload(i7 + i6, snake.f2324b + i6));
                    }
                }
                i = snake.f2323a;
                i2 = snake.f2324b;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }

        private void a(int i, int i2, int i3) {
            if (this.f2310b[i - 1] != 0) {
                return;
            }
            a(i, i2, i3, false);
        }

        private boolean a(int i, int i2, int i3, boolean z) {
            int i4;
            int i5;
            int i6;
            if (z) {
                i2--;
                i4 = i;
                i5 = i2;
            } else {
                i4 = i - 1;
                i5 = i4;
            }
            while (i3 >= 0) {
                Snake snake = this.f2309a.get(i3);
                int i7 = snake.f2323a;
                int i8 = snake.f2325c;
                int i9 = i7 + i8;
                int i10 = snake.f2324b + i8;
                if (z) {
                    for (int i11 = i4 - 1; i11 >= i9; i11--) {
                        if (this.f2312d.areItemsTheSame(i11, i5)) {
                            i6 = this.f2312d.areContentsTheSame(i11, i5) ? 8 : 4;
                            this.f2311c[i5] = (i11 << 5) | 16;
                            this.f2310b[i11] = (i5 << 5) | i6;
                            return true;
                        }
                    }
                } else {
                    for (int i12 = i2 - 1; i12 >= i10; i12--) {
                        if (this.f2312d.areItemsTheSame(i5, i12)) {
                            i6 = this.f2312d.areContentsTheSame(i5, i12) ? 8 : 4;
                            int i13 = i - 1;
                            this.f2310b[i13] = (i12 << 5) | 16;
                            this.f2311c[i12] = (i13 << 5) | i6;
                            return true;
                        }
                    }
                }
                i4 = snake.f2323a;
                i2 = snake.f2324b;
                i3--;
            }
            return false;
        }

        private void b(int i, int i2, int i3) {
            if (this.f2311c[i2 - 1] != 0) {
                return;
            }
            a(i, i2, i3, true);
        }

        private void b(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i, int i2, int i3) {
            if (!this.f2315g) {
                listUpdateCallback.onRemoved(i, i2);
                return;
            }
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                int i5 = i3 + i4;
                int i6 = this.f2310b[i5] & 31;
                if (i6 == 0) {
                    listUpdateCallback.onRemoved(i + i4, 1);
                    Iterator<PostponedUpdate> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().f2317b--;
                    }
                } else if (i6 == 4 || i6 == 8) {
                    int i7 = this.f2310b[i5] >> 5;
                    PostponedUpdate a2 = a(list, i7, false);
                    listUpdateCallback.onMoved(i + i4, a2.f2317b - 1);
                    if (i6 == 4) {
                        listUpdateCallback.onChanged(a2.f2317b - 1, 1, this.f2312d.getChangePayload(i5, i7));
                    }
                } else if (i6 == 16) {
                    list.add(new PostponedUpdate(i5, i + i4, true));
                } else {
                    throw new IllegalStateException("unknown flag for pos " + i5 + " " + Long.toBinaryString(i6));
                }
            }
        }

        private static PostponedUpdate a(List<PostponedUpdate> list, int i, boolean z) {
            int size = list.size() - 1;
            while (size >= 0) {
                PostponedUpdate postponedUpdate = list.get(size);
                if (postponedUpdate.f2316a == i && postponedUpdate.f2318c == z) {
                    list.remove(size);
                    while (size < list.size()) {
                        list.get(size).f2317b += z ? 1 : -1;
                        size++;
                    }
                    return postponedUpdate;
                }
                size--;
            }
            return null;
        }

        private void a(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i, int i2, int i3) {
            if (!this.f2315g) {
                listUpdateCallback.onInserted(i, i2);
                return;
            }
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                int i5 = i3 + i4;
                int i6 = this.f2311c[i5] & 31;
                if (i6 == 0) {
                    listUpdateCallback.onInserted(i, 1);
                    Iterator<PostponedUpdate> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().f2317b++;
                    }
                } else if (i6 == 4 || i6 == 8) {
                    int i7 = this.f2311c[i5] >> 5;
                    listUpdateCallback.onMoved(a(list, i7, true).f2317b, i);
                    if (i6 == 4) {
                        listUpdateCallback.onChanged(i, 1, this.f2312d.getChangePayload(i7, i5));
                    }
                } else if (i6 == 16) {
                    list.add(new PostponedUpdate(i5, i, false));
                } else {
                    throw new IllegalStateException("unknown flag for pos " + i5 + " " + Long.toBinaryString(i6));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ItemCallback<T> {
        public abstract boolean areContentsTheSame(T t, T t2);

        public abstract boolean areItemsTheSame(T t, T t2);

        public Object getChangePayload(T t, T t2) {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class PostponedUpdate {

        /* renamed from: a */
        int f2316a;

        /* renamed from: b */
        int f2317b;

        /* renamed from: c */
        boolean f2318c;

        public PostponedUpdate(int i, int i2, boolean z) {
            this.f2316a = i;
            this.f2317b = i2;
            this.f2318c = z;
        }
    }

    /* loaded from: classes.dex */
    public static class Range {

        /* renamed from: a */
        int f2319a;

        /* renamed from: b */
        int f2320b;

        /* renamed from: c */
        int f2321c;

        /* renamed from: d */
        int f2322d;

        public Range() {
        }

        public Range(int i, int i2, int i3, int i4) {
            this.f2319a = i;
            this.f2320b = i2;
            this.f2321c = i3;
            this.f2322d = i4;
        }
    }

    /* loaded from: classes.dex */
    public static class Snake {

        /* renamed from: a */
        int f2323a;

        /* renamed from: b */
        int f2324b;

        /* renamed from: c */
        int f2325c;

        /* renamed from: d */
        boolean f2326d;

        /* renamed from: e */
        boolean f2327e;

        Snake() {
        }
    }

    private DiffUtil() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:            if (r24[r13 - 1] < r24[r13 + r5]) goto L112;     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ba, code lost:            if (r25[r13 - 1] < r25[r13 + 1]) goto L142;     */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e3 A[LOOP:4: B:54:0x00cf->B:58:0x00e3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ee A[EDGE_INSN: B:59:0x00ee->B:60:0x00ee BREAK  A[LOOP:4: B:54:0x00cf->B:58:0x00e3], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.support.v7.util.DiffUtil.Snake a(android.support.v7.util.DiffUtil.Callback r19, int r20, int r21, int r22, int r23, int[] r24, int[] r25, int r26) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.util.DiffUtil.a(android.support.v7.util.DiffUtil$Callback, int, int, int, int, int[], int[], int):android.support.v7.util.DiffUtil$Snake");
    }

    public static DiffResult calculateDiff(Callback callback) {
        return calculateDiff(callback, true);
    }

    public static DiffResult calculateDiff(Callback callback, boolean z) {
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, oldListSize, 0, newListSize));
        int abs = Math.abs(oldListSize - newListSize) + oldListSize + newListSize;
        int i = abs * 2;
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake a2 = a(callback, range.f2319a, range.f2320b, range.f2321c, range.f2322d, iArr, iArr2, abs);
            if (a2 != null) {
                if (a2.f2325c > 0) {
                    arrayList.add(a2);
                }
                a2.f2323a += range.f2319a;
                a2.f2324b += range.f2321c;
                Range range2 = arrayList3.isEmpty() ? new Range() : (Range) arrayList3.remove(arrayList3.size() - 1);
                range2.f2319a = range.f2319a;
                range2.f2321c = range.f2321c;
                if (a2.f2327e) {
                    range2.f2320b = a2.f2323a;
                    range2.f2322d = a2.f2324b;
                } else if (a2.f2326d) {
                    range2.f2320b = a2.f2323a - 1;
                    range2.f2322d = a2.f2324b;
                } else {
                    range2.f2320b = a2.f2323a;
                    range2.f2322d = a2.f2324b - 1;
                }
                arrayList2.add(range2);
                if (a2.f2327e) {
                    if (a2.f2326d) {
                        int i2 = a2.f2323a;
                        int i3 = a2.f2325c;
                        range.f2319a = i2 + i3 + 1;
                        range.f2321c = a2.f2324b + i3;
                    } else {
                        int i4 = a2.f2323a;
                        int i5 = a2.f2325c;
                        range.f2319a = i4 + i5;
                        range.f2321c = a2.f2324b + i5 + 1;
                    }
                } else {
                    int i6 = a2.f2323a;
                    int i7 = a2.f2325c;
                    range.f2319a = i6 + i7;
                    range.f2321c = a2.f2324b + i7;
                }
                arrayList2.add(range);
            } else {
                arrayList3.add(range);
            }
        }
        Collections.sort(arrayList, f2308a);
        return new DiffResult(callback, arrayList, iArr, iArr2, z);
    }
}
