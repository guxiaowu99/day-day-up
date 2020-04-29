package io.study.common.model;

import lombok.Data;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

/**
 * @Auther zhangmengchao
 * @Date 2020/4/29 0029
 */
@Data
public class AuthUser implements UserDetails, CredentialsContainer {
    /**
     * 用户id
     */
    private Long id;
    /**
     * 登录账号
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户编码
     */
    private String userNo;
    /**
     * 用户电话
     */
    private String phoneNumber;
    /**
     * 身份认证
     */
    private Integer indentity;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 头像图片
     */
    private String headImg;
    /**
     * 邀请码
     */
    private String inviteCode;

    /**
     * 是否设置支付密码
     */
    private Boolean isPayPwd;
    /**
     * 店铺id
     */
    private Long shopId;
    /**
     * 用户类型 10:普通用户  20:会员
     */
    private Integer type;
    /**
     * 权限资源码-admin
     */
    private Set<String> resourceCodes;

    private Set<GrantedAuthority> authorities;

    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    public AuthUser() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public void eraseCredentials() {
        this.password = null;
    }
}
