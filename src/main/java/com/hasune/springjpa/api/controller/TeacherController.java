package com.hasune.springjpa.api.controller;

import com.hasune.springjpa.api.controller.request.TeacherRequest;
import com.hasune.springjpa.api.controller.response.TeacherResponse;
import com.hasune.springjpa.api.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping
    public void create(@RequestBody TeacherRequest request) {
        teacherService.create(request);
    }

    @PutMapping("{id}")
    public void update(@RequestBody TeacherRequest request, @PathVariable("id") String id) {
        teacherService.update(id, request);
    }

    @GetMapping("{id}")
    public TeacherResponse findTeacher(@PathVariable("id") String id) {
        return teacherService.findTeacherById(id);
    }

    @GetMapping("/all")
    public List<TeacherResponse> getAllTeachers() {
        return teacherService.findAllTeacher();
    }

}
