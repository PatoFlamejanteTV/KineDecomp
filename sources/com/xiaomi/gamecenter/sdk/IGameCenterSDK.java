package com.xiaomi.gamecenter.sdk;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.widget.RemoteViews;
import com.xiaomi.gamecenter.sdk.IServiceCallback;
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
public interface IGameCenterSDK extends IInterface {

    /* loaded from: classes.dex */
    public abstract class Stub extends Binder implements IGameCenterSDK {
        private static final String DESCRIPTOR = "com.xiaomi.gamecenter.sdk.IGameCenterSDK";
        static final int TRANSACTION_ConnService = 1;
        static final int TRANSACTION_ConnServiceNew = 49;
        static final int TRANSACTION_acceptAllMessage = 21;
        static final int TRANSACTION_acceptMessage = 20;
        static final int TRANSACTION_appExit = 47;
        static final int TRANSACTION_checkJoinedUnion = 38;
        static final int TRANSACTION_checkMiTalkStatus = 36;
        static final int TRANSACTION_checkVipIsScubscribed = 40;
        static final int TRANSACTION_deleteMe = 28;
        static final int TRANSACTION_getRemoteViews = 12;
        static final int TRANSACTION_getUnionList = 42;
        static final int TRANSACTION_getVipList = 43;
        static final int TRANSACTION_isMiAccountLogin = 48;
        static final int TRANSACTION_joinUnion = 37;
        static final int TRANSACTION_loadGameFriends = 16;
        static final int TRANSACTION_loadGameInfo = 14;
        static final int TRANSACTION_loadGameMe = 15;
        static final int TRANSACTION_loadGameMessage = 19;
        static final int TRANSACTION_loadLeaderBoard = 25;
        static final int TRANSACTION_loadLotteryPrize = 29;
        static final int TRANSACTION_messageBlock = 26;
        static final int TRANSACTION_miCardPay = 6;
        static final int TRANSACTION_miGetAccountInfo = 7;
        static final int TRANSACTION_miLogin = 2;
        static final int TRANSACTION_miLogout = 3;
        static final int TRANSACTION_miUniPay = 13;
        static final int TRANSACTION_miUniPayOffline = 4;
        static final int TRANSACTION_miUniPayOnline = 5;
        static final int TRANSACTION_miWindow = 11;
        static final int TRANSACTION_openAppReport = 10;
        static final int TRANSACTION_openAppReportForInit = 46;
        static final int TRANSACTION_openMiTalkUpdateSite = 44;
        static final int TRANSACTION_registCallback = 8;
        static final int TRANSACTION_sendGameMessage = 18;
        static final int TRANSACTION_sendInviteMessage = 27;
        static final int TRANSACTION_sendInviteMessageNew = 35;
        static final int TRANSACTION_sendLogToService = 31;
        static final int TRANSACTION_sendTextMsgToFriend = 41;
        static final int TRANSACTION_shareToMiTalkForImgAndUrl = 45;
        static final int TRANSACTION_shareToMiliao = 30;
        static final int TRANSACTION_shareToMiliaoForLargeImg = 34;
        static final int TRANSACTION_subscribeVip = 39;
        static final int TRANSACTION_syncResult = 32;
        static final int TRANSACTION_syncResults = 33;
        static final int TRANSACTION_unregistCallBack = 9;
        static final int TRANSACTION_updateMe = 17;
        static final int TRANSACTION_updateResult = 23;
        static final int TRANSACTION_updateResults = 24;
        static final int TRANSACTION_useHeart = 22;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IGameCenterSDK asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGameCenterSDK)) ? new a(iBinder) : (IGameCenterSDK) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean ConnService = ConnService(parcel.readInt() != 0 ? (MiAppInfo) MiAppInfo.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(ConnService ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    LoginResult miLogin = miLogin(parcel.readString());
                    parcel2.writeNoException();
                    if (miLogin == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    miLogin.writeToParcel(parcel2, 1);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    miLogout(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    int miUniPayOffline = miUniPayOffline(parcel.readInt() != 0 ? (MiBuyInfoOffline) MiBuyInfoOffline.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(miUniPayOffline);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    int miUniPayOnline = miUniPayOnline(parcel.readInt() != 0 ? (MiBuyInfoOnline) MiBuyInfoOnline.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(miUniPayOnline);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    int miCardPay = miCardPay(parcel.readInt() != 0 ? (CardBuyInfo) CardBuyInfo.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(miCardPay);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    MiAccountInfo miGetAccountInfo = miGetAccountInfo(parcel.readString());
                    parcel2.writeNoException();
                    if (miGetAccountInfo == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    miGetAccountInfo.writeToParcel(parcel2, 1);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    registCallback(IServiceCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregistCallBack(IServiceCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    openAppReport(parcel.readInt() != 0 ? (MiAppInfo) MiAppInfo.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    int miWindow = miWindow();
                    parcel2.writeNoException();
                    parcel2.writeInt(miWindow);
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    RemoteViews remoteViews = getRemoteViews(parcel.readString());
                    parcel2.writeNoException();
                    if (remoteViews == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    remoteViews.writeToParcel(parcel2, 1);
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    int miUniPay = miUniPay(parcel.readInt() != 0 ? (MiBuyInfo) MiBuyInfo.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(miUniPay);
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    MiGamMessageResponse loadGameInfo = loadGameInfo();
                    parcel2.writeNoException();
                    if (loadGameInfo == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    loadGameInfo.writeToParcel(parcel2, 1);
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    MiGamMessageResponse loadGameMe = loadGameMe();
                    parcel2.writeNoException();
                    if (loadGameMe == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    loadGameMe.writeToParcel(parcel2, 1);
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    MiGamMessageResponse loadGameFriends = loadGameFriends();
                    parcel2.writeNoException();
                    if (loadGameFriends == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    loadGameFriends.writeToParcel(parcel2, 1);
                    return true;
                case 17:
                    parcel.enforceInterface(DESCRIPTOR);
                    MiGamMessageResponse updateMe = updateMe(parcel.readInt(), parcel.readInt(), parcel.createByteArray(), parcel.createByteArray());
                    parcel2.writeNoException();
                    if (updateMe == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    updateMe.writeToParcel(parcel2, 1);
                    return true;
                case 18:
                    parcel.enforceInterface(DESCRIPTOR);
                    MiGamMessageResponse sendGameMessage = sendGameMessage(parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt(), parcel.createByteArray(), (GamMetaInfo[]) parcel.createTypedArray(GamMetaInfo.CREATOR));
                    parcel2.writeNoException();
                    if (sendGameMessage == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    sendGameMessage.writeToParcel(parcel2, 1);
                    return true;
                case 19:
                    parcel.enforceInterface(DESCRIPTOR);
                    MiGamMessageResponse loadGameMessage = loadGameMessage();
                    parcel2.writeNoException();
                    if (loadGameMessage == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    loadGameMessage.writeToParcel(parcel2, 1);
                    return true;
                case 20:
                    parcel.enforceInterface(DESCRIPTOR);
                    MiGamMessageResponse acceptMessage = acceptMessage(parcel.readString());
                    parcel2.writeNoException();
                    if (acceptMessage == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    acceptMessage.writeToParcel(parcel2, 1);
                    return true;
                case 21:
                    parcel.enforceInterface(DESCRIPTOR);
                    MiGamMessageResponse acceptAllMessage = acceptAllMessage();
                    parcel2.writeNoException();
                    if (acceptAllMessage == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    acceptAllMessage.writeToParcel(parcel2, 1);
                    return true;
                case 22:
                    parcel.enforceInterface(DESCRIPTOR);
                    MiGamMessageResponse useHeart = useHeart(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    if (useHeart == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    useHeart.writeToParcel(parcel2, 1);
                    return true;
                case 23:
                    parcel.enforceInterface(DESCRIPTOR);
                    MiGamMessageResponse updateResult = updateResult(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.createByteArray(), parcel.createByteArray(), parcel.readString(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    if (updateResult == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    updateResult.writeToParcel(parcel2, 1);
                    return true;
                case 24:
                    parcel.enforceInterface(DESCRIPTOR);
                    MiGamMessageResponse updateResults = updateResults((ScoresEntry[]) parcel.createTypedArray(ScoresEntry.CREATOR), parcel.readInt(), parcel.createByteArray(), parcel.createByteArray(), parcel.readString(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    if (updateResults == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    updateResults.writeToParcel(parcel2, 1);
                    return true;
                case 25:
                    parcel.enforceInterface(DESCRIPTOR);
                    MiGamMessageResponse loadLeaderBoard = loadLeaderBoard(parcel.readString(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    if (loadLeaderBoard == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    loadLeaderBoard.writeToParcel(parcel2, 1);
                    return true;
                case 26:
                    parcel.enforceInterface(DESCRIPTOR);
                    MiGamMessageResponse messageBlock = messageBlock(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    if (messageBlock == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    messageBlock.writeToParcel(parcel2, 1);
                    return true;
                case 27:
                    parcel.enforceInterface(DESCRIPTOR);
                    MiGamMessageResponse sendInviteMessage = sendInviteMessage(parcel.readString(), parcel.readInt() != 0, parcel.readString(), (GamMetaInfo[]) parcel.createTypedArray(GamMetaInfo.CREATOR), parcel.readInt() != 0 ? (MiliaoInfo) MiliaoInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (sendInviteMessage == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    sendInviteMessage.writeToParcel(parcel2, 1);
                    return true;
                case 28:
                    parcel.enforceInterface(DESCRIPTOR);
                    MiGamMessageResponse deleteMe = deleteMe();
                    parcel2.writeNoException();
                    if (deleteMe == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    deleteMe.writeToParcel(parcel2, 1);
                    return true;
                case 29:
                    parcel.enforceInterface(DESCRIPTOR);
                    MiGamMessageResponse loadLotteryPrize = loadLotteryPrize();
                    parcel2.writeNoException();
                    if (loadLotteryPrize == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    loadLotteryPrize.writeToParcel(parcel2, 1);
                    return true;
                case 30:
                    parcel.enforceInterface(DESCRIPTOR);
                    MiGamMessageResponse shareToMiliao = shareToMiliao(parcel.readInt() != 0 ? (MiliaoInfo) MiliaoInfo.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (shareToMiliao == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    shareToMiliao.writeToParcel(parcel2, 1);
                    return true;
                case 31:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendLogToService(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 32:
                    parcel.enforceInterface(DESCRIPTOR);
                    MiGamMessageResponse syncResult = syncResult(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.createByteArray(), parcel.createByteArray());
                    parcel2.writeNoException();
                    if (syncResult == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    syncResult.writeToParcel(parcel2, 1);
                    return true;
                case 33:
                    parcel.enforceInterface(DESCRIPTOR);
                    MiGamMessageResponse syncResults = syncResults((ScoresEntry[]) parcel.createTypedArray(ScoresEntry.CREATOR), parcel.readInt(), parcel.createByteArray(), parcel.createByteArray());
                    parcel2.writeNoException();
                    if (syncResults == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    syncResults.writeToParcel(parcel2, 1);
                    return true;
                case 34:
                    parcel.enforceInterface(DESCRIPTOR);
                    MiGamMessageResponse shareToMiliaoForLargeImg = shareToMiliaoForLargeImg(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (MiliaoInfo) MiliaoInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (shareToMiliaoForLargeImg == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    shareToMiliaoForLargeImg.writeToParcel(parcel2, 1);
                    return true;
                case 35:
                    parcel.enforceInterface(DESCRIPTOR);
                    MiGamMessageResponse sendInviteMessageNew = sendInviteMessageNew(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (MiliaoInfo) MiliaoInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (sendInviteMessageNew == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    sendInviteMessageNew.writeToParcel(parcel2, 1);
                    return true;
                case 36:
                    parcel.enforceInterface(DESCRIPTOR);
                    MiGamMessageResponse checkMiTalkStatus = checkMiTalkStatus();
                    parcel2.writeNoException();
                    if (checkMiTalkStatus == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    checkMiTalkStatus.writeToParcel(parcel2, 1);
                    return true;
                case 37:
                    parcel.enforceInterface(DESCRIPTOR);
                    MiGamMessageResponse joinUnion = joinUnion(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (joinUnion == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    joinUnion.writeToParcel(parcel2, 1);
                    return true;
                case 38:
                    parcel.enforceInterface(DESCRIPTOR);
                    MiGamMessageResponse checkJoinedUnion = checkJoinedUnion(parcel.readString());
                    parcel2.writeNoException();
                    if (checkJoinedUnion == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    checkJoinedUnion.writeToParcel(parcel2, 1);
                    return true;
                case 39:
                    parcel.enforceInterface(DESCRIPTOR);
                    MiGamMessageResponse subscribeVip = subscribeVip(parcel.readString());
                    parcel2.writeNoException();
                    if (subscribeVip == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    subscribeVip.writeToParcel(parcel2, 1);
                    return true;
                case 40:
                    parcel.enforceInterface(DESCRIPTOR);
                    MiGamMessageResponse checkVipIsScubscribed = checkVipIsScubscribed(parcel.readString());
                    parcel2.writeNoException();
                    if (checkVipIsScubscribed == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    checkVipIsScubscribed.writeToParcel(parcel2, 1);
                    return true;
                case 41:
                    parcel.enforceInterface(DESCRIPTOR);
                    MiGamMessageResponse sendTextMsgToFriend = sendTextMsgToFriend();
                    parcel2.writeNoException();
                    if (sendTextMsgToFriend == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    sendTextMsgToFriend.writeToParcel(parcel2, 1);
                    return true;
                case 42:
                    parcel.enforceInterface(DESCRIPTOR);
                    MiGamMessageResponse unionList = getUnionList();
                    parcel2.writeNoException();
                    if (unionList == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    unionList.writeToParcel(parcel2, 1);
                    return true;
                case 43:
                    parcel.enforceInterface(DESCRIPTOR);
                    MiGamMessageResponse vipList = getVipList();
                    parcel2.writeNoException();
                    if (vipList == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    vipList.writeToParcel(parcel2, 1);
                    return true;
                case 44:
                    parcel.enforceInterface(DESCRIPTOR);
                    openMiTalkUpdateSite();
                    parcel2.writeNoException();
                    return true;
                case 45:
                    parcel.enforceInterface(DESCRIPTOR);
                    MiGamMessageResponse shareToMiTalkForImgAndUrl = shareToMiTalkForImgAndUrl(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (MiliaoInfo) MiliaoInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (shareToMiTalkForImgAndUrl == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    shareToMiTalkForImgAndUrl.writeToParcel(parcel2, 1);
                    return true;
                case 46:
                    parcel.enforceInterface(DESCRIPTOR);
                    openAppReportForInit(parcel.readInt() != 0 ? (MiAppInfo) MiAppInfo.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 47:
                    parcel.enforceInterface(DESCRIPTOR);
                    int appExit = appExit();
                    parcel2.writeNoException();
                    parcel2.writeInt(appExit);
                    return true;
                case 48:
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle isMiAccountLogin = isMiAccountLogin();
                    parcel2.writeNoException();
                    if (isMiAccountLogin == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    isMiAccountLogin.writeToParcel(parcel2, 1);
                    return true;
                case 49:
                    parcel.enforceInterface(DESCRIPTOR);
                    int ConnServiceNew = ConnServiceNew(parcel.readInt() != 0 ? (MiAppInfo) MiAppInfo.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(ConnServiceNew);
                    return true;
                case 1598968902:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    boolean ConnService(MiAppInfo miAppInfo, String str);

    int ConnServiceNew(MiAppInfo miAppInfo, String str);

    MiGamMessageResponse acceptAllMessage();

    MiGamMessageResponse acceptMessage(String str);

    int appExit();

    MiGamMessageResponse checkJoinedUnion(String str);

    MiGamMessageResponse checkMiTalkStatus();

    MiGamMessageResponse checkVipIsScubscribed(String str);

    MiGamMessageResponse deleteMe();

    RemoteViews getRemoteViews(String str);

    MiGamMessageResponse getUnionList();

    MiGamMessageResponse getVipList();

    Bundle isMiAccountLogin();

    MiGamMessageResponse joinUnion(String str, String str2);

    MiGamMessageResponse loadGameFriends();

    MiGamMessageResponse loadGameInfo();

    MiGamMessageResponse loadGameMe();

    MiGamMessageResponse loadGameMessage();

    MiGamMessageResponse loadLeaderBoard(String str, int i, int i2);

    MiGamMessageResponse loadLotteryPrize();

    MiGamMessageResponse messageBlock(boolean z);

    int miCardPay(CardBuyInfo cardBuyInfo, String str, Bundle bundle);

    MiAccountInfo miGetAccountInfo(String str);

    LoginResult miLogin(String str);

    void miLogout(String str);

    int miUniPay(MiBuyInfo miBuyInfo, String str);

    int miUniPayOffline(MiBuyInfoOffline miBuyInfoOffline, String str, Bundle bundle);

    int miUniPayOnline(MiBuyInfoOnline miBuyInfoOnline, String str, Bundle bundle);

    int miWindow();

    void openAppReport(MiAppInfo miAppInfo, String str);

    void openAppReportForInit(MiAppInfo miAppInfo, String str);

    void openMiTalkUpdateSite();

    void registCallback(IServiceCallback iServiceCallback, String str);

    MiGamMessageResponse sendGameMessage(String str, boolean z, String str2, String str3, int i, byte[] bArr, GamMetaInfo[] gamMetaInfoArr);

    MiGamMessageResponse sendInviteMessage(String str, boolean z, String str2, GamMetaInfo[] gamMetaInfoArr, MiliaoInfo miliaoInfo);

    MiGamMessageResponse sendInviteMessageNew(String str, String str2, String str3, MiliaoInfo miliaoInfo);

    void sendLogToService(String str);

    MiGamMessageResponse sendTextMsgToFriend();

    MiGamMessageResponse shareToMiTalkForImgAndUrl(String str, String str2, String str3, String str4, MiliaoInfo miliaoInfo);

    MiGamMessageResponse shareToMiliao(MiliaoInfo miliaoInfo, String str, String str2, String str3);

    MiGamMessageResponse shareToMiliaoForLargeImg(String str, String str2, MiliaoInfo miliaoInfo);

    MiGamMessageResponse subscribeVip(String str);

    MiGamMessageResponse syncResult(String str, int i, int i2, byte[] bArr, byte[] bArr2);

    MiGamMessageResponse syncResults(ScoresEntry[] scoresEntryArr, int i, byte[] bArr, byte[] bArr2);

    void unregistCallBack(IServiceCallback iServiceCallback, String str);

    MiGamMessageResponse updateMe(int i, int i2, byte[] bArr, byte[] bArr2);

    MiGamMessageResponse updateResult(String str, int i, int i2, byte[] bArr, byte[] bArr2, String str2, int i3, String str3);

    MiGamMessageResponse updateResults(ScoresEntry[] scoresEntryArr, int i, byte[] bArr, byte[] bArr2, String str, int i2, String str2);

    MiGamMessageResponse useHeart(int i, boolean z);
}
