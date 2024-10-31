package com.fasterxml.jackson.core.a;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.b.e;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import java.io.IOException;

/* compiled from: GeneratorBase.java */
/* loaded from: classes.dex */
public abstract class a extends JsonGenerator {
    protected com.fasterxml.jackson.core.c b;
    protected int c;
    protected boolean f;
    protected e e = e.g();
    protected boolean d = a(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS);

    protected abstract void d(String str) throws IOException, JsonGenerationException;

    protected abstract void i();

    /* JADX INFO: Access modifiers changed from: protected */
    public a(int i, com.fasterxml.jackson.core.c cVar) {
        this.c = i;
        this.b = cVar;
    }

    public final boolean a(JsonGenerator.Feature feature) {
        return (this.c & feature.getMask()) != 0;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator b() {
        return a() != null ? this : a(new DefaultPrettyPrinter());
    }

    public final e h() {
        return this.e;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(String str) throws JsonGenerationException {
        throw new JsonGenerationException(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        throw new RuntimeException("Internal error: should never end up through this code path");
    }
}
