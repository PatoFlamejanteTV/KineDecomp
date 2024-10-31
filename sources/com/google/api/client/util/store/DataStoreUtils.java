package com.google.api.client.util.store;

import java.io.IOException;

/* loaded from: classes.dex */
public final class DataStoreUtils {
    public static String a(DataStore<?> dataStore) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append('{');
            boolean z = true;
            for (String str : dataStore.a()) {
                if (z) {
                    z = false;
                } else {
                    sb.append(", ");
                }
                sb.append(str).append('=').append(dataStore.a(str));
            }
            return sb.append('}').toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private DataStoreUtils() {
    }
}
