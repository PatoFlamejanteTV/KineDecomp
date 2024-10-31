package com.google.api.client.http;

import com.google.api.client.util.Charsets;
import com.google.api.client.util.Data;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Throwables;
import com.google.api.client.util.Types;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.List;

/* loaded from: classes.dex */
public class UrlEncodedParser implements ObjectParser {

    /* renamed from: a */
    public static final String f2476a = new HttpMediaType("application/x-www-form-urlencoded").a(Charsets.f2530a).c();

    public static void a(String str, Object obj) {
        if (str != null) {
            try {
                a(new StringReader(str), obj);
            } catch (IOException e) {
                throw Throwables.a(e);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004e, code lost:            r6 = com.google.api.client.util.escape.CharEscapers.b(r6.toString());     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x005a, code lost:            if (r6.length() == 0) goto L81;     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x005c, code lost:            r12 = com.google.api.client.util.escape.CharEscapers.b(r5.toString());        r5 = r8.a(r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0068, code lost:            if (r5 == null) goto L96;     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006a, code lost:            r6 = com.google.api.client.util.Data.a((java.util.List<java.lang.reflect.Type>) r9, r5.d());     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0076, code lost:            if (com.google.api.client.util.Types.a(r6) == false) goto L85;     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0078, code lost:            r0 = com.google.api.client.util.Types.a((java.util.List<java.lang.reflect.Type>) r9, com.google.api.client.util.Types.b(r6));        r10.a(r5.a(), r0, a(r0, (java.util.List<java.lang.reflect.Type>) r9, r12));     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00a6, code lost:            if (com.google.api.client.util.Types.a(com.google.api.client.util.Types.a((java.util.List<java.lang.reflect.Type>) r9, r6), (java.lang.Class<?>) java.lang.Iterable.class) == false) goto L95;     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a8, code lost:            r0 = (java.util.Collection) r5.a(r15);     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00ae, code lost:            if (r0 != null) goto L90;     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b0, code lost:            r0 = com.google.api.client.util.Data.b(r6);        r5.a(r15, r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b9, code lost:            if (r6 != java.lang.Object.class) goto L94;     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00bb, code lost:            r5 = null;     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00bc, code lost:            r0.add(a(r5, (java.util.List<java.lang.reflect.Type>) r9, r12));     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00c4, code lost:            r5 = com.google.api.client.util.Types.c(r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c9, code lost:            r5.a(r15, a(r6, (java.util.List<java.lang.reflect.Type>) r9, r12));     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00d1, code lost:            if (r3 == null) goto L81;     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d3, code lost:            r0 = (java.util.ArrayList) r3.get(r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d9, code lost:            if (r0 != null) goto L102;     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00db, code lost:            r0 = new java.util.ArrayList();     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00e0, code lost:            if (r1 == null) goto L103;     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00e2, code lost:            r1.set(r6, r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e9, code lost:            r3.put(r6, r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e5, code lost:            r0.add(r12);     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008b, code lost:            r6 = new java.io.StringWriter();        r5 = new java.io.StringWriter();     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0096, code lost:            if (r11 != (-1)) goto L106;     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00f5, code lost:            r0 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0098, code lost:            r10.a();     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009b, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.io.Reader r14, java.lang.Object r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.client.http.UrlEncodedParser.a(java.io.Reader, java.lang.Object):void");
    }

    private static Object a(Type type, List<Type> list, String str) {
        return Data.a(Data.a(list, type), str);
    }

    @Override // com.google.api.client.util.ObjectParser
    public <T> T a(InputStream inputStream, Charset charset, Class<T> cls) throws IOException {
        return (T) a((Reader) new InputStreamReader(inputStream, charset), (Class) cls);
    }

    public <T> T a(Reader reader, Class<T> cls) throws IOException {
        return (T) a(reader, (Type) cls);
    }

    public Object a(Reader reader, Type type) throws IOException {
        Preconditions.a(type instanceof Class, "dataType has to be of type Class<?>");
        Object a2 = Types.a((Class<Object>) type);
        a(new BufferedReader(reader), a2);
        return a2;
    }
}
