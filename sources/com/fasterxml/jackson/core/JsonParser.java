package com.fasterxml.jackson.core;

import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes.dex */
public abstract class JsonParser implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    protected int f417a;

    public abstract JsonToken a() throws IOException, JsonParseException;

    public abstract JsonParser b() throws IOException, JsonParseException;

    public abstract JsonToken c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close() throws IOException;

    public abstract String d() throws IOException, JsonParseException;

    public abstract JsonLocation e();

    public abstract String f() throws IOException, JsonParseException;

    public abstract int i() throws IOException, JsonParseException;

    public abstract long j() throws IOException, JsonParseException;

    public abstract BigInteger k() throws IOException, JsonParseException;

    public abstract float l() throws IOException, JsonParseException;

    public abstract double m() throws IOException, JsonParseException;

    public abstract BigDecimal n() throws IOException, JsonParseException;

    /* loaded from: classes.dex */
    public enum Feature {
        AUTO_CLOSE_SOURCE(true),
        ALLOW_COMMENTS(false),
        ALLOW_UNQUOTED_FIELD_NAMES(false),
        ALLOW_SINGLE_QUOTES(false),
        ALLOW_UNQUOTED_CONTROL_CHARS(false),
        ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER(false),
        ALLOW_NUMERIC_LEADING_ZEROS(false),
        ALLOW_NON_NUMERIC_NUMBERS(false);

        private final boolean _defaultState;

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
            return 1 << ordinal();
        }
    }

    public boolean a(Feature feature) {
        return (this.f417a & feature.getMask()) != 0;
    }

    public byte g() throws IOException, JsonParseException {
        int i = i();
        if (i < -128 || i > 255) {
            throw a("Numeric value (" + f() + ") out of range of Java byte");
        }
        return (byte) i;
    }

    public short h() throws IOException, JsonParseException {
        int i = i();
        if (i < -32768 || i > 32767) {
            throw a("Numeric value (" + f() + ") out of range of Java short");
        }
        return (short) i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JsonParseException a(String str) {
        return new JsonParseException(str, e());
    }
}
