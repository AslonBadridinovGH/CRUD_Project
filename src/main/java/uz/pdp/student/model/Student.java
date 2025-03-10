package uz.pdp.student.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
  private  Integer id;
  private  String name;
  private  String phoneNumber;
  private  String courseName;
}
