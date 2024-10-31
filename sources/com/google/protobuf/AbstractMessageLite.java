package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractMessageLite.Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class AbstractMessageLite<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite {

    /* renamed from: a */
    protected int f18370a = 0;

    /* loaded from: classes2.dex */
    public static abstract class Builder<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite.Builder {
        protected abstract BuilderType a(MessageType messagetype);

        @Override // com.google.protobuf.MessageLite.Builder
        public abstract BuilderType a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;

        @Override // 
        /* renamed from: clone */
        public abstract BuilderType mo17clone();

        @Override // com.google.protobuf.MessageLite.Builder
        public BuilderType b(byte[] bArr) throws InvalidProtocolBufferException {
            return a(bArr, 0, bArr.length);
        }

        public static UninitializedMessageException b(MessageLite messageLite) {
            return new UninitializedMessageException(messageLite);
        }

        public BuilderType a(CodedInputStream codedInputStream) throws IOException {
            return a(codedInputStream, ExtensionRegistryLite.a());
        }

        public BuilderType a(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            try {
                CodedInputStream a2 = CodedInputStream.a(bArr, i, i2);
                a(a2);
                a2.a(0);
                return this;
            } catch (InvalidProtocolBufferException e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException(a("byte array"), e3);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.MessageLite.Builder
        public BuilderType a(MessageLite messageLite) {
            if (a().getClass().isInstance(messageLite)) {
                return (BuilderType) a((Builder<MessageType, BuilderType>) messageLite);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }

        private String a(String str) {
            return "Reading " + getClass().getName() + " from a " + str + " threw an IOException (should never happen).";
        }

        protected static <T> void a(Iterable<T> iterable, Collection<? super T> collection) {
            if (iterable != null) {
                if (iterable instanceof LazyStringList) {
                    a(((LazyStringList) iterable).N());
                    collection.addAll((Collection) iterable);
                    return;
                } else {
                    if (iterable instanceof Collection) {
                        a((Iterable<?>) iterable);
                        collection.addAll((Collection) iterable);
                        return;
                    }
                    for (T t : iterable) {
                        if (t != null) {
                            collection.add(t);
                        } else {
                            throw new NullPointerException();
                        }
                    }
                    return;
                }
            }
            throw new NullPointerException();
        }

        private static void a(Iterable<?> iterable) {
            Iterator<?> it = iterable.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new NullPointerException();
                }
            }
        }
    }

    private String a(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    @Override // com.google.protobuf.MessageLite
    public ByteString c() {
        try {
            ByteString.c newCodedBuilder = ByteString.newCodedBuilder(d());
            a(newCodedBuilder.b());
            return newCodedBuilder.a();
        } catch (IOException e2) {
            throw new RuntimeException(a("ByteString"), e2);
        }
    }

    public UninitializedMessageException g() {
        return new UninitializedMessageException(this);
    }

    @Override // com.google.protobuf.MessageLite
    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[d()];
            CodedOutputStream b2 = CodedOutputStream.b(bArr);
            a(b2);
            b2.c();
            return bArr;
        } catch (IOException e2) {
            throw new RuntimeException(a("byte array"), e2);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(OutputStream outputStream) throws IOException {
        CodedOutputStream a2 = CodedOutputStream.a(outputStream, CodedOutputStream.e(d()));
        a(a2);
        a2.d();
    }

    public static <T> void a(Iterable<T> iterable, Collection<? super T> collection) {
        Builder.a(iterable, collection);
    }
}
