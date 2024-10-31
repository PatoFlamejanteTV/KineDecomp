package com.google.api.client.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public interface ObjectParser {
    <T> T a(InputStream inputStream, Charset charset, Class<T> cls) throws IOException;
}
