package com.google.api.client.util;

import java.util.regex.Pattern;

@Beta
/* loaded from: classes.dex */
public final class PemReader {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f2546a = Pattern.compile("-----BEGIN ([A-Z ]+)-----");
    private static final Pattern b = Pattern.compile("-----END ([A-Z ]+)-----");

    /* loaded from: classes.dex */
    public static final class Section {
    }
}
