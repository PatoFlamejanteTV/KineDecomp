package com.fasterxml.jackson.core;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes.dex */
public abstract class JsonGenerator implements Closeable, Flushable, g {

    /* renamed from: a */
    protected d f9671a;

    /* loaded from: classes.dex */
    public enum Feature {
        AUTO_CLOSE_TARGET(true),
        AUTO_CLOSE_JSON_CONTENT(true),
        FLUSH_PASSED_TO_STREAM(true),
        QUOTE_FIELD_NAMES(true),
        QUOTE_NON_NUMERIC_NUMBERS(true),
        WRITE_NUMBERS_AS_STRINGS(false),
        WRITE_BIGDECIMAL_AS_PLAIN(false),
        ESCAPE_NON_ASCII(false),
        STRICT_DUPLICATE_DETECTION(false),
        IGNORE_UNKNOWN(false);

        private final boolean _defaultState;
        private final int _mask = 1 << ordinal();

        Feature(boolean z) {
            this._defaultState = z;
        }

        public static int collectDefaults() {
            int i = 0;
            for (Feature feature : values()) {
                if (feature.enabledByDefault()) {
                    i |= feature.getMask();
                }
            }
            return i;
        }

        public boolean enabledByDefault() {
            return this._defaultState;
        }

        public boolean enabledIn(int i) {
            return (i & this._mask) != 0;
        }

        public int getMask() {
            return this._mask;
        }
    }

    public JsonGenerator a(d dVar) {
        this.f9671a = dVar;
        return this;
    }

    public abstract void a(char c2) throws IOException;

    public abstract void a(double d2) throws IOException;

    public abstract void a(float f2) throws IOException;

    public abstract void a(int i) throws IOException;

    public abstract void a(BigDecimal bigDecimal) throws IOException;

    public abstract void a(BigInteger bigInteger) throws IOException;

    public abstract void a(boolean z) throws IOException;

    public abstract void a(char[] cArr, int i, int i2) throws IOException;

    public d b() {
        return this.f9671a;
    }

    public abstract JsonGenerator c();

    public void e(String str) throws JsonGenerationException {
        throw new JsonGenerationException(str, this);
    }

    public abstract void f(String str) throws IOException;

    @Override // java.io.Flushable
    public abstract void flush() throws IOException;

    public abstract void g(long j) throws IOException;

    public abstract void g(String str) throws IOException;

    public abstract void h(String str) throws IOException;

    public abstract void r() throws IOException;

    public abstract void s() throws IOException;

    public abstract void u() throws IOException;

    public abstract void v() throws IOException;

    public abstract void w() throws IOException;

    public void a(e eVar) throws IOException {
        g(eVar.getValue());
    }

    public final void a() {
        com.fasterxml.jackson.core.util.g.a();
        throw null;
    }
}
