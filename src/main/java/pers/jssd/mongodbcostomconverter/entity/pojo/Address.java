package pers.jssd.mongodblearning.entity.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wangjingjing@bonc.com.cn
 * @date 2021/1/16 14:24
 */
@Data
public class Address implements Serializable {

    private String id;

    /**
     * 地区区域
     */
    private String location;

    /**
     * 地址街道
     */
    private String addr;

    /**
     * 门牌号
     */
    private Integer number;

}
