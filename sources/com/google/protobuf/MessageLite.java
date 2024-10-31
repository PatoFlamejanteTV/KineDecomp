package com.google.protobuf;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public interface MessageLite extends MessageLiteOrBuilder {

    /* loaded from: classes2.dex */
    public interface Builder extends MessageLiteOrBuilder, Cloneable {
        MessageLite T();

        Builder a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;

        Builder a(MessageLite messageLite);

        Builder b(byte[] bArr) throws InvalidProtocolBufferException;

        MessageLite build();
    }

    void a(CodedOutputStream codedOutputStream) throws IOException;

    Builder b();

    ByteString c();

    int d();

    Builder e();

    Parser<? extends MessageLite> f();

    byte[] toByteArray();

    void writeTo(OutputStream outputStream) throws IOException;
}
