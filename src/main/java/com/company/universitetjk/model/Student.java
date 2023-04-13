package com.company.universitetjk.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {
    Long id ;
    String name;
    String email;
    String country;
    int status;

}
