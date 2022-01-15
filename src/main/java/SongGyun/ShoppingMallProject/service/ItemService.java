package SongGyun.ShoppingMallProject.service;

import SongGyun.ShoppingMallProject.domain.Item;
import SongGyun.ShoppingMallProject.dto.ItemDto;
import SongGyun.ShoppingMallProject.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    //모든 아이템 조회
    public List<ItemDto> findAllItems(){
        log.info("memberService : findAllItems");


        return itemRepository.findAll().
                stream().map(item -> item.toDto(item))
                .collect(Collectors.toList());
    }
}
