package android.support.v7.widget;

import android.support.v7.widget.AdapterHelper;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class OpReorderer {

    /* renamed from: a */
    final Callback f2857a;

    /* loaded from: classes.dex */
    public interface Callback {
        AdapterHelper.UpdateOp obtainUpdateOp(int i, int i2, int i3, Object obj);

        void recycleUpdateOp(AdapterHelper.UpdateOp updateOp);
    }

    public OpReorderer(Callback callback) {
        this.f2857a = callback;
    }

    private void c(List<AdapterHelper.UpdateOp> list, int i, AdapterHelper.UpdateOp updateOp, int i2, AdapterHelper.UpdateOp updateOp2) {
        int i3 = updateOp.f2604d < updateOp2.f2602b ? -1 : 0;
        if (updateOp.f2602b < updateOp2.f2602b) {
            i3++;
        }
        int i4 = updateOp2.f2602b;
        int i5 = updateOp.f2602b;
        if (i4 <= i5) {
            updateOp.f2602b = i5 + updateOp2.f2604d;
        }
        int i6 = updateOp2.f2602b;
        int i7 = updateOp.f2604d;
        if (i6 <= i7) {
            updateOp.f2604d = i7 + updateOp2.f2604d;
        }
        updateOp2.f2602b += i3;
        list.set(i, updateOp2);
        list.set(i2, updateOp);
    }

    public void a(List<AdapterHelper.UpdateOp> list) {
        while (true) {
            int b2 = b(list);
            if (b2 == -1) {
                return;
            } else {
                a(list, b2, b2 + 1);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void b(java.util.List<android.support.v7.widget.AdapterHelper.UpdateOp> r9, int r10, android.support.v7.widget.AdapterHelper.UpdateOp r11, int r12, android.support.v7.widget.AdapterHelper.UpdateOp r13) {
        /*
            r8 = this;
            int r0 = r11.f2604d
            int r1 = r13.f2602b
            r2 = 4
            r3 = 0
            r4 = 1
            if (r0 >= r1) goto Ld
            int r1 = r1 - r4
            r13.f2602b = r1
            goto L20
        Ld:
            int r5 = r13.f2604d
            int r1 = r1 + r5
            if (r0 >= r1) goto L20
            int r5 = r5 - r4
            r13.f2604d = r5
            android.support.v7.widget.OpReorderer$Callback r0 = r8.f2857a
            int r1 = r11.f2602b
            java.lang.Object r5 = r13.f2603c
            android.support.v7.widget.AdapterHelper$UpdateOp r0 = r0.obtainUpdateOp(r2, r1, r4, r5)
            goto L21
        L20:
            r0 = r3
        L21:
            int r1 = r11.f2602b
            int r5 = r13.f2602b
            if (r1 > r5) goto L2b
            int r5 = r5 + r4
            r13.f2602b = r5
            goto L41
        L2b:
            int r6 = r13.f2604d
            int r7 = r5 + r6
            if (r1 >= r7) goto L41
            int r5 = r5 + r6
            int r5 = r5 - r1
            android.support.v7.widget.OpReorderer$Callback r3 = r8.f2857a
            int r1 = r1 + r4
            java.lang.Object r4 = r13.f2603c
            android.support.v7.widget.AdapterHelper$UpdateOp r3 = r3.obtainUpdateOp(r2, r1, r5, r4)
            int r1 = r13.f2604d
            int r1 = r1 - r5
            r13.f2604d = r1
        L41:
            r9.set(r12, r11)
            int r11 = r13.f2604d
            if (r11 <= 0) goto L4c
            r9.set(r10, r13)
            goto L54
        L4c:
            r9.remove(r10)
            android.support.v7.widget.OpReorderer$Callback r11 = r8.f2857a
            r11.recycleUpdateOp(r13)
        L54:
            if (r0 == 0) goto L59
            r9.add(r10, r0)
        L59:
            if (r3 == 0) goto L5e
            r9.add(r10, r3)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.OpReorderer.b(java.util.List, int, android.support.v7.widget.AdapterHelper$UpdateOp, int, android.support.v7.widget.AdapterHelper$UpdateOp):void");
    }

    private void a(List<AdapterHelper.UpdateOp> list, int i, int i2) {
        AdapterHelper.UpdateOp updateOp = list.get(i);
        AdapterHelper.UpdateOp updateOp2 = list.get(i2);
        int i3 = updateOp2.f2601a;
        if (i3 == 1) {
            c(list, i, updateOp, i2, updateOp2);
        } else if (i3 == 2) {
            a(list, i, updateOp, i2, updateOp2);
        } else {
            if (i3 != 4) {
                return;
            }
            b(list, i, updateOp, i2, updateOp2);
        }
    }

    void a(List<AdapterHelper.UpdateOp> list, int i, AdapterHelper.UpdateOp updateOp, int i2, AdapterHelper.UpdateOp updateOp2) {
        boolean z;
        int i3 = updateOp.f2602b;
        int i4 = updateOp.f2604d;
        boolean z2 = false;
        if (i3 < i4) {
            if (updateOp2.f2602b == i3 && updateOp2.f2604d == i4 - i3) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (updateOp2.f2602b == i4 + 1 && updateOp2.f2604d == i3 - i4) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        int i5 = updateOp.f2604d;
        int i6 = updateOp2.f2602b;
        if (i5 < i6) {
            updateOp2.f2602b = i6 - 1;
        } else {
            int i7 = updateOp2.f2604d;
            if (i5 < i6 + i7) {
                updateOp2.f2604d = i7 - 1;
                updateOp.f2601a = 2;
                updateOp.f2604d = 1;
                if (updateOp2.f2604d == 0) {
                    list.remove(i2);
                    this.f2857a.recycleUpdateOp(updateOp2);
                    return;
                }
                return;
            }
        }
        int i8 = updateOp.f2602b;
        int i9 = updateOp2.f2602b;
        AdapterHelper.UpdateOp updateOp3 = null;
        if (i8 <= i9) {
            updateOp2.f2602b = i9 + 1;
        } else {
            int i10 = updateOp2.f2604d;
            if (i8 < i9 + i10) {
                updateOp3 = this.f2857a.obtainUpdateOp(2, i8 + 1, (i9 + i10) - i8, null);
                updateOp2.f2604d = updateOp.f2602b - updateOp2.f2602b;
            }
        }
        if (z2) {
            list.set(i, updateOp2);
            list.remove(i2);
            this.f2857a.recycleUpdateOp(updateOp);
            return;
        }
        if (z) {
            if (updateOp3 != null) {
                int i11 = updateOp.f2602b;
                if (i11 > updateOp3.f2602b) {
                    updateOp.f2602b = i11 - updateOp3.f2604d;
                }
                int i12 = updateOp.f2604d;
                if (i12 > updateOp3.f2602b) {
                    updateOp.f2604d = i12 - updateOp3.f2604d;
                }
            }
            int i13 = updateOp.f2602b;
            if (i13 > updateOp2.f2602b) {
                updateOp.f2602b = i13 - updateOp2.f2604d;
            }
            int i14 = updateOp.f2604d;
            if (i14 > updateOp2.f2602b) {
                updateOp.f2604d = i14 - updateOp2.f2604d;
            }
        } else {
            if (updateOp3 != null) {
                int i15 = updateOp.f2602b;
                if (i15 >= updateOp3.f2602b) {
                    updateOp.f2602b = i15 - updateOp3.f2604d;
                }
                int i16 = updateOp.f2604d;
                if (i16 >= updateOp3.f2602b) {
                    updateOp.f2604d = i16 - updateOp3.f2604d;
                }
            }
            int i17 = updateOp.f2602b;
            if (i17 >= updateOp2.f2602b) {
                updateOp.f2602b = i17 - updateOp2.f2604d;
            }
            int i18 = updateOp.f2604d;
            if (i18 >= updateOp2.f2602b) {
                updateOp.f2604d = i18 - updateOp2.f2604d;
            }
        }
        list.set(i, updateOp2);
        if (updateOp.f2602b != updateOp.f2604d) {
            list.set(i2, updateOp);
        } else {
            list.remove(i2);
        }
        if (updateOp3 != null) {
            list.add(i, updateOp3);
        }
    }

    private int b(List<AdapterHelper.UpdateOp> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f2601a != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }
}
