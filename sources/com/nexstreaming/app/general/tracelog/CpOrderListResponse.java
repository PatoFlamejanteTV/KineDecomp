package com.nexstreaming.app.general.tracelog;

import com.nexstreaming.app.general.tracelog.TLP;
import java.util.List;

/* loaded from: classes2.dex */
public class CpOrderListResponse implements TLP.BaseResponse {
    public static final int ORDER_CONSUME_CODE_COIN = 11;
    public static final int ORDER_CONSUME_CODE_COMMON = 10;
    public static final int ORDER_STATE_CODE_FAILED = 1;
    public static final int ORDER_STATE_CODE_SUCCESS = 0;
    private int result = -1;
    private long log_date = 0;
    private List<OrderList> list = null;

    /* loaded from: classes2.dex */
    public static class OrderList {
        public String productcode = null;
        public long paytime = 0;
        public long payfee = 0;
        public int orderstatus = 0;
        public int orderconsumetype = 0;
        public long partnergiftconsume = 0;
        public String cp_user_info = null;
        public String orderid = null;
    }

    public List<OrderList> getList() {
        return this.list;
    }

    public long getLogDate() {
        return this.log_date;
    }

    @Override // com.nexstreaming.app.general.tracelog.TLP.BaseResponse
    public int getResult() {
        return this.result;
    }

    public String toString() {
        return "XiaomiCpOrderListResponse{result=" + this.result + ", list=" + this.list + '}';
    }
}
