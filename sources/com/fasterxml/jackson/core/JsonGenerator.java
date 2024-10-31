package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.io.CharacterEscapes;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes.dex */
public abstract class JsonGenerator implements Closeable, Flushable {

    /* renamed from: a, reason: collision with root package name */
    protected d f416a;

    public abstract void a(char c) throws IOException, JsonGenerationException;

    public abstract void a(double d) throws IOException, JsonGenerationException;

    public abstract void a(float f) throws IOException, JsonGenerationException;

    public abstract void a(long j) throws IOException, JsonGenerationException;

    public abstract void a(String str) throws IOException, JsonGenerationException;

    public abstract void a(BigDecimal bigDecimal) throws IOException, JsonGenerationException;

    public abstract void a(BigInteger bigInteger) throws IOException, JsonGenerationException;

    public abstract void a(boolean z) throws IOException, JsonGenerationException;

    public abstract void a(char[] cArr, int i, int i2) throws IOException, JsonGenerationException;

    public abstract JsonGenerator b();

    public abstract void b(int i) throws IOException, JsonGenerationException;

    public abstract void b(String str) throws IOException, JsonGenerationException;

    public abstract void c() throws IOException, JsonGenerationException;

    public abstract void c(String str) throws IOException, JsonGenerationException;

    public abstract void d() throws IOException, JsonGenerationException;

    public abstract void e() throws IOException, JsonGenerationException;

    public abstract void f() throws IOException, JsonGenerationException;

    @Override // java.io.Flushable
    public abstract void flush() throws IOException;

    public abstract void g() throws IOException, JsonGenerationException;

    /* loaded from: classes.dex */
    public enum Feature {
        AUTO_CLOSE_TARGET(true),
        AUTO_CLOSE_JSON_CONTENT(true),
        QUOTE_FIELD_NAMES(true),
        QUOTE_NON_NUMERIC_NUMBERS(true),
        WRITE_NUMBERS_AS_STRINGS(false),
        FLUSH_PASSED_TO_STREAM(true),
        ESCAPE_NON_ASCII(false);

        private final boolean _defaultState;
        private final int _mask = 1 << ordinal();

        public static int collectDefaults() {
            int i = 0;
            for (Feature feature : values()) {
                if (feature.enabledByDefault()) {
                    i |= feature.getMask();
                }
            }
            return i;
        }

        Feature(boolean z) {
            this._defaultState = z;
        }

        public boolean enabledByDefault() {
            return this._defaultState;
        }

        public int getMask() {
            return this._mask;
        }
    }

    public JsonGenerator a(e eVar) {
        throw new UnsupportedOperationException();
    }

    public JsonGenerator a(d dVar) {
        this.f416a = dVar;
        return this;
    }

    public d a() {
        return this.f416a;
    }

    public JsonGenerator a(int i) {
        return this;
    }

    public JsonGenerator a(CharacterEscapes characterEscapes) {
        return this;
    }

    public void b(e eVar) throws IOException, JsonGenerationException {
        c(eVar.getValue());
    }
}
