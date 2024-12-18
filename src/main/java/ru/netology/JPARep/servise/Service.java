package ru.netology.JPARep.servise;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import ru.netology.JPARep.entity.Person;
import ru.netology.JPARep.entity.PersonDto;
import ru.netology.JPARep.entity.PersonFilter;
import ru.netology.JPARep.entity.PersonMapper;
import ru.netology.JPARep.repository.PersonRepository;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class Service {

    private final PersonMapper personMapper;

    private final PersonRepository personRepository;

    private final ObjectMapper objectMapper;

    public Page<PersonDto> getAll(PersonFilter filter, Pageable pageable) {
        Specification<Person> spec = filter.toSpecification();
        Page<Person> people = personRepository.findAll(spec, pageable);
        return people.map(personMapper::toPersonDto);
    }

    public PersonDto getOne(Long id) {
        Optional<Person> personOptional = personRepository.findById(id);
        return personMapper.toPersonDto(personOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id))));
    }

    public List<PersonDto> getMany(List<Long> ids) {
        List<Person> people = personRepository.findAllById(ids);
        return people.stream()
                .map(personMapper::toPersonDto)
                .toList();
    }

    public PersonDto create(PersonDto dto) {
        Person person = personMapper.toEntity(dto);
        Person resultPerson = personRepository.save(person);
        return personMapper.toPersonDto(resultPerson);
    }

    public PersonDto patch(Long id, JsonNode patchNode) throws IOException {
        Person person = personRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));

        PersonDto personDto = personMapper.toPersonDto(person);
        objectMapper.readerForUpdating(personDto).readValue(patchNode);
        personMapper.updateWithNull(personDto, person);

        Person resultPerson = personRepository.save(person);
        return personMapper.toPersonDto(resultPerson);
    }

    public List<Long> patchMany(List<Long> ids, JsonNode patchNode) throws IOException {
        Collection<Person> people = personRepository.findAllById(ids);

        for (Person person : people) {
            PersonDto personDto = personMapper.toPersonDto(person);
            objectMapper.readerForUpdating(personDto).readValue(patchNode);
            personMapper.updateWithNull(personDto, person);
        }

        List<Person> resultPeople = personRepository.saveAll(people);
        return resultPeople.stream()
                .map(Person::getId)
                .toList();
    }

    public PersonDto delete(Long id) {
        Person person = personRepository.findById(id).orElse(null);
        if (person != null) {
            personRepository.delete(person);
        }
        return personMapper.toPersonDto(person);
    }

    public void deleteMany(List<Long> ids) {
        personRepository.deleteAllById(ids);
    }
}
