package com.fasterxml.jackson.core.c;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import java.util.HashSet;

/* compiled from: DupDetector.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    protected final Object f9697a;

    /* renamed from: b */
    protected String f9698b;

    /* renamed from: c */
    protected String f9699c;

    /* renamed from: d */
    protected HashSet<String> f9700d;

    private b(Object obj) {
        this.f9697a = obj;
    }

    public static b a(JsonParser jsonParser) {
        return new b(jsonParser);
    }

    public Object b() {
        return this.f9697a;
    }

    public void c() {
        this.f9698b = null;
        this.f9699c = null;
        this.f9700d = null;
    }

    public static b a(JsonGenerator jsonGenerator) {
        return new b(jsonGenerator);
    }

    public b a() {
        return new b(this.f9697a);
    }

    public boolean a(String str) throws JsonParseException {
        String str2 = this.f9698b;
        if (str2 == null) {
            this.f9698b = str;
            return false;
        }
        if (str.equals(str2)) {
            return true;
        }
        String str3 = this.f9699c;
        if (str3 == null) {
            this.f9699c = str;
            return false;
        }
        if (str.equals(str3)) {
            return true;
        }
        if (this.f9700d == null) {
            this.f9700d = new HashSet<>(16);
            this.f9700d.add(this.f9698b);
            this.f9700d.add(this.f9699c);
        }
        return !this.f9700d.add(str);
    }
}
