package com.google.api.client.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public class IOUtils {
    public static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        a(inputStream, outputStream, true);
    }

    public static void a(InputStream inputStream, OutputStream outputStream, boolean z) throws IOException {
        try {
            ByteStreams.a(inputStream, outputStream);
        } finally {
            if (z) {
                inputStream.close();
            }
        }
    }

    public static long a(StreamingContent streamingContent) throws IOException {
        c cVar = new c();
        try {
            streamingContent.writeTo(cVar);
            cVar.close();
            return cVar.f14982a;
        } catch (Throwable th) {
            cVar.close();
            throw th;
        }
    }

    public static byte[] a(Object obj) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(obj, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static void a(Object obj, OutputStream outputStream) throws IOException {
        try {
            new ObjectOutputStream(outputStream).writeObject(obj);
        } finally {
            outputStream.close();
        }
    }

    public static <S extends Serializable> S a(byte[] bArr) throws IOException {
        if (bArr == null) {
            return null;
        }
        return (S) a((InputStream) new ByteArrayInputStream(bArr));
    }

    public static <S extends Serializable> S a(InputStream inputStream) throws IOException {
        try {
            try {
                return (S) new ObjectInputStream(inputStream).readObject();
            } catch (ClassNotFoundException e2) {
                IOException iOException = new IOException("Failed to deserialize object");
                iOException.initCause(e2);
                throw iOException;
            }
        } finally {
            inputStream.close();
        }
    }

    public static boolean a(File file) throws IOException {
        try {
            try {
                return ((Boolean) Class.forName("java.nio.file.Files").getMethod("isSymbolicLink", Class.forName("java.nio.file.Path")).invoke(null, File.class.getMethod("toPath", new Class[0]).invoke(file, new Object[0]))).booleanValue();
            } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException unused) {
                if (File.separatorChar == '\\') {
                    return false;
                }
                if (file.getParent() != null) {
                    file = new File(file.getParentFile().getCanonicalFile(), file.getName());
                }
                return !file.getCanonicalFile().equals(file.getAbsoluteFile());
            }
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            Throwables.a(cause, IOException.class);
            throw new RuntimeException(cause);
        }
    }
}
