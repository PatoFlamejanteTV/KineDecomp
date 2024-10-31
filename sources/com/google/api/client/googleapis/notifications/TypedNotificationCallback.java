package com.google.api.client.googleapis.notifications;

import com.google.api.client.http.HttpMediaType;
import com.google.api.client.util.Beta;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.nio.charset.Charset;

@Beta
/* loaded from: classes2.dex */
public abstract class TypedNotificationCallback<T> implements UnparsedNotificationCallback {
    private static final long serialVersionUID = 1;

    protected abstract Class<T> getDataClass() throws IOException;

    protected abstract ObjectParser getObjectParser() throws IOException;

    protected abstract void onNotification(StoredChannel storedChannel, TypedNotification<T> typedNotification) throws IOException;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.api.client.googleapis.notifications.UnparsedNotificationCallback
    public final void onNotification(StoredChannel storedChannel, UnparsedNotification unparsedNotification) throws IOException {
        TypedNotification typedNotification = new TypedNotification(unparsedNotification);
        String k = unparsedNotification.k();
        if (k != null) {
            Charset b2 = new HttpMediaType(k).b();
            Class<T> dataClass = getDataClass();
            Preconditions.a(dataClass);
            typedNotification.a((TypedNotification) getObjectParser().a(unparsedNotification.j(), b2, dataClass));
        }
        onNotification(storedChannel, typedNotification);
    }
}
