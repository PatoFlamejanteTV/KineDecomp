package com.xiaomi.gamecenter.sdk;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.widget.RemoteViews;
import com.xiaomi.gamecenter.sdk.entry.CardBuyInfo;
import com.xiaomi.gamecenter.sdk.entry.LoginResult;
import com.xiaomi.gamecenter.sdk.entry.MiAccountInfo;
import com.xiaomi.gamecenter.sdk.entry.MiAppInfo;
import com.xiaomi.gamecenter.sdk.entry.MiBuyInfo;
import com.xiaomi.gamecenter.sdk.entry.MiBuyInfoOffline;
import com.xiaomi.gamecenter.sdk.entry.MiBuyInfoOnline;
import com.xiaomi.gamecenter.sdk.gam.GamMetaInfo;
import com.xiaomi.gamecenter.sdk.gam.MiGamMessageResponse;
import com.xiaomi.gamecenter.sdk.gam.MiliaoInfo;
import com.xiaomi.gamecenter.sdk.gam.ScoresEntry;

/* loaded from: classes.dex */
public class a implements IGameCenterSDK {

    /* renamed from: a */
    private IBinder f4876a;

    public a(IBinder iBinder) {
        this.f4876a = iBinder;
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public boolean ConnService(MiAppInfo miAppInfo, String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            if (miAppInfo != null) {
                obtain.writeInt(1);
                miAppInfo.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str);
            this.f4876a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public int ConnServiceNew(MiAppInfo miAppInfo, String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            if (miAppInfo != null) {
                obtain.writeInt(1);
                miAppInfo.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str);
            this.f4876a.transact(49, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public MiGamMessageResponse acceptAllMessage() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            this.f4876a.transact(21, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (MiGamMessageResponse) MiGamMessageResponse.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public MiGamMessageResponse acceptMessage(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            obtain.writeString(str);
            this.f4876a.transact(20, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (MiGamMessageResponse) MiGamMessageResponse.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public int appExit() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            this.f4876a.transact(47, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f4876a;
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public MiGamMessageResponse checkJoinedUnion(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            obtain.writeString(str);
            this.f4876a.transact(38, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (MiGamMessageResponse) MiGamMessageResponse.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public MiGamMessageResponse checkMiTalkStatus() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            this.f4876a.transact(36, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (MiGamMessageResponse) MiGamMessageResponse.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public MiGamMessageResponse checkVipIsScubscribed(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            obtain.writeString(str);
            this.f4876a.transact(40, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (MiGamMessageResponse) MiGamMessageResponse.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public MiGamMessageResponse deleteMe() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            this.f4876a.transact(28, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (MiGamMessageResponse) MiGamMessageResponse.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public RemoteViews getRemoteViews(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            obtain.writeString(str);
            this.f4876a.transact(12, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (RemoteViews) RemoteViews.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public MiGamMessageResponse getUnionList() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            this.f4876a.transact(42, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (MiGamMessageResponse) MiGamMessageResponse.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public MiGamMessageResponse getVipList() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            this.f4876a.transact(43, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (MiGamMessageResponse) MiGamMessageResponse.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public Bundle isMiAccountLogin() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            this.f4876a.transact(48, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public MiGamMessageResponse joinUnion(String str, String str2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            obtain.writeString(str);
            obtain.writeString(str2);
            this.f4876a.transact(37, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (MiGamMessageResponse) MiGamMessageResponse.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public MiGamMessageResponse loadGameFriends() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            this.f4876a.transact(16, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (MiGamMessageResponse) MiGamMessageResponse.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public MiGamMessageResponse loadGameInfo() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            this.f4876a.transact(14, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (MiGamMessageResponse) MiGamMessageResponse.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public MiGamMessageResponse loadGameMe() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            this.f4876a.transact(15, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (MiGamMessageResponse) MiGamMessageResponse.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public MiGamMessageResponse loadGameMessage() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            this.f4876a.transact(19, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (MiGamMessageResponse) MiGamMessageResponse.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public MiGamMessageResponse loadLeaderBoard(String str, int i, int i2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            obtain.writeString(str);
            obtain.writeInt(i);
            obtain.writeInt(i2);
            this.f4876a.transact(25, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (MiGamMessageResponse) MiGamMessageResponse.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public MiGamMessageResponse loadLotteryPrize() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            this.f4876a.transact(29, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (MiGamMessageResponse) MiGamMessageResponse.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public MiGamMessageResponse messageBlock(boolean z) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            obtain.writeInt(z ? 1 : 0);
            this.f4876a.transact(26, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (MiGamMessageResponse) MiGamMessageResponse.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public int miCardPay(CardBuyInfo cardBuyInfo, String str, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            if (cardBuyInfo != null) {
                obtain.writeInt(1);
                cardBuyInfo.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4876a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public MiAccountInfo miGetAccountInfo(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            obtain.writeString(str);
            this.f4876a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (MiAccountInfo) MiAccountInfo.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public LoginResult miLogin(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            obtain.writeString(str);
            this.f4876a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (LoginResult) LoginResult.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public void miLogout(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            obtain.writeString(str);
            this.f4876a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public int miUniPay(MiBuyInfo miBuyInfo, String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            if (miBuyInfo != null) {
                obtain.writeInt(1);
                miBuyInfo.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str);
            this.f4876a.transact(13, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public int miUniPayOffline(MiBuyInfoOffline miBuyInfoOffline, String str, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            if (miBuyInfoOffline != null) {
                obtain.writeInt(1);
                miBuyInfoOffline.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4876a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public int miUniPayOnline(MiBuyInfoOnline miBuyInfoOnline, String str, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            if (miBuyInfoOnline != null) {
                obtain.writeInt(1);
                miBuyInfoOnline.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4876a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public int miWindow() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            this.f4876a.transact(11, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public void openAppReport(MiAppInfo miAppInfo, String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            if (miAppInfo != null) {
                obtain.writeInt(1);
                miAppInfo.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str);
            this.f4876a.transact(10, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public void openAppReportForInit(MiAppInfo miAppInfo, String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            if (miAppInfo != null) {
                obtain.writeInt(1);
                miAppInfo.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str);
            this.f4876a.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public void openMiTalkUpdateSite() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            this.f4876a.transact(44, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public void registCallback(IServiceCallback iServiceCallback, String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            obtain.writeStrongBinder(iServiceCallback != null ? iServiceCallback.asBinder() : null);
            obtain.writeString(str);
            this.f4876a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public MiGamMessageResponse sendGameMessage(String str, boolean z, String str2, String str3, int i, byte[] bArr, GamMetaInfo[] gamMetaInfoArr) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            obtain.writeString(str);
            obtain.writeInt(z ? 1 : 0);
            obtain.writeString(str2);
            obtain.writeString(str3);
            obtain.writeInt(i);
            obtain.writeByteArray(bArr);
            obtain.writeTypedArray(gamMetaInfoArr, 0);
            this.f4876a.transact(18, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (MiGamMessageResponse) MiGamMessageResponse.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public MiGamMessageResponse sendInviteMessage(String str, boolean z, String str2, GamMetaInfo[] gamMetaInfoArr, MiliaoInfo miliaoInfo) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            obtain.writeString(str);
            obtain.writeInt(z ? 1 : 0);
            obtain.writeString(str2);
            obtain.writeTypedArray(gamMetaInfoArr, 0);
            if (miliaoInfo != null) {
                obtain.writeInt(1);
                miliaoInfo.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4876a.transact(27, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (MiGamMessageResponse) MiGamMessageResponse.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public MiGamMessageResponse sendInviteMessageNew(String str, String str2, String str3, MiliaoInfo miliaoInfo) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeString(str3);
            if (miliaoInfo != null) {
                obtain.writeInt(1);
                miliaoInfo.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4876a.transact(35, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (MiGamMessageResponse) MiGamMessageResponse.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public void sendLogToService(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            obtain.writeString(str);
            this.f4876a.transact(31, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public MiGamMessageResponse sendTextMsgToFriend() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            this.f4876a.transact(41, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (MiGamMessageResponse) MiGamMessageResponse.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public MiGamMessageResponse shareToMiTalkForImgAndUrl(String str, String str2, String str3, String str4, MiliaoInfo miliaoInfo) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeString(str3);
            obtain.writeString(str4);
            if (miliaoInfo != null) {
                obtain.writeInt(1);
                miliaoInfo.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4876a.transact(45, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (MiGamMessageResponse) MiGamMessageResponse.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public MiGamMessageResponse shareToMiliao(MiliaoInfo miliaoInfo, String str, String str2, String str3) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            if (miliaoInfo != null) {
                obtain.writeInt(1);
                miliaoInfo.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeString(str3);
            this.f4876a.transact(30, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (MiGamMessageResponse) MiGamMessageResponse.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public MiGamMessageResponse shareToMiliaoForLargeImg(String str, String str2, MiliaoInfo miliaoInfo) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            obtain.writeString(str);
            obtain.writeString(str2);
            if (miliaoInfo != null) {
                obtain.writeInt(1);
                miliaoInfo.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4876a.transact(34, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (MiGamMessageResponse) MiGamMessageResponse.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public MiGamMessageResponse subscribeVip(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            obtain.writeString(str);
            this.f4876a.transact(39, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (MiGamMessageResponse) MiGamMessageResponse.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public MiGamMessageResponse syncResult(String str, int i, int i2, byte[] bArr, byte[] bArr2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            obtain.writeString(str);
            obtain.writeInt(i);
            obtain.writeInt(i2);
            obtain.writeByteArray(bArr);
            obtain.writeByteArray(bArr2);
            this.f4876a.transact(32, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (MiGamMessageResponse) MiGamMessageResponse.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public MiGamMessageResponse syncResults(ScoresEntry[] scoresEntryArr, int i, byte[] bArr, byte[] bArr2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            obtain.writeTypedArray(scoresEntryArr, 0);
            obtain.writeInt(i);
            obtain.writeByteArray(bArr);
            obtain.writeByteArray(bArr2);
            this.f4876a.transact(33, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (MiGamMessageResponse) MiGamMessageResponse.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public void unregistCallBack(IServiceCallback iServiceCallback, String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            obtain.writeStrongBinder(iServiceCallback != null ? iServiceCallback.asBinder() : null);
            obtain.writeString(str);
            this.f4876a.transact(9, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public MiGamMessageResponse updateMe(int i, int i2, byte[] bArr, byte[] bArr2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            obtain.writeInt(i);
            obtain.writeInt(i2);
            obtain.writeByteArray(bArr);
            obtain.writeByteArray(bArr2);
            this.f4876a.transact(17, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (MiGamMessageResponse) MiGamMessageResponse.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public MiGamMessageResponse updateResult(String str, int i, int i2, byte[] bArr, byte[] bArr2, String str2, int i3, String str3) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            obtain.writeString(str);
            obtain.writeInt(i);
            obtain.writeInt(i2);
            obtain.writeByteArray(bArr);
            obtain.writeByteArray(bArr2);
            obtain.writeString(str2);
            obtain.writeInt(i3);
            obtain.writeString(str3);
            this.f4876a.transact(23, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (MiGamMessageResponse) MiGamMessageResponse.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public MiGamMessageResponse updateResults(ScoresEntry[] scoresEntryArr, int i, byte[] bArr, byte[] bArr2, String str, int i2, String str2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            obtain.writeTypedArray(scoresEntryArr, 0);
            obtain.writeInt(i);
            obtain.writeByteArray(bArr);
            obtain.writeByteArray(bArr2);
            obtain.writeString(str);
            obtain.writeInt(i2);
            obtain.writeString(str2);
            this.f4876a.transact(24, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (MiGamMessageResponse) MiGamMessageResponse.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.xiaomi.gamecenter.sdk.IGameCenterSDK
    public MiGamMessageResponse useHeart(int i, boolean z) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.gamecenter.sdk.IGameCenterSDK");
            obtain.writeInt(i);
            obtain.writeInt(z ? 1 : 0);
            this.f4876a.transact(22, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (MiGamMessageResponse) MiGamMessageResponse.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
