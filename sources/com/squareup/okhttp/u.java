package com.squareup.okhttp;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/* compiled from: Dns.java */
/* loaded from: classes3.dex */
public interface u {

    /* renamed from: a */
    public static final u f25535a = new t();

    List<InetAddress> lookup(String str) throws UnknownHostException;
}
