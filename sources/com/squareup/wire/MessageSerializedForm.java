package com.squareup.wire;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.StreamCorruptedException;

/* loaded from: classes.dex */
final class MessageSerializedForm implements Serializable {
    private static final long serialVersionUID = 0;
    private final byte[] bytes;
    private final Class<? extends Message> messageClass;

    public MessageSerializedForm(Message message, Class<? extends Message> cls) {
        this.bytes = message.toByteArray();
        this.messageClass = cls;
    }

    Object readResolve() throws ObjectStreamException {
        try {
            return new s((Class<?>[]) new Class[0]).a(this.bytes, this.messageClass);
        } catch (IOException e) {
            throw new StreamCorruptedException(e.getMessage());
        }
    }
}
