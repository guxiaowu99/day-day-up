package io.study.core.util;

import io.study.api.user.dto.UserDTO;
import io.study.api.user.dto.UserRegistDTO;
import io.study.core.domain.user.UserDO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

/**
 * @Auther zhangmengchao
 * @Date 2020/4/29 0029
 */
@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ModelCoreUserConvert {

    ModelCoreUserConvert mapper = Mappers.getMapper(ModelCoreUserConvert.class);

    /**
     * 注册DTO->DO
     * @param userRegistDTO
     * @return
     */
    UserDO mapUserDO(UserRegistDTO userRegistDTO);

    /**
     * UserDO -> UserDTO
     * @param userDO
     * @return
     */
    UserDTO mapUserDTO(UserDO userDO);
}
