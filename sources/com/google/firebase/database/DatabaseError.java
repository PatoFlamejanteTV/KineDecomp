package com.google.firebase.database;

import com.google.firebase.annotations.PublicApi;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
@PublicApi
/* loaded from: classes2.dex */
public class DatabaseError {

    /* renamed from: a */
    private static final Map<Integer, String> f16630a = new HashMap();

    /* renamed from: b */
    private static final Map<String, Integer> f16631b;

    /* renamed from: c */
    private final int f16632c;

    /* renamed from: d */
    private final String f16633d;

    /* renamed from: e */
    private final String f16634e;

    static {
        f16630a.put(-1, "The transaction needs to be run again with current data");
        f16630a.put(-2, "The server indicated that this operation failed");
        f16630a.put(-3, "This client does not have permission to perform this operation");
        f16630a.put(-4, "The operation had to be aborted due to a network disconnect");
        f16630a.put(-6, "The supplied auth token has expired");
        f16630a.put(-7, "The supplied auth token was invalid");
        f16630a.put(-8, "The transaction had too many retries");
        f16630a.put(-9, "The transaction was overridden by a subsequent set");
        f16630a.put(-10, "The service is unavailable");
        f16630a.put(-11, "User code called from the Firebase Database runloop threw an exception:\n");
        f16630a.put(-24, "The operation could not be performed due to a network error");
        f16630a.put(-25, "The write was canceled by the user.");
        f16630a.put(-999, "An unknown error occurred");
        f16631b = new HashMap();
        f16631b.put("datastale", -1);
        f16631b.put("failure", -2);
        f16631b.put("permission_denied", -3);
        f16631b.put("disconnected", -4);
        f16631b.put("expired_token", -6);
        f16631b.put("invalid_token", -7);
        f16631b.put("maxretries", -8);
        f16631b.put("overriddenbyset", -9);
        f16631b.put("unavailable", -10);
        f16631b.put("network_error", -24);
        f16631b.put("write_canceled", -25);
    }

    private DatabaseError(int i, String str) {
        this(i, str, null);
    }

    public static DatabaseError a(String str) {
        return a(str, null);
    }

    @PublicApi
    public DatabaseException b() {
        return new DatabaseException("Firebase Database error: " + this.f16633d);
    }

    public String toString() {
        return "DatabaseError: " + this.f16633d;
    }

    private DatabaseError(int i, String str, String str2) {
        this.f16632c = i;
        this.f16633d = str;
        this.f16634e = str2 == null ? "" : str2;
    }

    public static DatabaseError a(String str, String str2) {
        return a(str, str2, null);
    }

    public static DatabaseError a(int i) {
        if (f16630a.containsKey(Integer.valueOf(i))) {
            return new DatabaseError(i, f16630a.get(Integer.valueOf(i)), null);
        }
        throw new IllegalArgumentException("Invalid Firebase Database error code: " + i);
    }

    public static DatabaseError a(String str, String str2, String str3) {
        Integer num = f16631b.get(str.toLowerCase());
        if (num == null) {
            num = -999;
        }
        if (str2 == null) {
            str2 = f16630a.get(num);
        }
        return new DatabaseError(num.intValue(), str2, str3);
    }

    @PublicApi
    public static DatabaseError a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return new DatabaseError(-11, f16630a.get(-11) + stringWriter.toString());
    }

    @PublicApi
    public int a() {
        return this.f16632c;
    }
}
