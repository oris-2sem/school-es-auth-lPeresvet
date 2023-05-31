package ru.itis.oris.jpahw.dto.timetable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class NewTimetableDto {
    private Long lessonId;
    private Long schoolClassId;
    private Long teacherId;
    private String auditoriumNumber;
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "dd-MM-yyyy hh:mm:ss")
    private Date date;
}
