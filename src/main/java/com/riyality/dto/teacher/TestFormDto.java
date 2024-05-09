package com.riyality.dto.teacher;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestFormDto {

	private String testName;
	private List<QuestionDto> questions;
}