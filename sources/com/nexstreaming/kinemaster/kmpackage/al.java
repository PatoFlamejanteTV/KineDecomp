package com.nexstreaming.kinemaster.kmpackage;

import android.util.Log;
import com.facebook.internal.Utility;
import com.nexstreaming.kinemaster.kmpackage.KMTManifest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.keyczar.Verifier;
import org.keyczar.exceptions.KeyczarException;

/* compiled from: KMTPackageValidator.java */
/* loaded from: classes.dex */
public class al {

    /* renamed from: a */
    private static String f3437a = "KMTPackageValidator";
    private static boolean b = false;

    public static List<String> a(KMTManifest kMTManifest, ak akVar) {
        ArrayList arrayList = new ArrayList();
        for (String str : kMTManifest.b().keySet()) {
            if (!akVar.c(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static boolean a(String str, String str2, z[] zVarArr) {
        for (z zVar : zVarArr) {
            if (a(str, str2, zVar)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(String str, String str2, z zVar) {
        try {
            try {
                if (!new Verifier(zVar.a()).verify(str, str2)) {
                    Log.w(f3437a, "verification failure (false return)");
                }
                return true;
            } catch (KeyczarException e) {
                Log.w(f3437a, "KeyczarException[B]!!", e);
                return false;
            }
        } catch (KeyczarException e2) {
            Log.w(f3437a, "KeyczarException[A]!!", e2);
            return false;
        }
    }

    public static boolean b(KMTManifest kMTManifest, ak akVar) throws IOException {
        if (EffectLibrary.c && (akVar instanceof ac)) {
            return true;
        }
        String next = new Scanner(akVar.a("kinemaster.dsa").f3434a).useDelimiter("\\Z").next();
        for (Map.Entry<String, KMTManifest.a> entry : kMTManifest.a().entrySet()) {
            if (!a(akVar, akVar.a(entry.getKey()), entry.getValue().f3426a)) {
                return false;
            }
        }
        for (Map.Entry<String, KMTManifest.a> entry2 : kMTManifest.b().entrySet()) {
            if (!a(akVar, akVar.b(entry2.getKey()), entry2.getValue().f3426a)) {
                return false;
            }
        }
        for (Map.Entry<String, KMTManifest.a> entry3 : kMTManifest.c().entrySet()) {
            try {
                ag b2 = akVar.b(entry3.getKey());
                if (b2 != null && !a(akVar, b2, entry3.getValue().f3426a)) {
                    return false;
                }
            } catch (FileNotFoundException e) {
            }
        }
        for (z zVar : akVar.a()) {
            try {
                try {
                    if (!new Verifier(zVar.a()).verify(kMTManifest.h(), next)) {
                        Log.w(f3437a, "verification failure (false return)");
                    } else {
                        if (kMTManifest.g() != null) {
                            return true;
                        }
                        Log.w(f3437a, "Missing Summary");
                    }
                } catch (KeyczarException e2) {
                    Log.w(f3437a, "KeyczarException[B]!!");
                    e2.printStackTrace();
                }
            } catch (KeyczarException e3) {
                Log.w(f3437a, "KeyczarException[A]!!");
            }
        }
        return false;
    }

    static boolean a(ak akVar, ag agVar, String str) throws IOException {
        if (str == null || str.length() < 1) {
            return false;
        }
        String a2 = a(agVar);
        if (b) {
        }
        return a2.equals(str);
    }

    static String a(ag agVar) throws IOException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
            messageDigest.update(("km " + agVar.b).getBytes());
            messageDigest.update((byte) 0);
            while (true) {
                int read = agVar.f3434a.read(bArr);
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    return com.nexstreaming.app.general.util.v.a(messageDigest.digest());
                }
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Required digest algorithm not found", e);
        }
    }
}
