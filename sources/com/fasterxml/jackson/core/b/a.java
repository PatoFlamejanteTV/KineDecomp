package com.fasterxml.jackson.core.b;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.c.e;
import com.fasterxml.jackson.core.d;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import java.io.IOException;
import java.math.BigDecimal;

/* compiled from: GeneratorBase.java */
/* loaded from: classes.dex */
public abstract class a extends JsonGenerator {

    /* renamed from: b, reason: collision with root package name */
    protected static final int f9677b = (JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS.getMask() | JsonGenerator.Feature.ESCAPE_NON_ASCII.getMask()) | JsonGenerator.Feature.STRICT_DUPLICATE_DETECTION.getMask();

    /* renamed from: c, reason: collision with root package name */
    protected com.fasterxml.jackson.core.c f9678c;

    /* renamed from: d, reason: collision with root package name */
    protected int f9679d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f9680e;

    /* renamed from: f, reason: collision with root package name */
    protected e f9681f;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f9682g;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(int i, com.fasterxml.jackson.core.c cVar) {
        this.f9679d = i;
        this.f9678c = cVar;
        this.f9681f = e.a(JsonGenerator.Feature.STRICT_DUPLICATE_DETECTION.enabledIn(i) ? com.fasterxml.jackson.core.c.b.a(this) : null);
        this.f9680e = JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS.enabledIn(i);
    }

    public final boolean a(JsonGenerator.Feature feature) {
        return (feature.getMask() & this.f9679d) != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String b(BigDecimal bigDecimal) throws IOException {
        if (JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN.enabledIn(this.f9679d)) {
            int scale = bigDecimal.scale();
            if (scale >= -9999 && scale <= 9999) {
                return bigDecimal.toPlainString();
            }
            e(String.format("Attempt to write plain `java.math.BigDecimal` (see JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) with illegal scale (%d): needs to be between [-%d, %d]", Integer.valueOf(scale), 9999, 9999));
            throw null;
        }
        return bigDecimal.toString();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator c() {
        if (b() != null) {
            return this;
        }
        a(x());
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f9682g = true;
    }

    protected d x() {
        return new DefaultPrettyPrinter();
    }

    public com.fasterxml.jackson.core.b y() {
        return this.f9681f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(int i, int i2) throws IOException {
        if (i2 >= 56320 && i2 <= 57343) {
            return ((i - 55296) << 10) + 65536 + (i2 - 56320);
        }
        e("Incomplete surrogate pair: first char 0x" + Integer.toHexString(i) + ", second 0x" + Integer.toHexString(i2));
        throw null;
    }
}
