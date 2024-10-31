package com.google.api.client.extensions.android.json;

import android.annotation.TargetApi;
import android.util.JsonReader;
import com.facebook.internal.ServerProtocol;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonParser;
import com.google.api.client.json.JsonToken;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AndroidJsonParser.java */
@Beta
@TargetApi(11)
/* loaded from: classes.dex */
class b extends JsonParser {

    /* renamed from: a, reason: collision with root package name */
    private final JsonReader f2422a;
    private final AndroidJsonFactory b;
    private List<String> c = new ArrayList();
    private JsonToken d;
    private String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AndroidJsonFactory androidJsonFactory, JsonReader jsonReader) {
        this.b = androidJsonFactory;
        this.f2422a = jsonReader;
        jsonReader.setLenient(true);
    }

    @Override // com.google.api.client.json.JsonParser
    public void a() throws IOException {
        this.f2422a.close();
    }

    @Override // com.google.api.client.json.JsonParser
    public String b() {
        if (this.c.isEmpty()) {
            return null;
        }
        return this.c.get(this.c.size() - 1);
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonToken c() {
        return this.d;
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonFactory d() {
        return this.b;
    }

    @Override // com.google.api.client.json.JsonParser
    public byte e() {
        p();
        return Byte.valueOf(this.e).byteValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public short f() {
        p();
        return Short.valueOf(this.e).shortValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public int g() {
        p();
        return Integer.valueOf(this.e).intValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public float h() {
        p();
        return Float.valueOf(this.e).floatValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public BigInteger i() {
        p();
        return new BigInteger(this.e);
    }

    @Override // com.google.api.client.json.JsonParser
    public BigDecimal j() {
        p();
        return new BigDecimal(this.e);
    }

    @Override // com.google.api.client.json.JsonParser
    public double k() {
        p();
        return Double.valueOf(this.e).doubleValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public long l() {
        p();
        return Long.valueOf(this.e).longValue();
    }

    private void p() {
        Preconditions.a(this.d == JsonToken.VALUE_NUMBER_INT || this.d == JsonToken.VALUE_NUMBER_FLOAT);
    }

    @Override // com.google.api.client.json.JsonParser
    public String m() {
        return this.e;
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonToken n() throws IOException {
        android.util.JsonToken jsonToken;
        if (this.d != null) {
            switch (this.d) {
                case START_ARRAY:
                    this.f2422a.beginArray();
                    this.c.add(null);
                    break;
                case START_OBJECT:
                    this.f2422a.beginObject();
                    this.c.add(null);
                    break;
            }
        }
        try {
            jsonToken = this.f2422a.peek();
        } catch (EOFException e) {
            jsonToken = android.util.JsonToken.END_DOCUMENT;
        }
        switch (AnonymousClass1.b[jsonToken.ordinal()]) {
            case 1:
                this.e = "[";
                this.d = JsonToken.START_ARRAY;
                break;
            case 2:
                this.e = "]";
                this.d = JsonToken.END_ARRAY;
                this.c.remove(this.c.size() - 1);
                this.f2422a.endArray();
                break;
            case 3:
                this.e = "{";
                this.d = JsonToken.START_OBJECT;
                break;
            case 4:
                this.e = "}";
                this.d = JsonToken.END_OBJECT;
                this.c.remove(this.c.size() - 1);
                this.f2422a.endObject();
                break;
            case 5:
                if (this.f2422a.nextBoolean()) {
                    this.e = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
                    this.d = JsonToken.VALUE_TRUE;
                    break;
                } else {
                    this.e = "false";
                    this.d = JsonToken.VALUE_FALSE;
                    break;
                }
            case 6:
                this.e = "null";
                this.d = JsonToken.VALUE_NULL;
                this.f2422a.nextNull();
                break;
            case 7:
                this.e = this.f2422a.nextString();
                this.d = JsonToken.VALUE_STRING;
                break;
            case 8:
                this.e = this.f2422a.nextString();
                this.d = this.e.indexOf(46) == -1 ? JsonToken.VALUE_NUMBER_INT : JsonToken.VALUE_NUMBER_FLOAT;
                break;
            case 9:
                this.e = this.f2422a.nextName();
                this.d = JsonToken.FIELD_NAME;
                this.c.set(this.c.size() - 1, this.e);
                break;
            default:
                this.e = null;
                this.d = null;
                break;
        }
        return this.d;
    }

    /* compiled from: AndroidJsonParser.java */
    /* renamed from: com.google.api.client.extensions.android.json.b$1, reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] b = new int[android.util.JsonToken.values().length];

        static {
            try {
                b[android.util.JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[android.util.JsonToken.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                b[android.util.JsonToken.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                b[android.util.JsonToken.END_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                b[android.util.JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                b[android.util.JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                b[android.util.JsonToken.STRING.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                b[android.util.JsonToken.NUMBER.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                b[android.util.JsonToken.NAME.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            f2423a = new int[JsonToken.values().length];
            try {
                f2423a[JsonToken.START_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f2423a[JsonToken.START_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.api.client.json.JsonParser
    public JsonParser o() throws IOException {
        if (this.d != null) {
            switch (this.d) {
                case START_ARRAY:
                    this.f2422a.skipValue();
                    this.e = "]";
                    this.d = JsonToken.END_ARRAY;
                    break;
                case START_OBJECT:
                    this.f2422a.skipValue();
                    this.e = "}";
                    this.d = JsonToken.END_OBJECT;
                    break;
            }
        }
        return this;
    }
}
