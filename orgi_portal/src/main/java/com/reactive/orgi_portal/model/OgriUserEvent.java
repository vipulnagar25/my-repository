package com.reactive.orgi_portal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class OgriUserEvent {

    private Integer OgriUserEventId;
    private OgriUser ogriUser;

}
