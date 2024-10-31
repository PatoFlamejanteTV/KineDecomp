package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzad extends zzan {
    private static boolean zzvo;
    private AdvertisingIdClient.Info zzvp;
    private final I zzvq;
    private String zzvr;
    private boolean zzvs;
    private final Object zzvt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzad(zzap zzapVar) {
        super(zzapVar);
        this.zzvs = false;
        this.zzvt = new Object();
        this.zzvq = new I(zzapVar.zzcn());
    }

    private final boolean zza(AdvertisingIdClient.Info info, AdvertisingIdClient.Info info2) {
        String str = null;
        String id = info2 == null ? null : info2.getId();
        if (TextUtils.isEmpty(id)) {
            return true;
        }
        String zzeh = zzcw().zzeh();
        synchronized (this.zzvt) {
            if (!this.zzvs) {
                this.zzvr = zzcg();
                this.zzvs = true;
            } else if (TextUtils.isEmpty(this.zzvr)) {
                if (info != null) {
                    str = info.getId();
                }
                if (str == null) {
                    String valueOf = String.valueOf(id);
                    String valueOf2 = String.valueOf(zzeh);
                    return zzp(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
                }
                String valueOf3 = String.valueOf(str);
                String valueOf4 = String.valueOf(zzeh);
                this.zzvr = zzo(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3));
            }
            String valueOf5 = String.valueOf(id);
            String valueOf6 = String.valueOf(zzeh);
            String zzo = zzo(valueOf6.length() != 0 ? valueOf5.concat(valueOf6) : new String(valueOf5));
            if (TextUtils.isEmpty(zzo)) {
                return false;
            }
            if (zzo.equals(this.zzvr)) {
                return true;
            }
            if (!TextUtils.isEmpty(this.zzvr)) {
                zzq("Resetting the client id because Advertising Id changed.");
                zzeh = zzcw().zzei();
                zza("New client Id", zzeh);
            }
            String valueOf7 = String.valueOf(id);
            String valueOf8 = String.valueOf(zzeh);
            return zzp(valueOf8.length() != 0 ? valueOf7.concat(valueOf8) : new String(valueOf7));
        }
    }

    private final synchronized AdvertisingIdClient.Info zzce() {
        if (this.zzvq.a(1000L)) {
            this.zzvq.b();
            AdvertisingIdClient.Info zzcf = zzcf();
            if (zza(this.zzvp, zzcf)) {
                this.zzvp = zzcf;
            } else {
                zzu("Failed to reset client id on adid change. Not using adid");
                this.zzvp = new AdvertisingIdClient.Info("", false);
            }
        }
        return this.zzvp;
    }

    private final AdvertisingIdClient.Info zzcf() {
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(getContext());
        } catch (IllegalStateException unused) {
            zzt("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
            return null;
        } catch (Exception e2) {
            if (!zzvo) {
                zzvo = true;
                zzd("Error getting advertiser id", e2);
            }
            return null;
        }
    }

    private final String zzcg() {
        String str = null;
        try {
            FileInputStream openFileInput = getContext().openFileInput("gaClientIdData");
            byte[] bArr = new byte[128];
            int read = openFileInput.read(bArr, 0, 128);
            if (openFileInput.available() > 0) {
                zzt("Hash file seems corrupted, deleting it.");
                openFileInput.close();
                getContext().deleteFile("gaClientIdData");
            } else if (read <= 0) {
                zzq("Hash file is empty.");
                openFileInput.close();
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                } catch (FileNotFoundException unused) {
                } catch (IOException e2) {
                    e = e2;
                    str = str2;
                    zzd("Error reading Hash file, deleting it", e);
                    getContext().deleteFile("gaClientIdData");
                    return str;
                }
                str = str2;
            }
        } catch (FileNotFoundException unused2) {
        } catch (IOException e3) {
            e = e3;
        }
        return str;
    }

    private static String zzo(String str) {
        MessageDigest zzai = zzcz.zzai("MD5");
        if (zzai == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, zzai.digest(str.getBytes())));
    }

    private final boolean zzp(String str) {
        try {
            String zzo = zzo(str);
            zzq("Storing hashed adid.");
            FileOutputStream openFileOutput = getContext().openFileOutput("gaClientIdData", 0);
            openFileOutput.write(zzo.getBytes());
            openFileOutput.close();
            this.zzvr = zzo;
            return true;
        } catch (IOException e2) {
            zze("Error creating hash file", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    protected final void zzaw() {
    }

    public final boolean zzbw() {
        zzdb();
        AdvertisingIdClient.Info zzce = zzce();
        return (zzce == null || zzce.isLimitAdTrackingEnabled()) ? false : true;
    }

    public final String zzcd() {
        zzdb();
        AdvertisingIdClient.Info zzce = zzce();
        String id = zzce != null ? zzce.getId() : null;
        if (TextUtils.isEmpty(id)) {
            return null;
        }
        return id;
    }
}
