package com.google.protobuf;

import com.google.protobuf.MessageLite;
import java.io.InputStream;

/* loaded from: classes2.dex */
public abstract class AbstractParser<MessageType extends MessageLite> implements Parser<MessageType> {

    /* renamed from: a, reason: collision with root package name */
    private static final ExtensionRegistryLite f18371a = ExtensionRegistryLite.a();

    private UninitializedMessageException b(MessageType messagetype) {
        if (messagetype instanceof AbstractMessageLite) {
            return ((AbstractMessageLite) messagetype).g();
        }
        return new UninitializedMessageException(messagetype);
    }

    private MessageType a(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        throw b(messagetype).asInvalidProtocolBufferException().setUnfinishedMessage(messagetype);
    }

    public MessageType b(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        try {
            CodedInputStream newCodedInput = byteString.newCodedInput();
            MessageType messagetype = (MessageType) b(newCodedInput, extensionRegistryLite);
            try {
                newCodedInput.a(0);
                return messagetype;
            } catch (InvalidProtocolBufferException e2) {
                throw e2.setUnfinishedMessage(messagetype);
            }
        } catch (InvalidProtocolBufferException e3) {
            throw e3;
        }
    }

    @Override // com.google.protobuf.Parser
    public MessageType a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        MessageType messagetype = (MessageType) b(codedInputStream, extensionRegistryLite);
        a((AbstractParser<MessageType>) messagetype);
        return messagetype;
    }

    public MessageType b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        CodedInputStream a2 = CodedInputStream.a(inputStream);
        MessageType messagetype = (MessageType) b(a2, extensionRegistryLite);
        try {
            a2.a(0);
            return messagetype;
        } catch (InvalidProtocolBufferException e2) {
            throw e2.setUnfinishedMessage(messagetype);
        }
    }

    @Override // com.google.protobuf.Parser
    public MessageType a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        MessageType b2 = b(byteString, extensionRegistryLite);
        a((AbstractParser<MessageType>) b2);
        return b2;
    }

    public MessageType a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        MessageType b2 = b(inputStream, extensionRegistryLite);
        a((AbstractParser<MessageType>) b2);
        return b2;
    }

    @Override // com.google.protobuf.Parser
    public MessageType a(InputStream inputStream) throws InvalidProtocolBufferException {
        return a(inputStream, f18371a);
    }
}
