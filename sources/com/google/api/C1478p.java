package com.google.api;

import com.google.api.Distribution;
import com.google.protobuf.GeneratedMessageLite;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
/* renamed from: com.google.api.p, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
/* synthetic */ class C1478p {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f15032a;

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ int[] f15033b = new int[Distribution.BucketOptions.OptionsCase.values().length];

    static {
        try {
            f15033b[Distribution.BucketOptions.OptionsCase.LINEAR_BUCKETS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f15033b[Distribution.BucketOptions.OptionsCase.EXPONENTIAL_BUCKETS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f15033b[Distribution.BucketOptions.OptionsCase.EXPLICIT_BUCKETS.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f15033b[Distribution.BucketOptions.OptionsCase.OPTIONS_NOT_SET.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        f15032a = new int[GeneratedMessageLite.MethodToInvoke.values().length];
        try {
            f15032a[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f15032a[GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f15032a[GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE.ordinal()] = 3;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f15032a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 4;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f15032a[GeneratedMessageLite.MethodToInvoke.VISIT.ordinal()] = 5;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f15032a[GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM.ordinal()] = 6;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f15032a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 7;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f15032a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 8;
        } catch (NoSuchFieldError unused12) {
        }
    }
}
