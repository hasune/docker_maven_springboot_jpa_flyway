package com.hasune.springjpa.api.service;

import com.hasune.springjpa.api.controller.request.TeacherRequest;
import com.hasune.springjpa.api.controller.response.TeacherResponse;
import com.hasune.springjpa.domain.TeacherEntity;
import com.hasune.springjpa.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepo;
    private final ModelMapper modelMapper;

    // 登録
    public void saveTeacher(TeacherRequest request) {
        TeacherEntity teacherEntity = modelMapper.map(request, TeacherEntity.class);
        teacherRepo.save(teacherEntity);
    }

    @Transactional
    public void create(TeacherRequest request) {
        TeacherEntity requestEntity = modelMapper.map(request, TeacherEntity.class);
        teacherRepo.save(requestEntity);
    }

    @Transactional
    public void update(String id, TeacherRequest request) {
        TeacherEntity targetEntity = teacherRepo.findById(Integer.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Not Found Teacher"));
        modelMapper.map(request, targetEntity);
    }

    @Transactional
    public void updateTeacher(String id, TeacherRequest request) {
        TeacherEntity teacherEntity = teacherRepo.findById(Integer.valueOf(id))
                .orElseThrow(() -> new RuntimeException("NOT FOUND TEACHER"));
        modelMapper.map(request, teacherEntity);
    }

    public TeacherResponse findTeacherById(String id) {
        TeacherEntity teacherEntity = teacherRepo.findById(Integer.valueOf(id))
                .orElseThrow(() -> new RuntimeException("NOT FOUND TEACHER"));
        return modelMapper.map(teacherEntity, TeacherResponse.class);
    }

    public TeacherResponse findTeacherByName(String name) {
        TeacherEntity teacherEntity = teacherRepo.findByName(name)
                .orElseThrow(() -> new RuntimeException("NOT FOUND TEACHER"));
        return modelMapper.map(teacherEntity, TeacherResponse.class);
    }

    public List<TeacherResponse> findAllTeacher() {
        List<TeacherEntity> teacherEntities = StreamSupport.stream(teacherRepo.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return teacherEntities.stream().map(e -> modelMapper.map(e, TeacherResponse.class))
                .collect(Collectors.toList());
    }
}