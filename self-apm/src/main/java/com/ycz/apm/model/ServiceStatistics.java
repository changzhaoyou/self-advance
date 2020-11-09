package com.ycz.apm.model;

/**
 * @author ycz
 * @date 2020/9/26 5:23 PM
 */
public class ServiceStatistics extends Statistics{
    public String errorMsg;
    public String errorType;
    public String serviceName; //服务名称
    public String simpleName; //服务简称
    public String methodName; //方法名称

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    @Override
    public String toString() {
        return "ServiceStatistics{" +
                "errorMsg='" + errorMsg + '\'' +
                ", errorType='" + errorType + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", simpleName='" + simpleName + '\'' +
                ", methodName='" + methodName + '\'' +
                '}' +super.toString();
    }

}
