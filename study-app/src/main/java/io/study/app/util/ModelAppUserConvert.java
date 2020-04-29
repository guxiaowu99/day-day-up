package io.study.app.util;


import io.study.api.user.dto.UserRegistDTO;
import io.study.app.query.UserRegisterQuery;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ModelAppUserConvert {

    ModelAppUserConvert mapper = Mappers.getMapper(ModelAppUserConvert.class);

    /**
     * 用户注册DTO转换
     * @param userRegisterQuery
     * @return
     */
    UserRegistDTO mapUserRegistDTO(UserRegisterQuery userRegisterQuery);
}
