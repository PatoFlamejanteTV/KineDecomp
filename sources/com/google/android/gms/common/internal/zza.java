package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzp;

/* loaded from: classes.dex */
public class zza extends zzp.zza {

    /* renamed from: a, reason: collision with root package name */
    int f1000a;
    private Account b;
    private Context c;

    public static Account a(zzp zzpVar) {
        Account account = null;
        if (zzpVar != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = zzpVar.a();
            } catch (RemoteException e) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return account;
    }

    @Override // com.google.android.gms.common.internal.zzp
    public Account a() {
        int callingUid = Binder.getCallingUid();
        if (callingUid == this.f1000a) {
            return this.b;
        }
        if (!GooglePlayServicesUtil.a(this.c, callingUid)) {
            throw new SecurityException("Caller is not GooglePlayServices");
        }
        this.f1000a = callingUid;
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zza) {
            return this.b.equals(((zza) obj).b);
        }
        return false;
    }
}
