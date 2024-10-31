package com.google.protobuf;

import java.io.InputStream;

/* loaded from: classes2.dex */
public interface Parser<MessageType> {
    MessageType a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

    MessageType a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

    MessageType a(InputStream inputStream) throws InvalidProtocolBufferException;

    MessageType b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;
}
