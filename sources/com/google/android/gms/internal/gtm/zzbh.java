package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: classes2.dex */
public final class zzbh extends zzan {
    private volatile String zzut;
    private Future<String> zzyh;

    public zzbh(zzap zzapVar) {
        super(zzapVar);
    }

    private final boolean zzb(Context context, String str) {
        Preconditions.b(str);
        Preconditions.c("ClientId should be saved from worker thread");
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    zza("Storing clientId", str);
                    fileOutputStream = context.openFileOutput("gaClientId", 0);
                    fileOutputStream.write(str.getBytes());
                    if (fileOutputStream == null) {
                        return true;
                    }
                    try {
                        fileOutputStream.close();
                        return true;
                    } catch (IOException e2) {
                        zze("Failed to close clientId writing stream", e2);
                        return true;
                    }
                } catch (IOException e3) {
                    zze("Error writing to clientId file", e3);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            zze("Failed to close clientId writing stream", e4);
                        }
                    }
                    return false;
                }
            } catch (FileNotFoundException e5) {
                zze("Error creating clientId file", e5);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e6) {
                        zze("Failed to close clientId writing stream", e6);
                    }
                }
                return false;
            }
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e7) {
                    zze("Failed to close clientId writing stream", e7);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String zzd(android.content.Context r9) {
        /*
            r8 = this;
            java.lang.String r0 = "gaClientId"
            java.lang.String r1 = "Failed to close client id reading stream"
            java.lang.String r2 = "ClientId should be loaded from worker thread"
            com.google.android.gms.common.internal.Preconditions.c(r2)
            r2 = 0
            java.io.FileInputStream r3 = r9.openFileInput(r0)     // Catch: java.lang.Throwable -> L67 java.io.IOException -> L6a java.io.FileNotFoundException -> L8b
            r4 = 36
            byte[] r5 = new byte[r4]     // Catch: java.io.IOException -> L65 java.lang.Throwable -> L7f java.io.FileNotFoundException -> L8c
            r6 = 0
            int r4 = r3.read(r5, r6, r4)     // Catch: java.io.IOException -> L65 java.lang.Throwable -> L7f java.io.FileNotFoundException -> L8c
            int r7 = r3.available()     // Catch: java.io.IOException -> L65 java.lang.Throwable -> L7f java.io.FileNotFoundException -> L8c
            if (r7 <= 0) goto L33
            java.lang.String r4 = "clientId file seems corrupted, deleting it."
            r8.zzt(r4)     // Catch: java.io.IOException -> L65 java.lang.Throwable -> L7f java.io.FileNotFoundException -> L8c
            r3.close()     // Catch: java.io.IOException -> L65 java.lang.Throwable -> L7f java.io.FileNotFoundException -> L8c
            r9.deleteFile(r0)     // Catch: java.io.IOException -> L65 java.lang.Throwable -> L7f java.io.FileNotFoundException -> L8c
            if (r3 == 0) goto L32
            r3.close()     // Catch: java.io.IOException -> L2e
            goto L32
        L2e:
            r9 = move-exception
            r8.zze(r1, r9)
        L32:
            return r2
        L33:
            r7 = 14
            if (r4 >= r7) goto L4d
            java.lang.String r4 = "clientId file is empty, deleting it."
            r8.zzt(r4)     // Catch: java.io.IOException -> L65 java.lang.Throwable -> L7f java.io.FileNotFoundException -> L8c
            r3.close()     // Catch: java.io.IOException -> L65 java.lang.Throwable -> L7f java.io.FileNotFoundException -> L8c
            r9.deleteFile(r0)     // Catch: java.io.IOException -> L65 java.lang.Throwable -> L7f java.io.FileNotFoundException -> L8c
            if (r3 == 0) goto L4c
            r3.close()     // Catch: java.io.IOException -> L48
            goto L4c
        L48:
            r9 = move-exception
            r8.zze(r1, r9)
        L4c:
            return r2
        L4d:
            r3.close()     // Catch: java.io.IOException -> L65 java.lang.Throwable -> L7f java.io.FileNotFoundException -> L8c
            java.lang.String r7 = new java.lang.String     // Catch: java.io.IOException -> L65 java.lang.Throwable -> L7f java.io.FileNotFoundException -> L8c
            r7.<init>(r5, r6, r4)     // Catch: java.io.IOException -> L65 java.lang.Throwable -> L7f java.io.FileNotFoundException -> L8c
            java.lang.String r4 = "Read client id from disk"
            r8.zza(r4, r7)     // Catch: java.io.IOException -> L65 java.lang.Throwable -> L7f java.io.FileNotFoundException -> L8c
            if (r3 == 0) goto L64
            r3.close()     // Catch: java.io.IOException -> L60
            goto L64
        L60:
            r9 = move-exception
            r8.zze(r1, r9)
        L64:
            return r7
        L65:
            r4 = move-exception
            goto L6c
        L67:
            r9 = move-exception
            r3 = r2
            goto L80
        L6a:
            r4 = move-exception
            r3 = r2
        L6c:
            java.lang.String r5 = "Error reading client id file, deleting it"
            r8.zze(r5, r4)     // Catch: java.lang.Throwable -> L7f
            r9.deleteFile(r0)     // Catch: java.lang.Throwable -> L7f
            if (r3 == 0) goto L7e
            r3.close()     // Catch: java.io.IOException -> L7a
            goto L7e
        L7a:
            r9 = move-exception
            r8.zze(r1, r9)
        L7e:
            return r2
        L7f:
            r9 = move-exception
        L80:
            if (r3 == 0) goto L8a
            r3.close()     // Catch: java.io.IOException -> L86
            goto L8a
        L86:
            r0 = move-exception
            r8.zze(r1, r0)
        L8a:
            throw r9
        L8b:
            r3 = r2
        L8c:
            if (r3 == 0) goto L96
            r3.close()     // Catch: java.io.IOException -> L92
            goto L96
        L92:
            r9 = move-exception
            r8.zze(r1, r9)
        L96:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzbh.zzd(android.content.Context):java.lang.String");
    }

    @VisibleForTesting
    public final String zzek() {
        String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.US);
        try {
            return !zzb(zzcq().a(), lowerCase) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : lowerCase;
        } catch (Exception e2) {
            zze("Error saving clientId file", e2);
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    protected final void zzaw() {
    }

    public final String zzeh() {
        String str;
        zzdb();
        synchronized (this) {
            if (this.zzut == null) {
                this.zzyh = zzcq().a(new CallableC1329s(this));
            }
            if (this.zzyh != null) {
                try {
                    try {
                        this.zzut = this.zzyh.get();
                    } catch (InterruptedException e2) {
                        zzd("ClientId loading or generation was interrupted", e2);
                        this.zzut = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    }
                } catch (ExecutionException e3) {
                    zze("Failed to load or generate client id", e3);
                    this.zzut = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                }
                if (this.zzut == null) {
                    this.zzut = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                }
                zza("Loaded clientId", this.zzut);
                this.zzyh = null;
            }
            str = this.zzut;
        }
        return str;
    }

    public final String zzei() {
        synchronized (this) {
            this.zzut = null;
            this.zzyh = zzcq().a(new CallableC1331t(this));
        }
        return zzeh();
    }

    @VisibleForTesting
    public final String zzej() {
        String zzd = zzd(zzcq().a());
        return zzd == null ? zzek() : zzd;
    }
}
