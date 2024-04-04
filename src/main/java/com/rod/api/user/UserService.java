package com.rod.api.user;

import com.rod.api.common.command.CommandService;
import com.rod.api.common.component.MessengerVo;
import com.rod.api.common.query.QueryService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserService extends CommandService, QueryService {
    // command
    String updatePassword(User user);
    // query
    List<?> findUsersByName(String name);
    List<?> findUsersByJob(String job);

}