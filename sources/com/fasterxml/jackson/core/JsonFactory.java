package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.c.h;
import com.fasterxml.jackson.core.c.i;
import com.fasterxml.jackson.core.c.k;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.InputDecorator;
import com.fasterxml.jackson.core.io.OutputDecorator;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import java.io.CharArrayReader;
import java.io.DataInput;
import java.io.DataOutput;
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
import java.net.URL;

/* loaded from: classes.dex */
public class JsonFactory implements g, Serializable {
    public static final String FORMAT_NAME_JSON = "JSON";
    private static final long serialVersionUID = 1;
    protected final transient com.fasterxml.jackson.core.d.a _byteSymbolCanonicalizer;
    protected CharacterEscapes _characterEscapes;
    protected int _factoryFeatures;
    protected int _generatorFeatures;
    protected InputDecorator _inputDecorator;
    protected c _objectCodec;
    protected OutputDecorator _outputDecorator;
    protected int _parserFeatures;
    protected final transient com.fasterxml.jackson.core.d.b _rootCharSymbols;
    protected e _rootValueSeparator;
    protected static final int DEFAULT_FACTORY_FEATURE_FLAGS = Feature.collectDefaults();
    protected static final int DEFAULT_PARSER_FEATURE_FLAGS = JsonParser.Feature.collectDefaults();
    protected static final int DEFAULT_GENERATOR_FEATURE_FLAGS = JsonGenerator.Feature.collectDefaults();

    /* renamed from: a, reason: collision with root package name */
    private static final e f9670a = DefaultPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;

    /* loaded from: classes.dex */
    public enum Feature {
        INTERN_FIELD_NAMES(true),
        CANONICALIZE_FIELD_NAMES(true),
        FAIL_ON_SYMBOL_HASH_OVERFLOW(true),
        USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING(true);

        private final boolean _defaultState;

        Feature(boolean z) {
            this._defaultState = z;
        }

        public static int collectDefaults() {
            int i = 0;
            for (Feature feature : values()) {
                if (feature.enabledByDefault()) {
                    i |= feature.getMask();
                }
            }
            return i;
        }

        public boolean enabledByDefault() {
            return this._defaultState;
        }

        public boolean enabledIn(int i) {
            return (i & getMask()) != 0;
        }

        public int getMask() {
            return 1 << ordinal();
        }
    }

    public JsonFactory() {
        this(null);
    }

    private final void a(String str) {
        if (!a()) {
            throw new UnsupportedOperationException(String.format(str, getFormatName()));
        }
    }

    protected void _checkInvalidCopy(Class<?> cls) {
        if (JsonFactory.class == cls) {
            return;
        }
        throw new IllegalStateException("Failed copy(): " + JsonFactory.class.getName() + " (version: " + version() + ") does not override copy(); it has to");
    }

    protected com.fasterxml.jackson.core.io.c _createContext(Object obj, boolean z) {
        return new com.fasterxml.jackson.core.io.c(_getBufferRecycler(), obj, z);
    }

    protected OutputStream _createDataOutputWrapper(DataOutput dataOutput) {
        return new com.fasterxml.jackson.core.io.b(dataOutput);
    }

    protected JsonGenerator _createGenerator(Writer writer, com.fasterxml.jackson.core.io.c cVar) throws IOException {
        k kVar = new k(cVar, this._generatorFeatures, this._objectCodec, writer);
        CharacterEscapes characterEscapes = this._characterEscapes;
        if (characterEscapes != null) {
            kVar.a(characterEscapes);
        }
        e eVar = this._rootValueSeparator;
        if (eVar != f9670a) {
            kVar.b(eVar);
        }
        return kVar;
    }

    protected JsonParser _createParser(InputStream inputStream, com.fasterxml.jackson.core.io.c cVar) throws IOException {
        return new com.fasterxml.jackson.core.c.a(cVar, inputStream).a(this._parserFeatures, this._objectCodec, this._byteSymbolCanonicalizer, this._rootCharSymbols, this._factoryFeatures);
    }

    protected JsonGenerator _createUTF8Generator(OutputStream outputStream, com.fasterxml.jackson.core.io.c cVar) throws IOException {
        i iVar = new i(cVar, this._generatorFeatures, this._objectCodec, outputStream);
        CharacterEscapes characterEscapes = this._characterEscapes;
        if (characterEscapes != null) {
            iVar.a(characterEscapes);
        }
        e eVar = this._rootValueSeparator;
        if (eVar != f9670a) {
            iVar.b(eVar);
        }
        return iVar;
    }

    protected Writer _createWriter(OutputStream outputStream, JsonEncoding jsonEncoding, com.fasterxml.jackson.core.io.c cVar) throws IOException {
        if (jsonEncoding == JsonEncoding.UTF8) {
            return new com.fasterxml.jackson.core.io.i(cVar, outputStream);
        }
        return new OutputStreamWriter(outputStream, jsonEncoding.getJavaName());
    }

    protected final InputStream _decorate(InputStream inputStream, com.fasterxml.jackson.core.io.c cVar) throws IOException {
        InputStream decorate;
        InputDecorator inputDecorator = this._inputDecorator;
        return (inputDecorator == null || (decorate = inputDecorator.decorate(cVar, inputStream)) == null) ? inputStream : decorate;
    }

    public com.fasterxml.jackson.core.util.a _getBufferRecycler() {
        if (Feature.USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING.enabledIn(this._factoryFeatures)) {
            return com.fasterxml.jackson.core.util.b.a();
        }
        return new com.fasterxml.jackson.core.util.a();
    }

    protected InputStream _optimizedStreamFromURL(URL url) throws IOException {
        String host;
        if ("file".equals(url.getProtocol()) && (((host = url.getHost()) == null || host.length() == 0) && url.getPath().indexOf(37) < 0)) {
            return new FileInputStream(url.getPath());
        }
        return url.openStream();
    }

    public boolean canHandleBinaryNatively() {
        return false;
    }

    public boolean canParseAsync() {
        return a();
    }

    public boolean canUseCharArrays() {
        return true;
    }

    public boolean canUseSchema(a aVar) {
        String formatName;
        return (aVar == null || (formatName = getFormatName()) == null || !formatName.equals(aVar.a())) ? false : true;
    }

    public final JsonFactory configure(Feature feature, boolean z) {
        return z ? enable(feature) : disable(feature);
    }

    public JsonFactory copy() {
        _checkInvalidCopy(JsonFactory.class);
        return new JsonFactory(this, null);
    }

    public JsonGenerator createGenerator(OutputStream outputStream, JsonEncoding jsonEncoding) throws IOException {
        com.fasterxml.jackson.core.io.c _createContext = _createContext(outputStream, false);
        _createContext.a(jsonEncoding);
        if (jsonEncoding == JsonEncoding.UTF8) {
            return _createUTF8Generator(_decorate(outputStream, _createContext), _createContext);
        }
        return _createGenerator(_decorate(_createWriter(outputStream, jsonEncoding, _createContext), _createContext), _createContext);
    }

    @Deprecated
    public JsonGenerator createJsonGenerator(OutputStream outputStream, JsonEncoding jsonEncoding) throws IOException {
        return createGenerator(outputStream, jsonEncoding);
    }

    @Deprecated
    public JsonParser createJsonParser(File file) throws IOException, JsonParseException {
        return createParser(file);
    }

    public JsonParser createNonBlockingByteArrayParser() throws IOException {
        a("Non-blocking source not (yet?) support for this format (%s)");
        return new com.fasterxml.jackson.core.c.a.a(_createContext(null, false), this._parserFeatures, this._byteSymbolCanonicalizer.e(this._factoryFeatures));
    }

    public JsonParser createParser(File file) throws IOException, JsonParseException {
        com.fasterxml.jackson.core.io.c _createContext = _createContext(file, true);
        return _createParser(_decorate(new FileInputStream(file), _createContext), _createContext);
    }

    public JsonFactory disable(Feature feature) {
        this._factoryFeatures = (feature.getMask() ^ (-1)) & this._factoryFeatures;
        return this;
    }

    public JsonFactory enable(Feature feature) {
        this._factoryFeatures = feature.getMask() | this._factoryFeatures;
        return this;
    }

    public CharacterEscapes getCharacterEscapes() {
        return this._characterEscapes;
    }

    public c getCodec() {
        return this._objectCodec;
    }

    public String getFormatName() {
        if (JsonFactory.class == JsonFactory.class) {
            return FORMAT_NAME_JSON;
        }
        return null;
    }

    public Class<? extends Object> getFormatReadFeatureType() {
        return null;
    }

    public Class<? extends Object> getFormatWriteFeatureType() {
        return null;
    }

    public InputDecorator getInputDecorator() {
        return this._inputDecorator;
    }

    public OutputDecorator getOutputDecorator() {
        return this._outputDecorator;
    }

    public String getRootValueSeparator() {
        e eVar = this._rootValueSeparator;
        if (eVar == null) {
            return null;
        }
        return eVar.getValue();
    }

    public MatchStrength hasFormat(com.fasterxml.jackson.core.format.a aVar) throws IOException {
        if (JsonFactory.class == JsonFactory.class) {
            return hasJSONFormat(aVar);
        }
        return null;
    }

    protected MatchStrength hasJSONFormat(com.fasterxml.jackson.core.format.a aVar) throws IOException {
        return com.fasterxml.jackson.core.c.a.a(aVar);
    }

    public final boolean isEnabled(Feature feature) {
        return (feature.getMask() & this._factoryFeatures) != 0;
    }

    protected Object readResolve() {
        return new JsonFactory(this, this._objectCodec);
    }

    public boolean requiresCustomCodec() {
        return false;
    }

    public boolean requiresPropertyOrdering() {
        return false;
    }

    public JsonFactory setCharacterEscapes(CharacterEscapes characterEscapes) {
        this._characterEscapes = characterEscapes;
        return this;
    }

    public JsonFactory setCodec(c cVar) {
        this._objectCodec = cVar;
        return this;
    }

    public JsonFactory setInputDecorator(InputDecorator inputDecorator) {
        this._inputDecorator = inputDecorator;
        return this;
    }

    public JsonFactory setOutputDecorator(OutputDecorator outputDecorator) {
        this._outputDecorator = outputDecorator;
        return this;
    }

    public JsonFactory setRootValueSeparator(String str) {
        this._rootValueSeparator = str == null ? null : new SerializedString(str);
        return this;
    }

    public Version version() {
        return com.fasterxml.jackson.core.c.f.f9714a;
    }

    public JsonFactory(c cVar) {
        this._rootCharSymbols = com.fasterxml.jackson.core.d.b.a();
        this._byteSymbolCanonicalizer = com.fasterxml.jackson.core.d.a.b();
        this._factoryFeatures = DEFAULT_FACTORY_FEATURE_FLAGS;
        this._parserFeatures = DEFAULT_PARSER_FEATURE_FLAGS;
        this._generatorFeatures = DEFAULT_GENERATOR_FEATURE_FLAGS;
        this._rootValueSeparator = f9670a;
        this._objectCodec = cVar;
    }

    protected JsonParser _createParser(Reader reader, com.fasterxml.jackson.core.io.c cVar) throws IOException {
        return new com.fasterxml.jackson.core.c.g(cVar, this._parserFeatures, reader, this._objectCodec, this._rootCharSymbols.c(this._factoryFeatures));
    }

    public final JsonFactory configure(JsonParser.Feature feature, boolean z) {
        return z ? enable(feature) : disable(feature);
    }

    @Deprecated
    public JsonGenerator createJsonGenerator(Writer writer) throws IOException {
        return createGenerator(writer);
    }

    @Deprecated
    public JsonParser createJsonParser(URL url) throws IOException, JsonParseException {
        return createParser(url);
    }

    public JsonFactory disable(JsonParser.Feature feature) {
        this._parserFeatures = (feature.getMask() ^ (-1)) & this._parserFeatures;
        return this;
    }

    public JsonFactory enable(JsonParser.Feature feature) {
        this._parserFeatures = feature.getMask() | this._parserFeatures;
        return this;
    }

    public final boolean isEnabled(JsonParser.Feature feature) {
        return (feature.getMask() & this._parserFeatures) != 0;
    }

    private final boolean a() {
        return getFormatName() == FORMAT_NAME_JSON;
    }

    protected JsonParser _createParser(char[] cArr, int i, int i2, com.fasterxml.jackson.core.io.c cVar, boolean z) throws IOException {
        return new com.fasterxml.jackson.core.c.g(cVar, this._parserFeatures, null, this._objectCodec, this._rootCharSymbols.c(this._factoryFeatures), cArr, i, i + i2, z);
    }

    protected final Reader _decorate(Reader reader, com.fasterxml.jackson.core.io.c cVar) throws IOException {
        Reader decorate;
        InputDecorator inputDecorator = this._inputDecorator;
        return (inputDecorator == null || (decorate = inputDecorator.decorate(cVar, reader)) == null) ? reader : decorate;
    }

    public final JsonFactory configure(JsonGenerator.Feature feature, boolean z) {
        return z ? enable(feature) : disable(feature);
    }

    @Deprecated
    public JsonGenerator createJsonGenerator(OutputStream outputStream) throws IOException {
        return createGenerator(outputStream, JsonEncoding.UTF8);
    }

    @Deprecated
    public JsonParser createJsonParser(InputStream inputStream) throws IOException, JsonParseException {
        return createParser(inputStream);
    }

    public JsonFactory disable(JsonGenerator.Feature feature) {
        this._generatorFeatures = (feature.getMask() ^ (-1)) & this._generatorFeatures;
        return this;
    }

    public JsonFactory enable(JsonGenerator.Feature feature) {
        this._generatorFeatures = feature.getMask() | this._generatorFeatures;
        return this;
    }

    public final boolean isEnabled(JsonGenerator.Feature feature) {
        return (feature.getMask() & this._generatorFeatures) != 0;
    }

    protected JsonParser _createParser(byte[] bArr, int i, int i2, com.fasterxml.jackson.core.io.c cVar) throws IOException {
        return new com.fasterxml.jackson.core.c.a(cVar, bArr, i, i2).a(this._parserFeatures, this._objectCodec, this._byteSymbolCanonicalizer, this._rootCharSymbols, this._factoryFeatures);
    }

    @Deprecated
    public JsonParser createJsonParser(Reader reader) throws IOException, JsonParseException {
        return createParser(reader);
    }

    public JsonParser createParser(URL url) throws IOException, JsonParseException {
        com.fasterxml.jackson.core.io.c _createContext = _createContext(url, true);
        return _createParser(_decorate(_optimizedStreamFromURL(url), _createContext), _createContext);
    }

    protected JsonParser _createParser(DataInput dataInput, com.fasterxml.jackson.core.io.c cVar) throws IOException {
        a("InputData source not (yet?) support for this format (%s)");
        int a2 = com.fasterxml.jackson.core.c.a.a(dataInput);
        return new h(cVar, this._parserFeatures, dataInput, this._objectCodec, this._byteSymbolCanonicalizer.e(this._factoryFeatures), a2);
    }

    protected final DataInput _decorate(DataInput dataInput, com.fasterxml.jackson.core.io.c cVar) throws IOException {
        DataInput decorate;
        InputDecorator inputDecorator = this._inputDecorator;
        return (inputDecorator == null || (decorate = inputDecorator.decorate(cVar, dataInput)) == null) ? dataInput : decorate;
    }

    @Deprecated
    public JsonParser createJsonParser(byte[] bArr) throws IOException, JsonParseException {
        return createParser(bArr);
    }

    @Deprecated
    public JsonParser createJsonParser(byte[] bArr, int i, int i2) throws IOException, JsonParseException {
        return createParser(bArr, i, i2);
    }

    protected final OutputStream _decorate(OutputStream outputStream, com.fasterxml.jackson.core.io.c cVar) throws IOException {
        OutputStream decorate;
        OutputDecorator outputDecorator = this._outputDecorator;
        return (outputDecorator == null || (decorate = outputDecorator.decorate(cVar, outputStream)) == null) ? outputStream : decorate;
    }

    public JsonGenerator createGenerator(OutputStream outputStream) throws IOException {
        return createGenerator(outputStream, JsonEncoding.UTF8);
    }

    @Deprecated
    public JsonParser createJsonParser(String str) throws IOException, JsonParseException {
        return createParser(str);
    }

    public JsonParser createParser(InputStream inputStream) throws IOException, JsonParseException {
        com.fasterxml.jackson.core.io.c _createContext = _createContext(inputStream, false);
        return _createParser(_decorate(inputStream, _createContext), _createContext);
    }

    public JsonGenerator createGenerator(Writer writer) throws IOException {
        com.fasterxml.jackson.core.io.c _createContext = _createContext(writer, false);
        return _createGenerator(_decorate(writer, _createContext), _createContext);
    }

    protected final Writer _decorate(Writer writer, com.fasterxml.jackson.core.io.c cVar) throws IOException {
        Writer decorate;
        OutputDecorator outputDecorator = this._outputDecorator;
        return (outputDecorator == null || (decorate = outputDecorator.decorate(cVar, writer)) == null) ? writer : decorate;
    }

    public JsonParser createParser(Reader reader) throws IOException, JsonParseException {
        com.fasterxml.jackson.core.io.c _createContext = _createContext(reader, false);
        return _createParser(_decorate(reader, _createContext), _createContext);
    }

    protected JsonFactory(JsonFactory jsonFactory, c cVar) {
        this._rootCharSymbols = com.fasterxml.jackson.core.d.b.a();
        this._byteSymbolCanonicalizer = com.fasterxml.jackson.core.d.a.b();
        this._factoryFeatures = DEFAULT_FACTORY_FEATURE_FLAGS;
        this._parserFeatures = DEFAULT_PARSER_FEATURE_FLAGS;
        this._generatorFeatures = DEFAULT_GENERATOR_FEATURE_FLAGS;
        this._rootValueSeparator = f9670a;
        this._objectCodec = cVar;
        this._factoryFeatures = jsonFactory._factoryFeatures;
        this._parserFeatures = jsonFactory._parserFeatures;
        this._generatorFeatures = jsonFactory._generatorFeatures;
        this._characterEscapes = jsonFactory._characterEscapes;
        this._inputDecorator = jsonFactory._inputDecorator;
        this._outputDecorator = jsonFactory._outputDecorator;
        this._rootValueSeparator = jsonFactory._rootValueSeparator;
    }

    public JsonGenerator createGenerator(File file, JsonEncoding jsonEncoding) throws IOException {
        OutputStream fileOutputStream = new FileOutputStream(file);
        com.fasterxml.jackson.core.io.c _createContext = _createContext(fileOutputStream, true);
        _createContext.a(jsonEncoding);
        if (jsonEncoding == JsonEncoding.UTF8) {
            return _createUTF8Generator(_decorate(fileOutputStream, _createContext), _createContext);
        }
        return _createGenerator(_decorate(_createWriter(fileOutputStream, jsonEncoding, _createContext), _createContext), _createContext);
    }

    public JsonParser createParser(byte[] bArr) throws IOException, JsonParseException {
        InputStream decorate;
        com.fasterxml.jackson.core.io.c _createContext = _createContext(bArr, true);
        InputDecorator inputDecorator = this._inputDecorator;
        if (inputDecorator != null && (decorate = inputDecorator.decorate(_createContext, bArr, 0, bArr.length)) != null) {
            return _createParser(decorate, _createContext);
        }
        return _createParser(bArr, 0, bArr.length, _createContext);
    }

    public JsonParser createParser(byte[] bArr, int i, int i2) throws IOException, JsonParseException {
        InputStream decorate;
        com.fasterxml.jackson.core.io.c _createContext = _createContext(bArr, true);
        InputDecorator inputDecorator = this._inputDecorator;
        if (inputDecorator != null && (decorate = inputDecorator.decorate(_createContext, bArr, i, i2)) != null) {
            return _createParser(decorate, _createContext);
        }
        return _createParser(bArr, i, i2, _createContext);
    }

    public JsonGenerator createGenerator(DataOutput dataOutput, JsonEncoding jsonEncoding) throws IOException {
        return createGenerator(_createDataOutputWrapper(dataOutput), jsonEncoding);
    }

    public JsonGenerator createGenerator(DataOutput dataOutput) throws IOException {
        return createGenerator(_createDataOutputWrapper(dataOutput), JsonEncoding.UTF8);
    }

    public JsonParser createParser(String str) throws IOException, JsonParseException {
        int length = str.length();
        if (this._inputDecorator == null && length <= 32768 && canUseCharArrays()) {
            com.fasterxml.jackson.core.io.c _createContext = _createContext(str, true);
            char[] a2 = _createContext.a(length);
            str.getChars(0, length, a2, 0);
            return _createParser(a2, 0, length, _createContext, true);
        }
        return createParser(new StringReader(str));
    }

    public JsonParser createParser(char[] cArr) throws IOException {
        return createParser(cArr, 0, cArr.length);
    }

    public JsonParser createParser(char[] cArr, int i, int i2) throws IOException {
        if (this._inputDecorator != null) {
            return createParser(new CharArrayReader(cArr, i, i2));
        }
        return _createParser(cArr, i, i2, _createContext(cArr, true), false);
    }

    public JsonParser createParser(DataInput dataInput) throws IOException {
        com.fasterxml.jackson.core.io.c _createContext = _createContext(dataInput, false);
        return _createParser(_decorate(dataInput, _createContext), _createContext);
    }
}
