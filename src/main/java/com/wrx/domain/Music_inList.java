package com.wrx.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Music_inList {
    private Integer music_id;
    private Integer user_id;
    private Integer list_id;
    private String title;
    private String singer;
    private String composer;
    private String wording;
    private String type_id;
    private String music_cover_url;
    private String music_url;
    private String words_url;
    private Integer i;
}
