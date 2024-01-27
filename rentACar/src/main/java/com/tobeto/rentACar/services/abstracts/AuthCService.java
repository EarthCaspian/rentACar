package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.user.request.LoginUserRequest;

public interface AuthCService {

    String login (LoginUserRequest loginUserRequest);

}
