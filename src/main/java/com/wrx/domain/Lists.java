package com.wrx.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Lists {
    private Integer user_id;
    private Integer music_id;
    private Integer list_id;
    private String list_type;
    private String list_cover_url;
    private String list_name;

}
