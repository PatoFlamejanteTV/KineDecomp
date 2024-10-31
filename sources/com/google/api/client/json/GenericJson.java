package com.google.api.client.json;

import com.google.api.client.util.GenericData;
import com.google.api.client.util.Throwables;
import java.io.IOException;

/* loaded from: classes.dex */
public class GenericJson extends GenericData implements Cloneable {
    private JsonFactory jsonFactory;

    public final JsonFactory getFactory() {
        return this.jsonFactory;
    }

    public final void setFactory(JsonFactory jsonFactory) {
        this.jsonFactory = jsonFactory;
    }

    @Override // java.util.AbstractMap
    public String toString() {
        if (this.jsonFactory != null) {
            try {
                return this.jsonFactory.a(this);
            } catch (IOException e) {
                throw Throwables.a(e);
            }
        }
        return super.toString();
    }

    public String toPrettyString() throws IOException {
        return this.jsonFactory != null ? this.jsonFactory.b(this) : super.toString();
    }

    @Override // com.google.api.client.util.GenericData, java.util.AbstractMap
    public GenericJson clone() {
        return (GenericJson) super.clone();
    }

    @Override // com.google.api.client.util.GenericData
    public GenericJson set(String str, Object obj) {
        return (GenericJson) super.set(str, obj);
    }
}
