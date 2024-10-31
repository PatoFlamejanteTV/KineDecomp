package com.squareup.wire;

import com.squareup.wire.ExtendableMessage;
import com.squareup.wire.Message;

/* compiled from: Extension.java */
/* loaded from: classes.dex */
public final class e<T extends ExtendableMessage<?>, E> implements Comparable<e<?, ?>> {

    /* renamed from: a */
    private final Class<T> f25711a;

    /* renamed from: b */
    private final Class<? extends Message> f25712b;

    /* renamed from: c */
    private final Class<? extends m> f25713c;

    /* renamed from: d */
    private final String f25714d;

    /* renamed from: e */
    private final int f25715e;

    /* renamed from: f */
    private final Message.Datatype f25716f;

    /* renamed from: g */
    private final Message.Label f25717g;

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(e<?, ?> eVar) {
        int value;
        int value2;
        if (eVar == this) {
            return 0;
        }
        int i = this.f25715e;
        int i2 = eVar.f25715e;
        if (i != i2) {
            return i - i2;
        }
        Message.Datatype datatype = this.f25716f;
        if (datatype != eVar.f25716f) {
            value = datatype.value();
            value2 = eVar.f25716f.value();
        } else {
            Message.Label label = this.f25717g;
            if (label != eVar.f25717g) {
                value = label.value();
                value2 = eVar.f25717g.value();
            } else {
                Class<T> cls = this.f25711a;
                if (cls != null && !cls.equals(eVar.f25711a)) {
                    return this.f25711a.getName().compareTo(eVar.f25711a.getName());
                }
                Class<? extends Message> cls2 = this.f25712b;
                if (cls2 != null && !cls2.equals(eVar.f25712b)) {
                    return this.f25712b.getName().compareTo(eVar.f25712b.getName());
                }
                Class<? extends m> cls3 = this.f25713c;
                if (cls3 == null || cls3.equals(eVar.f25713c)) {
                    return 0;
                }
                return this.f25713c.getName().compareTo(eVar.f25713c.getName());
            }
        }
        return value - value2;
    }

    public Class<? extends m> d() {
        return this.f25713c;
    }

    public Class<T> e() {
        return this.f25711a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && compareTo((e) obj) == 0;
    }

    public Message.Label f() {
        return this.f25717g;
    }

    public Class<? extends Message> g() {
        return this.f25712b;
    }

    public String h() {
        return this.f25714d;
    }

    public int hashCode() {
        int value = ((((((this.f25715e * 37) + this.f25716f.value()) * 37) + this.f25717g.value()) * 37) + this.f25711a.hashCode()) * 37;
        Class<? extends Message> cls = this.f25712b;
        int hashCode = (value + (cls != null ? cls.hashCode() : 0)) * 37;
        Class<? extends m> cls2 = this.f25713c;
        return hashCode + (cls2 != null ? cls2.hashCode() : 0);
    }

    public int i() {
        return this.f25715e;
    }

    public String toString() {
        return String.format("[%s %s %s = %d]", this.f25717g, this.f25716f, this.f25714d, Integer.valueOf(this.f25715e));
    }

    public Message.Datatype a() {
        return this.f25716f;
    }
}
