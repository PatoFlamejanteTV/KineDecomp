package com.adobe.creativesdk.foundation.internal.twowayview.widget;

import com.adobe.creativesdk.foundation.internal.twowayview.widget.BaseLayoutManager;
import java.util.Arrays;

/* compiled from: ItemEntries.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a */
    private BaseLayoutManager.a[] f6830a;

    /* renamed from: b */
    private int f6831b;

    /* renamed from: c */
    private boolean f6832c;

    private void d(int i) {
        BaseLayoutManager.a[] aVarArr = this.f6830a;
        if (aVarArr == null) {
            this.f6830a = new BaseLayoutManager.a[Math.max(i, 10) + 1];
            Arrays.fill(this.f6830a, (Object) null);
        } else if (i >= aVarArr.length) {
            this.f6830a = new BaseLayoutManager.a[e(i)];
            System.arraycopy(aVarArr, 0, this.f6830a, 0, aVarArr.length);
            BaseLayoutManager.a[] aVarArr2 = this.f6830a;
            Arrays.fill(aVarArr2, aVarArr.length, aVarArr2.length, (Object) null);
        }
    }

    private int e(int i) {
        int i2;
        int length = this.f6830a.length;
        while (length <= i) {
            length *= 2;
        }
        return (this.f6832c || length <= (i2 = this.f6831b)) ? length : i2;
    }

    public BaseLayoutManager.a a(int i) {
        BaseLayoutManager.a[] aVarArr = this.f6830a;
        if (aVarArr == null || i >= aVarArr.length) {
            return null;
        }
        return aVarArr[i];
    }

    public void b(int i, BaseLayoutManager.a aVar) {
        this.f6832c = true;
        a(i, aVar);
        this.f6832c = false;
    }

    public void c(int i) {
        this.f6831b = i;
    }

    public void a(int i, BaseLayoutManager.a aVar) {
        d(i);
        this.f6830a[i] = aVar;
    }

    public int b() {
        BaseLayoutManager.a[] aVarArr = this.f6830a;
        if (aVarArr != null) {
            return aVarArr.length;
        }
        return 0;
    }

    public void a() {
        BaseLayoutManager.a[] aVarArr = this.f6830a;
        if (aVarArr != null) {
            Arrays.fill(aVarArr, (Object) null);
        }
    }

    public void b(int i) {
        BaseLayoutManager.a[] aVarArr = this.f6830a;
        if (aVarArr == null || i >= aVarArr.length) {
            return;
        }
        while (true) {
            BaseLayoutManager.a[] aVarArr2 = this.f6830a;
            if (i >= aVarArr2.length) {
                return;
            }
            BaseLayoutManager.a aVar = aVarArr2[i];
            if (aVar != null) {
                aVar.a();
            }
            i++;
        }
    }

    public void a(int i, int i2) {
        BaseLayoutManager.a[] aVarArr = this.f6830a;
        if (aVarArr == null || i >= aVarArr.length) {
            return;
        }
        int i3 = i + i2;
        d(i3);
        BaseLayoutManager.a[] aVarArr2 = this.f6830a;
        System.arraycopy(aVarArr2, i, aVarArr2, i3, (aVarArr2.length - i) - i2);
        Arrays.fill(this.f6830a, i, i3, (Object) null);
    }

    public void b(int i, int i2) {
        BaseLayoutManager.a[] aVarArr = this.f6830a;
        if (aVarArr == null || i >= aVarArr.length) {
            return;
        }
        int i3 = i + i2;
        d(i3);
        BaseLayoutManager.a[] aVarArr2 = this.f6830a;
        System.arraycopy(aVarArr2, i3, aVarArr2, i, (aVarArr2.length - i) - i2);
        BaseLayoutManager.a[] aVarArr3 = this.f6830a;
        Arrays.fill(aVarArr3, aVarArr3.length - i2, aVarArr3.length, (Object) null);
    }
}
