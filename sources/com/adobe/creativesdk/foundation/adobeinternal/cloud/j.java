package com.adobe.creativesdk.foundation.adobeinternal.cloud;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

/* compiled from: DecompressibleInputStream.java */
/* loaded from: classes.dex */
public class j extends ObjectInputStream {
    public j(InputStream inputStream) throws IOException {
        super(inputStream);
    }

    @Override // java.io.ObjectInputStream
    protected ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
        ObjectStreamClass readClassDescriptor = super.readClassDescriptor();
        try {
            ObjectStreamClass lookup = ObjectStreamClass.lookup(Class.forName(readClassDescriptor.getName()));
            if (lookup == null) {
                return readClassDescriptor;
            }
            long serialVersionUID = lookup.getSerialVersionUID();
            long serialVersionUID2 = readClassDescriptor.getSerialVersionUID();
            if (serialVersionUID2 == serialVersionUID) {
                return readClassDescriptor;
            }
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, j.class.getSimpleName(), "Overriding serialized class version mismatch: local serialVersionUID = " + serialVersionUID + " stream serialVersionUID = " + serialVersionUID2);
            return lookup;
        } catch (ClassNotFoundException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, j.class.getSimpleName(), "No local class for " + readClassDescriptor.getName(), e2);
            return readClassDescriptor;
        }
    }
}
