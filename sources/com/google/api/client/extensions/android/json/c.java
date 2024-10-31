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
/* loaded from: classes2.dex */
class c extends JsonParser {

    /* renamed from: c, reason: collision with root package name */
    private final JsonReader f14637c;

    /* renamed from: d, reason: collision with root package name */
    private final AndroidJsonFactory f14638d;

    /* renamed from: e, reason: collision with root package name */
    private List<String> f14639e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private JsonToken f14640f;

    /* renamed from: g, reason: collision with root package name */
    private String f14641g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AndroidJsonFactory androidJsonFactory, JsonReader jsonReader) {
        this.f14638d = androidJsonFactory;
        this.f14637c = jsonReader;
        jsonReader.setLenient(true);
    }

    private void r() {
        JsonToken jsonToken = this.f14640f;
        Preconditions.a(jsonToken == JsonToken.VALUE_NUMBER_INT || jsonToken == JsonToken.VALUE_NUMBER_FLOAT);
    }

    @Override // com.google.api.client.json.JsonParser
    public void a() throws IOException {
        this.f14637c.close();
    }

    @Override // com.google.api.client.json.JsonParser
    public BigInteger b() {
        r();
        return new BigInteger(this.f14641g);
    }

    @Override // com.google.api.client.json.JsonParser
    public byte c() {
        r();
        return Byte.parseByte(this.f14641g);
    }

    @Override // com.google.api.client.json.JsonParser
    public String d() {
        if (this.f14639e.isEmpty()) {
            return null;
        }
        return this.f14639e.get(r0.size() - 1);
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonToken e() {
        return this.f14640f;
    }

    @Override // com.google.api.client.json.JsonParser
    public BigDecimal f() {
        r();
        return new BigDecimal(this.f14641g);
    }

    @Override // com.google.api.client.json.JsonParser
    public double g() {
        r();
        return Double.parseDouble(this.f14641g);
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonFactory h() {
        return this.f14638d;
    }

    @Override // com.google.api.client.json.JsonParser
    public float i() {
        r();
        return Float.parseFloat(this.f14641g);
    }

    @Override // com.google.api.client.json.JsonParser
    public int j() {
        r();
        return Integer.parseInt(this.f14641g);
    }

    @Override // com.google.api.client.json.JsonParser
    public long k() {
        r();
        return Long.parseLong(this.f14641g);
    }

    @Override // com.google.api.client.json.JsonParser
    public short l() {
        r();
        return Short.parseShort(this.f14641g);
    }

    @Override // com.google.api.client.json.JsonParser
    public String m() {
        return this.f14641g;
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonToken n() throws IOException {
        android.util.JsonToken jsonToken;
        JsonToken jsonToken2 = this.f14640f;
        if (jsonToken2 != null) {
            int i = b.f14635a[jsonToken2.ordinal()];
            if (i == 1) {
                this.f14637c.beginArray();
                this.f14639e.add(null);
            } else if (i == 2) {
                this.f14637c.beginObject();
                this.f14639e.add(null);
            }
        }
        try {
            jsonToken = this.f14637c.peek();
        } catch (EOFException unused) {
            jsonToken = android.util.JsonToken.END_DOCUMENT;
        }
        switch (b.f14636b[jsonToken.ordinal()]) {
            case 1:
                this.f14641g = "[";
                this.f14640f = JsonToken.START_ARRAY;
                break;
            case 2:
                this.f14641g = "]";
                this.f14640f = JsonToken.END_ARRAY;
                List<String> list = this.f14639e;
                list.remove(list.size() - 1);
                this.f14637c.endArray();
                break;
            case 3:
                this.f14641g = "{";
                this.f14640f = JsonToken.START_OBJECT;
                break;
            case 4:
                this.f14641g = "}";
                this.f14640f = JsonToken.END_OBJECT;
                List<String> list2 = this.f14639e;
                list2.remove(list2.size() - 1);
                this.f14637c.endObject();
                break;
            case 5:
                if (this.f14637c.nextBoolean()) {
                    this.f14641g = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
                    this.f14640f = JsonToken.VALUE_TRUE;
                    break;
                } else {
                    this.f14641g = "false";
                    this.f14640f = JsonToken.VALUE_FALSE;
                    break;
                }
            case 6:
                this.f14641g = "null";
                this.f14640f = JsonToken.VALUE_NULL;
                this.f14637c.nextNull();
                break;
            case 7:
                this.f14641g = this.f14637c.nextString();
                this.f14640f = JsonToken.VALUE_STRING;
                break;
            case 8:
                this.f14641g = this.f14637c.nextString();
                this.f14640f = this.f14641g.indexOf(46) == -1 ? JsonToken.VALUE_NUMBER_INT : JsonToken.VALUE_NUMBER_FLOAT;
                break;
            case 9:
                this.f14641g = this.f14637c.nextName();
                this.f14640f = JsonToken.FIELD_NAME;
                List<String> list3 = this.f14639e;
                list3.set(list3.size() - 1, this.f14641g);
                break;
            default:
                this.f14641g = null;
                this.f14640f = null;
                break;
        }
        return this.f14640f;
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonParser o() throws IOException {
        JsonToken jsonToken = this.f14640f;
        if (jsonToken != null) {
            int i = b.f14635a[jsonToken.ordinal()];
            if (i == 1) {
                this.f14637c.skipValue();
                this.f14641g = "]";
                this.f14640f = JsonToken.END_ARRAY;
            } else if (i == 2) {
                this.f14637c.skipValue();
                this.f14641g = "}";
                this.f14640f = JsonToken.END_OBJECT;
            }
        }
        return this;
    }
}
