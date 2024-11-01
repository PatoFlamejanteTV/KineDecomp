package com.fasterxml.jackson.core.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class InputDecorator implements Serializable {
    private static final long serialVersionUID = 1;

    public abstract InputStream decorate(c cVar, InputStream inputStream) throws IOException;

    public abstract InputStream decorate(c cVar, byte[] bArr, int i, int i2) throws IOException;

    public abstract Reader decorate(c cVar, Reader reader) throws IOException;
}
