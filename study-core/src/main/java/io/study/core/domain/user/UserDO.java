package io.study.core.domain.user;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("user")
@Data
public class UserDO {

    /**
     * 用户id
     */
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    /**
     * 用户名称
     */
    @TableId(value = "name")
    private String name;

    /**
     * 手机号
     */
    @TableId(value = "phone")
    private String phone;

    /**
     * 密码
     */
    @TableId(value = "password")
    private String password;

    /**
     * 创建时间
     */
    @TableId(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableId(value = "update_time")
    private Date updateTime;

    /**
     * 删除时间
     */
    @TableId(value = "delete_time")
    private Date deleteTime;

    /**
     * 状态 0:正常  1:删除  2-锁定
     */
    @TableId(value = "status")
    private Integer status;

    /**
     * 版本号
     */
    @TableId(value = "version")
    private Integer version;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_PHONE = "phone";

    public static final String COL_PASSWORD = "password";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_DELETE_TIME = "delete_time";

    public static final String COL_STATUS = "status";

    public static final String COL_VERSION = "version";

}