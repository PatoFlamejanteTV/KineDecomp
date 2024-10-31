package com.fasterxml.jackson.core.b;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;

/* compiled from: JsonGeneratorImpl.java */
/* loaded from: classes.dex */
public abstract class c extends com.fasterxml.jackson.core.a.a {
    protected static final int[] g = com.fasterxml.jackson.core.io.b.f();
    protected final com.fasterxml.jackson.core.io.c h;
    protected int[] i;
    protected int j;
    protected CharacterEscapes k;
    protected com.fasterxml.jackson.core.e l;

    public c(com.fasterxml.jackson.core.io.c cVar, int i, com.fasterxml.jackson.core.c cVar2) {
        super(i, cVar2);
        this.i = g;
        this.l = DefaultPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        this.h = cVar;
        if (a(JsonGenerator.Feature.ESCAPE_NON_ASCII)) {
            a(127);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator a(int i) {
        if (i < 0) {
            i = 0;
        }
        this.j = i;
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator a(CharacterEscapes characterEscapes) {
        this.k = characterEscapes;
        if (characterEscapes == null) {
            this.i = g;
        } else {
            this.i = characterEscapes.getEscapeCodesForAscii();
        }
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator a(com.fasterxml.jackson.core.e eVar) {
        this.l = eVar;
        return this;
    }
}
