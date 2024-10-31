package com.google.api.client.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/* loaded from: classes.dex */
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
            streamingContent.a(cVar);
            cVar.close();
            return cVar.f2549a;
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
            } catch (ClassNotFoundException e) {
                IOException iOException = new IOException("Failed to deserialize object");
                iOException.initCause(e);
                throw iOException;
            }
        } finally {
            inputStream.close();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.io.File r8) throws java.io.IOException {
        /*
            r1 = 1
            r2 = 0
            java.lang.String r0 = "java.nio.file.Files"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.reflect.InvocationTargetException -> L3e java.lang.NoSuchMethodException -> L4e java.lang.IllegalAccessException -> L80 java.lang.SecurityException -> L82 java.lang.IllegalArgumentException -> L84 java.lang.ClassNotFoundException -> L86
            java.lang.String r3 = "java.nio.file.Path"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.reflect.InvocationTargetException -> L3e java.lang.NoSuchMethodException -> L4e java.lang.IllegalAccessException -> L80 java.lang.SecurityException -> L82 java.lang.IllegalArgumentException -> L84 java.lang.ClassNotFoundException -> L86
            java.lang.Class<java.io.File> r4 = java.io.File.class
            java.lang.String r5 = "toPath"
            r6 = 0
            java.lang.Class[] r6 = new java.lang.Class[r6]     // Catch: java.lang.reflect.InvocationTargetException -> L3e java.lang.NoSuchMethodException -> L4e java.lang.IllegalAccessException -> L80 java.lang.SecurityException -> L82 java.lang.IllegalArgumentException -> L84 java.lang.ClassNotFoundException -> L86
            java.lang.reflect.Method r4 = r4.getMethod(r5, r6)     // Catch: java.lang.reflect.InvocationTargetException -> L3e java.lang.NoSuchMethodException -> L4e java.lang.IllegalAccessException -> L80 java.lang.SecurityException -> L82 java.lang.IllegalArgumentException -> L84 java.lang.ClassNotFoundException -> L86
            r5 = 0
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.reflect.InvocationTargetException -> L3e java.lang.NoSuchMethodException -> L4e java.lang.IllegalAccessException -> L80 java.lang.SecurityException -> L82 java.lang.IllegalArgumentException -> L84 java.lang.ClassNotFoundException -> L86
            java.lang.Object r4 = r4.invoke(r8, r5)     // Catch: java.lang.reflect.InvocationTargetException -> L3e java.lang.NoSuchMethodException -> L4e java.lang.IllegalAccessException -> L80 java.lang.SecurityException -> L82 java.lang.IllegalArgumentException -> L84 java.lang.ClassNotFoundException -> L86
            java.lang.String r5 = "isSymbolicLink"
            r6 = 1
            java.lang.Class[] r6 = new java.lang.Class[r6]     // Catch: java.lang.reflect.InvocationTargetException -> L3e java.lang.NoSuchMethodException -> L4e java.lang.IllegalAccessException -> L80 java.lang.SecurityException -> L82 java.lang.IllegalArgumentException -> L84 java.lang.ClassNotFoundException -> L86
            r7 = 0
            r6[r7] = r3     // Catch: java.lang.reflect.InvocationTargetException -> L3e java.lang.NoSuchMethodException -> L4e java.lang.IllegalAccessException -> L80 java.lang.SecurityException -> L82 java.lang.IllegalArgumentException -> L84 java.lang.ClassNotFoundException -> L86
            java.lang.reflect.Method r0 = r0.getMethod(r5, r6)     // Catch: java.lang.reflect.InvocationTargetException -> L3e java.lang.NoSuchMethodException -> L4e java.lang.IllegalAccessException -> L80 java.lang.SecurityException -> L82 java.lang.IllegalArgumentException -> L84 java.lang.ClassNotFoundException -> L86
            r3 = 0
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.reflect.InvocationTargetException -> L3e java.lang.NoSuchMethodException -> L4e java.lang.IllegalAccessException -> L80 java.lang.SecurityException -> L82 java.lang.IllegalArgumentException -> L84 java.lang.ClassNotFoundException -> L86
            r6 = 0
            r5[r6] = r4     // Catch: java.lang.reflect.InvocationTargetException -> L3e java.lang.NoSuchMethodException -> L4e java.lang.IllegalAccessException -> L80 java.lang.SecurityException -> L82 java.lang.IllegalArgumentException -> L84 java.lang.ClassNotFoundException -> L86
            java.lang.Object r0 = r0.invoke(r3, r5)     // Catch: java.lang.reflect.InvocationTargetException -> L3e java.lang.NoSuchMethodException -> L4e java.lang.IllegalAccessException -> L80 java.lang.SecurityException -> L82 java.lang.IllegalArgumentException -> L84 java.lang.ClassNotFoundException -> L86
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.reflect.InvocationTargetException -> L3e java.lang.NoSuchMethodException -> L4e java.lang.IllegalAccessException -> L80 java.lang.SecurityException -> L82 java.lang.IllegalArgumentException -> L84 java.lang.ClassNotFoundException -> L86
            boolean r2 = r0.booleanValue()     // Catch: java.lang.reflect.InvocationTargetException -> L3e java.lang.NoSuchMethodException -> L4e java.lang.IllegalAccessException -> L80 java.lang.SecurityException -> L82 java.lang.IllegalArgumentException -> L84 java.lang.ClassNotFoundException -> L86
        L3d:
            return r2
        L3e:
            r0 = move-exception
            java.lang.Throwable r0 = r0.getCause()
            java.lang.Class<java.io.IOException> r1 = java.io.IOException.class
            com.google.api.client.util.Throwables.a(r0, r1)
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            r1.<init>(r0)
            throw r1
        L4e:
            r0 = move-exception
        L4f:
            char r0 = java.io.File.separatorChar
            r3 = 92
            if (r0 == r3) goto L3d
            java.lang.String r0 = r8.getParent()
            if (r0 == 0) goto L6d
            java.io.File r0 = new java.io.File
            java.io.File r3 = r8.getParentFile()
            java.io.File r3 = r3.getCanonicalFile()
            java.lang.String r4 = r8.getName()
            r0.<init>(r3, r4)
            r8 = r0
        L6d:
            java.io.File r0 = r8.getCanonicalFile()
            java.io.File r3 = r8.getAbsoluteFile()
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L7e
            r0 = r1
        L7c:
            r2 = r0
            goto L3d
        L7e:
            r0 = r2
            goto L7c
        L80:
            r0 = move-exception
            goto L4f
        L82:
            r0 = move-exception
            goto L4f
        L84:
            r0 = move-exception
            goto L4f
        L86:
            r0 = move-exception
            goto L4f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.client.util.IOUtils.a(java.io.File):boolean");
    }
}
