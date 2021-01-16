package pers.jssd.mongodbcostomconverter.entity.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import pers.jssd.mongodbcostomconverter.entity.constant.SexEnum;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户实体类
 *
 * @author wangjingjing@bonc.com.cn
 * @date 2021/1/16 14:19
 */
@Data
public class User implements Serializable {

    @Id
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 地址信息, 一个人有多个地址
     */
    private List<Address> addressList;

    /**
     * 性别
     * @see SexEnum
     */
    private SexEnum sex;

    /**
     * 创建时间
     */
    private LocalDateTime createTs;

}
