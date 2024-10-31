package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.util.RequestPayload;
import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes.dex */
public abstract class JsonParser implements Closeable, g {

    /* renamed from: a */
    protected int f9672a;

    /* renamed from: b */
    protected transient RequestPayload f9673b;

    /* loaded from: classes.dex */
    public enum Feature {
        AUTO_CLOSE_SOURCE(true),
        ALLOW_COMMENTS(false),
        ALLOW_YAML_COMMENTS(false),
        ALLOW_UNQUOTED_FIELD_NAMES(false),
        ALLOW_SINGLE_QUOTES(false),
        ALLOW_UNQUOTED_CONTROL_CHARS(false),
        ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER(false),
        ALLOW_NUMERIC_LEADING_ZEROS(false),
        ALLOW_NON_NUMERIC_NUMBERS(false),
        ALLOW_MISSING_VALUES(false),
        ALLOW_TRAILING_COMMA(false),
        STRICT_DUPLICATE_DETECTION(false),
        IGNORE_UNDEFINED(false),
        INCLUDE_SOURCE_IN_LOCATION(true);

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

    protected JsonParser() {
    }

    public abstract String A() throws IOException;

    public abstract JsonToken L() throws IOException;

    public abstract JsonParser M() throws IOException;

    public abstract BigInteger a() throws IOException;

    public boolean a(Feature feature) {
        return feature.enabledIn(this.f9672a);
    }

    public byte b() throws IOException {
        int x = x();
        if (x >= -128 && x <= 255) {
            return (byte) x;
        }
        throw e("Numeric value (" + A() + ") out of range of Java byte");
    }

    public abstract JsonLocation c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close() throws IOException;

    public JsonParseException e(String str) {
        return new JsonParseException(this, str).withRequestPayload(this.f9673b);
    }

    public abstract String r() throws IOException;

    public abstract JsonToken s();

    public abstract BigDecimal u() throws IOException;

    public abstract double v() throws IOException;

    public abstract float w() throws IOException;

    public abstract int x() throws IOException;

    public abstract long y() throws IOException;

    public short z() throws IOException {
        int x = x();
        if (x >= -32768 && x <= 32767) {
            return (short) x;
        }
        throw e("Numeric value (" + A() + ") out of range of Java short");
    }

    public JsonParser(int i) {
        this.f9672a = i;
    }
}
