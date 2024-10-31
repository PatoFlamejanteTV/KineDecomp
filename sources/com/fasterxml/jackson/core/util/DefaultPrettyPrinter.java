package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.d;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.io.SerializedString;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;

/* loaded from: classes.dex */
public class DefaultPrettyPrinter implements d, Serializable {
    public static final SerializedString DEFAULT_ROOT_VALUE_SEPARATOR = new SerializedString(" ");
    private static final long serialVersionUID = -5512586643324525213L;
    protected a _arrayIndenter;
    protected transient int _nesting;
    protected a _objectIndenter;
    protected final e _rootSeparator;
    protected boolean _spacesInObjectEntries;

    /* loaded from: classes.dex */
    public interface a {
        boolean isInline();

        void writeIndentation(JsonGenerator jsonGenerator, int i) throws IOException, JsonGenerationException;
    }

    public DefaultPrettyPrinter() {
        this(DEFAULT_ROOT_VALUE_SEPARATOR);
    }

    public DefaultPrettyPrinter(String str) {
        this(str == null ? null : new SerializedString(str));
    }

    public DefaultPrettyPrinter(e eVar) {
        this._arrayIndenter = FixedSpaceIndenter.instance;
        this._objectIndenter = Lf2SpacesIndenter.instance;
        this._spacesInObjectEntries = true;
        this._nesting = 0;
        this._rootSeparator = eVar;
    }

    public DefaultPrettyPrinter(DefaultPrettyPrinter defaultPrettyPrinter) {
        this(defaultPrettyPrinter, defaultPrettyPrinter._rootSeparator);
    }

    public DefaultPrettyPrinter(DefaultPrettyPrinter defaultPrettyPrinter, e eVar) {
        this._arrayIndenter = FixedSpaceIndenter.instance;
        this._objectIndenter = Lf2SpacesIndenter.instance;
        this._spacesInObjectEntries = true;
        this._nesting = 0;
        this._arrayIndenter = defaultPrettyPrinter._arrayIndenter;
        this._objectIndenter = defaultPrettyPrinter._objectIndenter;
        this._spacesInObjectEntries = defaultPrettyPrinter._spacesInObjectEntries;
        this._nesting = defaultPrettyPrinter._nesting;
        this._rootSeparator = eVar;
    }

    public DefaultPrettyPrinter withRootSeparator(e eVar) {
        if (this._rootSeparator != eVar) {
            return (eVar == null || !eVar.equals(this._rootSeparator)) ? new DefaultPrettyPrinter(this, eVar) : this;
        }
        return this;
    }

    public void indentArraysWith(a aVar) {
        if (aVar == null) {
            aVar = NopIndenter.instance;
        }
        this._arrayIndenter = aVar;
    }

    public void indentObjectsWith(a aVar) {
        if (aVar == null) {
            aVar = NopIndenter.instance;
        }
        this._objectIndenter = aVar;
    }

    public void spacesInObjectEntries(boolean z) {
        this._spacesInObjectEntries = z;
    }

    /* renamed from: createInstance, reason: merged with bridge method [inline-methods] */
    public DefaultPrettyPrinter m0createInstance() {
        return new DefaultPrettyPrinter(this);
    }

    @Override // com.fasterxml.jackson.core.d
    public void writeRootValueSeparator(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        if (this._rootSeparator != null) {
            jsonGenerator.b(this._rootSeparator);
        }
    }

    @Override // com.fasterxml.jackson.core.d
    public void writeStartObject(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        jsonGenerator.a('{');
        if (!this._objectIndenter.isInline()) {
            this._nesting++;
        }
    }

    @Override // com.fasterxml.jackson.core.d
    public void beforeObjectEntries(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        this._objectIndenter.writeIndentation(jsonGenerator, this._nesting);
    }

    @Override // com.fasterxml.jackson.core.d
    public void writeObjectFieldValueSeparator(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        if (this._spacesInObjectEntries) {
            jsonGenerator.c(" : ");
        } else {
            jsonGenerator.a(':');
        }
    }

    @Override // com.fasterxml.jackson.core.d
    public void writeObjectEntrySeparator(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        jsonGenerator.a(',');
        this._objectIndenter.writeIndentation(jsonGenerator, this._nesting);
    }

    @Override // com.fasterxml.jackson.core.d
    public void writeEndObject(JsonGenerator jsonGenerator, int i) throws IOException, JsonGenerationException {
        if (!this._objectIndenter.isInline()) {
            this._nesting--;
        }
        if (i > 0) {
            this._objectIndenter.writeIndentation(jsonGenerator, this._nesting);
        } else {
            jsonGenerator.a(' ');
        }
        jsonGenerator.a('}');
    }

    @Override // com.fasterxml.jackson.core.d
    public void writeStartArray(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        if (!this._arrayIndenter.isInline()) {
            this._nesting++;
        }
        jsonGenerator.a('[');
    }

    @Override // com.fasterxml.jackson.core.d
    public void beforeArrayValues(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        this._arrayIndenter.writeIndentation(jsonGenerator, this._nesting);
    }

    @Override // com.fasterxml.jackson.core.d
    public void writeArrayValueSeparator(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        jsonGenerator.a(',');
        this._arrayIndenter.writeIndentation(jsonGenerator, this._nesting);
    }

    @Override // com.fasterxml.jackson.core.d
    public void writeEndArray(JsonGenerator jsonGenerator, int i) throws IOException, JsonGenerationException {
        if (!this._arrayIndenter.isInline()) {
            this._nesting--;
        }
        if (i > 0) {
            this._arrayIndenter.writeIndentation(jsonGenerator, this._nesting);
        } else {
            jsonGenerator.a(' ');
        }
        jsonGenerator.a(']');
    }

    /* loaded from: classes.dex */
    public static class NopIndenter implements a, Serializable {
        public static NopIndenter instance = new NopIndenter();
        private static final long serialVersionUID = 1;

        @Override // com.fasterxml.jackson.core.util.DefaultPrettyPrinter.a
        public void writeIndentation(JsonGenerator jsonGenerator, int i) {
        }

        @Override // com.fasterxml.jackson.core.util.DefaultPrettyPrinter.a
        public boolean isInline() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class FixedSpaceIndenter implements a, Serializable {
        public static FixedSpaceIndenter instance = new FixedSpaceIndenter();
        private static final long serialVersionUID = 1;

        @Override // com.fasterxml.jackson.core.util.DefaultPrettyPrinter.a
        public void writeIndentation(JsonGenerator jsonGenerator, int i) throws IOException, JsonGenerationException {
            jsonGenerator.a(' ');
        }

        @Override // com.fasterxml.jackson.core.util.DefaultPrettyPrinter.a
        public boolean isInline() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class Lf2SpacesIndenter implements a, Serializable {
        static final char[] SPACES;
        static final int SPACE_COUNT = 64;
        static final String SYSTEM_LINE_SEPARATOR;
        public static Lf2SpacesIndenter instance = new Lf2SpacesIndenter();
        private static final long serialVersionUID = 1;

        static {
            String str = null;
            try {
                str = System.getProperty("line.separator");
            } catch (Throwable th) {
            }
            if (str == null) {
                str = "\n";
            }
            SYSTEM_LINE_SEPARATOR = str;
            SPACES = new char[64];
            Arrays.fill(SPACES, ' ');
        }

        @Override // com.fasterxml.jackson.core.util.DefaultPrettyPrinter.a
        public boolean isInline() {
            return false;
        }

        @Override // com.fasterxml.jackson.core.util.DefaultPrettyPrinter.a
        public void writeIndentation(JsonGenerator jsonGenerator, int i) throws IOException, JsonGenerationException {
            jsonGenerator.c(SYSTEM_LINE_SEPARATOR);
            if (i > 0) {
                int i2 = i + i;
                while (i2 > 64) {
                    jsonGenerator.a(SPACES, 0, 64);
                    i2 -= SPACES.length;
                }
                jsonGenerator.a(SPACES, 0, i2);
            }
        }
    }
}
