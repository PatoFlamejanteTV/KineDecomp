package com.google.api.client.json;

import com.google.api.client.util.GenericData;
import com.google.api.client.util.Throwables;
import java.io.IOException;

/* loaded from: classes2.dex */
public class GenericJson extends GenericData implements Cloneable {
    private JsonFactory jsonFactory;

    public final JsonFactory getFactory() {
        return this.jsonFactory;
    }

    public final void setFactory(JsonFactory jsonFactory) {
        this.jsonFactory = jsonFactory;
    }

    public String toPrettyString() throws IOException {
        JsonFactory jsonFactory = this.jsonFactory;
        if (jsonFactory != null) {
            return jsonFactory.b(this);
        }
        return super.toString();
    }

    @Override // java.util.AbstractMap
    public String toString() {
        JsonFactory jsonFactory = this.jsonFactory;
        if (jsonFactory != null) {
            try {
                return jsonFactory.c(this);
            } catch (IOException e2) {
                Throwables.a(e2);
                throw null;
            }
        }
        return super.toString();
    }

    @Override // com.google.api.client.util.GenericData
    public GenericJson set(String str, Object obj) {
        super.set(str, obj);
        return this;
    }

    @Override // com.google.api.client.util.GenericData, java.util.AbstractMap
    public GenericJson clone() {
        return (GenericJson) super.clone();
    }
}
