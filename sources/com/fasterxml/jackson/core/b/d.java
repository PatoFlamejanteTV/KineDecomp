package com.fasterxml.jackson.core.b;

import com.fasterxml.jackson.core.JsonLocation;

/* compiled from: JsonReadContext.java */
/* loaded from: classes.dex */
public final class d extends com.fasterxml.jackson.core.b {
    protected final d c;
    protected int d;
    protected int e;
    protected String f;
    protected d g = null;

    public d(d dVar, int i, int i2, int i3) {
        this.f420a = i;
        this.c = dVar;
        this.d = i2;
        this.e = i3;
        this.b = -1;
    }

    protected void a(int i, int i2, int i3) {
        this.f420a = i;
        this.b = -1;
        this.d = i2;
        this.e = i3;
        this.f = null;
    }

    public static d g() {
        return new d(null, 0, 1, 0);
    }

    public d a(int i, int i2) {
        d dVar = this.g;
        if (dVar == null) {
            d dVar2 = new d(this, 1, i, i2);
            this.g = dVar2;
            return dVar2;
        }
        dVar.a(1, i, i2);
        return dVar;
    }

    public d b(int i, int i2) {
        d dVar = this.g;
        if (dVar == null) {
            d dVar2 = new d(this, 2, i, i2);
            this.g = dVar2;
            return dVar2;
        }
        dVar.a(2, i, i2);
        return dVar;
    }

    public String h() {
        return this.f;
    }

    public d i() {
        return this.c;
    }

    public JsonLocation a(Object obj) {
        return new JsonLocation(obj, -1L, this.d, this.e);
    }

    public boolean j() {
        int i = this.b + 1;
        this.b = i;
        return this.f420a != 0 && i > 0;
    }

    public void a(String str) {
        this.f = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        switch (this.f420a) {
            case 0:
                sb.append("/");
                break;
            case 1:
                sb.append('[');
                sb.append(f());
                sb.append(']');
                break;
            case 2:
                sb.append('{');
                if (this.f != null) {
                    sb.append('\"');
                    com.fasterxml.jackson.core.io.b.a(sb, this.f);
                    sb.append('\"');
                } else {
                    sb.append('?');
                }
                sb.append('}');
                break;
        }
        return sb.toString();
    }
}
