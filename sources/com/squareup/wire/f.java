package com.squareup.wire;

import com.squareup.wire.ExtendableMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: ExtensionMap.java */
/* loaded from: classes3.dex */
public final class f<T extends ExtendableMessage<?>> {

    /* renamed from: a */
    private Object[] f25718a;

    /* renamed from: b */
    private int f25719b;

    public <E> f(e<T, E> eVar, E e2) {
        this.f25718a = new Object[2];
        Object[] objArr = this.f25718a;
        objArr[0] = eVar;
        objArr[1] = e2;
        this.f25719b = 1;
    }

    public e<T, ?> a(int i) {
        if (i >= 0 && i < this.f25719b) {
            return (e) this.f25718a[i];
        }
        throw new IndexOutOfBoundsException("" + i);
    }

    public int b() {
        return this.f25719b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f25719b != fVar.f25719b) {
            return false;
        }
        for (int i = 0; i < this.f25719b * 2; i++) {
            if (!this.f25718a[i].equals(fVar.f25718a[i])) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 < this.f25719b * 2; i2++) {
            i = (i * 37) + this.f25718a[i2].hashCode();
        }
        return i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        String str = "";
        int i = 0;
        while (i < this.f25719b) {
            sb.append(str);
            sb.append(((e) this.f25718a[i]).i());
            sb.append("=");
            sb.append(this.f25718a[this.f25719b + i]);
            i++;
            str = ", ";
        }
        sb.append("}");
        return sb.toString();
    }

    public Object b(int i) {
        int i2;
        if (i >= 0 && i < (i2 = this.f25719b)) {
            return this.f25718a[i2 + i];
        }
        throw new IndexOutOfBoundsException("" + i);
    }

    public List<e<T, ?>> a() {
        ArrayList arrayList = new ArrayList(this.f25719b);
        for (int i = 0; i < this.f25719b; i++) {
            arrayList.add((e) this.f25718a[i]);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public f(f<T> fVar) {
        this.f25718a = (Object[]) fVar.f25718a.clone();
        this.f25719b = fVar.f25719b;
    }

    public <E> E a(e<T, E> eVar) {
        int binarySearch = Arrays.binarySearch(this.f25718a, 0, this.f25719b, eVar);
        if (binarySearch < 0) {
            return null;
        }
        return (E) this.f25718a[this.f25719b + binarySearch];
    }

    public <E> void a(e<T, E> eVar, E e2) {
        int binarySearch = Arrays.binarySearch(this.f25718a, 0, this.f25719b, eVar);
        if (binarySearch >= 0) {
            this.f25718a[this.f25719b + binarySearch] = e2;
        } else {
            a(eVar, e2, -(binarySearch + 1));
        }
    }

    private <E> void a(e<T, E> eVar, E e2, int i) {
        Object[] objArr = this.f25718a;
        if (objArr.length < (this.f25719b + 1) * 2) {
            Object[] objArr2 = new Object[objArr.length * 2];
            System.arraycopy(objArr, 0, objArr2, 0, i);
            objArr = objArr2;
        }
        int i2 = this.f25719b;
        if (i < i2) {
            System.arraycopy(this.f25718a, i2 + i, objArr, i2 + i + 2, i2 - i);
            System.arraycopy(this.f25718a, i, objArr, i + 1, this.f25719b);
        } else {
            System.arraycopy(this.f25718a, i2, objArr, i2 + 1, i2);
        }
        this.f25719b++;
        this.f25718a = objArr;
        Object[] objArr3 = this.f25718a;
        objArr3[i] = eVar;
        objArr3[this.f25719b + i] = e2;
    }
}
