package com.riyality.dto.teacher;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionDto {
	private String questionText;
	private List<AnswerDto> answers;
}
