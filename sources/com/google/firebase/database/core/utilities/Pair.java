package com.google.firebase.database.core.utilities;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class Pair<T, U> {

    /* renamed from: a */
    private final T f17059a;

    /* renamed from: b */
    private final U f17060b;

    public Pair(T t, U u) {
        this.f17059a = t;
        this.f17060b = u;
    }

    public T a() {
        return this.f17059a;
    }

    public U b() {
        return this.f17060b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Pair.class != obj.getClass()) {
            return false;
        }
        Pair pair = (Pair) obj;
        T t = this.f17059a;
        if (t == null ? pair.f17059a != null : !t.equals(pair.f17059a)) {
            return false;
        }
        U u = this.f17060b;
        return u == null ? pair.f17060b == null : u.equals(pair.f17060b);
    }

    public int hashCode() {
        T t = this.f17059a;
        int hashCode = (t != null ? t.hashCode() : 0) * 31;
        U u = this.f17060b;
        return hashCode + (u != null ? u.hashCode() : 0);
    }

    public String toString() {
        return "Pair(" + this.f17059a + "," + this.f17060b + ")";
    }
}
