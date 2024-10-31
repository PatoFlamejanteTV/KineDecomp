package android.support.v4.provider;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes.dex */
class DocumentsContractApi19 {
    DocumentsContractApi19() {
    }

    private static String a(Context context, Uri uri) {
        return a(context, uri, "mime_type", (String) null);
    }

    public static boolean canRead(Context context, Uri uri) {
        return context.checkCallingOrSelfUriPermission(uri, 1) == 0 && !TextUtils.isEmpty(a(context, uri));
    }

    public static boolean canWrite(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 2) != 0) {
            return false;
        }
        String a2 = a(context, uri);
        int a3 = a(context, uri, "flags", 0);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        if ((a3 & 4) != 0) {
            return true;
        }
        if (!"vnd.android.document/directory".equals(a2) || (a3 & 8) == 0) {
            return (TextUtils.isEmpty(a2) || (a3 & 2) == 0) ? false : true;
        }
        return true;
    }

    public static boolean exists(Context context, Uri uri) {
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"document_id"}, null, null, null);
            return cursor.getCount() > 0;
        } catch (Exception e2) {
            Log.w("DocumentFile", "Failed query: " + e2);
            return false;
        } finally {
            a(cursor);
        }
    }

    public static long getFlags(Context context, Uri uri) {
        return a(context, uri, "flags", 0L);
    }

    public static String getName(Context context, Uri uri) {
        return a(context, uri, "_display_name", (String) null);
    }

    public static String getType(Context context, Uri uri) {
        String a2 = a(context, uri);
        if ("vnd.android.document/directory".equals(a2)) {
            return null;
        }
        return a2;
    }

    public static boolean isDirectory(Context context, Uri uri) {
        return "vnd.android.document/directory".equals(a(context, uri));
    }

    public static boolean isDocumentUri(Context context, Uri uri) {
        return DocumentsContract.isDocumentUri(context, uri);
    }

    public static boolean isFile(Context context, Uri uri) {
        String a2 = a(context, uri);
        return ("vnd.android.document/directory".equals(a2) || TextUtils.isEmpty(a2)) ? false : true;
    }

    public static boolean isVirtual(Context context, Uri uri) {
        return isDocumentUri(context, uri) && (getFlags(context, uri) & 512) != 0;
    }

    public static long lastModified(Context context, Uri uri) {
        return a(context, uri, "last_modified", 0L);
    }

    public static long length(Context context, Uri uri) {
        return a(context, uri, "_size", 0L);
    }

    private static String a(Context context, Uri uri, String str, String str2) {
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
            return (!cursor.moveToFirst() || cursor.isNull(0)) ? str2 : cursor.getString(0);
        } catch (Exception e2) {
            Log.w("DocumentFile", "Failed query: " + e2);
            return str2;
        } finally {
            a(cursor);
        }
    }

    private static int a(Context context, Uri uri, String str, int i) {
        return (int) a(context, uri, str, i);
    }

    private static long a(Context context, Uri uri, String str, long j) {
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
            return (!cursor.moveToFirst() || cursor.isNull(0)) ? j : cursor.getLong(0);
        } catch (Exception e2) {
            Log.w("DocumentFile", "Failed query: " + e2);
            return j;
        } finally {
            a(cursor);
        }
    }

    private static void a(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }
}
