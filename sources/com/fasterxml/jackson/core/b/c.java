package com.fasterxml.jackson.core.b;

import android.support.v7.widget.ActivityChooserView;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.JsonEOFException;
import com.fasterxml.jackson.core.util.g;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: ParserMinimalBase.java */
/* loaded from: classes.dex */
public abstract class c extends JsonParser {

    /* renamed from: c */
    protected static final byte[] f9683c = new byte[0];

    /* renamed from: d */
    protected static final int[] f9684d = new int[0];

    /* renamed from: e */
    protected static final BigInteger f9685e = BigInteger.valueOf(-2147483648L);

    /* renamed from: f */
    protected static final BigInteger f9686f = BigInteger.valueOf(2147483647L);

    /* renamed from: g */
    protected static final BigInteger f9687g = BigInteger.valueOf(Long.MIN_VALUE);

    /* renamed from: h */
    protected static final BigInteger f9688h = BigInteger.valueOf(Long.MAX_VALUE);
    protected static final BigDecimal i = new BigDecimal(f9687g);
    protected static final BigDecimal j = new BigDecimal(f9688h);
    protected static final BigDecimal k = new BigDecimal(f9685e);
    protected static final BigDecimal l = new BigDecimal(f9686f);
    protected JsonToken m;

    public c(int i2) {
        super(i2);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser M() throws IOException {
        JsonToken jsonToken = this.m;
        if (jsonToken != JsonToken.START_OBJECT && jsonToken != JsonToken.START_ARRAY) {
            return this;
        }
        int i2 = 1;
        while (true) {
            JsonToken L = L();
            if (L == null) {
                N();
                return this;
            }
            if (L.isStructStart()) {
                i2++;
            } else if (L.isStructEnd()) {
                i2--;
                if (i2 == 0) {
                    return this;
                }
            } else if (L == JsonToken.NOT_AVAILABLE) {
                a("Not enough content available for `skipChildren()`: non-blocking parser? (%s)", getClass().getName());
                throw null;
            }
        }
    }

    protected abstract void N() throws JsonParseException;

    public void O() throws JsonParseException {
        a(" in " + this.m, this.m);
        throw null;
    }

    public final void P() {
        g.a();
        throw null;
    }

    public void Q() throws IOException {
        f(String.format("Numeric value (%s) out of range of int (%d - %s)", A(), Integer.MIN_VALUE, Integer.valueOf(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED)));
        throw null;
    }

    public void R() throws IOException {
        f(String.format("Numeric value (%s) out of range of long (%d - %s)", A(), Long.MIN_VALUE, Long.MAX_VALUE));
        throw null;
    }

    public void a(JsonToken jsonToken) throws JsonParseException {
        String str;
        if (jsonToken != JsonToken.VALUE_STRING) {
            str = (jsonToken == JsonToken.VALUE_NUMBER_INT || jsonToken == JsonToken.VALUE_NUMBER_FLOAT) ? " in a Number value" : " in a value";
        } else {
            str = " in a String value";
        }
        a(str, jsonToken);
        throw null;
    }

    public void b(int i2, String str) throws JsonParseException {
        if (i2 >= 0) {
            String format = String.format("Unexpected character (%s)", a(i2));
            if (str != null) {
                format = format + ": " + str;
            }
            f(format);
            throw null;
        }
        O();
        throw null;
    }

    public void c(int i2) throws JsonParseException {
        f("Illegal character (" + a((int) ((char) i2)) + "): only regular white space (\\r, \\n, \\t) is allowed between tokens");
        throw null;
    }

    public void d(int i2, String str) throws JsonParseException {
        String format = String.format("Unexpected character (%s) in numeric value", a(i2));
        if (str != null) {
            format = format + ": " + str;
        }
        f(format);
        throw null;
    }

    public final void f(String str) throws JsonParseException {
        throw e(str);
    }

    public void g(String str) throws JsonParseException {
        f("Invalid numeric value: " + str);
        throw null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonToken s() {
        return this.m;
    }

    public void c(int i2, String str) throws JsonParseException {
        if (!a(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS) || i2 > 32) {
            f("Illegal unquoted character (" + a((int) ((char) i2)) + "): has to be escaped using backslash to be included in " + str);
            throw null;
        }
    }

    public void a(String str, JsonToken jsonToken) throws JsonParseException {
        throw new JsonEOFException(this, jsonToken, "Unexpected end-of-input" + str);
    }

    public char a(char c2) throws JsonProcessingException {
        if (a(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER)) {
            return c2;
        }
        if (c2 == '\'' && a(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
            return c2;
        }
        f("Unrecognized character escape " + a((int) c2));
        throw null;
    }

    public void b(int i2) throws JsonParseException {
        b(i2, "Expected space separating root-level values");
        throw null;
    }

    public final void b(String str, Throwable th) throws JsonParseException {
        throw a(str, th);
    }

    protected static final String a(int i2) {
        char c2 = (char) i2;
        if (Character.isISOControl(c2)) {
            return "(CTRL-CHAR, code " + i2 + ")";
        }
        if (i2 > 255) {
            return "'" + c2 + "' (code " + i2 + " / 0x" + Integer.toHexString(i2) + ")";
        }
        return "'" + c2 + "' (code " + i2 + ")";
    }

    public final void a(String str, Object obj) throws JsonParseException {
        throw e(String.format(str, obj));
    }

    public final void a(String str, Object obj, Object obj2) throws JsonParseException {
        throw e(String.format(str, obj, obj2));
    }

    protected final JsonParseException a(String str, Throwable th) {
        return new JsonParseException(this, str, th);
    }
}
