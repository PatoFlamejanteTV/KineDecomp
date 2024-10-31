package com.adobe.xmp;

/* compiled from: XMPMeta.java */
/* loaded from: classes.dex */
public interface f extends Cloneable {
    com.adobe.xmp.c.b a(String str, String str2, String str3, String str4) throws XMPException;

    e a(String str, String str2, com.adobe.xmp.b.b bVar) throws XMPException;

    void a(String str, String str2);

    void a(String str, String str2, int i, String str3, com.adobe.xmp.b.e eVar) throws XMPException;

    void a(String str, String str2, com.adobe.xmp.b.e eVar, String str3, com.adobe.xmp.b.e eVar2) throws XMPException;

    void a(String str, String str2, Object obj) throws XMPException;

    void a(String str, String str2, Object obj, com.adobe.xmp.b.e eVar) throws XMPException;

    void a(String str, String str2, String str3, String str4, String str5) throws XMPException;

    void a(String str, String str2, String str3, String str4, String str5, com.adobe.xmp.b.e eVar) throws XMPException;

    com.adobe.xmp.c.b b(String str, String str2) throws XMPException;

    String c(String str, String str2) throws XMPException;

    Object clone();

    boolean d(String str, String str2);

    e iterator() throws XMPException;
}
