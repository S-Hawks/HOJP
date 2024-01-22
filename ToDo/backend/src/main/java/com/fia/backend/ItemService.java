package com.fia.backend;

import com.fia.backend.dto.ItemResources;
import com.fia.backend.dto.NewItemResource;
import com.fia.backend.dto.UpdateItemResource;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    private final ModelMapper modelMapper;

    public Flux<ItemResources> findAll() {
        Sort sort = Sort.by(Sort.Order.by("lastModifiedDate"));
        return itemRepository.findAll(sort).map(item -> modelMapper.map(item, ItemResources.class));
    }

    public Mono<ItemResources> create(NewItemResource newItemResource) {
        return Mono.just(newItemResource)
                .flatMap(resources -> {
                    Item itemToSave = modelMapper.map(newItemResource,Item.class);
                    return itemRepository.save(itemToSave).map(savedItem -> modelMapper.map(savedItem, ItemResources.class));
                });
    }

    public Mono<ItemResources> update(String id, UpdateItemResource updateItemResource) {
       return itemRepository.findById(id)
               .doOnNext(item -> {
                   System.out.println("Item from database: " + item);
               })
               .flatMap(item -> {
                   item.setDescription(updateItemResource.getDescription()).setStatus(updateItemResource.getStatus());
                   return itemRepository.save(item);
               }).map(updatedItem-> modelMapper.map(updatedItem, ItemResources.class));
    }
}
