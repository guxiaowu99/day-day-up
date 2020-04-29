package io.study.core.mapper.user;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.study.core.domain.user.UserDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserServiceMapper extends BaseMapper<UserDO> {

}