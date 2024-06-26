package com.rod.api.common.component;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Component
@Getter
@Builder
public class ImageVo {
    private Long imageId;
    String name;
    Long lastModified;
    Long lastModifiedDate;
    String type;
    String webkitRelativePath;
    Long size;
}
