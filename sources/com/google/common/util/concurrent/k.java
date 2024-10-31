package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Service;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractService.java */
/* loaded from: classes2.dex */
public /* synthetic */ class k {

    /* renamed from: a */
    static final /* synthetic */ int[] f16204a = new int[Service.State.values().length];

    static {
        try {
            f16204a[Service.State.NEW.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f16204a[Service.State.STARTING.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f16204a[Service.State.RUNNING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f16204a[Service.State.STOPPING.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f16204a[Service.State.TERMINATED.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f16204a[Service.State.FAILED.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
