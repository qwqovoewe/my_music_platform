package com.wrx.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mv {
    private Integer mv_id;
    private Integer music_id;
    private String movie_url;
    private String picture_url;
    private String description;
    private String title;
    private String singer;
    private String music_url;
}
