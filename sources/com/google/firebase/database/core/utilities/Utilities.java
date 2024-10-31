package com.google.firebase.database.core.utilities;

import android.util.Base64;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.RepoInfo;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class Utilities {

    /* renamed from: a */
    private static final char[] f17072a = "0123456789abcdef".toCharArray();

    public static int a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static int a(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    public static ParsedUrl a(String str) throws DatabaseException {
        try {
            int indexOf = str.indexOf("//");
            if (indexOf != -1) {
                int i = indexOf + 2;
                int indexOf2 = str.substring(i).indexOf("/");
                if (indexOf2 != -1) {
                    int i2 = indexOf2 + i;
                    String[] split = str.substring(i2).split("/", -1);
                    StringBuilder sb = new StringBuilder();
                    for (int i3 = 0; i3 < split.length; i3++) {
                        if (!split[i3].equals("")) {
                            sb.append("/");
                            sb.append(URLEncoder.encode(split[i3], "UTF-8"));
                        }
                    }
                    str = str.substring(0, i2) + sb.toString();
                }
                URI uri = new URI(str);
                String replace = uri.getPath().replace("+", " ");
                Validation.b(replace);
                Path path = new Path(replace);
                String scheme = uri.getScheme();
                RepoInfo repoInfo = new RepoInfo();
                repoInfo.f16919a = uri.getHost().toLowerCase();
                int port = uri.getPort();
                if (port != -1) {
                    repoInfo.f16920b = scheme.equals("https");
                    repoInfo.f16919a += ":" + port;
                } else {
                    repoInfo.f16920b = true;
                }
                repoInfo.f16921c = repoInfo.f16919a.split("\\.", -1)[0].toLowerCase();
                repoInfo.f16922d = repoInfo.f16919a;
                ParsedUrl parsedUrl = new ParsedUrl();
                parsedUrl.f17062b = path;
                parsedUrl.f17061a = repoInfo;
                return parsedUrl;
            }
            throw new URISyntaxException(str, "Invalid scheme specified");
        } catch (UnsupportedEncodingException e2) {
            throw new DatabaseException("Failed to URLEncode the path", e2);
        } catch (URISyntaxException e3) {
            throw new DatabaseException("Invalid Firebase Database url specified", e3);
        }
    }

    public static String b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes("UTF-8"));
            return Base64.encodeToString(messageDigest.digest(), 2);
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 encoding is required for Firebase Database to run!");
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException("Missing SHA-1 MessageDigest provider.", e2);
        }
    }

    public static String c(String str) {
        String replace = str.indexOf(92) != -1 ? str.replace("\\", "\\\\") : str;
        if (str.indexOf(34) != -1) {
            replace = replace.replace("\"", "\\\"");
        }
        return '\"' + replace + '\"';
    }

    public static Integer d(String str) {
        if (str.length() > 11 || str.length() == 0) {
            return null;
        }
        int i = 0;
        boolean z = true;
        if (str.charAt(0) != '-') {
            z = false;
        } else {
            if (str.length() == 1) {
                return null;
            }
            i = 1;
        }
        long j = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return null;
            }
            j = (j * 10) + (charAt - '0');
            i++;
        }
        if (!z) {
            if (j > 2147483647L) {
                return null;
            }
            return Integer.valueOf((int) j);
        }
        long j2 = -j;
        if (j2 < -2147483648L) {
            return null;
        }
        return Integer.valueOf((int) j2);
    }

    public static String a(double d2) {
        StringBuilder sb = new StringBuilder(16);
        long doubleToLongBits = Double.doubleToLongBits(d2);
        for (int i = 7; i >= 0; i--) {
            int i2 = (int) ((doubleToLongBits >>> (i * 8)) & 255);
            sb.append(f17072a[(i2 >> 4) & 15]);
            sb.append(f17072a[i2 & 15]);
        }
        return sb.toString();
    }

    public static void a(boolean z) {
        a(z, "");
    }

    public static void a(boolean z, String str) {
        if (z) {
            return;
        }
        throw new AssertionError("hardAssert failed: " + str);
    }

    public static Pair<Task<Void>, DatabaseReference.CompletionListener> a(DatabaseReference.CompletionListener completionListener) {
        if (completionListener == null) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            return new Pair<>(taskCompletionSource.a(), new g(taskCompletionSource));
        }
        return new Pair<>(null, completionListener);
    }
}
