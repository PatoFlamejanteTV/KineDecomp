package com.squareup.wire;

import com.squareup.wire.ExtendableMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExtensionMap.java */
/* loaded from: classes.dex */
public final class f<T extends ExtendableMessage<?>> {

    /* renamed from: a, reason: collision with root package name */
    private Object[] f4858a;
    private int b;

    public <E> f(e<T, E> eVar, E e) {
        this.f4858a = new Object[2];
        this.f4858a[0] = eVar;
        this.f4858a[1] = e;
        this.b = 1;
    }

    public f(f<T> fVar) {
        this.f4858a = (Object[]) fVar.f4858a.clone();
        this.b = fVar.b;
    }

    public int a() {
        return this.b;
    }

    public e<T, ?> a(int i) {
        if (i < 0 || i >= this.b) {
            throw new IndexOutOfBoundsException("" + i);
        }
        return (e) this.f4858a[i];
    }

    public Object b(int i) {
        if (i < 0 || i >= this.b) {
            throw new IndexOutOfBoundsException("" + i);
        }
        return this.f4858a[this.b + i];
    }

    public List<e<T, ?>> b() {
        ArrayList arrayList = new ArrayList(this.b);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.b) {
                arrayList.add((e) this.f4858a[i2]);
                i = i2 + 1;
            } else {
                return Collections.unmodifiableList(arrayList);
            }
        }
    }

    public <E> E a(e<T, E> eVar) {
        int binarySearch = Arrays.binarySearch(this.f4858a, 0, this.b, eVar);
        if (binarySearch < 0) {
            return null;
        }
        return (E) this.f4858a[binarySearch + this.b];
    }

    public <E> void a(e<T, E> eVar, E e) {
        int binarySearch = Arrays.binarySearch(this.f4858a, 0, this.b, eVar);
        if (binarySearch >= 0) {
            this.f4858a[binarySearch + this.b] = e;
        } else {
            a(eVar, e, -(binarySearch + 1));
        }
    }

    private <E> void a(e<T, E> eVar, E e, int i) {
        Object[] objArr = this.f4858a;
        if (this.f4858a.length < (this.b + 1) * 2) {
            objArr = new Object[this.f4858a.length * 2];
            System.arraycopy(this.f4858a, 0, objArr, 0, i);
        }
        if (i < this.b) {
            System.arraycopy(this.f4858a, this.b + i, objArr, this.b + i + 2, this.b - i);
            System.arraycopy(this.f4858a, i, objArr, i + 1, this.b);
        } else {
            System.arraycopy(this.f4858a, this.b, objArr, this.b + 1, this.b);
        }
        this.b++;
        this.f4858a = objArr;
        this.f4858a[i] = eVar;
        this.f4858a[this.b + i] = e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.b != fVar.b) {
            return false;
        }
        for (int i = 0; i < this.b * 2; i++) {
            if (!this.f4858a[i].equals(fVar.f4858a[i])) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 < this.b * 2; i2++) {
            i = (i * 37) + this.f4858a[i2].hashCode();
        }
        return i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        String str = "";
        int i = 0;
        while (i < this.b) {
            sb.append(str);
            sb.append(((e) this.f4858a[i]).e());
            sb.append("=");
            sb.append(this.f4858a[this.b + i]);
            i++;
            str = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
