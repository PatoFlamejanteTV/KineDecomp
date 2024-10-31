package com.fasterxml.jackson.core.c;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;

/* compiled from: JsonWriteContext.java */
/* loaded from: classes.dex */
public class e extends com.fasterxml.jackson.core.b {

    /* renamed from: c */
    protected final e f9708c;

    /* renamed from: d */
    protected b f9709d;

    /* renamed from: e */
    protected e f9710e;

    /* renamed from: f */
    protected String f9711f;

    /* renamed from: g */
    protected Object f9712g;

    /* renamed from: h */
    protected boolean f9713h;

    protected e(int i, e eVar, b bVar) {
        this.f9675a = i;
        this.f9708c = eVar;
        this.f9709d = bVar;
        this.f9676b = -1;
    }

    protected e a(int i) {
        this.f9675a = i;
        this.f9676b = -1;
        this.f9711f = null;
        this.f9713h = false;
        this.f9712g = null;
        b bVar = this.f9709d;
        if (bVar != null) {
            bVar.c();
        }
        return this;
    }

    @Override // com.fasterxml.jackson.core.b
    public final String b() {
        return this.f9711f;
    }

    public e h() {
        this.f9712g = null;
        return this.f9708c;
    }

    public e i() {
        e eVar = this.f9710e;
        if (eVar == null) {
            b bVar = this.f9709d;
            e eVar2 = new e(1, this, bVar == null ? null : bVar.a());
            this.f9710e = eVar2;
            return eVar2;
        }
        eVar.a(1);
        return eVar;
    }

    public e j() {
        e eVar = this.f9710e;
        if (eVar == null) {
            b bVar = this.f9709d;
            e eVar2 = new e(2, this, bVar == null ? null : bVar.a());
            this.f9710e = eVar2;
            return eVar2;
        }
        eVar.a(2);
        return eVar;
    }

    public int k() {
        int i = this.f9675a;
        if (i == 2) {
            if (!this.f9713h) {
                return 5;
            }
            this.f9713h = false;
            this.f9676b++;
            return 2;
        }
        if (i == 1) {
            int i2 = this.f9676b;
            this.f9676b = i2 + 1;
            return i2 < 0 ? 0 : 1;
        }
        this.f9676b++;
        return this.f9676b == 0 ? 0 : 3;
    }

    public static e a(b bVar) {
        return new e(0, null, bVar);
    }

    public int a(String str) throws JsonProcessingException {
        if (this.f9675a != 2 || this.f9713h) {
            return 4;
        }
        this.f9713h = true;
        this.f9711f = str;
        b bVar = this.f9709d;
        if (bVar != null) {
            a(bVar, str);
        }
        return this.f9676b < 0 ? 0 : 1;
    }

    private final void a(b bVar, String str) throws JsonProcessingException {
        if (bVar.a(str)) {
            Object b2 = bVar.b();
            throw new JsonGenerationException("Duplicate field '" + str + "'", b2 instanceof JsonGenerator ? (JsonGenerator) b2 : null);
        }
    }
}
