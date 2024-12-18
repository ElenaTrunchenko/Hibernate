package ru.netology.JPARep.controller;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.web.bind.annotation.*;
import ru.netology.JPARep.entity.PersonDto;
import ru.netology.JPARep.entity.PersonFilter;
import ru.netology.JPARep.servise.Service;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/person")
//--/rest/admin-ui/people
@RequiredArgsConstructor
public class Controller {

    private final Service service;

    @GetMapping
    public PagedModel<PersonDto> getAll(@ParameterObject @ModelAttribute PersonFilter filter, @ParameterObject Pageable pageable) {
        Page<PersonDto> personDtos = service.getAll(filter, pageable);
        return new PagedModel<>(personDtos);
    }

    @GetMapping("/{id}")
    public PersonDto getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @GetMapping("/by-ids")
    public List<PersonDto> getMany(@RequestParam List<Long> ids) {
        return service.getMany(ids);
    }

    @PostMapping
    public PersonDto create(@RequestBody PersonDto dto) {
        return service.create(dto);
    }

    @PatchMapping("/{id}")
    public PersonDto patch(@PathVariable Long id, @RequestBody JsonNode patchNode) throws IOException {
        return service.patch(id, patchNode);
    }

    @PatchMapping
    public List<Long> patchMany(@RequestParam List<Long> ids, @RequestBody JsonNode patchNode) throws IOException {
        return service.patchMany(ids, patchNode);
    }

    @DeleteMapping("/{id}")
    public PersonDto delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @DeleteMapping
    public void deleteMany(@RequestParam List<Long> ids) {
        service.deleteMany(ids);
    }
}
