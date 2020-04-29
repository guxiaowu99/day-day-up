package io.study.core.service.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.study.api.user.dto.UserDTO;
import io.study.api.user.dto.UserRegistDTO;
import io.study.api.user.service.UserServiceApi;
import io.study.core.util.ModelCoreUserConvert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import io.study.core.domain.user.UserDO;
import io.study.core.mapper.user.UserServiceMapper;

@Slf4j
@Service
public class UserServiceApiImpl extends ServiceImpl<UserServiceMapper, UserDO> implements UserServiceApi {

    @Override
    public Boolean regist(UserRegistDTO userRegistDTO) {
        UserDO userDO = ModelCoreUserConvert.mapper.mapUserDO(userRegistDTO);
        int result = this.baseMapper.insert(userDO);
        if (result <1){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public UserDTO selectByName(String username) {
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(UserDO.COL_NAME, username);
        UserDO userDO = this.baseMapper.selectOne(queryWrapper);
        return ModelCoreUserConvert.mapper.mapUserDTO(userDO);
    }
}

