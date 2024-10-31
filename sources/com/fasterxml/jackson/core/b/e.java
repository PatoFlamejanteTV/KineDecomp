package com.fasterxml.jackson.core.b;

/* compiled from: JsonWriteContext.java */
/* loaded from: classes.dex */
public class e extends com.fasterxml.jackson.core.b {
    protected final e c;
    protected String d;
    protected e e = null;

    protected e(int i, e eVar) {
        this.f420a = i;
        this.c = eVar;
        this.b = -1;
    }

    public static e g() {
        return new e(0, null);
    }

    private e a(int i) {
        this.f420a = i;
        this.b = -1;
        this.d = null;
        return this;
    }

    public final e h() {
        e eVar = this.e;
        if (eVar != null) {
            return eVar.a(1);
        }
        e eVar2 = new e(1, this);
        this.e = eVar2;
        return eVar2;
    }

    public final e i() {
        e eVar = this.e;
        if (eVar != null) {
            return eVar.a(2);
        }
        e eVar2 = new e(2, this);
        this.e = eVar2;
        return eVar2;
    }

    public final e j() {
        return this.c;
    }

    public final int a(String str) {
        if (this.f420a != 2 || this.d != null) {
            return 4;
        }
        this.d = str;
        return this.b < 0 ? 0 : 1;
    }

    public final int k() {
        if (this.f420a == 2) {
            if (this.d == null) {
                return 5;
            }
            this.d = null;
            this.b++;
            return 2;
        }
        if (this.f420a == 1) {
            int i = this.b;
            this.b++;
            return i >= 0 ? 1 : 0;
        }
        this.b++;
        return this.b != 0 ? 3 : 0;
    }

    protected final void a(StringBuilder sb) {
        if (this.f420a == 2) {
            sb.append('{');
            if (this.d != null) {
                sb.append('\"');
                sb.append(this.d);
                sb.append('\"');
            } else {
                sb.append('?');
            }
            sb.append('}');
            return;
        }
        if (this.f420a == 1) {
            sb.append('[');
            sb.append(f());
            sb.append(']');
            return;
        }
        sb.append("/");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(64);
        a(sb);
        return sb.toString();
    }
}
