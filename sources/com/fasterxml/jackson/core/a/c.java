package com.fasterxml.jackson.core.a;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* compiled from: ParserMinimalBase.java */
/* loaded from: classes.dex */
public abstract class c extends JsonParser {
    protected JsonToken K;

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract JsonToken a() throws IOException, JsonParseException;

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract String f() throws IOException, JsonParseException;

    protected abstract void t() throws JsonParseException;

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonToken c() {
        return this.K;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser b() throws IOException, JsonParseException {
        if (this.K == JsonToken.START_OBJECT || this.K == JsonToken.START_ARRAY) {
            int i = 1;
            while (true) {
                JsonToken a2 = a();
                if (a2 == null) {
                    t();
                } else {
                    switch (a2) {
                        case START_OBJECT:
                        case START_ARRAY:
                            i++;
                            break;
                        case END_OBJECT:
                        case END_ARRAY:
                            i--;
                            if (i != 0) {
                                break;
                            } else {
                                break;
                            }
                    }
                }
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i, String str) throws JsonParseException {
        String str2 = "Unexpected character (" + c(i) + ")";
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        d(str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C() throws JsonParseException {
        c(" in " + this.K);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(String str) throws JsonParseException {
        d("Unexpected end-of-input" + str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D() throws JsonParseException {
        c(" in a value");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i) throws JsonParseException {
        d("Illegal character (" + c((char) i) + "): only regular white space (\\r, \\n, \\t) is allowed between tokens");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i, String str) throws JsonParseException {
        if (!a(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS) || i >= 32) {
            d("Illegal unquoted character (" + c((char) i) + "): has to be escaped using backslash to be included in " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public char a(char c) throws JsonProcessingException {
        if (!a(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER) && (c != '\'' || !a(JsonParser.Feature.ALLOW_SINGLE_QUOTES))) {
            d("Unrecognized character escape " + c(c));
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final String c(int i) {
        char c = (char) i;
        if (Character.isISOControl(c)) {
            return "(CTRL-CHAR, code " + i + ")";
        }
        if (i > 255) {
            return "'" + c + "' (code " + i + " / 0x" + Integer.toHexString(i) + ")";
        }
        return "'" + c + "' (code " + i + ")";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d(String str) throws JsonParseException {
        throw a(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(String str, Throwable th) throws JsonParseException {
        throw b(str, th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void E() {
        throw new RuntimeException("Internal error: this code path should never get executed");
    }

    protected final JsonParseException b(String str, Throwable th) {
        return new JsonParseException(str, e(), th);
    }
}
