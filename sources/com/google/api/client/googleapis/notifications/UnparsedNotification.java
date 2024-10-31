package com.google.api.client.googleapis.notifications;

import com.google.api.client.util.Beta;
import java.io.InputStream;

@Beta
/* loaded from: classes2.dex */
public class UnparsedNotification extends AbstractNotification {
    private String i;
    private InputStream j;

    public final InputStream j() {
        return this.j;
    }

    public final String k() {
        return this.i;
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public String toString() {
        return super.i().a("contentType", this.i).toString();
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public UnparsedNotification b(String str) {
        super.b(str);
        return this;
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public UnparsedNotification c(String str) {
        super.c(str);
        return this;
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public UnparsedNotification d(String str) {
        super.d(str);
        return this;
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public UnparsedNotification e(String str) {
        super.e(str);
        return this;
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public UnparsedNotification f(String str) {
        super.f(str);
        return this;
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public UnparsedNotification g(String str) {
        super.g(str);
        return this;
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public UnparsedNotification a(long j) {
        super.a(j);
        return this;
    }

    @Override // com.google.api.client.googleapis.notifications.AbstractNotification
    public UnparsedNotification a(String str) {
        super.a(str);
        return this;
    }
}
