package com.fasterxml.jackson.core.c;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;

/* compiled from: JsonReadContext.java */
/* loaded from: classes.dex */
public final class d extends com.fasterxml.jackson.core.b {

    /* renamed from: c */
    protected final d f9702c;

    /* renamed from: d */
    protected b f9703d;

    /* renamed from: e */
    protected d f9704e;

    /* renamed from: f */
    protected String f9705f;

    /* renamed from: g */
    protected Object f9706g;

    /* renamed from: h */
    protected int f9707h;
    protected int i;

    public d(d dVar, b bVar, int i, int i2, int i3) {
        this.f9702c = dVar;
        this.f9703d = bVar;
        this.f9675a = i;
        this.f9707h = i2;
        this.i = i3;
        this.f9676b = -1;
    }

    protected void a(int i, int i2, int i3) {
        this.f9675a = i;
        this.f9676b = -1;
        this.f9707h = i2;
        this.i = i3;
        this.f9705f = null;
        this.f9706g = null;
        b bVar = this.f9703d;
        if (bVar != null) {
            bVar.c();
        }
    }

    public d b(int i, int i2) {
        d dVar = this.f9704e;
        if (dVar == null) {
            b bVar = this.f9703d;
            d dVar2 = new d(this, bVar == null ? null : bVar.a(), 2, i, i2);
            this.f9704e = dVar2;
            return dVar2;
        }
        dVar.a(2, i, i2);
        return dVar;
    }

    public d h() {
        this.f9706g = null;
        return this.f9702c;
    }

    public boolean i() {
        int i = this.f9676b + 1;
        this.f9676b = i;
        return this.f9675a != 0 && i > 0;
    }

    public d j() {
        return this.f9702c;
    }

    @Override // com.fasterxml.jackson.core.b
    public String b() {
        return this.f9705f;
    }

    public static d a(b bVar) {
        return new d(null, bVar, 0, 1, 0);
    }

    public d a(int i, int i2) {
        d dVar = this.f9704e;
        if (dVar == null) {
            b bVar = this.f9703d;
            dVar = new d(this, bVar == null ? null : bVar.a(), 1, i, i2);
            this.f9704e = dVar;
        } else {
            dVar.a(1, i, i2);
        }
        return dVar;
    }

    public JsonLocation a(Object obj) {
        return new JsonLocation(obj, -1L, this.f9707h, this.i);
    }

    public void a(String str) throws JsonProcessingException {
        this.f9705f = str;
        b bVar = this.f9703d;
        if (bVar != null) {
            a(bVar, str);
        }
    }

    private void a(b bVar, String str) throws JsonProcessingException {
        if (bVar.a(str)) {
            Object b2 = bVar.b();
            throw new JsonParseException(b2 instanceof JsonParser ? (JsonParser) b2 : null, "Duplicate field '" + str + "'");
        }
    }
}
