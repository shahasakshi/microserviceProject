package com.studentresult.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "StudentResult")
public class StudentResult {

    @Id
    private String rId;
    private String firstName;
    private float math;
    private float science;
    private float english;
    private float marathi;
    private float hindi;
    private float socialScience;

}
