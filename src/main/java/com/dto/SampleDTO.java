package com.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

// VO 클래스 라고 생각하면 된다.
@Data
@Builder(toBuilder = true)
public class SampleDTO {

    private Long sno;
    private String first;
    private String last;
    private LocalDateTime regTime;

}
