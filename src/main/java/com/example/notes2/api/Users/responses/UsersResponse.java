package com.example.notes2.api.Users.responses;

import com.example.notes2.api.Common.responses.ListResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@EqualsAndHashCode(callSuper=true)
@Accessors(chain = true)
public class UsersResponse extends ListResponse<UserResponse> {
}
