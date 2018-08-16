package com.briup.ssm.common.exception;

import java.util.HashMap;
import java.util.Map;

/*
 * 定义统一的异常实现类
 */
public class EstoreCommonException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private static final Map<Integer, EstoreCommonException> exceptionMap = new HashMap<Integer, EstoreCommonException>();
	private static final Map<Integer, String> errmsgMap = new HashMap<Integer, String>();

	/*
	 * 定义不同状态码显示不同的信息 方便开发人员统一异常
	 */
	static {
		errmsgMap.put(401, "参数为空!");
		errmsgMap.put(402, "用户名密码错误!");
		errmsgMap.put(403, "参数错误!");
		errmsgMap.put(404, "查询结果为空！");
		exceptionMap.put(501, new EstoreCommonException(501, getMessage(501)));
	}

	private int errcode;
	private String errmsg;

	public EstoreCommonException(int errcode, String msg) {
		super(msg);
		this.errcode = errcode;
		this.errmsg = msg;
	}

	public int getErrcode() {
		return errcode;
	}

	@Override
	public String getMessage() {
		return errmsg;
	}

	/*
	 * 获取不同的状态码所对应的信息
	 */
	public static String getMessage(int errcode) {
		if (errmsgMap.containsKey(errcode)) {
			return errmsgMap.get(errcode);
		}
		else {
			return errmsgMap.get(501);
		}
	}

	/*
	 * 获取不同的状态码所对应的异常信息
	 */
	public static EstoreCommonException getException(int errcode) {
		if (exceptionMap.containsKey(errcode)) {
			return exceptionMap.get(errcode);
		} else if (errmsgMap.containsKey(errcode)) {
			EstoreCommonException ex = new EstoreCommonException(errcode, getMessage(errcode));
			exceptionMap.put(errcode, ex);
			return ex;
		} else {
			return exceptionMap.get(501);
			
		}
	}

}
