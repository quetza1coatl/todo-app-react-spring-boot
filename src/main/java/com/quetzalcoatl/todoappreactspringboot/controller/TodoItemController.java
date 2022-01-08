package com.quetzalcoatl.todoappreactspringboot.controller;

import com.quetzalcoatl.todoappreactspringboot.exceptions.ResourceNotFoundException;
import com.quetzalcoatl.todoappreactspringboot.model.TodoItem;
import com.quetzalcoatl.todoappreactspringboot.repository.TodoItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(TodoItemController.REST_URL)
public class TodoItemController {
    static final String REST_URL = "/rest/items";
    private final TodoItemRepository repository;

    public TodoItemController(TodoItemRepository repository) {
        this.repository = repository;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TodoItem> saveItem(@RequestBody TodoItem item){
        TodoItem created = repository.save(item);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @GetMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TodoItem>> getItems(){
        return ResponseEntity.ok(
                this.repository.findAll()
        );
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TodoItem> getItem(@PathVariable(value = "id" ) Integer id){
       TodoItem item = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Item with id=" + id + " not found")
        );
        return  ResponseEntity.ok().body(item);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TodoItem updateItem(@RequestBody TodoItem newItem, @PathVariable(value = "id") Integer id){
        return repository.findById(id)
                .map(item -> {
                    item.setLabel(newItem.getLabel());
                    item.setDescription(newItem.getDescription());
                    item.setPriority(newItem.getPriority());
                    item.setIsDone(newItem.getIsDone());
                    item.setIsOnControl(newItem.getIsOnControl());
                    return repository.save(item);
                })
                .orElseGet(()->{
                    newItem.setId(id);
                    return repository.save(newItem);
                });
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable(value = "id") Integer id){
        repository.deleteById(id);
    }
}
