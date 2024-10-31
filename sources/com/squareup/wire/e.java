package com.squareup.wire;

import com.squareup.wire.ExtendableMessage;
import com.squareup.wire.Message;

/* compiled from: Extension.java */
/* loaded from: classes.dex */
public final class e<T extends ExtendableMessage<?>, E> implements Comparable<e<?, ?>> {

    /* renamed from: a, reason: collision with root package name */
    private final Class<T> f4857a;
    private final Class<? extends Message> b;
    private final Class<? extends m> c;
    private final String d;
    private final int e;
    private final Message.Datatype f;
    private final Message.Label g;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(e<?, ?> eVar) {
        if (eVar == this) {
            return 0;
        }
        if (this.e != eVar.e) {
            return this.e - eVar.e;
        }
        if (this.f != eVar.f) {
            return this.f.value() - eVar.f.value();
        }
        if (this.g != eVar.g) {
            return this.g.value() - eVar.g.value();
        }
        if (this.f4857a != null && !this.f4857a.equals(eVar.f4857a)) {
            return this.f4857a.getName().compareTo(eVar.f4857a.getName());
        }
        if (this.b != null && !this.b.equals(eVar.b)) {
            return this.b.getName().compareTo(eVar.b.getName());
        }
        if (this.c == null || this.c.equals(eVar.c)) {
            return 0;
        }
        return this.c.getName().compareTo(eVar.c.getName());
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && compareTo((e) obj) == 0;
    }

    public int hashCode() {
        return (((this.b != null ? this.b.hashCode() : 0) + (((((((this.e * 37) + this.f.value()) * 37) + this.g.value()) * 37) + this.f4857a.hashCode()) * 37)) * 37) + (this.c != null ? this.c.hashCode() : 0);
    }

    public String toString() {
        return String.format("[%s %s %s = %d]", this.g, this.f, this.d, Integer.valueOf(this.e));
    }

    public Class<T> a() {
        return this.f4857a;
    }

    public Class<? extends Message> b() {
        return this.b;
    }

    public Class<? extends m> c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public Message.Datatype f() {
        return this.f;
    }

    public Message.Label g() {
        return this.g;
    }
}
