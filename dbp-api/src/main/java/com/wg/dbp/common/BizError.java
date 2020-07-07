package com.wg.dbp.common;

public interface BizError extends java.io.Serializable {
    int getErrno();

    String getErrmsg() ;
}
