package com.mizlicai.eudemon.context;

/**
 * Created by huangyt on 2017/6/16.
 */
public final class TokenConstant {
    /**
     * token存活时间 单位秒
     */
    public static final long CYCLE = 60 * 10;
//	public static final long CYCLE = 24  * 60 * 60;
    /**
     * 保持全局token值的默认命名空间
     */
    public static final String TOKEN_GLOBAL_NAMESPACE = "CASHIER.XSET.GLOBAL";

    /**
     * 保存token值的默认命名空间
     */
    public static final String TOKEN_NAMESPACE = "cashier.tokens";

}