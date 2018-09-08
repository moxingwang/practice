package top.moxingwang.jib.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * code和message默认使用 200段
 *
 * @param <T>
 */
@ApiModel(value = "BaseResponse",description = "返回实体")
public class BaseResponse<T> {
    @ApiModelProperty(value = "返回code")
    protected String code;
    @ApiModelProperty(value = "返回message")
    protected String message;
    @ApiModelProperty(value = "返回data")
    protected T data;

    public BaseResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}