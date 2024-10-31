package com.xiaomi.gamecenter.sdk.gam;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class MiResponseHandler extends Handler {
    public MiResponseHandler() {
        super(Looper.getMainLooper());
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        super.dispatchMessage(message);
        try {
            MiGamMessageResponse miGamMessageResponse = (MiGamMessageResponse) message.obj;
            int sdkStatus = miGamMessageResponse.getSdkStatus();
            String msgResult = miGamMessageResponse.getMsgResult();
            JSONObject jSONObject = msgResult != null ? new JSONObject(msgResult) : null;
            if (sdkStatus == 0) {
                onComplete(sdkStatus, jSONObject);
            } else {
                onError(sdkStatus, jSONObject);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected abstract void onComplete(int i, JSONObject jSONObject);

    protected abstract void onError(int i, JSONObject jSONObject);

    public void sendResultMsg(int i, String str) {
        Message message = new Message();
        MiGamMessageResponse miGamMessageResponse = new MiGamMessageResponse();
        miGamMessageResponse.setSdkStatus(i);
        miGamMessageResponse.setMsgResult(str);
        message.obj = miGamMessageResponse;
        sendMessage(message);
    }

    public void sendResultMsg(MiGamMessageResponse miGamMessageResponse) {
        Message message = new Message();
        message.obj = miGamMessageResponse;
        sendMessage(message);
    }
}
