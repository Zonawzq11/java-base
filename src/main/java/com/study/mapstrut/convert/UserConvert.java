package com.study.mapstrut.convert;

import com.study.mapstrut.ConvertNum;
import com.study.mapstrut.User;
import com.study.mapstrut.UserCopy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;


/**
 * @Description: 转换类
 * @Authorzhiqiangwang
 */
@Mapper(uses = {ConvertNum.class})
public interface UserConvert {
   UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

  @Mappings({
          @Mapping(source="number",target = "copyNumber",qualifiedByName = "stringToLong")
  })
   UserCopy toManyCopy(User user);

   List<UserCopy> toListUserCopyList(List<User> users);

}
