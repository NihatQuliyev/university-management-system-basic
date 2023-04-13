package com.company.universitetjk.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Teacher {
    Long id ;
    String name;
    String email;
    String subject;
    int status;
}
