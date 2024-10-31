package com.fasterxml.jackson.core.c;

/* compiled from: Name.java */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    protected final String f431a;
    protected final int b;

    public abstract boolean a(int i);

    public abstract boolean a(int i, int i2);

    public abstract boolean a(int[] iArr, int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public c(String str, int i) {
        this.f431a = str;
        this.b = i;
    }

    public String a() {
        return this.f431a;
    }

    public String toString() {
        return this.f431a;
    }

    public final int hashCode() {
        return this.b;
    }

    public boolean equals(Object obj) {
        return obj == this;
    }
}
