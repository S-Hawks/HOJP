package com.fia.backend;

import com.fia.backend.dto.ItemResources;
import com.fia.backend.dto.NewItemResource;
import com.fia.backend.dto.UpdateItemResource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping(MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Flux<ItemResources> getAllTodo(){
        return itemService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ItemResources> create(@Valid @RequestBody  NewItemResource newItemResource){
        return itemService.create(newItemResource);
    }

    @PutMapping(value = "/{id}")
    public Mono<ItemResources> update(@PathVariable @NotNull  String id, @Valid @RequestBody UpdateItemResource updateItemResource){
        return itemService.update(id, updateItemResource);
    }

}
