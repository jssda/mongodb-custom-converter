package pers.jssd.mongodbcostomconverter.entity.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wangjingjing@bonc.com.cn
 * @date 2021/1/16 14:33
 */
@Data
public class Result<T> implements Serializable {

    private Integer code;

    private String massage;

    private T data;

    public static <T> Result<T> success() {
        return success(null);
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMassage("success");
        result.setData(data);
        return result;
    }

}
