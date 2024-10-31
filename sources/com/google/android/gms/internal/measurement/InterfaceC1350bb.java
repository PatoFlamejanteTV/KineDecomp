package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.bb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
interface InterfaceC1350bb {
    int a() throws IOException;

    @Deprecated
    <T> T a(InterfaceC1353cb<T> interfaceC1353cb, zzub zzubVar) throws IOException;

    void a(List<Integer> list) throws IOException;

    @Deprecated
    <T> void a(List<T> list, InterfaceC1353cb<T> interfaceC1353cb, zzub zzubVar) throws IOException;

    <T> T b(InterfaceC1353cb<T> interfaceC1353cb, zzub zzubVar) throws IOException;

    String b() throws IOException;

    void b(List<Boolean> list) throws IOException;

    <T> void b(List<T> list, InterfaceC1353cb<T> interfaceC1353cb, zzub zzubVar) throws IOException;

    void c(List<zzte> list) throws IOException;

    boolean c() throws IOException;

    long d() throws IOException;

    void d(List<String> list) throws IOException;

    int e() throws IOException;

    void e(List<String> list) throws IOException;

    long f() throws IOException;

    void f(List<Float> list) throws IOException;

    int g() throws IOException;

    void g(List<Double> list) throws IOException;

    int getTag();

    void h(List<Integer> list) throws IOException;

    void i(List<Long> list) throws IOException;

    void j(List<Integer> list) throws IOException;

    void k(List<Integer> list) throws IOException;

    void l(List<Long> list) throws IOException;

    void m(List<Long> list) throws IOException;

    void n(List<Long> list) throws IOException;

    void o(List<Integer> list) throws IOException;

    void p(List<Long> list) throws IOException;

    void q(List<Integer> list) throws IOException;

    double readDouble() throws IOException;

    float readFloat() throws IOException;

    String readString() throws IOException;

    long zzul() throws IOException;

    zzte zzur() throws IOException;

    int zzut() throws IOException;

    int zzuu() throws IOException;

    long zzuv() throws IOException;

    int zzuw() throws IOException;

    long zzux() throws IOException;

    int zzvh() throws IOException;

    boolean zzvi() throws IOException;
}
