package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.b.f;
import com.fasterxml.jackson.core.b.g;
import com.fasterxml.jackson.core.b.i;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.InputDecorator;
import com.fasterxml.jackson.core.io.OutputDecorator;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.io.Writer;
import java.lang.ref.SoftReference;
import java.net.URL;

/* loaded from: classes.dex */
public class JsonFactory implements Serializable {
    public static final String FORMAT_NAME_JSON = "JSON";
    private static final long serialVersionUID = 8726401676402117450L;
    protected CharacterEscapes _characterEscapes;
    protected int _factoryFeatures;
    protected int _generatorFeatures;
    protected InputDecorator _inputDecorator;
    protected c _objectCodec;
    protected OutputDecorator _outputDecorator;
    protected int _parserFeatures;
    protected final transient com.fasterxml.jackson.core.c.a _rootByteSymbols;
    protected final transient com.fasterxml.jackson.core.c.b _rootCharSymbols;
    protected e _rootValueSeparator;
    protected static final int DEFAULT_FACTORY_FEATURE_FLAGS = Feature.collectDefaults();
    protected static final int DEFAULT_PARSER_FEATURE_FLAGS = JsonParser.Feature.collectDefaults();
    protected static final int DEFAULT_GENERATOR_FEATURE_FLAGS = JsonGenerator.Feature.collectDefaults();

    /* renamed from: a */
    private static final e f415a = DefaultPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
    protected static final ThreadLocal<SoftReference<BufferRecycler>> _recyclerRef = new ThreadLocal<>();

    /* loaded from: classes.dex */
    public enum Feature {
        INTERN_FIELD_NAMES(true),
        CANONICALIZE_FIELD_NAMES(true);

        private final boolean _defaultState;

        public static int collectDefaults() {
            int i = 0;
            for (Feature feature : values()) {
                if (feature.enabledByDefault()) {
                    i |= feature.getMask();
                }
            }
            return i;
        }

        Feature(boolean z) {
            this._defaultState = z;
        }

        public boolean enabledByDefault() {
            return this._defaultState;
        }

        public boolean enabledIn(int i) {
            return (getMask() & i) != 0;
        }

        public int getMask() {
            return 1 << ordinal();
        }
    }

    public JsonFactory() {
        this(null);
    }

    public JsonFactory(c cVar) {
        this._rootCharSymbols = com.fasterxml.jackson.core.c.b.a();
        this._rootByteSymbols = com.fasterxml.jackson.core.c.a.a();
        this._factoryFeatures = DEFAULT_FACTORY_FEATURE_FLAGS;
        this._parserFeatures = DEFAULT_PARSER_FEATURE_FLAGS;
        this._generatorFeatures = DEFAULT_GENERATOR_FEATURE_FLAGS;
        this._rootValueSeparator = f415a;
        this._objectCodec = cVar;
    }

    public JsonFactory copy() {
        _checkInvalidCopy(JsonFactory.class);
        return new JsonFactory(null);
    }

    protected void _checkInvalidCopy(Class<?> cls) {
        if (getClass() != cls) {
            throw new IllegalStateException("Failed copy(): " + getClass().getName() + " (version: " + version() + ") does not override copy(); it has to");
        }
    }

    protected Object readResolve() {
        return new JsonFactory(this._objectCodec);
    }

    public boolean canUseSchema(a aVar) {
        String formatName = getFormatName();
        return formatName != null && formatName.equals(aVar.a());
    }

    public String getFormatName() {
        if (getClass() == JsonFactory.class) {
            return FORMAT_NAME_JSON;
        }
        return null;
    }

    public MatchStrength hasFormat(com.fasterxml.jackson.core.format.a aVar) throws IOException {
        if (getClass() == JsonFactory.class) {
            return hasJSONFormat(aVar);
        }
        return null;
    }

    public boolean requiresCustomCodec() {
        return false;
    }

    protected MatchStrength hasJSONFormat(com.fasterxml.jackson.core.format.a aVar) throws IOException {
        return com.fasterxml.jackson.core.b.a.a(aVar);
    }

    public Version version() {
        return com.fasterxml.jackson.core.b.b.f423a.a();
    }

    public final JsonFactory configure(Feature feature, boolean z) {
        return z ? enable(feature) : disable(feature);
    }

    public JsonFactory enable(Feature feature) {
        this._factoryFeatures |= feature.getMask();
        return this;
    }

    public JsonFactory disable(Feature feature) {
        this._factoryFeatures &= feature.getMask() ^ (-1);
        return this;
    }

    public final boolean isEnabled(Feature feature) {
        return (this._factoryFeatures & feature.getMask()) != 0;
    }

    public final JsonFactory configure(JsonParser.Feature feature, boolean z) {
        return z ? enable(feature) : disable(feature);
    }

    public JsonFactory enable(JsonParser.Feature feature) {
        this._parserFeatures |= feature.getMask();
        return this;
    }

    public JsonFactory disable(JsonParser.Feature feature) {
        this._parserFeatures &= feature.getMask() ^ (-1);
        return this;
    }

    public final boolean isEnabled(JsonParser.Feature feature) {
        return (this._parserFeatures & feature.getMask()) != 0;
    }

    public InputDecorator getInputDecorator() {
        return this._inputDecorator;
    }

    public JsonFactory setInputDecorator(InputDecorator inputDecorator) {
        this._inputDecorator = inputDecorator;
        return this;
    }

    public final JsonFactory configure(JsonGenerator.Feature feature, boolean z) {
        return z ? enable(feature) : disable(feature);
    }

    public JsonFactory enable(JsonGenerator.Feature feature) {
        this._generatorFeatures |= feature.getMask();
        return this;
    }

    public JsonFactory disable(JsonGenerator.Feature feature) {
        this._generatorFeatures &= feature.getMask() ^ (-1);
        return this;
    }

    public final boolean isEnabled(JsonGenerator.Feature feature) {
        return (this._generatorFeatures & feature.getMask()) != 0;
    }

    public CharacterEscapes getCharacterEscapes() {
        return this._characterEscapes;
    }

    public JsonFactory setCharacterEscapes(CharacterEscapes characterEscapes) {
        this._characterEscapes = characterEscapes;
        return this;
    }

    public OutputDecorator getOutputDecorator() {
        return this._outputDecorator;
    }

    public JsonFactory setOutputDecorator(OutputDecorator outputDecorator) {
        this._outputDecorator = outputDecorator;
        return this;
    }

    public JsonFactory setRootValueSeparator(String str) {
        this._rootValueSeparator = str == null ? null : new SerializedString(str);
        return this;
    }

    public String getRootValueSeparator() {
        if (this._rootValueSeparator == null) {
            return null;
        }
        return this._rootValueSeparator.getValue();
    }

    public JsonFactory setCodec(c cVar) {
        this._objectCodec = cVar;
        return this;
    }

    public c getCodec() {
        return this._objectCodec;
    }

    public JsonParser createParser(File file) throws IOException, JsonParseException {
        return createJsonParser(file);
    }

    public JsonParser createParser(URL url) throws IOException, JsonParseException {
        return createJsonParser(url);
    }

    public JsonParser createParser(InputStream inputStream) throws IOException, JsonParseException {
        return createJsonParser(inputStream);
    }

    public JsonParser createParser(Reader reader) throws IOException, JsonParseException {
        return createJsonParser(reader);
    }

    public JsonParser createParser(byte[] bArr) throws IOException, JsonParseException {
        return createJsonParser(bArr);
    }

    public JsonParser createParser(byte[] bArr, int i, int i2) throws IOException, JsonParseException {
        return createJsonParser(bArr, i, i2);
    }

    public JsonParser createParser(String str) throws IOException, JsonParseException {
        return createJsonParser(str);
    }

    public JsonParser createJsonParser(File file) throws IOException, JsonParseException {
        com.fasterxml.jackson.core.io.c _createContext = _createContext(file, true);
        InputStream fileInputStream = new FileInputStream(file);
        if (this._inputDecorator != null) {
            fileInputStream = this._inputDecorator.decorate(_createContext, fileInputStream);
        }
        return _createParser(fileInputStream, _createContext);
    }

    public JsonParser createJsonParser(URL url) throws IOException, JsonParseException {
        com.fasterxml.jackson.core.io.c _createContext = _createContext(url, true);
        InputStream _optimizedStreamFromURL = _optimizedStreamFromURL(url);
        if (this._inputDecorator != null) {
            _optimizedStreamFromURL = this._inputDecorator.decorate(_createContext, _optimizedStreamFromURL);
        }
        return _createParser(_optimizedStreamFromURL, _createContext);
    }

    public JsonParser createJsonParser(InputStream inputStream) throws IOException, JsonParseException {
        com.fasterxml.jackson.core.io.c _createContext = _createContext(inputStream, false);
        if (this._inputDecorator != null) {
            inputStream = this._inputDecorator.decorate(_createContext, inputStream);
        }
        return _createParser(inputStream, _createContext);
    }

    public JsonParser createJsonParser(Reader reader) throws IOException, JsonParseException {
        com.fasterxml.jackson.core.io.c _createContext = _createContext(reader, false);
        if (this._inputDecorator != null) {
            reader = this._inputDecorator.decorate(_createContext, reader);
        }
        return _createParser(reader, _createContext);
    }

    public JsonParser createJsonParser(byte[] bArr) throws IOException, JsonParseException {
        InputStream decorate;
        com.fasterxml.jackson.core.io.c _createContext = _createContext(bArr, true);
        return (this._inputDecorator == null || (decorate = this._inputDecorator.decorate(_createContext, bArr, 0, bArr.length)) == null) ? _createParser(bArr, 0, bArr.length, _createContext) : _createParser(decorate, _createContext);
    }

    public JsonParser createJsonParser(byte[] bArr, int i, int i2) throws IOException, JsonParseException {
        InputStream decorate;
        com.fasterxml.jackson.core.io.c _createContext = _createContext(bArr, true);
        return (this._inputDecorator == null || (decorate = this._inputDecorator.decorate(_createContext, bArr, i, i2)) == null) ? _createParser(bArr, i, i2, _createContext) : _createParser(decorate, _createContext);
    }

    public JsonParser createJsonParser(String str) throws IOException, JsonParseException {
        Reader stringReader = new StringReader(str);
        com.fasterxml.jackson.core.io.c _createContext = _createContext(stringReader, true);
        if (this._inputDecorator != null) {
            stringReader = this._inputDecorator.decorate(_createContext, stringReader);
        }
        return _createParser(stringReader, _createContext);
    }

    public JsonGenerator createGenerator(OutputStream outputStream, JsonEncoding jsonEncoding) throws IOException {
        return createJsonGenerator(outputStream, jsonEncoding);
    }

    public JsonGenerator createGenerator(Writer writer) throws IOException {
        return createJsonGenerator(writer);
    }

    public JsonGenerator createGenerator(OutputStream outputStream) throws IOException {
        return createJsonGenerator(outputStream);
    }

    public JsonGenerator createGenerator(File file, JsonEncoding jsonEncoding) throws IOException {
        return createJsonGenerator(file, jsonEncoding);
    }

    public JsonGenerator createJsonGenerator(OutputStream outputStream, JsonEncoding jsonEncoding) throws IOException {
        com.fasterxml.jackson.core.io.c _createContext = _createContext(outputStream, false);
        _createContext.a(jsonEncoding);
        if (jsonEncoding == JsonEncoding.UTF8) {
            if (this._outputDecorator != null) {
                outputStream = this._outputDecorator.decorate(_createContext, outputStream);
            }
            return _createUTF8JsonGenerator(outputStream, _createContext);
        }
        Writer _createWriter = _createWriter(outputStream, jsonEncoding, _createContext);
        if (this._outputDecorator != null) {
            _createWriter = this._outputDecorator.decorate(_createContext, _createWriter);
        }
        return _createGenerator(_createWriter, _createContext);
    }

    public JsonGenerator createJsonGenerator(Writer writer) throws IOException {
        com.fasterxml.jackson.core.io.c _createContext = _createContext(writer, false);
        if (this._outputDecorator != null) {
            writer = this._outputDecorator.decorate(_createContext, writer);
        }
        return _createGenerator(writer, _createContext);
    }

    public JsonGenerator createJsonGenerator(OutputStream outputStream) throws IOException {
        return createJsonGenerator(outputStream, JsonEncoding.UTF8);
    }

    public JsonGenerator createJsonGenerator(File file, JsonEncoding jsonEncoding) throws IOException {
        OutputStream fileOutputStream = new FileOutputStream(file);
        com.fasterxml.jackson.core.io.c _createContext = _createContext(fileOutputStream, true);
        _createContext.a(jsonEncoding);
        if (jsonEncoding == JsonEncoding.UTF8) {
            if (this._outputDecorator != null) {
                fileOutputStream = this._outputDecorator.decorate(_createContext, fileOutputStream);
            }
            return _createUTF8JsonGenerator(fileOutputStream, _createContext);
        }
        Writer _createWriter = _createWriter(fileOutputStream, jsonEncoding, _createContext);
        if (this._outputDecorator != null) {
            _createWriter = this._outputDecorator.decorate(_createContext, _createWriter);
        }
        return _createGenerator(_createWriter, _createContext);
    }

    protected JsonParser _createParser(InputStream inputStream, com.fasterxml.jackson.core.io.c cVar) throws IOException, JsonParseException {
        return _createJsonParser(inputStream, cVar);
    }

    @Deprecated
    protected JsonParser _createJsonParser(InputStream inputStream, com.fasterxml.jackson.core.io.c cVar) throws IOException, JsonParseException {
        return new com.fasterxml.jackson.core.b.a(cVar, inputStream).a(this._parserFeatures, this._objectCodec, this._rootByteSymbols, this._rootCharSymbols, isEnabled(Feature.CANONICALIZE_FIELD_NAMES), isEnabled(Feature.INTERN_FIELD_NAMES));
    }

    protected JsonParser _createParser(Reader reader, com.fasterxml.jackson.core.io.c cVar) throws IOException, JsonParseException {
        return _createJsonParser(reader, cVar);
    }

    @Deprecated
    protected JsonParser _createJsonParser(Reader reader, com.fasterxml.jackson.core.io.c cVar) throws IOException, JsonParseException {
        return new f(cVar, this._parserFeatures, reader, this._objectCodec, this._rootCharSymbols.a(isEnabled(Feature.CANONICALIZE_FIELD_NAMES), isEnabled(Feature.INTERN_FIELD_NAMES)));
    }

    protected JsonParser _createParser(byte[] bArr, int i, int i2, com.fasterxml.jackson.core.io.c cVar) throws IOException, JsonParseException {
        return _createJsonParser(bArr, i, i2, cVar);
    }

    @Deprecated
    protected JsonParser _createJsonParser(byte[] bArr, int i, int i2, com.fasterxml.jackson.core.io.c cVar) throws IOException, JsonParseException {
        return new com.fasterxml.jackson.core.b.a(cVar, bArr, i, i2).a(this._parserFeatures, this._objectCodec, this._rootByteSymbols, this._rootCharSymbols, isEnabled(Feature.CANONICALIZE_FIELD_NAMES), isEnabled(Feature.INTERN_FIELD_NAMES));
    }

    protected JsonGenerator _createGenerator(Writer writer, com.fasterxml.jackson.core.io.c cVar) throws IOException {
        return _createJsonGenerator(writer, cVar);
    }

    @Deprecated
    protected JsonGenerator _createJsonGenerator(Writer writer, com.fasterxml.jackson.core.io.c cVar) throws IOException {
        i iVar = new i(cVar, this._generatorFeatures, this._objectCodec, writer);
        if (this._characterEscapes != null) {
            iVar.a(this._characterEscapes);
        }
        e eVar = this._rootValueSeparator;
        if (eVar != f415a) {
            iVar.a(eVar);
        }
        return iVar;
    }

    protected JsonGenerator _createUTF8Generator(OutputStream outputStream, com.fasterxml.jackson.core.io.c cVar) throws IOException {
        return _createUTF8JsonGenerator(outputStream, cVar);
    }

    @Deprecated
    protected JsonGenerator _createUTF8JsonGenerator(OutputStream outputStream, com.fasterxml.jackson.core.io.c cVar) throws IOException {
        g gVar = new g(cVar, this._generatorFeatures, this._objectCodec, outputStream);
        if (this._characterEscapes != null) {
            gVar.a(this._characterEscapes);
        }
        e eVar = this._rootValueSeparator;
        if (eVar != f415a) {
            gVar.a(eVar);
        }
        return gVar;
    }

    protected Writer _createWriter(OutputStream outputStream, JsonEncoding jsonEncoding, com.fasterxml.jackson.core.io.c cVar) throws IOException {
        return jsonEncoding == JsonEncoding.UTF8 ? new com.fasterxml.jackson.core.io.i(cVar, outputStream) : new OutputStreamWriter(outputStream, jsonEncoding.getJavaName());
    }

    protected com.fasterxml.jackson.core.io.c _createContext(Object obj, boolean z) {
        return new com.fasterxml.jackson.core.io.c(_getBufferRecycler(), obj, z);
    }

    public BufferRecycler _getBufferRecycler() {
        SoftReference<BufferRecycler> softReference = _recyclerRef.get();
        BufferRecycler bufferRecycler = softReference == null ? null : softReference.get();
        if (bufferRecycler == null) {
            BufferRecycler bufferRecycler2 = new BufferRecycler();
            _recyclerRef.set(new SoftReference<>(bufferRecycler2));
            return bufferRecycler2;
        }
        return bufferRecycler;
    }

    protected InputStream _optimizedStreamFromURL(URL url) throws IOException {
        String host;
        if ("file".equals(url.getProtocol()) && ((host = url.getHost()) == null || host.length() == 0)) {
            if (url.getPath().indexOf(37) < 0) {
                return new FileInputStream(url.getPath());
            }
            return new FileInputStream(url.getPath());
        }
        return url.openStream();
    }
}
