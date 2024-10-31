package com.fasterxml.jackson.core.c;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import java.io.IOException;

/* compiled from: JsonGeneratorImpl.java */
/* loaded from: classes.dex */
public abstract class c extends com.fasterxml.jackson.core.b.a {

    /* renamed from: h, reason: collision with root package name */
    protected static final int[] f9701h = com.fasterxml.jackson.core.io.a.c();
    protected final com.fasterxml.jackson.core.io.c i;
    protected int[] j;
    protected int k;
    protected CharacterEscapes l;
    protected com.fasterxml.jackson.core.e m;
    protected boolean n;

    public c(com.fasterxml.jackson.core.io.c cVar, int i, com.fasterxml.jackson.core.c cVar2) {
        super(i, cVar2);
        this.j = f9701h;
        this.m = DefaultPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        this.i = cVar;
        if (JsonGenerator.Feature.ESCAPE_NON_ASCII.enabledIn(i)) {
            this.k = 127;
        }
        this.n = !JsonGenerator.Feature.QUOTE_FIELD_NAMES.enabledIn(i);
    }

    public JsonGenerator a(CharacterEscapes characterEscapes) {
        this.l = characterEscapes;
        if (characterEscapes == null) {
            this.j = f9701h;
        } else {
            this.j = characterEscapes.getEscapeCodesForAscii();
        }
        return this;
    }

    public JsonGenerator b(int i) {
        if (i < 0) {
            i = 0;
        }
        this.k = i;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(String str) throws IOException {
        e(String.format("Can not %s, expecting field name (context: %s)", str, this.f9681f.g()));
        throw null;
    }

    public JsonGenerator b(com.fasterxml.jackson.core.e eVar) {
        this.m = eVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, int i) throws IOException {
        if (i == 0) {
            if (this.f9681f.d()) {
                this.f9671a.beforeArrayValues(this);
                return;
            } else {
                if (this.f9681f.e()) {
                    this.f9671a.beforeObjectEntries(this);
                    return;
                }
                return;
            }
        }
        if (i == 1) {
            this.f9671a.writeArrayValueSeparator(this);
            return;
        }
        if (i == 2) {
            this.f9671a.writeObjectFieldValueSeparator(this);
            return;
        }
        if (i == 3) {
            this.f9671a.writeRootValueSeparator(this);
        } else {
            if (i != 5) {
                a();
                throw null;
            }
            i(str);
            throw null;
        }
    }
}
