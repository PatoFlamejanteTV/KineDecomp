package com.fasterxml.jackson.core.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;

/* loaded from: classes.dex */
public abstract class OutputDecorator implements Serializable {
    public abstract OutputStream decorate(c cVar, OutputStream outputStream) throws IOException;

    public abstract Writer decorate(c cVar, Writer writer) throws IOException;
}
