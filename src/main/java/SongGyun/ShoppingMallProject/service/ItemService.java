package SongGyun.ShoppingMallProject.service;

import SongGyun.ShoppingMallProject.domain.Image;
import SongGyun.ShoppingMallProject.domain.Item;
import SongGyun.ShoppingMallProject.dto.ItemDto;
import SongGyun.ShoppingMallProject.dto.CreateItemDto;
import SongGyun.ShoppingMallProject.repository.ItemRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final ImageService imageService;

    //모든 아이템 조회
    public List<ItemDto> findAllItems(){
        log.info("ItemService : findAllItems");

        return itemRepository.findAll().
                stream().map(item -> item.toDto(item))
                .collect(Collectors.toList());
    }

    //상품 저장
    @Transactional
    public void createItem(MultipartFile[] multipartFiles , String stringItemDto) throws IOException {
        log.info("ItemService : createItem");
        Item item = new ObjectMapper().readValue(stringItemDto, CreateItemDto.class).toEntity();

        //이미지를 실제로 저장하고 이미지객체를 아이템과 연관시키기
        for (MultipartFile multipartFile : multipartFiles) {
            Image image = imageService.storeImage(multipartFile);
            item.setImage(image);
        }
        itemRepository.save(item);
    }



}
